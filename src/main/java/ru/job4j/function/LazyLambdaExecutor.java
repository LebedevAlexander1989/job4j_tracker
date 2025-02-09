package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLambdaExecutor {
    public static void main(String[] args) {
        String[] names = {
                "Ivan"
               // "Vova"
        };
        Comparator<String> lengthComparator = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthComparator);
    }
}
