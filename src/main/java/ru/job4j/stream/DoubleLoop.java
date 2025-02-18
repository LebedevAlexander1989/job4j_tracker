package ru.job4j.stream;

import java.util.stream.Stream;

public class DoubleLoop {

    public static void main(String[] args) {
        Stream.of(Card.Suit.values())
                .flatMap(suit -> Stream.of(Card.Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);

    }
}
