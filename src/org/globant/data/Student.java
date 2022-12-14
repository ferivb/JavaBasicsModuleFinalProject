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

    // ------------ GETTERS --------------

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // ------------ SETTERS --------------

    public void setId(int id) {
        this.id = id;
    }

    public static void resetCounter(){
        counter--;
    }

    @Override
    public String toString() {
        return "   " + this.id + "  |\t" + this.name + "\t\t|\t" + this.age;
    }
}
