
drop table sku_product_variant_options;
drop table sku_images;
drop table orderitems;
drop table wishlist;
drop table sku_products;
drop table product_variant_options;
drop table product_variants;
drop table product_tags;
drop table orders;
drop table comments;
drop table posts;
drop table products;
drop table categories;
drop table user_roles;
drop table images;
drop table tags;
drop table address;
drop table user_activation;
drop table password_reset_request;
drop table users;
drop table roles;
drop table tenants;
drop table wishlist_status;

create table tenants (
    id varchar(64) NOT NULL,
    organization varchar(64) NOT NULL,
    email varchar(64) NOT NULL,
    logo_url varchar(256) NOT NULL,
    base_url varchar(256) NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

create table roles (
    id int(11) AUTO_INCREMENT,
    name varchar(24) NOT NULL,
    tenant_id varchar(64) NOT NULL,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    UNIQUE KEY idx_name_tenant(name, tenant_id)
);

create table users (
    id int(11) AUTO_INCREMENT,
    username varchar(64) NOT NULL,
    email varchar(64) NOT NULL,
    password varchar(64) NOT NULL,
    fullname varchar(64) NOT NULL,
    telephone varchar(64),
    organization varchar(64),
    activated boolean NOT NULL DEFAULT FALSE,
    tenant_id varchar(64) NOT NULL,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    UNIQUE KEY idx_username_tenant(username, tenant_id),
    UNIQUE KEY idx_email_tenant(email, tenant_id)
);

create table user_activation (
    id varchar(64) NOT NULL,
    user_id int (11) NOT NULL,
    createdAt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    closedAt timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

create table address (
    id int (11) AUTO_INCREMENT,
    user_id int (11) NOT NULL,
    address varchar (256) NOT NULL,
    is_default boolean NOT NULL DEFAULT FALSE,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

create table user_roles (
    user_id int(11) NOT NULL,
    role_id int(11) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

create table categories (
    id int(11) AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    tenant_id varchar(64) NOT NULL,
    parent_category_id int (11) DEFAULT NULL,
    image_url varchar(512) NOT NULL,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    UNIQUE KEY idx_name_tenant(name, tenant_id)
);

alter table categories add foreign key (parent_category_id) references categories(id);

create table products (
    id int(11) AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    description varchar(256) DEFAULT NULL,
    brand varchar(64),
    category_id int(11) NOT NULL,
    discontinued boolean NOT NULL DEFAULT FALSE,
    tenant_id varchar(64) NOT NULL,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

create table product_variants (
    id int(11) AUTO_INCREMENT,
    product_id int(11) NOT NULL,
    name varchar(64),
    tenant_id varchar(64),
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    UNIQUE KEY idx_product_name_tenant(product_id, name, tenant_id)
);

create table product_variant_options (
    id int(11) AUTO_INCREMENT,
    product_variant_id int(11) NOT NULL,
    name varchar(64),
    tenant_id varchar(64),
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_variant_id) REFERENCES product_variants(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    UNIQUE KEY idx_product_variant_id_name_tenant_id(product_variant_id, name, tenant_id)
);

create table sku_products (
    id int(11) AUTO_INCREMENT,
    product_id int(11) NOT NULL,
    sku varchar(32) NOT NULL UNIQUE,
    price decimal(13,2),
    discount decimal (13,2) NOT NULL DEFAULT 0,
    sku_description varchar(256) DEFAULT NULL,
    discontinued boolean NOT NULL DEFAULT FALSE,
    vat_exclusive boolean NOT NULL DEFAULT FALSE,
    quantity int(11) NOT NULL DEFAULT 0,
    new boolean NOT NULL DEFAULT TRUE,
    sale boolean NOT NULL DEFAULT FALSE,
    tenant_id varchar(64),
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY (id)
);

create table sku_product_variant_options (
    sku_id int(11) NOT NULL,
    product_variant_option_id int(11) NOT NULL,
    FOREIGN KEY (sku_id) REFERENCES sku_products(id),
    FOREIGN KEY (product_variant_option_id) REFERENCES product_variant_options(id),
    UNIQUE KEY idx_sku_product_variant(sku_id, product_variant_option_id)
);

create table images (
    id int(11) AUTO_INCREMENT,
    imagepath varchar(512) NOT NULL,
    PRIMARY KEY (id)
);

create table tags (
    id int(11) AUTO_INCREMENT,
    tagname varchar(64) NOT NULL,
    PRIMARY KEY (id)
);

create table product_tags (
    product_id int(11) NOT NULL,
    tag_id int(11) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (tag_id) REFERENCES tags(id),
    UNIQUE KEY idx_product_tag (product_id, tag_id)
);

create table sku_images (
  sku_id int(11) NOT NULL,
  image_id int(11) NOT NULL,
  FOREIGN KEY (sku_id) REFERENCES sku_products(id),
  FOREIGN KEY (image_id) REFERENCES images(id),
  UNIQUE KEY idx_product_image (sku_id, image_id)
);

create table posts (
    id int(11) AUTO_INCREMENT,
    title varchar(256) NOT NULL,
    content TEXT NOT NULL,
    user_id int(11) NOT NULL,
    product_id int(11) NOT NULL,
    tenant_id varchar(64) NOT NULL,
    likes int DEFAULT 0,
    dislikes int DEFAULT 0,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY (id)
);

create table comments(
  id int(11) AUTO_INCREMENT,
  content TEXT NOT NULL,
  user_id int(11) NOT NULL,
  post_id int(11) NOT NULL,
  createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
  lastModifiedAt timestamp DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (post_id) REFERENCES posts(id),
  PRIMARY KEY (id)
);

create table orders(
    id int(11) AUTO_INCREMENT,
    user_id int(11),
    order_date timestamp DEFAULT CURRENT_TIMESTAMP,
    fulfill_date timestamp,
    order_amount decimal(10, 2) DEFAULT 0,
    payment_ref  varchar(16),
    transaction_id varchar(16),
    pin varchar(16) NOT NULL,
    pickup boolean NOT NULL DEFAULT TRUE,
    deliver boolean NOT NULL DEFAULT TRUE,
    full_name varchar(64),
    email varchar(64),
    telephone varchar(32),
    address varchar(256),
    tenant_id varchar(64) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY (id)
);

create table orderitems(
    id int(11) AUTO_INCREMENT,
    order_id int(11) NOT NULL,
    sku_id int(11) NOT NULL,
    quantity int(11) DEFAULT 1,
    unit_price decimal(10, 2) NOT NULL,
    vat_price decimal(10, 2) DEFAULT 0,
    discount decimal(10, 2) DEFAULT 0,
    total_price decimal(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (sku_id) REFERENCES sku_products(id),
    PRIMARY KEY (id)
);

create table wishlist_status(
    id int(11),
    name varchar(16) NOT NULL,
    PRIMARY KEY (id)
);

create table wishlist(
    id int(11) AUTO_INCREMENT,
    user_id int(11) NOT NULL,
    sku_id int(11) NOT NULL,
    status_id int(11) NOT NULL DEFAULT 1,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (sku_id) REFERENCES sku_products(id),
    FOREIGN KEY (status_id) REFERENCES wishlist_status(id),
    PRIMARY KEY (id)
);

create table password_reset_request(
    id int(11) AUTO_INCREMENT,
    uuid varchar(64) NOT NULL UNIQUE,
    user_id int(11) NOT NULL,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    PRIMARY KEY (id)
);
