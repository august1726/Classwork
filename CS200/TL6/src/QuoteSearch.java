import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program provides the user a way to search a data file for quotes.
 * 
 * Data file source: https://github.com/akhiltak/inspirational-quotes/blob/master/Quotes.csv
 * @author Jim Williams
 * @author TODO (add your name when you contribute to this program.)
 */
public class QuoteSearch {

    /**
     * Looks for the phrase within the file.
     * @param phrase  The characters or words to search for.
     * @param fileName  The name of the file in which to search.
     * @return A list of quotes containing the phrase.
     * @throws FileNotFoundException
     */
    public static ArrayList<String> find(String phrase, String fileName)
            throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {

            String line = input.nextLine().toLowerCase().trim();
            if (line.contains(phrase)) {
                list.add(line);
            } else {
                // ignore for now
            }
        }
        input.close();
        return list;
    }

    /**
     * Saves the items to the specified file.
     * 
     * @param fileName The name of the file in which to save items.
     * @param items The list of items to save.
     * @throws FileNotFoundException
     */
    public static void save(String fileName, ArrayList<String> items) throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter writer = new PrintWriter(file);
        for (String item : items) {
            writer.print(item);
        }
        //TODO: Is it important or useful to close?
        //writer.close();
    }

    /**
     * This program prompts the user for a word and then looks for that word in a data file.
     * The main method contains all the user input and output and calls the appropriate methods
     * to read and write to files.
     * 
     * @param args (unused)
     */
    public static void main(String[] args) {
        final String DATA_FILE_NAME = "Quotes.csv";

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to QuoteSearch.");
        System.out.print("Enter a phrase: ");
        String searchPhrase = in.nextLine().toLowerCase().trim();

        ArrayList<String> foundList = null;
        try {
            foundList = find(searchPhrase, DATA_FILE_NAME);
            System.out.println("Found " + foundList.size() + " quotes containing " + searchPhrase);
                System.out.print("Enter filename or simply Enter to write to screen: ");
                String saveFileName = in.nextLine().trim();
                if (saveFileName.isEmpty()) {
                    for ( String item : foundList) {
                        System.out.println( item);
                    }
                } else {
                    try {
                        save(saveFileName, foundList);
                    } catch (FileNotFoundException e) {
                        System.out.println("Unable to write to file: " + saveFileName);
                    }
                }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in.close();
    }
}
