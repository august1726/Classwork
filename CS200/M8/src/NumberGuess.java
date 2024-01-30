///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Even Number Guessing Game
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
import java.util.Random;
import java.util.Scanner;
public class NumberGuess{
    public static void main(String[] args){
        Random rand = new Random();
        rand.setSeed(Config.SEED);
        Scanner scnr = new Scanner(System.in);
        int ans = rand.nextInt(100/2) * 2 + 2;
        int guess = 0;
        int b1 = 1;
        int b2 = 100;
        int loopnum = 0;
        while (guess != ans) {
            System.out.print("Please make an even number guess between " + b1 + " and " + b2 + ": ");
            guess = scnr.nextInt();
            if (guess % 2 != 0 || guess < b1 || guess > b2) {
                loopnum += 1;
                continue;
            }
            else if (guess < ans) {
                b1 = guess;
            }
            else if (guess > ans) {
                b2 = guess;
            }
            else if (guess == ans) {
                loopnum += 1;
                System.out.print("You won in " + loopnum + " trials!");
                break;
            }
            loopnum += 1;
        }
        scnr.close();
    }
}