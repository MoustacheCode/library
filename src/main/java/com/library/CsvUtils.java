package com.library;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class CsvUtils {

    public static ArrayList<Book> loadBooks() {

        InputStream inputStream = CsvUtils.class.getClassLoader().getResourceAsStream("books_new.csv");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List<Book> books = new CsvToBeanBuilder<Book>(reader).withType(Book.class).withIgnoreLeadingWhiteSpace(true).build().parse();

        return new ArrayList<>(books);
    }

}

