package com.library;

import com.library.user.User;
import com.library.user.UserManager;

import java.util.ArrayList;
import java.util.Scanner;

// Interface in Command Line
public class LibraryApp {
    private UserManager userManager;
    private User user;
    private Library library;
    private Scanner scanner = new Scanner(System.in);

    public LibraryApp(ArrayList<Book> books) {
        this.library = new Library(books);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("=== | Library Menu | ===");
            System.out.println("[1] List all Books");
            System.out.println("[2] Search for a Book");
            System.out.println("[3] Create User");
            System.out.println("[4] Login");
            System.out.println("[5] Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Listing all books...");

                    ArrayList<Book> allBooks = library.listBooks();

                    for (Book book : allBooks) {
                        System.out.println(book);

                    }
                    break;

                case 2:
                    System.out.println("Enter search term: ");
                    String query = scanner.nextLine();

                    ArrayList<Book> matches = library.searchBooks(query);

                    if (matches.isEmpty()) {
                        System.out.println("No books found.");
                    }
                    else {
                        System.out.println("Search results: ");
                        for (Book book : matches) {
                            System.out.println(book);
                        }

                    }
                    break;

                case 3:
                    System.out.println("Creating User...");

                    System.out.println("Please enter a Username: ");

                    String userCreate = scanner.nextLine();
                    System.out.println("Please enter a Password: ");

                    String passCreate = scanner.nextLine();
                    System.out.println("User created!");

                    break;



                case 4:
                    System.out.println("Logging in...");

                    System.out.println("Enter username: ");
                    String username = scanner.nextLine();

                    System.out.println("Enter password: ");
                    String password = scanner.nextLine();

                    User loggedInUser = userManager.login(username, password);

                    if (loggedInUser != null) {
                        System.out.println("Login successful!");
                        this.user = loggedInUser;
                        userMenu();
                    }
                    else {
                        System.out.println("Wait a minute...These details don't seem to be right");
                    }


                case 5:
                    System.out.println("Thanks for coming! Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again");
            }
        }

    }

    public void userMenu() {
        boolean loggedIn = true;

        while(loggedIn) {
            System.out.println("=== | User Menu | ===");
            System.out.println("[1] Search for a Book");
            System.out.println("[2] Borrow a Book");
            System.out.println("[3] Return a Book");
            System.out.println("[4] My Borrowed Books");
            System.out.println("[5] Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter search term: ");
                    String query = scanner.nextLine();

                    ArrayList<Book> matches = library.searchBooks(query);

                    if (matches.isEmpty()) {
                        System.out.println("No books found.");
                    }
                    else {
                        System.out.println("Search results: ");
                        for (Book book : matches) {
                            System.out.println(book);
                        }

                    }
                    break;

                case 2:
                    System.out.println("Enter book ID or Title: ");
                    String borrow = scanner.nextLine();

                    int id = 0;
                    String title = null;

                    try {
                        id = Integer.parseInt(borrow); // Check for Int ID
                    }
                    catch (NumberFormatException e) { // Here for the title
                        title = borrow;
                    }

                    boolean success = library.borrowBook(title, id); // When successful - Returns borrowBook method

                    if (success) {
                        CsvUtils.saveBooks(library.getBooks());
                        System.out.println("Book borrowed successfully!");
                    }
                    else {
                        System.out.println("This book is currently unavailable. Please check back soon!");
                    }

                    break;

                case 3:
                    System.out.println("Which book are you returning?");

                    break;

                case 4:
                    library.showMyBorrowedBooks(user);
                    break;

                case 5: loggedIn = false; break;

                default:
                    throw new IllegalStateException("Invalid option");


            }
        }
    }
}