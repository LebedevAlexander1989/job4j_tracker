package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

import java.util.Arrays;
import java.util.List;

public class StartUI {

    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println();
        output.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            output.println(i + ". " + actions.get(i).name());
        }
        output.println();
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), output);
        Tracker tracker = new Tracker();

        List<UserAction> actions = Arrays.asList(
        new CreateAction(output),
        new ShowAllAction(output),
        new EditAction(output),
        new DeleteAction(output),
        new ShowByIdAction(output),
        new ShowAllByNameAction(output),
        new ExitAction(output));

        new StartUI(output).init(input, tracker, actions);
    }
}

