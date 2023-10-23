package ru.job4j.tracker.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Output;

public class ShowAllIAction implements UserAction {

    private final Output output;

    public ShowAllIAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
