package io.factorialsystems.store.mapper.user;

import io.factorialsystems.store.domain.user.Address;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AddressMapper {
    final String insertSQL = "insert into address (user_id, address, is_default) values(#{user_id}, #{address}, #{is_default})";
    final String selectUSER_ADDRESS = "select id, user_id, address, is_default from address where user_id = #{user_id}";
    final String selectDEFAULT_ADDRESS = "select id, user_id, address, is_default from address where user_id = #{user_id} and is_default = true";

    @Select(selectDEFAULT_ADDRESS)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "address", column = "address"),
            @Result(property = "is_default", column = "is_default"),
    })
    public Address getUserDefaultAddress(Integer userId);

    @Select(selectUSER_ADDRESS)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "address", column = "address"),
            @Result(property = "is_default", column = "is_default"),
    })
    public List<Address> getUserAddresses(Integer userId);

    @Insert(insertSQL)
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveUserAddress(Address address);

    @Update("update address set address.address = #{address.address} where id = #{addressId}")
    Integer updateUserAddress(Integer addressId, Address address);

    @Delete("delete from address where id = #{id}")
    public void deleteAddress(Integer id);

}
