///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Print Ragged Array
// Course:          COMP SCI 200, term 1, and 2021
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
public class PrintArray{
    public static void print(int[][] list){
        for (int i = 0; i < list.length; ++i) {
            int sum = 0;
            for (int j = 0; j < list[i].length; ++j) {
                System.out.print(list[i][j] + " ");
                sum += list[i][j];
                if (j == list[i].length - 1) {
                    System.out.println(sum);
                }
            }
        }
        //TODO: Print out list with sum at the end of each row
    }
}
