package io.factorialsystems.store.web.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    @Null
    Integer id;

    Integer user_id;
    String full_name;

    @Email
    String email;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime orderedAt;

    String paymentRef;
    String transaction_id;

    Double orderAmount;

    Boolean pickup;
    Boolean deliver;

    String telephone;
    String address;

    List<OrderItemDto> orderItems;
}