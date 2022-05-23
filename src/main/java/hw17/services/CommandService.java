package hw17.services;

import hw17.model.Book;
import java.io.IOException;


public class CommandService extends ServiceLibrary implements CheckAble {
    Book bookDefault = new Book("unknown", "unknown", "unknown");

    public void add() {
        var bookBuilder = Book.builder();
        System.out.println("enter name a book");
        bookBuilder.nameOfBook(String.valueOf(scanner.nextLine()));
        System.out.println("enter author of book");
        bookBuilder.author(String.valueOf(scanner.nextLine())).build();
        System.out.println("Text");
        String line ="";
        StringBuilder alltext = new StringBuilder();
        while (!check(line=scanner.nextLine())){
            alltext.append(line+"\n");
        }
        Book book = bookBuilder.text(alltext.toString()).build();
        library.getCatalog().put(book.getNameOfBook(), book);
        saveLibrary();
    }

    public void read() {
        System.out.println("enter name of book");
        System.out.println(library.getCatalog().getOrDefault(scanner.nextLine(), bookDefault).getText());
    }

    public void delete() {
        System.out.println("enter name of book");
        String line = scanner.nextLine();
        if (library.getCatalog().containsKey(line)) {
            library.getCatalog().remove(line);
            saveLibrary();
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

    @Override
    public boolean check(String line) {
        return line.equals("exit");
    }

}
