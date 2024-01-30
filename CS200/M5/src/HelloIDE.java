///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           HelloIDE
// Course:          Comp Sci 200, Term 1, 2021
//
// Author:          August Bambenek
// Email:           abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.util.Scanner;

public class HelloIDE {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is your name?");
        String userName = scnr.hasNext() ? scnr.next() : (Config.DEFAULT_NAME);
        if (userName.isBlank()) {
            userName = (Config.DEFAULT_NAME);
        }
        else {
            userName = userName.trim();
        }
        System.out.print("Hello, " + userName + "!");
        scnr.close();
    }

}
