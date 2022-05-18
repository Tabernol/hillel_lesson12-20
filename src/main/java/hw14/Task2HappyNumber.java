package hw14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task2HappyNumber {
    Set<Integer> number = new HashSet<>();

    public boolean isHappy(int n) {
        while (n != 1 && !number.contains(n)) {
            number.add(n);
            n = powAndSumN(n);
        }
        return n == 1;
    }

    int powAndSumN(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        int newN = list.stream()
                .map(element -> element * element)
                .reduce((accumulator, element) -> element + accumulator)
                .get();
        return newN;
    }
}
