package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartphoneTest {
    @ParameterizedTest
    @CsvSource(
            {"'search by whole word', 'Samsung', 'A51', 'Samsung'",
             "'search by part of a word', 'Sony', 'FGT-700', 'on'",
             "'empty search', 'Apple', '9X', ''"}
    )
    void shouldSearchByAuthorRight(String test, String manufacturer, String name, String text) {
        Smartphone smartphone = new Smartphone();
        smartphone.setManufacturer(manufacturer);
        smartphone.setName(name);
        boolean actual = smartphone.matches(text);
        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource(
            {"'search by more length word', 'Xiaomi', 'Mi-9', 'Xiaomi+'",
                    "'search by wrong word', 'Huawey', '96', 'z'"}
    )
    void shouldSearchByNameWrong(String test, String manufacturer, String name, String text) {
        Smartphone smartphone = new Smartphone();
        smartphone.setManufacturer(manufacturer);
        smartphone.setName(name);
        boolean actual = smartphone.matches(text);
        assertFalse(actual);
    }

}
