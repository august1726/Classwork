//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Room
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

/**
 * Contains data for a school classroom
 * 
 * @author August Bambenek
 */
public class Room {
  private String location; //the building and room number, e.g. “Noland 168"
  private int capacity; //the maximum number of people who can be in the room at a time
  
  /**
   * initializes the data fields to the values of the arguments.
   * 
   * @param location - the name of the building and room number
   * @param capacity - the max number of people who can fit in this room
   * @throws IllegalArgumentException with a descriptive error message if the provided integer is 
   * negative (<0)
   */
  public Room(String location, int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("ERROR: capacity can't be less than zero");
    }
    this.location = location;
    this.capacity = capacity;
  }
  
  /**
   * returns the location of this room
   * 
   * @return returns the location of this room
   */
  public String getLocation() {
    return this.location;
  }
  
  /**
   * returns the capacity of this room
   * 
   * @return returns the capacity of this room
   */
  public int getCapacity() {
    return this.capacity;
  }
  
  /**
   * Returns a new Room object with the same location as this one, but with a capacity less than 
   * this one’s by the argument’s amount. For example, if Room r has a capacity of 10, calling 
   * r.reduceCapacity(3) will return a new Room object with the same location as r but a capacity 
   * of 7.
   * 
   * @param decrement - integer amount to decrease the capacity of the room by
   * @throws IllegalArgumentException with a descriptive error message If the argument is greater 
   * than the given Room’s capacity
   * @return Returns a new Room object with the same location but a decreased capacity
   */
  public Room reduceCapacity(int decrement) {
    if (decrement > this.capacity) {
      throw new IllegalArgumentException("ERROR: decrement amount can't be greater than capacity");
    }
    return new Room(this.location, this.capacity - decrement);
  }

}
