package io.factorialsystems.store.mapper.user;

import io.factorialsystems.store.domain.user.Role;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.payload.request.PasswordResetRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    final String SELECT_ROLES = "select r.id, r.name, r.tenant_id from roles r, user_roles ur, users u " +
            "where r.id = ur.role_id and u.id = ur.user_id and u.id = #{userId}";

    final String SELECT_USER = "SELECT u.id, u.username, u.email, u.fullname, u.telephone, a.address, u.tenant_id " +
            "from users u, address a where u.tenant_id = #{tenantId} and a.user_id = u.id and a.is_default = true";

    final String SELECT_USER_ID = "SELECT u.id, u.username, u.email, u.fullname, u.telephone, u.organization, u.password, a.address, u.tenant_id " +
            "from users u, address a where u.id = #{id} and u.tenant_id = #{tenantId} and a.user_id = u.id and a.is_default = true";

    final String SELECT_USER_NAME = "SELECT u.id, u.username, u.email, u.password, u.fullname, u.telephone, u.activated, u.organization, a.address, u.tenant_id " +
            "from users u, address a where u.username = #{username} and u.tenant_id = #{tenantId} and a.user_id = u.id and a.is_default = true";

    final String SELECT_USER_EMAIL = "SELECT u.id, u.username, u.email, u.password, u.fullname, u.telephone, a.address, u.tenant_id " +
            "from users u, address a where u.email = #{email} and u.tenant_id = #{tenantId} and a.user_id = u.id and a.is_default = true";

    final String SELECT_USER_TOKEN = "SELECT u.id, u.username, u.email, u.password, u.fullname, u.telephone, u.tenant_id " +
            "from users u, password_reset_request pr where pr.uuid = #{token} and pr.lastModifiedAt is NULL and pr.user_id = u.id and u.tenant_id = #{tenantId}";

    @Select(SELECT_USER)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "fullName", column = "fullname"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "address", column = "address"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "selectUserRoles"))
    })
    List<User> findAll(String tenantId);

    @Select(SELECT_USER_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "fullName", column = "fullname"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "address", column = "address"),
            @Result(property = "password", column = "password"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "selectUserRoles"))
    })
    User findById(Integer id, String tenantId);

    @Select(SELECT_USER_NAME)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "fullName", column = "fullname"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "address", column = "address"),
            @Result(property = "activated", column = "activated"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "selectUserRoles"))
    })
    User findByUsername(String username, String tenantId);

    @Select(SELECT_USER_EMAIL)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "fullName", column = "fullname"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "address", column = "address"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "selectUserRoles"))
    })
    User findByEmail(String email, String tenantId);

    @Select(SELECT_ROLES)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "roleType", column = "name"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    List<Role> selectUserRoles(Integer userId);

   @Select(SELECT_USER_TOKEN)
   @Results(value = {
           @Result(property = "id", column = "id"),
           @Result(property = "username", column = "username"),
           @Result(property = "email", column = "email"),
           @Result(property = "password", column = "password"),
           @Result(property = "fullName", column = "fullname"),
           @Result(property = "telephone", column = "telephone"),
           @Result(property = "tenantId", column = "tenant_id"),
           @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "selectUserRoles"))
   })
   User findUserByResetToken(String token, String tenantId);

    @Select("Select Exists(Select 1 from users where username = #{username} and tenant_id = #{tenantId})")
    Boolean existsByUsername(String username, String tenantId);

    @Select("Select Exists(Select 1 from users where email = #{email} and tenant_id = #{tenantId})")
    Boolean existsByEmail(String email, String tenantId);

    @Select("Select Exists(Select 1 from users where email = #{email} and id != #{id} and tenant_id = #{tenantId})")
    Boolean existsByEmailUser(Integer id, String email, String tenantId);

    @Insert("insert into users(username, email, password, fullname, telephone, organization, tenant_id) values(#{username}, #{email}, #{password}, #{fullName}, #{telephone}, #{organization}, #{tenantId})")
    //@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    Integer createUser(User user);

    @Insert("insert into password_reset_request(uuid, user_id) values (#{uuid}, #{userId})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    Integer createPasswordResetRequest(PasswordResetRequest request);

    @Update("update users set username = #{user.username}, email = #{user.email}, fullname = #{user.fullName}, organization = #{user.organization}, telephone = #{user.telephone}, lastModifiedAt = NOW() where id = #{id} and tenant_id = #{tenantId}")
    Integer updateUser(Integer id, User user, String tenantId);

    @Update("update users set username = #{username}, lastModifiedAt = NOW() where id = #{userId} and tenant_id = #{tenantId}")
    Integer changeUsername(Integer userId, String username, String tenantId);

    @Update("update users set email = #{email}, lastModifiedAt = NOW() where id = #{userId} and tenant_id = #{tenantId}")
    Integer changeEmail(Integer userId, String email, String tenantId);

    @Update("update users set password = #{password}, lastModifiedAt = NOW() where id = #{userId} and tenant_id = #{tenantId}")
    Integer changePassword(Integer userId, String password, String tenantId);

    @Update("update password_reset_request set lastModifiedAt = NOW() where uuid = #{token}")
    Integer closeRequestToken(String token);

    @Insert("insert into user_roles(user_id, role_id) values(#{id}, #{roleId})")
    Integer addRole(Integer id, Integer roleId, String tenantId);

    @Delete("delete from user_roles where user_id = #{id} and role_id = #{role_id}")
    Integer removeRole(Integer id, Integer roleId, String tenantId);


    @Insert({"<script>",
            "insert into user_roles(user_id, role_id) values ",
            "<foreach collection = 'roleList' item = 'role' open = '(' separator = '),(' close = ')' > #{userId}, #{role.id}</foreach>",
            "</script>"})
    Integer insertRoleList(Integer userId, List<Role> roleList);
}
