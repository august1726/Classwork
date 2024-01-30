//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Shopping Cart Tester
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

import java.io.File;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

/**
 * Some tests for methods in the Exceptional Shopping Cart class
 * 
 * @author August Bambenek
 */
public class ExceptionalShoppingCartTester {

  /**
   * runs all test methods in this class
   * 
   * @return returns true if all tests pass, returns false if a test fails
   */
  public static boolean runAllTests() {
    if (!testLookupMethods() || !testAddItemToMarketCatalog() || !testSaveCartSummary()
        || !testLoadCartSummary()) {
      return false;
    }
    return true;
  }

  /**
   * tests the lookupProductByName method and the lookupProductById method
   * 
   * @return returns true if all tests pass, returns false if a test fails
   */
  public static boolean testLookupMethods() {
    String name = "Apple";
    String expectedResult = "4390 Apple $1.59";
    try {
      if (!ExceptionalShoppingCart.lookupProductByName(name).equals(expectedResult)) {
        return false;
      }
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      return false;
    }
    int id = 4017;
    expectedResult = "4017 Carrot $1.19";
    try {
      if (!ExceptionalShoppingCart.lookupProductById(id).equals(expectedResult)) {
        return false;
      }
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
    name = "test";
    try {
      if (!ExceptionalShoppingCart.lookupProductByName(name).isEmpty()
          || !ExceptionalShoppingCart.lookupProductByName(name).isBlank()) {
        return false;
      }
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      return true;
    }
    return false;
  }

  /**
   * tests the addItemToMarketCatalog method
   * 
   * @return returns true if all tests pass, returns false if a test fails
   */
  public static boolean testAddItemToMarketCatalog() {
    String id = "1234";
    String name = "test";
    String price = "$1.23";
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog(id, name, price);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
    String[][] copyArray = ExceptionalShoppingCart.getCopyOfMarketItems();
    if (!copyArray[25][0].equals(id) || !copyArray[25][1].equals(name)
        || !copyArray[25][2].equals(price)) {
      return false;
    }
    id = "2345";
    name = "test2";
    price = "$$abcdefg";
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog(id, name, price);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return true;
    }
    return false;
  }

  /**
   * tests the saveCartSummary method and the parseCartSummaryLine() method
   * 
   * @return returns true if all tests pass, returns false if a test fails
   */
  public static boolean testSaveCartSummary() {
    File file = new File("document.txt");
    String[] cart1 = new String[] {"Banana", "Banana", "Banana", "Grape", "Carrot", null, null};
    int size = 5;
    try {
      size = ExceptionalShoppingCart.parseCartSummaryLine("( 2 ) Tomato", cart1, size);
      ExceptionalShoppingCart.saveCartSummary(cart1, size, file);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (DataFormatException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
      return false;
    }

    return true;
  }

  /**
   * tests the the loadCartSummary method, must be ran after the testSaveCartSummary() method
   * 
   * @return returns true if all tests pass, returns false if a test fails
   */
  public static boolean testLoadCartSummary() {
    File file = new File("document.txt");
    String[] cart2 = new String[7];
    String[] cart1 =
        new String[] {"Banana", "Banana", "Banana", "Grape", "Carrot", "Tomato", "Tomato"};
    int size2 = 0;
    try {
      size2 = ExceptionalShoppingCart.loadCartSummary(file, cart2, size2);
      for (int i = 0; i < cart2.length; i++) {
        if (!cart2[i].equals(cart1[i])) {
          return false;
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  /**
   * the main method which tests can be ran from
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }

}
