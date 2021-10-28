
-- Get All Products, Prices and Related Data
select sku.id,
       sku.sku,
       p.id as productId,
       sku.price,
       sku.discount,
       sku.sku_description as description,
       sku.new,
       sku.vat_exclusive,
       sku.sale,
       sku.quantity,
       p.name,
       p.brand,
       p.discontinued,
       c.name as category,
       pvo.name as UoM
from
    products p, product_variants pv, product_variant_options pvo, categories c, sku_products sku, sku_product_variant_options spvo, images i, sku_images si
where
        p.id = pv.product_id and
        pv.id = pvo.product_variant_id and
        c.id = p.category_id and
        pvo.id = spvo.product_variant_option_id and
        sku.id = spvo.sku_id and
        p.id = sku.product_id and
        sku.id = si.sku_id and
        si.image_id = i.id and
        sku.discontinued = FALSE
order by sku.id;
