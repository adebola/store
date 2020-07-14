package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.ProductVariantOption;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto.ProductVariantOptionDtoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-14T17:32:57+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class ProductVariantOptionMSMapperImpl implements ProductVariantOptionMSMapper {

    @Override
    public ProductVariantOptionDto NonDtoToDto(ProductVariantOption pvo) {
        if ( pvo == null ) {
            return null;
        }

        ProductVariantOptionDtoBuilder productVariantOptionDto = ProductVariantOptionDto.builder();

        productVariantOptionDto.name( pvo.getName() );
        productVariantOptionDto.createdDate( pvo.getCreatedDate() );
        productVariantOptionDto.id( pvo.getId() );
        productVariantOptionDto.productVariantId( pvo.getProductVariantId() );
        productVariantOptionDto.lastModifiedDate( pvo.getLastModifiedDate() );

        return productVariantOptionDto.build();
    }

    @Override
    public ProductVariantOption DtoToNonDto(ProductVariantOptionDto pvod) {
        if ( pvod == null ) {
            return null;
        }

        ProductVariantOption productVariantOption = new ProductVariantOption();

        productVariantOption.setName( pvod.getName() );
        productVariantOption.setCreatedDate( pvod.getCreatedDate() );
        productVariantOption.setId( pvod.getId() );
        productVariantOption.setProductVariantId( pvod.getProductVariantId() );
        productVariantOption.setLastModifiedDate( pvod.getLastModifiedDate() );

        return productVariantOption;
    }

    @Override
    public List<ProductVariantOptionDto> ListNonDtoToDto(List<ProductVariantOption> pvolist) {
        if ( pvolist == null ) {
            return null;
        }

        List<ProductVariantOptionDto> list = new ArrayList<ProductVariantOptionDto>( pvolist.size() );
        for ( ProductVariantOption productVariantOption : pvolist ) {
            list.add( NonDtoToDto( productVariantOption ) );
        }

        return list;
    }

    @Override
    public List<ProductVariantOption> ListDtoToNonDto(List<ProductVariantOptionDto> pvodlist) {
        if ( pvodlist == null ) {
            return null;
        }

        List<ProductVariantOption> list = new ArrayList<ProductVariantOption>( pvodlist.size() );
        for ( ProductVariantOptionDto productVariantOptionDto : pvodlist ) {
            list.add( DtoToNonDto( productVariantOptionDto ) );
        }

        return list;
    }
}
