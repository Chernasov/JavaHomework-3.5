package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Введение в джаву", 300, "Котлин");
    private Book second = new Book(2, "Введение в Гугл", 300, "Гугл");
    private Book third = new Book(3, "Преступление и наказание", 300, "Достоевский");
    private Smartphone fourth = new Smartphone(4, "SFX-500", 15000, "Sony");
    private Smartphone fifth = new Smartphone(5, "LG-500", 15000, "LG");
    private Smartphone sixth = new Smartphone(6, "5C", 15000, "Apple");
    private Product seventh = new Product(7,"Колобок",100);
    private ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Котлин");
        Product[] expected = new Product[] {first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTitle() {
        Product[] actual = manager.searchBy("Преступление");
        Product[] expected = new Product[] {third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTitleMatches() {
        Product[] actual = manager.searchBy("Введение");
        Product[] expected = new Product[] {first, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {
        Product[] actual = manager.searchBy("SFX");
        Product[] expected = new Product[] {fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacture() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[] {sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWithoutMatches() {
        Product[] actual = manager.searchBy("Acer");
        Product[] expected = new Product[] {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByVoid() {
        Product[] actual = manager.searchBy("");
        Product[] expected = new Product[] {first, second, third, fourth, fifth, sixth};
        assertArrayEquals(expected, actual);
    }

}