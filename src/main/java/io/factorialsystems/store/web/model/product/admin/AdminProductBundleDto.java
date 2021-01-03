package io.factorialsystems.store.web.model.product.admin;

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
public class AdminProductBundleDto {
    private Integer id;
    private String sku;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private Integer quantity;
    private Boolean isNew;
    private Boolean onSale;
    private List<String> imagePath;
    private Set<AdminProductBundleVariantDto> variantOptions;
}
