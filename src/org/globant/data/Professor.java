package org.globant.data;

import java.util.List;

public class Professor {

    private static int counter = 1;

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    protected double baseSalary;
    protected double actualSalary;
    protected String typeOfContract;
    protected List<Course> courses;


    public Professor(String firstName, String lastName, double baseSalary) {
        this.id = counter;
        counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = this.firstName + "." + this.lastName + this.id + "@university.edu";
        this.baseSalary = baseSalary;
    }
}
