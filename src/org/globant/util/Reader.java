package org.globant.util;

import java.util.Scanner;

public class Reader {

    public static int intScanner(){
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (java.util.InputMismatchException e){
            System.out.println("Invalid input, please input a number without symbols");
            return -1;
        }
    }

    public static double doubleScanner(){
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextDouble();
        } catch (java.util.InputMismatchException e){
            System.out.println("Invalid input, please input a number without symbols");
            return -1;
        }
    }

    public static String stringScanner(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

}
