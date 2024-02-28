package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    @Test
    public void whenSortAscending() {
        List<Item> items = Arrays.asList(
                new Item(1, "test8"),
                new Item(2, "test1"),
                new Item(3, "test9"),
                new Item(4, "test4"),
                new Item(5, "test6"),
                new Item(6, "test3")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "test1"),
                new Item(6, "test3"),
                new Item(4, "test4"),
                new Item(5, "test6"),
                new Item(1, "test8"),
                new Item(3, "test9")
        );
        assertThat(items).containsAll(expected);
    }

    @Test
    public void whenSortDescending() {
        List<Item> items = Arrays.asList(
                new Item(1, "test8"),
                new Item(2, "test1"),
                new Item(3, "test9"),
                new Item(4, "test4"),
                new Item(5, "test6"),
                new Item(6, "test3")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "test9"),
                new Item(1, "test8"),
                new Item(5, "test6"),
                new Item(4, "test4"),
                new Item(6, "test3"),
                new Item(2, "test1")
        );
        assertThat(items).containsAll(expected);
    }
}