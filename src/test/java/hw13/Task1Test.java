package hw13;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task1Test {
    Task1 task = new Task1();

    @Test
    public void maxProduct1() {
        assertEquals(30, task.maxProduct(new int[]{2, 4, 6, 1, 7}));
    }

    @Test
    public void maxProduct2() {
        assertEquals(0, task.maxProduct(new int[]{1, 1}));
    }
}