package hw14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task1UniqueMorse {
    String[] alphabetMorse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
            ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    Map<Character, String> morseMap = new HashMap<>();
    Set<String> uniqueWords = new HashSet<>();
    public int uniqueMorseRepresentations(String[] words) {
        char symbol = 'a';
        for (int i = 0; i<alphabetMorse.length; i++){
            morseMap.put(symbol, alphabetMorse[i]);
            symbol++;
        }
        for (int i = 0; i < words.length; i++) {
            String wordMorse = "";
            for (int j = 0; j < words[i].length(); j++) {
                char letter = words[i].charAt(j);
                String letterMorse = morseMap.get(letter);
                wordMorse = wordMorse.concat(letterMorse);
            }
            uniqueWords.add(wordMorse);
        }
        return uniqueWords.size();
    }
}
