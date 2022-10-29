package org.globant.view;

import org.globant.data.*;
import org.globant.persistence.DataInitializer;
import org.globant.util.Reader;

public class Main {
    public static void main(String[] args) {

        boolean iterator = true;
        University myUniversity = DataInitializer.loadUniversity();

        System.out.println("*******************");
        System.out.println("*** WELCOME  TO ***");
        System.out.println("***   GLOBUNI   ***");
        System.out.println("*******************");


        while(iterator){
            int option;

            System.out.println("Choose an option:");
            System.out.println(" 1. See Professors  |  2. See Courses  | 3. See Students  |  4. Exit");
            option = Reader.intScanner();
            switch (option){
                case 1:
                    handleProfessorMenu(myUniversity);
                    break;
                case 2:
                    handleCourseMenu(myUniversity);
                    break;
                case 3:
                    handleStudentMenu(myUniversity);
                    break;
                case 4:
                    iterator = handleExit();
                    break;
                default:
                    handleInvalidOption();
            }
        }
    }

    // ***************** OPTION 1. PROFESSORS ********************

    public static void handleProfessorMenu(University university) {
        boolean iterator = true;
        System.out.println("Welcome to the professors menu");

        while (iterator) {
            int option;

            System.out.println(" ");
            System.out.println("Please choose an option:");
            System.out.println(" 1. List Professors  |  2. Create Professor  | 3. See Classes per Professor  |  4. Go back");

            option = Reader.intScanner();
            switch (option) {
                case 1:
                    listProfessors(university);
                    break;
                case 2:
                    createProfessor(university);
                    break;
                case 3:
                    seeCoursesPerTeacher(university);
                    break;
                case 4:
                    iterator = handleExit();
                    break;
                default:
                    handleInvalidOption();
            }
        }
    }

    public static void listProfessors(University university){
        if (university.getTeacherList().size() > 0){
            System.out.println("  id  | \t\t Name \t\t | \t\t\t email \t\t\t | \t\t Contract \t\t | \t Salary \t");
            for (int i = 0; i < university.getTeacherList().size(); i++){
                System.out.println(university.getTeacherList().get(i));
            }
        } else {
            System.out.println("No professors registered. Register professors using option 2.");
        }
    }

    public static void createProfessor(University university){
        boolean error = true;

        System.out.println("Type in the teacher's First Name:");
        String firstName = Reader.stringScanner();
        System.out.println("Type in the teacher's Last Name");
        String lastName = Reader.stringScanner();
        System.out.println("Under what base salary was this Teacher hired?");
        double baseSalary = Reader.doubleScanner();

        while(error){
            System.out.println("Please choose the type of contract for this teacher:");
            System.out.println(" 1. Full-Time  |  2. Part-Time");
            int option = Reader.intScanner();
            switch (option) {
                case 1:
                    System.out.println("Please type in this teacher's experience in years:");
                    int experience = Reader.intScanner();
                    FullTimeTeacher fullTimeTeacher = new FullTimeTeacher(firstName, lastName, baseSalary, experience);
                    university.addProfessor(fullTimeTeacher);
                    error = false;
                    break;
                case 2:
                    System.out.println("How many hours a week will this teacher work?");
                    int activeHours = Reader.intScanner();
                    PartTimeTeacher partTimeTeacher = new PartTimeTeacher(firstName, lastName, baseSalary, activeHours);
                    university.addProfessor(partTimeTeacher);
                    error = false;
                    break;
                default:
                    System.out.println("invalid option");
            }
        }
        System.out.println(" ");
        System.out.println("Professor created successfully!");
    }

    public static void seeCoursesPerTeacher(University university){
        int counter = 0;
        System.out.println("To see the classes of a given Teacher, please type in a teacher's ID:");
        int id = Reader.intScanner();
        Professor professor = university.findProfessorById(id);
        if (professor.getId() > 0){
            System.out.println("Professor " + professor.getFirstName() + " " + professor.getLastName() + " Classes:");
            for (int i = 0; i < university.getCourseList().size(); i++){
                if (university.retrieveProfessorIdFromCourseList(i) == id){
                    System.out.println("\t" + university.retrieveCourseName(i));
                    counter++;
                }
            }
            if (counter == 0){
                System.out.println("\t Teacher has no classes assigned.");
            }
        } else {
            System.out.println("Invalid professor ID");
        }
    }

