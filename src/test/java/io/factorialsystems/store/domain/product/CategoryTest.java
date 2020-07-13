package io.factorialsystems.store.domain.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {
    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Integer id = 2;
        category.setId(id);

        assertEquals(id, category.getId());
    }

    @Test
    void getName() {
        String name = "Category";
        category.setName(name);

        assertEquals(name, category.getName());
    }

    @Test
    void getCreatedDate() {
        Date dateNow = new Date();
        category.setCreatedDate(dateNow);

        assertEquals(dateNow, category.getCreatedDate());
    }

    @Test
    void getLastModifiedDate() {
        Date dateNow = new Date();
        category.setCreatedDate(dateNow);

        assertEquals(dateNow, category.getCreatedDate());
    }

    @Test
    void getTenantId() {
        UUID uuid = UUID.randomUUID();
        category.setTenantId(uuid.toString());

        assertEquals(uuid.toString(), category.getTenantId());
    }
}
