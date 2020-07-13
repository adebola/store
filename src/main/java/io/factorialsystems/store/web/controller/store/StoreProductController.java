package io.factorialsystems.store.web.controller.store;


import io.factorialsystems.store.service.store.StoreProductService;
import io.factorialsystems.store.web.model.product.StoreProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store/products")
public class StoreProductController {
    private final StoreProductService storeProductService;

    @GetMapping("/")
    public ResponseEntity<List<StoreProductDto>> findAll() {
        return new ResponseEntity<>(storeProductService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<StoreProductDto>> findByProductId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(storeProductService.findByProductId(id), HttpStatus.OK);
    }
}
