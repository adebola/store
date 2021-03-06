package io.factorialsystems.store.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String brand;
    private String description;
    private Integer categoryId;
    private String categoryName;
    private Date createdDate;
    private Date lastModifiedDate;
    private String tenantId;

//    private List<ProductVariant> variants;
//
//    public void addVariant(ProductVariant pv) {
//        if (pv != null) {
//            if (variants == null) {
//                variants = new ArrayList<>();
//            }
//
//            variants.add(pv);
//        }
//    }
}
