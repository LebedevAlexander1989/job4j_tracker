package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("The bus is on its way");
    }

    @Override
    public void addPassengers(int passengers) {
        System.out.println("There are " + passengers + " passengers on the bus");
    }

    @Override
    public int refuel(int fuel) {
        int cost = 5;
        return cost * fuel;
    }
}
