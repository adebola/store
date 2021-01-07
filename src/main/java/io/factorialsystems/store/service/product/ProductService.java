package io.factorialsystems.store.service.product;

import io.factorialsystems.store.data.image.SKUImage;
import io.factorialsystems.store.data.product.ProductAdminSKU;
import io.factorialsystems.store.data.product.SPVO;
import io.factorialsystems.store.domain.image.Image;
import io.factorialsystems.store.domain.product.*;
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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductMSMapper productMSMapper;
    private final CategoryMapper categoryMapper;
    private final ProductSKUMapper productSKUMapper;
    private final PlatformTransactionManager transactionManager;

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
        ProductAdminSKU productAdminSKU = productSKUMapper.findByProductId(id, TenantContext.getCurrentTenant());

        if (productAdminSKU != null) {
            return Convert(productAdminSKU);
        }

        return null;
    }

    public Boolean updateSKU(Integer id, AdminProductDto adminProductDto) {

        AdminProductBundleDto adminProductBundleDto = adminProductDto.getBundles().stream().findFirst().get();
        AdminProductBundleVariantDto adminProductBundleVariantDto = adminProductBundleDto.getVariantOptions().stream().findFirst().get();

        TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            // Update Product
            Product product = new Product();
            product.setBrand(adminProductDto.getBrand());
            product.setCategoryId(adminProductDto.getCategoryId());
            product.setName(adminProductDto.getName());
            product.setDescription(adminProductBundleDto.getDescription());
            product.setTenantId(TenantContext.getCurrentTenant());
            productMapper.updateProduct(id, product);

            // Update SKU Product
            productSKUMapper.updateProductSKU(adminProductBundleDto, TenantContext.getCurrentTenant());

            // Update SKU ImagePath
            productSKUMapper.updateSKUImagePath(adminProductBundleDto.getId(), adminProductBundleDto.getImagePath().get(0));

            // Update The Variant
            productSKUMapper.updateProductVariantOptions(adminProductBundleVariantDto.getId(), adminProductBundleVariantDto.getVariantOption());
        } catch (Exception e) {
            transactionManager.rollback(txStatus);
            return false;
        }

        transactionManager.commit(txStatus);


        return true;
    }

    public Boolean saveSKU(AdminProductDto adminProductDto) {

        AdminProductBundleDto adminProductBundleDto = adminProductDto.getBundles().stream().findFirst().get();
        AdminProductBundleVariantDto adminProductBundleVariantDto = adminProductBundleDto.getVariantOptions().stream().findFirst().get();

        TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            // Save the product
            Product product = new Product();
            product.setBrand(adminProductDto.getBrand());
            product.setCategoryId(adminProductDto.getCategoryId());
            product.setName(adminProductDto.getName());
            product.setDescription(adminProductBundleDto.getDescription());
            product.setTenantId(TenantContext.getCurrentTenant());
            productMapper.saveProduct(product);

            Integer productId = product.getId();
            if (productId == null) {
                throw new RuntimeException("Error Saving Product");
            }

            log.info(String.format("Product Id: %d Name: %s saved Successfully", product.getId(), product.getName()));

            // Save ProductVariant
            ProductVariant pv = new ProductVariant();
            pv.setName(adminProductBundleVariantDto.getVariantName());
            pv.setTenantId(TenantContext.getCurrentTenant());
            pv.setProductId(productId);
            productMapper.saveProductVariant(pv);

            Integer pvId = pv.getId();

            if (pvId == null) {
                throw new RuntimeException("Error Saving Product Variant");
            }

            log.info(String.format("Product Variant Id: %d Name: %s saved Successfully", pv.getId(), pv.getName()));

            // Save ProductVariantOptions
            ProductVariantOption pvo = new ProductVariantOption();
            pvo.setName(adminProductBundleVariantDto.getVariantOption());
            pvo.setProductVariantId(pvId);
            pvo.setTenantId(TenantContext.getCurrentTenant());
            productMapper.saveProductVariantOption(pvo);

            Integer pvoId = pvo.getId();

            if (pvo == null) {
                throw new RuntimeException("Product Variant Option");
            }

            log.info(String.format("Product Variant Option Id: %d Name: %s saved Successfully", pvo.getId(), pvo.getName()));

            // Save Product SKU
            SKU sku = SKU.builder()
                    .discount(adminProductBundleDto.getDiscount())
                    .price(adminProductBundleDto.getPrice())
                    .sku(adminProductBundleDto.getSku())
                    .onSale(adminProductBundleDto.getOnSale())
                    .isNew(adminProductBundleDto.getIsNew())
                    .quantity(adminProductBundleDto.getQuantity())
                    .description(adminProductBundleDto.getDescription())
                    .productId(productId)
                    .tenantId(TenantContext.getCurrentTenant())
                    .build();

            productSKUMapper.saveProductSKU(sku);

            Integer skuId = sku.getId();

            if (skuId == null) {
                throw new RuntimeException("Unable to save SKU");
            }

            log.info(String.format("Product SKU Id: %d SKU: %s saved Successfully", sku.getId(), sku.getSku()));

            // Insert into Normalising Table sku_product_variant_options
            SPVO spvo = new SPVO(skuId, pvoId);
            productSKUMapper.saveSPVO(spvo);

            // Save Image
            Image image = new Image(adminProductBundleDto.getImagePath().stream().findFirst().get());
            productSKUMapper.saveProductImage(image);

            Integer imageId = image.getId();

            if (imageId == null) {
                throw new RuntimeException(String.format("Unable to Save Image %s", adminProductBundleDto.getImagePath().stream().findFirst().get()));
            }

            log.info(String.format("Image SKU Id: %d path: %s saved Successfully", image.getId(), image.getImagePath()));

            // Link Image in the sku_images table
            SKUImage skuImage = new SKUImage(skuId, imageId);
            productSKUMapper.saveProductSKUImage(skuImage);
        } catch (Exception e) {
            transactionManager.rollback(txStatus);
            return false;
        }

        transactionManager.commit(txStatus);
        return true;
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
                    .id(productAdminSKU.getVariantOptionId())
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
                        .id(productAdminSKU.getVariantOptionId())
                        .variantName(productAdminSKU.getVariant())
                        .variantOption(productAdminSKU.getVariantOption())
                        .build();
                adminProductBundleDto.getVariantOptions().add(spvd);
            }
        }

        return adminProductDto;
    }

    public List<ProductTag> getProductTags(Integer id) {
        return productMapper.getTags(id);
    }

    public void deleteProductTag(Integer id, Integer productId) {
        productMapper.deleteTag(id, productId);
    }

    public void saveProductTag(ProductTag productTag) {
        productMapper.saveTag(productTag);

        if (productTag.getId() == null) {
            throw new RuntimeException("Error Saving Tag");
        }

        log.info(String.format("PRODUCT-TAG id: %d, tagName: %s, productId: %d", productTag.getId(), productTag.getTagName(), productTag.getProductId()));

        productMapper.linkTag(productTag);
    }
}
