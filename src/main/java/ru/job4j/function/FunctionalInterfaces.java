package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = map::put;

        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");

        BiPredicate<Integer, String> predicate = (integer, string) -> integer % 2 == 0 || string.length() == 4;
        for (Integer key : map.keySet()) {
            final String value = map.get(key);
            if (predicate.test(key, value)) {
                System.out.println("key: " + key + " value: " + value);
            }
        }

        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        Consumer<List<String>> consumer = System.out::println;
        consumer.accept(supplier.get());

        Function<String, String> function = String::toUpperCase;
        for (String string : supplier.get()) {
            System.out.println(function.apply(string));
        }
    }
}
