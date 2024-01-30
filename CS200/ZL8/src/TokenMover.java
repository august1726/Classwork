///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           August Bambenek
// Course:          Comp Sci 200, term 1, and 2021
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

public class TokenMover {
   /** 
    * This method returns the index of the first instance of the delimiter,
    * or -1 if it is not found.
    * 
    * Example: delimiter ',' and input "one,two,three".toCharArray() should
    * return 3.
    * 
    * @param   delimiter  a character to split the string with
    * @param   input      a character array
    * @return  int        the index of the first occurence of the delimiter
    */
   public static int firstDelimiterIndex(char delimiter, char[] input) {
      for (int i = 0; i < input.length; ++i) {
          if (input[i] == delimiter) {
              return i;
          }
      }
      return -1;
   }

   /** 
    * Reorder char[] input by moving the first token to the end of the array.
    * This method should return the array after modifying it. Hint:
    * use firstDelimiterIndex() to find the index of the array you need to be
    * considering.
    * 
    * Example: delimiter ',' and input "one,two,three".toCharArray() should
    * return "two,three,one"
    * 
    * @param   delimiter     a character to split the string with
    * @param   input         a character array
    * @return  char[] input  the modified character array
    */
   
   public static char[] moveFirstToken(char delimiter, char[] input) {
       if (firstDelimiterIndex(delimiter, input) > -1) {
           String str = "";
           for (int i = firstDelimiterIndex(delimiter, input) + 1; i < input.length; ++i) {
               str += input[i];
           }
           str += delimiter;
           for (int i = 0; i < firstDelimiterIndex(delimiter, input); ++i) {
               str += input[i];
           }
           return str.toCharArray();
       }
       else {
           return input;
       }
   }

   /** 
    * The main method. Tests for moveFirstToken() should go here.
    * 
    * @param   args      
    * @return  void
    */
   public static void main(String[] args) {
      String s1 = "a,comma,separated,list";
      String s2 = "hhhhhhhhhh jjjjj iiiiii lllll";
      String s3 = "one&two&three&four&five";
      System.out.println("Expected: comma,separated,list,a");
      System.out.print("Actual: ");
      System.out.println(moveFirstToken(',', s1.toCharArray()));

      System.out.println(moveFirstToken(' ', s2.toCharArray()));
      System.out.println(moveFirstToken('&', s3.toCharArray()));
   }
}
