package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Летатет по воздуху.");
    }

    @Override
    public void passengers() {
        System.out.println("200 пассажиров.");
    }
}
