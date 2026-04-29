package com.library;

import java.util.ArrayList;

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
        // Book Borrow logic - Create UI to wire up correctly
 //   public boolean borrowBook(String title) {
 //       for (Book book : books) {
 //           if (book.getId() == bookId) {
 //               if (book.isBorrowed()) {
 //                   return false;
 //               }
 //
 //               book.setIsBorrowed(true);
 //               return true;
 //           }

  //          return false;
 //       }

  //      return false;
  //  }


}