///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Test Cipher
// Course:          Comp Sci 200, Term 1, 2021
//
// Author:          August Bambenek
// Email:           abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Original Code by Jim Williams, Tiger Ji, and Juan Rios
// 
// Additions Made by: August Bambenek
// 
// 
// 
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.io.IOException;
import java.io.PrintWriter;

/**
 * This contains testing methods for the Cipher class.
 * @author Jim Williams
 * @author August Bambenek
 */
public class TestCipher {

    /**
     * This main method runs the selected tests.  Comment out a test if you don't want it to run.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        testGetKey();
        testCheckKey();
        testEncryptionAndDecryption();
    }

    /**
     * Tests the getKey method.
     */
    private static void testGetKey() {
        boolean error = false;


        {  //1 test that null is returned when the filename is null
            if(Cipher.getKey(null) != null) {
                System.out.println("testGetKey 1) Error, incorrect value returned for null");
                error = true;
            }
            else {
                System.out.println("Test 1 Passed!");
            }
        }
        
        {  //2 test that null is returned when the filename is ""
            if(Cipher.getKey("") != null) {
                System.out.println("testGetKey 2) Error, incorrect value returned for \"\"");
                error = true;
            }
            else {
                System.out.println("Test 2 Passed!");
            }
        }

        { //3 test that when trying to read a file that doesn't exist that null is returned.
            if(Cipher.getKey("fakeFile.txt") != null) {
                System.out.println("testGetKey 3) Error, incorrect value returned when "
                    + "file doesn't exist");
                error = true;
            }
            else {
                System.out.println("Test 3 Passed!");
            }
        }

        { //4 test that when trying to read a partial file that null is returned.
            String filename = "partialFile.txt";
            String fileContents = "cipher: ABCDEFGHIJKL;.&@^abc";
            writeFile(fileContents, filename);
            if(Cipher.getKey("partialFile.txt") != null) {
                System.out.println("testGetKey 4) Error, incorrect value returned when "
                    + "file is too short");
                error = true;
            }
            else {
                System.out.println("Test 4 Passed!");
            }
        }

        { //5 test that valid versions of the file name are accepted
            if(Cipher.getKey("key.txt") == null || Cipher.getKey("      KEY.txt") == null) {
                System.out.println("testGetKey 5) Error, file name isn't being read correctly");
                error = true;
            }
            else {
                System.out.println("Test 5 Passed!");
            }
        }

        { //6, 7 & 8 test that the plainKey and cipherKey are successfully read from a file using
            //the getKey method.

            //prepare the file to be read
            String filename = "testkey.txt";
            String cipherKey = "ABCDEFGHIJKL;.&@^abc";
            String plainKey = "abcdefghijkl:!$%^ABC";
            String fileContents = "cipher :" + cipherKey + "\nplain:" + plainKey + "\n";
            writeFile(fileContents, filename);

            //read the key and compare to the expected
            String[] expected = new String[2];
            expected[Cipher.PLAIN_INDEX] = plainKey;
            expected[Cipher.CIPHER_INDEX] = cipherKey;
            String[] actual = Cipher.getKey(filename);

            //6 check that actual and the two keys are not null
            if (actual == null || actual[Cipher.PLAIN_INDEX] == null || actual[Cipher.CIPHER_INDEX] == null) {
                error = true;
                System.out.println("testGetKey 6) Error, no part of the key should be null");
            }

            //7 check that the actual plain key matches the expected plain key
            if (!actual[Cipher.PLAIN_INDEX].equals(expected[Cipher.PLAIN_INDEX])) {
                error = true;
                System.out.println("testGetKey 7) Error, plain key doesn't match expected value!");
            }
            //8 check that the actual cipher key matches the expected cipher key
            if (!actual[Cipher.CIPHER_INDEX].equals(expected[Cipher.CIPHER_INDEX])) {
                error = true;
                System.out.println("testGetKey 8) Error, cipher key doesn't match expected value!");
            }
        }

        if (error) {
            System.out.println("testGetKey failed");
        } else {
            System.out.println("testGetKey passed");
        }
    }

