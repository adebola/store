package io.factorialsystems.store.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WishList {
    Integer id;
    Integer user_id;
    Integer sku_id;
    Integer status_id;
    String name;
    String description;
    Double price;
    Double discount;
   String imagepath;
}
