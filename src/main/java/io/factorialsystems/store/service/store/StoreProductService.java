package io.factorialsystems.store.service.store;

import io.factorialsystems.store.data.product.ProductSKU;
import io.factorialsystems.store.mapper.product.ProductSKUMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.model.product.StoreProductBundleDto;
import io.factorialsystems.store.web.model.product.StoreProductBundleVariantDto;
import io.factorialsystems.store.web.model.product.StoreProductDto;
import io.factorialsystems.store.web.model.product.StoreProductSKUDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreProductService {
    private final ProductSKUMapper productSKUMapper;

    public List<StoreProductDto> findAll() {
        return Convert(productSKUMapper.findAll(TenantContext.getCurrentTenant()));
    }

    public List<StoreProductDto> search(String searchString) {
        return Convert(productSKUMapper.search(searchString,  TenantContext.getCurrentTenant()));
    }

//    public List<StoreProductDto> findByProductId(Integer id) {
//        return Convert(productSKUMapper.findByProductId(id, TenantContext.getCurrentTenant()));
//    }

//    public List<StoreProductSKUDto> findAllSKU() {
//        return ConvertSKU(productSKUMapper.findAll(TenantContext.getCurrentTenant()));
//    }
//
//    public List<StoreProductSKUDto> findSKUByProductId(Integer productId) {
//        return ConvertSKU(productSKUMapper.findByProductId(productId, TenantContext.getCurrentTenant()));
//    }
//
//    public List<StoreProductSKUDto> findSKUBySkuId(Integer skuId) {
//        return ConvertSKU(productSKUMapper.findBySkuId(skuId, TenantContext.getCurrentTenant()));
//    }

    private List<StoreProductSKUDto> ConvertSKU(List<ProductSKU> productSKUs) {
        Map<Integer, StoreProductSKUDto> storeProductSKUDtoMap = new HashMap<>();

        productSKUs.forEach(product -> {
            StoreProductSKUDto skuDto = storeProductSKUDtoMap.get(product.getId());

            if (skuDto == null) {

                skuDto = StoreProductSKUDto
                        .builder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .category(product.getCategory())
                        .brand(product.getBrand())
                        .id(product.getId())
                        .sku(product.getSku())
                        .price(product.getPrice())
                        .discount(product.getDiscount())
                        .description(product.getDescription())
                        .isNew(product.getIsNew())
                        .sale(product.getOnSale())
                        .images(new ArrayList<>())
                        .build();

                storeProductSKUDtoMap.put(product.getId(), skuDto);
            }

            if (product.getVariant().equals("Color") && skuDto.getColor() == null) {
                skuDto.setColor(product.getVariantOption());
            }

            if (product.getVariant().equals("Size") && skuDto.getSize() == null) {
                skuDto.setSize(product.getVariantOption());
            }

            if (skuDto.getImages().size() == 0) {
                skuDto.getImages().add(product.getImagePath());
            } else {
                Optional<String> imageOptional = skuDto.getImages().stream()
                        .filter(o -> o.equals(product.getImagePath()))
                        .findFirst();

                if (imageOptional.isEmpty()) {
                    //log.info(String.format("Image Not Found in StoreBundle %d including", storeProductBundleDto.getId()));
                    skuDto.getImages().add(product.getImagePath());
                }
            }
        });

        return new ArrayList<>(storeProductSKUDtoMap.values());
    }

    private List<StoreProductDto> Convert(List<ProductSKU> productSKUs) {

        // Create HashMap to Contain all StoreProduct Objects, which will be displayed
        // in the Store
        Map<Integer, StoreProductDto> storeProductDtoMap = new HashMap<>();


        // Loop through RAW Products Loaded from the Database, Not in the desired Format for display
        productSKUs.forEach(productSKU -> {

            // Store-Product
            StoreProductDto storeProductDto = storeProductDtoMap.get(productSKU.getProductId());

            if (storeProductDto == null) {
                //log.info("No StoreProduct Object available creating One");

                Set<String> tags = new HashSet<>();

                storeProductDto = StoreProductDto
                        .builder()
                        .productId(productSKU.getProductId())
                        .name(productSKU.getName())
                        .category(productSKU.getCategory())
                        .brand(productSKU.getBrand())
                        .build();

                storeProductDtoMap.put(productSKU.getProductId(), storeProductDto);
            }

            // Store-Product-Bundle
            Set<StoreProductBundleDto> storeProductBundleDtoSet = storeProductDto.getBundles();

            if (storeProductBundleDtoSet == null) {
                //log.info("No Store Bundle Set Found Creating One");
                storeProductDto.setBundles(new HashSet<>());
                storeProductBundleDtoSet = storeProductDto.getBundles();
            }

            Optional<StoreProductBundleDto> storeProductBundleDtoOptional = storeProductBundleDtoSet.stream()
                    .filter(o -> o.getId().equals(productSKU.getId()))
                    .findFirst();

            StoreProductBundleDto storeProductBundleDto;

            if (storeProductBundleDtoOptional.isEmpty()) {
                //log.info(String.format("StoreBundle %d Empty", productSKU.getId()));

                storeProductBundleDto = StoreProductBundleDto
                        .builder()
                        .id(productSKU.getId())
                        .sku(productSKU.getSku())
                        .discount(productSKU.getDiscount())
                        .description(productSKU.getDescription())
                        .isNew(productSKU.getIsNew())
                        .onSale(productSKU.getOnSale())
                        .stock(productSKU.getStock())
                        .price(productSKU.getPrice())
                        .imagePath(new ArrayList<>())
                        .vatExclusive(productSKU.getVatExclusive())
                        .build();

                storeProductBundleDtoSet.add(storeProductBundleDto);

            } else {
                storeProductBundleDto = storeProductBundleDtoOptional.get();
                //log.info(String.format("Store Bundle %d Found", storeProductBundleDto.getId()));
            }

            // Check Images
            Optional<String> imageOptional = storeProductBundleDto.getImagePath().stream()
                    .filter(o -> o.equals(productSKU.getImagePath()))
                    .findFirst();

            if (imageOptional.isEmpty()) {
                //log.info(String.format("Image Not Found in StoreBundle %d including", storeProductBundleDto.getId()));
                storeProductBundleDto.getImagePath().add(productSKU.getImagePath());
            }

            // StoreProductBundleVariant Variants & Variant-Options
            if (storeProductBundleDto.getVariantOptions() == null) {
                //log.info(String.format("StoreBundle %d has no variants", storeProductBundleDto.getId()));
                storeProductBundleDto.setVariantOptions(new HashSet<>());

                StoreProductBundleVariantDto spvd =  StoreProductBundleVariantDto
                        .builder()
                        .variantName(productSKU.getVariant())
                        .variantOption(productSKU.getVariantOption())
                        .build();
                storeProductBundleDto.getVariantOptions().add(spvd);
            } else {
                //log.info(String.format("StoreBundle %d has variants", storeProductBundleDto.getId()));
                Optional<StoreProductBundleVariantDto> spvdOptional = storeProductBundleDto.getVariantOptions().stream()
                        .filter(o -> (o.getVariantName().equals(productSKU.getVariant()) && o.getVariantOption().equals(productSKU.getVariantOption())))
                        .findFirst();

                if (spvdOptional.isEmpty()) {
                    StoreProductBundleVariantDto spvd =  StoreProductBundleVariantDto
                            .builder()
                            .variantName(productSKU.getVariant())
                            .variantOption(productSKU.getVariantOption())
                            .build();
                    storeProductBundleDto.getVariantOptions().add(spvd);
                }
            }
        });

        return new ArrayList<>(storeProductDtoMap.values());
    }
}
