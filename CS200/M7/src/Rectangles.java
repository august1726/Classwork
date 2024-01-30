///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Rectangle Comparison
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
import java.lang.Math;


public class Rectangles {
   
   /* Type your code here */
   
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); 
      int r1xul, r1yul, r1xbr, r1ybr; // x upper-left, y upper-left, x bottom-right, y bottom-right
      int r2xul, r2yul, r2xbr, r2ybr;
      
      r1xul = scnr.nextInt(); r1yul = scnr.nextInt(); r1xbr = scnr.nextInt(); r1ybr = scnr.nextInt(); 
      r2xul = scnr.nextInt(); r2yul = scnr.nextInt(); r2xbr = scnr.nextInt(); r2ybr = scnr.nextInt(); 
   
      System.out.println(firstRectangleSmaller(r1xul, r1yul, r1xbr, r1ybr, r2xul, r2yul, r2xbr, r2ybr)); 
      scnr.close();
   }
   public static boolean firstRectangleSmaller(int r1xul, int r1yul, int r1xbr, int r1ybr, int r2xul, int r2yul, int r2xbr, int r2ybr) {
       double a1 = Math.abs((r1yul - r1ybr) * (r1xbr - r1xul));
       double a2 = Math.abs((r2yul - r2ybr) * (r2xbr - r2xul));
       boolean m = (a1 < a2) ? true : false;
       return m;
   }
}
