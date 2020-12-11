package io.factorialsystems.store.web.controller.order;

import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.order.OrderService;
import io.factorialsystems.store.web.model.order.OrderDto;
import io.factorialsystems.store.web.model.order.OrderItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Integer> save(@Valid @RequestBody OrderDto order) {
        return new ResponseEntity<>(orderService.SaveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<MessageResponse> testEmail () {
        orderService.sendTestEmail();
        return new ResponseEntity<>(new MessageResponse("It is Well"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findOrderById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderDto>> findOrdersByUsersId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(orderService.findOrderByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/orderitem/{id}")
    public ResponseEntity<List<OrderItemDto>> findOrderItemsById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(orderService.findOrderItemById(id), HttpStatus.OK);
    }
}