    // ***************** OPTION 2. COURSES ********************

    public static void handleCourseMenu(University university) {
        boolean iterator = true;

        while (iterator) {
            int option;

            System.out.println("Welcome to the courses menu, please choose an option:");
            System.out.println(" 1. List All Courses  |  2. Create a Course  | 3. Go back");

            option = Reader.intScanner();
            switch (option) {
                case 1:
                    listCourses(university);
                    break;
                case 2:
                    createCourse(university);
                    break;
                case 3:
                    iterator = handleExit();
                    break;
                default:
                    handleInvalidOption();
            }
        }
    }

    public static void listCourses(University university){
        boolean iterator = true;
        System.out.println("  ID  |  COURSE NAME");
        if (university.getCourseList().size() > 0){
            for (int i = 0; i < university.getCourseList().size(); i++){
                System.out.println(university.getCourseList().get(i));
            }
            System.out.println(" ");
            while (iterator){
                System.out.println("Type in the ID of a Course to see/update its details or 0 to go back:");
                int option = Reader.intScanner();
                if (option != 0){
                    Course chosenCourse = university.findCourseById(option);
                    if (chosenCourse.getId() > 0){
                        while (iterator){
                            int editOption;

                            System.out.println("Class ID:\t\t" + chosenCourse.getId());
                            System.out.println("Class Name:\t\t" + chosenCourse.getName());
                            System.out.println("Classroom:\t\t" + chosenCourse.getClassroom());
                            System.out.println("Professor:\t\t" + chosenCourse.retrieveProfessorName());
                            System.out.println("Registered Students:");
                            for (int i = 0; i < chosenCourse.getRegisteredStudents().size(); i++){
                                System.out.println("\t\t\t\t" + chosenCourse.retrieveStudentName(i));
                            }

                            System.out.println(" ");
                            System.out.println(" 1. Edit Class Name | 2. Edit Classroom | 3. Edit Professor | 4. Enroll Students | 5. Exit");
                            editOption = Reader.intScanner();
                            switch (editOption){
                                case 1:
                                    editClassName(chosenCourse);
                                    break;
                                case 2:
                                    editClassRoom(chosenCourse);
                                    break;
                                case 3:
                                    editProfessor(university, chosenCourse);
                                    break;
                                case 4:
                                    enrollStudents(university, chosenCourse);
                                    break;
                                case 5:
                                    iterator = handleExit();
                                    break;
                                default:
                                    handleInvalidOption();
                            }
                        }
                    } else {
                        System.out.println("No courses match the ID provided.");
                    }
                } else {
                    iterator = handleExit();
                }
            }
        }
    }

    public static void editClassName(Course course){
        System.out.println("Type in the new course name:");
        String newName = Reader.stringScanner();
        course.setName(newName);
        System.out.println("Class name changed to: " + newName);
    }

    public static void editClassRoom(Course course){
        System.out.println("Enter the new ClassRoom");
        int newClassRoom = Reader.intScanner();
        course.setClassroom(newClassRoom);
        System.out.println("Classroom changed to: " + newClassRoom);
    }

    public static void editProfessor(University university, Course course){
        System.out.println("These are the available professors:");
        listProfessors(university);
        boolean iterator = true;
        while (iterator){
            System.out.println("Please type in the ID of the professor you wish to assign to this class or 0 to cancel:");
            int id = Reader.intScanner();
            Professor newProfessor = university.findProfessorById(id);
            if (course.setProfessor(newProfessor)){
                System.out.println("Professor: " + newProfessor.getFirstName() + " " + newProfessor.getLastName() + " assigned to this Course.");
                iterator = false;
            } else if (id == 0) {
                iterator = handleExit();
            } else {
                System.out.println("No professors found with that ID.");
            }
        }
    }

