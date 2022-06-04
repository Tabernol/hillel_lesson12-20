package hw18;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToIntegerFastTest {
    RomanToIntegerBetter romanToIntegerBetter = new RomanToIntegerBetter();

    @Test
    public void romanToInt1() {
        assertEquals(1994,romanToIntegerBetter.romanToInt("MCMXCIV"));
    }
    @Test
    public void romanToInt2(){
        assertEquals(58,romanToIntegerBetter.romanToInt("LVIII"));
    }
}