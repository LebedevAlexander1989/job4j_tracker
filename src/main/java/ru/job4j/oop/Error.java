package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfoError() {
        System.out.println("Активная ошибка: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Сообщение ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfoError();
        System.out.println();

        Error error1 = new Error(true, 1, "не работает насос");
        error1.printInfoError();
        System.out.println();

        Error error2 = new Error(false, 2, "перезагрузите систему");
        error2.printInfoError();
    }
}
