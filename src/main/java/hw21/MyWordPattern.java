package hw21;

import java.util.HashMap;
import java.util.Map;

public class MyWordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] key = pattern.split("");
        String[] value = s.split(" ");
        Map<String, String> myMap = new HashMap<>();
        if (key.length != value.length) {
            return false;
        }
        for (int i = 0; i < key.length; i++) {
            if (myMap.containsKey(key[i])) {
                if (!myMap.get(key[i]).equals(value[i])) {
                    return false;
                }
            } else if (myMap.values().contains(value[i])) {
                return false;
            } else {
                myMap.put(key[i], value[i]);
            }
        }
        return true;
    }
}
