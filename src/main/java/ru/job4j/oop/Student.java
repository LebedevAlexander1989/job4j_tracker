package ru.job4j.oop;

public class Student {

    public void music(String lyrics) {
        System.out.println("I am sing a song : " + lyrics);
    }

    public void sing() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        String song = "I believe, I can fly";

        Student petya = new Student();
        petya.music(song);
    }
}
