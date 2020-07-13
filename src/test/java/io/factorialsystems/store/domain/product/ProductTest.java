package io.factorialsystems.store.domain.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void getId() {
        int idValue = 2;

        product.setId(idValue);

        assertEquals(idValue, product.getId());
    }

    @Test
    void getName() {
        String name = "ProductName";
        product.setName(name);

        assertEquals(name, product.getName());
    }

    @Test
    void getCategory() {
        int id = 1;
        String name = "Category";
        Date date = new Date();
        UUID tenantId = UUID.randomUUID();

        Category category =  new Category();
        category.setId(id);
        category.setName(name);
        category.setCreatedDate (date);
        category.setLastModifiedDate(date);
        category.setTenantId(tenantId.toString());

        product.setCategory(category);

        assertEquals(id, product.getCategory().getId());
        assertEquals(name, product.getCategory().getName());
        assertEquals(date, product.getCategory().getCreatedDate());
        assertEquals(date, product.getCategory().getLastModifiedDate());
        assertEquals(tenantId.toString(), product.getCategory().getTenantId());
    }

    @Test
    void getCreatedDate() {
        Date date = new Date();
        product.setCreatedDate(date);

        assertEquals(date, product.getCreatedDate());
    }

    @Test
    void getLastModifiedDate() {
        Date date = new Date();
        product.setLastModifiedDate(date);

        assertEquals(date, product.getLastModifiedDate());
    }

    @Test
    void getTenantId() {
        UUID uuid = UUID.randomUUID();
        product.setTenantId(uuid.toString());

        assertEquals(uuid.toString(), product.getTenantId());
    }

    @Test
    void getVariants() {
        String variantName = "ProductVariant";
        ProductVariant productVariant = new ProductVariant();
        productVariant.setId(1);
        productVariant.setProductId(product.getId());
        productVariant.setName(variantName);
        product.addVariant(productVariant);

        assertEquals(product.getVariants().size(), 1);
        assertEquals(product.getVariants().get(0).getId(), 1);
        assertEquals(product.getVariants().get(0).getName(),variantName);
    }
}
