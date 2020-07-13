package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.ProductVariant;
import io.factorialsystems.store.domain.product.ProductVariantOption;
import io.factorialsystems.store.web.model.product.ProductVariantDto;
import io.factorialsystems.store.web.model.product.ProductVariantDto.ProductVariantDtoBuilder;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto.ProductVariantOptionDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-13T18:41:28+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class ProductVariantMSMapperImpl implements ProductVariantMSMapper {

    @Override
    public ProductVariantDto ProductVariantToProductVariantDto(ProductVariant productVariant) {
        if ( productVariant == null ) {
            return null;
        }

        ProductVariantDtoBuilder productVariantDto = ProductVariantDto.builder();

        productVariantDto.createdDate( productVariant.getCreatedDate() );
        productVariantDto.productId( productVariant.getProductId() );
        productVariantDto.lastModifiedDate( productVariant.getLastModifiedDate() );
        productVariantDto.variantOptions( productVariantOptionListToProductVariantOptionDtoList( productVariant.getVariantOptions() ) );
        productVariantDto.name( productVariant.getName() );
        productVariantDto.id( productVariant.getId() );

        return productVariantDto.build();
    }

    @Override
    public ProductVariant ProductVariantDtoToProductVariant(ProductVariantDto productVariantDtoDto) {
        if ( productVariantDtoDto == null ) {
            return null;
        }

        ProductVariant productVariant = new ProductVariant();

        productVariant.setCreatedDate( productVariantDtoDto.getCreatedDate() );
        productVariant.setProductId( productVariantDtoDto.getProductId() );
        productVariant.setLastModifiedDate( productVariantDtoDto.getLastModifiedDate() );
        productVariant.setVariantOptions( productVariantOptionDtoListToProductVariantOptionList( productVariantDtoDto.getVariantOptions() ) );
        productVariant.setName( productVariantDtoDto.getName() );
        productVariant.setId( productVariantDtoDto.getId() );

        return productVariant;
    }

    @Override
    public List<ProductVariantDto> ListProductVariantToProductVariantDto(List<ProductVariant> productVariants) {
        if ( productVariants == null ) {
            return null;
        }

        List<ProductVariantDto> list = new ArrayList<ProductVariantDto>( productVariants.size() );
        for ( ProductVariant productVariant : productVariants ) {
            list.add( ProductVariantToProductVariantDto( productVariant ) );
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
}
