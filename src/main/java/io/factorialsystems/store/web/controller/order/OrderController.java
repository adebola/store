package io.factorialsystems.store.web.controller.order;

import io.factorialsystems.store.domain.order.FulFillOrder;
import io.factorialsystems.store.domain.order.OrderTotals;
import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.order.OrderService;
import io.factorialsystems.store.web.model.order.OrderDto;
import io.factorialsystems.store.web.model.order.OrderItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Integer> save(@Valid @RequestBody OrderDto order) {
        return new ResponseEntity<>(orderService.SaveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/test")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<MessageResponse> testEmail () {
        orderService.sendTestEmail();
        return new ResponseEntity<>(new MessageResponse("It is Well"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<OrderDto> findOrderById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<OrderDto>> findOrdersByUsersId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(orderService.findOrderByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/orderitem/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<OrderItemDto>> findOrderItemsById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(orderService.findOrderItemById(id), HttpStatus.OK);
    }

    @GetMapping("/totals")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<OrderTotals>> findOrderTotals() {
        return new ResponseEntity<>(orderService.findOrderTotals(), HttpStatus.OK);
    }

    @GetMapping({"/",""})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<OrderDto>> findAll() {
        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
    }

    @PutMapping("/fulfill/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> fulfillOrder(@PathVariable("id") Integer id, @Valid @RequestBody FulFillOrder fulFillOrder) {
        orderService.fulfillOrder(fulFillOrder);

        return new ResponseEntity<>(new MessageResponse("Success"), HttpStatus.OK);
    }
}
