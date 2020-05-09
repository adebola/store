create table tenants (
    id varchar(64) NOT NULL,
    name varchar(64) NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

create table roles (
    id int(11) AUTO_INCREMENT,
    name varchar(24) NOT NULL,
    tenant_id varchar(64) NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY (id),
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastMoModifiedAt timestamp DEFAULT NULL,
    UNIQUE KEY idx_name_tenant(name, tenant_id)
);

create table users (
    id int(11) AUTO_INCREMENT,
    username varchar(64) NOT NULL,
    email varchar(64) NOT NULL,
    password varchar(64) NOT NULL,
    tenant_id varchar(64) NOT NULL,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastMoModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY(id),
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
    lastMoModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY(id),
    UNIQUE KEY idx_name_tenant(name, tenant_id)
);

create table products (
    id int(11) AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    category_id int(11) NOT NULL,
    tenant_id varchar(64) NOT NULL,
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastMoModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY(id),
    UNIQUE KEY idx_name_tenant(name, tenant_id)
);

create table product_variants (
    id int(11) AUTO_INCREMENT,
    product_id int(11) NOT NULL,
    name varchar(64),
    tenant_id varchar(64),
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastMoModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY (id),
    UNIQUE KEY idx_product_name_tenant(product_id, name, tenant_id)
);

create table product_variant_options (
    id int(11) AUTO_INCREMENT,
    product_variant_id int(11) NOT NULL,
    name varchar(64),
    tenant_id varchar(64),
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastMoModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (product_variant_id) REFERENCES product_variants(id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY (id),
    UNIQUE KEY idx_product_variant_id_name_tenant_id(product_variant_id, name, tenant_id)
);

create table sku (
    id int(11) AUTO_INCREMENT,
    product_variant_option_id int(11) NOT NULL,
    sku varchar(32) NOT NULL,
    price decimal(13,2),
    tenant_id varchar(64),
    createdAt timestamp DEFAULT CURRENT_TIMESTAMP,
    lastMoModifiedAt timestamp DEFAULT NULL,
    FOREIGN KEY (product_variant_option_id) REFERENCES product_variant_options (id),
    FOREIGN KEY (tenant_id) REFERENCES tenants(id),
    PRIMARY KEY (id)
--      UNIQUE KEY idx_product_id(product_id)
);

create table sku_product_variant_options (
    sku_id int(11) NOT NULL,
    product_variant_id int(11) NOT NULL,
    product_variant_option_id int(11) NOT NULL,
    FOREIGN KEY (sku_id) REFERENCES sku(id),
    FOREIGN KEY (product_variant_id) REFERENCES product_variants(id),
    FOREIGN KEY (product_variant_option_id) REFERENCES product_variant_options(id)
);
