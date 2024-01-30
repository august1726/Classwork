//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Shopping Cart
// Course: CS 300 Spring 2022
//
// Author: August Bambenek
// Email: abambenek@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Contains various methods for modifying and analyzing the contents of a shopping cart
 * 
 * @author August Bambenek
 */
public class ShoppingCart {
  private static final double TAX_RATE = 0.05; // sales tax
  // MarketItems: a perfect-size two-dimensional array that stores the list of
  // available items in a given market
  // MarketItems[i][0] refers to a String representation of the item identifiers
  // MarketItems[i][1] refers the item name. Item names are also unique
  // MarketItems[i][2] a String representation of the unit price
  // of the item in dollars
  private static String[][] marketItems =
      new String[][] {{"4390", "Apple", "$1.59"}, {"4046", "Avocado", "$0.59"},
          {"4011", "Banana", "$0.49"}, {"4500", "Beef", "$3.79"}, {"4033", "Blueberry", "$6.89"},
          {"4129", "Broccoli", "$1.79"}, {"4131", "Butter", "$4.59"}, {"4017", "Carrot", "$1.19"},
          {"3240", "Cereal", "$3.69"}, {"3560", "Cheese", "$3.49"}, {"3294", "Chicken", "$5.09"},
          {"4071", "Chocolate", "$3.19"}, {"4363", "Cookie", "$9.5"}, {"4232", "Cucumber", "$0.79"},
          {"3033", "Eggs", "$3.09"}, {"4770", "Grape", "$2.29"}, {"3553", "Ice Cream", "$5.39"},
          {"3117", "Milk", "$2.09"}, {"3437", "Mushroom", "$1.79"}, {"4663", "Onion", "$0.79"},
          {"4030", "Pepper", "$1.99"}, {"3890", "Pizza", "$11.5"}, {"4139", "Potato", "$0.69"},
          {"3044", "Spinach", "$3.09"}, {"4688", "Tomato", "$1.79"}, null, null, null, null};

