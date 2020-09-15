package io.factorialsystems.store.web.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreProductBundleVariantDto {
    private String variantName;
    private String variantOption;
}
