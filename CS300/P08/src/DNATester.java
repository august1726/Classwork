//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    DNA Tester
// Course:   CS 300 Spring 2022
//
// Author:   August Bambenek
// Email:    abambenek@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * Test methods to verify your implementation of the methods for P08.
 */
public class DNATester {
  
  /**
   * Tests the LinkedQueue class
   * @return true if and only if the class works correctly
   */
  public static boolean testLinkedQueue() {
    LinkedQueue<Integer> num = new LinkedQueue<Integer>();
    try {
      num.dequeue();
      return false;
    } catch(NoSuchElementException e) {
      
    }
    num.enqueue(1);
    num.enqueue(2);
    num.enqueue(3);
    if (num.size() != 3) {
      return false;
    }
    if (!num.toString().equals("1 2 3")) {
      return false;
    }
    if (num.dequeue() != 1) {
      return false;
    }
    num.dequeue();
    num.dequeue();
    if (!num.isEmpty()) {
      return false;
    }
    try {
      num.peek();
      return false;
    } catch(NoSuchElementException e) {
      
    }
    return true;
  }
  
  /**
   * Tests the transcribeDNA() method
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    System.out.println(testDNA.transcribeDNA().toString());
    if (testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
      return true;
    }
    System.out.println(mRNA.length());
    System.out.println(testDNA.transcribeDNA().toString().length());
    return false;
  }
  
  /**
   * Tests the translateDNA() method
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    System.out.println(testDNA.translateDNA().toString());
    if (testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {
      return true;
    }
    return false;
  }

  /**
   * Tests the mRNATranslate() method
   * @return true if and only if the method works correctly
   */
  public static boolean testMRNATranslate() {
    DNA testmRNA = new DNA("GGCCGGGAGGCCACCUAGGUU");
    String str = "GGCCGGGAGGCCACCUAGGUU";
    LinkedQueue<Character> mRNA = new LinkedQueue<Character>();
    for (int i = 0; i < str.length(); i++) {
      mRNA.enqueue(str.charAt(i));
    }
    if (testmRNA.mRNATranslate​(mRNA).toString().replaceAll(" ", "").equals("GREAT")) {
      return true;
    }
    return false;
  }
  
  /**
   * Tests the size() method in LinkedQueue
   * @return true if and only if the method works correctly
   */
  public static boolean testQueueSize() {
    LinkedQueue<Integer> num = new LinkedQueue<Integer>();
    try {
      if (num.size() != 0) {
        return false;
      }
      num.enqueue(1);
      num.enqueue(2);
      num.enqueue(3);
      if (num.size() != 3) {
        return false;
      }
      num.dequeue();
      if (num.size() != 2) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }
  
  /**
   * Tests the enqueue() and dequeue() methods in LinkedQueue
   * @return true if and only if the method works correctly
   */
  public static boolean testEnqueueDequeue() {
    LinkedQueue<Integer> num = new LinkedQueue<Integer>();
    try {
      num.dequeue();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      num.enqueue(1);
      num.enqueue(2);
      num.enqueue(3);
      num.enqueue(4);
      if (num.dequeue() != 1) {
        return false;
      }
      if (num.dequeue() != 2) {
        return false;
      }
      if (num.dequeue() != 3) {
        return false;
      }
      if (num.dequeue() != 4) {
        return false;
      }
      if (!num.isEmpty()) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    
    return true;
  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("transcribeDNA: "+testTranscribeDNA());
    System.out.println("translateDNA: "+testTranslateDNA());
    System.out.println("testLinkedQueue(): " + testLinkedQueue());
    System.out.println("testMRNATranslate(): " + testMRNATranslate());
    System.out.println("testQueueSize(): " + testQueueSize());
    System.out.println("testEnqueueDequeue(): " + testEnqueueDequeue());
  }

}
