///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Binary To Decimal
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

public class BinaryToDecimal {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int bitLength;
      // Get the bitLength of binary number as input from user
      bitLength = scnr.nextInt();
      int[] binaryNum = new int[bitLength];
      int digitWeight; 
      int decimalSum = 0; 
      int i;
      
      // Get user's binary number. Store leftmost bit in index (bitlength-1) of binaryNum array and rightmost in index (0).
      for (i = bitLength - 1; i >= 0; --i) {
          binaryNum[i] = scnr.nextInt();
       }
      for (i = 0; i < bitLength; ++i) {
          digitWeight = (int)Math.pow(2, i);
          decimalSum += binaryNum[i] * digitWeight;
      }
      // Hint: Store binary input in reverse order in the array. 
      // for..{
      //   Update the binaryNum array
      // }
      
      /* Add code to convert from binary to decimal
         Hint : Loop over elements in binaryNum and multiply by approriate power of 2. ie 2^0, 2^1, 2^2 and so on.
         Type your code here. */
         
      System.out.println(decimalSum);
   }
}
