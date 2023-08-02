package ru.job4j.oop;

public class Computer {

    private boolean multiMonitor;
    private int ssd;
    private String cpu;

    public Computer() {
        this.multiMonitor = true;
        this.ssd = 500;
        this.cpu = "Intel Core I7-10700K";

    }

    public Computer(boolean multiMonitor, int ssd, String cpu) {
        this.multiMonitor = multiMonitor;
        this.ssd = ssd;
        this.cpu = cpu;
    }

    public void printInfo() {
        System.out.println("Много мониторов: " + multiMonitor);
        System.out.println("SSD: " + ssd + " GB");
        System.out.println("Модель CPU: " + cpu);
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.printInfo();
        System.out.println();

        Computer computer1 = new Computer(true, 500, "Intel Core I7-10700K");
        computer1.printInfo();
        System.out.println();

        Computer computer2 = new Computer(true, 256, "AMD Ryzen 5 3600");
        computer2.printInfo();
    }
}
