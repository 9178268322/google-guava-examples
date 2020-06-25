package com.ip.imp;

import com.ip.model.Book;
import com.ip.repository.BookStore;

import java.util.Arrays;
import java.util.List;

/**
 * This is the implementaion class of BookStore interface.
 */
public class BookStoreImp implements BookStore {
    @Override
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book("Code Complete", 1234),
                new Book("Clean Code", 5463),
                new Book("Design Patterns", 8971),
                new Book("Head First", 5590),
                new Book("Refactoring", 6661)
        );
    }
}
