package io.factorialsystems.store.mapper.user;

import io.factorialsystems.store.domain.user.Activation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ActivationMapper {

    final String insertSQL = "insert into user_activation(id, user_id) values (uuid(), #{userId})";
    final String selectSQL = "select id, user_id, createdAt, closedAt from user_activation where id = #{activationId}";
    final String updateSQL = "update user set activated = true where id in (select user_id from user_activation where id = #{activationId})";

    @Insert(insertSQL)
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = String.class)
    public void saveUserActivation(Integer userId);

    @Select(selectSQL)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "createdAt", column = "createdAt"),
            @Result(property = "closedAt", column = "closedAt"),
    })
    public Activation findActivationById(String activationId);

    @Update(updateSQL)
    public void ActivateUser(String activationId);
}
