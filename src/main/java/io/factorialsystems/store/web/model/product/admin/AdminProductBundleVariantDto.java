package io.factorialsystems.store.web.model.product.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminProductBundleVariantDto {

    private Integer id;

    @NotBlank
    private String variantName;

    @NotBlank
    private String variantOption;
}
