package hw20;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyWordPatternTest {
    MyWordPattern myWordPattern = new MyWordPattern();

    @Test
    public void wordPattern1() {
        assertTrue(myWordPattern.wordPattern("abba", "dog cat cat dog"));
    }

    @Test
    public void wordPattern2() {
        assertFalse(myWordPattern.wordPattern("aaaa", "dog cat cat dog"));
    }

    @Test
    public void wordPattern3() {
        assertFalse(myWordPattern.wordPattern("abba", "dog dog dog dog"));
    }

    @Test
    public void wordPattern4() {
        assertFalse(myWordPattern.wordPattern("aa", "dog dog dog dog"));
    }
}