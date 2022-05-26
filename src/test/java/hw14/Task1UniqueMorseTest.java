package hw14;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class Task1UniqueMorseTest {
    Task1UniqueMorse words = new Task1UniqueMorse();
    @Test
    public void uniqueMorseRepresentations() {
        String[] str = new String[]{"gin", "zen", "gig", "msg","gin", "zen", "gig", "msg"};
        assertEquals(2,words.uniqueMorseRepresentations(str));
    }

    @Test
    public void uniqueMorseRepresentations2() {
        String[] str = new String[]{"ea", "u"};
        assertEquals(1,words.uniqueMorseRepresentations(str));
    }

    @Test
    public void uniqueMorseRepresentations3() {
        String[] str = new String[]{"a", "b", "c"};
        assertEquals(3
                ,words.uniqueMorseRepresentations(str));
    }
}