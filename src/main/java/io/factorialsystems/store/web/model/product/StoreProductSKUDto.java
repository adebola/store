package io.factorialsystems.store.web.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreProductSKUDto {
    Integer productId;
    String name;
    String category;
    String brand;
    Integer id;
    String sku;
    BigDecimal price;
    BigDecimal discount;
    Boolean isNew;
    Boolean sale;
    String color;
    String description;
    String size;
    List<String> images;
}
