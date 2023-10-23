package ru.job4j.tracker.action;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

public class CreateAction implements UserAction {

    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Добавленная заявка: " + item);
        return true;
    }
}
