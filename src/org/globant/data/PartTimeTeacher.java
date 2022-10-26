package org.globant.data;

public class PartTimeTeacher extends Professor{

    private int activeHours;

    public PartTimeTeacher(String firstName, String lastName, double baseSalary, int activeHours) {
        super(firstName, lastName, baseSalary);
        this.actualSalary = (this.baseSalary / 48) * activeHours;
        this.typeOfContract = "PartTime";
    }
}
