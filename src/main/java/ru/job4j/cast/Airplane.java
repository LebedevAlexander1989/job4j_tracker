package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("The " + getClass().getSimpleName() + " flies through the air");
    }
}