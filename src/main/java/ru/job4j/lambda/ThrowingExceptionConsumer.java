package ru.job4j.lambda;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingExceptionConsumer<T, E extends Exception> {
    void accept(T t) throws E;

    static <T> Consumer<T> throwingExceptionConsumerWrapper(ThrowingExceptionConsumer<T, Exception> throwingExceptionConsumer) {
        return x -> {
            try {
                throwingExceptionConsumer.accept(x);
            } catch (Exception e) {
                System.out.println("Тут возникла ошибка: " + e.getMessage());
            }
        };
    }
}