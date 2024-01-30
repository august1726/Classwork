//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Access Control Tester
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

import java.util.ArrayList;

/**
 * A series of test methods for the User() class and the AccessControl() class
 * 
 * @author August Bambenek
 */
public class AccessControlTester {
  
  /**
   * Runs all test methods
   * 
   * @return returns true if all test pass, returns false if a test fails
   */
  public static boolean runAllTests(){
    if (!testUserConstructorAndMethods() || !testAccessControlIsValidLoginNotValidUser() || 
        !testAddUserWithNoAdminPowers() || !testAddRemoveUserWithAdminPowers()) {
      return false;
    }
    return true;
  }

  /**
   * Tests the User() contructor and all of its methods
   * 
   * @return returns true if all tests pass, returns false if a test fails
   */
  public static boolean testUserConstructorAndMethods() {
    User testUser = new User("test", "test", false);
    if(!testUser.isValidLogin("test") || !testUser.getUsername().equals("test") || 
        testUser.getIsAdmin()) {
      return false;
    }
    testUser.setIsAdmin(true);
    testUser.setPassword("reset");
    if(!testUser.isValidLogin("reset") || !testUser.getIsAdmin()) {
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of AccessControl.isValidLogin() method when 
   * called with incorrect username or not matching (username, password) pair
   * 
   * @return returns true if the test passes, returns false if the test fails.
   */
  public static boolean testAccessControlIsValidLoginNotValidUser() {
    AccessControl test = new AccessControl();
    if(AccessControl.isValidLogin("abcdefg", "hijklmn")) {
      return false;
    }
    if(AccessControl.isValidLogin("admin", "wrongPassword")) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new AccessControl object and does not log in an admin, then tries to add a new user
   * 
   * @return returns true if the test passes, returns false if the isValidLogin doesn't return false
   *  or if the user was added to the list of users
   */
  public static boolean testAddUserWithNoAdminPowers() {
    AccessControl test = new AccessControl();
    if(test.addUser("steven")) {
      return false;
    }
    if(AccessControl.isValidLogin("steven", "changeme")) {
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of addUser and removeUser methods when the current user has admin powers
   * 
   * @return returns true if test passes, returns false if test fails
   */
  public static boolean testAddRemoveUserWithAdminPowers() {
    AccessControl testAdmin = new AccessControl();
    testAdmin.setCurrentUser("admin");
    if(!testAdmin.addUser("jeremy")) {
      return false;
    }
    if(!AccessControl.isValidLogin("jeremy", "changeme")) {
      return false;
    }
    if(!testAdmin.removeUser("jeremy")) {
      return false;
    }
    if(AccessControl.isValidLogin("jeremy", "changeme")) {
      return false;
    }
    testAdmin.logout();
    return true;
  }

  /**
   * main method
   * 
   * @param args - unused
   */
  public static void main(String[] args) {
    System.out.print(runAllTests());
  }

}
