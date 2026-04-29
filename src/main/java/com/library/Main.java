import com.library.Book;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public static void main(String[] args) throws FileNotFoundException {


    FileReader fileReader = new FileReader("src/main/java/resources/books_new.csv");
    CSVReader csvReader = new CSVReader(fileReader);

    ArrayList<Book> bookList = new ArrayList<>(new CsvToBeanBuilder<Book>(csvReader).withType(Book.class).withIgnoreLeadingWhiteSpace(true).build().stream().toList());

    for (Book model: bookList) {
        System.out.println("---");
        System.out.println(model.getAuthor());
        System.out.println(model.getTitle());
        System.out.println(model.getGenre());
        System.out.println(model.getSubGenre());
        System.out.println(model.getPublisher());
        System.out.println(model.isBorrowed());
    }
}