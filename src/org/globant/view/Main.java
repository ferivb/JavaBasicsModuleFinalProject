package org.globant.view;

import org.globant.data.FullTimeTeacher;
import org.globant.data.PartTimeTeacher;
import org.globant.data.Professor;
import org.globant.data.University;
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
                    handleCourseMenu();
                    break;
                case 3:
                    handleStudentMenu();
                    break;
                case 4:
                    iterator = handleExit();
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please choose the number of the option you wish to take.");
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

    public static void handleCourseMenu() {
        boolean iterator = true;

        while (iterator) {
            int option;

            System.out.println("Welcome to the courses menu, please choose an option:");
            System.out.println(" 1. List All Classes  |  2. Create a Course  | 3. Course Details  |  4. Go back");

            option = Reader.intScanner();
            switch (option) {
                case 1:
                    System.out.println("Create list professors func");
                    break;
                case 2:
                    System.out.println("Create create Course func");
                    break;
                case 3:
                    System.out.println("create course details func");
                    break;
                case 4:
                    iterator = handleExit();
                    break;
                default:
                    handleInvalidOption();
            }
        }
    }

    // ***************** OPTION 3. STUDENTS ********************

    public static void handleStudentMenu() {
        boolean iterator = true;

        while (iterator) {
            int option;

            System.out.println("Welcome to the students menu, please choose an option:");
            System.out.println(" 1. List All Students  |  2. Create a Student  | 3. Student Details  |  4. Go back");

            option = Reader.intScanner();
            switch (option) {
                case 1:
                    System.out.println("Create list students func");
                    break;
                case 2:
                    System.out.println("Create create student func");
                    break;
                case 3:
                    System.out.println("create student details func");
                    break;
                case 4:
                    iterator = handleExit();
                    break;
                default:
                    handleInvalidOption();
            }
        }
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