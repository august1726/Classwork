//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Application Queue
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
 * Array-based heap implementation of a priority queue containing Applications. Guarantees the
 * min-heap invariant, so that the Application at the root should have the lowest score, and
 * children always have a higher or equal score as their parent. The root of a non-empty queue is
 * always at index 0 of this array-heap.
 * 
 * @author August Bambenek
 */
public class ApplicationQueue implements PriorityQueueADT<Application>, Iterable<Application> {
  private Application[] queue; // array min-heap of applications representing this priority queue
  private int size; // size of this priority queue

  /**
   * Creates a new empty ApplicationQueue with the given capacity
   * 
   * @param capacity Capacity of this ApplicationQueue
   * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
   *                                  positive integer
   */
  public ApplicationQueue(int capacity) {
    // verify the capacity
    if (capacity <= 0) {
      throw new IllegalArgumentException();
    }
    // initialize fields appropriately
    queue = new Application[capacity];
  }

  /**
   * Checks whether this ApplicationQueue is empty
   * 
   * @return {@code true} if this ApplicationQueue is empty
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the size of this ApplicationQueue
   * 
   * @return the size of this ApplicationQueue
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Adds the given Application to this ApplicationQueue and use the percolateUp() method to
   * maintain min-heap invariant of ApplicationQueue. Application should be compared using the
   * Application.compareTo() method.
   * 
   * 
   * @param o Application to add to this ApplicationQueue
   * @throws NullPointerException  if the given Application is null
   * @throws IllegalStateException with a descriptive error message if this ApplicationQueue is full
   */
  @Override
  public void enqueue(Application o) {
    // verify the application
    if (o == null) {
      throw new NullPointerException("ERROR: Application passed as input is null");
    }
    // verify that the queue is not full
    if (queue.length == size) {
      throw new IllegalStateException("ERROR: Queue is full");
    }
    // if allowed, add the application to the queue and percolate to restore the heap condition
    queue[size] = o;
    size += 1;
    percolateUp(size - 1); 
  }

  /**
   * Removes and returns the Application at the root of this ApplicationQueue, i.e. the Application
   * with the lowest score.
   * 
   * @return the Application in this ApplicationQueue with the smallest score
   * @throws NoSuchElementException with a descriptive error message if this ApplicationQueue is
   *                                empty
   */
  @Override
  public Application dequeue() {
    // verify that the queue is not empty
    if (isEmpty()) {
      throw new NoSuchElementException("ApplicationQueue is empty");
    }
    // save the lowest-scoring application
    Application temp = queue[0];
    // replace the root of the heap and percolate to restore the heap condition
    // fix this argument
    queue[0] = queue[size - 1];
    queue[size - 1] = null;
    percolateDown(0);
    size -= 1;
    // return the lowest-scoring application
    return temp; 
  }

