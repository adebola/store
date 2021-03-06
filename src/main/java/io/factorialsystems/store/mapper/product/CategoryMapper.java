package io.factorialsystems.store.mapper.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.payload.response.IntegerResponse;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper {

    @Select("SELECT id, name, image_url, createdAt, lastModifiedAt, parent_category_id, tenant_id from categories where parent_category_id is null and tenant_id = #{tenantId}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "image_url", column = "image_url"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "subCategories", column = "id", javaType = List.class, many=@Many(select="findSubCategoriesById")),
    })
    List<Category> findAll(String tenantId);

    @Select("SELECT id, name, image_url, createdAt, lastModifiedAt, parent_category_id, tenant_id from categories where id = #{id} and tenant_id = #{tenantId}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "image_url", column = "image_url"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "subCategories", column = "id", javaType = List.class, many=@Many(select="findSubCategoriesById"))
    })
    Category findById(Integer id, String tenantId);

    @Select("SELECT id, name, image_url, createdAt, lastModifiedAt, parent_category_id, tenant_id from categories where parent_category_id is null and id != #{id} and id not in (select parent_category_id from categories where parent_category_id is not null and tenant_id = #{tenantId}) and tenant_id = #{tenantId}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "image_url", column = "image_url"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "subCategories", column = "id", javaType = List.class, many=@Many(select="findSubCategoriesById"))
    })
    List<Category> findAvailableCategoriesforSubCategorization(Integer id, String tenantId);

    @Select("SELECT id, name, image_url, createdAt, lastModifiedAt, parent_category_id, tenant_id from categories where tenant_id = #{tenantId} and id not in (select parent_category_id from categories where parent_category_id is not null and tenant_id = #{tenantId})")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "image_url", column = "image_url"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "subCategories", column = "id", javaType = List.class, many=@Many(select="findSubCategoriesById"))
    })
    List<Category> findAssignableCategories(String tenantId);

    @Select("SELECT id, name, image_url, createdAt, lastModifiedAt, tenant_id from categories where parent_category_id = #{id}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "image_url", column = "image_url"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    List<Category> findSubCategoriesById(Integer id);

    @Update("update categories set name = #{category.name}, image_url = #{category.image_url}, lastModifiedAt = NOW() where id = #{categoryId} and tenant_id = #{tenantId}")
    Integer updateCategory(Integer categoryId, String tenantId, Category category);

    @Insert("insert into categories(name, image_url, tenant_id) values(#{name}, #{image_url}, #{tenantId})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    Integer saveCategory(Category category);

    @Delete("delete from categories where id = #{id} and tenant_id = #{tenantId}")
    Integer deleteById(Integer id, String tenantId);

    @Update("update categories set parent_category_id = null where id = #{id} and tenant_id = #{tenantId}")
    Integer removeSubCategory(Integer id, String tenantId);

    @Update("update categories set parent_category_id = #{newId} where id = #{id} and tenant_id = #{tenantId}")
    Integer addSubCategory(Integer id, Integer newId, String tenantId);

    @Select("select count(*) as count from products where category_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "count")
    })
    IntegerResponse getProductCount(Integer id);
}
