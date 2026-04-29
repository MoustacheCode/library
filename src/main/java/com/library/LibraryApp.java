package com.library;

import java.util.ArrayList;
import java.util.Scanner;

// Interface in Command Line
public class LibraryApp {

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
                    // Implement method call later
                    break;

                case 2:
                    System.out.println("Searching for a book...");
                    break;

                case 3:
                    System.out.println("Creating User...");

                case 4:
                    System.out.println("Logging in...");

                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again");
            }
        }

    }
}