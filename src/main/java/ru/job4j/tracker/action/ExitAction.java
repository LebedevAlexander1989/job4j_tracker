package ru.job4j.tracker.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;

public class ExitAction implements UserAction {

    private final Output output;

    public ExitAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Exit ===");
        return false;
    }
}
