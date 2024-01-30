import java.util.Scanner;

public class MessedUp {
    public static String g(int t) {
        String detail;
        if (t >= 93)
            detail = "A";
        else if (t >= 89)
            detail = "AB";
        else if (t >= 82)
            detail = "B";
        else if (t >= 76)
            detail = "BC";
        else if (t >= 68)
            detail = "C";
        else if (t >= 55)
            detail = "D";
        else
            detail = "F";
        return detail;
    }

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        System.out.print("Enter your score: ");
        int s = z.nextInt();
        System.out.println("Grade: " + g(s));
    }
}
