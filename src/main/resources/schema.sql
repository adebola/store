create table tenants (
    id varchar(64) NOT NULL,
    organization varchar(64) NOT NULL,
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
    address varchar(64),
    tenant_id varchar(64) NOT NULL,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    UNIQUE KEY idx_username_tenant(username, tenant_id),
    UNIQUE KEY idx_email_tenant(email, tenant_id)
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
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    UNIQUE KEY idx_name_tenant(name, tenant_id)
);

create table products (
    id int(11) AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    description varchar(256) NOT NULL,
    brand varchar(64),
    category_id int(11) NOT NULL,
    tenant_id varchar(64) NOT NULL,
    new boolean NOT NULL DEFAULT TRUE,
    sale boolean NOT NULL DEFAULT FALSE,
    discontinued boolean NOT NULL DEFAULT FALSE,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastModifiedAt timestamp DEFAULT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    FOREIGN KEY (category_id) REFERENCES categories(id),
    UNIQUE KEY idx_name_tenant(name, tenant_id)
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
    discontinued boolean NOT NULL DEFAULT FALSE,
    stocklevel int(11) NOT NULL DEFAULT 0,
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
    imagepath varchar(64) NOT NULL,
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

create table product_images (
  product_id int(11) NOT NULL,
  image_id int(11) NOT NULL,
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (image_id) REFERENCES images(id),
  UNIQUE KEY idx_product_image (product_id, image_id)
);
