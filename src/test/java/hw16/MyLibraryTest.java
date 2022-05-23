package hw16;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.Assert.*;

public class MyLibraryTest {
    MyLibrary myLibrary = new MyLibrary();

    @Test
    public void readCatalog() {
        myLibrary.readCatalog(myLibrary.directory);
        assertEquals(true, Files.exists(myLibrary.directory));
    }

    @Test
    public void readCatalog2() {
        Map<String, Path> catalogTest = myLibrary.readCatalog(myLibrary.directory);
        assertEquals(false, catalogTest.isEmpty());
    }
}