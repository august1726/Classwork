///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Rock Paper Scissors
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
import java.util.Random;
public class RockPaperScissors {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      Random rand = new Random(Config.SEED);
      int compChoice = rand.nextInt(3) + 1;
      int userChoice;
      System.out.print("Please select one of [R/P/S]: ");
      if (scnr.hasNext()) {
          String userInput = scnr.next();
          userChoice = DetermineNum(userInput);
      }
      else {
          System.out.println("Invalid choice! Defaulting to Rock.");
          userChoice = 1;
      }
      System.out.println("I chose: " + DetermineType(compChoice));
      DetermineWinner(userChoice, compChoice);
      scnr.close();
   }
   public static int DetermineNum(String n) {
       int val;
       if (n.contains("r") || n.contains("R")) {
           val = 1;
           System.out.println("You chose: Rock");
       }
       else if (n.contains("p") || n.contains("P")) {
           val = 2;
           System.out.println("You chose: Paper");
       }
       else if (n.contains("s") || n.contains("S")) {
           val = 3;
           System.out.println("You chose: Scissors");
       }
       else {
           System.out.println("Invalid choice! Defaulting to Rock.");
           val = 1;
       }
       return val;
   }
   public static String DetermineType(int val) {
       int a = 1;
       int b = 2;
       int c = 3;
       if (val == a) {
           return "Rock";
       }
       if (val == b) {
           return "Paper";
       }
       if (val == c) {
           return "Scissors";
       }
       else {
           return "error";
       }
   }
   public static void DetermineWinner(int userChoice, int compChoice) {
       if (userChoice == compChoice) {
           System.out.println("A Tie!");
       }
       else if (userChoice == 1 && compChoice == 2) {
           System.out.println("Paper beats rock - you lose!");
       }
       else if (userChoice == 1 && compChoice == 3) {
           System.out.println("Rock beats scissors - you win!");
       }
       else if (userChoice == 2 && compChoice == 1) {
           System.out.println("Paper beats rock - you win!");
       }
       else if (userChoice == 2 && compChoice == 3) {
           System.out.println("Scissors beats paper - you lose!");
       }
       else if (userChoice == 3 && compChoice == 1) {
           System.out.println("Rock beats scissors - you lose!");
       }
       else if (userChoice == 3 && compChoice == 2) {
           System.out.println("Scissors beats paper - you win!");
       }
   }
}