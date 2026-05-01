package com.library;


import com.library.user.User;

import java.util.ArrayList;
import java.util.List;

// Storing the books
public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
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
      //   Book Borrow Method - Create UI to wire up correctly
    public boolean borrowBook(String title, int bookId) {
        for (Book book : books) {
            // Match ID
            if (bookId > 0 && book.getId() == bookId) {
                if (book.isBorrowed()) {
                    return false; //borrowed
                }

                book.setIsBorrowed(true);
                return true;

            }
            // Match title
            if (title != null && book.getTitle().toLowerCase().contains(title.toLowerCase()) ) {

                if (book.isBorrowed()) {
                    return false; // borrowed
                }

                book.setIsBorrowed(true);
                return true; // success
            }

        }
        // no books found
        return false;
   }

    public boolean returnBook(User currentUser, String title, int bookId) {

        for (Book book : books) {

            // 1. Match by ID
            if (bookId > 0 && book.getId() == bookId) {
                return processReturn(currentUser, book);
            }

            // 2. Match by title (partial match)
            if (title != null && book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return processReturn(currentUser, book);
            }
        }

        System.out.println("Sorry - My dog ate this book! Is there anything else you'd like?");
        return false;
    }

    private boolean processReturn(User currentUser, Book book) {

        // Not borrowed at all
        if (!book.isBorrowed()) {
            System.out.println("Here we are - It might be a bit dusty!");
            return false;
        }

        // Borrowed by someone else
        if (!book.getBorrowedByUsername().equals(currentUser.getUsername())) {
            System.out.println("Wait a minute...This book was borrowed by: "
                    + book.getBorrowedByUsername() + "!!");
            return false;
        }

        // Return the book
        book.setIsBorrowed(false);
        book.setBorrowedByUsername(null);

        CsvUtils.saveBooks(books);

        System.out.println("Thanks! I actually wanted to read " + book.getTitle());
        return true;
    }




}


