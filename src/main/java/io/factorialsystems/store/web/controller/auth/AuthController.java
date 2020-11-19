package io.factorialsystems.store.web.controller.auth;

import io.factorialsystems.store.domain.user.Role;
import io.factorialsystems.store.domain.user.RoleType;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.payload.request.LoginRequest;
import io.factorialsystems.store.payload.request.SignupRequest;
import io.factorialsystems.store.payload.response.JwtResponse;
import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.security.JwtUtils;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.service.user.RoleService;
import io.factorialsystems.store.service.user.UserDetailsImpl;
import io.factorialsystems.store.service.user.UserService;
import io.factorialsystems.store.task.TaskSendMail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;
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

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        
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
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .fullName(userDetails.getFullName())
                .telephone(userDetails.getTelephone())
                .address(userDetails.getAddress())
                .token(jwt)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

        if (userService.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error E-mail is already in use!"));
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                signupRequest.getFullName(),
                signupRequest.getTelephone(),
                signupRequest.getAddress(),
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
            return ResponseEntity.ok(new MessageResponse("User Registered Successfully"));
        } else {
            String message = "Unable to Create New User";
            log.error(message);
            throw new RuntimeException(message);
        }
    }
}
