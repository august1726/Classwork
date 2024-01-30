/**
 * LinkedListInteger class represents a reference-based implementation of the list
 * ListADT which stores elements of type Integer.
 * 
 */
public class LinkedListInteger implements ListADT<Integer> {
  private LinkedNode<Integer> head; // entry point reference to linked list of items of type<T>
  // This linked list is accessible only from a reference to her head. It does not define
  // a tail reference or a size field.


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
   * adds a newObject of type Integer at the end of this list
   * 
   * @param newObject to add
   */
  @Override
  public void add(Integer newObject) {
    // consider two cases: list empty versus list not-empty
    // add newObject to an empty list
    if (isEmpty()) {
      head = new LinkedNode<Integer>(newObject);
    } else {
      // add newObject to a non-empty list
      LinkedNode<Integer> node = new LinkedNode<Integer>(newObject);
      LinkedNode<Integer> runner = head; // pointer to traverse through list
      // traverse the list until runner points to the last node in the list
      while(runner.getNext()!= null) {
        runner = runner.getNext();
      }
      runner.setNext(node);
    }
  }

  /**
   * Returns the size of the list
   * 
   * @return the number of items in the list
   */
  @Override
  public int size() {
    // TODO
    int size = 0;
    // list empty versus list not empty
    // if list not empty, traverse the list starting from head to count stored items
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
  public void add(int index, Integer newObject) {
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
  public Integer get(int index) {
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
   * @param findObject of type Integer
   * @return true if the list contains findObject and false otherwise
   */
  @Override
  public boolean contains(Integer findObject) {
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
   * @param findObject of type Integer
   * @return the index of findObject in the list if found -1 otherwise
   */
  @Override
  public int indexOf(Integer findObject) {
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
  public Integer remove(int index) {

    if (index < 0 && index >= size()) {
      throw new IndexOutOfBoundsException(
          "\nWARNING: Index " + "should be from 0 to " + (size() - 1) + "!");
    }
    // TODO
    // remove the node at the head of the list
    // remove an item other than the head

    return null;
  }


  
} // end LinkedList class