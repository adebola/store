package io.factorialsystems.store.web.controller.product;

import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.product.ProductService;
import io.factorialsystems.store.web.model.product.ProductDto;
import io.factorialsystems.store.web.model.product.admin.AdminProductDto;
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
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping({"/", ""})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @Valid @RequestBody ProductDto productDto) {

        MessageResponse messageResponse;
        HttpStatus httpStatus = HttpStatus.OK;

        if (productService.update(id, productDto)) {
            messageResponse = new MessageResponse("Product updated Successfully");
        } else {
            messageResponse = new MessageResponse("Product update Error");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(messageResponse, httpStatus);
    }

    @PostMapping({"/",""})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable("id") Integer id) {
        productService.deleteById(id);

        return new ResponseEntity<>(new MessageResponse("Product has been deleted successfully"), HttpStatus.OK);
    }


    // SKU Paths
    @GetMapping("/sku/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdminProductDto> findProductById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }
}
