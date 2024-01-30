///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Is Divisible By 3
// Course:          Comp Sci 200 Term 1 2021
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
import java.util.InputMismatchException;

public class IntException {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.print(isDivisibleByThree(scnr));
   }
   
  /**
   * Determines if the input to scanner is evenly divisible by three, and
   * returns the result as a boolean. If the input to scanner is inappropriate,
   * catch the exception.
   * 
   * @param  scnr  a scanner object 
   * @return       true if input is evenly divisible by three, false if not
   */ 
   public static boolean isDivisibleByThree(Scanner scnr) {
       try {
           int num = scnr.nextInt();
           if (num % 3 == 0) {
               return true;
           }
           else {
               return false;
           }
       }
       catch(NullPointerException e) {
           return false;
       }
       catch(InputMismatchException f) {
           return false;
       }
      //TODO: try-catch block which catches incorrect input
   
   }

}