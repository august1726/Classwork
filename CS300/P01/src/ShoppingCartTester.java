//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Shopping Cart Tester
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
 * Contains various tests for the methods within ShoppingCart.java
 * 
 * @author August Bambenek
 */
public class ShoppingCartTester {

  /**
   * Checks whether ShoppingCart.lookupProductByName() and ShoppingCart.lookupProductById() methods
   * work as expected.
   * 
   * @return Returns true when this test verifies a correct functionality, and returns false
   *         otherwise
   */
  public static boolean testLookupMethods() {
    // 1. The item to find is at index 0 of the marketItems array
    String expectedOutput = "4390 Apple $1.59";
    if (!ShoppingCart.lookupProductByName("Apple").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Apple as input");
      return false;
    }
    if (!ShoppingCart.lookupProductById(4390).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id of Apple as input");
      return false;
    }
    // 2. The item to find is at the last non-null position of
    // the marketItems array
    expectedOutput = "4688 Tomato $1.79";
    if (!ShoppingCart.lookupProductByName("Tomato").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Tomato as input");
      return false;
    }
    if (!ShoppingCart.lookupProductById(4688).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id of Tomato as input");
      return false;
    }
    // 3. The item to find is at an arbitrary position of the
    // middle of the marketItems array
    expectedOutput = "4363 Cookie $9.5";
    if (!ShoppingCart.lookupProductByName("Cookie").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Cookie as input");
      return false;
    }
    if (!ShoppingCart.lookupProductById(4363).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id of Coookie as input");
      return false;
    }
    // 4. The item to find is not found in the market
    expectedOutput = "No match found";
    if (!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed the name of "
          + "a product not found in the market.");
      return false;
    }
    if (!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the identifier"
          + "of a product not found in the market.");
      return false;
    }
    return true; // NO BUGS detected by this tester method
  }

  /**
   * Checks the correctness of ShoppingCart.getProductPrice() method
   * 
   * @return Returns true when this test verifies a correct functionality, and returns false
   *         otherwise
   */
  public static boolean testGetProductPrice() {
    // first test scenario: get the price of Apple
    double expectedPrice = 1.59; // price of the product Apple in the market
    if (Math.abs(ShoppingCart.getProductPrice("Apple") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when passed Apple.");
      return false;
    }
    // second test scenario: get the price of Spinach
    expectedPrice = 3.09;
    if (Math.abs(ShoppingCart.getProductPrice("Spinach") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when passed Spinach.");
      return false;
    }
    // third test scenario: get the price of a product that doesn't exist
    expectedPrice = -1.0;
    if (Math.abs(ShoppingCart.getProductPrice("abcdefg") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when passed a product that doesn't exist.");
      return false;
    }
    return true; // No bug detected. The ShoppingCart.getProductPrice()
    // passed this tester.
  }

  /**
   * checks the correctness of addItemToCart, contains, and nbOccurrences methods defined in the
   * ShoppingCart class
   * 
   * @return Returns true when this test verifies a correct functionality, and returns false
   *         otherwise
   */
  public static boolean testAddItemToCartContainsNbOccurrences() {
    // first test: adding an item to an empty cart
    String[] cart = new String[7];
    int size = 0;
    size = ShoppingCart.addItemToCart("Cucumber", cart, size);
    if (size != 1 || !ShoppingCart.contains("Cucumber", cart, size)
        || ShoppingCart.nbOccurrences("Cucumber", cart, size) != 1) {
      System.out.println(
          "Problem detected: Your addItemToCart() method failed to return the expected output when "
              + "passed an empty cart");
      return false;
    }
    // second test: attempting to add an item to a full cart
    String[] cart2 = new String[] {"Banana", "Apple", "Ice Cream"};
    size = 3;
    size = ShoppingCart.addItemToCart("Broccoli", cart2, size);
    if (size != 3 || ShoppingCart.contains("Broccoli", cart2, size)
        || !ShoppingCart.contains("Banana", cart2, size)
        || !ShoppingCart.contains("Apple", cart2, size)
        || !ShoppingCart.contains("Ice Cream", cart2, size)) {
      System.out.println(
          "Problem detected: Your addItemToCart() method failed to return the expected output when "
              + "passed a full cart");
      return false;
    }
    // third test: adding an item to a partially filled cart
    String[] cart3 = new String[] {"Tomato", "Carrot", "Avocado", null, null, null, null, null};
    size = 3;
    size = ShoppingCart.addItemToCart("Butter", cart3, size);
    if (size != 4 || !ShoppingCart.contains("Butter", cart3, size)
        || !ShoppingCart.contains("Tomato", cart3, size)
        || !ShoppingCart.contains("Carrot", cart3, size)
        || !ShoppingCart.contains("Avocado", cart3, size)) {
      System.out.println(
          "Problem detected: Your addItemToCart() method failed to return the expected output when "
              + "passed a partially full cart");
      return false;
    }
    return true;
  }

  /**
   * This tester method checks the correctness of removeItem() method defined in the ShoppingCart
   * class
   * 
   * @return Returns true when this test verifies a correct functionality, and returns false
   *         otherwise
   */
  public static boolean testRemoveItem() {
    // test 1: removing an item at index 0
    String[] cart = new String[] {"Tomato", "Pepper", "Spinach"};
    int size = 3;
    size = ShoppingCart.removeItem(cart, "Tomato", size);
    if (size != 2 || ShoppingCart.nbOccurrences("Pepper", cart, size) != 1
        || ShoppingCart.nbOccurrences("Spinach", cart, size) != 1
        || ShoppingCart.contains("Tomato", cart, size)) {
      System.out.println(
          "Problem Detected: Your removeItem() method failed to return the expected output when"
              + " removing the item at index 0");
      return false;
    }
    // test 2: removing an item at index size - 1
    String[] cart2 = new String[] {"Chocolate", "Banana", "Cereal", "Blueberry", null, null};
    size = 4;
    size = ShoppingCart.removeItem(cart2, "Blueberry", size);
    if (size != 3 || ShoppingCart.nbOccurrences("Chocolate", cart2, size) != 1
        || ShoppingCart.nbOccurrences("Banana", cart2, size) != 1
        || ShoppingCart.nbOccurrences("Cereal", cart2, size) != 1
        || ShoppingCart.contains("Blueberry", cart2, size)) {
      System.out.println(
          "Problem Detected: Your removeItem() method failed to return the expected output when"
              + " removing the item at index size - 1");
      return false;
    }
    // test 3: removing an item at an arbitrary position in the middle
    String[] cart3 = new String[] {"Mushroom", "Onion", "Onion", "Onion", "Beef", null};
    size = 5;
    size = ShoppingCart.removeItem(cart3, "Onion", size);
    if (size != 4 || ShoppingCart.nbOccurrences("Mushroom", cart3, size) != 1
        || ShoppingCart.nbOccurrences("Onion", cart3, size) != 2
        || ShoppingCart.nbOccurrences("Beef", cart3, size) != 1) {
      System.out.println(
          "Problem Detected: Your removeItem() method failed to return the expected output when"
              + " removing the item at an arbitrary position in the middle");
      return false;
    }
    // test 4: removing an item from an empty cart
    size = 0;
    size = ShoppingCart.removeItem(cart3, "Onion", size);
    if (size != 0 || ShoppingCart.nbOccurrences("Onion", cart3, 4) != 2) {
      System.out.println(
          "Problem Detected: Your removeItem() method failed to return the expected output when"
              + " removing the item from an empty cart");
      return false;
    }
    // test 5: removing an item that isn't in the cart
    size = 4;
    size = ShoppingCart.removeItem(cart3, "Ice Cream", size);
    if (size != 4) {
      System.out.println(
          "Problem Detected: Your removeItem() method failed to return the expected output when"
              + " removing an item that isn't in the cart");
      return false;
    }
    return true;
  }

  /**
   * This tester method checks the correctness of checkout and getCartSummary() methods defined in
   * the ShoppingCart class
   * 
   * @return Returns true when this test verifies a correct functionality, and returns false
   *         otherwise
   */
  public static boolean testCheckoutGetCartSummary() {
    // test 1: cart containing duplicate items
    String[] cart = new String[] {"Tomato", "Pizza", "Pizza", "Apple", "Cheese", "Tomato", "Pizza"};
    int size = 7;
    String expected = "(1) Apple\n(1) Cheese\n(3) Pizza\n(2) Tomato";
    double expectedPrice = 45.318;
    if (!ShoppingCart.getCartSummary(cart, size).equals(expected)) {
      System.out.println("Problem Detected: Your getCartSummary() method failed to return "
          + "the expected output when passed a cart containing duplicate items");
      return false;
    }
    if (Math.abs(ShoppingCart.checkout(cart, size) - expectedPrice) > 0.001) {
      System.out.println("Problem Detected: Your checkout() method failed to return "
          + "the expected output when passed a cart containing duplicate items");
      return false;
    }
    // test 2: cart containing all different items
    String[] cart2 = new String[] {"Grape", "Potato", "Eggs", "Avocado", "Chicken", "Milk", "Beef"};
    expected = "(1) Avocado\n(1) Beef\n(1) Chicken\n(1) Eggs\n(1) Grape\n(1) Milk\n(1) Potato";
    expectedPrice = 18.5115;
    if (!ShoppingCart.getCartSummary(cart2, size).equals(expected)) {
      System.out.println("Problem Detected: Your getCartSummary() method failed to return "
          + "the expected output when passed a cart containing all different items");
      return false;
    }
    if (Math.abs(ShoppingCart.checkout(cart2, size) - expectedPrice) > 0.001) {
      System.out.println("Problem Detected: Your checkout() method failed to return "
          + "the expected output when passed a cart containing all different items");
      return false;
    }
    // test 3: empty cart
    String[] emptyCart = new String[20];
    expected = "";
    size = 0;
    expectedPrice = 0.0;
    if (!ShoppingCart.getCartSummary(emptyCart, size).equals(expected)) {
      System.out.println("Problem Detected: Your getCartSummary() method failed to return "
          + "the expected output when passed an empty cart");
      return false;
    }
    if (Math.abs(ShoppingCart.checkout(emptyCart, size) - expectedPrice) > 0.001) {
      System.out.println("Problem Detected: Your checkout() method failed to return "
          + "the expected output when passed an empty cart");
      return false;
    }
    return true;
  }

  /**
   * This tester runs all the tester methods defined in this tester class. For instance, if this
   * tester class defines three tester methods named test1(), test2() and test3(), it will return
   * test1() && test2() && test3()
   * 
   * @return Returns false if any of the tester methods fails, and true if all the tests are passed.
   */
  public static boolean runAllTests() {
    if (!testLookupMethods() || !testGetProductPrice() || !testCheckoutGetCartSummary()
        || !testRemoveItem() || !testAddItemToCartContainsNbOccurrences()) {
      return false;
    }
    return true;
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testLookupMethods(): " + testLookupMethods());
    System.out.println("testGetProductPrice(): " + testGetProductPrice());
    System.out.println("testCheckoutGetCartSummary(): " + testCheckoutGetCartSummary());
    System.out.println("testRemoveItem(): " + testRemoveItem());
    System.out.println(
        "testAddItemToCartContainsNbOccurrences(): " + testAddItemToCartContainsNbOccurrences());
    System.out.println("runAllTests(): " + runAllTests());
  }
}
