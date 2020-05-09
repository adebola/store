package io.factorialsystems.store.web.controller.product;

import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.product.ProductVariantOptionService;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto;
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
@RequestMapping("/api/v1/product_variant_options")
public class ProductVariantOptionController {

    private final ProductVariantOptionService productVariantOptionService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ProductVariantOptionDto>> findAll() {
        return new ResponseEntity<List<ProductVariantOptionDto>>(productVariantOptionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductVariantOptionDto> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productVariantOptionService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @Valid @RequestBody ProductVariantOptionDto productVariantOptionDto) {

        MessageResponse messageResponse;

        if (productVariantOptionService.update(id, productVariantOptionDto)) {
            messageResponse = new MessageResponse("Product Variant updated Successfully");
        } else {
            messageResponse = new MessageResponse("Product update Error");
        }

        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductVariantOptionDto> save(@Valid @RequestBody ProductVariantOptionDto productVariantOptionDto) {
        return new ResponseEntity<>(productVariantOptionService.save(productVariantOptionDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable("id") Integer id) {
        productVariantOptionService.deleteById(id);

        return new ResponseEntity<>(new MessageResponse("Product has been deleted successfully"), HttpStatus.OK);
    }
}
