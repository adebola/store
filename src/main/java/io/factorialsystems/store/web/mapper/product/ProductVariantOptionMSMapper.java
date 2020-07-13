package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.ProductVariantOption;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {DateMSMapper.class})
public interface ProductVariantOptionMSMapper {
    ProductVariantOptionMSMapper INSTANCE = Mappers.getMapper(ProductVariantOptionMSMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "productVariantId", target = "productVariantId"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
    })
    public ProductVariantOptionDto NonDtoToDto(ProductVariantOption pvo);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "productVariantId", target = "productVariantId"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
    })
    public ProductVariantOption DtoToNonDto(ProductVariantOptionDto pvod);
    public List<ProductVariantOptionDto> ListNonDtoToDto(List<ProductVariantOption> pvolist);
    public List<ProductVariantOption> ListDtoToNonDto(List<ProductVariantOptionDto> pvodlist);
}
