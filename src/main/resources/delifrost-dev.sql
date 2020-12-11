

insert into tenants(id, organization, email, logo_url, base_url) values
('65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'DELIFROST', 'delifrost@factorialsystems.io',  'https://delifrost-30582.web.app/assets/images/icon/logo-7.png','https://delifrost-30582.web.app');

insert into roles (name, tenant_id) values
('ROLE_USER', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('ROLE_OPERATOR', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('ROLE_ADMIN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');

insert into categories(name, tenant_id, image_url) values
('Dairy Products', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/diary-products.jpg'),
('Ice Creams', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/ice-cream.jpg'),
('Alternative Creams', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/alternative-creams.jpg'),
('Vegetables & Fries', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/fries-veg.jpg'),
('Yam & Plantain', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/yam-plantain.jpg'),
('Fish & Sea Food', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/seafood.jpg'),
('Frozen Food', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/frozen-food.jpg'),
('Viennoiserie & Bakery', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/vennoiserie/chicken.jpg'),
('Confectionery', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e', 'assets/images/categories/confectionary.jpg');

insert into products(name, description, brand, category_id, tenant_id) values
('Maestrella Frozen Diced Mozzarella', 'Maestrella Frozen Diced Mozzarella', 'Maestrella', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Maestrella Frozen Mozzarella Block', 'Maestrella Frozen Mozzarella Block', 'Maestrella', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Maestrella Frozen Shredded Mozzarella', 'Maestrella Frozen Shredded Mozzarella', 'Maestrella', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Galbani Permasan Cheese', 'Galbani Permasan Cheese', 'Galbani', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Edam Cheese loaf', 'President Edam Cheese loaf ', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Gouda Cheese loaf', 'President Gouda Cheese loaf', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Emmental Block Cheese', 'President Emmental Block Cheese', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Cream Cheese', 'President Cream Cheese', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Mclelland Mild Red Cheddar Loaf', 'Mclelland Mild Red Cheddar Loaf', 'Mclelland', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Mclelland Mild White Cheddar Loaf', 'Mclelland Mild White Cheddar Loaf', 'Mclelland', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 220g Emmental cheese', 'President 220g Emmental cheese', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Small Brie in Tin', 'President Small Brie in Tin', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Small Camembert in Tin', 'President Small Camembert in Tin', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Mild White Cheddar', 'President Mild White Cheddar', 'President', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Cream Cheese', 'President Cream Cheese', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 120g Processed Cheese', 'President 120g Processed Cheese', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President Edam Slices', 'President Edam Slices', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President  Gouda Slices', 'President  Gouda Slices 150g x 10 pcs', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 10 Sliced cheddar cheese', 'President 10 Sliced cheddar cheese for sandwich', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 10 Sliced emmental cheese for toast', 'President 10 Sliced emmental cheese for toast', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 10 Sliced cheddar cheese for hamburger', 'President 10 Sliced cheddar cheese for hamburger', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 1L Cream 18% (Cooking)', 'President 1L Cream 18% (Cooking)', 'Galbani', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 250g spray Cream 20% whipped', 'President 250g spray Cream 20% whipped x 12 pcs  ', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 1L Cream 35.1% (whipping)', 'President 1L Cream 35.1% (whipping)', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Merci Chef 200G Unsalted Butter', 'Merci Chef 200G Unsalted Butter', 'Merci', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ambassador 200g Salted butter mix', 'Ambassador 200g Salted butter mix', 'Ambassador', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ambassador 200g Unsalted butter mix', 'Mclelland Mild Red Cheddar Loaf', 'Ambassador', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 8g Minitubs Unsalted butter', 'President 8g Minitubs Unsalted butter ', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 200g Salted Butter', 'President 200g Salted Butter', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('President 200g Unsalted Butter', 'President 200g Unsalted Butter ', 'President', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Bridel 200G Unsalted Butter', 'Bridel 200G Unsalted Butter', 'Bridel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Lactel Fruity Pineapple', 'Lactel Fruity Pineapple 4x12x125g', 'Lactel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Lactel Fruity Strawberry', 'Lactel Fruity Strawberry', 'Lactel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Lactel Fruity Mango', 'Lactel Fruity Mango', 'Lactel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Lactel Fruity Banana', 'Lactel Fruity Banana', 'Lactel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Lactel Fruity Mixed Berries', 'Lactel Fruity Mixed Berries', 'Lactel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Lactel Dessert Nature Plain', 'Lactel Dessert Nature Plain', 'Lactel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Lactel Dessert Chocolate', 'Lactel Dessert Chocolate', 'Lactel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Lactel Dessert Vanilla', 'Lactel Dessert Vanilla', 'Lactel', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Oreo 480ml Ice Cream', 'Oreo 480ml Ice Cream', 'Oreo', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Cadbury 480ml Caramello Ice Cream', 'Cadbury 480ml Caramello Ice Cream', 'Cadbury', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Chocolate & Fudge Ice Cream', 'Dairy Maid Chocolate & Fudge Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Blueberry & Cheesecake Ice Cream', 'Dairy Maid Blueberry & Cheesecake Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Choca-Cara-Nila Ice Cream', 'Dairy Maid Choca-Cara-Nila Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Fresh Vanilla Lite Ice Cream', 'Dairy Maid Fresh Vanilla Lite Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Fresh Vanilla Ice Cream', 'Dairy Maid Fresh Vanilla Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Fresh Neapolitan Ice Cream', 'Dairy Maid Fresh Neapolitan Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Fresh Vanilla Ice Cream', 'Dairy Maid Fresh Vanilla Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Fresh Neapolitan Ice Cream', 'Dairy Maid Fresh Neapolitan Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Fresh Vanilla Ice Cream', 'Dairy Maid Fresh Vanilla Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Dairy Maid Blueberry & Cheesecake Ice Cream', 'Dairy Maid Blueberry & Cheesecake Ice Cream', 'Dairy Maid', 2, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Danica Non Dairy Cooking Cream', 'Danica Non Dairy Cooking Cream', 'Danica', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Danica Non Dairy Whipping Cream', 'Danica Non Dairy Whipping Cream', 'Danica', 3, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Richs Bettercreme Chocolate flavoured', 'Richs Bettercreme Chocolate flavoured ', 'Rich', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Richs Bettercream Strawbery flavoured ', 'Richs Bettercream Strawbery flavoured', 'Rich', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Richs Bettercream Vanilla flavoured', 'Richs Bettercream Vanilla flavoured', 'Rich', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Mity Fresh Mixed Vegetables', 'Mity Fresh Mixed Vegetables', 'Mity', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Mity Fresh Green Peas', 'Mity Fresh Green Peas', 'Mity', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Golden Phoenix 2.5Kg French Fries', 'Golden Phoenix 2.5Kg French Fries', 'Golden Phoenix', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Golden Phoenix 1kg French Fries', 'Golden Phoenix 1kg French Fries X 10pcs', 'Golden Phoenix', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Mixed Vegetables', 'McCain Mixed Vegetables', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Peas', 'McCain Peas', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Corn Kernels', 'McCain Corn Kernels', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Winter Vegetables', 'McCain Winter Vegetables', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Seasoned Wedges', 'McCain Seasoned Wedges 12', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Tradition French Fries', 'McCain Tradition French Fries', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Tradition French Fries', 'McCain Tradition French Fries', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Original 6/6 French Fries', 'McCain Original 6/6 French Fries', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('McCain Original 9/9 French Fries', 'McCain Original 9/9 French Fries', 'McCain', 4, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Sympli Straight Cut Yam Fries', 'Sympli Straight Cut Yam Fries', 'Sympli', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Sympli Straight Cut Yam Fries', 'Sympli Straight Cut Yam Fries', 'Sympli', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Sympli Straight Cut Yam Fries', 'Sympli Straight Cut Yam Fries', 'Sympli', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Sympli Thick Cut Yam Chip', 'Sympli Thick Cut Yam Chip', 'Sympli', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Sympli Thick Cut Yam Chip', 'Sympli Thick Cut Yam Chip', 'Sympli', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Sympli Thick Cut Yam Chip', 'Sympli Thick Cut Yam Chip', 'Sympli', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Sympli Ripe Plantain Chops', 'Sympli Ripe Plantain Chops', 'Sympli', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Golden Phoenix 1Kg fish fillet', 'Golden Phoenix 1Kg fish fillet', 'Golden Phoenix', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Golden Phoenix 400g Large Shrimp', 'Golden Phoenix 400g Large Shrimp', 'Golden Phoenix', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Golden Phoenix 400g Jumbo Shrimp', 'Golden Phoenix 400g Jumbo Shrimp', 'Golden Phoenix', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower African Mix Fish', 'Ocean Flower African Mix Fish', 'Ocean Flower', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower Tilapia Fish', 'Ocean Flower Tilapia Fish', 'Ocean Flower', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower Sole Pan Ready', 'Ocean Flower Sole Pan Ready', 'Ocean Flower', 5, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower Crab Whole', 'Ocean Flower Crab Whole', 'Ocean Flower', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower Seafood Mix 400g', 'Ocean Flower Seafood Mix 400g', 'Ocean Flower', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower Octopus Flower Gutted 1kg', 'Ocean Flower Octopus Flower Gutted 1kg ', 'Ocean Flower', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower Crab Cluster 1kg', 'Ocean Flower Crab Cluster 1kg', 'Ocean Flwoer', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower PUD Medium Shrimps', 'Ocean Flower PUD Medium Shrimps', 'Ocean Flwoer', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower PUD Small Shrimps', 'Ocean Flower PUD Small Shrimps', 'Ocean Flower', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Ocean Flower Headless Small Shrimps', 'Ocean Flower Headless Small Shrimps', 'Ocean Flower', 6, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Golden Phoenix 340g Chicken Franks', 'Golden Phoenix 340g Chicken Franks', 'Golden Phoenix', 7, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Seara Chicken Franks 340g', 'Seara Chicken Franks 340g', 'Seara', 7, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Tulip Sliced Streaky Bacon 1kg', 'Tulip Sliced Streaky Bacon 1kg', 'Tulip', 7, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Tulip Sliced Back Bacon 1kg', 'Tulip Sliced Back Bacon 1kg', 'Tulip', 7, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Tulip Sliced Streaky Bacon', 'Tulip Sliced Streaky Bacon 150g x 15 pcs', 'Tulip', 7, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Tulip Danish Salami ', 'Tulip Danish Salami ', 'Tulip', 7, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Tulip Sliced Pepperoni 1kg', 'Tulip Sliced Pepperoni 1kg', 'Tulip', 7, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('White Baguette', 'White Baguette', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Multicereal Baguette', 'Multicereal Baguette', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Multicereal Loaf', 'Multicereal Loaf', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Cereals,Almonds,Hazelnut Loaf', 'Cereals,Almonds,Hazelnut Loaf', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('White Roll', 'White Roll', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Maxi Croissant ', 'Maxi Croissant', 'Maxi', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Maxi Pain Au Chocolat', 'Maxi Pain Au Chocolat', 'Maxi', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Multicereal Croissant', 'Multicereal Croissant', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Raisin Whirl', 'Raisin Whirl', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Chocolate Chip Muffin', 'Chocolate Chip Muffin', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Plain Muffin with Sugar Topping', 'Plain Muffin with Sugar Topping', 'In-House', 1, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Mini Croissant', 'Mini Croissant', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Mini Raisin Whirl', 'Mini Raisin Whirl', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Mini Pain Au Chocolate', 'Mini Pain Au Chocolate', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Tiramisu Layer Cake', 'Tiramisu Layer Cake', 'In-House', 8, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Bien Croissant', 'Bien Croissant', 'In-House', 9, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Choco Bien', 'Choco Bien', 'In-House', 9, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Roxy', 'Roxy', 'In-House', 9, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
('Bence', 'bence', 'In-House', 9, '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');

insert into product_variants(product_id, name, tenant_id) values
-- Maestrella Frozen Diced Mozarella
(1, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maestrella Frozen Mozzarella Block
(2, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maestrella Frozen Shredded Mozzarella
(3, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Galbani Permasan Cheese
(4, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Edam Cheese loaf
(5, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Gouda Cheese loaf
(6, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Emmental Block Cheese
(7, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Cream Cheese
(8, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mclelland Mild Red Cheddar Loaf
(9, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mclelland Mild White Cheddar Loaf
(10, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 220g Emmental cheese x 14 pcs
(11, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President  Small Brie in Tin 125g x 12 Pcs
(12, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Small Camembert in Tin 125g x 12 Pcs
(13, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Mild White Cheddar 200g x 8 pcs
(14, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Cream Cheese 180g X 12 pcs
(15, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 120g Processed Cheese 8 portions x 24 pcs
(16, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Edam Slices 150g x 10 pcs
(17, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President  Gouda Slices 150g x 10 pcs
(18, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced cheddar cheese for sandwich 200g x 36 pcs
(19, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced emmental cheese for toast 200g x 36 pcs
(20, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced cheddar cheese for hamburger 200g x 36 pcs
(21, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 1L Cream 18% (Cooking) x 6 pcs
(22, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 250g spray Cream 20% whipped x 12 pcs
(23, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 1L Cream 35.1% (whipping) x 6 pcs
(24, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Merci Chef 200G Unsalted Butter X 40 Pcs
(25, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador 200g Salted butter mix x 40pcs
(26, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador 200g Unsalted butter mix x 40pcs
(27, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 8g Minitubs Unsalted butter x 600 pcs
(28, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 200g Salted Butter x 40 pcs
(29, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 200g Unsalted Butter x 40 pcs
(30, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Bridel 200G Unsalted Butter X 40 Pcs
(31, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Pineapple 4x12x125g
(32, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Strawberry 4x12x125g
(33, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Mango 4x12x125g
(34, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Banana 4x12x125g
(35, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Mixed Berries 4x12x125g
(36, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Nature Plain 4x12x125g
(37, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Chocolate 4x12x125g
(38, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Vanilla 4x12x125g
(39, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Oreo 480ml Ice Cream
(40, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cadbury 480ml Caramello  x 6 pcs (Ice Cream)
(41, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid Ice Cream
(42, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L Country Fresh Blueberry & Cheesecake (Ice cream)
(43, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid Choca-Cara-Nila Ice Cream
(44, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L Country Fresh Vanilla Lite (Ice Cream)
(45, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid Fresh Vanilla Ice Cream
(46, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
--Dairy Maid 2L Country Fresh Neapolitan (Ice Cream)
(47, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 5L Country Fresh Vanilla (Ice Cream)
(48, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 5L Country Fresh Neapolitan (Ice Cream)
(49, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 500ml Country Fresh Vanilla (Ice Cream)
(50, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 500ml Country Fresh Blueberry & Cheesecake (Ice cream)
(51, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Danica Non Dairy Cooking Cream 25% 1LX12
(52, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Danica Non Dairy Whipping Cream Sweet 27% 1LX12
(53, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Rich's Bettercreme Chocolate flavoured 9 x 2kg
(54, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Rich's Bettercream Strawbery flavoured 9 x 2kg
(55, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Rich's Bettercream Vanilla flavoured 9 x 2kg
(56, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mity Fresh Mixed Vegetables 400g x 20 pcs
(57, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mity Fresh Green Peas 400g x 20 pcs
(58, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 2.5Kg French fries x 4 pcs
(59, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 1kg French Fries X 10pcs
(60, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Mixed Vegetables 12 x500g
(61, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Peas 24 x 500g
(62, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Corn Kernels 12 x 500g
(63, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Winter Vegetables 12 x 500g
(64, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Seasoned Wedges 12 x 750g
(65, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Tradition French Fries 16 x 750g
(66, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Tradition French Fries 8 x 1.5kg
(67, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Original 6/6 French Fries 5 x 2.5kg
(68, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Original 9/9 French Fries 5 x 2.5kg
(69, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 200g x 25 pcs
(70, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 500g x 10 pcs
(71, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 2.5kg x 4 pcs
(72, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 200g x 25 pcs
(73, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 500g x 10 pcs
(74, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 2.5kg x 4 pcs
(75, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Ripe Plantain Chops 2.5kg x 4 pcs
(76, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 1Kg fish fillet x 10 pcs
(77, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 400g Large Shrimp x  10 pcs
(78, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 400g Jumbo Shrimp x  10 pcs
(79, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower African Mix Fish 1kg x 8 pcs
(80, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Tilapia Fish 1.3kg x 8 pcs
(81, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Sole Pan Ready 1kg x 8 pcs
(82, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Crab Whole 1kg x 8 pcs
(83, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Seafood Mix 400g x 12 pcs
(84, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Octopus Flower Gutted 1kg x 8 pcs
(85, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Crab Cluster 1kg x 6 pcs
(86, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower PUD Medium Shrimps 400g x 12 pcs
(87, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower PUD Small Shrimps 400g x 12 pcs
(88, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Headless Small Shrimps 400g x 12 pcs
(89, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 340g Chicken Franks x 24 pcs
(90, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Seara Chicken Franks 340g x 24 pcs
(91, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Streaky Bacon 1kg
(92, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Back Bacon 1kg
(93, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Streaky Bacon 150g x 15 pcs
(94, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Danish Salami
(95, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Pepperoni 1kg
(96, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- White Baguette 225g x 38 pcs
(97, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Baguette 250g x 30 pcs
(98, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Loaf 440g x 16 pcs
(99, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cereals,Almonds,Hazelnut Loaf 365g x 30 pcs
(100, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- White Roll 40g x 160 pcs
(101, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maxi Croissant  90g x 80 pcs
(102, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maxi Pain Au Chocolat 120g x 64 pcs
(103, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Croissant 80g x 56 pcs
(104, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Raisin Whirl 96g x 60 pcs
(105, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Chocolate Chip Muffin 95g x 24 pcs
(106, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Plain Muffin with Sugar Topping 95g x 24 pcs
(107, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Croissant  25g x 160 pcs
(108, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Raisin Whirl 30g x 150 pcs
(109, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Pain Au Chocolate 25g x 160 pcs
(110, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tiramisu Layer Cake 610g x 4 pcs
(111, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Bien Croissant 4 x 20 x 50g
(112, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Choco Bien 6 x 24 x 32g
(113, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Roxy
(114, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Bence
(115, 'Unit', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');


insert into product_variant_options(product_variant_id, name, tenant_id) values
-- Maestrella Frozen Diced Mozarella
(1, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maestrella Frozen Mozzarella Block
(2, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maestrella Frozen Shredded Mozzarella
(3, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Galbani Permasan Cheese
(4, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Edam Cheese loaf
(5, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Gouda Cheese loaf
(6, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Emmental Block Cheese
(7, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Cream Cheese
(8, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mclelland Mild Red Cheddar Loaf
(9, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mclelland Mild White Cheddar Loaf
(10, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 220g Emmental cheese x 14 pcs
(11, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President  Small Brie in Tin 125g x 12 Pcs
(12, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Small Camembert in Tin 125g x 12 Pcs
(13, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Mild White Cheddar 200g x 8 pcs
(14, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Cream Cheese 180g X 12 pcs
(15, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 120g Processed Cheese 8 portions x 24 pcs
(16, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Edam Slices 150g x 10 pcs
(17, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President  Gouda Slices 150g x 10 pcs
(18, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced cheddar cheese for sandwich 200g x 36 pcs
(19, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced emmental cheese for toast 200g x 36 pcs
(20, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced cheddar cheese for hamburger 200g x 36 pcs
(21, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 1L Cream 18% (Cooking) x 6 pcs
(22, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 250g spray Cream 20% whipped x 12 pcs
(23, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 1L Cream 35.1% (whipping) x 6 pcs
(24, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Merci Chef 200G Unsalted Butter X 40 Pcs
(25, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador 200g Salted butter mix x 40pcs
(26, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador 200g Unsalted butter mix x 40pcs
(27, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 8g Minitubs Unsalted butter x 600 pcs
(28, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 200g Salted Butter x 40 pcs
(29, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 200g Unsalted Butter x 40 pcs
(30, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Bridel 200G Unsalted Butter X 40 Pcs
(31, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Pineapple 4x12x125g
(32, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Strawberry 4x12x125g
(33, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Mango 4x12x125g
(34, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Banana 4x12x125g
(35, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Mixed Berries 4x12x125g
(36, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Nature Plain 4x12x125g
(37, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Chocolate 4x12x125g
(38, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Vanilla 4x12x125g
(39, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Oreo 480ml Ice Cream
(40, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cadbury 480ml Caramello  x 6 pcs (Ice Cream)
(41, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid Ice Cream
(42, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L Country Fresh Blueberry & Cheesecake (Ice cream)
(43, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid Choca-Cara-Nila Ice Cream
(44, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L Country Fresh Vanilla Lite (Ice Cream)
(45, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid Fresh Vanilla Ice Cream
(46, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L Country Fresh Neapolitan (Ice Cream)
(47, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 5L Country Fresh Vanilla (Ice Cream)
(48, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 5L Country Fresh Neapolitan (Ice Cream)
(49, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 500ml Country Fresh Vanilla (Ice Cream)
(50, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 500ml Country Fresh Blueberry & Cheesecake (Ice cream)
(51, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Danica Non Dairy Cooking Cream 25% 1LX12
(52, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Danica Non Dairy Whipping Cream Sweet 27% 1LX12
(53, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Rich's Bettercreme Chocolate flavoured 9 x 2kg
(54, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Rich's Bettercream Strawbery flavoured 9 x 2kg
(55, 'Carton', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Rich's Bettercream Vanilla flavoured 9 x 2kg
(56, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mity Fresh Mixed Vegetables 400g x 20 pcs
(57, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mity Fresh Green Peas 400g x 20 pcs
(58, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 2.5Kg French fries x 4 pcs
(59, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 1kg French Fries X 10pcs
(60, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Mixed Vegetables 12 x500g
(61, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Peas 24 x 500g
(62, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Corn Kernels 12 x 500g
(63, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Winter Vegetables 12 x 500g
(64, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Seasoned Wedges 12 x 750g
(65, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Tradition French Fries 16 x 750g
(66, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Tradition French Fries 8 x 1.5kg
(67, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Original 6/6 French Fries 5 x 2.5kg
(68, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
--McCain Original 9/9 French Fries 5 x 2.5kg
(69, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 200g x 25 pcs
(70, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 500g x 10 pcs
(71, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 2.5kg x 4 pcs
(72, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 200g x 25 pcs
(73, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 500g x 10 pcs
(74, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 2.5kg x 4 pcs
(75, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Ripe Plantain Chops 2.5kg x 4 pcs
(76, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 1Kg fish fillet x 10 pcs
(77, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 400g Large Shrimp x  10 pcs
(78, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 400g Jumbo Shrimp x  10 pcs
(79, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower African Mix Fish 1kg x 8 pcs
(80, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Tilapia Fish 1.3kg x 8 pcs
(81, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Sole Pan Ready 1kg x 8 pcs
(82, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Crab Whole 1kg x 8 pcs
(83, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Seafood Mix 400g x 12 pcs
(84, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Octopus Flower Gutted 1kg x 8 pcs
(85, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Crab Cluster 1kg x 6 pcs
(86, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower PUD Medium Shrimps 400g x 12 pcs
(87, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower PUD Small Shrimps 400g x 12 pcs
(88, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Headless Small Shrimps 400g x 12 pcs
(89, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 340g Chicken Franks x 24 pcs
(90, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Seara Chicken Franks 340g x 24 pcs
(91, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Streaky Bacon 1kg
(92, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Back Bacon 1kg
(93, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Streaky Bacon 150g x 15 pcs
(94, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Danish Salami
(95, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Pepperoni 1kg
(96, 'KG', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- White Baguette 225g x 38 pcs
(97, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Baguette 250g x 30 pcs
(98, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Loaf 440g x 16 pcs
(99, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cereals,Almonds,Hazelnut Loaf 365g x 30 pcs
(100, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- White Roll 40g x 160 pcs
(101, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maxi Croissant  90g x 80 pcs
(102, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maxi Pain Au Chocolat 120g x 64 pcs
(103, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Croissant 80g x 56 pcs
(104, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Raisin Whirl 96g x 60 pcs
(105, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Chocolate Chip Muffin 95g x 24 pcs
(106, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Plain Muffin with Sugar Topping 95g x 24 pcs
(107, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Croissant  25g x 160 pcs
(108, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Raisin Whirl 30g x 150 pcs
(109, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Pain Au Chocolate 25g x 160 pcs
(110, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tiramisu Layer Cake 610g x 4 pcs
(111, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Bien Croissant 4 x 20 x 50g
(112, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Choco Bien 6 x 24 x 32g
(113, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Roxy
(114, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- bence
(115, 'CTN', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');



insert into sku_products(product_id, sku, price, discount, sku_description, tenant_id) values
-- Maestrella Frozen Diced Mozarella
(1, '51004', 25000, 2.5, 'Maestrella Frozen Diced Mozzarella 2.5kg x 4', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maestrella Frozen Mozzarella Block
(2, '60001', 25000, 2.5, 'Maestrella Frozen Mozzarella Block', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maestrella Frozen Shredded Mozzarella
(3, '2183', 23500, 2.5, 'Maestrella Frozen Shredded Mozzarella 2KG X 6pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Galbani Permasan Cheese
(4, '90585', 24500, 2, 'Galbani Permasan Cheese', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Edam Cheese loaf
(5, '89368', 25500, 2, 'President Edam Cheese loaf', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Gouda Cheese loaf
(6, '89376', 24500, 2, 'President Gouda Cheese loaf', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Emmental Block Cheese
(7, '9803', 15000, 2, 'President Emmental Block Cheese', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Cream Cheese
(8, '7116', 15500, 2, 'President Cream Cheese', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mclelland Mild Red Cheddar Loaf
(9, '97335', 15000, 2, 'Mclelland Mild Red Cheddar Loaf', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mclelland Mild White Cheddar Loaf
(10, '8530', 15000, 2, 'Mclelland Mild White Cheddar Loaf', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 220g Emmental cheese x 14 pcs
(11, '49977', 15000, 2, 'President 220g Emmental cheese x 14 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President  Small Brie in Tin 125g x 12 Pcs
(12, '1349', 15000, 2, 'President Small Brie in Tin 125g x 12 Pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Small Camembert in Tin 125g x 12 Pcs
(13, '1846', 15000, 2, 'President Small Camembert in Tin 125g x 12 Pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Mild White Cheddar 200g x 8 pcs
(14, '5174', 15000, 2, 'President Small Camembert in Tin 125g x 12 Pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Cream Cheese 180g X 12 pcs
(15, '10353', 15000, 2, 'President Cream Cheese 180g X 12 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
--President 120g Processed Cheese 8 portions x 24 pcs
(16, '75599', 19000, 2.5, 'President 120g Processed Cheese 8 portions x 24 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Corn Kernels
(17, '89366', 9500, 2, 'President Edam Slices 150g x 10 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix Chicken Franks
(18, '89374', 25000, 2.5, 'President  Gouda Slices 150g x 10 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced cheddar cheese for sandwich 200g x 36 pcs
(19, '49714', 25000, 2.5, 'President 10 Sliced cheddar cheese for sandwich 200g x 36 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced emmental cheese for toast 200g x 36 pcs
(20, '49715', 25000, 2.5, 'President 10 Sliced emmental cheese for toast 200g x 36 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 10 Sliced cheddar cheese for hamburger 200g x 36 pcs
(21, '49716', 25000, 2.5, 'President 10 Sliced cheddar cheese for hamburger 200g x 36 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 1L Cream 18% (Cooking) x 6 pcs
(22, '36821', 23500, 2.5, 'President 1L Cream 18% (Cooking) x 6 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Galbani Permasan Cheese
(23, '35681', 24500, 2, 'President 250g spray Cream 20% whipped x 12 pcs ', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President Edam Cheese loaf
(24, '31243', 25500, 2, 'President 1L Cream 35.1% (whipping) x 6 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Merci Chef 200G Unsalted Butter X 40 Pcs
(25, '54008', 24500, 2, 'Merci Chef 200G Unsalted Butter X 40 Pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador 200g Salted butter mix x 40pcs
(26, '34079', 15000, 2, 'Ambassador 200g Salted butter mix x 40pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ambassador 200g Unsalted butter mix x 40pcs
(27, '33330', 15500, 2, 'Ambassador 200g Unsalted butter mix x 40pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 8g Minitubs Unsalted butter x 600 pcs
(28, '36699', 15000, 2, 'President 8g Minitubs Unsalted butter x 600 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 200g Salted Butter x 40 pcs
(29, '35196', 15000, 2, 'President 200g Salted Butter x 40 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- President 200g Unsalted Butter x 40 pcs
(30, '35165', 15000, 2, 'President 200g Unsalted Butter x 40 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Bridel 200G Unsalted Butter X 40 Pcs
(31, '32080', 15000, 2, 'Bridel 200G Unsalted Butter X 40 Pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Pineapple 4x12x125g
(32, '72659', 15000, 2, 'Lactel Fruity Pineapple 4x12x125g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Strawberry 4x12x125g
(33, '72660', 15000, 2, 'Lactel Fruity Strawberry 4x12x125g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Mango 4x12x125g
(34, '72661', 15000, 2, 'Lactel Fruity Mango 4x12x125g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Banana 4x12x125g
(35, '72663', 19000, 2.5, 'Lactel Fruity Banana 4x12x125g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Fruity Mixed Berries 4x12x125g
(36, '72669', 9500, 2, 'Lactel Fruity Mixed Berries 4x12x125g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Nature Plain 4x12x125g
(37, '72908', 25000, 2.5, 'Lactel Dessert Nature Plain 4x12x125g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Chocolate 4x12x125g
(38, '72666', 25000, 2.5, 'Lactel Dessert Chocolate 4x12x125g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Lactel Dessert Vanilla 4x12x125g
(39, '72670', 25000, 2.5, 'Lactel Dessert Vanilla 4x12x125g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Oreo 480ml x 6 pcs (Ice Cream)
(40, '8919', 25000, 2.5, 'Oreo 480ml x 6 pcs (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cadbury 480ml Caramello  x 6 pcs (Ice Cream)
(41, '8933', 23500, 2.5, 'Cadbury 480ml Caramello x 6 pcs (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L  Country Fresh Chocolate & Fudge (Ice Cream)
(42, '1541', 24500, 2, 'Dairy Maid 2L Country Fresh Chocolate & Fudge (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L Country Fresh Blueberry & Cheesecake (Ice cream)
(43, '1534', 25500, 2, 'Dairy Maid 2L Country Fresh Blueberry & Cheesecake (Ice cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L Country Fresh Choca-Cara-Nilla  (Ice Cream)
(44, '1497', 24500, 2, 'Dairy Maid 2L Country Fresh Choca-Cara-Nilla (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 2L Country Fresh Vanilla Lite (Ice Cream)
(45, '1480', 15000, 2, 'Dairy Maid 2L Country Fresh Vanilla Lite (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid Fresh Vanilla Ice Cream
(46, '1473', 15500, 2, 'Dairy Maid 2L Country Fresh Vanilla (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mclelland Mild Red Cheddar Loaf
(47, '1503', 15000, 2, 'Dairy Maid 2L Country Fresh Neapolitan (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 5L Country Fresh Vanilla (Ice Cream)
(48, '8599', 15000, 2, 'Dairy Maid 5L Country Fresh Vanilla (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 5L Country Fresh Neapolitan (Ice Cream)
(49, '8605', 15000, 2, 'Dairy Maid 5L Country Fresh Neapolitan (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 500ml Country Fresh Vanilla (Ice Cream)
(50, '1572', 15000, 2, 'Dairy Maid 500ml Country Fresh Vanilla (Ice Cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Dairy Maid 500ml Country Fresh Blueberry & Cheesecake (Ice cream)
(51, '1565', 15000, 2, 'Dairy Maid 500ml Country Fresh Blueberry & Cheesecake (Ice cream)', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Danica Non Dairy Cooking Cream 25% 1LX12
(52, '120', 19000, 2.5, 'Danica Non Dairy Cooking Cream 25% 1LX12', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Danica Non Dairy Whipping Cream Sweet 27% 1LX12
(53, '118', 9500, 2, 'Danica Non Dairy Whipping Cream Sweet 27% 1LX12', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Rich's Bettercreme Chocolate flavoured 9 x 2kg
(54, '8495', 25000, 2.5, 'Rich''s Bettercreme Chocolate flavoured 9 x 2kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Rich's Bettercream Strawbery flavoured 9 x 2kg
(55, '8507', 25000, 2.5, 'Rich''s Bettercream Strawbery flavoured 9 x 2kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maestrella Frozen Diced Mozarella
(56, '8500', 25000, 2.5, 'Rich''s Bettercream Vanilla flavoured 9 x 2kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mity Fresh Mixed Vegetables 400g x 20 pcs
(57, '9297', 15000, 2, 'Mity Fresh Mixed Vegetables 400g x 20 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mity Fresh Green Peas 400g x 20 pcs
(58, '9310', 15000, 2, 'Mity Fresh Green Peas 400g x 20 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 2.5Kg French fries x 4 pcs
(59, '8042', 19000, 2.5, 'Golden Phoenix 2.5Kg French fries x 4 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 1kg French Fries X 10pcs
(60, '8585', 9500, 2, 'Golden Phoenix 1kg French Fries X 10pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Mixed Vegetables 12 x500g
(61, '6236', 24500, 2, 'McCain Mixed Vegetables 12 x500g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Peas 24 x 500g
(62, '6014', 25500, 2, 'McCain Peas 24 x 500g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Corn Kernels 12 x 500g
(63, '6403', 24500, 2, 'McCain Corn Kernels 12 x 500g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Winter Vegetables 12 x 500g
(64, '5669', 15000, 2, 'McCain Winter Vegetables 12 x 500g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Seasoned Wedges 12 x 750g
(65, '9265', 15500, 2, 'McCain Seasoned Wedges 12 x 750g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Tradition French Fries 16 x 750g
(66, '4227', 15000, 2, 'McCain Tradition French Fries 16 x 750g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Tradition French Fries 8 x 1.5kg
(67, '4241', 15000, 2, 'McCain Tradition French Fries 8 x 1.5kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Original 6/6 French Fries 5 x 2.5kg
(68, '8856', 15000, 2, 'McCain Original 6/6 French Fries 5 x 2.5kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- McCain Original 9/9 French Fries 5 x 2.5kg
(69, '8849', 15000, 2, 'McCain Original 9/9 French Fries 5 x 2.5kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 200g x 25 pcs
(70, '9403', 15000, 2, 'Sympli Straight Cut Yam Fries 200g x 25 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 500g x 10 pcs
(71, '9434', 15000, 2, 'Sympli Straight Cut Yam Fries 500g x 10 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Straight Cut Yam Fries 2.5kg x 4 pcs
(72, '9441', 15000, 2, 'Sympli Straight Cut Yam Fries 2.5kg x 4 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 200g x 25 pcs
(73, '9458', 19000, 2.5, 'Sympli Thick Cut Yam Chip 200g x 25 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 500g x 10 pcs
(74, '9410', 9500, 2, 'Sympli Thick Cut Yam Chip 500g x 10 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Thick Cut Yam Chip 2.5kg x 4 pcs
(75, '9427', 25000, 2.5, 'Sympli Thick Cut Yam Chip 2.5kg x 4 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Sympli Ripe Plantain Chops 2.5kg x 4 pcs
(76, '9465', 25000, 2.5, 'Sympli Ripe Plantain Chops 2.5kg x 4 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 1Kg fish fillet x 10 pcs
(77, '578', 25000, 2.5, 'Golden Phoenix 1Kg fish fillet x 10 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 400g Large Shrimp x  10 pcs
(78, '4019', 25000, 2.5, 'Golden Phoenix 400g Large Shrimp x  10 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 400g Jumbo Shrimp x  10 pcs
(79, '4002', 23500, 2.5, 'Golden Phoenix 400g Jumbo Shrimp x  10 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower African Mix Fish 1kg x 8 pcs
(80, '9510', 24500, 2, 'Ocean Flower African Mix Fish 1kg x 8 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Tilapia Fish 1.3kg x 8 pcs
(81, '9480', 25500, 2, 'Ocean Flower Tilapia Fish 1.3kg x 8 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Sole Pan Ready 1kg x 8 pcs
(82, '9596', 24500, 2, 'Ocean Flower Sole Pan Ready 1kg x 8 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Crab Whole 1kg x 8 pcs
(83, '9572', 15000, 2, 'Ocean Flower Crab Whole 1kg x 8 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Seafood Mix 400g x 12 pcs
(84, '9558', 15500, 2, 'Ocean Flower Seafood Mix 400g x 12 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Octopus Flower Gutted 1kg x 8 pcs
(85, '9589', 15000, 2, 'Ocean Flower Octopus Flower Gutted 1kg x 8 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Crab Cluster 1kg x 6 pcs
(86, '9565', 15000, 2, 'Ocean Flower Crab Cluster 1kg x 6 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower PUD Medium Shrimps 400g x 12 pcs
(87, '9411', 15000, 2, 'Ocean Flower PUD Medium Shrimps 400g x 12 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower PUD Small Shrimps 400g x 12 pcs
(88, '9466', 15000, 2, 'Ocean Flower PUD Small Shrimps 400g x 12 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Ocean Flower Headless Small Shrimps 400g x 12 pcs
(89, '9435', 15000, 2, 'Ocean Flower Headless Small Shrimps 400g x 12 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Golden Phoenix 340g Chicken Franks x 24 pcs
(90, '9183', 15000, 2, 'Golden Phoenix 340g Chicken Franks x 24 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Seara Chicken Franks 340g x 24 pcs
(91, '38300', 15000, 2, 'Seara Chicken Franks 340g x 24 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Streaky Bacon 1kg
(92, '3261', 19000, 2.5, 'Tulip Sliced Streaky Bacon 1kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Back Bacon 1kg
(93, '2808', 9500, 2, 'Tulip Sliced Back Bacon 1kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Streaky Bacon 150g x 15 pcs
(94, '6957', 25000, 2.5, 'Tulip Sliced Streaky Bacon 150g x 15 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Danish Salami
(95, '6901', 25000, 2.5, 'Tulip Danish Salami ', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tulip Sliced Pepperoni 1kg
(96, '6145', 25000, 2.5, 'Tulip Sliced Pepperoni 1kg', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- White Baguette 225g x 38 pcs
(97, '6969', 25000, 2.5, 'White Baguette 225g x 38 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Baguette 250g x 30 pcs
(98, '506', 25000, 2.5, 'Multicereal Baguette 250g x 30 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Loaf 440g x 16 pcs
(99, '678', 25000, 2.5, 'Multicereal Loaf 440g x 16 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Cereals,Almonds,Hazelnut Loaf 365g x 30 pcs
(100, '78006', 25000, 2.5, 'Cereals,Almonds,Hazelnut Loaf 365g x 30 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- White Roll 40g x 160 pcs
(101, '695', 23500, 2.5, 'White Roll 40g x 160 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maxi Croissant  90g x 80 pcs
(102, '3101', 24500, 2, 'Maxi Croissant  90g x 80 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Maxi Pain Au Chocolat 120g x 64 pcs
(103, '3105', 25500, 2, 'Maxi Pain Au Chocolat 120g x 64 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Multicereal Croissant 80g x 56 pcs
(104, '7095', 24500, 2, 'Multicereal Croissant 80g x 56 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Raisin Whirl 96g x 60 pcs
(105, '852', 15000, 2, 'Raisin Whirl 96g x 60 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Chocolate Chip Muffin 95g x 24 pcs
(106, '78829', 15500, 2, 'Chocolate Chip Muffin 95g x 24 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Plain Muffin with Sugar Topping 95g x 24 pcs
(107, '78830', 15000, 2, 'Plain Muffin with Sugar Topping 95g x 24 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Croissant  25g x 160 pcs
(108, '3189', 15000, 2, 'Mini Croissant  25g x 160 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Raisin Whirl 30g x 150 pcs
(109, '3120', 15000, 2, 'Mini Raisin Whirl 30g x 150 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Mini Pain Au Chocolate 25g x 160 pcs
(110, '3255', 15000, 2, 'Mini Pain Au Chocolate 25g x 160 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Tiramisu Layer Cake 610g x 4 pcs
(111, '75643', 15000, 2, 'Tiramisu Layer Cake 610g x 4 pcs', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Bien Croissant 4 x 20 x 50g
(112, '3415', 15000, 2, 'Bien Croissant 4 x 20 x 50g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),

-- Choco Bien 6 x 24 x 32g
(113, '4210', 15000, 2, 'Choco Bien 6 x 24 x 32g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Roxy 6 x 24 x 40g
(114, '4043', 19000, 2.5, 'Roxy 6 x 24 x 40g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e'),
-- Bence 6 x 24 x 40g
(115, '4027', 9500, 2, 'Bence 6 x 24 x 40g', '65b5dd14-ef71-11ea-8db0-0a195e8ca79e');




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
(19,19),
(20,20),
(21,21),
(22,22),
(23,23),
(24,24),
(25,25),
(26,26),
(27,27),
(28,28),
(29,29),
(30,30),
(31,31),
(32,32),
(33,33),
(34,34),
(35,35),
(36,36),
(37,37),
(38,38),
(39,39),
(40,40),
(41,41),
(42,42),
(43,43),
(44,44),
(45,45),
(46,46),
(47,47),
(48,48),
(49,49),
(50,50),
(51,51),
(52,52),
(53,53),
(54,54),
(55,55),
(56,56),
(57,57),
(58,58),
(59,59),
(60,60),
(61,61),
(62,62),
(63,63),
(64,64),
(65,65),
(66,66),
(67,67),
(68,68),
(69,69),
(70,70),
(71,71),
(72,72),
(73,73),
(74,74),
(75,75),
(76,76),
(77,77),
(78,78),
(79,79),
(80,80),
(81,81),
(82,82),
(83,83),
(84,84),
(85,85),
(86,86),
(87,87),
(88,88),
(89,89),
(90,90),
(91,91),
(92,92),
(93,93),
(94,94),
(95,95),
(96,96),
(97,97),
(98,98),
(99,99),
(100,100),
(101,101),
(102,102),
(103,103),
(104,104),
(105,105),
(106,106),
(107,107),
(108,108),
(109,109),
(110,110),
(111,111),
(112,112),
(113,113),
(114,114),
(115,115);


insert into images (imagepath) values
('assets/images/products/1.jpg'),
('assets/images/products/2.jpg'),
('assets/images/products/3.jpg'),
('assets/images/products/4.jpg'),
('assets/images/products/5.jpg'),
('assets/images/products/6.jpg'),
('assets/images/products/7.jpg'),
('assets/images/products/8.jpg'),
('assets/images/products/9.jpg'),
('assets/images/products/10.jpg'),
('assets/images/products/11.jpg'),
('assets/images/products/12.jpg'),
('assets/images/products/13.jpg'),
('assets/images/products/14.jpg'),
('assets/images/products/15.jpg'),
('assets/images/products/16.jpg'),
('assets/images/products/17.jpg'),
('assets/images/products/18.jpg'),
('assets/images/products/19.jpg'),
('assets/images/products/20.jpg'),
('assets/images/products/21.jpg'),
('assets/images/products/22.jpg'),
('assets/images/products/23.jpg'),
('assets/images/products/24.jpg'),
('assets/images/products/25.jpg'),
('assets/images/products/26.jpg'),
('assets/images/products/27.jpg'),
('assets/images/products/28.jpg'),
('assets/images/products/29.jpg'),
('assets/images/products/30.jpg'),
('assets/images/products/31.jpg'),
('assets/images/products/32.jpg'),
('assets/images/products/33.jpg'),
('assets/images/products/34.jpg'),
('assets/images/products/35.jpg'),
('assets/images/products/36.jpg'),
('assets/images/products/37.jpg'),
('assets/images/products/38.jpg'),
('assets/images/products/39.jpg'),
('assets/images/products/40.jpg'),
('assets/images/products/41.jpg'),
('assets/images/products/42.jpg'),
('assets/images/products/43.jpg'),
('assets/images/products/44.jpg'),
('assets/images/products/45.jpg'),
('assets/images/products/46.jpg'),
('assets/images/products/47.jpg'),
('assets/images/products/48.jpg'),
('assets/images/products/49.jpg'),
('assets/images/products/50.jpg'),
('assets/images/products/51.jpg'),
('assets/images/products/52.jpg'),
('assets/images/products/53.jpg'),
('assets/images/products/54.jpg'),
('assets/images/products/55.jpg'),
('assets/images/products/56.jpg'),
('assets/images/products/57.jpg'),
('assets/images/products/58.jpg'),
('assets/images/products/59.jpg'),
('assets/images/products/60.jpg'),
('assets/images/products/61.jpg'),
('assets/images/products/62.jpg'),
('assets/images/products/63.jpg'),
('assets/images/products/64.jpg'),
('assets/images/products/65.jpg'),
('assets/images/products/66.jpg'),
('assets/images/products/67.jpg'),
('assets/images/products/68.jpg'),
('assets/images/products/69.jpg'),
('assets/images/products/70.jpg'),
('assets/images/products/71.jpg'),
('assets/images/products/72.jpg'),
('assets/images/products/73.jpg'),
('assets/images/products/74.jpg'),
('assets/images/products/75.jpg'),
('assets/images/products/76.jpg'),
('assets/images/products/77.jpg'),
('assets/images/products/78.jpg'),
('assets/images/products/79.jpg'),
('assets/images/products/80.jpg'),
('assets/images/products/81.jpg'),
('assets/images/products/82.jpg'),
('assets/images/products/83.jpg'),
('assets/images/products/84.jpg'),
('assets/images/products/85.jpg'),
('assets/images/products/86.jpg'),
('assets/images/products/87.jpg'),
('assets/images/products/88.jpg'),
('assets/images/products/89.jpg'),
('assets/images/products/90.jpg'),
('assets/images/products/91.jpg'),
('assets/images/products/92.jpg'),
('assets/images/products/93.jpg'),
('assets/images/products/94.jpg'),
('assets/images/products/95.jpg'),
('assets/images/products/96.jpg'),
('assets/images/products/97.jpg'),
('assets/images/products/98.jpg'),
('assets/images/products/99.jpg'),
('assets/images/products/100.jpg'),
('assets/images/products/101.jpg'),
('assets/images/products/102.jpg'),
('assets/images/products/103.jpg'),
('assets/images/products/104.jpg'),
('assets/images/products/105.jpg'),
('assets/images/products/106.jpg'),
('assets/images/products/107.jpg'),
('assets/images/products/108.jpg'),
('assets/images/products/109.jpg'),
('assets/images/products/110.jpg'),
('assets/images/products/111.jpg'),
('assets/images/products/112.jpg'),
('assets/images/products/113.jpg'),
('assets/images/products/114.jpg'),
('assets/images/products/115.jpg');

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
(11,11),
(12,12),
(13,13),
(14,14),
(15,15),
(16,16),
(17,17),
(18,18),
(19,19),
(20,20),
(21,21),
(22,22),
(23,23),
(24,24),
(25,25),
(26,26),
(27,27),
(28,28),
(29,29),
(30,30),
(31,31),
(32,32),
(33,33),
(34,34),
(35,35),
(36,36),
(37,37),
(38,38),
(39,39),
(40,40),
(41,41),
(42,42),
(43,43),
(44,44),
(45,45),
(46,46),
(47,47),
(48,48),
(49,49),
(50,50),
(51,51),
(52,52),
(53,53),
(54,54),
(55,55),
(56,56),
(57,57),
(58,58),
(59,59),
(60,60),
(61,61),
(62,62),
(63,63),
(64,64),
(65,65),
(66,66),
(67,67),
(69,69),
(70,70),
(71,71),
(72,72),
(73,73),
(74,74),
(75,75),
(76,76),
(77,77),
(78,78),
(79,79),
(80,80),
(81,81),
(82,82),
(83,83),
(84,84),
(85,85),
(86,86),
(87,87),
(88,88),
(89,89),
(90,90),
(91,91),
(92,92),
(93,93),
(94,94),
(95,95),
(96,96),
(97,97),
(98,98),
(99,99),
(100,100),
(101,101),
(102,102),
(103,103),
(104,104),
(105,105),
(106,106),
(107,107),
(108,108),
(109,109),
(110,110),
(111,111),
(112,112),
(113,113),
(114,114),
(115,115);

insert into wishlist_status(id, name) values
(1, 'Open'),
(2, 'Converted'),
(3, 'Deleted');

insert into tags(tagname) values
('butter'),
('ice-cream'),
('cheese'),
('mozzarella'),
('diced'),
('frozen'),
('shredded'),
('parmesan'),
('cream'),
('spreadable'),
('salted'),
('salt'),
('unsalted'),
('slight salt'),
('chips'),
('fries'),
('french fries'),
('potato chips'),
('potato fries'),
('chicken'),
('meat');

insert into product_tags(product_id, tag_id) values
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 3),
(2, 4),
(2, 6),
(3, 3),
(3, 6),
(3, 7),
(4, 3),
(4, 8);



















