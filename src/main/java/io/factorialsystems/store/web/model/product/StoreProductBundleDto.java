package io.factorialsystems.store.web.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreProductBundleDto {
    private Integer id;
    private BigDecimal price;
    private Set<StoreProductBundleVariantDto> variantOptions;
}
