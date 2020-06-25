package com.ip.collections;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.ip.model.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class conatins functions to store books
 * using non maps and maps unique index.
 */
public class MapsUtility {

    /**
     * This is just demo with out maps.uniqueIndex.
     * @return
     */
    public Map<Integer, Book> doBookStore(List<Book> bookList) {
        Map<Integer, Book> bookMap = new HashMap<>();
        for (Book book : bookList) {
            bookMap.put(book.getIsbn(), book);
        }
        return bookMap;
    }

    /**
     * Used with maps.uniqueIndex.
     */
    public Map<Integer, Book> doUniquesIndex(List<Book> bookList) {
        if (bookList == null || bookList.isEmpty()) {
            throw new IllegalArgumentException("BookList can't be null");
        }
        return Maps.uniqueIndex(bookList.iterator(), new Function<Book, Integer>() {
            @Override
            public Integer apply(Book input) {
                return input.getIsbn();
            }
        });
    }
}
