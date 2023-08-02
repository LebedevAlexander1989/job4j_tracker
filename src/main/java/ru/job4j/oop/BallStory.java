package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();

        Wolf wolf = new Wolf();
        wolf.tryEat(ball);

        Hare hare = new Hare();
        hare.tryEat(ball);

        Fox fox = new Fox();
        fox.tryEat(ball);
    }
}
