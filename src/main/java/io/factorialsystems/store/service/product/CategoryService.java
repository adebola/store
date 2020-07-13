package io.factorialsystems.store.service.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.mapper.product.CategoryMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.mapper.product.CategoryMSMapper;
import io.factorialsystems.store.web.model.product.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryMSMapper categoryMSMapper;

    public List<CategoryDto> findAll() {
        return categoryMSMapper.ListCategoryToCategoryDto(categoryMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public CategoryDto findById(Integer id) {
        return categoryMSMapper.CategoryToCategoryDto(categoryMapper.findById(id, TenantContext.getCurrentTenant()));
    }

    public void update(Integer id, CategoryDto categoryDto) {

        Category category = categoryMSMapper.CategoryDtoToCategory(categoryDto);

        categoryMapper.updateCategory(id, TenantContext.getCurrentTenant(), category);
    }

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryMSMapper.CategoryDtoToCategory(categoryDto);
        category.setTenantId(TenantContext.getCurrentTenant());

        categoryMapper.saveCategory(category);

        if (category != null && category.getId() > 0 ) {
            return categoryMSMapper.CategoryToCategoryDto(category);
        }

        throw new RuntimeException("Error Saving Category to the Database");
    }

    public void deleteById(Integer id) {
        categoryMapper.deleteById(id, TenantContext.getCurrentTenant());
    }
}