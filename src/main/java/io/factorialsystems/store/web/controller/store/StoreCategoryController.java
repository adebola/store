package io.factorialsystems.store.web.controller.store;


import io.factorialsystems.store.service.product.CategoryService;
import io.factorialsystems.store.web.model.product.CategoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store/categories")
public class StoreCategoryController {
    private final CategoryService categoryService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<CategoryDto>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}
