package hw16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MyLibrary {
    Path directory = Paths.get("src\\main\\resources\\MyLibrary\\Books");
    static Map<String, Path> catalog;

    public void startMyLibrary() {
        readCatalog(directory);
        System.out.println("What a you want do: \ncreate a book write \"create\" \n" +
                "delete a book write \"delete\" \n" +
                "show catalog write \"show\" \n" +
                "write \"exit\" for finish.");
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        switch (scanner.nextLine()) {
            case "create":
                book.createBook();
                startMyLibrary();
                return;
            case "delete":
                showCatalog();
                book.deleteBook(scanner.nextLine());
                startMyLibrary();
                return;
            case "show":
                showCatalog();
                startMyLibrary();
                return;
            case "exit":
                return;
        }
        scanner.close();
    }

    public void showCatalog() {
        catalog.forEach((k, v) -> System.out.println(k));
    }

    public Map<String, Path> readCatalog(Path path) {
        try {
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            catalog = Files.list(Paths.get(String.valueOf(path)))
                    .collect(Collectors.toMap(p -> p.getFileName()
                                    .toString()
                                    .replace(".txt", ""),
                            p -> p));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public static void main(String[] args) {
        MyLibrary myLibrary = new MyLibrary();
        myLibrary.startMyLibrary();
    }
}
