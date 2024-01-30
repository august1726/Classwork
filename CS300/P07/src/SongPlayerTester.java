//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Song Player Tester
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

import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 *
 * @author August Bambenek
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method,
   * overridden method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    Song song1 = new Song("Song", "Artist", "1:00");
    Song song2 = new Song("Song", "Artist", "1:00");
    if (!song1.equals(song2)) {
      System.out.println("testSong equals() failed");
      return false;
    }
    if (!song1.toString().equals("Song---Artist---1:00")) {
      System.out.println("testSong toString() failed");
      return false;
    }
    if (!song1.getArtist().equals("Artist")) {
      System.out.println("testSong getArtist() failed");
      return false;
    }
    if (!song1.getSongName().equals("Song")) {
      System.out.println("testSong getSongName() equfailed");
      return false;
    }
    if (!song1.getDuration().equals("1:00")) {
      System.out.println("testSong getDuration() failed");
      return false;
    }
    try {
      Song song3 = new Song(null, null, "");
      System.out.println("testSong failed to throw IllegalArgumentException");
      return false;
    } catch (IllegalArgumentException e){
      
    }
    try {
      Song song4 = new Song("Song", "Artist", "99:99");
      System.out.println("testSong failed to throw IllegalArgumentException");
      return false;
    } catch (IllegalArgumentException e) {
      return true;
    }
  }
  
  /**
   * This method test and make use of the LinkedNode constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {
    LinkedNode<String> str1 = new LinkedNode<String>(null, "one", null);
    LinkedNode<String> str2 = new LinkedNode<String>(str1, "two", null);
    str1.setNext​(str2);
    LinkedNode<String> str3 = new LinkedNode<String>(str2, "three", null);
    str2.setNext​(str3);
    if (!str2.getPrev().getData().equals("one")) {
      System.out.println("testLinkedNode getPrev() failed");
      return false;
    }
    if (!str2.getNext().getData().equals("three")) {
      System.out.println("testLinkedNode getNext() failed");
      return false;
    }
    if (!str2.getData().equals("two")) {
      System.out.println("testLinkedNode getData() failed");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {
    Song song1 = new Song("Roundabout", "Yes", "8:10");
    Song song2 = new Song("Song 2", "Blur", "2:22");
    Song song3 = new Song("Runaway","Kanye West","9:10");
    Song song4 = new Song("Despacito","Despacito Guy","4:21");
    SongPlayer player = new SongPlayer();
    player.addFirst​(song3);
    player.addLast(song4);
    player.addFirst​(song1);
    player.add​(1, song2);
    if (!player.getFirst().equals(song1)) {
      System.out.println("testSongPlayerAdd failed");
      return false;
    }
    if (!player.getLast().equals(song4)) {
      System.out.println("testSongPlayerAdd failed");
      return false;
    }
    try {
      player.add​(0, null);
      System.out.println("testSongPlayerAdd failed to throw NullPointerException");
      return false;
    } catch (NullPointerException e) {
      
    }
    Song song5 = new Song("Requiem in D Minor", "Wolfgang Amadeus Mozart", "55:15");
    try {
      player.add​(25, song5);
    } catch (IndexOutOfBoundsException e) {
      return true;
    }
    System.out.println("testSongPlayerAdd failed to throw IndexOutOfBoundsException");
    return false;
  }
  
  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {
    Song song1 = new Song("Roundabout", "Yes", "8:10");
    Song song2 = new Song("Song 2", "Blur", "2:22");
    Song song3 = new Song("Runaway","Kanye West","9:10");
    Song song4 = new Song("Despacito","Despacito Guy","4:21");
    SongPlayer player = new SongPlayer();
    player.addFirst​(song3);
    player.addLast(song4);
    player.addFirst​(song1);
    player.add​(1, song2);
    if (!player.getFirst().equals(song1)) {
      System.out.println("testSongPlayerGet getFirst() failed");
      return false;
    }
    if (!player.getLast().equals(song4)) {
      System.out.println("testSongPlayerGet getLast() failed");
      return false;
    }
    if (!player.get​(1).equals(song2)) {
      System.out.println("testSongPlayerGet get() failed");
      return false;
    }
    try {
      player.get​(22);
    } catch (IndexOutOfBoundsException e) {
      return true;
    }
    System.out.println("testSongPlayerGet failed to throw IndexOutOfBoundsException");
    return false;
  }
  
  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {
    Song song1 = new Song("Roundabout", "Yes", "8:10");
    Song song2 = new Song("Song 2", "Blur", "2:22");
    Song song3 = new Song("Runaway","Kanye West","9:10");
    Song song4 = new Song("Despacito","Despacito Guy","4:21");
    SongPlayer player = new SongPlayer();
    player.addFirst​(song3);
    player.addLast(song4);
    player.addFirst​(song1);
    player.add​(1, song2);
    player.remove​(2);
    player.removeFirst();
    player.removeLast();
    try {
      player.remove​(2);
      System.out.println("testSongPlayerRemove failed to throw IndexOutOfBoundsException");
      return false;
    } catch (IndexOutOfBoundsException e) {
      
    }
    if (player.size() != 1 || !player.contains​(song2)) {
      System.out.println("testSongPlayerRemove failed");
      return false;
    }
    player.remove​(0);
    if (!player.isEmpty()) {
      System.out.println("testSongPlayerRemove failed to empty SongPlayer");
      return false;
    }
    try {
      player.removeFirst();
    } catch (NoSuchElementException e) {
      return true;
    }
    System.out.println("testSongPlayerRemove failed to throw NoSuchElementException when empty");
    return false;
  }
 
  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and String play()
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {
    Song song3 = new Song("Runaway","Kanye West","9:10");
    Song song4 = new Song("Despacito","Despacito Guy","4:21");
    SongPlayer player = new SongPlayer();
    player.addFirst​(song3);
    player.addLast(song4);
    if (!(player.iterator() instanceof ForwardSongIterator)) {
      System.out.println("testSongPlayerIterator failed to create the correct iterator");
      return false;
    }
    if (!player.play().equals("Runaway---Kanye West---9:10\nDespacito---Despacito Guy---4:21")) {
      System.out.println("testSongPlayerIterator failed in the forward direction");
      return false;
    }
    player.switchPlayingDirection();
    if (!player.play().equals("Despacito---Despacito Guy---4:21\nRunaway---Kanye West---9:10")) {
      System.out.println("testSongPlayerIterator failed in the backward direction");
      return false;
    }
    return true;
  }
  
  /**
   * This method checks for the correctness of contains(Object song), clear(),
   * isEmpty()and size() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {
    Song song1 = new Song("Roundabout", "Yes", "8:10");
    Song song2 = new Song("Song 2", "Blur", "2:22");
    Song song3 = new Song("Runaway","Kanye West","9:10");
    Song song4 = new Song("Despacito","Despacito Guy","4:21");
    SongPlayer player = new SongPlayer();
    player.addFirst​(song3);
    player.addLast(song4);
    player.addFirst​(song1);
    player.add​(1, song2);
    if (player.isEmpty()) {
      System.out.println("testSongPlayerCommonMethod isEmpty() failed");
      return false;
    }
    if (player.size() != 4) {
      System.out.println("testSongPlayerCommonMethod size() failed");
      return false;
    }
    player.clear();
    if (!player.isEmpty()) {
      System.out.println("testSongPlayerCommonMethod clear() failed");
      return false;
    }
    if (player.size() != 0) {
      System.out.println("testSongPlayerCommonMethod clear() failed");
      return false;
    }
    return true;
  }
  
  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {
    Song song1 = new Song("Roundabout", "Yes", "8:10");
    Song song2 = new Song("Song 2", "Blur", "2:22");
    LinkedNode<Song> link1 = new LinkedNode<Song>(null, song1, null);
    LinkedNode<Song> link2 = new LinkedNode<Song>(link1, song2, null);
    link1.setNext​(link2);
    ForwardSongIterator iter = new ForwardSongIterator(link1);
    if (!iter.next().equals(song1)) {
      System.out.println("testForwardSongIterator failed to iterate");
      return false;
    }
    if (!iter.next().equals(song2)) {
      System.out.println("testForwardSongIterator failed to iterate");
      return false;
    }
    try {
      iter.next();
    } catch (NoSuchElementException e) {
      return true;
    }
    System.out.println("testForwardSongIterator failed to throw NoSuchElementException");
    return false;
  }
  
  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {
    Song song1 = new Song("Roundabout", "Yes", "8:10");
    Song song2 = new Song("Song 2", "Blur", "2:22");
    LinkedNode<Song> link1 = new LinkedNode<Song>(null, song1, null);
    LinkedNode<Song> link2 = new LinkedNode<Song>(link1, song2, null);
    link1.setNext​(link2);
    BackwardSongIterator iter = new BackwardSongIterator(link2);
    if (!iter.next().equals(song2)) {
      System.out.println("testBackwardsSongIterator failed to iterate");
      return false;
    }
    if (!iter.next().equals(song1)) {
      System.out.println("testBackwardsSongIterator failed to iterate");
      return false;
    }
    try {
      iter.next();
    } catch (NoSuchElementException e) {
      return true;
    }
    System.out.println("testBackwardsSongIterator failed to throw NoSuchElementException");
    return false;
  }

  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    if (!testSong() || !testLinkedNode() || !testSongPlayerAdd() || !testSongPlayerRemove() || 
        !testSongPlayerIterator() || !testSongPlayerCommonMethod() || !testForwardSongIterator() || 
        !testBackwardSongIterator()) {
      return false;
    }
    return true;
  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println("testSong(): " + testSong());
    System.out.println("testLinkedNode(): " + testLinkedNode());
    System.out.println("testSongPlayerAdd(): " + testSongPlayerAdd());
    System.out.println("testSongPlayerRemove(): " + testSongPlayerRemove());
    System.out.println("testSongPlayerIterator(): " + testSongPlayerIterator());
    System.out.println("testSongPlayerCommonMethod(): " + testSongPlayerCommonMethod());
    System.out.println("testForwardSongIterator(): " + testForwardSongIterator());
    System.out.println("testBackwardSongIterator(): " + testBackwardSongIterator());
    System.out.println("runAllTests(): " + runAllTests());
  }
}