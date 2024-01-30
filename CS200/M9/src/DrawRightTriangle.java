///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Right Triangle Maker
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
public class DrawRightTriangle {
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char char1 = scnr.next().charAt(0);
        System.out.println("Enter triangle height (1-10): ");
        int int1 = scnr.hasNextInt() ? scnr.nextInt() : 0;
        while (int1 > 10 || int1 < 1) {
            System.out.println("Please enter height between 1 and 10.");
            int1 = scnr.nextInt();
        }
        for (int i = int1; i >= 0; --i) {
            System.out.println("");
            for (int j = 1; j <= int1; ++j) {
                System.out.print(char1 + " ");
            }
            int1 -= 1;
        }
        scnr.close();
    }
}
