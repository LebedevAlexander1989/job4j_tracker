package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private Output output;

    @BeforeEach
    public void before() {
        output = new StubOutput();
    }

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();

        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Edit item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"});

        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});

        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Edit item"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Edit item ==="
                        + LINE_SEPARATOR
                        + "Заявка изменена успешно."
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Edit item"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }

    @Test
    public void whenShowAllItemsTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show all items"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Show all items ==="
                        + LINE_SEPARATOR
                        + item
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show all items"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }

    @Test
    public void whenShowAllItemsTestOutputIsSuccessfullyWithoutItems() {
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show all items"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Show all items ==="
                        + LINE_SEPARATOR
                        + "Хранилище еще не содержит заявок"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show all items"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }

    @Test
    public void whenShowAllByNameItemTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[]{"0", "test", "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllByNameAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show all items by name"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Show all items by name ==="
                        + LINE_SEPARATOR
                        + item
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show all items by name"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }

    @Test
    public void whenShowAllByNameItemTestOutputIsWithoutItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[]{"0", "test1", "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllByNameAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show all items by name"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Show all items by name ==="
                        + LINE_SEPARATOR
                        + "Заявки с именем: test1 ,не найдены."
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show all items by name"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }

    @Test
    public void whenShowByIdItemTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowByIdAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show item by id"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Show item by id ==="
                        + LINE_SEPARATOR
                        + item
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show item by id"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }

    @Test
    public void whenShowByIdItemTestOutputIsWithoutItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(2), "1"}
        );

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowByIdAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show item by id"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Show item by id ==="
                        + LINE_SEPARATOR
                        + "Заявка с введенным id: 2 ,не найдена."
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Show item by id"
                        + LINE_SEPARATOR
                        + "1. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }

    @Test
    void whenInvalidExit() {
        Input in = new StubInput(
                new String[]{"-1", "0"}
        );
        Tracker tracker = new Tracker();

        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));

        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Неверный ввод, вы можете выбрать: 0 .. 0"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "Menu:"
                        + LINE_SEPARATOR
                        + "0. Exit"
                        + LINE_SEPARATOR
                        + LINE_SEPARATOR
                        + "=== Exit ==="
                        + LINE_SEPARATOR
        );
    }
}


