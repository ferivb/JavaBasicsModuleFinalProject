package org.globant.data;

public class FullTimeTeacher extends Professor{

    private int experienceYears;

    public FullTimeTeacher(String firstName, String lastName, double baseSalary, int experience) {
        super(firstName, lastName, baseSalary);
        this.experienceYears = experience;
        this.typeOfContract = "FullTime";
    }

    @Override
    public double calculateRealSalary() {
        return this.baseSalary * (this.experienceYears * 1.1);
    }

    @Override
    public String toString() {
        double salary = this.calculateRealSalary();
        return " " + this.id + "\t\t" +
                "\t | " + this.firstName + " " + this.lastName + "\t" +
                "\t | " + this.email + "\t" +
                "\t | " + this.typeOfContract + "\t" +
                "\t | $" + salary;
    }
}
