//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Clickable Interface
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

public interface Clickable {
  public void draw(); // draws this Clickable object to the screen
  public void mousePressed(); // defines the behavior of this Clickable object
  // each time the mouse is pressed
  public void mouseReleased(); // defines the behavior of this Clickable object
  // each time the mouse is released
  public boolean isMouseOver(); // returns true if the mouse is over this clickable object
}
