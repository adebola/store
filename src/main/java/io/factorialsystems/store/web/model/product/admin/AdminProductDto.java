package io.factorialsystems.store.web.model.product.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminProductDto {

    @Null
    private Integer productId;

    @NotBlank
    private String name;

    private String category;

    @NotNull
    private Integer categoryId;

    @NotBlank
    private String brand;

    @NotNull
    private Set<AdminProductBundleDto> bundles;
}
