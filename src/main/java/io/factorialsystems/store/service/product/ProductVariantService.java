package io.factorialsystems.store.service.product;

import io.factorialsystems.store.domain.product.ProductVariant;
import io.factorialsystems.store.mapper.product.ProductVariantMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.mapper.product.ProductVariantMSMapper;
import io.factorialsystems.store.web.model.product.ProductVariantDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


// Build against table constraints otherwise SQLExceptions which cannot be caught are thrown

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductVariantService {
    private final ProductVariantMapper productVariantMapper;
    private final ProductVariantMSMapper productVariantMSMapper;

    public List<ProductVariantDto> findAll() {
        return productVariantMSMapper.ListProductVariantToProductVariantDto(productVariantMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public ProductVariantDto findById(Integer id) {
        return productVariantMSMapper.ProductVariantToProductVariantDto(productVariantMapper.findById(id, TenantContext.getCurrentTenant()));
    }

    public Boolean update(Integer id, ProductVariantDto productVariantDto) {
        ProductVariant productVariant = productVariantMSMapper.ProductVariantDtoToProductVariant(productVariantDto);
        productVariant.setTenantId(TenantContext.getCurrentTenant());

        productVariantMapper.updateProductVariant(id, productVariant);
        return true;
    }

    public ProductVariantDto save(ProductVariantDto productVariantDto) {
       ProductVariant productVariant = productVariantMSMapper.ProductVariantDtoToProductVariant(productVariantDto);
       productVariant.setTenantId(TenantContext.getCurrentTenant());

       productVariantMapper.saveProductVariant(productVariant);

       if (productVariant != null && productVariant.getId() > 0) {
           return productVariantMSMapper.ProductVariantToProductVariantDto(productVariant);
       }

        throw new RuntimeException("Error saving ProductVariant to the Database");
    }

    public void deleteById(Integer id) {
        productVariantMapper.deleteById(id, TenantContext.getCurrentTenant());
    }
}
