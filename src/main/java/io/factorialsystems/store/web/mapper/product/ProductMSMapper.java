package io.factorialsystems.store.web.mapper.product;

import io.factorialsystems.store.domain.product.Product;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.product.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {DateMSMapper.class})
public interface ProductMSMapper {
    public static ProductMSMapper INSTANCE = Mappers.getMapper(ProductMSMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "lastModifiedDate", target = "lastModifiedDate"),
            @Mapping(source = "variants", target = "variants"),
            //@Mapping(source = "productVariantList.productVariantOptionList", target = "variants.variantOptions")
    })
    ProductDto ProductToProductDto(Product product);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "lastModifiedDate", target = "lastModifiedDate"),
            @Mapping(source = "variants", target = "variants"),
            //@Mapping(source = "variants.variantOptions", target = "productVariantList.productVariantOptionList")

    })
    Product ProductDtoToProduct(ProductDto productDto);
    List<ProductDto> ListProductToProductDto(List<Product> products);
    List<Product> ListProductDtoToProduct(List<ProductDto> productDtos);
}
