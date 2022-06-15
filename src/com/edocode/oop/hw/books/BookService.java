package com.edocode.oop.hw.books;

import java.util.Arrays;

public class BookService {
    public Book[] filterBooksByAuthor(Author author, Book[] books) {
        Book[] filteredBooks = new Book[books.length];
        int counter = 0;

        for (Book book : books) {
            if (Arrays.asList(book.getAuthors()).contains(author)) {
                filteredBooks[counter] = book;
                counter += 1;
            }
        }

        Book[] results = new Book[counter];
        for (int i = 0; i < counter; ++i) {
            results[i] = filteredBooks[i];
        }
        return results;
    }

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
        Book[] filteredBooks = new Book[books.length];
        int counter = 0;

        for (Book book : books) {
            if (publisher.equals(book.getPublisher())) {
                filteredBooks[counter] = book;
                counter += 1;
            }
        }

        Book[] results = new Book[counter];
        for (int i = 0; i < counter; ++i) {
            results[i] = filteredBooks[i];
        }
        return results;
    }

    // methods keeps books with publishing year inclusively.
    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
        Book[] filteredBooks = new Book[books.length];
        int counter = 0;

        for (Book book : books) {
            if (book.getPublishingYear() >= yearFromInclusively) {
                filteredBooks[counter] = book;
                counter += 1;
            }
        }

        Book[] results = new Book[counter];
        for (int i = 0; i < counter; ++i) {
            results[i] = filteredBooks[i];
        }
        return results;
    }

}
