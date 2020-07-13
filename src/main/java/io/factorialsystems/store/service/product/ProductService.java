package io.factorialsystems.store.service.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.domain.product.Product;
import io.factorialsystems.store.mapper.product.CategoryMapper;
import io.factorialsystems.store.mapper.product.ProductMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.mapper.product.ProductMSMapper;
import io.factorialsystems.store.web.model.product.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductMSMapper productMSMapper;
    private final CategoryMapper categoryMapper;

    public List<ProductDto> findAll() {
        return productMSMapper.ListProductToProductDto(productMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public ProductDto findById(Integer id) {
        return productMSMapper.ProductToProductDto(productMapper.findById(id, TenantContext.getCurrentTenant()));
    }

    public Boolean update(Integer id, ProductDto productDto) {
        String tenantContext = TenantContext.getCurrentTenant();
        Category category = categoryMapper.findById(productDto.getCategory().getId(), tenantContext);

        if (category == null) {
            return false;
        } else {
            Product product = productMSMapper.ProductDtoToProduct(productDto);
            product.setTenantId(tenantContext);
            productMapper.updateProduct(id, product);
            return true;
        }
    }

    public ProductDto save(ProductDto productDto) {
        Product product = productMSMapper.ProductDtoToProduct(productDto);
        product.setTenantId(TenantContext.getCurrentTenant());

            productMapper.saveProduct(product);

            log.info(product.toString());

            if (product != null && product.getId() > 0) {
                return productMSMapper.ProductToProductDto(product);
            }

            throw new RuntimeException("Error saving Product to the Database");
    }

    public void deleteById(Integer id) {
        productMapper.deleteById(id, TenantContext.getCurrentTenant());
    }
}
