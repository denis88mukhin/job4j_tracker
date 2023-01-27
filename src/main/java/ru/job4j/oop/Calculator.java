package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int e) {
        return e - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int b) {
        return sum(b) + multiply(b) + minus(b) + divide(b);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        result = minus(9);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        rsl = calculator.divide(20);
        System.out.println(rsl);
        rsl = calculator.sumAllOperation(10);
        System.out.println(rsl);
    }
}
