package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

import static ru.job4j.lambda.ThrowingExceptionConsumer.throwingExceptionConsumerWrapper;

public class ScopeInside {
    public static void main(String[] args) {
//        String ayyyy = "ayyyyy";
//        ayyyy = "aaaaa";
//        String temp = ayyyy;
//        String name = echo(
//                () -> {
//                    return temp;
//                }
//        );
//        System.out.println(ayyyy);
//        System.out.println(name);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(throwingExceptionConsumerWrapper(ScopeInside::methodThrowingAnException));

    }

    private static void methodThrowingAnException(Integer number) throws Exception {
        if (number == 3) {
            throw new Exception("тут появилась ошибка");
        }
        System.out.println(number);
    }
}
