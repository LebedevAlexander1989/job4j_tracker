package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> predName = p -> p.getName().contains(key);
        Predicate<Person> predSurName = p -> p.getSurname().contains(key);
        Predicate<Person> predPhone = p -> p.getPhone().contains(key);
        Predicate<Person> predAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combine = predName.or(predSurName).or(predPhone).or(predAddress);
        for (Person p : persons) {
            if (combine.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
