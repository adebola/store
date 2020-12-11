package io.factorialsystems.store.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    Integer id;
    Integer user_id;
    Date orderedAt;
    Double orderAmount;
    String paymentRef;
    String transaction_id;
    String pin;
    Boolean pickup;
    Boolean deliver;
    String full_name;
    String email;
    String telephone;
    String address;
    String tenant_id;

    List<OrderItem> orderItems;
}
