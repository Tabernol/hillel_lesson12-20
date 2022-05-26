package hw16;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.Assert.*;

public class BookTest {
    MyLibrary myLibrary = new MyLibrary();

    @Test
    public void createBook() {
        try {
            Path path = Files.createFile(myLibrary.directory.resolve("name3.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(true, Files.exists(Paths.get(String.valueOf(myLibrary.directory.resolve("name3.txt")))));
    }
}