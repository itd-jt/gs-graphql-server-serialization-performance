package com.example.graphqlserver;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class BookListAsJSON {

    public static String bookListAsJSON(List<Book> books) throws JsonProcessingException {
        List<BookWithAuthor> l = convertToBooksWithAuthor(books);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(l);
    }

    private record BookWithAuthor(String id, String name, int pageCount, Author author) {
    }

    private static List<BookWithAuthor> convertToBooksWithAuthor(List<Book> books) {
        List<BookWithAuthor> booksWithAuthor = new ArrayList<>();
        for (Book book : books) {
            BookWithAuthor bookWithAuthor = new BookWithAuthor(book.id(), book.name(), book.pageCount(), Author.getById(book.authorId()));
            booksWithAuthor.add(bookWithAuthor);
        }
        return booksWithAuthor;
    }
}
