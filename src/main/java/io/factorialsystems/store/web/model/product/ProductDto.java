package io.factorialsystems.store.web.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    @Null(message = "This Value cannot be set and will be generated in the Database")
    private Integer id;

    @NotBlank(message = "Product Name cannot be Blank")
    private String name;

    @NotNull
    private CategoryDto category;

    @Null(message = "Created Date cannot be set")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null(message = "LastModified Date cannt be set")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;

    // Values May or May not be set depending on the circumstances
    private List<ProductVariantDto> variants;
}
