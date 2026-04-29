package com.library;

import com.opencsv.bean.CsvBindByName;

public class Book {

    @CsvBindByName(column = "title", required = true)
    private String title;

    @CsvBindByName(column = "author")
    private String author;

    @CsvBindByName(column = "genre", required = true)
    private String genre;

    @CsvBindByName(column = "subGenre", required = true)
    private String subGenre;

    @CsvBindByName(column = "height", required = true)
    private int height;

    @CsvBindByName(column = "publisher")
    private String publisher;

    @CsvBindByName(column = "isBorrow")
    private boolean isBorrowed;

    public Book() {

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

    public Book(int id, String title, String author, String genre, String subGenre, int height, String publisher, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.subGenre = subGenre;
        this.height = height;
        this.publisher = publisher;
        this.isBorrowed = isBorrowed;
    }

}