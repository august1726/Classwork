//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    LinkedQueue
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
 * A generic implementation of a linked queue
 * 
 * @author August Bambenek
 * @param T - The type of data to be contained in the queue
 */
public class LinkedQueue<T> implements QueueADT<T> {
  private int n; //The number of elements in the queue
  protected Node<T> front; //The node at the front of the queue, added LEAST recently
  protected Node<T> back; //The node at the back of the queue, added MOST recently
  
  /**
   * Adds the given data to this queue; every addition to a queue is made at the back
   * 
   * @param data - the data to add
   */
  public void enqueue(T data) {
    if (n == 0) {
      front = new Node<T>(data);
      back = new Node<T>(data);
      n += 1;
      return;
    }
    
    Node<T> next = new Node<T>(data);
    back.setNext​(next);
    if (n == 1) {
      front.setNext​(next);
    }
    back = next;
    n += 1;
  }
  
  /**
   * Removes and returns the item from this queue that was least recently added
   * 
   * @return the item from this queue that was least recently added
   * @throws NoSuchElementException - if this queue is empty
   */
  public T dequeue() {
    if (n <= 0) {
      throw new NoSuchElementException("ERROR: Queue is empty");
    }
    if (n == 1) {
      T temp = front.getData();
      front = null;
      back = null;
      n -= 1;
      return temp;
    }
    T temp = front.getData();
    front = front.getNext();
    n -= 1;
    return temp;
  }
  
  /**
   * Returns the item least recently added to this queue without removing it
   * 
   * @return the item least recently added to this queue
   * @throws NoSuchElementException - if this queue is empty
   */
  public T peek() {
    if (n == 0) {
      throw new NoSuchElementException("ERROR: Queue is empty");
    }
    return front.getData();
  }
  
  /**
   * Checks whether the queue contains any elements
   * 
   * @return true if this queue is empty; false otherwise
   */
  public boolean isEmpty() {
    return n == 0;
  }
  
  /**
   * Returns the number of items in this queue
   * 
   * @return the number of items in this queue
   */
  public int size() {
    return n;
  }

  /**
   * Returns a string representation of this queue, beginning at the front (least recently added) 
   * of the queue and ending at the back (most recently added). An empty queue is represented as an 
   * empty string; otherwise items in the queue are represented using their data separated by spaces
   * 
   * @return the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {
    
    Node<T> temp = front;
    String str = "";
    while (temp != null) {
      str = str.concat(temp.getData().toString() + " ");
      temp = temp.getNext();
    }
    return str.trim();
  }
  
}
