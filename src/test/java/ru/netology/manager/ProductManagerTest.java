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
    private Book second = new Book(2, "Введение в Питон", 300, "Гугл");
    private Book third = new Book(3, "Преступление и наказание", 300, "Достоевский");
    private Smartphone fourth = new Smartphone(4, "Sony-500", 15000, "Sony");
    private Smartphone fifth = new Smartphone(5, "LG-500", 15000, "LG");
    private Smartphone sixth = new Smartphone(6, "Apple 5C", 15000, "Apple");
    private ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    void searchBy() {
        Product[] actual = manager.searchBy("Гугл");
        Product[] expected = new Product[] {second};
        assertArrayEquals(expected, actual);
    }
}