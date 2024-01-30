/**
 * ListADT models the List Abstract Data Type
 *
 * @param <T> represents the Type of the elements of the list
 */
public interface ListADT<T> {
  // List of Operations

  /**
   * This method adds a newObject of type T at the end of the list
   * 
   * @param newObject to add
   */
  public void add(T newObject); // add(size(), newObject)

  /**
   * This method adds an newObject to the list at the given index position
   * 
   * @param index position where to insert newObject in the list
   * @param newObject to add to the list at position index
   * @throws IndexOutOfBoundsException if index is out of the range 0 .. size()
   */
  public void add(int index, T newObject);


  /**
   * This method checks if the list contains the element findObject
   * 
   * @param findObject element to find
   * @return true if the list contains findObject and false otherwise
   */
  public boolean contains(T findObject);

  /**
   * isEmpty() Checks if the list is empty
   * 
   * @return true if the list is empty, false otherwise
   */
  public boolean isEmpty();

  /**
   * This method returns the size of this list
   * 
   * @return the number of items in the list
   */
  public int size();


  /**
   * This method returns the index of the first element of this list whose equals method matches
   * with findObject
   * 
   * @param findObject element to find its index if it is stored in this list
   * @return the index of findObject in the list if found, and -1 otherwise
   */
  public int indexOf(T findObject);


  /**
   * This method returns the element at position index of this list without removing it
   * 
   * @param index of the element to return
   * @return the element of the list at the given index
   * @throws IndexOutOfBoundsException if index is out of the range 0 .. size()-1
   */
  public T get(int index);


  /**
   * This method returns and removes the item from the list at the given index position
   * 
   * @param index of the element to be removed
   * @return the removed item
   * @throws IndexOutOfBoundsException if index is out of the range 0 .. size()-1
   */
  public T remove(int index);

} // end ListADT generic interface