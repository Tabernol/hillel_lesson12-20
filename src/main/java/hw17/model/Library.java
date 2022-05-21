package hw17.model;

import hw17.services.ServiceLibrary;
import org.json.JSONObject;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Library {
    Boolean libraryExist;
    Path directory = Paths.get("src\\main\\resources\\Library\\Books");
    static Map<String, Book> catalog;
    Map<String, Consumer<Scanner>> mapCommand = new HashMap<>();
    ServiceLibrary serviceLibrary = new ServiceLibrary();


//    public void startMyLibrary() {
//        readCatalog(directory);
//        System.out.println("What a you want do: \ncreate a book write \"create\" \n" +
//                "delete a book write \"delete\" \n" +
//                "show catalog write \"show\" \n" +
//                "write \"exit\" for finish.");
//        Scanner scanner = new Scanner(System.in);
//        Book book = new Book();
//        switch (scanner.nextLine()) {
//            case "create":
//                book.createBook();
//                startMyLibrary();
//                return;
//            case "delete":
//                showCatalog();
//                book.deleteBook(scanner.nextLine());
//                startMyLibrary();
//                return;
//            case "show":
//                showCatalog();
//                startMyLibrary();
//                return;
//            case "exit":
//                return;
//        }
//        scanner.close();
//    }

    public void showCatalog() {
        catalog.forEach((k, v) -> System.out.println(k));
    }
//    public Map<String, Path> readCatalog(Path path) {
//        try {
//            if (!Files.exists(directory)) {
//                Files.createDirectories(directory);
//            }
//            catalog = Files.list(Paths.get(String.valueOf(path)))
//                    .collect(Collectors.toMap(p -> p.getFileName()
//                                    .toString()
//                                    .replace(".txt", ""),
//                            p -> p));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return catalog;
//    }

    public static void main(String[] args) {
//        Library myLibrary = new Library();
//        myLibrary.startMyLibrary();
    }

    public void startLibrary(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Command");
        String command = "";
        while (!command.equals("exit")){
            command = scanner.nextLine().toLowerCase();
            mapCommand.getOrDefault(command, scanner1-> System.out.println("repeat")).accept(scanner);
        }

    }
    public void inizializator (){
        mapCommand.put(Command.SHOW.command,
                scanner -> catalog.forEach((k,v) ->System.out.println(k)));
        mapCommand.put(Command.ADD.command, scanner -> { serviceLibrary.add();

        } );
        mapCommand.put(Command.READ.command, );
        mapCommand.put(Command.DELETE.command, );
        mapCommand.put(Command.EXIT.command, );
    }

}
