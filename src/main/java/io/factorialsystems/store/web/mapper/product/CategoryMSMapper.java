package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.product.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {DateMSMapper.class})
public interface CategoryMSMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "image_url", target = "image_url"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "lastModifiedDate", target = "lastModifiedDate"),
            @Mapping(source = "subCategories", target = "subCategories")
    })
    CategoryDto CategoryToCategoryDto(Category category);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "image_url", target = "image_url"),
            @Mapping(target = "createdDate", ignore = true),
            @Mapping(target = "lastModifiedDate", ignore = true),
            @Mapping(source = "subCategories", target = "subCategories"),
            @Mapping(target = "tenantId", ignore = true)
    })
    Category CategoryDtoToCategory(CategoryDto categoryDto);

    List<CategoryDto> ListCategoryToCategoryDto(List<Category> categories);
    // List<Category> ListCategoryDtoToCategory(List<CategoryDto> categoryDtos);
}
