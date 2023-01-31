package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int sizeNew = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                rsl[index] = item;
                sizeNew++;
            }
        }
        return Arrays.copyOf(rsl, sizeNew);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index == -1 ? null : items[index];
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean isValid = index != -1;
        if (isValid) {
            item.setId(id);
            items[index] = item;
        }
        return isValid;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean isValid = index != -1;
        if (isValid) {
            System.arraycopy(items, index + 1, items, index, items.length - index - 1);
            items[items.length - index - 1] = null;
            size--;
        }
        return isValid;
    }
}