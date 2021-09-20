package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    @Test
    void shouldSearchByTitle() {
        Product product = new Product();
        product.setName("Колобок");
        boolean actual = product.matches("оло");
        assertTrue(actual);
    }

}
