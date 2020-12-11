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

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<StoreProductDto>> findAllProducts() {
        return new ResponseEntity<>(storeProductService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<List<StoreProductDto>> search(@PathVariable("search") String search) {
        return new ResponseEntity<>(storeProductService.search(search), HttpStatus.OK);
    }

//    @GetMapping("/sku")
//    public ResponseEntity<List<StoreProductSKUDto>> findAllSKU() {
//        return new ResponseEntity<>(storeProductService.findAllSKU(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<List<StoreProductDto>> findProductByProductId(@PathVariable("id") Integer id) {
//        return new ResponseEntity<>(storeProductService.findByProductId(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/sku/sku/{id}")
//    public ResponseEntity<List<StoreProductSKUDto>> findSkuBySkuId(@PathVariable("id") Integer id) {
//        return new ResponseEntity<>(storeProductService.findSKUBySkuId(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/sku/{id}")
//    public ResponseEntity<List<StoreProductSKUDto>> findSkuByProductId(@PathVariable("id") Integer id) {
//        return new ResponseEntity<>(storeProductService.findSKUByProductId(id), HttpStatus.OK);
//    }
}
