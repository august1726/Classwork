///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title: Test Input Methods
// Course: Comp Sci 200, Term 1, 2021
//
// Author: August Bambenek
// Email: abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Original Code By Jim Williams and Devesh Shah
//
// Edited, Additional Methods added By August Bambenek
//
//
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This contains testing methods for the InputMethods class.
 * 
 * @author Jim Williams
 * @author Devesh Shah
 * @author August Bambenek
 */
public class TestInputMethods {

    /**
     * This main method runs the selected tests. Comment out a test if you don't want it to run.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        testGetValidInt();
    }

    /**
     * Tests that the getValidInt method handles all the cases described in the assignment.
     */
    private static void testGetValidInt() {
        boolean error = false;

        {
            Scanner input = new Scanner("9\n");

            int expected = 9;

            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);

            if (actual != expected) {
                error = true;

                System.out.println(
                    "testGetValidInt 1) Error, expected: " + expected + ", actual: " + actual);
            }
        }
        {
            int expected = -1;
            int actual = InputMethods.getValidInt(null, "Enter a number between 0 and 10:", 0, 10);
            if (actual != expected) {
                error = true;
                System.out.println(
                    "testGetValidInt 2) Error, expected: " + expected + ", actual: " + actual);
            }
        }
        {
            Scanner input = new Scanner("9\n");
            int expected = -2;
            int actual = InputMethods.getValidInt(input, "Enter a number between 10 and 0:", 10, 0);
            if (actual != expected) {
                error = true;
                System.out.println(
                    "testGetValidInt 3) Error, expected: " + expected + ", actual: " + actual);
            }
        }
        {
            Scanner input = new Scanner("2 10 11\n7 8 9\n");
            int expected = 7;
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
            if (actual != expected) {
                error = true;
                System.out.println(
                    "testGetValidInt 4) Error, expected: " + expected + ", actual: " + actual);
            }
        }
        {
            Scanner input = new Scanner("test\n10\n");
            int expected = 10;
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
            if (actual != expected) {
                error = true;
                System.out.println(
                    "testGetValidInt 5) Error, expected: " + expected + ", actual: " + actual);
            }
        }
        {
            Scanner input = new Scanner("1\n2\n7\n");
            int expected = 7;
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
            if (actual != expected) {
                error = true;
                System.out.println(
                    "testGetValidInt 6) Error, expected: " + expected + ", actual: " + actual);
            }
        }
        {
            Scanner input = new Scanner("1\n2\n3\n7\n");
            int expected = -3;
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
            if (actual != expected) {
                error = true;
                System.out.println(
                    "testGetValidInt 7) Error, expected: " + expected + ", actual: " + actual);
            }
        }
        if (error) {
            System.out.println("testGetValidInt failed");
        } else {
            System.out.println("testGetValidInt passed; it is expected that the prompt and "
                + "getValidInt error messages are printed out.");
        }
    }
}
