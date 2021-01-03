package io.factorialsystems.store.web.model.product.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminProductBundleVariantDto {
    private String variantName;
    private String variantOption;
}
