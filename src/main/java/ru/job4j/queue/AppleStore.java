package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer customer = new Customer("", 0);
        for (int index = 0; index < count; index++) {
            customer = queue.poll();
        }
        return customer.name();
    }

    public String getFirstUpsetCustomer() {
        Customer customer = new Customer("", 0);
        for (int index = 0; index <= count; index++) {
            customer = queue.poll();
        }
        return customer.name();
    }
}
