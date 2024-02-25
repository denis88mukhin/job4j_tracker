package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mukhin.denis88@gmail.com", "Mukhin Denis Mikhaylovich");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
