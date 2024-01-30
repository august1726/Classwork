///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Mystery Methods
// Course:          Comp Sci 200, Term 1, 2021
//
// Author:          August Bambenek
// Email:           abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Original Code by Juan Rios and reviewed by Tiger Ji
// 
// 
//  
// 
//  
// 
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

/**
 * This class contains four mystery methods and main method. The main method tests
 * the four mystery methods and displays the results. The names of each method and
 * variable have been refactored to better describe what is happening.
 *
 * @author Juan Rios
 * @author Tiger Ji
 * @author August Bambenek
 */
public class MysteryMethods {
    
    /**
     * The main method tests the other four mystery methods by inputting the character 
     * array charArray1 whatever other parameters are necessary into each method and 
     * displaying the results
     * 
     * @param args  unused
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Mystery Methods!");
        char[] charArray1 = {'e', 'n', 'i', 'r', 't', 'S', 'g', 'l', 'p', 'm', 'i', 'S'};
        System.out.print("Initial array: ");
        System.out.println(charArray1);
        System.out.println(" \nMethod Outputs:");

        int occurrenceIndex1 = firstOccurrenceOfChar('e', charArray1);

        System.out.println("First call of the first Method:");
        System.out.println(occurrenceIndex1);

        int occurrenceIndex2 = firstOccurrenceOfChar('g', charArray1);

        System.out.println("Second call of the first Method:");
        System.out.println(occurrenceIndex2);

        swapTwoChars(occurrenceIndex1, occurrenceIndex2, charArray1);

        System.out.println("Call of the second Method:");
        System.out.println(charArray1);

        charArray1 = reverseAnArray(charArray1);
        System.out.println("Call of the third Method:");
        System.out.println(charArray1);

        char[] charsToSearchFor = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        int[] numOfMatches = searchArrayForChars(charsToSearchFor, charArray1);

        System.out.println("Call of the fourth Method:");
        printInput("Fourth Method Output:", numOfMatches);
    }

    /**
     * This method prints the description followed by the contents of list. The list
     * begins with '[', ends with ']' and each element is separated with ', '.
     * Example: printInput( "Initial array:", new int[]{1,2,3}) Initial array: [1, 2, 3]
     * <p>
     * @param description The text printed out before the list of ints.
     * @param list        The array of ints to be printed.
     */
    public static void printInput(String description, int[] list) {

        System.out.print(description);
        System.out.print(" [");

        for (int i = 0; i < list.length; i++) {

            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(list[i]);
        }
        System.out.println("]");
    }
    
    /**
     * Finds the first occurrence of a character charToFind in charArray and returns
     * the index of where the character first occurs in charArray.
     * 
     * @param charToFind The character that will be searched for in charArray
     * @param charArray  The array of characters that will be searched through
     * @return returns the index of the first occurence of charToFind in charArray
     * or returns -1 if it isn't in charArray
     */
    public static int firstOccurrenceOfChar(char charToFind, char[] charArray) {

        for (int i = 0; i < charArray.length; i++) {

            if (charToFind == charArray[i]) {

                return i;
            }
        }

        return -1;
    }

    /**
     * This method takes two elements of charArray at index1 and index2 and swaps
     * their places in charArray. If index1 or index2 are less than zero, or if 
     * charArray has a length less than or equal to one of the indices, the method
     * will return without changing anything
     * 
     * @param index1    The index of one character in charArray that will be swapped
     * @param index2    The index of another character in charArray that will be swapped
     * @param charArray a char array that will have two characters swapped
     */
    public static void swapTwoChars(int index1, int index2, char[] charArray) {
        if (index1 < 0 || index2 < 0 || charArray.length <= Math.max(index1, index2)) {
            return;
        }
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
    
    /**
     * This method takes a char array and returns the array in reverse order
     * 
     * @param  forwardArray A char array that will be reversed
     * @return returns forwardArray in reverse order, so the character at the first index
     * will now be at the last index and so on. If forwardArray is empty, it will
     * return forwardArray unchanged
     */
    public static char[] reverseAnArray(char[] forwardArray) {

        if (forwardArray.length == 0) {
            return forwardArray;
        }

        char[] reverseArray = new char[forwardArray.length];

        for (int i = 0; i < forwardArray.length; i++) {
            reverseArray[forwardArray.length - i - 1] = forwardArray[i];
        }
        return reverseArray;
    }

    /**
     * This method takes two char arrays (charsToSearchFor and charArray) and
     * finds how many times each character in charsToSearchFor appears in charArray,
     * regardless of if it is uppercase or lowercase.
     * 
     * @param charsToSearchFor A char array with with chars whose numbers of occurences
     * in charArray will be recorded
     * @param charArray        The char array that will be examined to see how many times
     * each char in charsToSearchFor appears in it
     * @return returns an int array with the number of times each letter in charsToSearchFor
     * appears in charArray. returns an int array with the same length of 
     * charsToSearchFor if either array has a length of 0
     */
    public static int[] searchArrayForChars(char[] charsToSearchFor, char[] charArray) {

        if (charsToSearchFor.length == 0 || charArray.length == 0) {
            return new int[charsToSearchFor.length];
        }

        int[] numMatches = new int[charsToSearchFor.length];

        for (int i = 0; i < charsToSearchFor.length; i++) {
            for (int j = 0; j < charArray.length; j++) {
                if (Character.toUpperCase(charArray[j]) == 
                    Character.toUpperCase(charsToSearchFor[i])) {
                    numMatches[i] += 1;
                }
            }
        }

        return numMatches;
    }
}
