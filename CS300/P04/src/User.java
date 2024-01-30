//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    User
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
// Persons:         (identify each by name and describe how they helped OR TYPE NONE)
// Online Sources:  (identify each by URL and describe how it helped OR TYPE NONE)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A user with a username and password; also can be set as an admin or not
 * 
 * @author August Bambenek
 */
public class User {
  
  private final String USERNAME;
  private String password;
  private boolean isAdmin;
  
  /**
   * Creates a new user with the given username, password, and admin status
   * 
   * @param username - a string that will be set as the new user's username
   * @param password - a string that will be set as the new user's password
   * @param isAdmin - a boolean that will set the user as an admin if it is true, and will set the 
   * user as a non-admin if it is false
   */
  public User(String username, String password, boolean isAdmin) {
    USERNAME = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  /**
   * Takes a string as input and checks to see if it matches the user's password
   * 
   * @param password - string passed in to see if it matches current user's password
   * @return returns true if password matches user's password, false if password doesn't match
   */
  public boolean isValidLogin(String password) {
    if (password.equals(this.password)) {
      return true;
    }
    return false;
  }

  /**
   * Returns the name of the user
   * 
   * @return returns a string that matches the user's username
   */
  public String getUsername() {
    return USERNAME;
  }

  /**
   * Checks whether or not the user is an admin
   * 
   * @return returns true if the user is an admin, returns false if the user is not an admin
   */
  public boolean getIsAdmin() {
    return this.isAdmin;
  }

  /**
   * Sets the user's password to the string passed in as input
   * 
   * @param password - a string that will be set to user's new password
   */
  public void setPassword(String password) {
    this.password = password;
  } 

  /**
   * Set's the user's admin status
   * 
   * @param isAdmin - true if the user should be set as admin, false if the user should set as a 
   * non-admin
   */
  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  } 

}
