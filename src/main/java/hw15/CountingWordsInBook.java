package hw15;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingWordsInBook {
    public Map<String, Long> countingWords(Path path) {
        Map<String, Long> wordCount = null;
        Pattern myPattern = Pattern.compile("\\.\\w+$");
        Matcher myMatcher = myPattern.matcher(path.toString());
        myMatcher.find();
        String pathForWrite = path.toString().replace(myMatcher.group(), "_Result.txt");

        try (BufferedReader bf = new BufferedReader(new FileReader(path.toString()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(pathForWrite))) {
            String line = "";
            List<String> list = new ArrayList<>();
            while ((line = bf.readLine()) != null) {
                list.addAll(Stream.of(line.split("[^А-Яа-я]+"))
                        .map(String::toLowerCase)
                        .filter(word -> !word.contains("рус"))
                        .filter(word -> !word.contains("рассия"))
                        .filter(word -> word.length() > 3)
                        .toList());
            }
            wordCount = list.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors
                            .toMap(Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new));
            bw.write(String.valueOf(wordCount));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }
}
