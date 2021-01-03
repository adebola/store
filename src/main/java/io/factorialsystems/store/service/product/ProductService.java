package io.factorialsystems.store.service.product;

import io.factorialsystems.store.domain.product.Category;
import io.factorialsystems.store.domain.product.Product;
import io.factorialsystems.store.domain.product.ProductAdminSKU;
import io.factorialsystems.store.mapper.product.CategoryMapper;
import io.factorialsystems.store.mapper.product.ProductMapper;
import io.factorialsystems.store.mapper.product.ProductSKUMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.mapper.product.ProductMSMapper;
import io.factorialsystems.store.web.model.product.ProductDto;
import io.factorialsystems.store.web.model.product.admin.AdminProductBundleDto;
import io.factorialsystems.store.web.model.product.admin.AdminProductBundleVariantDto;
import io.factorialsystems.store.web.model.product.admin.AdminProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductMSMapper productMSMapper;
    private final CategoryMapper categoryMapper;
    private final ProductSKUMapper productSKUMapper;

    public List<ProductDto> findAll() {
        return productMSMapper.ListProductToProductDto(productMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public ProductDto findById(Integer id) {
        return productMSMapper.ProductToProductDto(productMapper.findById(id, TenantContext.getCurrentTenant()));
    }

    public Boolean update(Integer id, ProductDto productDto) {
        String tenantContext = TenantContext.getCurrentTenant();
        Category category = categoryMapper.findById(productDto.getCategoryId(), tenantContext);

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

    public AdminProductDto findProductById(Integer id) {
        return Convert( productSKUMapper.findByProductId(id, TenantContext.getCurrentTenant()));
    }

    private AdminProductDto Convert(ProductAdminSKU productAdminSKU) {

        AdminProductDto adminProductDto = AdminProductDto
                .builder()
                .productId(productAdminSKU.getProductId())
                .name(productAdminSKU.getName())
                .category(productAdminSKU.getCategory())
                .categoryId(productAdminSKU.getCategoryId())
                .brand(productAdminSKU.getBrand())
                .build();


        // Admin-Product-Bundle
        Set<AdminProductBundleDto> adminProductBundleDtoSet = adminProductDto.getBundles();

        if (adminProductBundleDtoSet == null) {
            adminProductDto.setBundles(new HashSet<>());
            adminProductBundleDtoSet = adminProductDto.getBundles();
        }

        Optional<AdminProductBundleDto> adminProductBundleDtoOptional = adminProductBundleDtoSet.stream()
                .filter(o -> o.getId().equals(productAdminSKU.getId()))
                .findFirst();

        AdminProductBundleDto adminProductBundleDto;

        if (adminProductBundleDtoOptional.isEmpty()) {
            adminProductBundleDto = AdminProductBundleDto
                    .builder()
                    .id(productAdminSKU.getId())
                    .sku(productAdminSKU.getSku())
                    .discount(productAdminSKU.getDiscount())
                    .description(productAdminSKU.getDescription())
                    .isNew(productAdminSKU.getIsNew())
                    .onSale(productAdminSKU.getOnSale())
                    .price(productAdminSKU.getPrice())
                    .quantity(productAdminSKU.getQuantity())
                    .imagePath(new ArrayList<>())
                    .build();

            adminProductBundleDtoSet.add(adminProductBundleDto);
        } else {
            adminProductBundleDto = adminProductBundleDtoOptional.get();
        }

        // Check Images
        Optional<String> imageOptional = adminProductBundleDto.getImagePath().stream()
                .filter(o -> o.equals(productAdminSKU.getImagePath()))
                .findFirst();

        if (imageOptional.isEmpty()) {
            adminProductBundleDto.getImagePath().add(productAdminSKU.getImagePath());
        }

        // AdminProductBundleVariant Variants & Variant-Options
        if (adminProductBundleDto.getVariantOptions() == null) {
            adminProductBundleDto.setVariantOptions(new HashSet<>());

            AdminProductBundleVariantDto spvd = AdminProductBundleVariantDto
                    .builder()
                    .variantName(productAdminSKU.getVariant())
                    .variantOption(productAdminSKU.getVariantOption())
                    .build();
            adminProductBundleDto.getVariantOptions().add(spvd);
        } else {
            Optional<AdminProductBundleVariantDto> spvdOptional = adminProductBundleDto.getVariantOptions().stream()
                    .filter(o -> (o.getVariantName().equals(productAdminSKU.getVariant()) && o.getVariantOption().equals(productAdminSKU.getVariantOption())))
                    .findFirst();

            if (spvdOptional.isEmpty()) {
                AdminProductBundleVariantDto spvd = AdminProductBundleVariantDto
                        .builder()
                        .variantName(productAdminSKU.getVariant())
                        .variantOption(productAdminSKU.getVariantOption())
                        .build();
                adminProductBundleDto.getVariantOptions().add(spvd);
            }
        }

        return adminProductDto;
    }
}
