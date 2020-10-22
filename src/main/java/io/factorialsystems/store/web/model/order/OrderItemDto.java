package io.factorialsystems.store.web.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto {
    @Null
    Integer id;

    @Null
    Integer order_id;

    Integer sku_id;

    @Null
    String image_path;

    @Null
    String product_name;

    Integer quantity;
    Double unit_price;
    Double discount;
    Double total_price;
}
