package com.library;

import com.opencsv.bean.CsvBindByName;

public class Book {

    @CsvBindByName(column = "Id")
    private int id;

    @CsvBindByName(column = "Title", required = true)
    private String title;

    @CsvBindByName(column = "Author")
    private String author;

    @CsvBindByName(column = "Genre", required = true)
    private String genre;

    @CsvBindByName(column = "SubGenre", required = true)
    private String subGenre;

    @CsvBindByName(column = "Height", required = true)
    private int height;

    @CsvBindByName(column = "Publisher")
    private String publisher;

    @CsvBindByName
    private boolean isBorrowed;

    @CsvBindByName(column = "BorrowedByUsername")
    private String borrowedByUsername;

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book(int i, String number, String georgeOrwell, boolean b) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String getBorrowedByUsername() {
        return borrowedByUsername;
    }

    public void setBorrowedByUsername(String borrowedByUsername) {
        this.borrowedByUsername = borrowedByUsername;
    }

    public Book(int id, String title, String author, String genre, String subGenre, int height, String publisher, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.subGenre = subGenre;
        this.height = height;
        this.publisher = publisher;
        this.isBorrowed = isBorrowed;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author;
    }

}