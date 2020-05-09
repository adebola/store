package io.factorialsystems.store.mapper.product;

import io.factorialsystems.store.domain.product.ProductVariantOption;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductVariantOptionMapper {

    @Select("select id, name, tenant_id, product_variant_id, lastModifiedAt, createdAt from product_variant_options where tenant_id = #{tenantId}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "productVariantId", column = "product_variant_id"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    public List<ProductVariantOption> findAll(String tenantId);

    @Select("select id, name, tenant_id, product_variant_id, lastModifiedAt, createdAt from product_variant_options where tenant_id = #{tenantId} and id = #{id}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "productVariantId", column = "product_variant_id"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id")
    })
    public ProductVariantOption findById(Integer id, String tenantId);

    @Update("update product_variant_options set name = #{productVariantOption.name}, lastModifiedAt = NOW() where id = #{id} and tenant_id = #{productVariantOption.tenantId}")
    public Integer updateProductVariantOption(Integer id, ProductVariantOption productVariantOption);

    @Insert("insert into product_variant_options(name, product_variant_id, tenant_id) values(#{name}, #{productVariantId}, #{tenantId})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveProductVariantOption(ProductVariantOption productVariantOption);

    @Delete("delete from product_variant_options where id = #{id} and tenant_id = #{tenantId}")
    public Integer deleteById(Integer id, String tenantId);
}
