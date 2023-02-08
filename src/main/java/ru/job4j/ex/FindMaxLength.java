package ru.job4j.ex;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] names = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (int index = 0; index < names.length; index++) {
            String el = names[index];
            if (el != null && el.length() > max) {
                max = el.length();
            }
        }
        System.out.println("Max length: " + max);
    }
}
