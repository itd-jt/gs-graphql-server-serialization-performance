package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public record Book (String id, String name, int pageCount, String authorId) {

    private static List<Book> getBookList(int nrOfBooks) {
        List<Book> books = new ArrayList<>();
        String[] authors = { "author-1", "author-2", "author-3" };

        for (int i = 1; i <= nrOfBooks; i++) {
            String bookId = "book-" + i;
            String title = "Book Title " + i;
            int pageCount = 123;
            String author = authors[i % authors.length];

            Book book = new Book(bookId, title, pageCount, author);
            books.add(book);
        }

        return books;
    }

    public static Book getById(String id) {
        return getBookList(10).stream()
				.filter(book -> book.id().equals(id))
				.findFirst()
				.orElse(null);
    }

    public static List<Book> getAll(int nrOfBooks) {
        return getBookList(nrOfBooks).stream().toList();
    }
}
