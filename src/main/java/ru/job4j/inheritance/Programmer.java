package ru.job4j.inheritance;

public class Programmer extends Profession {

    private String programLang;
    private int experience;

    public Programmer(String programLang, int experience, boolean degree) {
        super(degree);
        this.programLang = programLang;
        this.experience = experience;
    }
}
