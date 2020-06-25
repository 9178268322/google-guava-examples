package com.ip.service;

import com.ip.imp.BookStoreImp;
import com.ip.model.Book;
import com.ip.repository.BookStore;

import java.util.List;

/**
 * This is book's service class to provide the service.
 */
public class BookService {

    private final transient BookStore store;

    public BookService(BookStore store) {
        this.store = store;
    }

    public List<Book> getListBooks() {
        return store.getBooks();
    }

    public static BookService getService() {
        return new BookService(new BookStoreImp());
    }
}
