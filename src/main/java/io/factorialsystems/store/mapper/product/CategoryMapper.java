package io.factorialsystems.store.mapper.product;

import io.factorialsystems.store.domain.product.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper {

    @Select("SELECT id, name, createdAt, lastModifiedAt, tenant_id from categories where tenant_id = #{tenantId}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    List<Category> findAll(String tenantId);

    @Select("SELECT id, name, createdAt, lastModifiedAt, tenant_id from categories where id = #{id} and tenant_id = #{tenantId}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    Category findById(Integer id, String tenantId);

    @Update("update categories set name = #{category.name}, lastModifiedAt = NOW() where id = #{categoryId} and tenant_id = #{tenantId}")
    Integer updateCategory(Integer categoryId, String tenantId, Category category);

    @Insert("insert into categories(name, tenant_id) values(#{name}, #{tenantId})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    Integer saveCategory(Category category);

    @Delete("delete from categories where id = #{id} and tenant_id = #{tenantId}")
    Integer deleteById(Integer id, String tenantId);
}
