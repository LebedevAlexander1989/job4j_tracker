package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, -1, 4, -3, 8, 9);
        List<Integer> positive = numbers.stream()
                .filter(n -> n > 0).toList();
        positive.forEach(System.out::println);
    }
}
