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

    final String SelectSQLAll = "select sku.id,\n" +
    "            sku.sku,\n" +
    "            p.id as productId,\n" +
    "            sku.price,\n" +
    "            sku.discount,\n" +
    "            sku.sku_description as description,\n" +
    "            sku.new,\n" +
    "            sku.sale,\n" +
    "            p.name,\n" +
    "            p.brand,\n" +
    "            c.name as category,\n" +
    "            pv.name as variant,\n" +
    "            pvo.name as variant_option,\n" +
    "            i.imagepath\n" +
    "from\n" +
    "            products p, product_variants pv, product_variant_options pvo, categories c, sku_products sku, sku_product_variant_options spvo, images i, sku_images si\n" +
    "where\n" +
    "            p.tenant_id = #{tenantId} and\n" +
    "            p.id = pv.product_id and\n" +
    "            pv.id = pvo.product_variant_id and\n" +
    "            c.id = p.category_id and\n" +
    "            pvo.id = spvo.product_variant_option_id and\n" +
    "            sku.id = spvo.sku_id and\n" +
    "            p.id = sku.product_id and\n" +
    "            sku.id = si.sku_id and\n" +
    "            si.image_id = i.id and\n" +
    "            sku.discontinued = FALSE and\n" +
    "            p.discontinued = FALSE\n" +
    "order by sku.id;";

    final String SelectSQLProduct = "select sku.id,\n" +
            "            sku.sku,\n" +
            "            p.id as productId,\n" +
            "            sku.price,\n" +
            "            sku.discount,\n" +
            "            sku.sku_description as description,\n" +
            "            sku.new,\n" +
            "            sku.sale,\n" +
            "            p.name,\n" +
            "            p.brand,\n" +
            "            c.name as category,\n" +
            "            pv.name as variant,\n" +
            "            pvo.name as variant_option,\n" +
            "            i.imagepath\n" +
            "from\n" +
            "            products p, product_variants pv, product_variant_options pvo, categories c, sku_products sku, sku_product_variant_options spvo, images i, sku_images si\n" +
            "where\n" +
            "            p.tenant_id = #{tenantId} and\n" +
            "            p.id = #{id} and\n" +
            "            p.id = pv.product_id and\n" +
            "            pv.id = pvo.product_variant_id and\n" +
            "            c.id = p.category_id and\n" +
            "            pvo.id = spvo.product_variant_option_id and\n" +
            "            sku.id = spvo.sku_id and\n" +
            "            p.id = sku.product_id and\n" +
            "            sku.id = si.sku_id and\n" +
            "            si.image_id = i.id and\n" +
            "            sku.discontinued = FALSE and\n" +
            "            p.discontinued = FALSE\n" +
            "order by sku.id;";

    final String SelectSQLSKU = "select sku.id,\n" +
            "            sku.sku,\n" +
            "            p.id as productId,\n" +
            "            sku.price,\n" +
            "            sku.discount,\n" +
            "            sku.sku_description as description,\n" +
            "            sku.new,\n" +
            "            sku.sale,\n" +
            "            p.name,\n" +
            "            p.brand,\n" +
            "            c.name as category,\n" +
            "            pv.name as variant,\n" +
            "            pvo.name as variant_option,\n" +
            "            i.imagepath\n" +
            "from\n" +
            "            products p, product_variants pv, product_variant_options pvo, categories c, sku_products sku, sku_product_variant_options spvo, images i, sku_images si\n" +
            "where\n" +
            "            p.tenant_id = #{tenantId} and\n" +
            "            sku.id = #{id} and\n" +
            "            p.id = pv.product_id and\n" +
            "            pv.id = pvo.product_variant_id and\n" +
            "            c.id = p.category_id and\n" +
            "            pvo.id = spvo.product_variant_option_id and\n" +
            "            sku.id = spvo.sku_id and\n" +
            "            p.id = sku.product_id and\n" +
            "            sku.id = si.sku_id and\n" +
            "            si.image_id = i.id and\n" +
            "            sku.discontinued = FALSE and\n" +
            "            p.discontinued = FALSE\n" +
            "order by sku.id;";



    final String SelectSQLSKUSearch = "select sku.id,\n" +
            "            sku.sku,\n" +
            "            p.id as productId,\n" +
            "            sku.price,\n" +
            "            sku.discount,\n" +
            "            sku.sku_description as description,\n" +
            "            sku.new,\n" +
            "            sku.sale,\n" +
            "            p.name,\n" +
            "            p.brand,\n" +
            "            c.name as category,\n" +
            "            pv.name as variant,\n" +
            "            pvo.name as variant_option,\n" +
            "            i.imagepath\n" +
            "from\n" +
            "            products p, product_variants pv, product_variant_options pvo, categories c, sku_products sku, sku_product_variant_options spvo, images i, sku_images si\n" +
            "where\n" +
            "            p.tenant_id = #{tenantId} and\n" +
            "            p.id = pv.product_id and\n" +
            "            pv.id = pvo.product_variant_id and\n" +
            "            c.id = p.category_id and\n" +
            "            pvo.id = spvo.product_variant_option_id and\n" +
            "            sku.id = spvo.sku_id and\n" +
            "            p.id = sku.product_id and\n" +
            "            sku.id = si.sku_id and\n" +
            "            si.image_id = i.id and\n" +
            "            sku.discontinued = FALSE and\n" +
            "            p.discontinued = FALSE and \n" +
            "            p.id in (select p.product_id from tags t, product_tags p where t.tagname = #{search} and t.id = p.tag_id)\n " +
            "order by sku.id;";

    @Select(SelectSQLAll)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "sku", column = "sku"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "price", column = "price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "name", column = "name"),
            @Result(property = "category", column = "category"),
            @Result(property = "imagePath", column = "imagePath"),
            @Result(property = "description", column = "description"),
            @Result(property = "isNew", column = "new"),
            @Result(property = "onSale", column = "sale"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "variant", column = "variant"),
            @Result(property = "variantOption", column = "variant_option")

    })
    public List<ProductSKU> findAll(String tenantId);

    @Select(SelectSQLProduct)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "sku", column = "sku"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "price", column = "price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "name", column = "name"),
            @Result(property = "category", column = "category"),
            @Result(property = "imagePath", column = "imagePath"),
            @Result(property = "description", column = "description"),
            @Result(property = "isNew", column = "new"),
            @Result(property = "onSale", column = "sale"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "variant", column = "variant"),
            @Result(property = "variantOption", column = "variant_option")
    })
    public List<ProductSKU> findByProductId(Integer id, String tenantId);

    @Select(SelectSQLSKU)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "sku", column = "sku"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "price", column = "price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "name", column = "name"),
            @Result(property = "category", column = "category"),
            @Result(property = "imagePath", column = "imagePath"),
            @Result(property = "description", column = "description"),
            @Result(property = "isNew", column = "new"),
            @Result(property = "onSale", column = "sale"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "variant", column = "variant"),
            @Result(property = "variantOption", column = "variant_option")
    })
    public List<ProductSKU> findBySkuId(Integer id, String tenantId);

    @Select(SelectSQLSKUSearch)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "sku", column = "sku"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "price", column = "price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "name", column = "name"),
            @Result(property = "category", column = "category"),
            @Result(property = "imagePath", column = "imagePath"),
            @Result(property = "description", column = "description"),
            @Result(property = "isNew", column = "new"),
            @Result(property = "onSale", column = "sale"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "variant", column = "variant"),
            @Result(property = "variantOption", column = "variant_option")

    })
    public List<ProductSKU> search(String search, String tenantId);
}
