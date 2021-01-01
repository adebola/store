package io.factorialsystems.store.web.controller.product;

import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.product.ProductVariantService;
import io.factorialsystems.store.web.model.product.ProductVariantDto;
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
@RequestMapping("/api/v1/pv")
public class ProductVariantController {
    private final ProductVariantService productVariantService;

    @GetMapping("/product/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ProductVariantDto>> findByProductId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productVariantService.findByProductId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductVariantDto> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productVariantService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @Valid @RequestBody ProductVariantDto productVariantDto) {

        MessageResponse messageResponse;

        if (productVariantService.update(id, productVariantDto)) {
            messageResponse = new MessageResponse("Product Variant updated Successfully");
        } else {
            messageResponse = new MessageResponse("Product update Error");
        }

        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductVariantDto> save(@Valid @RequestBody ProductVariantDto productVariantDto) {
        return new ResponseEntity<>(productVariantService.save(productVariantDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable("id") Integer id) {
        productVariantService.deleteById(id);

        return new ResponseEntity<>(new MessageResponse("Product has been deleted successfully"), HttpStatus.OK);
    }
}
