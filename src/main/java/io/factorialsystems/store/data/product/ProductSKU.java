package io.factorialsystems.store.data.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSKU {
    Integer id;
    String sku;
    Integer productId;
    Integer stock;
    BigDecimal price;
    BigDecimal discount;
    String name;
    String category;
    String imagePath;
    String description;
    String brand;
    Boolean isNew;
    Boolean onSale;
    Boolean vatExclusive;
    String variant;
    String variantOption;
}
