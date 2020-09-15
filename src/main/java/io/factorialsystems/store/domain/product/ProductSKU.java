package io.factorialsystems.store.domain.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSKU {
    Integer id;
    String sku;
    Integer productId;
    BigDecimal price;
    BigDecimal discount;
    String name;
    String category;
    String imagePath;
    String description;
    String brand;
    Boolean isNew;
    Boolean onSale;
    String variant;
    String variantOption;
}
