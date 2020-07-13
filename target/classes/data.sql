insert into tenants(id, organization) values
('ca7efbdc-7fef-11ea-8e3b-62fdd0190df3', 'IcePlanet Cold Store'),
('ca7f369c-7fef-11ea-8e3b-62fdd0190df3', 'FotoJUG');

insert into roles (name, tenant_id) values
-- IcePlanet Roles
('ROLE_USER', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('ROLE_MODERATOR', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('ROLE_ADMIN', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
-- FotoJUG Roles
('ROLE_USER', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
('ROLE_OPERATOR', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
('ROLE_ADMIN', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');


insert into categories(name, tenant_id) values
-- IcePlanet Categories
('Fish', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Chicken', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Shrimps', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
--  FotoJUG Categories
('Cups', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
('Shirts', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');

insert into products(name, category_id, description, tenant_id) values
-- IcePlanet Products
('Croaker Fish', 1, 'Croaker Fish', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Panla Fish', 1, 'Panla Fish', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Pangasius', 1, 'Pangasius', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Orobo', 2, 'Orobo Chicken', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Fryer Lap', 2, 'Soft Fryer Lap', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('King Prawns',3, 'King Prawns', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
-- FotoJUG Products
('Mug', 4, 'Ikea Slim Coffee Mug', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
('Shirts', 5, 'Tommy Hilfiger T-Shirt', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');

insert into product_variants(product_id, name, tenant_id) values
-- IcePlanet Product Variants
(1, 'Package', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(1, 'Size', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(2, 'Package', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(3, 'Package', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(4, 'Package', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3' ),
-- PhotoJUG Product Variants
(7, 'Color', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'Color', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'Size', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');


insert into product_variant_options(product_variant_id, name, tenant_id) values
-- IcePlanet Product Variant Options
(1, 'Kg', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(1, 'Carton - 10Kg', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(2, 'Small', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(2, 'Medium', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(2, 'Large', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(3, 'Kg', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(3, 'Carton - 20Kg', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(4, 'Kg', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(4, 'Carton', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(5, 'Kg', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(5, 'Carton', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
-- FotoJUG Product Variant Options
(6, 'Blue', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(6, 'Red', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(7, 'Green', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(7, 'Yellow', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'S', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'M', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'L', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'XL', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, '2XL', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, '3XL', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');


insert into sku_products(product_id, sku, price, tenant_id) values
(1, 'sku1', 1300, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(1, 'sku2', 1300, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(1, 'sku3', 1300, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(1, 'sku4', 22000, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(1, 'sku5', 22000, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(1, 'sku6', 22000, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(2, 'sku7', 1000, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(2, 'sku8', 9000, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(3, 'sku9', 1700, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(3, 'sku10', 15000, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(4, 'sku11', 1500, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(4, 'sku12', 15000, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
-- FotoJUG Mug
(7, 'sku13', 5500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(7, 'sku14', 5500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
-- FotoJUG T-Shirt
(8, 'sku15', 10500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku16', 10500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku17', 10500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku18', 12500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku19', 12500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku20', 12500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku21', 10500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku22', 10500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku23', 10500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku24', 12500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku25', 12500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(8, 'sku26', 12500, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');



insert into sku_product_variant_options(sku_id, product_variant_option_id) values
(1, 1),
(1, 3),
(2, 1),
(2, 4),
(3, 1),
(3, 5),
(4, 2),
(4, 3),
(5, 2),
(5, 4),
(6, 2),
(6, 5),
(7, 6),
(8, 7),
(9, 8),
(10,9),
(11, 10),
(12, 11),
(13, 12),
(14, 13),
-- Green Small
(15, 14),
(15, 16),
-- Green Medium
(16, 14),
(16, 17),
-- Green Large
(17, 14),
(17, 18),
-- Green XL
(18, 14),
(18, 19),
-- Green 2XL
(19, 14),
(19, 20),
-- Green 3XL
(20, 14),
(20, 21),
-- Yellow Small
(21, 15),
(21, 16),
-- Yellow Medium
(22, 15),
(22, 17),
-- Yellow Large
(23, 15),
(23, 18),
-- Yellow XL
(24, 15),
(24, 19),
-- Yellow 2XL
(25, 15),
(25, 20),
-- Yellow 3XL
(26, 15),
(26, 21);



-- GET Single Product, Variants and Variant Options
select p.name as pname,
       p.tenant_id as ptenant,
       pv.name as pvname,
       pv.tenant_id as pvotenant,
       pvo.name as pvoname,
       pvo.tenant_id as pvotenant
from
    products p, product_variants pv, product_variant_options pvo
where
        p.id = 1 and p.id = pv.product_id and pv.id = pvo.product_variant_id;

-- GET All Products for Display
select sku.id as sku,
       p.id as productId,
       i.imagepath as imagepath,
       sku.price,
       p.name,
       pv.name as variant,
       pvo.name as variant_options
from
     products p,
     product_variants pv,
     product_variant_options pvo,
     sku_products sku,
     sku_product_variant_options spvo,
     images i,
     product_images pi

where
     spvo.product_variant_option_id = pvo.id and
     pvo.product_variant_id = pv.id and
     sku.id = spvo.sku_id and
     p.id = sku.product_id and
     p.id = pi.product_id and
     pi.image_id = i.id and
     p.id = 7 and
     sku.discontinued = FALSE and
     p.discontinued = FALSE
order by sku.id;

-- GET Single product for Display
select sku.id as sku,
       p.id as productId,
       sku.price,
       p.name,
       p.imagePath,
       pv.name as variant,
       pvo.name as variant_options
from
    products p, product_variants pv, product_variant_options pvo, sku_products sku, sku_product_variant_options spvo
where
        spvo.product_variant_option_id = pvo.id and
        pvo.product_variant_id = pv.id and
        sku.id = spvo.sku_id and
        p.id = sku.product_id and
        p.id = 1
order by sku.id;


select p.id as product_id,
       p.name as product,
       pv.id as variant_id,
       pv.name as variant,
       pvo.id as variant_option_id,
       pvo.name as variant_option
from
     products p, product_variants pv, product_variant_options pvo
where
    p.id = 1 and p.id = pv.product_id and pv.id = pvo.product_variant_id;

-- GET Variants Only

select skp.id,
       p.name as product_name,
       p.imagepath,
       skp.sku,
       skp.price,
       pv.name as variant,
       pvo.name as variant_options
from sku_products skp, sku_product_variant_options spvo, product_variant_options pvo, product_variants pv, products p
where
      skp.product_id = 1 and
      skp.product_id = p.id and
      skp.discontinued = FALSE and
      p.discontinued = FALSE and
      skp.id = spvo.sku_id and
      spvo.product_variant_option_id = pvo.id and
      pvo.product_variant_id = pv.id;


select skp.id,
    skp.sku, skp.price, pv.name as variant, pvo.name as variant_option
    from sku_products skp, sku_product_variant_options spvo, product_variant_options pvo, product_variants pv, products p
    where
    skp.product_id = 1 and
    skp.product_id = p.id and
    skp.discontinued = FALSE and
    p.discontinued = FALSE and
    skp.id = spvo.sku_id and
    spvo.product_variant_option_id = pvo.id and
    pvo.product_variant_id = pv.id;
