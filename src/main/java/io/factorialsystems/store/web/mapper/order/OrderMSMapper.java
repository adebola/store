package io.factorialsystems.store.web.mapper.order;

import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.order.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {DateMSMapper.class})
public interface OrderMSMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "user_id", target = "user_id"),
            @Mapping(source = "full_name", target = "full_name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "orderedAt", target = "orderedAt"),
            @Mapping(source = "orderAmount", target = "orderAmount"),
            @Mapping(source = "pin", target = "pin"),
            @Mapping(source = "pickup", target = "pickup"),
            @Mapping(source = "deliver", target = "deliver"),
            @Mapping(source = "telephone", target = "telephone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "orderItems", target = "orderItems")
    })
    OrderDto OrderToOrderDto(Order order);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "user_id", target = "user_id"),
            @Mapping(source = "full_name", target = "full_name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "orderedAt", target = "orderedAt"),
            @Mapping(source = "orderAmount", target = "orderAmount"),
            @Mapping(source = "paymentRef", target = "paymentRef"),
            @Mapping(source = "transaction_id", target = "transaction_id"),
            @Mapping(source = "pin", target = "pin"),
            @Mapping(source = "pickup", target = "pickup"),
            @Mapping(source = "deliver", target = "deliver"),
            @Mapping(source = "telephone", target = "telephone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "orderItems", target = "orderItems")
    })
    Order OrderDtoToOrder(OrderDto orderDto);

    List<OrderDto> ListOrderToOrderDto(List<Order> orders);
    List<Order> ListOrderDtoToOrder(List<OrderDto> orders);


}
