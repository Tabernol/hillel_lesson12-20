package hw18;

public class RomanToIntegerFast {
    public int romanToInt(String s) {
        int result = 0;
        int[] array = new int[s.length()];
        for (int i = 0; i < array.length; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    array[i] = 1;
                    break;
                case 'V':
                    array[i] = 5;
                    break;
                case 'X':
                    array[i] = 10;
                    break;
                case 'L':
                    array[i] = 50;
                    break;
                case 'C':
                    array[i] = 100;
                    break;
                case 'D':
                    array[i] = 500;
                    break;
                case 'M':
                    array[i] = 1000;
                    break;
            }
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                result += array[i + 1] - array[i];
                array[i] = 0;
                array[i + 1] = 0;
                i++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }
}
