package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.domain.product.Product;
import io.factorialsystems.store.domain.product.ProductVariant;
import io.factorialsystems.store.domain.product.ProductVariantOption;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.product.CategoryDto;
import io.factorialsystems.store.web.model.product.CategoryDto.CategoryDtoBuilder;
import io.factorialsystems.store.web.model.product.ProductDto;
import io.factorialsystems.store.web.model.product.ProductDto.ProductDtoBuilder;
import io.factorialsystems.store.web.model.product.ProductVariantDto;
import io.factorialsystems.store.web.model.product.ProductVariantDto.ProductVariantDtoBuilder;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto.ProductVariantOptionDtoBuilder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-14T08:56:04+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class ProductMSMapperImpl implements ProductMSMapper {

    @Autowired
    private DateMSMapper dateMSMapper;

    @Override
    public ProductDto ProductToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDto.builder();

        if ( product.getCreatedDate() != null ) {
            productDto.createdDate( dateMSMapper.asOffsetDateTime( new Timestamp( product.getCreatedDate().getTime() ) ) );
        }
        if ( product.getLastModifiedDate() != null ) {
            productDto.lastModifiedDate( dateMSMapper.asOffsetDateTime( new Timestamp( product.getLastModifiedDate().getTime() ) ) );
        }
        productDto.name( product.getName() );
        productDto.id( product.getId() );
        productDto.variants( productVariantListToProductVariantDtoList( product.getVariants() ) );
        productDto.category( categoryToCategoryDto( product.getCategory() ) );

        return productDto.build();
    }

    @Override
    public Product ProductDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setCreatedDate( dateMSMapper.asTimestamp( productDto.getCreatedDate() ) );
        product.setLastModifiedDate( dateMSMapper.asTimestamp( productDto.getLastModifiedDate() ) );
        product.setName( productDto.getName() );
        product.setId( productDto.getId() );
        product.setVariants( productVariantDtoListToProductVariantList( productDto.getVariants() ) );
        product.setCategory( categoryDtoToCategory( productDto.getCategory() ) );

        return product;
    }

    @Override
    public List<ProductDto> ListProductToProductDto(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( ProductToProductDto( product ) );
        }

        return list;
    }

    protected ProductVariantOptionDto productVariantOptionToProductVariantOptionDto(ProductVariantOption productVariantOption) {
        if ( productVariantOption == null ) {
            return null;
        }

        ProductVariantOptionDtoBuilder productVariantOptionDto = ProductVariantOptionDto.builder();

        productVariantOptionDto.id( productVariantOption.getId() );
        productVariantOptionDto.name( productVariantOption.getName() );
        productVariantOptionDto.productVariantId( productVariantOption.getProductVariantId() );
        productVariantOptionDto.createdDate( productVariantOption.getCreatedDate() );
        productVariantOptionDto.lastModifiedDate( productVariantOption.getLastModifiedDate() );

        return productVariantOptionDto.build();
    }

    protected List<ProductVariantOptionDto> productVariantOptionListToProductVariantOptionDtoList(List<ProductVariantOption> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductVariantOptionDto> list1 = new ArrayList<ProductVariantOptionDto>( list.size() );
        for ( ProductVariantOption productVariantOption : list ) {
            list1.add( productVariantOptionToProductVariantOptionDto( productVariantOption ) );
        }

        return list1;
    }

    protected ProductVariantDto productVariantToProductVariantDto(ProductVariant productVariant) {
        if ( productVariant == null ) {
            return null;
        }

        ProductVariantDtoBuilder productVariantDto = ProductVariantDto.builder();

        productVariantDto.id( productVariant.getId() );
        productVariantDto.name( productVariant.getName() );
        productVariantDto.productId( productVariant.getProductId() );
        productVariantDto.createdDate( productVariant.getCreatedDate() );
        productVariantDto.lastModifiedDate( productVariant.getLastModifiedDate() );
        productVariantDto.variantOptions( productVariantOptionListToProductVariantOptionDtoList( productVariant.getVariantOptions() ) );

        return productVariantDto.build();
    }

    protected List<ProductVariantDto> productVariantListToProductVariantDtoList(List<ProductVariant> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductVariantDto> list1 = new ArrayList<ProductVariantDto>( list.size() );
        for ( ProductVariant productVariant : list ) {
            list1.add( productVariantToProductVariantDto( productVariant ) );
        }

        return list1;
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
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

    protected ProductVariantOption productVariantOptionDtoToProductVariantOption(ProductVariantOptionDto productVariantOptionDto) {
        if ( productVariantOptionDto == null ) {
            return null;
        }

        ProductVariantOption productVariantOption = new ProductVariantOption();

        productVariantOption.setId( productVariantOptionDto.getId() );
        productVariantOption.setName( productVariantOptionDto.getName() );
        productVariantOption.setProductVariantId( productVariantOptionDto.getProductVariantId() );
        productVariantOption.setCreatedDate( productVariantOptionDto.getCreatedDate() );
        productVariantOption.setLastModifiedDate( productVariantOptionDto.getLastModifiedDate() );

        return productVariantOption;
    }

    protected List<ProductVariantOption> productVariantOptionDtoListToProductVariantOptionList(List<ProductVariantOptionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductVariantOption> list1 = new ArrayList<ProductVariantOption>( list.size() );
        for ( ProductVariantOptionDto productVariantOptionDto : list ) {
            list1.add( productVariantOptionDtoToProductVariantOption( productVariantOptionDto ) );
        }

        return list1;
    }

    protected ProductVariant productVariantDtoToProductVariant(ProductVariantDto productVariantDto) {
        if ( productVariantDto == null ) {
            return null;
        }

        ProductVariant productVariant = new ProductVariant();

        productVariant.setId( productVariantDto.getId() );
        productVariant.setName( productVariantDto.getName() );
        productVariant.setProductId( productVariantDto.getProductId() );
        productVariant.setCreatedDate( productVariantDto.getCreatedDate() );
        productVariant.setLastModifiedDate( productVariantDto.getLastModifiedDate() );
        productVariant.setVariantOptions( productVariantOptionDtoListToProductVariantOptionList( productVariantDto.getVariantOptions() ) );

        return productVariant;
    }

    protected List<ProductVariant> productVariantDtoListToProductVariantList(List<ProductVariantDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductVariant> list1 = new ArrayList<ProductVariant>( list.size() );
        for ( ProductVariantDto productVariantDto : list ) {
            list1.add( productVariantDtoToProductVariant( productVariantDto ) );
        }

        return list1;
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
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
}