    public static void enrollStudents(University university, Course course){
        int id = 1;
        while (id != 0){
            System.out.println("List of registered students:");
            System.out.println("  ID  |\t\tNAME\t\t|\tAGE");
            for(int i = 0; i < university.getStudentList().size(); i++) {
                System.out.println(university.getStudentList().get(i));
            }
            System.out.println(" ");
            System.out.println("Type the ID of the student you wish to enroll or 0 to go back");
            id = Reader.intScanner();
            if (course.registerStudent(university.findStudentInUniversity(id))){
                System.out.println("Student enrolled in course.");
                System.out.println("You can enroll another Student.");
            } else {
                System.out.println("Unable to enroll Student, either the student is already enrolled or the ID is invalid.");
            }
        }
    }

    public static void createCourse(University university){
        System.out.println("Type in the name of the course:");
        String name = Reader.stringScanner();
        System.out.println("Type in the Classroom where this course will take place:");
        int classroom = Reader.intScanner();
        Course newCourse = new Course(name, classroom);
        university.addCourse(newCourse);
        System.out.println("Course :" + name + " created successfully");
        System.out.println("Please assign a professor");
        editProfessor(university, newCourse);
        System.out.println("Please enroll students to this course:");
        enrollStudents(university, newCourse);
    }



    // ***************** OPTION 3. STUDENTS ********************

    public static void handleStudentMenu(University university) {
        boolean iterator = true;

        while (iterator) {
            int option;

            System.out.println("Welcome to the students menu, please choose an option:");
            System.out.println(" 1. List All Students  |  2. Create a Student  | 3. Go back");

            option = Reader.intScanner();
            switch (option) {
                case 1:
                    printAllStudents(university);
                    break;
                case 2:
                    createStudent(university);
                    break;
                case 3:
                    iterator = handleExit();
                    break;
                default:
                    handleInvalidOption();
            }
        }
    }

    public static void printAllStudents(University university){
        boolean iterator = true;

        while(iterator){
            int id;
            int counter = 0;
            System.out.println("  ID  |\t\tNAME\t\t|\tAGE");
            for(int i = 0; i < university.getStudentList().size(); i++){
                System.out.println(university.getStudentList().get(i));
            }
            System.out.println("Type the ID of a student to see the classes they're enrolled in or 0 to go back:");
            id = Reader.intScanner();
            if (id > 0 && id <= university.getStudentList().size()){
                for (int i = 0; i < university.getCourseList().size(); i++){
                    if (university.confirmStudentEnrolled(id, i)){
                        System.out.println(university.getCourseList().get(i).getName());
                        counter++;
                    }
                }
                if (counter == 0){
                    System.out.println("Student is not enrolled in any class.");
                }
            } else if (id == 0) {
                iterator = handleExit();
            } else {
                System.out.println("Invalid ID");
            }
        }
    }

    public static void createStudent(University university){
        boolean error = true;
        int age;

        System.out.println("Type in the student name:");
        String name = Reader.stringScanner();
        System.out.println("Type in the student's age:");
        age = Reader.intScanner();
        Student newStudent = new Student(name, age);
        university.addStudent(newStudent);

        while(error) {
            int id;

            System.out.println("These are the courses you can enroll the student in:");
            System.out.println("  ID  |  COURSE NAME");
            for (int i = 0; i < university.getCourseList().size(); i++){
                System.out.println(university.getCourseList().get(i));
            }
            System.out.println(" ");
            System.out.println("Type in the ID for the class you wish to enroll the student");
            id = Reader.intScanner();
            Course chosenCourse = university.findCourseById(id);
            if (chosenCourse.getId() > 0){
                chosenCourse.registerStudent(newStudent);
                System.out.println("Student: " + newStudent.getName() + " created and enrolled successfully.");
                error = false;
            } else {
                System.out.println("Invalid Course ID");
            }
        }
    }

    public static void seeClassesPerStudent(University university){
        int id;

        System.out.println("Type in the id of a student to see the courses they're enrolled in");
        id = Reader.intScanner();

    }

    public static boolean handleExit(){
        System.out.println("Leaving this menu.");
        return false;
    }

    public static void handleInvalidOption(){
        System.out.println("Invalid option");
        System.out.println("Please choose the number of the option you wish to take.");
    }


}