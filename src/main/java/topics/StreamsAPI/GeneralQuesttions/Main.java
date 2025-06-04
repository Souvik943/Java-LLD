package topics.StreamsAPI.GeneralQuesttions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"apple", "banana", "cherry", "date", "grapefruit", "apple"};
        findLongestString(strs);
        calculateAverageLength(strs);
        System.out.println((isPrimeNumberPressent(List.of(4, 6, 8, 10, 12, 14, 15))));
        freqOfWords(strs);
    }

    private static void findLongestString(String[] strs) {
        Arrays.stream(strs)
                .max(Comparator.comparingInt(str -> str.length()))
                .ifPresent(str -> System.out.println(str));
    }

    private static void calculateAverageLength(String[] strs) {
        double average = Arrays.stream(strs)
                .collect(Collectors.averagingInt(s -> s.length()));
        System.out.println(average);
    }

    private static boolean isPrime(int n) {
        if( n <= 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeNumberPressent(List<Integer> list) {
        return list.stream()
                .anyMatch(i -> isPrime(i));
    }

    private static void freqOfWords(String[] strs) {
        System.out.println(Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> s.equals(s))));
    }
}
