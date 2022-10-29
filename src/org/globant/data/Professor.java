package org.globant.data;

import java.util.List;

public abstract class Professor {

    private static int counter = 1;

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected double baseSalary;
    protected String typeOfContract;
    // protected List<Course> courses;  ---------- CREATE A METHOD FOR THIS -----------


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

    public String getTypeOfContract() {
        return this.typeOfContract;
    }

    // -------------- SETTERS --------------

    public void setId(int id) {
        this.id = id;
    }

//    public List<Course> getCourses() {
//        return this.courses;
//    }

    // ------------ METHODS -------------

    public static void resetCounter(){
        counter--;
    }
    public abstract double calculateRealSalary();

//    public void addCourseToList(Course course){
//        this.courses.add(course);
//    }
//
//    public Course findCourse(int index){
//        return this.courses.get(index);
//    }
//
//    public void removeFromCourses(int index){
//        this.courses.remove(index);
//    }

}
