package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("lebedev@yandex.ru", "Alexander Lebedev");

        for (String k : map.keySet()) {
            System.out.println("email: " + k + ", name: " + map.get(k));
        }
    }
}