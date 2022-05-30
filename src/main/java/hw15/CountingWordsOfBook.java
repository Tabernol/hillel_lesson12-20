package hw15;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingWordsOfBook {
//    public Map<String, String> countingWords(Path path) {
//        Map<String, String> wordCount = null;
//        Pattern myPattern = Pattern.compile("\\.\\w+$");
//        Matcher myMatcher = myPattern.matcher(path.toString());
//        myMatcher.find();
//        String pathForWrite = path.toString().replace(myMatcher.group(), "_Result.txt");
//
//        try (BufferedReader bf = new BufferedReader(new FileReader(path.toString()));
//             BufferedWriter bw = new BufferedWriter(new FileWriter(pathForWrite))) {
//            String line = "";
//            List<String> list = new ArrayList<>();
//            while ((line = bf.readLine()) != null) {
//                list.addAll(Stream.of(line.split("[^А-Яа-я]+"))
//                        .map(String::toLowerCase)
//                        .filter(word -> !word.contains("рус"))
//                        .filter(word -> !word.contains("рассия"))
//                        .filter(word -> word.length() > 3)
//                        .toList());
//            }
//            wordCount = list.stream()
//                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                    .entrySet()
//                    .stream()
//                    .collect(Collectors
//                            .toMap(k-> k.getKey(),v -> v.getValue().toString().concat("\n")));
//            bw.write(String.valueOf(wordCount));
//            System.out.println(wordCount);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return wordCount;
//    }
}
