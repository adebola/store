package io.factorialsystems.store.web.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishListDto {

    @Null
    Integer id;

    @NotNull
    Integer user_id;

    @NotNull
    Integer sku_id;

    Integer status_id;

    @Null
    String name;

    @Null
    String description;

    @Null
    Double price;

    @Null
    Double discount;

    @Null
    String imagepath;
}
