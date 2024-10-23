package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftStrings = left.split("/");
        String[] rightStrings = right.split("/");

        int result = rightStrings[0].compareTo(leftStrings[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}
