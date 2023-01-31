package ru.job4j.tracker;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime createdDateTime = item.getCreated();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdDateTimeFormat = createdDateTime.format(formatter);
        System.out.println(createdDateTimeFormat);

        Item item1 = new Item();
        System.out.println(item1);
    }
}
