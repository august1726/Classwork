///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Print 4 Per Line
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

public class FourPerLine {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int[] yearlyValues = new int[12];
      int i;
      int userNum;
      
      // Get array values
      for (i = 0; i < 12; ++i) {
         yearlyValues[i] = scnr.nextInt();
      }
      
      for (i = 0; i < 12; i += 4) {
          System.out.print(yearlyValues[i] + " ");
          System.out.print(yearlyValues[i + 1] + " ");
          System.out.print(yearlyValues[i + 2] + " ");
          System.out.println(yearlyValues[i + 3]);
       }
   }
}
