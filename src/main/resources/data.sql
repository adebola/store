insert into tenants(id, name) values
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
('Fish', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
--  FotoJUG Categories
('Cups', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
('Shirts', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');

insert into products(name, category_id, tenant_id) values
-- IcePlanet Products
('Croaker Fish', 1, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Panla Fish', 1, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Pangasius', 1, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
('Orobo', 2, 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
-- FotoJUG Products
('Coffee Mug', 8, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
('TH T-Shirt', 7, 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');

insert into product_variants(product_id, name, tenant_id) values
-- IcePlanet Product Variants
(1, 'Package', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(1, 'Size', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(2, 'Package', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(3, 'Package', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3'),
(4, 'Package', 'ca7efbdc-7fef-11ea-8e3b-62fdd0190df3' ),
-- PhotoJUG Product Variants
(5, 'Color', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(6, 'Color', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3'),
(6, 'Size', 'ca7f369c-7fef-11ea-8e3b-62fdd0190df3');


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
