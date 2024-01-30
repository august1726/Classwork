import java.util.Scanner;

// TODO Make the improvements listed in the lab

public class GameOfSticks {

    public static int promptUser(Scanner input, String prompt, int min, int max) {
        int userChoice = 0;
        do {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                userChoice = input.nextInt();
                input.nextLine();
                if (userChoice < min || userChoice > max) {
                    System.out.println("Please enter a number from " + min + " to " + max + ".");
                }
            } else {
                input.nextLine();
            }
        } while (userChoice < min || userChoice > max);
        return userChoice;
    }

    public static int computer(int rem) {
        int pickUp = (rem - 1) % 4;
        return pickUp > 0 ? pickUp : 1;
    }

    public static void main(String[] args) {
        int START = 21;
        int MAX = 3;
        int MIN = 1;
        Scanner i = new Scanner(System.in);
        System.out.println("Welcome to the Game of Sticks");
        int sr = START;
        System.out.print("Would you like to go first? (y/n): ");
        boolean ht = i.nextLine().trim().equalsIgnoreCase("y");
        int uc = 0;
        int cc = 0;
        for (; sr > 0;) {
            if (ht == true) {
                String prompt = "There are " + sr + " remaining sticks. How many do you pick up ("
                    + MIN + "-" + Math.min(MAX, sr) + ")? ";
                uc = promptUser(i, prompt, MIN, MAX);
                sr -= uc;
                if (sr <= 0) {
                    System.out.println("You lost!");
                }
            }
            if (ht == false) {
                cc = computer(sr);
                System.out.println("Computer picks up " + cc + " sticks");
                sr -= cc;
                if (sr <= 0) {
                    System.out.println("You won!");
                }
            }
            ht = !ht;
        }
    }
}
