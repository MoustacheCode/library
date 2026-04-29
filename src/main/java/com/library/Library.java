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
}