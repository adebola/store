package io.factorialsystems.store.web.mapper.user;

import io.factorialsystems.store.domain.user.Role;
import io.factorialsystems.store.service.user.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMSMapper {
    private final RoleService roleService;

    public String asString(Role role) {
        if (role != null) {
            return role.getRoleType().name();
        } else {
            return null;
        }
    }

    // Typically this side will not be called, but just should in case
    public Role asRole(String strRole) {
        if (strRole != null) {
            return roleService.findRoleByName(strRole);
        } else {
            return null;
        }
    }
}
