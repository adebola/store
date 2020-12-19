package io.factorialsystems.store.web.controller.auth;

import io.factorialsystems.store.domain.user.Role;
import io.factorialsystems.store.domain.user.RoleType;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.payload.request.LoginRequest;
import io.factorialsystems.store.payload.request.SignupRequest;
import io.factorialsystems.store.payload.response.JwtResponse;
import io.factorialsystems.store.payload.response.SignupResponse;
import io.factorialsystems.store.security.JwtUtils;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.service.auth.CaptchaService;
import io.factorialsystems.store.service.user.RoleService;
import io.factorialsystems.store.service.user.UserDetailsImpl;
import io.factorialsystems.store.service.user.UserService;
import io.factorialsystems.store.task.TaskSendMail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final TaskSendMail taskSendMail;
    private final TaskExecutor taskExecutor;
    private final CaptchaService captchaService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

//        User user = userService.findByUsername(loginRequest.getUsername());
//
//        if (!user.isActivated()) {
//            JwtResponse response = JwtResponse.builder()
//                    .status(400)
//                    .message("User has not been activated please contact DELIFROST")
//                    .build();
//
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }

        if (!captchaService.verify(loginRequest.getCaptchaResponse())) {
            JwtResponse response = JwtResponse.builder()
                    .status(400)
                    .message("Invalid Captcha")
                    .build();

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        Roles Not needed for Now
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());

        JwtResponse response =  JwtResponse.builder()
                .status(200)
                .message("Success")
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .fullName(userDetails.getFullName())
                .telephone(userDetails.getTelephone())
                .address(userDetails.getAddress())
                .organization(userDetails.getOrganization())
                .token(jwt)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

        if (!captchaService.verify(signupRequest.getCaptchaResponse())) {
            SignupResponse response = SignupResponse.builder()
                    .status(400)
                    .message("Invalid Captcha")
                    .build();

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByUsername(signupRequest.getUsername())) {
            SignupResponse response = SignupResponse.builder()
                    .status(400)
                    .message("User Name Already Taken Please try again")
                    .build();

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByEmail(signupRequest.getEmail())) {
            SignupResponse response = SignupResponse.builder()
                    .status(400)
                    .message("E-Mail already in use please try again")
                    .build();

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                signupRequest.getFullName(),
                signupRequest.getTelephone(),
                signupRequest.getAddress(),
                signupRequest.getOrganization(),
                encoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        List<Role> roles = new ArrayList<>();

        if (strRoles == null) {
            Role userRole = roleService.findRoleByType (RoleType.ROLE_USER);

            if (userRole == null) {
                throw new RuntimeException("Error Role USER is not Found!!!");
            }

            roles.add(userRole);
            log.info("No Role Specified, Added User Role");
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findRoleByType(RoleType.ROLE_ADMIN);

                        if (adminRole == null) {
                            throw new RuntimeException("Error Role ADMIN Not Found");
                        }

                        roles.add(adminRole);
                        log.info("Added Admin Role");
                        break;

                    case "mod":
                        Role modRole = roleService.findRoleByType(RoleType.ROLE_MODERATOR);

                        if (modRole == null) {
                            throw new RuntimeException("Error Role MODERATOR Not Found");
                        }

                        roles.add(modRole);
                        log.info("Added Moderator Role");
                        break;

                    case "user":
                        Role userRole = roleService.findRoleByType (RoleType.ROLE_USER);

                        if (userRole == null) {
                            throw new RuntimeException("Error Role USER is not Found!!!");
                        }

                        roles.add(userRole);
                        log.info("Added User Role");
                        break;

                    default:
                        String errorMessage = String.format("Unknown Role Encountered : %s", role);
                        log.error(errorMessage);
                        throw new RuntimeException(errorMessage);
                }
            });
        }

        user.setRoles(roles);
        User newUser = userService.saveUser(user);

        if (newUser != null && newUser.getId() > 0) {
            // Send Activation E-Mail
            taskSendMail.setParameters(newUser.getEmail(), TenantContext.getCurrentTenant());
            taskExecutor.execute(taskSendMail);

            log.info(String.format("User Created Successfully with Id %d and Username %s", newUser.getId(), newUser.getUsername()));

            SignupResponse response = SignupResponse.builder()
                    .status(200)
                    .message("User Registered Successfully")
                    .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            String message = "Unable to Create New User";
            log.error(message);
            throw new RuntimeException(message);
        }
    }
}
