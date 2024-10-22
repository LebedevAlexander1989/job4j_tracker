package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftStrings = left.split("/");
        String[] rightStrings = right.split("/");

        if (leftStrings[0].compareTo(rightStrings[0]) == 0) {
            for (int i = 1; i < Math.min(leftStrings.length, rightStrings.length); i++) {
                if (leftStrings[i].compareTo(rightStrings[i]) != 0) {
                    return leftStrings[i].compareTo(rightStrings[i]);
                }
            }

            if (leftStrings.length != rightStrings.length) {
                return Integer.compare(leftStrings.length, rightStrings.length);
            }
        }
        return rightStrings[0].compareTo(leftStrings[0]);
    }
}
