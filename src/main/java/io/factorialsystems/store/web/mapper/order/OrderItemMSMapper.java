package io.factorialsystems.store.web.mapper.order;

import io.factorialsystems.store.domain.order.OrderItem;
import io.factorialsystems.store.web.model.order.OrderItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface OrderItemMSMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "order_id", target = "order_id"),
            @Mapping(source = "sku_id", target = "sku_id"),
            @Mapping(source = "image_path", target = "image_path"),
            @Mapping(source = "product_name", target = "product_name"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "unit_price", target = "unit_price"),
            @Mapping(source = "discount", target = "discount"),
            @Mapping(source = "total_price", target = "total_price")
    })
    OrderItemDto OrderToOrderDto(OrderItem orderItem);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "order_id", target = "order_id"),
            @Mapping(source = "sku_id", target = "sku_id"),
            @Mapping(source = "image_path", target = "image_path"),
            @Mapping(source = "product_name", target = "product_name"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "unit_price", target = "unit_price"),
            @Mapping(source = "discount", target = "discount"),
            @Mapping(source = "total_price", target = "total_price")
    })
    OrderItem OrderDtoToOrder(OrderItemDto orderItemDto);

    List<OrderItemDto> ListOrderToOrderDto(List<OrderItem> orders);
    List<OrderItem> ListOrderDtoToOrder(List<OrderItemDto> orderDtos);
}
