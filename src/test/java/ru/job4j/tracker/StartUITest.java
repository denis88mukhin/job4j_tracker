package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                                + "0. Exit." + System.lineSeparator()
                                + "=== Exit program ===" + ln);
    }

    @Test
    void whenEditItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String editName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), editName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                                + "0. Edit item" + ln
                                + "1. Exit." + ln
                                + "=== Edit item ===" + ln
                                + "Заявка изменена успешно." + ln
                                + "Menu:" + ln
                                + "0. Edit item" + ln
                                + "1. Exit." + ln
                                + "=== Exit program ===" + ln
        );
    }

    @Test
    void whenFindAllOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                                + "0. Show all items" + ln
                                + "1. Exit." + ln
                                + "=== Show all items ===" + ln
                                + one + ln
                                + "Menu:" + ln
                                + "0. Show all items" + ln
                                + "1. Exit." + ln
                                + "=== Exit program ===" + ln
        );
    }

    @Test
    void whenFindByNameOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "test1", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                                + "0. Find item by name." + ln
                                + "1. Exit." + ln
                                + "=== Find items by name ===" + ln
                                + one + ln
                                + "Menu:" + ln
                                + "0. Find item by name." + ln
                                + "1. Exit." + ln
                                + "=== Exit program ===" + ln
        );
    }

    @Test
    void whenFindByIdOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                                + "0. Find item by id." + ln
                                + "1. Exit." + ln
                                + "=== Find item by id ===" + ln
                                + one + ln
                                + "Menu:" + ln
                                + "0. Find item by id." + ln
                                + "1. Exit." + ln
                                + "=== Exit program ===" + ln
        );
    }
}