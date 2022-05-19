package hw15;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.Assert.*;

public class CountingWordsInBookTest {
    CountingWordsInBook pathToBook = new CountingWordsInBook();

    @Test
    public void countingWords() {
        Map<String,String> result =
                pathToBook.countingWords(Paths.get("src\\main\\resources\\tolstoy_voyna-i-mir__xoraa_436421.txt"));
        assertEquals(false, result.isEmpty());
    }
}