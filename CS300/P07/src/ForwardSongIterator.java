//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ForwardSongIterator
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterator to play songs in the forward direction from a doubly linked list 
 * of songs
 * 
 * @author August Bambenek
 */
public class ForwardSongIterator implements Iterator<Song>{
  private LinkedNode<Song> next; //reference to the next linked node in a list of nodes.
  
  /**
   * Creates a new iterator which iterates through songs in front/head to back/tail order
   * 
   * @param first - reference to the head of a doubly linked list of songs
   */
  public ForwardSongIterator(LinkedNode<Song> first) {
    next = first;
  }
  
  /**
   * Checks whether there are more songs to return
   * 
   * @return true if there are more songs to return
   */
  public boolean hasNext() {
    return next != null;
  }
  
  /**
   * Returns the next song in the iteration
   * 
   * @return the next song in the iteration
   * @throws NoSuchElementException - with a descriptive error message if there are no more songs 
   * to return in the forward order (meaning if this.hasNext() returns false)
   */
  public Song next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException("ERROR: no next song");
    }
    Song temp = next.getData();
    next = next.getNext();
    return temp;
  }
  
}
