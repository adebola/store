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
    Integer id;
    String name;
    String description;
    String brand;
    Boolean isNew;
    Boolean onSale;

    Set<String> images;
    Set<StoreProductBundleDto> bundles;
}
