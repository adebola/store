package io.factorialsystems.store.domain.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSKU {
    Integer sku;
    Integer productId;
    BigDecimal price;
    String name;
    String imagePath;
    String description;
    String brand;
    Boolean isNew;
    Boolean onSale;
    String variant;
    String variant_options;
}
