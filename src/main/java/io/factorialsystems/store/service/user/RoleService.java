package io.factorialsystems.store.service.user;

import io.factorialsystems.store.domain.user.Role;
import io.factorialsystems.store.domain.user.RoleType;
import io.factorialsystems.store.mapper.user.RoleMapper;
import io.factorialsystems.store.security.TenantContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final RoleMapper roleMapper;

    public List<Role> findAll() {
        return roleMapper.findAll(TenantContext.getCurrentTenant());
    }

    public Role findRoleByType(RoleType roleType) {
        return roleMapper.findRoleByType(roleType, TenantContext.getCurrentTenant());
    }

    public Role findRoleByName(String roleType) {
        return roleMapper.findRoleByName(roleType, TenantContext.getCurrentTenant());
    }
}
