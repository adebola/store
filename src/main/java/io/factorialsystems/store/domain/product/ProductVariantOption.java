package io.factorialsystems.store.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantOption {
    private Integer id;
    private String name;
    private Integer productVariantId;
    private Date createdDate;
    private Date lastModifiedDate;
    private String tenantId;
}
