import java.util.Scanner;

public class styleAndComment {
    public static String g(int t) {
        String d;       if (t >= 93)    d = "A";
        else if (     t >= 89)          d = "AB";
            else if (t >=      82)          d = "B";    else if (t      >= 76)          d = "BC";
        else if (t >= 68)           d = "C";
                            else if (t >= 55)           d = "D";
        else    d = "F";        return d;   }

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);     System.out.print("Enter your score: ");
        int s = z.nextInt();        System.out.println("Grade: " 
                + g(s));
    }
}
