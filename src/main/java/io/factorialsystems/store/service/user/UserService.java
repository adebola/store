package io.factorialsystems.store.service.user;

import io.factorialsystems.store.domain.tenant.Tenant;
import io.factorialsystems.store.domain.user.Role;
import io.factorialsystems.store.domain.user.RoleType;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.mapper.tenant.TenantMapper;
import io.factorialsystems.store.mapper.user.RoleMapper;
import io.factorialsystems.store.mapper.user.UserMapper;
import io.factorialsystems.store.payload.request.PasswordChangeRequest;
import io.factorialsystems.store.payload.request.PasswordChangeTokenRequest;
import io.factorialsystems.store.payload.request.PasswordResetRequest;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.task.TaskSendMail;
import io.factorialsystems.store.web.mapper.user.UserMSMapper;
import io.factorialsystems.store.web.model.user.AddressDto;
import io.factorialsystems.store.web.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserMSMapper userMapStructMapper;
    private final AddressService addressService;
    private final TaskSendMail taskSendMail;
    private final TaskExecutor taskExecutor;
    private final TenantMapper tenantMapper;
    private final RoleMapper roleMapper;

    private static final String activationMessage = "Dear esteemed Customer,\r\n" +
            "Welcome to the Delifrost Family. Your registered user account is now activated.\r\n" +
            "We are happy to be part of your business.\r\n" +
            "Please enjoy the Online shopping\r\n\r\n\r\n" +
            "Thank you.\r\n Regards,\r\nDelifrost Team";

    // Functions that will be Invoked through the Controller from the Outside

    public List<UserDto> findAll() {
        return userMapStructMapper.ListUserToUserDto(userMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public UserDto findById(Integer id) {
        return userMapStructMapper.UserToUserDto(userMapper.findById(id, TenantContext.getCurrentTenant()));
    }

    public String generatePasswordResetRequest(String emailAddress) {

        User user = userMapper.findByEmail(emailAddress, TenantContext.getCurrentTenant());

        if (user == null) {
            throw new RuntimeException("User / Email address does not exist on our database");
        }

        PasswordResetRequest request = new PasswordResetRequest(user.getId(), UUID.randomUUID());

        userMapper.createPasswordResetRequest(request);

        if (request == null || request.getId() == null) {
            throw new RuntimeException("Unable to create Password Reset Request");
        }

        Tenant tenant = tenantMapper.findById(TenantContext.getCurrentTenant());

        String messageBody = String.format("Please click on the link below to reset your password \n %s/auth/forgotpassword/%s", tenant.getBase_url(), request.getUuid());
        taskSendMail.setParameters(emailAddress, "Reset Password Request", messageBody, TenantContext.getCurrentTenant());
        taskExecutor.execute(taskSendMail);

        return request.getUuid();
    }

    public UserDto updateUser(Integer id, UserDto userDto) {

        if (userDto.getEmail() == null) {
            throw new RuntimeException("E-mail cannot be null");
        }

        if (userMapper.existsByEmailUser(id, userDto.getEmail(), TenantContext.getCurrentTenant())) {
            throw new RuntimeException("E-Mail already exists");
        }

        userMapper.updateUser(id, userMapStructMapper.UserDtoToUser(userDto), TenantContext.getCurrentTenant());
        return userMapStructMapper.UserToUserDto(userMapper.findById(id, TenantContext.getCurrentTenant()));
    }

    public void updateUserAdmin(Integer id, UserDto userDto) {

        if (userMapper.existsByEmailUser(id, userDto.getEmail(), TenantContext.getCurrentTenant())) {
            throw new RuntimeException("E-Mail Already Exists");
        }

        String userPassword = userDto.getPassword();

        User user = new User(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getFullName(),
                userDto.getTelephone(),
                userDto.getAddress(),
                userDto.getOrganization(),
                null);

        user.setActivated(userDto.getActivated());

        if (userPassword == null || userPassword.length() == 0) {
            userMapper.updateUserWithoutPassword(id, user, TenantContext.getCurrentTenant());
        } else {
            PasswordEncoder encoder = new BCryptPasswordEncoder();

            user.setPassword(encoder.encode(userPassword));
            userMapper.updateUserWithPassword(id, user, TenantContext.getCurrentTenant());
        }

        // Update User Address
        userMapper.updateDefaultAddress(id, userDto.getAddress());

        Set<String> strRoles = userDto.getRoles();
        saveRoles(id, strRoles);
    }

    private boolean saveRoles(int id, Set<String> roles) {

        // Get Existing Roles Form Database
        List<Role> existingRoles = userMapper.selectUserRoles(id);

        if (roles == null || roles.isEmpty()) {
            for (Role role: existingRoles) {

                if (!role.getRoleType().name().equals("ROLE_USER")) {
                    userMapper.removeRole(id, role.getRoleType().ordinal() + 1, TenantContext.getCurrentTenant());
                }
            }

            return true;
        }

        for (String role: roles) {
            Role rl = existingRoles.stream()
                    .filter(r -> r.getRoleType().name().equals(role))
                    .findAny()
                    .orElse(null);

            if (rl == null) {
                log.info(String.format("Ordinal for %s is %d", role, RoleType.valueOf(role).ordinal()));
                userMapper.addRole(id, RoleType.valueOf(role).ordinal() + 1, TenantContext.getCurrentTenant());
            }
        }

        for (Role role: existingRoles) {
           String sr = roles.stream()
                   .filter(s -> role.getRoleType().name().equals(s))
                   .findAny()
                   .orElse(null);

           if (sr == null && role.getRoleType() != RoleType.ROLE_USER) {
               userMapper.removeRole(id, role.getRoleType().ordinal() + 1, TenantContext.getCurrentTenant());
           }
        }

        return true;
    }

    public void SaveUserAdmin(UserDto userDto) {

        if (userMapper.existsByEmail(userDto.getEmail(), TenantContext.getCurrentTenant())) {
            throw new RuntimeException("User E-mail exists on the system, Please choose another ");
        }

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // Save the User
        User user = new User(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getFullName(),
                userDto.getTelephone(),
                userDto.getAddress(),
                userDto.getOrganization(),
                encoder.encode(userDto.getPassword()));

        user.setActivated(userDto.getActivated());

        List<Role> roles = new ArrayList<>();
        Role userRole = roleMapper.findRoleByType (RoleType.ROLE_USER, TenantContext.getCurrentTenant());
        roles.add(userRole);

        Set<String> strRoles = userDto.getRoles();

        if (strRoles != null && !strRoles.isEmpty()) {
            for (String strRole : strRoles) {
                Role tempRole = roleMapper.findRoleByType(RoleType.valueOf(strRole), TenantContext.getCurrentTenant());
                roles.add(tempRole);
            }
        }

        user.setRoles(roles);
        saveUser(user);
    }

    public Boolean changeUsername(Integer userId, String username) {

        // Check that Request is made by logged in User
        String currentUser = TenantContext.getCurrentUser();
        String tenant = TenantContext.getCurrentTenant();

        User user = userMapper.findById(userId, tenant);

        if (user == null) {
            // We really should not be here, means logged in User not found in database
            log.error(String.format("Error in UserService::changeUsername, User %d not found with tenantId %s", userId, tenant));
            return false;
        }

        if (user.getUsername().equals(currentUser)) {
            if (!userMapper.existsByUsername(username, TenantContext.getCurrentTenant())) {
                userMapper.changeUsername(userId, username, TenantContext.getCurrentTenant());

                return true;
            }
        }

        return false;
    }

    public Boolean changeEmail(Integer userId, String email) {

        // Check that Request is made by logged in User
        String username = TenantContext.getCurrentUser();
        String tenant = TenantContext.getCurrentTenant();

        User user = userMapper.findById(userId, tenant);

        if (user == null) {
            // We really should not be here, means logged in User not found in database
            log.error(String.format("Error in UserService::changeEmail, User %d not found with tenantId %s", userId, tenant));
            return false;
        }

        // This Operation is restricted to the Account Owner ONLY
        if (user.getUsername().equals(username)) {
            if (!userMapper.existsByEmail(email, TenantContext.getCurrentTenant())) {
                userMapper.changeEmail(userId, email, TenantContext.getCurrentTenant());

                return true;
            }
        }

        return false;
    }

    public Boolean changeTokenPassword(PasswordChangeTokenRequest request) {

        User user = userMapper.findUserByResetToken(request.getToken(), TenantContext.getCurrentTenant());

        if (user == null) {
            throw new RuntimeException("Unable to Find Password Reset Request, you might have used it ot it expired");
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        userMapper.changePassword(user.getId(), encodedPassword, TenantContext.getCurrentTenant());
        userMapper.closeRequestToken(request.getToken());

        return true;
    }

    public Boolean changePassword(Integer userId, PasswordChangeRequest passwordChangeRequest) {

        // Check that Request is made by logged in User
        String username = TenantContext.getCurrentUser();
        String tenant = TenantContext.getCurrentTenant();

        User user = userMapper.findById(userId, tenant);

        if (user == null) {
            // We really should not be here, means logged in User not found in database
            log.error(String.format("Error in UserService::changePassword, User %d not found with tenantId %s", userId, tenant));

            throw new RuntimeException("Password change Request User Not Found");
        }

        if (!user.getUsername().equals(username)) {
            throw new RuntimeException("Password change failed, you must be the account owner to change your password");
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (!passwordEncoder.matches(passwordChangeRequest.getCurrentpassword(), user.getPassword())) {
            throw new RuntimeException("Password change failed, the password you supplied is not correct");
        }

        String encodedPassword = passwordEncoder.encode(passwordChangeRequest.getNewPassword());
        userMapper.changePassword(userId, encodedPassword, TenantContext.getCurrentTenant());

        return true;

    }

    // Functions that are called from within and not returning data directly to the Outside

    public Boolean existsByUsername(String username) {
        return userMapper.existsByUsername(username, TenantContext.getCurrentTenant());
    }

    public Boolean existsByEmail(String email) {
        return userMapper.existsByEmail(email, TenantContext.getCurrentTenant());
    }

    public UserDto findUserByResetToken(String token) {
        return userMapStructMapper.UserToUserDto(userMapper.findUserByResetToken(token, TenantContext.getCurrentTenant()));
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username, TenantContext.getCurrentTenant());
    }

    public boolean sendUserActivationMessage(Integer userId) {

        User user = userMapper.findById(userId, TenantContext.getCurrentTenant());

        if (user != null) {
            taskSendMail.setParameters(user.getEmail(), "Delifrost Activation", activationMessage, TenantContext.getCurrentTenant());
            taskExecutor.execute(taskSendMail);

            return true;
        }

        return false;
    }

    // Save User is not exposed to the outside world, for now only used by the Auth Framework
    // so will still return user
    public User saveUser(User user) {

        String tenantId = TenantContext.getCurrentTenant();

        if (tenantId != null) {
            user.setTenantId(tenantId);
            userMapper.createUser(user);

            Integer userId = user.getId();
            log.info(String.format("User Created with UserId %d", userId));

            if (userId != null && userId > 0 && user.getRoles().size() > 0) {

                // Insert User Roles
                userMapper.insertRoleList(userId, user.getRoles());

                // Create Address Object and Save In database
                AddressDto addressDto = AddressDto.builder()
                        .address(user.getAddress())
                        .user_id(userId)
                        .is_default(true)
                        .build();

                AddressDto newAddress = addressService.saveUserAddress(addressDto);

                if (newAddress == null || newAddress.getId() == 0) {

                    String message = String.format("Unable to Save User Address for Newly Created User %s", user.getFullName());
                    log.error(message);
                    throw new RuntimeException(message);
                }
            }

            return user;
        } else {
            String message = "Error Saving User No Organization Specified";
            log.error(message);
            throw new RuntimeException(message);
        }
    }
}
