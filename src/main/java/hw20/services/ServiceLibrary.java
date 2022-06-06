package hw20.services;

import com.fasterxml.jackson.databind.json.JsonMapper;
import hw17.model.Command;
import hw17.model.Library;
import hw17.model.Output;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class ServiceLibrary implements CheckAble {
    static File directory = new File(Output.PATH + "lib.json");
    static Library library = new Library();
    private static Map<String, Consumer<Scanner>> mapCommand = new HashMap<>();
    private static CommandService commandService = new CommandService();
    static JsonMapper jsonMapper = new JsonMapper();
    Scanner scanner = new Scanner(System.in);

    static {
        commandInitializer();
        makeOrReadCatalog();
    }

    public void startLibrary() {
        String command = "";
        while (!check(command)) {
            Command.printDescription();
            command = scanner.nextLine().toLowerCase();
            mapCommand.getOrDefault(command, scanner1 -> System.out.println(Output.REPEAT)).accept(scanner);
        }
    }

    private static void commandInitializer() {
        mapCommand.put(Command.SHOW.command, scanner -> commandService.show());
        mapCommand.put(Command.ADD.command, scanner -> commandService.add());
        mapCommand.put(Command.READ.command, scanner -> commandService.read());
        mapCommand.put(Command.DELETE.command, scanner -> commandService.delete());
        mapCommand.put(Command.EXIT.command, scanner -> commandService.exit());
        mapCommand.put(Command.SAVE.command, scanner -> commandService.saveToFile());
    }

    public static void makeOrReadCatalog() {
        try {
            directory.createNewFile();
            library = jsonMapper.readValue(directory, Library.class);
        } catch (IOException e) {
            library = new Library();
        }
    }

    @Override
    public boolean check(String line) {
        return line.equals("exit");
    }

    public static void main(String[] args) {
        ServiceLibrary start = new ServiceLibrary();
        start.startLibrary();
    }


}
