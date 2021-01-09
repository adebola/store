package io.factorialsystems.store.mapper.product;

import io.factorialsystems.store.data.image.SKUImage;
import io.factorialsystems.store.data.product.ProductAdminSKU;
import io.factorialsystems.store.data.product.ProductSKU;
import io.factorialsystems.store.data.product.SPVO;
import io.factorialsystems.store.domain.image.Image;
import io.factorialsystems.store.domain.product.SKU;
import io.factorialsystems.store.web.model.product.admin.AdminProductBundleDto;
import org.apache.ibatis.annotations.*;
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
            "            sku.quantity,\n" +
            "            sku.sku_description as description,\n" +
            "            sku.new,\n" +
            "            sku.sale,\n" +
            "            sku.discontinued,\n" +
            "            sku.vat_exclusive,\n" +
            "            p.name,\n" +
            "            p.brand,\n" +
            "            c.name as category,\n" +
            "            c.id as category_id,\n" +
            "            pv.name as variant,\n" +
            "            pvo.name as variant_option,\n" +
            "            pvo.id as variant_option_id,\n" +
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
            "            si.image_id = i.id";

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

    final String UPDATE_SKU_PRODUCT = "update sku_products set sku=#{dto.sku}, price=#{dto.price}, discount=#{dto.discount}, vat_exclusive=#{dto.vatExclusive}," +
            "sku_description=#{dto.description}, quantity=#{dto.quantity}, new=#{dto.isNew}, sale=#{dto.onSale}, discontinued=#{dto.discontinued}, " +
            "lastModifiedAt = NOW() where id=#{dto.id} and tenant_id=#{tenantId}";

    final String SAVE_SKU_PRODUCT = "insert into sku_products(product_id, sku, price, discount, sku_description, quantity, " +
            "new, sale, discontinued, vat_exclusive, tenant_id) values(#{productId}, #{sku}, #{price}, #{discount}, #{description}, " +
            "#{quantity}, #{isNew}, #{onSale}, #{discontinued}, #{vatExclusive}, #{tenantId})";

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
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "name", column = "name"),
            @Result(property = "discontinued", column = "discontinued"),
            @Result(property = "vatExclusive", column = "vat_exclusive"),
            @Result(property = "category", column = "category"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "variantOptionId", column = "variant_option_id"),
            @Result(property = "imagePath", column = "imagePath"),
            @Result(property = "description", column = "description"),
            @Result(property = "isNew", column = "new"),
            @Result(property = "onSale", column = "sale"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "variant", column = "variant"),
            @Result(property = "variantOption", column = "variant_option")
    })
    public ProductAdminSKU findByProductId(Integer id, String tenantId);

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

    @Update(UPDATE_SKU_PRODUCT)
    public Integer updateProductSKU(AdminProductBundleDto dto, String tenantId);

    @Update("update images INNER JOIN sku_images on images.id = sku_images.image_id  and sku_images.sku_id=#{id} SET imagepath=#{imagepath}")
    public Integer updateSKUImagePath(Integer id, String imagepath);

    @Update("update product_variant_options set name = #{option} where id=#{id}")
    public Integer updateProductVariantOptions(Integer id, String option);

    @Insert(SAVE_SKU_PRODUCT)
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveProductSKU(SKU sku);

    @Insert("insert into images(imagepath) values(#{imagePath})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer saveProductImage(Image image);

    @Insert("insert into sku_product_variant_options(sku_id, product_variant_option_id) values(#{skuId}, #{pvoId})")
    public Integer saveSPVO(SPVO spvo);

    @Insert("insert into sku_images(sku_id, image_id) values(#{skuId}, #{imageId})")
    public Integer saveProductSKUImage(SKUImage skuImage);


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
