package io.factorialsystems.store.mapper.product;

import io.factorialsystems.store.domain.product.ProductVariant;
import io.factorialsystems.store.domain.product.ProductVariantOption;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductVariantMapper {
    @Select("select id, name, tenant_id, product_id, lastModifiedAt, createdAt from product_variants where tenant_id = #{tenantId}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "variantOptions", column = "id", javaType = List.class, many=@Many(select="selectProductVariantOptions"))
    })
    public List<ProductVariant> findAll(String tenantId);

    @Select("select id, name, tenant_id, product_id, lastModifiedAt, createdAt from product_variants where tenant_id = #{tenantId} and id = #{id}")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "createdDate", column = "createdAt"),
            @Result(property = "lastModifiedDate", column = "lastModifiedAt"),
            @Result(property = "tenantId", column = "tenant_id"),
            @Result(property = "variantOptions", column = "id", javaType = List.class, many=@Many(select="selectProductVariantOptions"))
    })
    public ProductVariant findById(Integer id, String tenantId);

    @Update("update product_variants set name = #{productVariant.name}, lastModifiedAt = NOW() where id = #{id} and tenant_id = #{productVariant.tenantId}")
    public Integer updateProductVariant(Integer id, ProductVariant productVariant);

    @Insert("insert into product_variants(name, product_id, tenant_id) values(#{name}, #{productId}, #{tenantId})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveProductVariant(ProductVariant productVariant);

    @Delete("delete from product_variants where id = #{id} and tenant_id = #{tenantId}")
    public Integer deleteById(Integer id, String tenantId);

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
