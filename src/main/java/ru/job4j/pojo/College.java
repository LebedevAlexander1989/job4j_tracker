package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setGroup("D-1");
        student.setAdmissionDate(new Date());

        System.out.println(student.getName());
        System.out.println(student.getSurname());
        System.out.println(student.getGroup());
        System.out.println(student.getAdmissionDate());
    }
}
