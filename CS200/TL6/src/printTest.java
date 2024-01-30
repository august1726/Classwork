import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class printTest {
    public static void main(String[] args) {
        String outFileName = "myData.txt";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(outFileName);
            for (int i = 1; i <= 9; i++) {
                writer.printf("%d, ", i * i);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to write to " + outFileName);
        } finally {
            // if (writer != null) writer.close();
        }

        writer.close();
    }
}
