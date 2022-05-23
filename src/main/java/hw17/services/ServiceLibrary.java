package hw17.services;

import com.fasterxml.jackson.databind.json.JsonMapper;
import hw17.model.Command;
import hw17.model.Library;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class ServiceLibrary{
    Boolean libraryExist;
    static File directory = new File("src\\main\\resources\\lib.json");
    static Library library = new Library();
    static Map<String, Consumer<Scanner>> mapCommand = new HashMap<>();
    static CommandService commandService = new CommandService();
    static JsonMapper jsonMapper = new JsonMapper();
    Scanner scanner = new Scanner(System.in);

    static {
        commandInitializer();
        makeOrReadCatalog();
    }

    public void startLibrary() {
        System.out.println("Command");
        String command = "";
        while (!command.equals("exit")) {
            command = scanner.nextLine().toLowerCase();
            mapCommand.getOrDefault(command, scanner1 -> System.out.println("repeat")).accept(scanner);
        }
    }

    public static void commandInitializer() {
        mapCommand.put(Command.SHOW.command, scanner -> commandService.show());
        mapCommand.put(Command.ADD.command, scanner -> commandService.add());
        mapCommand.put(Command.READ.command, scanner -> commandService.read());
        mapCommand.put(Command.DELETE.command, scanner -> commandService.delete());
        mapCommand.put(Command.EXIT.command, scanner -> commandService.exit());
    }

    public static void makeOrReadCatalog() {
        try {
            directory.createNewFile();
            library = jsonMapper.readValue(directory, Library.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean libraryExist() {
        return directory.exists();
    }

    public static void main(String[] args) {
        ServiceLibrary s = new ServiceLibrary();
        System.out.println(s.library.getCatalog());
        s.startLibrary();

        // s.makeCatalog();

    }

}
