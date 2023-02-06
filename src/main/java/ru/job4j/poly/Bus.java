package ru.job4j.poly;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Двигается по скоростным тассам.");
    }

    @Override
    public void passengers() {
        System.out.println("60 пассажиров.");
    }
}
