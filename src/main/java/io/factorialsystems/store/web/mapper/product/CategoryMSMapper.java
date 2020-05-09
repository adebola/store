package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.product.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {DateMSMapper.class})
public interface CategoryMSMapper {
    CategoryDto CategoryToCategoryDto(Category category);
    Category CategoryDtoToCategory(CategoryDto categoryDto);
    List<CategoryDto> ListCategoryToCategoryDto(List<Category> categories);
    List<Category> ListCategoryDtoToCategory(List<CategoryDto> categoryDtos);
}
