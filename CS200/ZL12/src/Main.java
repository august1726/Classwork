import java.lang.Integer;
import java.util.Scanner;
public class Main{
    /**
     * This program reads a multi-dimensional array from the scanner of the form {{row1}{row2}...}.
     * Spaces are removed before parsing so they don't matter. Each row is a list of comma-separated integers.
     * After reading the input, this program calls PrintArray.print to print of each row on a line followed by the sum
     * of that row.
     *
     * Students DO NOT need to change this method and this file cannot be submitted.
     */
    public static void main(String[] args){
        System.out.print("Enter a 2-D array: ");      
        
        Scanner scan = new Scanner(System.in);
        
        if (scan.hasNext()){
            String arr = scan.nextLine();
            arr = arr.substring(2,arr.length()-2).replaceAll(" ", "");
            
            String [] lines = arr.split("\\}\\{");
            int[][] test = new int[lines.length][];
            
            for (int i = 0; i < lines.length; ++i){
                String[] line = lines[i].split(",");
                test[i] = new int[line.length];
                
                for (int j = 0; j < line.length; ++j){
                    test[i][j] = Integer.parseInt(line[j]);
                }
            }
            System.out.println();
            PrintArray.print(test);
        }
    }
}