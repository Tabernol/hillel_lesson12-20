package hw14;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task2HappyNumberTest {
    Task2HappyNumber number = new Task2HappyNumber();

    @Test
    public void isHappy() {
        assertEquals(true, number.isHappy(1));
    }

    @Test
    public void isHappy2() {
        assertEquals(false, number.isHappy(2));
    }

    @Test
    public void powAndSumN() {
        assertEquals(13, number.powAndSumN(23));
    }

    @Test
    public void powAndSumN2() {
        assertEquals(2, number.powAndSumN(11));
    }
}