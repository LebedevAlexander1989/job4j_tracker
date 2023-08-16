package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("book1", 100);
        Book book2 = new Book("book2", 150);
        Book book3 = new Book("book3", 50);
        Book cleanCode = new Book("Clean code", 365);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = cleanCode;

        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println("Название книги: " + b.getName() + ", количество страниц: " + b.getCount());
        }
        System.out.println();

        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println("Название книги: " + b.getName() + ", количество страниц: " + b.getCount());
        }
        System.out.println();

        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (b.getName().equals("Clean code")) {
                System.out.println("Название книги: " + b.getName() + ", количество страниц: " + b.getCount());
            }
        }
    }
}
