//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Open Position Tester
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
 * This class implements unit test methods to check the correctness of Application,
 * ApplicationIterator, ApplicationQueue and OpenPosition classes in the assignment.
 *
 * @author August Bambenek
 */
public class OpenPositionTester {

  /**
   * This method tests and makes use of the Application constructor, getter methods, toString() and
   * compareTo() methods.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testApplication() {
    // create an Application with valid input
    try {
      Application test = new Application("Jim", "jim@office.com", 100);
    } catch (Exception e) {
      return false;
    }
    // create an Application with invalid input:
    // blank name
    try {
      Application test1 = new Application("", "john@office.com", 100);
      return false;
    } catch (IllegalArgumentException e) {

    }
    // null email
    try {
      Application test1 = new Application("James", null, 100);
      return false;
    } catch (IllegalArgumentException e) {

    }
    // no @ email
    try {
      Application test1 = new Application("Jack", "jackoffice.com", 100);
      return false;
    } catch (IllegalArgumentException e) {

    }
    // too many @ email
    try {
      Application test1 = new Application("Jane", "jane@@office.com", 100);
      return false;
    } catch (IllegalArgumentException e) {

    }
    // invalid score
    try {
      Application test1 = new Application("Jorge", "jorge@office.com", 101);
      return false;
    } catch (IllegalArgumentException e) {

    }
    // verify getters
    Application test = new Application("Jay", "jay@office.com", 56);
    if (!test.getEmail().equals("jay@office.com")) {
      return false;
    }
    if (!test.getName().equals("Jay")) {
      return false;
    }
    if (test.getScore() != 56) {
      return false;
    }
    // verify compareTo
    Application test2 = new Application("Juan", "juan@office.com", 27);
    Application test3 = new Application("Jacob", "jacob@office.com", 27);
    // verify toString
    if (test2.compareTo(test) >= 0) {
      return false;
    }
    if (test.compareTo(test3) <= 0) {
      return false;
    }
    if (test2.compareTo(test3) != 0) {
      return false;
    }
    return true;
  }

  /**
   * This method tests and makes use of the ApplicationIterator class.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testApplicationIterator() {
    // create an ApplicationQueue with capacity at least 3
    // and at least 3 Applications with different scores
    ApplicationQueue queue = new ApplicationQueue(3);
    Application app1 = new Application("Doug", "doug@website.com", 100);
    Application app2 = new Application("Dean", "dean@website.com", 75);
    Application app3 = new Application("Diane", "diane@website.com", 10);
    // add those Applications to the queue
    queue.enqueue(app1);
    queue.enqueue(app2);
    queue.enqueue(app3);
    // verify that iterating through the queue gives you the applications in order of
    // INCREASING score
    ApplicationIterator iter = (ApplicationIterator) queue.iterator();
    if (!iter.hasNext()) {
      return false;
    }
    if (iter.next().getScore() != 10) {
      return false;
    }
    if (iter.next().getScore() != 75) {
      return false;
    }
    if (iter.next().getScore() != 100) {
      return false;
    }
    if (iter.hasNext()) {
      return false;
    }
    try {
      iter.next();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * This method tests and makes use of the enqueue() and dequeue() methods in the ApplicationQueue
   * class.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testEnqueueDequeue() {

    // enqueue an invalid value (null)
    try {
      ApplicationQueue queue = new ApplicationQueue(3);
      queue.enqueue(null);
      return false;
    } catch (NullPointerException e) {

    } catch (Exception e) {
      return false;
    }

    // create an ApplicationQueue with capacity 3
    // and at least 4 Applications with different scores

    ApplicationQueue queue = new ApplicationQueue(3);
    Application app1 = new Application("Phillip", "phil@phil.com", 95);
    Application app2 = new Application("Paul", "paul@paul.com", 66);
    Application app3 = new Application("Perry", "perry@perry.com", 39);
    Application app4 = new Application("Phoebe", "phoebe@phoebe.com", 87);
    // enqueue one valid application
    queue.enqueue(app1);
    // enqueue two more valid applications
    queue.enqueue(app2);
    queue.enqueue(app3);
    // enqueue one more application (exceeds capacity)
    try {
      queue.enqueue(app4);
      return false;
    } catch (IllegalStateException e) {

    }
    // dequeue one application (should be lowest score)
    try {
      if (!queue.dequeue().equals(app3)) {
        return false;
      }
      // dequeue all applications
      if (!queue.dequeue().equals(app2)) {
        return false;
      }
      if (!queue.dequeue().equals(app1)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    // dequeue from an empty queue
    try {
      ApplicationQueue queue1 = new ApplicationQueue(3);
      queue1.dequeue();
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      return false;
    }

    return true;
  }

  /**
   * This method tests and makes use of the common methods (isEmpty(), size(), peek()) in the
   * ApplicationQueue class.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testCommonMethods() {
    // create an ApplicationQueue with 0 capacity (should fail)
    try {
      ApplicationQueue queue = new ApplicationQueue(0);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    try {
      // create an ApplicationQueue with capacity 3
      // and at least 3 Applications with different scores
      ApplicationQueue queue = new ApplicationQueue(3);
      Application app1 = new Application("Evan", "evan@company.com", 55);
      Application app2 = new Application("Eve", "eve@company.com", 75);
      Application app3 = new Application("Evangeline", "evangeline@company.com", 90);
      // verify the methods' behaviors on an empty queue
      if (queue.size() != 0 || !queue.isEmpty()) {
        return false;
      }
      // add one Application and verify the methods' behaviors
      queue.enqueue(app3);
      if (queue.size() != 1 || queue.isEmpty() || !queue.peek().equals(app3)) {
        return false;
      }
      // add the rest of the Applications and verify the methods' behaviors
      queue.enqueue(app1);
      if (queue.size() != 2 || queue.isEmpty() || !queue.peek().equals(app1)) {
        return false;
      }
      queue.enqueue(app2);
      if (queue.size() != 3 || queue.isEmpty() || !queue.peek().equals(app1)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * This method tests and makes use of OpenPosition class.
   * 
   * @return true when this test verifies the functionality, and false otherwise
   */
  public static boolean testOpenPosition() {
    // create an OpenPosition with 0 capacity (should fail)
    try {
      OpenPosition position = new OpenPosition("test", 0);
      return false;
    } catch (IllegalArgumentException e) {

    } catch (Exception e) {
      return false;
    }
    // create an OpenPosition with capacity 3
    // and at least 5 Applications with different scores
    try {
      OpenPosition position = new OpenPosition("test", 3);
      Application app1 = new Application("Brian", "brian@org.org", 80);
      Application app2 = new Application("Benjamin", "benjamin@org.org", 76);
      Application app3 = new Application("Bob", "bob@org.org", 67);
      Application app4 = new Application("Billy", "billy@org.org", 23);
      Application app5 = new Application("Bart", "bart@org.org", 9);
      // verify that the 3 MIDDLE-scoring Applications can be added
      // don't use the highest and lowest scoring applications YET
      if (!position.add(app2)) {
        return false;
      }
      if (!position.add(app3)) {
        return false;
      }
      if (!position.add(app4)) {
        return false;
      }
      // verify that getApplications returns the correct value for your input
      if (!position.getApplications().contains(
          "Billy:billy@org.org:23\nBob:bob@org.org:67\n" + "Benjamin:benjamin@org.org:76")) {
        return false;
      }
      // verify that the result of getTotalScore is the sum of all 3 Application scores
      if (position.getTotalScore() != 166) {
        return false;
      }
      // verify that the lowest-scoring application is NOT added to the OpenPosition
      if (position.add(app5)) {
        return false;
      }
      if (position.getTotalScore() != 166) {
        return false;
      }
      // verify that the highest-scoring application IS added to the OpenPosition
      if (!position.add(app1)) {
        return false;
      }
      // verify that getApplications has changed correctly
      if (!position.getApplications().contains(
          "Bob:bob@org.org:67\nBenjamin:benjamin@org.org:76" + "\nBrian:brian@org.org:80")) {
        return false;
      }
      // verify that the result of getTotalScore has changed correctly
      if (position.getTotalScore() != 223) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true; 
  }

  /**
   * This method calls all the test methods defined and implemented in your OpenPositionTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    return testApplication() && testApplicationIterator() && testEnqueueDequeue()
        && testCommonMethods() && testOpenPosition();
  }

  /**
   * Driver method defined in this OpenPositionTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println("testApplication(): " + testApplication());
    System.out.println("testEnqueueDequeue(): " + testEnqueueDequeue());
    System.out.println("testCommonMethods(): " + testCommonMethods());
    System.out.println("testApplicationIterator(): " + testApplicationIterator());
    System.out.println("testOpenPosition(): " + testOpenPosition());
    System.out.println("runAllTests(): " + runAllTests());
  }
}
