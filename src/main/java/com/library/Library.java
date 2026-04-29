package com.library;

import java.util.ArrayList;
import java.util.Scanner;

// Storing the books
public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> listBooks() {
        return books;
    }

    public ArrayList<Book> searchBooks(String query) {
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }
}