  /**
   * Searches marketItems for a specified product given its name and returns a string containing its
   * ID, name, and price
   * 
   * @param name - the name of the product or item to search
   * @return Returns a string representation including the ID, name, and price of the item whose
   *         name is provided as input if a match was found. If no match is found, returns "No match
   *         found"
   */
  public static String lookupProductByName(String name) {
    for (int i = 0; i < 25; i++) {
      if (marketItems[i][1].toLowerCase().equals(name.toLowerCase())) {
        return marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2];
      }
    }
    return "No match found";
  }

  /**
   * Searches marketItems for a specified product given its ID and returns a string containing its
   * ID, name, and price
   * 
   * @param id - the identifier of the product or item to search
   * @return Returns a string representation including the ID, name, and price of the item whose ID
   *         is provided as input if a match was found. If no match is found, returns "No match
   *         found"
   */
  public static String lookupProductById(int id) {
    for (int i = 0; i < 25; i++) {
      if (Integer.parseInt(marketItems[i][0]) == id) {
        return marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2];
      }
    }
    return "No match found";
  }

  /**
   * Searches marketItems for a specified item given its name and returns its price
   * 
   * @param name - the name of the product to check its price
   * @return Returns the price in dollars (a double value) of a market item given its name. If no
   *         match was found in the market catalog, this method returns -1.0
   */
  public static double getProductPrice(String name) {
    for (int i = 0; i < 25; i++) {
      if (name.toLowerCase().equals(marketItems[i][1].toLowerCase())) {
        return Double.parseDouble(marketItems[i][2].substring(1));
      }
    }
    return -1.0;
  }

  /**
   * Returns a deep copy of the marketItems array
   * 
   * @return Returns a deep copy of the marketItems array
   */
  public static String[][] getCopyOfMarketItems() {
    String[][] copyArray = new String[marketItems.length][];
    for (int i = 0; i < marketItems.length; i++) {
      copyArray[i] = marketItems[i];
    }
    return copyArray;
  }

  /**
   * Appends an item to a given cart (appends means adding to the end). If the cart is already full
   * (meaning its size equals its length), the item will not be added to the cart.
   * 
   * @param item - the name of the product to be added to the cart
   * @param cart - an array of strings which contains the names of items in the cart
   * @param size - the number of items in the cart
   * @return Returns the size of the oversize array cart after trying to add item to the cart. This
   *         method returns the same of size without making any change to the contents of the array
   *         if it is full.
   */
  public static int addItemToCart(String item, String[] cart, int size) {
    if (cart.length == size) {
      return size;
    }
    cart[size] = item;
    return size + 1;
  }

  /**
   * Returns the number of occurrences of a given item within a cart.
   * 
   * @param item - the name of the item to search
   * @param cart - an array of strings which contains the names of items in the cart
   * @param size - the number of items in the cart
   * @return Returns the number of occurrences of item (exact match) within the oversize array cart.
   *         Zero or more occurrences of item can be present in the cart.
   */
  public static int nbOccurrences(String item, String[] cart, int size) {
    int occurences = 0;
    for (int i = 0; i < size; i++) {
      if (item.toLowerCase().equals(cart[i].toLowerCase())) {
        occurences += 1;
      }
    }
    return occurences;
  }

  /**
   * Checks whether a cart contains at least one occurrence of a given item.
   * 
   * @param item - the name of the item to search
   * @param cart - an array of strings which contains the names of items in the cart
   * @param size - the number of items in the cart
   * @return Returns true if there is a match (exact match) of item within the provided cart, and
   *         false otherwise.
   */
  public static boolean contains(String item, String[] cart, int size) {
    for (int i = 0; i < size; i++) {
      if (item.toLowerCase().equals(cart[i].toLowerCase())) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method returns the total value in dollars of the cart. All products in the market are
   * taxed (subject to TAX_RATE).
   * 
   * @param cart - an array of strings which contains the names of items in the cart
   * @param size - the number of items in the cart
   * @return Returns the total value in dollars of the cart accounting taxes.
   */
  public static double checkout(String[] cart, int size) {
    double total = 0;
    for (int i = 0; i < size; i++) {
      total += getProductPrice(cart[i]);
    }
    total += total * TAX_RATE;
    return total;
  }

  /**
   * Removes one occurrence of item from a given cart. If no match with item was found in the cart,
   * the method returns the same value of input size without making any change to the contents of
   * the array.
   * 
   * @param cart - an array of strings which contains the names of items in the cart
   * @param item - the name of the item to remove
   * @param size - the number of items in the cart
   * @return Returns the size of the oversize array cart after trying to remove item from the cart.
   */
  public static int removeItem(String[] cart, String item, int size) {
    if (size == 0) {
      return 0;
    }
    for (int i = 0; i < size; i++) {
      if (item.toLowerCase().equals(cart[i].toLowerCase())) {
        if (size == 1) {
          cart[i] = null;
          return size - 1;
        }
        cart[i] = cart[size - 1];
        cart[size - 1] = null;
        return size - 1;
      }
    }
    return size;
  }

  /**
   * Removes all items from a given cart. The array cart must be empty (contains only null
   * references) after this method returns.
   * 
   * @param cart - an array of strings which contains the names of items in the cart
   * @param size - the number of items in the cart
   * @return Returns the size of the cart after removing all its items.
   */
  public static int emptyCart(String[] cart, int size) {
    for (int i = 0; i < size; i++) {
      cart[i] = null;
    }
    return 0;
  }

  /**
   * Returns a string representation of the summary of the contents of a given cart. The format of
   * the returned string contains a set of lines where each line contains the number of occurrences
   * of a given item, between parentheses, followed by one space followed by the name of a unique
   * item in the cart. (#occurrences) name1 (#occurrences) name2
   * 
   * @param cart - an array of strings which contains the names of items in the cart
   * @param size - the number of items in the cart
   * @return Returns a string representation of the summary of the contents of the cart
   */
  public static String getCartSummary(String[] cart, int size) {
    if (size == 0) {
      return "";
    }
    int[] counter = new int[25];
    String summary = "";
    int numLines = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < 25; j++) {
        if (cart[i].toLowerCase().equals(marketItems[j][1].toLowerCase())) {
          if (counter[j] == 0) {
            numLines += 1;
          }
          counter[j] += 1;
          break;
        }
      }
    }
    for (int i = 0; i < 25; i++) {
      if (counter[i] > 0) {
        numLines -= 1;
        summary = summary.concat("(" + counter[i] + ") " + marketItems[i][1]);
        if (numLines > 0) {
          summary = summary.concat("\n");
        }
      }
    }
    return summary;
  }
}
