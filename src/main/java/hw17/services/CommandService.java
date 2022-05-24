package hw17.services;

import hw17.model.*;

import java.io.IOException;

public class CommandService extends ServiceLibrary {
    Book bookDefault = new Book("unknown", "unknown", "unknown");

    public void add() {
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
        library.getCatalog().put(book.getNameOfBook(), book);
        saveLibrary();
        System.out.println(Output.ADD);
    }

    public void read() {
        System.out.println(Output.NAME);
        System.out.println(library.getCatalog().getOrDefault(scanner.nextLine(), bookDefault).getText());
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

    private void saveLibrary() {
        try {
            jsonMapper.writeValue(directory, library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
