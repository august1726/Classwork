/**
 * LinkedListString class represents a reference-based implementation of the list
 * ListADT which stores elements of type String.
 * 
 */
public class LinkedListString implements ListADT<String> {
  private LinkedNode<String> head; 
  private LinkedNode<String> tail;
  private int size;


  /**
   * Checks if the list is empty
   * 
   * @return true if the list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * adds a newObject of type String at the end of this list
   * 
   * @param newObject to add
   */
  @Override
  public void add(String newObject) {
    // consider two cases: list empty versus list not-empty
    // add newObject to an empty list
	// update size
    
  
  }

  /**
   * Returns the size of the list
   * 
   * @return the number of items in the list
   */
  @Override
  public int size() {
    
    return size;
  }


  /**
   * This method adds an newObject to the list at the given index position
   * 
   * @param index     where the newObject will be inserted in the list
   * @param newObject to add at index position within the list
   * @throws IndexOutOfBoundsException if index is out of the range 0..size()
   */
  @Override
  public void add(int index, String newObject) {
    // index out of bounds --> throw an IndexOutOfBoundsException
    if (index < 0 || index > size()) { // index out of bounds
      throw new IndexOutOfBoundsException(
          "\nWARNING: Index " + "should be between 0 and " + size() + "!");
    }
    // index == size() -> add newObject at the end of this list
    // index == 0 -> add newObject at the head of this list
    // else (index > 0 and index < size) -> add index at the middle of this list
  }

  /**
   * Returns the item stored at position index within the list
   * 
   * @param index of the element to get
   * @return the element of the list at the given index
   * @throws IndexOutOfBoundsException if index is out of the range 0..size()-1
   */
  @Override
  public String get(int index) {
    if (index < 0 || index >= size()) { // index out of bounds
      throw new IndexOutOfBoundsException(
          "\nWARNING: Index " + "should be from 0 to " + (size() - 1) + "!");
    }
    // TODO - Traverse the list starting from the head until reaching the element at index
    return null;

  } // returns the element of the list at the given index


  /**
   * This method checks if the list contains the element findObject
   * 
   * @param findObject of type String
   * @return true if the list contains findObject and false otherwise
   */
  @Override
  public boolean contains(String findObject) {
    if (isEmpty()) // empty list
      return false;
    // TODO
    // traverse the list looking for a much with findObject


    return false;
  }

  /**
   * This method returns the index of the first element of the list whose equals method 
   * matches with findObject
   * 
   * @param findObject of type String
   * @return the index of findObject in the list if found -1 otherwise
   */
  @Override
  public int indexOf(String findObject) {
    int index = -1;
    if (isEmpty())
      return index;
    // TODO
    // traverse the list looking for the first match with findObject
    return index;
  }


  /**
   * Returns the item stored at position index within the list after removing it from the list
   * 
   * @param index of the element to remove
   * @return the removed element
   * @throws IndexOutOfBoundsException if index is out of the range 0..size()-1
   */
  @Override
  public String remove(int index) {

    if (index < 0 && index >= size()) {
      throw new IndexOutOfBoundsException(
          "\nWARNING: Index " + "should be from 0 to " + (size() - 1) + "!");
    }
    // TODO
    // remove the node at the head of the list
    // remove an item other than the head

    return null;
  }


  
} // end LinkedListString class