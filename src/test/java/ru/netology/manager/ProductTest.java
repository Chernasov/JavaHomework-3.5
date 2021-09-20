package ru.netology.manager;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    @ParameterizedTest
    @CsvSource(
            {"'search by whole word', 'Колобок', 'Колобок'",
             "'search by part of a word', 'Преступление и наказание', 'казан'",
             "'empty search', 'Репка', ''"}
    )
    void shouldSearchByNameRight(String test, String name, String text) {
        Product product = new Product();
        product.setName(name);
        boolean actual = product.matches(text);
        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource(
            {"'search by more length word', 'Колобок', 'Колобок и'",
             "'search by wrong word', 'Репка', '9'"}
    )
    void shouldSearchByNameWrong(String test, String name, String text) {
        Product product = new Product();
        product.setName(name);
        boolean actual = product.matches(text);
        assertFalse(actual);
    }

}
