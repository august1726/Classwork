import java.util.ArrayList;
import java.util.Scanner;

public class Counter {

    public static void main(String[] args) {
        ArrayList<Integer> dailyCounts = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a hashtag: ");
        String hashtag = input.nextLine().trim();
        hashtag = hashtag.startsWith("#") ? hashtag : "#" + hashtag;
        
        System.out.println("Enter count of " + hashtag + " tweets per day (negative to end).");
        
        boolean done = false;
        do {
            int count = input.nextInt();
            if ( count < 0) {
                done = true;
            } else {
                dailyCounts.add( count);
            }
        } while ( !done);
        
        //determine total number of days of data
        //determine minimum
        //determine maximum
        //determine average
        //draw a bar chart where maximum / 50 is represented by one *.
        
    }
}
