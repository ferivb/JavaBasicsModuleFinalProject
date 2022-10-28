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

    // --------------- GETTERS ------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public void setRegisteredStudents(List<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    // --------------- SETTERS ------------------

    public boolean setProfessor(Professor professor) {
        boolean success = false;
        if(professor.getId() > 0){
            this.professor = professor;
            success = true;
        }

        return success;
    }

    // ---------------- METHODS -----------------

    public boolean registerStudent(Student student){
        boolean success = false;
        if(student.getId() > 0 && !this.registeredStudents.contains(student)){
            success = true;
        }

        return success;
    }
}
