package io.factorialsystems.store.web.model.product.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminProductBundleDto {

    @Null
    private Integer id;

    @NotBlank
    private String sku;

    @NotNull
    private BigDecimal price;

    @NotNull
    private BigDecimal discount;

    @NotBlank
    private String description;

    @NotNull
    private Integer quantity;

    @NotNull
    private Boolean isNew;

    @NotNull
    private Boolean onSale;

    @NotNull
    private List<String> imagePath;

    @NotNull
    private Set<AdminProductBundleVariantDto> variantOptions;
}
