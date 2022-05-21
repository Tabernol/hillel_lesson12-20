package hw17.services;

import hw17.model.Book;
import hw17.model.Library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ServiceLibrary {
    Library lib = new Library();

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter name a book");
        Book.builder().nameOfBook(String.valueOf(scanner));
        System.out.println("enter author of book");
        Book.builder().author(String.valueOf(scanner));
        System.out.println("enter text");
        Book.builder().text(String.valueOf(scanner)).build();
      //  Path pathToBook = Paths.get(author + "_" + nameOfBook + ".txt");
        try {
            Files.createFile(Path.of(book.path));
            System.out.println("Book was add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
