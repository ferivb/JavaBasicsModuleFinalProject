package org.globant.data;

public class Student {

    private static int counter = 1;

    private int id;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = counter;
        counter++;
    }
}