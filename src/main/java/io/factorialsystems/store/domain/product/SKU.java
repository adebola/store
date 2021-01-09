package io.factorialsystems.store.domain.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SKU {
    private Integer id;
    private Integer productId;
    private String sku;
    private String description;
    private BigDecimal price;
    private BigDecimal discount;
    private Integer quantity;
    private Boolean isNew;
    private Boolean onSale;
    private Boolean discontinued;
    private Boolean vatExclusive;
    private String tenantId;
}
