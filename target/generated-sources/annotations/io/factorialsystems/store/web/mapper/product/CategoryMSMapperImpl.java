package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.product.CategoryDto;
import io.factorialsystems.store.web.model.product.CategoryDto.CategoryDtoBuilder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-14T17:32:58+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class CategoryMSMapperImpl implements CategoryMSMapper {

    @Autowired
    private DateMSMapper dateMSMapper;

    @Override
    public CategoryDto CategoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDtoBuilder categoryDto = CategoryDto.builder();

        categoryDto.id( category.getId() );
        categoryDto.name( category.getName() );
        if ( category.getCreatedDate() != null ) {
            categoryDto.createdDate( dateMSMapper.asOffsetDateTime( new Timestamp( category.getCreatedDate().getTime() ) ) );
        }
        if ( category.getLastModifiedDate() != null ) {
            categoryDto.lastModifiedDate( dateMSMapper.asOffsetDateTime( new Timestamp( category.getLastModifiedDate().getTime() ) ) );
        }

        return categoryDto.build();
    }

    @Override
    public Category CategoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );
        category.setCreatedDate( dateMSMapper.asTimestamp( categoryDto.getCreatedDate() ) );
        category.setLastModifiedDate( dateMSMapper.asTimestamp( categoryDto.getLastModifiedDate() ) );

        return category;
    }

    @Override
    public List<CategoryDto> ListCategoryToCategoryDto(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categories.size() );
        for ( Category category : categories ) {
            list.add( CategoryToCategoryDto( category ) );
        }

        return list;
    }
}
