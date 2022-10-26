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

    // -------------- GETTERS --------------

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public double getActualSalary() {
        return this.actualSalary;
    }

    public String getTypeOfContract() {
        return this.typeOfContract;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    // ------------ METHODS -------------

    public void addCourseToList(Course course){
        this.courses.add(course);
    }

    public Course findCourse(int index){
        return this.courses.get(index);
    }

    public void removeFromCourses(int index){
        this.courses.remove(index);
    }

}
