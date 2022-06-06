package hw20.services;

import hw17.model.Book;
import hw17.model.Output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CommandService extends ServiceLibrary {
    Book bookDefault = new Book("unknown", "unknown", "unknown");

    public Book createBook() {
        var bookBuilder = Book.builder();
        System.out.println(Output.NAME);
        bookBuilder.nameOfBook(String.valueOf(scanner.nextLine()));
        System.out.println(Output.AUTHOR);
        bookBuilder.author(String.valueOf(scanner.nextLine())).build();
        System.out.println(Output.TEXT);
        String line = "";
        StringBuilder allText = new StringBuilder();
        while (!check(line = scanner.nextLine())) {
            allText.append(line + "\n");
        }
        Book book = bookBuilder.text(allText.toString()).build();
        return book;
    }

    public String add() {
        Book book = createBook();
        library.getCatalog().put(book.getNameOfBook(), book);
        saveLibrary();
        System.out.println(Output.ADD);
        return Output.ADD;
    }

    public void read() {
        System.out.println(Output.NAME);
        String choice = scanner.nextLine();
        System.out.println(library.getCatalog().getOrDefault(choice, bookDefault).getText());
    }

    public void delete() {
        System.out.println(Output.NAME);
        String line = scanner.nextLine();
        if (library.getCatalog().containsKey(line)) {
            library.getCatalog().remove(line);
            saveLibrary();
            System.out.println(Output.DELETE);
        } else {
            System.out.println(bookDefault.getText());
        }
    }

    public String exit() {
        return "exit";
    }

    public void show() {
        library.getCatalog().forEach((k, v) -> System.out.println(k));
    }

    public void saveLibrary() {
        try {
            jsonMapper.writeValue(directory, library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        System.out.println(Output.NAME);
        String choice = scanner.nextLine();
        if (library.getCatalog().containsKey(choice)) {
            String allText = library.getCatalog().get(choice).getText();
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter(Output.PATH + choice + ".txt"))) {
                bw.write(allText);
                System.out.println(Output.SAVED + Output.PATH + choice + ".txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(bookDefault.getText());
        }


    }


}
