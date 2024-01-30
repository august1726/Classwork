///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Input Methods
// Course:          Comp Sci 200, Term 1, 2021
//
// Author:          August Bambenek
// Email:           abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Original template By Jim Williams and Devesh Shah
//
//
// 
//
// 
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Some methods to get user input.
 *
 * @author Jim Williams
 * @author Devesh Shah
 * @author August Bambenek
 */
public class InputMethods {
    
    /**
     * Prompts the user for an integer that is greater than the min value and less than or equal to
     * the max value. Searches for an integer that meets these conditions in the first token of the
     * first line. If no integer is found, it searches the first tokens of the next 2 lines.
     *
     * @param input           a scanner containing user input
     * @param requestMessage  a message that will be printed out to prompt the user for input 
     * that is between two values
     * @param min             a value that the valid integer must be greater than
     * @param max             a value that the valid integer must be less than or equal to
     * @return                returns an integer that is between the max and min bounds, returns -1
     * if the scanner passed in is null, returns -2 if the min value isn't less than the max value,
     * or returns -3 if no integer meeting the conditions is found in the first 3 lines of input
     */
    public static int getValidInt(Scanner input, String requestMessage, int min, int max) {
        System.out.println(requestMessage);
        if (input == null) {
            return -1;
        }
        if (min >= max) {
            return -2;
        }
        int validInt;
        for (int i = 0; i < 3; ++i) {
            if (input.hasNextInt()) {
                validInt = input.nextInt();
                if (validInt > min && validInt <= max) {
                    return validInt;
                }
            }
            if (i < 2){
                input.nextLine();
                System.out.println(requestMessage);
            }
        }
        
        return -3;
    }

}
