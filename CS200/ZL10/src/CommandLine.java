import java.util.IllegalFormatException;

///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Command Line
// Course: Comp Sci 200 Term 1 2021
//
// Author: August Bambenek
// Email: abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html;
// counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
public class CommandLine {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.print("Incorrect number of arguments passed");
            return;
        }
        int num = Integer.parseInt(args[0]);
        int factorial;
        if (num < 0) {
            System.out.print("Argument is a negative number");
            return;
        }
        if (num == 0) {
            System.out.print("The factorial of " + num + " is 1");
            return;
        }
        if (num > 0) {
            factorial = num;
            for (int i = num - 1; i > 0; --i) {
                factorial *= i;
            }
            System.out.print("The factorial of " + num + " is " + factorial);
        }
    }
}
