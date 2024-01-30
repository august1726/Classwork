//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Artwork
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
// Persons:         CSLC & Zihan Zhang helped with testBuyArtwork()
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * ArtworkGallery.
 * 
 * @author August Bambenek
 *
 */

public class ArtGalleryTester {

  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Artwork class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testArtworkCompareToEquals() {
    try {
      Artwork art1 = new Artwork("name", 1999, 10);
      Artwork art2 = new Artwork("name", 1999, 10);
      if (!art1.equals(art2) || art1.compareTo(art2) != 0) {
        return false;
      }
      Artwork art3 = new Artwork("name", 1111, 10);
      if (art3.compareTo(art1) >= 0) {
        return false;
      }
      Artwork art4 = new Artwork("name", 1999, 9);
      if (art4.compareTo(art1) >= 0) {
        return false;
      }
      Artwork art5 = new Artwork("zzzz", 1999, 10);
      if (art5.compareTo(art1) <= 0) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of both addArtwork() and toString() methods
   * implemented in the ArtworkGallery class. This unit test considers at least the following
   * scenarios. (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one artwork and then
   * check that the addArtwork() method call returns true, the tree is not empty, its size is 1, and
   * the .toString() called on the tree returns the expected output. (3) Try adding another artwork
   * which is smaller that the artwork at the root, (4) Try adding a third artwork which is greater
   * than the one at the root, (5) Try adding at least two further artwork such that one must be
   * added at the left subtree, and the other at the right subtree. For all the above scenarios, and
   * more, double check each time that size() method returns the expected value, the add method call
   * returns true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * artwork with respect to year, cost, and then name. (6) Try adding a artwork already stored in
   * the tree. Make sure that the addArtwork() method call returned false, and that the size of the
   * tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddArtworkToStringSize() {
    // TODO complete the implementation of this method
    Artwork art1 = new Artwork("name1", 1099, 10);
    Artwork art2 = new Artwork("name2", 1289, 15);
    Artwork art3 = new Artwork("name3", 1799, 20);
    Artwork art4 = new Artwork("name4", 1800, 22);
    Artwork art5 = new Artwork("name5", 1900, 22);
    Artwork art6 = new Artwork("name6", 2000, 22);
    Artwork art7 = new Artwork("name7", 2010, 22);
    ArtGallery gallery = new ArtGallery();
    if (gallery.size() != 0 || !gallery.isEmpty()) {
      return false;
    }
    if (!gallery.toString().equals("")) {
      return false;
    }
    if (!gallery.addArtwork(art3)) {
      return false;
    }
    if (gallery.size() != 1 || gallery.isEmpty()) {
      return false;
    }
    if (!gallery.toString().contains("[(Name: name3) (Year: 1799) (Cost: $20.0)]")) {
      System.out.println(gallery.toString());
      return false;
    }
    if (!gallery.addArtwork(art2)) {
      return false;
    }
    if (gallery.size() != 2) {
      return false;
    }
    if (!gallery.toString().contains("[(Name: name2) (Year: 1289) (Cost: $15.0)]\n[(Name: name3) "
        + "(Year: 1799) (Cost: $20.0)]")) {
      return false;
    }
    if(!gallery.addArtwork(art5)) {
      return false;
    }
    if (gallery.size() != 3) {
      return false;
    }
    if (!gallery.toString().contains("[(Name: name2) (Year: 1289) (Cost: $15.0)]\n[(Name: name3) "
        + "(Year: 1799) (Cost: $20.0)]\n[(Name: name5) (Year: 1900) (Cost: $22.0)]")) {
      return false;
    }
    if(!gallery.addArtwork(art1)) {
      return false;
    }
    if(!gallery.addArtwork(art4)) {
      return false;
    }
    if(!gallery.addArtwork(art6)) {
      return false;
    }
    if(!gallery.addArtwork(art7)) {
      return false;
    }
    if (gallery.size() != 7) {
      return false;
    }
    if (!gallery.toString().contains("[(Name: name1) (Year: 1099) (Cost: $10.0)]\n"
            + "[(Name: name2) (Year: 1289) (Cost: $15.0)]\n"
            + "[(Name: name3) (Year: 1799) (Cost: $20.0)]\n"
            + "[(Name: name4) (Year: 1800) (Cost: $22.0)]\n"
            + "[(Name: name5) (Year: 1900) (Cost: $22.0)]\n"
            + "[(Name: name6) (Year: 2000) (Cost: $22.0)]\n"
            + "[(Name: name7) (Year: 2010) (Cost: $22.0)]")) {
      return false;
    }
    if (gallery.addArtwork(art7)) {
      return false;
    }
    if (gallery.size() != 7) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * This method checks mainly for the correctness of the ArtworkGallery.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ArtworkGallery. Then, check
   * that calling the lookup() method on an empty ArtworkGallery returns false. (2) Consider a
   * ArtworkGallery of height 3 which lookup at least 5 artwork. Then, try to call lookup() method
   * to search for the artwork having a match at the root of the tree. (3) Then, search for a
   * artwork at the right and left subtrees at different levels considering successful and
   * unsuccessful search operations. Make sure that the lookup() method returns the expected output
   * for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    // TODO complete the implementation of this method
    Artwork art1 = new Artwork("name1", 1099, 10);
    Artwork art2 = new Artwork("name2", 1289, 15);
    Artwork art3 = new Artwork("name3", 1799, 20);
    Artwork art4 = new Artwork("name4", 1800, 22);
    Artwork art5 = new Artwork("name5", 1900, 22);
    Artwork art6 = new Artwork("name6", 2000, 22);
    ArtGallery gallery = new ArtGallery();
    if (gallery.lookup("name1", 1099, 10)) {
      return false;
    }
    gallery.addArtwork(art3);
    gallery.addArtwork(art2);
    gallery.addArtwork(art1);
    gallery.addArtwork(art5);
    gallery.addArtwork(art4);
    gallery.addArtwork(art6);
    if (!gallery.lookup("name1", 1099, 10)) {
      return false;
    }
    if (!gallery.lookup("name2", 1289, 15)) {
      return false;
    }
    if (!gallery.lookup("name3", 1799, 20)) {
      return false;
    }
    if (!gallery.lookup("name4", 1800, 22)) {
      return false;
    }
    if (!gallery.lookup("name5", 1900, 22)) {
      return false;
    }
    if (!gallery.lookup("name6", 2000, 22)) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty artwork tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ArtworkGallery with the following structure for instance, is 4. 
   *               (*) 
   *              /  \ 
   *            (*)  (*) 
   *             \   / \ 
   *            (*) (*) (*) 
   *                    / 
   *                   (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    // TODO complete the implementation of this method
    Artwork art1 = new Artwork("name1", 1099, 10);
    Artwork art2 = new Artwork("name2", 1289, 15);
    Artwork art3 = new Artwork("name3", 1799, 20);
    Artwork art4 = new Artwork("name4", 1800, 22);
    Artwork art5 = new Artwork("name5", 1900, 22);
    Artwork art6 = new Artwork("name6", 2000, 22);
    Artwork art7 = new Artwork("name7", 2010, 22);
    ArtGallery gallery = new ArtGallery();
    if(gallery.height() != 0) {
      return false;
    }
    gallery.addArtwork(art3);
    if(gallery.height() != 1) {
      return false;
    }
    gallery.addArtwork(art2);
    gallery.addArtwork(art1);
    gallery.addArtwork(art5);
    gallery.addArtwork(art4);
    gallery.addArtwork(art7);
    gallery.addArtwork(art6);
    if (gallery.height() != 4) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.getBestArtwork() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestArtwork() {
    // TODO complete the implementation of this method
    Artwork art1 = new Artwork("name1", 1099, 10);
    Artwork art2 = new Artwork("name2", 1289, 15);
    Artwork art3 = new Artwork("name3", 1799, 20);
    Artwork art4 = new Artwork("name4", 1800, 22);
    Artwork art5 = new Artwork("name5", 1900, 22);
    Artwork art6 = new Artwork("name6", 2000, 22);
    Artwork art7 = new Artwork("name7", 2010, 22);
    ArtGallery gallery = new ArtGallery();
    if (gallery.getBestArtwork() != null) {
      return false;
    }
    gallery.addArtwork(art3);
    if (!gallery.getBestArtwork().equals(art3)) {
      return false;
    }
    gallery.addArtwork(art2);
    gallery.addArtwork(art1);
    gallery.addArtwork(art5);
    gallery.addArtwork(art4);
    gallery.addArtwork(art7);
    gallery.addArtwork(art6);
    if (!gallery.getBestArtwork().equals(art7)) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }


  /**
   * Checks for the correctness of ArtworkGallery.lookupAll() method. This test must consider at
   * least 3 test scenarios. (1) Ensures that the ArtworkGallery.lookupAll() method returns an
   * empty arraylist when called on an empty tree. (2) Ensures that the
   * ArtworkGallery.lookupAll() method returns an array list which contains all the artwork satisfying
   * the search criteria of year and cost, when called on a non empty artwork tree with one match,
   * and two matches and more. Vary your search criteria such that the lookupAll() method must check
   * in left and right subtrees. (3) Ensures that the ArtworkGallery.lookupAll() method returns an
   * empty arraylist when called on a non-empty artwork tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupAll() {
    // TODO complete the implementation of this method
    ArrayList<Artwork> test = new ArrayList<Artwork>();
    Artwork art1 = new Artwork("name1", 1099, 10);
    Artwork art2 = new Artwork("name2", 1289, 15);
    Artwork art3 = new Artwork("name3", 1799, 20);
    Artwork art4 = new Artwork("name4", 2000, 2);
    Artwork art5 = new Artwork("name5", 2000, 10);
    Artwork art6 = new Artwork("name6", 2000, 202);
    Artwork art7 = new Artwork("name7", 2000, 2200);
    ArtGallery gallery = new ArtGallery();
    if (gallery.lookupAll(2000, 39).size() != 0) {
      return false;
    }
    gallery.addArtwork(art3);
    gallery.addArtwork(art2);
    gallery.addArtwork(art1);
    gallery.addArtwork(art5);
    gallery.addArtwork(art4);
    gallery.addArtwork(art7);
    gallery.addArtwork(art6);
    test = gallery.lookupAll(2000, 15);
    if(test.size() != 2) {
      return false;
    }
    if (!test.contains(art4) || !test.contains(art5)) {
      return false;
    }
    test = gallery.lookupAll(2000, 3000);
    if (test.size() != 4) {
      return false;
    }
    if (!test.contains(art6) || !test.contains(art7)) {
      return false;
    }
    if (gallery.lookupAll(1500, 100).size() != 0) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.buyArtwork() method. This test must consider at
   * least 3 test scenarios. (1) Buying artwork that is at leaf node (2) Buying artwork at non-leaf
   * node (3) ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException
   * when called on an artwork that is not present in the BST
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBuyArtwork() {
    try {
      Artwork art1 = new Artwork("name1", 1099, 10);
      Artwork art2 = new Artwork("name2", 1289, 15);
      Artwork art3 = new Artwork("name3", 1799, 20);
      Artwork art4 = new Artwork("name4", 2000, 2);
      Artwork art5 = new Artwork("name5", 2000, 10);
      Artwork art6 = new Artwork("name6", 2000, 202);
      Artwork art7 = new Artwork("name7", 2000, 2200);
      ArtGallery gallery = new ArtGallery();
      gallery.addArtwork(art3);
      gallery.addArtwork(art2);
      gallery.addArtwork(art1);
      gallery.addArtwork(art5);
      gallery.addArtwork(art4);
      gallery.addArtwork(art7);
      gallery.addArtwork(art6);
      gallery.buyArtwork("name6", 2000, 202);
      if (gallery.size() != 6 || gallery.lookup("name6", 2000, 202)) {
        return false;
      }
      gallery.buyArtwork("name2", 1289, 15);
      if (gallery.size() != 5 || gallery.lookup("name2", 1289, 15)) {
        return false;
      }
      gallery.buyArtwork("name1", 1099, 10);
      if (gallery.size() != 4 || gallery.lookup("name1", 1099, 10)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    try {
      Artwork art1 = new Artwork("name1", 1099, 10);
      Artwork art2 = new Artwork("name2", 1289, 15);
      Artwork art3 = new Artwork("name3", 1799, 20);
      ArtGallery gallery = new ArtGallery();
      gallery.addArtwork(art3);
      gallery.addArtwork(art2);
      gallery.addArtwork(art1);
      gallery.buyArtwork("fake", 2011, 100000000);
    } catch (NoSuchElementException e) {
      return true;
    } catch (Exception e) {
      return false;
    }
    // TODO complete the implementation of this method
    return false; // Default return statement added to resolve compiler errors
  }

  /**
   * Returns false if any of the tester methods defined in this tester class fails.
   * 
   * @return false if any of the tester methods defined in this tester class fails, and true if all
   *         tests pass
   */
  public static boolean runAllTests() {
    // TODO complete the implementation of this method
    if (!testArtworkCompareToEquals() || !testAddArtworkToStringSize() || !testLookup() || 
        !testHeight() || !testGetBestArtwork() || !testLookupAll() || !testBuyArtwork()) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testArworkCompareToEquals(): " + testArtworkCompareToEquals());
    System.out.println("testAddArtworkToStringSize(): " + testAddArtworkToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestArtwork(): " + testGetBestArtwork());
    System.out.println("testLookupAll(): " + testLookupAll());
    System.out.println("testBuyArtwork(): " + testBuyArtwork());
    System.out.println("runAllTests(): " + runAllTests());
  }

}
