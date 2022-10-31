package org.globant.data;

import java.util.ArrayList;
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
        this.registeredStudents = new ArrayList<Student>();
    }

    // --------------- GETTERS ------------------

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getClassroom() {
        return this.classroom;
    }

    public List<Student> getRegisteredStudents() {
        return this.registeredStudents;
    }

    // --------------- SETTERS ------------------

    public boolean setProfessor(Professor professor) {
        boolean success = false;
        if(professor.getId() > 0){
            this.professor = professor;
            success = true;
        }
        return success;
    }   // ------------------------------ fix this

    public void setId(int id) {
        this.id = id;
    }  // --------------------------------- another constructor

    public void setName(String name) {
        this.name = name;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    // ---------------- METHODS -----------------

    public static void resetCounter(){
        counter--;
    } // -------------------- another constructor


    public boolean registerStudent(Student student){
        boolean success = false;
        if(student.getId() > 0 && !this.registeredStudents.contains(student)){
            success = true;
            this.registeredStudents.add(student);
        }
        return success;
    }   // ------------------------------   student.getId() > 0  This should go in main

    public int retrieveProfessorId(){
        return this.professor.getId();
    }

    public String retrieveStudentName(int index){
        String result = "No students are registered in this class.";
        if (registeredStudents.size() > 0){
            result = registeredStudents.get(index).getName();
        }
        return result;
    }

    public String retrieveProfessorName(){
        return this.professor.getFirstName() + " " + this.professor.getLastName();
    }

    public boolean confirmIfStudentEnrolled(int id){
        boolean found = false;
        for (int i = 0; i < this.registeredStudents.size(); i++){
            if (this.registeredStudents.get(i).getId() == id){
                found = true;
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return "   " + this.id + "  |  " + this.name;
    }
}