    /*
      This is a supporting method for the testReadKey method.
     */
    static void writeFile(String fileContents, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.print(fileContents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the testCheckKey method handles all the cases described in its method header
     * comment.
     */
    private static void testCheckKey() {
        boolean error = false;

        { //1 test returns -1 if key is null.
            int actual = Cipher.checkKey(null);
            int expected = -1;
            if (actual != expected) {
                error = true;
                System.out.println("testCheckKey 1) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
        }

        { //2 test returns -1 if a string is null
            String[] key = new String[]{null, ""};
            int expected = -1;
            int actual = Cipher.checkKey(key);
            if (actual != expected) {
                error = true;
                System.out.println("testCheckKey 2) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
        }

        { //3 test returns -1 if other string is null
            String[] key = new String[]{"", null};
            int expected = -1;
            int actual = Cipher.checkKey(key);
            if (actual != expected) {
                error = true;
                System.out.println("testCheckKey 3) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
        }

        { //4 test returns -2 if the strings aren't the same length
            String[] key = new String[]{"abcdefgh", "ijk"};
            int expected = -2;
            int actual = Cipher.checkKey(key);
            if (actual != expected) {
                error = true;
                System.out.println("testCheckKey 4) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
        }

        { //5 test returns -3 if the characters in the plaintext string are not unique
            String[] key = new String[2];
            key[Cipher.CIPHER_INDEX] = "abcdefg";
            key[Cipher.PLAIN_INDEX] = "abcBefg";
            int expected = -3;
            int actual = Cipher.checkKey(key);
            if (actual != expected) {
                error = true;
                System.out.println("testCheckKey 5) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
        }

        { //6 test returns -4 if the characters in the ciphertext string are not unique
            String[] key = new String[2];
            key[Cipher.CIPHER_INDEX] = "abcCefg";
            key[Cipher.PLAIN_INDEX] = "abcdefg";
            int expected = -4;
            int actual = Cipher.checkKey(key);
            if (actual != expected) {
                error = true;
                System.out.println("testCheckKey 6) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
        }

        { //7 test returns 0 if the plaintext and ciphertext strings contain unique symbols and are
            // the same length.
            String[] key = new String[2];
            key[Cipher.CIPHER_INDEX] = "abcdefg";
            key[Cipher.PLAIN_INDEX] = "hijklmn";
            int expected = 0;
            int actual = Cipher.checkKey(key);
            if (actual != expected) {
                error = true;
                System.out.println("testCheckKey 7) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
        }

        if (error) {
            System.out.println("testCheckKey failed");
        } else {
            System.out.println("testCheckKey passed");
        }
    }


    /**
     * Tests the encrypt and decrypt methods which also rely on the findCipherSymbol and
     * findPlainSymbol methods.
     */
    private static void testEncryptionAndDecryption() {
        boolean error = false;

        { //1 test encrypt
            String[] key = new String[2];
            key[Cipher.PLAIN_INDEX] = "abcdehgfijklmnopqrstuvwxyz. :!-";
            key[Cipher.CIPHER_INDEX] = "dc!fghijklmpqrtnosuvwxyz. :e-ba";
            String plainMessage = "Z%abcdehgfijklmnopqrstuvwxyz. :!-"; //Z% and every symbol
            String expected = "Z%dc!fghijklmpqrtnosuvwxyz. :e-ba"; //Z% and every symbol
            String actual = Cipher.encrypt(key, plainMessage);
            if (!actual.equals(expected)) {
                error = true;
                System.out.println("testEncryptionAndDecryption 1) Error, expected: " + expected
                        + ", actual: " + actual);
            }
        }

        { //2 test decrypt
            String[] key = new String[2];
            key[Cipher.PLAIN_INDEX] = "abcdehgfijklmnopqrstuvwxyz. :!-";
            key[Cipher.CIPHER_INDEX] = "dc!fghijklmpqrtnosuvwxyz. :e-ba";
            String encryptedMessage = "dc!fghijklmpqrtnosuvwxyz. :e-ba$A"; //every symbol and $A
            String expected = "abcdehgfijklmnopqrstuvwxyz. :!-$A";  //every symbol and $A
            String actual = Cipher.decrypt(key, encryptedMessage);
            if (!actual.equals(expected)) {
                error = true;
                System.out.println("testEncryptionAndDecryption 2) Error, expected: " + expected
                        + ", actual: " + actual);
            }
        }

        if (error) {
            System.out.println("testEncryptionAndDecryption failed");
        } else {
            System.out.println("testEncryptionAndDecryption passed");
        }
    }
}
