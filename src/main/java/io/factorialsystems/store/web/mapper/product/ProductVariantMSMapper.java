package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.ProductVariant;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.product.ProductVariantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {DateMSMapper.class})
public interface ProductVariantMSMapper {
    //ProductVariantMSMapper INSTANCE = Mappers.getMapper(ProductVariantMSMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "lastModifiedDate", target = "lastModifiedDate"),
            @Mapping(source = "variantOptions", target = "variantOptions")
    })
    ProductVariantDto ProductVariantToProductVariantDto(ProductVariant productVariant);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "lastModifiedDate", target = "lastModifiedDate"),
            @Mapping(source = "variantOptions", target = "variantOptions"),
            @Mapping(target = "tenantId", ignore = true)
    })
    ProductVariant ProductVariantDtoToProductVariant(ProductVariantDto productVariantDtoDto);
    List<ProductVariantDto> ListProductVariantToProductVariantDto(List<ProductVariant> productVariants);
    //List<ProductVariant> ListProductVariantDtoToProductVariant(List<ProductVariantDto> productVariantDtos);
}
