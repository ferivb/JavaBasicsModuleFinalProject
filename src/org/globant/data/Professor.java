package org.globant.data;


public abstract class Professor {

    private static int counter = 1;

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected double baseSalary;


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
    } // check this later

    // -------------- SETTERS --------------

    public void setId(int id) {
        this.id = id;
    }  // make a constructor for this

    // ------------ METHODS -------------

    public static void resetCounter(){
        counter--;
    }
    public abstract double calculateRealSalary(); // make a constructor for this

}
