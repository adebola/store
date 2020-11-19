

insert into tenants(id, organization, email, logo_url, base_url) values
('65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'DELIFROST', 'delifrost@factorialsystems.io',  'https://delifrost-30582.web.app/assets/images/icon/logo-7.png','https://delifrost-30582.web.app');

insert into roles (name, tenant_id) values
('ROLE_USER', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('ROLE_OPERATOR', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('ROLE_ADMIN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');

insert into categories(name, tenant_id, image_url) values
('Butter', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/butter.jpg'),
('Ice-Cream', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/ice-cream.jpg'),
('Fries', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/fries.jpg'),
('Cheese', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/cheese.jpg'),
('Corn', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/corn.jpg'),
('Chicken', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/chicken.jpg');

insert into products(name, description, brand, category_id, tenant_id) values
('Ambassador Salted Butter', 'Ambassador Salted Butter', 'Ambassador', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ambassador Unsalted Butter', 'Ambassador Unsalted Butter', 'Ambassador', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ambassador Slightly Salted Butter', 'Ambassador Slightly Salted Butter', 'Ambassador', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ambassador Spreadable Salted Butter', 'Ambassador Salted Spreadable Butter', 'Ambassador', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Salted Butter', 'President Salted Butter', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Unsalted Butter', 'President Unsalted Butter', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Vanilla Ice-Cream', 'Cadbury Vanilla Ice-Cream', 'Cadbury', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Crunchie Ice-Cream', 'Cadbury Crunchie Ice-Cream', 'Cadbury', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ice-Cream', 'Cadbury Ice-Cream', 'Cadbury', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Phoenix Fries', 'Golden Phoenix French Fries', 'Golden Phoenix', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Phoenix Fries', 'Golden Phoenix French Fries', 'Golden Phoenix', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Crinkle Cut Fries', 'Crinkle Cut Fries', 'Golden Phoenix', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Crinkle Cut Fries', 'Crinkle Cut Fries', 'Golden Phoenix', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Shoestring Fries', 'Golden Phoenix Shoestring cut French Fries', 'Golden Phoenix', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Shoestring Fries', 'Golden Phoenix Shoestring cut French Fries', 'Golden Phoenix', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Mozarella Cheese', 'Maestrella Mozarella Shredded Cheese', 'Maestrella', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Corn Kernels', 'McCain Corn Kernels', 'McCain', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Chicken Franks', 'Golden Phoenix Chicken Franks', 'Golden Phoenix', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Chicken Griller', 'Golden Phoenix Frozen Chicken Griller', 'Golden Phoenix', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');

insert into product_variants(product_id, name, tenant_id) values
-- Ambassador Salted Butter
(1, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Unsalted Butter
(2, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Slightly Salted Butter
(3, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Spreadable Salted Butter
(4, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Salted Butter
(5, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Unsalted Butter
(6, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Vanilla Ice-Cream
(7, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Crunchie Ice-Cream
(8, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Caramel Ice-Cream
(9, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix Fries 2.5Kg
(10, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix Fries 1Kg
(11, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Crinkle Cut Fries
(12, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Crinkle Cut Fries
(13, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Shoestring Fries
(14, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Shoestring Fries
(15, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mozarella Cheese
(16, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Corn Kernels
(17, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Chicken Franks
(18, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Chicken Griller
(19, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');

insert into product_variant_options(product_variant_id, name, tenant_id) values
-- Ambassador Salted Butter
(1, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Unsalted Butter
(2, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Slightly Salted Butter
(3, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Spreadable Salted Butter
(4, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Salted Butter
(5, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Unsalted Butter
(6, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Vanilla Ice-Cream
(7, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Crunchie Ice-Cream
(8, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cadbury Caramel Ice-Cream
(9, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix Fries
(10, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix Fries
(11, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Crinkle Cut Fries
(12, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Crinkle Cut Fries
(13, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Shoestring Fries
(14, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Shoestring Fries
(15, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mozarella Cheese
(16, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Corn Kernels
(17, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Chicken Franks
(18, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Chicken Griller
(19, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');

insert into sku_products(product_id, sku, price, discount, sku_description, tenant_id) values
-- Ambassador Salted Butter
(1, 'AMB-SAL-BUT-CART-200G', 25000, 2.5, 'Ambassador Salted Butter Carton 10x200g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Unsalted Butter
(2, 'AMB-UNSAL-BUT-CART-200G', 25000, 2.5, 'Ambassador Unsalted Butter Carton 10x200g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Slightly Salted Butter
(3, 'AMB-SLSAL-BUT-CART-200G', 23500, 2.5, 'Ambassador Slightly Salted Butter Carton 10x 200g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador Spreadable Salted Butter
(4, 'AMB-SPSAL-BUT-CART-200G', 24500, 2, 'Ambasador Spreadable Salted Butter Carton 10x200g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Salted Butter
(5, 'PRES-SAL-BUT-CART-200G', 25500, 2, 'President Salted Butter Carton 10x200g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President UnSalted Butter
(6, 'PRES-UNSAL-BUT-CART-200G', 24500, 2, 'President Unsalted Butter Carton 10x200g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cadbury Vanilla Ice-Crean
(7, 'CAD-VAN-ICECREAM-CART-1KG', 15000, 2, 'Cadbury Vanilla IceCream Carton 10x1Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cadbury Crunchie Ice-Crean
(8, 'CAD-CRU-ICECREAM-CART-1KG', 15500, 2, 'Cadbury Chrunchie IceCream Carton 10x1Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cadbury Caramel Ice-Crean
(9, 'CAD-CAR-ICECREAM-CART-1KG', 15000, 2, 'Cadbury Caramel IceCream Carton 10x1Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix Fries 2.5Kg
(10, 'GOL-PHO-FRI-CART-2.5KG', 15000, 2, 'Golden Phoenix Extra Crispy Premium French Fries Carton 4x2.5Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix Fries 1Kg
(11, 'GOL-PHO-FRI-CART-1KG', 15000, 2, 'Golden Phoenix Extra Crispy Premium French Fries Carton 10x1Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix Crinkle Cut Fries 2.5Kg
(12, 'GOL-PHO-CRI-FRI-CART-2.5KG', 15000, 2, 'Golden Phoenix Crinkle Cut Fries Carton 4x2.5Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix Crinkle Cut Fries 1Kg
(13, 'GOL-PHO-CRI-FRI-CART-1KG', 15000, 2, 'Golden Phoenix Crinkle Cut Frie Carton 10x1Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix ShoeString Cut Fries 2.5Kg
(14, 'GOL-PHO-SHO-FRI-CART-2.5KG', 15000, 2, 'Golden Phoenix Shoestring Cut Fries Carton 4x2.5Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Phoenix ShoeString Cut Fries 1Kg
(15, 'GOL-PHO-SHO-FRI-CART-1KG', 15000, 2, 'Golden Phoenix Shoestring Cut Frie Carton 10x1Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mozarella Cheese
(16, 'MAE-MOZ-CHE-CART-1KG', 19000, 2.5, 'Maestrella Mozzarella Shredded Cheese Carton 10 x 2Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Corn Kernels
(17, 'MC-COR-KER-CART-500G', 9500, 2, 'McCain Corn Kernels Carton 5 x 500g ', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix Chicken Franks
(18, 'GOL-PHO-FRA-CART-1KG', 25000, 2.5, 'Golden Phoenix Chicken Franks 20 x 1Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix Chicken Griller
(19, 'GOL-PHO-GRILL-CART-1KG', 25000, 2.5, 'Golden Phoenix Chicken Griller 20 x 1Kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');

insert into sku_product_variant_options(sku_id, product_variant_option_id) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10),
(11,11),
(12,12),
(13,13),
(14,14),
(15,15),
(16,16),
(17,17),
(18,18),
(19,19);

insert into images (imagepath) values
('assets/images/products/salted-butter.jpg'),
('assets/images/products/unsalted-butter.jpg'),
('assets/images/products/slightly-salted-butter.jpg'),
('assets/images/products/spreadable-salted-butter.jpg'),
('assets/images/products/president-salted-butter.jpg'),
('assets/images/products/president-unsalted-butter.jpg'),
('assets/images/products/vanilla-icecream.jpg'),
('assets/images/products/crunchie-icecream.jpg'),
('assets/images/products/caramello-icecream.jpg'),
('assets/images/products/golden-phoenix-fries.jpg'),
('assets/images/products/crinkle-cut-fries.jpg'),
('assets/images/products/shoe-string-cut-fries.jpg'),
('assets/images/products/mozarella-cheese.jpg'),
('assets/images/products/corn-kernels.jpg'),
('assets/images/products/goldenphoenix-chickenfranks.jpg'),
('assets/images/products/chicken-griller.jpg');

insert into sku_images (sku_id, image_id) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10),
(11,10),
(12,11),
(13,11),
(14,12),
(15,12),
(16,13),
(17,14),
(18,15),
(19,16);














