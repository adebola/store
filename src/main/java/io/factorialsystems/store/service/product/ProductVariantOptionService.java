package io.factorialsystems.store.service.product;

import io.factorialsystems.store.domain.product.ProductVariantOption;
import io.factorialsystems.store.mapper.product.ProductVariantOptionMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.mapper.product.ProductVariantOptionMSMapper;
import io.factorialsystems.store.web.model.product.ProductVariantOptionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductVariantOptionService {
    private final ProductVariantOptionMapper productVariantOptionMapper;
    private final ProductVariantOptionMSMapper productVariantOptionMSMapper;

    public List<ProductVariantOptionDto> findAll() {
        return productVariantOptionMSMapper.ListNonDtoToDto(productVariantOptionMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public ProductVariantOptionDto findById(Integer id) {
        return productVariantOptionMSMapper.NonDtoToDto(productVariantOptionMapper.findById(id, TenantContext.getCurrentTenant()));
    }

    public Boolean update(Integer id, ProductVariantOptionDto productVariantOptionDto) {
        ProductVariantOption productVariantOption = productVariantOptionMSMapper.DtoToNonDto(productVariantOptionDto);
        productVariantOption.setTenantId(TenantContext.getCurrentTenant());

        productVariantOptionMapper.updateProductVariantOption(id, productVariantOption);
        return true;
    }

    public ProductVariantOptionDto save(ProductVariantOptionDto productVariantOptionDto) {
        ProductVariantOption productVariantOption = productVariantOptionMSMapper.DtoToNonDto(productVariantOptionDto);
        productVariantOption.setTenantId(TenantContext.getCurrentTenant());

        productVariantOptionMapper.saveProductVariantOption(productVariantOption);

        if (productVariantOption != null && productVariantOption.getId() > 0) {
            return productVariantOptionMSMapper.NonDtoToDto(productVariantOption);
        }

        throw new RuntimeException("Error saving ProductVariant to the Database");
    }

    public void deleteById(Integer id) {
        productVariantOptionMapper.deleteById(id, TenantContext.getCurrentTenant());
    }
}
