///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Word Detective
// Course:          Comp Sci 200, Term 1, and 2021
//
// Author:          August Bambenek
// Email:           abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples (REMOVE in your code - unless Jane Doe helped you and you helped John Doe accordingly):
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordDetective {

    /**
     * Finds the specified set of words in the specified file and returns them
     * as an ArrayList.  This finds the specified set in the file which is on the 
     * line number of the set. The first line and set in the file is 1.
     * 
     * This returns an ArrayList with the keyword first, and then followed 
     * by the rest of the words in the set, space delimited.
     * Note: The String class indexOf method can be used to find the :. The keyword is
     * everything prior to the : and the keywords are space delimited after. 
     * 
     * An error message to System.out should be printed and an empty list returned
     * in the following cases:
     *    A set number is not found.
     *       "Error: set " + fileSetNumber + " not found."
     *    A set doesn't have the : after the keyword.
     *       "Error: colon (:) not found in set " + fileSetNumber + "."
     * 
     * Example file format:
     * about: about auto bat boat but out tab tub 
     * other: her hero hot other the toe 
     * their: her hire hit the their tie tier tire 
     * 
     * If the set number is 2 the returned ArrayList should contain:
     * [other, her, hero, hot, other, the, toe]
     * 
     * Hint: In order to read a specific line in the file, you can use a while loop.
     * In each iteration, read the next line and increment a counter, until reaching
     * the line number you want.
     *
     * @param filename The file containing word sets.
     * @param set  The number of the set, starting with 1.
     * @return The set of words, with the keyword first and later in the list.
     * @throws FileNotFoundException 
     */
	public static ArrayList<String> loadWordSet(String filename, int set) throws FileNotFoundException {
	    File setFile = new File(filename);
	    Scanner scnr = new Scanner(setFile);
	    int n = 0;
	    ArrayList<String> wordSet = new ArrayList<String>();
	    String line = "";
	    if (set < 1 || set > 50) {
	        System.out.println("Error: set " + set + " not found.");
	        scnr.close();
	        return wordSet;
	    }
	    while (n < set) {
	        line = scnr.nextLine();
	        n += 1;
	    }
	    scnr.close();
	    if(!line.contains(":")) {
	        System.out.println("Error: colon (:) not found in set " + set + ".");
	    }
	    line = line.replace(":", "");
	    String[] lineArray = line.split(" ");
	    for (n = 0; n < lineArray.length; ++n) {
	        wordSet.add(lineArray[n]);
	    }
	    return wordSet; //TODO
	}
	
    /**
     * Reorders the letters in word.  
     * 
     * Algorithm:
     * Copy the word into an array of characters.
     * Repeat 4 times:
     *     Randomly select 2 indexes in the word array using
     *         nextInt( word length) of the randGen parameter.
     *     Swap the letters at the selected indexes in the word array.
     * Create a string from the array of characters.
     * 
     * @param word The letters to be reordered.
     * @param randGen A random number generator.
     * @return The letters that have been randomly ordered.
     */
	public static String reorderLetters(String word, Random randGen) {
	    char[] wordArray = word.toCharArray();
	    int ind1 = randGen.nextInt(word.length());
	    int ind2 = randGen.nextInt(word.length());
	    char temp = wordArray[ind1];
	    wordArray[ind1] = wordArray[ind2];
	    wordArray[ind2] = temp;
	    for(int i = 0; i < 3; ++i) {
	        ind1 = randGen.nextInt(word.length());
	        ind2 = randGen.nextInt(word.length());
	        temp = wordArray[ind1];
	        wordArray[ind1] = wordArray[ind2];
	        wordArray[ind2] = temp;
	    }
        return String.valueOf(wordArray); //TODO
	}	
	
    /**
     * This returns a string containing the char ch, count times.  
     * For example calling with 'a', 5 would return:
     * "aaaaa"
     * 
     * @param ch  The character to repeat.
     * @param count The number of the character.
     * @return A string with count number of ch.
     */
	public static String charToString(char ch, int count) {
	    String charString = "";
	    for (int i = 0; i < count; ++i) {
	        charString += ch;
	    }
        return charString; //TODO
	}
	
    /**
     * Returns (does not print out) a string showing the words that have 
     * been guessed and dashes (-) for the letters of the words not yet guessed.
     * 
     * Example
     * wordSet: ago,  now,   own,  wagon
     * guessed: true, false, true, false
     * Returned string: "ago\n---\nown\n-----\n"
     *
     * Note: Do not duplicate code. Remember to call charToString.
     * 
     * @param wordSet The set of words to be guessed.
     * @param guessed Which words have been guessed.
     * @return A string showing the state of the guesses.
     */
	public static String show(ArrayList<String> wordSet, boolean[] guessed) {
	    String guesses = "";
	    for(int i = 0; i < wordSet.size(); ++i) {
	        if(guessed[i] == true) {
	            guesses = guesses.concat(wordSet.get(i) + "\n");
	        }
	        else {
	            guesses = guesses.concat(charToString('-', wordSet.get(i).length()) + "\n");
	        }
	    }
        return guesses; //TODO
	}

    /**
     * Picks the first unguessed word to show.
     * Updates the guessed array indicating the selected word is shown.
     * 
     * Example
     * wordSet: ago,  now,   own,  wagon
     * guessed: true, false, true, false
     * Returned string: "now"
     * guessed (after method call): true, true, true, false
     *
     * @param wordSet  The set of words.
     * @param guessed  Whether a word has been guessed.
     * @return The word to show or null if all have been guessed.
     */
	public static String pickWordToShow(ArrayList<String> wordSet, boolean []guessed) {
	    for (int i = 0; i < wordSet.size(); ++i) {
	        if (guessed[i] == false) {
	            guessed[i] = true;
	            return wordSet.get(i);
	        }
	    }
        return null; //TODO
	}
	
    /**
     * Looks for guess in wordSet. If found then updates the guessed array at the 
     * corresponding index to true. Returns whether the guess was found or not.
     * 
     * @param wordSet  The set of words.
     * @param guessed  The boolean array parallel with wordSet indicating if a word
     *         has been guessed or not.
     * @param guess  The word to look for in wordSet.
     * @return Whether the guess was found in the wordSet.
     */
	public static boolean wordMatches(ArrayList<String> wordSet, boolean []guessed, String guess) {
	    for (int i = 0; i < wordSet.size(); ++i ) {
	        if (guess.equals(wordSet.get(i))) {
	            guessed[i] = true;
	            return true;
	        }
	    }
        return false; //TODO
	}
	
    /**
     * Determines if the all the elements in the guessed array are true.
     * 
     * @param guessed Which words have been guessed.
     * @return true, if all the words have been guessed, false otherwise.
     */
	public static boolean wordSetComplete(boolean []guessed) {
	    for (int i = 0; i < guessed.length; ++i) {
	        if (guessed[i] == false)  {
	            return false;
	        }
	    }
        return true; //TODO
	}	
	
    /**
     * This is the main program loops, prompts for user input and prints to the 
     * console. For exact messages and output see the output examples in zyBooks.
     * 
     * Algorithm: 
     * Initialization and Welcome
     * Note: First wordSet is the 1st line in the file. The words sets are 
     * presented in the order in the file.
     * Game loop ("q" quits)
     *     Load the next word set (the first time use first set) from file "sets50.txt"
     *     If file not found quit with message "Error: unable to read from <filename>",
     *         with <filename> replaced with the filename.
     *     Remove the first word from the word set, that is the keyword.
     *     Reorder the letters of the keyword (reorderLetters)
     *     Create a boolean array, parallel to the word set, to indicate which words
     *         have been guessed and which have not.
     *     Word set loop (guessing all words or quitting exits)
     *         Print out the words that have been guessed and dashes for those that haven't (show).
     *         Prompt for input (s to show a word and q to quit), see example
     *         If "s" then pick word to show (pickWordToShow) and print "showing: " + word
     *         If "q" then quit
     *         Otherwise, check if word matches (wordMatches) or print "not in my list: " + word
     *         If all words are guessed (wordSetComplete) then print "Congratulations! ..." and
     *             increment word set, and word set loop is now complete.
     * When game loop complete (quit), then print "Thanks for playing Word Detective!" 
     *
     * @param args unused
     */
	public static void main(String[] args)  {
	    Scanner input = new Scanner(System.in);
	    Random randGen = new Random(876);
	    final String WORD_SET_FILE = "sets50.txt";
	    ArrayList<String> list = new ArrayList<String>();
	    String keyword = "";
	    String guess = "";
	    System.out.println("Welcome to Word Detective!");
	    for(int i = 1; i <= 50; ++i) {
	        System.out.println("Guess the words made from the letters.");
	        System.out.println("Options s:show, q:quit");
	        try {
	            list = loadWordSet(WORD_SET_FILE, i);
	        }
	        catch(FileNotFoundException e) {
	            System.out.println("Error: unable to read from " + WORD_SET_FILE);
	            break;
	        }
	        keyword = list.get(0);
	        list.remove(0);
	        keyword = reorderLetters(keyword, randGen);
	        boolean[] guessed = new boolean[list.size()];
	        System.out.print(show(list, guessed));
	        while (!wordSetComplete(guessed)) {
	            System.out.print(i + ") " + keyword + ": ");
	            guess = input.next();
	            if (guess.equals("q")) {
	                System.out.println("Thanks for playing Word Detective!");
	                return;
	            }
	            if (guess.equals("s")) {
	                System.out.println("showing: " + pickWordToShow(list, guessed));
	            }
	            else if (!wordMatches(list, guessed, guess)) {
	                System.out.println("Not in my list: " + guess);
	            }
	            if(wordSetComplete(guessed)) {
	                System.out.println("Congratulations! You guessed all the words!");
	            }
	            else {
	                System.out.print(show(list, guessed));
	            }
	        }
	    }
	    //see algorithm in method header ...
	    
	    
	    System.out.println("Thanks for playing Word Detective!");
	    input.close();
	}
}
