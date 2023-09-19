package com.example.graphqlserver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class BookController {

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> allBooks(@Argument int nrOfBooks) {
        long startTime = System.currentTimeMillis(); // Record the start time

        List<Book> books = Book.getAll(nrOfBooks);

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("BookController.allBooks(): " + totalTime + " ms.");

        return books;
    }

    @QueryMapping
    public String allBooksAsJSON(@Argument int nrOfBooks) throws JsonProcessingException {
        long startTime = System.currentTimeMillis(); // Record the start time

        String json = BookListAsJSON.bookListAsJSON(Book.getAll(nrOfBooks));

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("BookController.allBooksAsJSON(): " + totalTime + " ms.");

        return json;
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}