package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        for (int index = 0; index < Math.min(o1.length(), o2.length()); index++) {
            if (o1.charAt(index) != o2.charAt(index)) {
                return Character.compare(o1.charAt(index), o2.charAt(index));
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
