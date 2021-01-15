package io.factorialsystems.store.web.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreProductBundleDto {
    private Integer id;
    private String sku;
    private Integer stock;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private Boolean isNew;
    private Boolean onSale;
    private Boolean vatExclusive;
    private List<String> imagePath;
    private Set<StoreProductBundleVariantDto> variantOptions;
}
