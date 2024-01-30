//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Access Control
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
import java.util.NoSuchElementException;

/**
 * An access control system of users
 * 
 * @author August Bambenek
 */
public class AccessControl {
  private static ArrayList<User> users;
  private User currentUser;
  private static final String DEFAULT_PASSWORD = "changeme";
  
  /**
   * No-argument constructor for AccessControl class, initializes the static and instance variables
   */
  public AccessControl() {
    if (users == null) {
      users = new ArrayList<User>();
      users.add(new User("admin", "root", true));
    }
    currentUser = null;
  } // A no-argument constructor

  /**
   * Checks whether or not the username and password pair are a valid login pair in the 
   * users ArrayList
   * 
   * @param username - string that represents a user's username
   * @param password - string that represents a user's password (should go with passed in username)
   * @return returns true if it is a valid username and password pair, returns false if username not
   * found or if password doesn't match username
   */
  public static boolean isValidLogin(String username, String password) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        if (users.get(i).isValidLogin(password)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Changes the current user's password
   * 
   * @param newPassword - the new password for the current user
   */
  public void changePassword(String newPassword) {
    currentUser.setPassword(newPassword);
  }

  /**
   * Logs out the current user (sets currentUser to null)
   */
  public void logout() {
    currentUser = null;
  }

  /**
   * A mutator that you can use to write tests without simulating user input. 
   * It sets the current user to the user from the users list whose username matches the string 
   * provided as input to the method (exact match case sensitive).
   * 
   * @param username - the username of the user to be set as current user
   */
  public void setCurrentUser(String username) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        currentUser = users.get(i);
        return;
      }
    }
  }

  /**
   * Create a new user with the default password and isAdmin==false and add it to the users 
   * ArrayList.
   * 
   * @param username - the username of the user to be added
   * @throws IllegalArgumentException with descriptive error message if usernae is null or if its 
   * length is less than 5 (< 5), or if a user with the same username is already in the list of 
   * users (usernames must be unique)
   * @return returns true if the current user has admin power and the new user was successfully 
   * added. Returns false if the current user is null or does not have admin power
   */
  public boolean addUser(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    if (username == null || username.length() < 5) {
      throw new IllegalArgumentException("ERROR: username was null or less than 5 characters");
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        throw new IllegalArgumentException("ERROR: username taken");
      }
    }
    users.add(new User(username, DEFAULT_PASSWORD, false));
    return true;
  }

  /**
   * Create a new user, specify their admin status, and add it to the list of users.
   * 
   * @param username - the username of the user to be added
   * @param isAdmin - the users admin status (true if admin, false if non-admin)
   * @throws IllegalArgumentException with descriptive error message if usernae is null or if its 
   * length is less than 5 (< 5), or if a user with the same username is already in the list of 
   * users (usernames must be unique)
   * @return returns true if the current user has admin power and the new user was successfully 
   * added. Returns false if the current user is null or does not have admin power
   */
  public boolean addUser(String username, boolean isAdmin) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    if (username == null || username.length() < 5) {
      throw new IllegalArgumentException("ERROR: username was null or less than 5 characters");
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        throw new IllegalArgumentException("ERROR: username taken");
      }
    }
    users.add(new User(username, DEFAULT_PASSWORD, isAdmin));
    return true;
  }
  
  /**
   * Remove a user given their unique username
   * 
   * @param username - username of the user to be removed from the list of users
   * @throws NoSuchElementException with a descriptive error message if no match with username is 
   * found in the list of users
   * @return returns true is the current user has admin powers and the user whose username is passed
   *  as input was successfully removes returns false if the current user is null or does not have 
   *  admin power
   */
  public boolean removeUser(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.remove(i);
        return true;
      }
      if (i == users.size() - 1) {
        throw new NoSuchElementException("ERROR: user not found");
      }
    }
    return false;
  }

  /**
   * Give a user admin power
   * 
   * @param username - the username of the user to be given admin powers
   * @throws NoSuchElementException with a descriptive error message if no match with username is 
   * found in the list of users
   * @return returns true if this operation terminates successfully, returns false if the current 
   * user is null or does not have admin powers
   */
  public boolean giveAdmin(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setIsAdmin(true);
        return true;
      }
      if (i == users.size() - 1) {
        throw new NoSuchElementException("ERROR: user not found");
      }
    }
    return false;
  }
  
  /**
   * Removes a users admin powers
   * 
   * @param username - the username of the user to remove admin powers from
   * @throws NoSuchElementException with a descriptive error message if no match with username is 
   * found in the list of users
   * @return returns true if this operation terminates successfully, returns false if the current 
   * user is null or does not have admin powers
   */
  public boolean takeAdmin(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setIsAdmin(false);
        return true;
      }
      if (i == users.size() - 1) {
        throw new NoSuchElementException("ERROR: user not found");
      }
    }
    return false;
  }

  /**
   * Reset the password of a user given their username
   * 
   * @param username - username of the user to reset the password for
   * @throws NoSuchElementException with a descriptive error message if no match with username is 
   * found in the list of users
   * @return retirns true if this operation terminates successfully, returns false if the current 
   * user is null or does not have admin powers
   */
  public boolean resetPassword(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setPassword(DEFAULT_PASSWORD);
        return true;
      }
      if (i == users.size() - 1) {
        throw new NoSuchElementException("ERROR: user not found");
      }
    }
    return false;
  } 

  /**
   * main method
   * 
   * @param args - unused
   */
  public static void main(String[] args) {

  }

}
