package ru.job4j.poly;

public class Bus implements Transpotr {
    @Override
    public void drive() {
        System.out.println("Ехать");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Колличество пассажиров " + passengers);
    }

    @Override
    public double refuel(int fuel) {
        return fuel / 30;
    }
}
