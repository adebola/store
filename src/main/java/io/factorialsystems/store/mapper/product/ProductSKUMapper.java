package io.factorialsystems.store.mapper.product;

import io.factorialsystems.store.domain.product.ProductSKU;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductSKUMapper {

    String SelectSQLAll = "select sku.id as sku,\n" +
            "       p.id as productId,\n" +
            "       i.imagepath as imagepath,\n" +
            "       sku.price,\n" +
            "       p.name,\n" +
            "       p.description,\n" +
            "       p.brand,\n" +
            "       p.new,\n" +
            "       p.sale,\n" +
            "       pv.name as variant,\n" +
            "       pvo.name as variant_options\n" +
            "from\n" +
            "     products p, product_variants pv, product_variant_options pvo, sku_products sku, sku_product_variant_options spvo, images i,product_images pi\n" +
            "where\n" +
            "     spvo.product_variant_option_id = pvo.id and\n" +
            "     pvo.product_variant_id = pv.id and\n" +
            "     sku.id = spvo.sku_id and\n" +
            "     p.id = sku.product_id and\n" +
            "     p.id = pi.product_id and\n" +
            "     pi.image_id = i.id and\n" +
            "     sku.discontinued = FALSE and\n" +
            "     p.discontinued = FALSE and\n" +
            "     p.tenant_id = #{tenantId}\n" +
            "order by sku.id;";

    String SelectSQL1 = "select sku.id as sku,\n" +
            "       p.id as productId,\n" +
            "       i.imagepath as imagepath,\n" +
            "       sku.price,\n" +
            "       p.name,\n" +
            "       p.description,\n" +
            "       p.brand,\n" +
            "       p.new,\n" +
            "       p.sale,\n" +
            "       pv.name as variant,\n" +
            "       pvo.name as variant_options\n" +
            "from\n" +
            "     products p, product_variants pv, product_variant_options pvo, sku_products sku, sku_product_variant_options spvo, images i,product_images pi\n" +
            "where\n" +
            "     spvo.product_variant_option_id = pvo.id and\n" +
            "     pvo.product_variant_id = pv.id and\n" +
            "     sku.id = spvo.sku_id and\n" +
            "     p.id = sku.product_id and\n" +
            "     p.id = pi.product_id and\n" +
            "     pi.image_id = i.id and\n" +
            "     p.id = #{id} and\n" +
            "     p.tenant_id = #{tenantId} and\n" +
            "     sku.discontinued = FALSE and\n" +
            "     p.discontinued = FALSE\n" +
            "order by sku.id;";

    @Select(SelectSQLAll)
    @Results(value = {
            @Result(property = "sku", column = "sku"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "price", column = "price"),
            @Result(property = "name", column = "name"),
            @Result(property = "imagePath", column = "imagePath"),
            @Result(property = "description", column = "description"),
            @Result(property = "isNew", column = "new"),
            @Result(property = "onSale", column = "sale"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "variant", column = "variant"),
            @Result(property = "variant_options", column = "variant_options")

    })
    public List<ProductSKU> findAll(String tenantId);


    @Select(SelectSQL1)
    @Results(value = {
            @Result(property = "sku", column = "sku"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "price", column = "price"),
            @Result(property = "name", column = "name"),
            @Result(property = "imagePath", column = "imagePath"),
            @Result(property = "description", column = "description"),
            @Result(property = "isNew", column = "new"),
            @Result(property = "onSale", column = "sale"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "variant", column = "variant"),
            @Result(property = "variant_options", column = "variant_options")
    })
    public List<ProductSKU> findByProductId(Integer id, String tenantId);
}
