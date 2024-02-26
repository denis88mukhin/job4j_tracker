package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mukhin.denis@gmail.com", "Mukhin Denis Mikhaylovich");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("mukhin.denis@gmail.com", "Mukhin Denis");
        map.put("ivanov@gmail.com", "Ivanov Ivan");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
