package io.factorialsystems.store.service.user;

import io.factorialsystems.store.domain.user.Address;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.mapper.user.AddressMapper;
import io.factorialsystems.store.mapper.user.UserMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.mapper.user.AddressMSMapper;
import io.factorialsystems.store.web.mapper.user.UserMSMapper;
import io.factorialsystems.store.web.model.user.AddressDto;
import io.factorialsystems.store.web.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserMSMapper userMapStructMapper;
    private final AddressMapper addressMapper;
    private final AddressMSMapper addressMapStructMapper;

    // Functions that will be Invoked through the Controller from the Outside

    public List<UserDto> findAll() {
        return userMapStructMapper.ListUserToUserDto(userMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public UserDto findById(Integer id) {
        return userMapStructMapper.UserToUserDto(userMapper.findById(id, TenantContext.getCurrentTenant()));
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

    public Boolean changePassword(Integer userId, String password) {

        // Check that Request is made by logged in User
        String username = TenantContext.getCurrentUser();
        String tenant = TenantContext.getCurrentTenant();

        User user = userMapper.findById(userId, tenant);

        if (user == null) {
            // We really should not be here, means logged in User not found in database
            log.error(String.format("Error in UserService::changePassword, User %d not found with tenantId %s", userId, tenant));
            return false;
        }

        if (user.getUsername().equals(username)) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            userMapper.changePassword(userId, encodedPassword, TenantContext.getCurrentTenant());

            return true;
        }

        return false;
    }

    // Functions that are called from within and not returning data directly to the Outside

    public Boolean existsByUsername(String username) {
        return userMapper.existsByUsername(username, TenantContext.getCurrentTenant());
    }

    public Boolean existsByEmail(String email) {
        return userMapper.existsByEmail(email, TenantContext.getCurrentTenant());
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username, TenantContext.getCurrentTenant());
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

                AddressDto newAddress = saveUserAddress(addressDto);

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

    public AddressDto saveUserAddress(AddressDto addressDto) {

        Address address = addressMapStructMapper.AddressDtoToAddress(addressDto);
        addressMapper.saveUserAddress(address);

        if (address != null && address.getId() > 0) {
            return addressMapStructMapper.AddressToAddressDto(address);
        }

        String message = "Error Saving Address";
        log.error(message);
        throw new RuntimeException(message);
    }

    public List<AddressDto> getUserAddresses(Integer userId) {

        return addressMapStructMapper.ListAddressToAddressDto(addressMapper.getUserAddresses(userId));
    }

    public AddressDto getUserDefaultAddress(Integer userId) {
        return addressMapStructMapper.AddressToAddressDto(addressMapper.getUserDefaultAddress(userId));
    }
}
