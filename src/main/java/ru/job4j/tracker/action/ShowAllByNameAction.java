package ru.job4j.tracker.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Output;

import java.util.List;

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
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем: " + name + " ,не найдены.");
        }
        return true;
    }
}
