package com.ip.repository;

import com.ip.model.Book;

import java.util.List;

/**
 * This is an interface to define book's recuirment.
 */
public interface BookStore {
    List<Book> getBooks();
}
