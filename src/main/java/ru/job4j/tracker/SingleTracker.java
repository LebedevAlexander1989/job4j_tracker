package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.util.List;

public final class SingleTracker {

    private static SingleTracker singleTracker;

    private final Tracker tracker = new Tracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (singleTracker == null) {
            return new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String name) {
       return tracker.findByName(name);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
       return tracker.delete(id);
    }
}
