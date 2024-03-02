package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int size = Math.min(o1.length(), o2.length());
        for (int index = 0; index < size; index++) {
            if (Character.isDigit(o1.charAt(index)) || Character.isDigit(o2.charAt(index))) {
                Integer.compare(o1.charAt(index), o2.charAt(index));
            } else {
                result = Character.compare(o1.charAt(index), o2.charAt(index));
            }
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = o1.length() - o2.length();
        }
        return result;
    }
}
