//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    LinkedNode
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
 * An instance of this class represents a single node within a doubly linked list.
 * 
 * @author August Bambenek
 */
public class LinkedNode<T> {
  private T data; //data field of this linked node
  private LinkedNode<T> prev; //reference to the previous linked node in a list of nodes
  private LinkedNode<T> next; //reference to the next linked node in a list of nodes
  
  /**
   * Initializes a new node with the provided information.
   * 
   * @param prev - node, which comes before this node in a doubly linked list
   * @param data - to be stored within this node
   * @param next - node, which comes after this node in a doubly linked list
   * @throws IllegalArgumentException with a descriptive error message if data is null
   */
  public LinkedNode(LinkedNode<T> prev, T data, LinkedNode<T> next) {
    if (data == null) {
      throw new IllegalArgumentException("ERROR: data field passed as input is null");
    }
    this.data = data;
    this.prev = prev;
    this.next = next;
  }
  
  /**
   * Accessor method for this node's previous node reference.
   * 
   * @return the reference to the node that comes before this one in the list or null when this is 
   * the first node in that list
   */
  public LinkedNode<T> getPrev() {
    return this.prev;
  }
  
  /**
   * Mutator method for this node's previous node reference.
   * 
   * @param prev - node, which comes before this node in a doubly linked list
   */
  public void setPrev​(LinkedNode<T> prev) {
    this.prev = prev;
  }
  
  /**
   * Accessor method for this node's next node reference.
   * 
   * @return the next reference to the node that comes after this one in the list, or null when 
   * this is the last node in that list
   */
  public LinkedNode<T> getNext() {
    return this.next;
  }
  
  /**
   * Mutator method for this node's next node reference.
   * 
   * @param next - node, which comes after this node in a doubly linked list
   */
  public void setNext​(LinkedNode<T> next) {
    this.next = next;
  }
  
  /**
   * Accessor method for this node's data.
   * 
   * @return the data stored within this node.
   */
  public T getData() {
    return this.data;
  }
  
}
