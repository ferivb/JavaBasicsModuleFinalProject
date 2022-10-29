package org.globant.persistence;

import org.globant.data.*;

public class DataInitializer {

    public static University loadUniversity(){
        University myUniversity = new University("Globuni");
        populateProfessors(myUniversity);
        populateStudents(myUniversity);
        populateCourses(myUniversity);
        return myUniversity;
    }

    public static void populateProfessors(University university){
        FullTimeTeacher fullTimeTeacher = new FullTimeTeacher("Michael", "Hunt", 2000, 10);
        PartTimeTeacher partTimeTeacher = new PartTimeTeacher("Benjamin", "Dover", 2000, 24);
        university.addProfessor(fullTimeTeacher);
        university.addProfessor(partTimeTeacher);
    }

    public static void populateStudents(University university){
        Student student1 = new Student("Dixie Normus", 22);
        Student student2 = new Student("Philip McCrakin", 19);
        Student student3 = new Student("Moe Lester", 17);
        Student student4 = new Student("Emma Royd", 20);
        Student student5 = new Student("Jack Hoffman", 35);
        Student student6 = new Student("Eileen Dover", 28);
        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
        university.addStudent(student4);
        university.addStudent(student5);
        university.addStudent(student6);
    }

    public static void populateCourses(University university){
        Course course1 = new Course("Forestry Psychology", 420);
        course1.setProfessor(university.findProfessorById(1));
        course1.registerStudent(university.findStudentById(1));
        course1.registerStudent(university.findStudentById(2));
        Course course2 = new Course("Meme History I", 69);
        course2.setProfessor(university.findProfessorById(2));
        course2.registerStudent(university.findStudentById(3));
        course2.registerStudent(university.findStudentById(4));
        Course course3 = new Course("Funk Dancing for Self Defense", 411);
        course3.setProfessor(university.findProfessorById(2));
        course3.registerStudent(university.findStudentById(5));
        course3.registerStudent(university.findStudentById(6));
        Course course4 = new Course("Advanced Candle Making", 415);
        course4.setProfessor(university.findProfessorById(1));
        course4.registerStudent(university.findStudentById(5));
        course4.registerStudent(university.findStudentById(6));
        university.addCourse(course1);
        university.addCourse(course2);
        university.addCourse(course3);
        university.addCourse(course4);
    }

}
