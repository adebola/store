package io.factorialsystems.store.web.mapper.order;

import io.factorialsystems.store.domain.order.OrderTotals;
import io.factorialsystems.store.web.model.order.OrderTotalsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderTotalsMSMapper {
    OrderTotalsDto OrderTotalsToOrderTotalsDto(OrderTotals orderTotals);
    OrderTotals OrderTotalsDtoToOrderTotals(OrderTotalsDto orderTotalsDto);
    List<OrderTotalsDto> ListOrderTotalsToOrderTotalsDto(List<OrderTotals> orderTotalsList);
    List<OrderTotals> ListOrderTotalsDtoToOrderTotals(List<OrderTotalsDto> orderTotalsDtoList);
}
