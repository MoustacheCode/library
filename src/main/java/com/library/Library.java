package com.library;


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


}


