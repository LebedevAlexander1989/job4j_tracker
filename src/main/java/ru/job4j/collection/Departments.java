package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            String[] strings = value.split("/");
            StringBuilder start = new StringBuilder(strings[0]);
            temp.add(start.toString());

            for (int i = 1; i < strings.length; i++) {
                start.append("/").append(strings[i]);
                temp.add(start.toString());
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
