package ru.netology.manager;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Book;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {
    @ParameterizedTest
    @CsvSource(
            {"'search by whole word', 'Достоевский Ф.М.', 'Идиот', 'Достоевский Ф.М.'",
             "'search by part of a word', 'Булгаков М.А.', 'Мастер и Маргарита', 'улга'",
             "'empty search', 'Толкиен Дж.Р.Р.', 'Хоббит', ''"}
    )
    void shouldSearchByAuthorRight(String test, String author, String name, String text) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        boolean actual = book.matches(text);
        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource(
            {"'search by more length word', 'Достоевский Ф.М.', 'Идиот', 'Достоевский Ф.М.&'",
             "'search by wrong word', 'Толкиен Дж.Р.Р.', 'Хоббит', '7'"}
    )
    void shouldSearchByNameWrong(String test, String author, String name, String text) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        boolean actual = book.matches(text);
        assertFalse(actual);
    }

}
