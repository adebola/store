package io.factorialsystems.store.web.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreProductDto {
    Integer productId;
    String name;
    String category;
    String brand;

    Set<String> tags;
    Set<StoreProductBundleDto> bundles;
}
