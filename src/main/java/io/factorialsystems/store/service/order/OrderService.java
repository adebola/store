package io.factorialsystems.store.service.order;

import io.factorialsystems.store.business.mail.Mail;
import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.domain.order.OrderItem;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.mapper.order.OrderMapper;
import io.factorialsystems.store.mapper.user.UserMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.task.TaskPDFMail;
import io.factorialsystems.store.web.mapper.order.OrderMSMapper;
import io.factorialsystems.store.web.model.order.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderMSMapper orderMSMapper;
    private final UserMapper userMapper;
    private final TaskExecutor taskExecutor;
    private final TaskPDFMail taskPDFMail;

    public Integer SaveOrder(OrderDto orderDto) {

        // Save Order
        Order order = Order.builder()
                .orderAmount(orderDto.getOrderAmount())
                .paymentRef(orderDto.getPaymentRef())
                .transaction_id(orderDto.getTransaction_id())
                .pickup(orderDto.getPickup())
                .deliver(orderDto.getDeliver())
                .tenant_id(TenantContext.getCurrentTenant())
                .user_id(orderDto.getUser_id())
                .build();

        // Anonymous User Requesting Delivery Create Address Object from Dto
        if (orderDto.getUser_id() == null && orderDto.getDeliver()) {
            if (orderDto.getAddress() == null) {
                throw new RuntimeException("Anonymous User has requested that goods be delivered but has not specified delivery address");
            }

            order.setAddress(orderDto.getAddress());
            order.setTelephone(orderDto.getTelephone());
            order.setFull_name(orderDto.getFull_name());
            order.setEmail(orderDto.getEmail());

        } else if (orderDto.getUser_id() != null && orderDto.getDeliver()) {  // Logged On User Requesting Delivery Get Address from Database

            User user = userMapper.findById(orderDto.getUser_id(), TenantContext.getCurrentTenant());

            if (user.getAddress() == null) {
                throw new RuntimeException(String.format("User %s has requested that goods be delivered but has no address on record and has not specified a delivery address", user.getFullName()));
            }

            // If the User specified address use over the address in the database
            order.setAddress(user.getAddress());
            order.setTelephone(user.getTelephone());
            order.setFull_name(user.getFullName());
            order.setEmail(user.getEmail());
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
        if (order.getEmail() != null) {
            taskPDFMail.setParameters(new Mail(order.getEmail()), TenantContext.getCurrentTenant(), order.getId());
            taskExecutor.execute(taskPDFMail);
        }

        return order.getId();
    }

    public OrderDto findOrderById(Integer id) {
        return orderMSMapper.OrderToOrderDto(orderMapper.findOrderById(id, TenantContext.getCurrentTenant()));
    }

    public void sendTestEmail() {

        taskPDFMail.setParameters(new Mail("adeomoboya@gmail.com"), TenantContext.getCurrentTenant(), 1);
        taskExecutor.execute(taskPDFMail);
    }
}
