///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: August bambenek
// Campus ID:9083041492
// WiscEmail:abambenek@wisc.edu
//                             (TODO: fill this out)
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//
// This file contains TWO classes named ServingQueue and ServingQueueIterator. 
// You will need to complete the implementation of these two classes with 
// respect to the provided requirements in the TODO tags for full credit.
//
// When creating new exception objects, including messages within these objects
// is optional.
//
// You are NOT allowed to add any data field to the provided classes
// You are NOT allowed to add any protected or public methods to the provided 
// classes.
////////////////////////////////////////////////////////////////////////////////

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements an array-based circular indexing queue to serve guests in their order of
 * arrival to a round table.
 *
 */
public class ServingQueue {
  private String[] guests; // array storing names of guests
  private int size; // size of the serving queue
  private int head; // index of the head of the queue
  private int tail; // index of the tail of the queue

  /**
   * Creates a new array based queue with a given capacity of guests. This queue should be
   * initialized to be empty (initially, size must be zero, head and tail must be -1). We assume that
   * capacity is greater than zero.
   * 
   * @param capacity the size of the array holding this queue data
   */
  public ServingQueue(int capacity) {
    // TODO #1: initialize all the data fields defined in the ServingQueue class
    guests = new String[capacity];
    size = 0;

  }

  /**
   * Checks whether there are any guests in this serving queue.
   * 
   * @return true when this queue contains zero guests, and false otherwise.
   */
  public boolean isEmpty() {
    // TODO #2: implement this method
    
    return size == 0;
  }

  /**
   * Gets the number of guests in this queue (to be served)
   * 
   * @return the size of this queue
   */
  public int size() {
    // TODO #3: implement this method
    
    return size; // default return statement added to avoid compiler errors. Feel free to change it.
  }

  /**
   * Gets the capacity of this queue (the maximum number of available seats at table)
   * 
   * @return the capacity of this queue
   */
  public int capacity() {
    // TODO #4: implement this method

    return guests.length; 
  }

  /**
   * Adds a single new guest to this queue (to be served after the others that were previously added
   * to the queue).
   * 
   * @param newGuest is the guest that is being added to this queue.
   * @throws IllegalStateException when called on a ServingQueue with an array that is full
   */
  public void add(String newGuest) {
    // TODO
    // #5: Throw an IllegalStateException if add was called on a full ServingQueue
    if (size >= guests.length) {
      throw new IllegalStateException("ERROR: queue is full");
    }

    // #6. Increment tail by one (Recall that guests is a circular indexing array!)
    if (tail == guests.length - 1) {
      tail = 0;
    } else {
      tail = tail % guests.length + 1;
    }
    // #7: Add newGuest to the tail of the queue and increment size
    guests[tail] = newGuest;
    size += 1;
    // adjust head if newGuest was added to an empty queue - No further action required
    if (size == 1)
      head = tail;
  }

  /**
   * Accessor for the guest that has been in this queue for the longest. This method does not add or
   * remove any guests.
   * 
   * @return a reference to the guest that has been in this queue the longest.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public String peek() {
    if (isEmpty())
      throw new IllegalStateException("Cannot peek on an empty ServingQueue.");
    // TODO #8: return the guest who has been in the queue for the longest
    

    return guests[head]; 
  }

//MAKE SURE TO SAVE your source file before uploading it to gradescope.
  
// ServingQueue.get(int) and ServingQueue.toString() are completely provided to you.
// DO NOT CHANGE THE IMPLEMENTATION OF get(int) and toString() methods.
  
  /**
   * Returns the element at a given index of the guests table
   * @param index given index
   * @return the element at a given index of the guests table
   * @throws ArrayIndexOutOfBoundsException if index is out of bounds of the guests table
   */
  public String get(int index) {
    return guests[index];
  }
  
  /**
   * The string representation of the guests in this queue should display each of the guests in this
   * queue separated by a single space.
   * 
   * @return string representation of the ordered guests in this queue starting from the head
   */
  @Override
  public String toString() {
    String s = "";
    int i = 0;
    while (i < size) {
      s += guests[(head + i) % guests.length] + " ";
      i++;
    }
    return s.trim();
  }

