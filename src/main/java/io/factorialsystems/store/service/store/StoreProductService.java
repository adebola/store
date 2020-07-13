package io.factorialsystems.store.service.store;

import io.factorialsystems.store.domain.product.ProductSKU;
import io.factorialsystems.store.mapper.product.ProductSKUMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.model.product.StoreProductBundleDto;
import io.factorialsystems.store.web.model.product.StoreProductBundleVariantDto;
import io.factorialsystems.store.web.model.product.StoreProductDto;
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

    public List<StoreProductDto> findByProductId(Integer id) {
        return Convert(productSKUMapper.findByProductId(id, TenantContext.getCurrentTenant()));
    }

    private List<StoreProductDto> Convert(List<ProductSKU> productSKUs) {

        // Create HashMap to Contain all StoreProduct Objects, which will be displayed
        // in the Store
        Map<Integer, StoreProductDto> storeProductDtoMap = new HashMap<>();

        // Loop through RAW Products Loaded from the Database, Not in the desired Format for display
        productSKUs.forEach(productSKU -> {

            StoreProductDto storeProductDto = storeProductDtoMap.get(productSKU.getProductId());

            if (storeProductDto == null) {
                log.info("No StoreProduct Object available creating One");

                Set<String> images = new HashSet<>();

                if (productSKU.getImagePath() != null) {
                    images.add(productSKU.getImagePath());
                }

                storeProductDto = StoreProductDto
                        .builder()
                        .id(productSKU.getProductId())
                        .name(productSKU.getName())
                        .description(productSKU.getDescription())
                        .brand(productSKU.getBrand())
                        .isNew(productSKU.getIsNew())
                        .onSale(productSKU.getOnSale())
                        .images(images)
                        .build();

                storeProductDtoMap.put(productSKU.getProductId(), storeProductDto);
            } else {

                if (productSKU.getImagePath() != null) {

                    Optional<String> imagepath = storeProductDto.getImages().stream()
                            .filter(o -> o.equals(productSKU.getImagePath()))
                            .findFirst();

                    if (!imagepath.isPresent()) {
                        storeProductDto.getImages().add(productSKU.getImagePath());
                    }
                }

                log.info("StoreProduct Object Found");
            }

            Set<StoreProductBundleDto> storeProductBundleDtoSet = storeProductDto.getBundles();

            if (storeProductBundleDtoSet == null) {
                log.info("No Store Bundle Found Creating One");
                storeProductBundleDtoSet = new HashSet<>();
                storeProductDto.setBundles(storeProductBundleDtoSet);
            } else {
                log.info("Store Bundle Found");
            }

            Optional<StoreProductBundleDto> storeProductBundleDtoOptional = storeProductBundleDtoSet.stream()
                    .filter(o -> o.getId().equals(productSKU.getSku()))
                    .findFirst();

            StoreProductBundleDto storeProductBundleDto;

            if (storeProductBundleDtoOptional.isPresent()) {
                log.info("StoreBundleDto Found in Set");
                storeProductBundleDto = storeProductBundleDtoOptional.get();
            } else {
                log.info("StoreBundleDto NOT Found in Set");
                storeProductBundleDto = StoreProductBundleDto.builder()
                        .price(productSKU.getPrice())
                        .id(productSKU.getSku())
                        .build();

                storeProductBundleDtoSet.add(storeProductBundleDto);
            }

            StoreProductBundleVariantDto spbvd = StoreProductBundleVariantDto.builder()
                    .variantName(productSKU.getVariant())
                    .VariantOption(productSKU.getVariant_options())
                    .build();

            if (storeProductBundleDto.getVariantOptions() == null) {
                storeProductBundleDto.setVariantOptions(new HashSet<>());
            }

            storeProductBundleDto.getVariantOptions().add(spbvd);
        });

        return new ArrayList<>(storeProductDtoMap.values());

    }
}
