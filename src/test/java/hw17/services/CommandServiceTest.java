package hw17.services;

import com.fasterxml.jackson.databind.json.JsonMapper;
import hw17.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CommandServiceTest {
    static File directory = new File(Output.PATH + "lib.json");
    CommandService commandService = new CommandService();
    static Library library = new Library();
    static JsonMapper jsonMapper = new JsonMapper();

    @BeforeEach
    public void bef() {
        System.out.println("before");
        try {
            library = jsonMapper.readValue(directory, Library.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read() {
        String nameOfBook = "w";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(nameOfBook.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        System.out.println(Output.NAME);
        String choice = scanner.nextLine();
        assertNotNull(library.getCatalog().get(choice).getText());
    }

    @Test
    void exit() {
        assertEquals("exit", commandService.exit());
    }

    @Test
    void show() {
        commandService.show();
    }
}