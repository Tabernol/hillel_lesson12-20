package hw12;

import hw12.Task1;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void numJewelsInStones1() {
        Task1 object = new Task1();
        assertEquals(3, object.numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    public void numJewelsInStones2() {
        Task1 object = new Task1();
        assertEquals(0, object.numJewelsInStones("x", "XX"));
    }

    @Test
    public void numJewelsInStones3() {
        Task1 object = new Task1();
        assertNotEquals(2, object.numJewelsInStones("k", "kyi"));
    }
}