package org.globant.data;

import java.util.List;

public class Course {

    private static int counter = 1;

    private int id;
    private String name;
    private int classroom;
    private List<Student> registeredStudents;
    private Professor professor;

    public Course(String name, int classroom) {
        this.id = counter;
        counter++;
        this.name = name;
        this.classroom = classroom;
    }
}
