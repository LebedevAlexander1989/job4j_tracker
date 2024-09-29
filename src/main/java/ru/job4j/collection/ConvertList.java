package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public static List<Integer> convert(List<int[]> lists) {
        List<Integer> result = new ArrayList<>();
        for (int[] list : lists) {
            for (int value : list) {
                result.add(value);
            }
        }
        return result;
    }
}
