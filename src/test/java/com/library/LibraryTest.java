package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    @Test
    public void testLibraryStoresBooks() {

        // Create a list with one book
        var books = new java.util.ArrayList<Book>();
        books.add(new Book(
                1,
                "Test Title",
                "Test Author",
                "Fantasy",
                "Epic",
                200,
                "Test Publisher",
                false,
                "ron"
        ));

        // Create the library
        Library library = new Library(books);

        // check the library returns the same list size
        assertEquals(1, library.getBooks().size());
    }

}
