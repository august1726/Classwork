///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
//Title:           Hello IDE
//Course:          Comp Sci 200, Term 1, 2021
//
//Author:          August Bambenek
//Email:           abambenek@wisc.edu
//Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
//Source or Recipient; Description
//Examples:
//Jane Doe; helped me with for loop in reverse method
//https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//counting for loop
//John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;
import java.lang.String;

public class HelloID {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("What is your name?");
        String name = scnr.next();
        if (name.isBlank() || name.isEmpty()) {
            name = (Config.DEFAULT_NAME);
        }
        else {
            name = name.trim();
        }
        System.out.print("Hello, " + name + "!");
        scnr.close();
    }
}