  /**
   * An implementation of percolateDown() method. Restores the min-heap invariant of a given subtree
   * by percolating its root down the tree. If the element at the given index does not violate the
   * min-heap invariant (it is due before its children), then this method does not modify the heap.
   * Otherwise, if there is a heap violation, then swap the element with the correct child and
   * continue percolating the element down the heap.
   * 
   * This method may be implemented recursively OR iteratively.
   * 
   * @param i index of the element in the heap to percolate downwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  private void percolateDown(int i) {
    // implement the min-heap percolate down algorithm to modify the heap in place
    if (i < 0 || i > size - 1) {
      throw new IndexOutOfBoundsException("ERROR: index passed as input is out of range");
    }
    if (i * 2 + 1 > size - 1 || queue[i * 2 + 1] == null) {
      return;
    }
    if (queue[i].compareTo(queue[i * 2 + 1]) > 0) {
      if (i * 2 + 2 > size - 1 || queue[i * 2 + 2] == null) {
        Application temp = queue[i * 2 + 1];
        queue[i * 2 + 1] = queue[i];
        queue[i] = temp;
        percolateDown(i * 2 + 1);
        return;
      }
      if (queue[i * 2 + 2].compareTo(queue[i * 2 + 1]) > 0) {
        Application temp = queue[i * 2 + 1];
        queue[i * 2 + 1] = queue[i];
        queue[i] = temp;
        percolateDown(i * 2 + 1);
        return;
      } else {
        Application temp = queue[i * 2 + 2];
        queue[i * 2 + 2] = queue[i];
        queue[i] = temp;
        percolateDown(i * 2 + 2);
        return;
      }
    }
    if (i * 2 + 2 > size - 1 || queue[i * 2 + 2] == null) {
      return;
    }
    if (queue[i].compareTo(queue[i * 2 + 2]) > 0) {
      Application temp = queue[i * 2 + 2];
      queue[i * 2 + 2] = queue[i];
      queue[i] = temp;
      percolateDown(i * 2 + 2);
      return;
    }
  }

  /**
   * An implementation of percolateUp() method. Restores the min-heap invariant of the tree by
   * percolating a leaf up the tree. If the element at the given index does not violate the min-heap
   * invariant (it occurs after its parent), then this method does not modify the heap. Otherwise,
   * if there is a heap violation, swap the element with its parent and continue percolating the
   * element up the heap.
   * 
   * This method may be implemented recursively OR iteratively.
   * 
   * Feel free to add private helper methods if you need them.
   * 
   * @param i index of the element in the heap to percolate upwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  private void percolateUp(int i) {
    // implement the min-heap percolate up algorithm to modify the heap in place
    if (i < 0 || i > size - 1) {
      throw new IndexOutOfBoundsException("ERROR: index passed as input is out of range");
    }
    int index = i;
    while (queue[index].compareTo(queue[(index - 1) / 2]) < 0) {
      Application temp = queue[index];
      queue[index] = queue[(index - 1) / 2];
      queue[(index - 1) / 2] = temp;
      index = (index - 1) / 2;
    }
  }

  /**
   * Returns the Application at the root of this ApplicationQueue, i.e. the Application with the
   * lowest score.
   * 
   * @return the Application in this ApplicationQueue with the smallest score
   * @throws NoSuchElementException if this ApplicationQueue is empty
   */
  @Override
  public Application peek() {
    // verify that the queue is not empty
    if (isEmpty()) {
      throw new NoSuchElementException("ERROR: queue is empty");
    }
    // return the lowest-scoring application
    return queue[0];
  }

  /**
   * Returns a deep copy of this ApplicationQueue containing all of its elements in the same order.
   * This method does not return the deepest copy, meaning that you do not need to duplicate
   * applications. Only the instance of the heap (including the array and its size) will be
   * duplicated.
   * 
   * @return a deep copy of this ApplicationQueue. The returned new application queue has the same
   *         length and size as this queue.
   */
  public ApplicationQueue deepCopy() {
    // implement this method according to its Javadoc comment
    ApplicationQueue copy = new ApplicationQueue(queue.length);
    for (int i = 0; i < size; i++) {
      copy.enqueue(queue[i]);
    }
    return copy;
  }

  /**
   * Returns a String representing this ApplicationQueue, where each element (application) of the
   * queue is listed on a separate line, in order from the lowest score to the highest score.
   * 
   * This implementation is provided.
   * 
   * @see Application#toString()
   * @see ApplicationIterator
   * @return a String representing this ApplicationQueue
   */
  @Override
  public String toString() {
    StringBuilder val = new StringBuilder();

    for (Application a : this) {
      val.append(a).append("\n");
    }

    return val.toString();
  }

  /**
   * Returns an Iterator for this ApplicationQueue which proceeds from the lowest-scored to the
   * highest-scored Application in the queue.
   * 
   * This implementation is provided.
   * 
   * @see ApplicationIterator
   * @return an Iterator for this ApplicationQueue
   */
  @Override
  public Iterator<Application> iterator() {
    return new ApplicationIterator(this);
  }
}
