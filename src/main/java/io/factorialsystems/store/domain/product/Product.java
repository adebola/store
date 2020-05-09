package io.factorialsystems.store.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Category category;
    private Date createdDate;
    private Date lastModifiedDate;
    private String tenantId;

    private List<ProductVariant> variants;
}
