package ru.job4j.tracker.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.Output;

import java.util.Objects;

public class ShowByIdAction implements UserAction {

    private final Output output;

    public ShowByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Show item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        output.println(Objects.requireNonNullElseGet(item, () -> "Заявка с введенным id: " + id + " ,не найдена."));
        return true;
    }
}
