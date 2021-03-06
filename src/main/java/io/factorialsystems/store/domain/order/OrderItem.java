package io.factorialsystems.store.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    Integer id;
    Integer order_id;
    Integer sku_id;
    String uom;
    String item_code;
    String image_path;
    String product_name;
    Integer quantity;
    Double unit_price;
    Double discount;
    Double vat_price;
    Double total_price;
}
