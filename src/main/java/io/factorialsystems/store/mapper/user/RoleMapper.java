package io.factorialsystems.store.mapper.user;

import io.factorialsystems.store.domain.user.Role;
import io.factorialsystems.store.domain.user.RoleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMapper {

    @Select("select id, name, tenant_id from roles where tenant_id = #{tenantId}")
    @Results( value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "roleType"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    List<Role> findAll(String tenantId);

    @Select("select id, name, tenant_id from roles where name = #{type} and tenant_id = #{tenantId}")
    @Results( value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "roleType"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    Role findRoleByType(RoleType type, String tenantId);

    @Select("select id, name, tenant_id from roles where name = #{roleType} and tenant_id = #{tenantId}")
    @Results( value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "roleType"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    Role findRoleByName(String roleType, String tenantId);
}
