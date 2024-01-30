public interface IterableRBTreeADT<Node> {
  /**
   * check if there are more nodes in the tree
   */
  public boolean hasNext();

  /**
   * Return the next node of the current parent
   * 
   * @return the next node of the current parent
   */
  public Node next();

  /**
   * Insert a new node into the tree
   * 
   * @param node node need to be inserted
   * @return true if the insertion is successful, false otherwise
   */
  public boolean insert(Node node);

  /**
   * Method to check if the tree is empty (does not contain any node).
   * 
   * @return true of this.size() return 0, false if this.size() > 0
   */
  public boolean isEmpty();

  /**
   * Print out every node in the tree
   * 
   * @return a string containing every node in the tree
   */
  public String toString();

  /**
   * Returns the number of nodes in the tree
   * 
   * @return number of nodes in the tree
   */
  public int size();

}
