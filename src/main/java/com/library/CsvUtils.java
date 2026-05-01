package com.library;

import com.library.user.User;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class CsvUtils {

    public static ArrayList<Book> loadBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try {
            Reader reader = new FileReader("data/books_new.csv");

            books = new ArrayList<>(
                    new CsvToBeanBuilder<Book>(reader)
                            .withType(Book.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build()
                            .parse()
            );

            reader.close();

            // Temp to assign id
            int nextId = 1;
            for (Book b : books) {
                b.setId(nextId++);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public static void saveBooks(List<Book> books) {
        try {
            Writer writer = new FileWriter("data/books_new.csv");

            StatefulBeanToCsv<Book> beanToCsv = new StatefulBeanToCsvBuilder<Book>(writer)
                    .withApplyQuotesToAll(false)
                    .build();

            beanToCsv.write(books);
            writer.close();

        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    public static List<User> loadUsers() {
        try {
            return new CsvToBeanBuilder<User>(new FileReader("users.csv"))
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveUsers(List<User> users) {
        try (Writer writer = new FileWriter("users.csv")) {
            StatefulBeanToCsv<User> beanToCsv = new StatefulBeanToCsvBuilder<User>(writer).build();
            beanToCsv.write(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