  /**
   * Checks the correctness of isEmpty, size and peek methods when called on an empty queue Note
   * that a tester method should not throw any exception. It must return by true or false.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testEmptyQueue() {
    // TODO
    // #9: Create an empty ServingQueue object with valid capacity
    ServingQueue test = new ServingQueue(10);
    // #10: This tester must return false if any of the following properties is not satisfied.
    
    // A newly created serving queue must be empty and its size must be zero
    if (!test.isEmpty() || test.size() != 0) {
      return false;
    }
    // An IllegalStateException must be thrown when peek() is called on an empty queue
    try {
      test.peek();
    } catch (IllegalStateException e) {
      
    } catch (Exception e) {
      return false;
    }
    // No other kind of exception should be thrown.

    // This tester should return true if no bugs is detected
    
    return true; // default return statement added to avoid compiler errors. Feel free to change it.
  }

//MAKE SURE TO SAVE your source file before uploading it to gradescope.
  
  /**
   * Checks the correctness of ServingQueue.add(String) method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAdd() {
    try {
      ServingQueue queue = new ServingQueue(4);
      // check capacity()
      if (queue.capacity() != 4)
        return false;

      // add to an empty queue
      queue.add("Ashley");
      if (queue.isEmpty() || queue.size() != 1 || !queue.peek().equals("Ashley")) {
        return false;
      }
      if (!queue.toString().equals("Ashley"))
        return false;

      // add to a non empty queue when head == 0
      queue.add("Michelle");
      if (queue.isEmpty() || queue.size() != 2 || !queue.peek().equals("Ashley")) {
        return false;
      }
      if (!queue.toString().equals("Ashley Michelle"))
        return false;

      // add add to a non empty queue when head is at any position of the queue
      String[] guests = new String[] {null, "Ashley", "Michelle", "Mouna"};
      queue.size = 3;
      queue.guests = guests;
      queue.head = 1;
      queue.tail = 3;
      queue.add("Hobbes");
      if (queue.isEmpty() || queue.size() != 4 || !queue.peek().equals("Ashley")) {
        return false;
      }
      if (!queue.toString().equals("Ashley Michelle Mouna Hobbes"))
        return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Driver method to call the tester methods
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testEmptyQueue(): " + testEmptyQueue());
    System.out.println("testAdd(): " + testAdd());
  }
}



/**
 * This class implements an iterator to iterate over the elements stored in a given serving queue
 * starting from its head.
 */
class ServingQueueIterator implements Iterator<String> {
  private ServingQueue queue; // circular array based queue
  private int head; // head index of the serving queue
  private int index; // index used to iterate through the elements of thr queue

//You are NOT required to implement any tester for the ServingQueueIterator class
  
  /**
   * Creates and initializes a new ServingQueueIterator
   * @param queue the circular queue to iterate through its elements
   * @param head index of the element at the head of the serving queue
   */
  public ServingQueueIterator(ServingQueue queue, int head) {
    this.queue = queue;
    this.head = head;
    index = 0;
  }

  // [HINT]: Check the provided implementation of ServingQueue.toString() method for hints on how
  // to implement the following hasNext and next methods

  /**
   * Checks if there are more elements in the iteration
   * @return true if there are more elements in the iteration and false otherwise
   */
  @Override
  public boolean hasNext() {
    // TODO #11: Complete the implementation of this method
    if (head % index >= queue.size()) {
      return false;
    }
    return true; // default return statement added to avoid compiler errors. Feel free to change it.
  }

  /**
   * Returns the next element in the serving queue and advances the iteration
   * @return the next element in this iteration
   * @throws NoSuchElementException if this iteration is exhausted
   */
  @Override
  public String next() {
    if(!hasNext())
      throw new NoSuchElementException("No more guests in this iteration.");
    
    // TODO #12: Complete the implementation of this method
    String temp = queue.get(index);
    index += 1;
    return temp; // default return statement added to avoid compiler errors. Feel free to change it.
  }

//MAKE SURE TO SAVE your source file before uploading it to gradescope.
  
}
