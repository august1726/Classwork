///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Min, Max, and Avg finder
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

public class MinMaxAvg {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int[] userValues = new int[10];
      int i;
      
      for (i = 0; i < 10; ++i) {
         userValues[i] = scnr.nextInt();
      }
      
      int minVal = 10000;
      int maxVal = -10000;
      long avgVal = 0;
      for (i = 0; i < 10; ++i) {
          if (userValues[i] > maxVal) {
              maxVal = userValues[i];
          }
          if (userValues[i] < minVal) {
              minVal = userValues[i];
          }
       }
      for (i = 0; i < 10; ++i) {
          if (userValues[i] != minVal && userValues[i] != maxVal) {
              avgVal += (long)userValues[i];
          }
       }
      System.out.println(minVal + " " + maxVal + " " + (avgVal/8.0));
   }
}