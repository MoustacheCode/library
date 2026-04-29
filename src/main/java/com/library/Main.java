import com.library.Book;
import com.library.CsvUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public static void main(String[] args) throws FileNotFoundException {

    // Book Data
    ArrayList<Book> books = CsvUtils.loadBooks();

    for (Book b: books) {
        System.out.println("---");

        System.out.println("Author: " + b.getAuthor());
        System.out.println("Title: " + b.getTitle());
        System.out.println("Genre: " + b.getGenre());
        System.out.println("SubGenre: " + b.getSubGenre());
        System.out.println("Publisher: " + b.getPublisher());
        System.out.println("ID: " + b.getId());
        System.out.println(b.isBorrowed());

    }
}