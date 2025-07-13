package topics.Practice.Implementation.Jul1225.streams;

import java.util.*;

public class StreamAPI {
    public static void main(String[] args) {
        findEvenOdd();
        startingWith1();
        findDuplicates();
        findDistinct();
        findFirst();
        totalSize();
        findMax();
        sort();
        sortDescending();
        calculateCubeAndFilter();
        sortArray();
        changeToUpperCase();
    }

    static void findEvenOdd() {
        System.out.println("Find EVen Odd ...");
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
        list.stream()
                .filter(i->i%2==0)
                .forEach(System.out::println);
    }

    static void startingWith1() {
        System.out.println("Starting with 1 ...");
        List<Integer> list = List.of(1,2,13,4,15,6,17,118);
        list.stream()
                .filter(i->i.toString().startsWith("1"))
                .forEach(System.out::println);
    }

    static void findDuplicates() {
        System.out.println("Find Duplicates ... ");
        List<Integer> list = List.of(1,2,13,4,1,6,13,118);
        Set<Integer> set = new HashSet<>();
        list.stream()
                .filter(i -> !set.add(i))
                .forEach(System.out::println);
    }

    static void findDistinct() {
        System.out.println("Find Distinct ... ");
        List<Integer> list = List.of(1,2,13,4,1,6,13,118);
        list.stream()
                .distinct()
                .forEach(System.out::println);
    }

    static void findFirst() {
        System.out.println("Find First ... ");
        List<Integer> list = List.of(1,2,13,4,1,6,13,118);
        list.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    static void totalSize() {
        System.out.println("Find Total Size ... ");
        List<Integer> list = List.of(1,2,13,4,1,6,13,118);
        System.out.println(list.stream()
                .count());
    }

    static void findMax() {
        System.out.println("Find Max ... ");
        List<Integer> list = List.of(1,2,13,4,1,6,13,118);
        System.out.println(list.stream()
                .max(Comparator.naturalOrder()));
    }

    static void sort() {
        System.out.println("Sorting in ascending ... ");
        List<Integer> list = List.of(1,2,13,4,1,6,13,118);
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    static void sortDescending() {
        System.out.println("Sorting in descending ... ");
        List<Integer> list = List.of(90,1,2,13,4,1,6,13,118);
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    static void calculateCubeAndFilter() {
        System.out.println("Calculating Cube and Filtering ... ");
        List<Integer> list = List.of(90,1,2,13,4,1,6,13,118);
        list.stream()
                .map(i -> i*i*i)
                .filter(i -> i>50)
                .forEach(System.out::println);
    }

    static void sortArray() {
        System.out.println("Sorting Array ... ");
        int[] array = {99,0,89,100,77,21,0};
        int[] arrayNew = Arrays.stream(array)
                .sorted()
                .toArray();
        for(int i : arrayNew) {
            System.out.println(i);
        }
    }

    static void changeToUpperCase() {
        System.out.println("Changing to upperCase ... ");
        List<String> list = List.of("HELLO", "jkuhl", "uuuuuu");
        list.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

    }
}
