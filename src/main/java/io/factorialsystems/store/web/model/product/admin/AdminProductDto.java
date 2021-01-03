package io.factorialsystems.store.web.model.product.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminProductDto {
    private Integer productId;
    private String name;
    private String category;
    private Integer categoryId;
    private String brand;

    private Set<String> tags;
    private Set<AdminProductBundleDto> bundles;
}
