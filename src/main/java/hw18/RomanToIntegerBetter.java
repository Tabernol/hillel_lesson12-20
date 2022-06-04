package hw18;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerBetter {
    int result;
    int change;
    int number;
    Map<Character, Integer> rome = new HashMap<>();

    public int romanToInt(String s) {
        rome.put('I', 1);
        rome.put('V', 5);
        rome.put('X', 10);
        rome.put('L', 50);
        rome.put('C', 100);
        rome.put('D', 500);
        rome.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            number = rome.get(s.charAt(s.length() - 1 - i));
            if (number >= change) {
                result += number;
            } else {
                result -= number;
            }
            change = number;
        }
        return result;
    }
}
