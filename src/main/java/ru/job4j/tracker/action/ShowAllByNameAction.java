package ru.job4j.tracker.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;

public class ShowAllByNameAction implements UserAction {

    private final Output output;

    public ShowAllByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show all items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Show all items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем: " + name + " ,не найдены.");
        }
        return true;
    }
}
