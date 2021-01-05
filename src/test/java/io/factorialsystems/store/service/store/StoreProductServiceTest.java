package io.factorialsystems.store.service.store;

import io.factorialsystems.store.data.product.ProductSKU;
import io.factorialsystems.store.mapper.product.ProductSKUMapper;
import io.factorialsystems.store.security.TenantContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class StoreProductServiceTest {

    MockMvc mockMvc;
    StoreProductService service;

    @Mock
    ProductSKUMapper productSKUMapper;

    @Mock
    TenantContext tenantContext;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new StoreProductService(productSKUMapper);
    }

    @Test
    void findAll() {
        int skuId1 = 1;
        int productId1 = 1;
        String productName1 = "Panla";
        String imagePath1 = "https://www.imagepath.io";
        String variant1 = "Package";
        String variantOption1 = "Kg";
        String variant2 = "Size";
        String variantOption2 = "Large";

        ProductSKU p1 = new ProductSKU();
        //p1.setSku(skuId1);
        p1.setProductId(productId1);
        p1.setName(productName1);
        p1.setImagePath(imagePath1);
        p1.setVariant(variant1);
        p1.setVariantOption(variantOption1);

        ProductSKU p2 = new ProductSKU();
        //p2.setSku(skuId1);
        p2.setProductId(productId1);
        p2.setName(productName1);
        p2.setImagePath(imagePath1);
        p2.setVariant(variant2);
        p2.setVariantOption(variantOption2);

        List<ProductSKU> skuList = Arrays.asList(p1, p2);

        when(productSKUMapper.findAll(anyString())).thenReturn(skuList);
        //when(TenantContext.getCurrentTenant()).thenReturn("ca7f369c-7fef-11ea-8e3b-62fdd0190df3");

        //List<StoreProductDto> results =  service.findAll();
        //assertEquals(2, results.size());
    }

    @Test
    void findByProductId() {
    }
}
