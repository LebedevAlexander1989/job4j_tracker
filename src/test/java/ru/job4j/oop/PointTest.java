package ru.job4j.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        Assertions.assertEquals(expected, out, 0.01);
    }

    @Test
    void when00to10then1() {
        double expected = 1;
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        double out = a.distance(b);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when00to01then1() {
        double expected = 1;
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        double out = a.distance(b);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when10to00then1() {
        double expected = 1;
        Point a = new Point(1, 0);
        Point b = new Point(0, 0);
        double out = a.distance(b);
        Assertions.assertEquals(expected, out, 0.1);
    }

    @Test
    void when103to004thenOnePointFour() {
        double expected = 1.4;
        Point a = new Point(1, 0, 3);
        Point b = new Point(0, 0, 4);
        double out = a.distance3d(b);
        Assertions.assertEquals(expected, out, 0.1);
    }
}
