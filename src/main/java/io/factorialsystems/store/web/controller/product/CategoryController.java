package io.factorialsystems.store.web.controller.product;

import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.product.CategoryService;
import io.factorialsystems.store.web.model.product.CategoryDto;
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
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping({"/", ""})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CategoryDto>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/subcategory")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CategoryDto>> findCategoriesforSubCategory() {
        return new ResponseEntity<>(categoryService.findCategoriesForSubCategory(), HttpStatus.OK);
    }

    @PutMapping("/subcategory/add/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> addSubCategory(@PathVariable("id") Integer id, @RequestBody Integer newId) {
        categoryService.addSubCategory(id, newId);
        return new ResponseEntity<>(new MessageResponse("Category has been updated"), HttpStatus.OK);
    }

    @PutMapping("/subcategory/remove/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> removeSubCategory(@PathVariable("id") Integer id) {
        categoryService.removeSubCategory(id);
        return new ResponseEntity<>(new MessageResponse("Category has been updated"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoryDto categoryDto) {
        categoryService.update(id, categoryDto);
        return new ResponseEntity<>(new MessageResponse("Category has been updated"), HttpStatus.OK);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> save(@Valid @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable("id") Integer id) {

        try {
            categoryService.deleteById(id);
            return new ResponseEntity<>(new MessageResponse("Category deleted successfully"), HttpStatus.OK);
        } catch (RuntimeException rex) {
            return new ResponseEntity<>(new MessageResponse(rex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
