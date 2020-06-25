package com.ip.model;

/**
 * This is just pojo class having.
 */
public class Book {

    private final transient String bookName;
    private final transient int isbn;

    public Book(String bookName, int isbn) {
        this.bookName = bookName;
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("Name:%s ISBN:%s", bookName, isbn);
    }
}
