package io.factorialsystems.store.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {
    private Integer id;
    private String name;
    private Integer productId;
    private Date createdDate;
    private Date lastModifiedDate;
    private String tenantId;

    private List<ProductVariantOption> variantOptions;
}
