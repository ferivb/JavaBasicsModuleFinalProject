package org.globant.data;

public class PartTimeTeacher extends Professor{

    private int activeHours;

    public PartTimeTeacher(String firstName, String lastName, double baseSalary, int activeHours) {
        super(firstName, lastName, baseSalary);
        this.activeHours = activeHours;
    }

    @Override
    public double calculateRealSalary() {
        return (this.baseSalary / 48) * activeHours;
    }

    @Override
    public String toString() {
        double salary = this.calculateRealSalary();
        return "  " + this.id + "  " +
                " |\t  " + this.firstName + " " + this.lastName + "\t" +
                " |\t " + this.email + "\t" +
                " |\t " + "Part-time" + "\t" +
                " |\t $" + salary;
    }
}
