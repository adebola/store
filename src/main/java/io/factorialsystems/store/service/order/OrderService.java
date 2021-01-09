package io.factorialsystems.store.service.order;

import io.factorialsystems.store.business.mail.Mail;
import io.factorialsystems.store.domain.order.FulFillOrder;
import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.domain.order.OrderItem;
import io.factorialsystems.store.domain.order.OrderTotals;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.mapper.order.OrderMapper;
import io.factorialsystems.store.mapper.user.UserMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.task.TaskPDFMail;
import io.factorialsystems.store.web.mapper.order.OrderItemMSMapper;
import io.factorialsystems.store.web.mapper.order.OrderMSMapper;
import io.factorialsystems.store.web.model.order.OrderDto;
import io.factorialsystems.store.web.model.order.OrderItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderMSMapper orderMSMapper;
    private final OrderItemMSMapper orderItemMSMapper;
    private final UserMapper userMapper;
    private final TaskExecutor taskExecutor;
    private final TaskPDFMail taskPDFMail;

    public Integer SaveOrder(OrderDto orderDto) {

        User user = null;

        if (orderDto.getUser_id() != null) {
            user = userMapper.findById(orderDto.getUser_id(), TenantContext.getCurrentTenant());
        }

        // Save Order
        Order order = Order.builder()
                .orderAmount(orderDto.getOrderAmount())
                .paymentRef(orderDto.getPaymentRef())
                .transaction_id(orderDto.getTransaction_id())
                .pickup(orderDto.getPickup())
                .deliver(orderDto.getDeliver())
                .tenant_id(TenantContext.getCurrentTenant())
                .user_id(orderDto.getUser_id())
                .pin(String.format("%04d", new Random().nextInt(10000)))
                .build();

        if (orderDto.getEmail() != null) {
            order.setEmail(orderDto.getEmail());
        } else {
            order.setEmail(user != null ? user.getEmail() : null);
        }

        if (orderDto.getAddress() != null) {
            order.setAddress(orderDto.getAddress());
        } else {
            order.setAddress(user != null ? user.getAddress() : null);
        }

        if (orderDto.getFull_name() != null) {
            order.setFull_name(orderDto.getFull_name());
        } else {
            order.setFull_name(user != null ? user.getFullName() : null);
        }

        if (orderDto.getTelephone() != null) {
            order.setTelephone(orderDto.getTelephone());
        } else {
            order.setTelephone(user != null ? user.getTelephone() : null);
        }


        // Make Sure that User Requesting Delivery has an Address either submitted or in the database
        if (order.getDeliver() && order.getAddress() == null) {
            throw new RuntimeException("User has requested that goods be delivered but has not specified delivery address or address cannot be read from the database");
        }

        orderMapper.saveOrder(order);

        if (!(order.getId() != null && order.getId() > 0)) {
            throw new RuntimeException("Database Error Saving Order");
        }

        int orderId = order.getId();

        // Save OrderItems
        orderDto.getOrderItems().forEach(e -> {
            OrderItem item = OrderItem.builder()
                    .order_id(orderId)
                    .sku_id(e.getSku_id())
                    .quantity(e.getQuantity())
                    .unit_price(e.getUnit_price())
                    .discount(e.getDiscount())
                    .total_price(e.getTotal_price())
                    .build();

            orderMapper.saveOrderItem(item);
        });

        // Send E-Mail & Generate Report all in 1 Async Task
        if (order.getEmail() != null && order.getAddress() != null && order.getFull_name() != null) {
            taskPDFMail.setParameters(new Mail(order.getEmail()), TenantContext.getCurrentTenant(), order.getId());
            taskExecutor.execute(taskPDFMail);
        }

        return order.getId();
    }

    public OrderDto findOrderById(Integer id) {
        return orderMSMapper.OrderToOrderDto(orderMapper.findOrderById(id, TenantContext.getCurrentTenant()));
    }

    public List<OrderDto> findOrderByUserId(Integer userId) {

        return orderMSMapper.ListOrderToOrderDto(orderMapper.findOrderByUserId(userId, TenantContext.getCurrentTenant()));
    }

    public List<OrderItemDto> findOrderItemById(Integer orderItemId) {
        return orderItemMSMapper.ListOrderToOrderDto(orderMapper.findOrderItemsById(orderItemId));
    }

    public List<OrderTotals> findOrderTotals() {
        return orderMapper.findOrderTotals(TenantContext.getCurrentTenant());
    }

    public void sendTestEmail() {
        taskPDFMail.setParameters(new Mail("adeomoboya@gmail.com"), TenantContext.getCurrentTenant(), 8);
        taskExecutor.execute(taskPDFMail);
    }

    public List<OrderDto> findAllOrders() {
        return orderMSMapper.ListOrderToOrderDto(orderMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public void fulfillOrder(FulFillOrder fulFillOrder) {
        orderMapper.fulfillOrder(fulFillOrder);
    }
}
