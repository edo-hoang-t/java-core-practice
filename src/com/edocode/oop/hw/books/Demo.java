package com.edocode.oop.hw.books;

import java.math.BigDecimal;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        BookService bs = new BookService();

        Book[] books = new Book[4];
        books[0] = new Book(1, "Book_1", new Author[]{new Author(1, "Jon", "Johnson")}, new Publisher(1, "Publisher_1"), 1990, 231, BigDecimal.valueOf(24.99), CoverType.PAPERBACK);
        books[1] = new Book(2, "Book_2", new Author[]{new Author(1, "Jon", "Johnson"), new Author(2, "William", "Wilson")}, new Publisher(2, "Publisher_2"), 2000, 120, BigDecimal.valueOf(14.99), CoverType.PAPERBACK);
        books[2] = new Book(3, "Book_3", new Author[]{new Author(3, "Walter", "Peterson")}, new Publisher(1, "Publisher_1"), 1997, 350, BigDecimal.valueOf(34.99), CoverType.HARDCOVER);
        books[3] = new Book(4, "Book_4", new Author[]{new Author(4, "Craig", "Gregory")}, new Publisher(3, "Publisher_3"), 1992, 185, BigDecimal.valueOf(19.99), CoverType.PAPERBACK);

        System.out.println(Arrays.toString(
                bs.filterBooksByAuthor(new Author(1, "Jon", "Johnson"), books)));

        System.out.println(Arrays.toString(
                bs.filterBooksByPublisher(new Publisher(3, "Publisher_3"), books)));

        System.out.println(Arrays.toString(
                bs.filterBooksAfterSpecifiedYear(1992, books)));
    }
}
