///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Draw Isosceles Triangle
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

public class DrawIsoscelesTriangle {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int triangleHeight = 0;

      int i = 0;
      int j = 0;

      System.out.print("Enter triangle height: ");
      triangleHeight = scnr.nextInt();

      //make sure triangle height is positive and odd
      while (triangleHeight < 0 || triangleHeight % 2 == 0) {
          System.out.print("Enter triangle height: ");
          triangleHeight = scnr.nextInt();
      }
      System.out.println("");
      int loopnum = 1;
      //draw top half of triangle up to its peak height (triangleHeight)
      for (int o = 1; o <= triangleHeight; ++o) {
          System.out.println("");
          for (int p = 1; p <= loopnum; ++p) {
              System.out.print("*");
          }
          loopnum += 1;
      }
      System.out.println("");
      loopnum = triangleHeight - 1;
      //draw rest of triangle
      for (int q = triangleHeight - 1; q >= 1; --q) {
          for (int r = 1; r <= loopnum; ++r) {
              System.out.print("*");
          }
          loopnum -= 1;
          System.out.println("");
      }



      return;
   }
}