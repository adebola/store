package io.factorialsystems.store.data.product;


import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProductAdminSKU {
    private Integer id;
    private String sku;
    private Integer productId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal discount;
    private String name;
    private String category;
    private Integer categoryId;
    private String imagePath;
    private String description;
    private String brand;
    private Boolean isNew;
    private Boolean onSale;
    private Integer variantOptionId;
    private String variant;
    private String variantOption;
}
