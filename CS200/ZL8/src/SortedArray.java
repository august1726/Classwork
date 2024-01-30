///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Array Sorted Test
// Course:          Comp Sci 200, Term 1, 2021
//
// Author:          August Bambenek
// Email:           abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
public class SortedArray {
   
   public static boolean inOrder(int [] nums) {
      /* Type your code here. */   
       for (int i = 0; i < nums.length - 1; ++i) {
           if (nums[i] > nums[i + 1]) {
               return false;
           }
       }
       return true;
   }
   
   public static void main(String[] args) {
      
      // Test out-of-order example.
      int [] nums1 = {5, 6, 7, 8, 3};
      
      if(inOrder(nums1)){
         System.out.println("In order");
      }else{
         System.out.println("Not in order");
      }
      
      // Test in-order example.
      int [] nums2 = {5, 6, 7, 8, 10};
      
      if(inOrder(nums2)){
         System.out.println("In order");
      }else{
         System.out.println("Not in order");
      }
   }
}
