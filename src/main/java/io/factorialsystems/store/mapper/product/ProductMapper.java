package io.factorialsystems.store.mapper.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.domain.product.Product;
import io.factorialsystems.store.domain.product.ProductVariant;
import io.factorialsystems.store.domain.product.ProductVariantOption;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductMapper {

    @Select("select id, name, category_id, tenant_id, lastModifiedAt, createdAt from products where tenant_id = #{tenantId}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class, one=@One(select="findCategoryById")),
            @Result(property = "variants", column = "id", javaType = List.class, many=@Many(select="selectProductVariants"))
    })
    public List<Product> findAll(String tenantId);

    @Select("select id, name, category_id, tenant_id, lastModifiedAt, createdAt from products where tenant_id = #{tenantId} and id = #{id}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class, one=@One(select="findCategoryById")),
            @Result(property = "variants", column = "id", javaType = List.class, many=@Many(select="selectProductVariants"))
    })
    public Product findById(Integer id, String tenantId);

    @Update("update products set name = #{product.name}, category_id = #{product.category.id}, lastModifiedAt = NOW() where id = #{id} and tenant_id = #{product.tenantId}")
    public Integer updateProduct(Integer id, Product product);

    @Insert("insert into products(name, category_id, tenant_id) values(#{name}, #{category.id}, #{tenantId})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveProduct(Product product);

    @Delete("delete from products where id = #{id} and tenant_id = #{tenantId}")
    public Integer deleteById(Integer id, String tenantId);

    @Select("select id, name, tenant_id, createdAt, lastModifiedAt from categories where id = #{id}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    public Category findCategoryById(Integer id);


    @Select("select id, name, tenant_id, createdAt, lastModifiedAt, product_id from product_variants where product_id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "variantOptions", column = "id", javaType = List.class, many=@Many(select="selectProductVariantOptions"))
    })
    public List<ProductVariant> selectProductVariants(Integer id);

    @Select("select id, name, tenant_id, product_variant_id, lastModifiedAt, createdAt from product_variant_options where product_variant_id = #{id}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "productVariantId", column = "product_variant_id"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    public List<ProductVariantOption> selectProductVariantOptions(Integer id);
}
