package io.factorialsystems.store.web.controller.test;

import io.factorialsystems.store.domain.order.OrderItem;
import io.factorialsystems.store.mapper.order.OrderMapper;
import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.reports.FirstReport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {
    private final OrderMapper orderMapper;

    @GetMapping({"","/"})
    public ResponseEntity<MessageResponse> TestReport() {
        FirstReport firstReport = new FirstReport();
        firstReport.runReport();

        return new ResponseEntity<>(new MessageResponse("OK"), HttpStatus.OK);
    }

    @GetMapping("/bill")
    public ResponseEntity<?> TestOrderItems() {

        OrderItem item = OrderItem.builder()
                .order_id(22)
                .sku_id(1)
                .quantity(3)
                .unit_price(25000.0)
                .vat_price(0.0)
                .discount(1.2)
                .total_price(24500.0)
                .build();

        log.info(String.format("OrderItem BEFORE INSERT Quantity is %d", item.getQuantity()));
        orderMapper.saveOrderItem(item);
        log.info(String.format("OrderItem AFTER INSERT Quantity is %d, ID %d", item.getQuantity(), item.getId()));

        return new ResponseEntity<>("Successes", HttpStatus.OK);
    }
}
