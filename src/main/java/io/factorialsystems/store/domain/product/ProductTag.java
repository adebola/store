package io.factorialsystems.store.domain.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class ProductTag {
    @Null
    private Integer id;

    @NotNull
    private Integer productId;

    @NotBlank
    private String tagName;
}
