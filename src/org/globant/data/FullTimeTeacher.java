package org.globant.data;

public class FullTimeTeacher extends Professor{

    private int experienceYears;

    public FullTimeTeacher(String firstName, String lastName, double baseSalary, int experience) {
        super(firstName, lastName, baseSalary);
        this.experienceYears = experience;
    }

    @Override
    public double calculateRealSalary() {
        return this.baseSalary * (this.experienceYears * 1.1);
    }

    @Override
    public String toString() {
        double salary = this.calculateRealSalary();
        return "  " + this.id + "  " +
                " |\t  " + this.firstName + " " + this.lastName + "\t" +
                " |\t " + this.email + "\t" +
                " |\t " + "Full-time" + "\t" +
                " |\t $" + salary;
    }
}
