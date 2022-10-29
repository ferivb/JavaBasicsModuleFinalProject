package org.globant.view;

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
                    handleProfessorMenu();
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

    public static void handleProfessorMenu() {
        boolean iterator = true;

        while (iterator) {
            int option;

            System.out.println("Welcome to the professors menu, please choose an option:");
            System.out.println(" 1. List Professors  |  2. Create Professor  | 3. See Classes per Professor  |  4. Go back");

            option = Reader.intScanner();
            switch (option) {
                case 1:
                    System.out.println("Create list professors func");
                    break;
                case 2:
                    System.out.println("Create create professor func");
                    break;
                case 3:
                    System.out.println("create courses list func");
                    break;
                case 4:
                    iterator = handleExit();
                    break;
                default:
                    handleInvalidOption();
            }
        }
    }

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