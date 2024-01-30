///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: August Bambenek
// Campus ID: 9083041492
// WiscEmail: abambenek@wisc.edu
//                           (TODO: fill this out)
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//
//  BE CAREFUL!! This file contains TWO classes. You will need to make
//  changes to BOTH classes for full credit.
//
////////////////////////////////////////////////////////////////////////////////

// MAKE SURE TO SAVE your source file before uploading it to gradescope.

import java.util.ArrayList;

/**
 * This class contains various Items and offers utility methods for analyzing the
 * contents of the cart.
 * 
 * NOTE: you may NOT add any additional data fields to this class. You may add private
 * helper methods if needed.
 */
public class Cart {
  // instance fields
  private ArrayList<Item> cart;
  private final double COST_LIMIT;
  
  /**
   * Creates a new Cart object
   */
  public Cart(double costLimit) {
    // TODO: complete the implementation to initialize all data fields
    this.COST_LIMIT = costLimit; 
    cart = new ArrayList<Item>();
  }
  
  /**
   * Adds an item to the cart if and only if it does not cause the cart to exceed its cost limit
   * 
   * @param i the Item to add
   * @return true if the item was added successfully; false if adding the item would cause the
   * cart to exceed its limit
   */
  public boolean addItem(Item i) {
    // TODO: complete the implementation per the Javadoc comment above
    if (i.getPrice() > COST_LIMIT - getTotalCost()) {
      return false;
    }
    cart.add(i);
    return true; // change this
  }
  
  /**
   * Calculates the current total cost of all items in the cart
   * 
   * @return the current total cost of all items in this cart
   */
  public double getTotalCost() {
    // TODO: complete the implementation per the Javadoc comment above
    double cost = 0;
    for (int i = 0; i < cart.size(); i++) {
      cost += cart.get(i).getPrice();
    }
    return cost; // change this
  }
  
  /**
   * Removes the Item with the highest price currently in the cart. If the cart is empty, returns
   * null.
   * 
   * For full credit, this method MUST call the sortCart() method defined below.
   * 
   * @return the Item with the highest price currently in the cart
   */
  public Item removeMostExpensive() {
    if (cart.size() == 0) {
      return null;
    }
    sortCart();
    Item mostExpensive = cart.get(0);
    cart.remove(0);
    return mostExpensive;
  }

// MAKE SURE TO SAVE your source file before uploading it to gradescope.
  
  /**
   * Private helper method; uses Collections.sort to sort the cart's contents.  After sorting,
   * items are sorted by increasing price.
   * TODO: UNCOMMENT this method AFTER implementing the Comparable interface in the Item class.
   */
  private void sortCart() {
    java.util.Collections.sort(this.cart);
  }
  
  ////////////////////////////////////////////////////////////////////////////////
  /////////   PROVIDED TESTER METHODS. MODIFY AS YOU LIKE! NOT GRADED.   /////////
  /////////         GRADED PORTION CONTINUES BELOW MAIN METHOD.          /////////
  ////////////////////////////////////////////////////////////////////////////////
  
  @Override
  public String toString() {
    String result = "";
    for (Item i : this.cart) {
      result += i.getName()+": $"+i.getPrice()+"\n";
    }
    return result.substring(0,result.length()-1);
  }
  
  public static void main(String[] args) {
    Cart c = new Cart(5.0);
    
    Item i1 = new Item("Apple", 4390, 1.59);
    Item i2 = new Item("Spinach", 3044, 3.09);
    Item i3 = new Item("Broccoli", 4129, 1.79);
    
    c.addItem(i1);  // should work
    c.addItem(i2);  // should work
    c.addItem(i3);  // should NOT work
    
    System.out.println(c); // should not include Broccoli
    
    System.out.println("Most expensive: "+c.removeMostExpensive().getName());  // should be Spinach
    System.out.println(c); // should be only Apple
    
    c.addItem(i3);  // should work
    System.out.println(c);
  }
  
  ////////////////////////////////////////////////////////////////////////////////
  /////////   END PROVIDED TESTER METHODS. CONTINUE IN THE CLASS BELOW.   ////////
  ////////////////////////////////////////////////////////////////////////////////
}

/**
 * This class models Item objects which can be added to a Cart. Each object contains
 * its price and name, and is sortable by increasing price.
 * 
 * TODO: modify this class to implement the Comparable interface, such that an Item can
 * be compared to another Item WITHOUT type casting or instanceof.
 */
class Item implements Comparable<Item>{
  // instance fields
  private String name;
  private int id;
  private double price;
  
  /**
   * Create a new Item object
   * 
   * @param name the name of the item
   * @param id the four-digit ID of the item
   * @param price the price of the item in US dollars
   * @throws IllegalArgumentException if price is 0 or negative, or if id is not a 4 digit
   * positive integer
   */
  public Item(String name, int id, double price) {
    // if the value of id is not a 4 digit positive integer, throw an IllegalArgumentException
    // if price is 0 or negative, throw an IllegalArgumentException
    if (id < 1000 || id > 9999) {
      throw new IllegalArgumentException("ERROR: id is not a 4 digit positive number");
    }
    if (price <= 0) {
      throw new IllegalArgumentException("ERROR: price cannot be zero or negative");
    }
    this.name = name;
    this.id = id;
    this.price = price;
    // TODO: complete the implementation to initialize all data fields and throw exceptions as
    // detailed above
  }
  
  // TODO: add any methods required by the Comparable interface
  @Override
  public int compareTo(Item otherItem) {
    if (otherItem.getPrice() > this.price) {
      return 1;
    }
    if (otherItem.getPrice() < this.price) {
      return -1;
    }
    return 0;
  }
  // Items are compared with respect to their prices; an item with price 1.59 is "greater than"
  // an item with price 0.75. Two Items are equal if their prices are equal.


  
  ////////////////////////////////////////////////////////////////////////////////
  ////////// ACCESSOR METHODS BELOW THIS LINE DO NOT NEED TO BE MODIFIED /////////
  ////////////////////////////////////////////////////////////////////////////////
  
  public String getName() { return this.name; }
  public int getID() { return this.id; }
  public double getPrice() { return this.price; }
  
// MAKE SURE TO SAVE your source file before uploading it to gradescope.  
}
