package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Denis Mukhin");
        student.setGroup("B-16");
        student.setEntrance(new Date());

        System.out.println(student.getName() + " student group " + student.getGroup() + ". Entered in " + student.getEntrance());
    }
}
