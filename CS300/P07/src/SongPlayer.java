//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Song Player
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterable collection of songs. Songs can be played in the forward or 
 * reverse order.
 * 
 * @author August Bambenek
 */
public class SongPlayer implements java.lang.Iterable<Song>{
  private int size; //size of the list
  private LinkedNode<Song> head; //head of this doubly linked list
  private LinkedNode<Song> tail; //tail of this doubly linked list
  private boolean playingBackward; //true if this song player is reading the list backward
  
  /**
   * Creates a new instance of song player which contains zero songs and set by default to play 
   * songs in the forward direction. 
   */
  public SongPlayer() {
    size = 0;
    playingBackward = false;
  }
  
  /**
   * Adds a Song as Last Song
   * 
   * @param oneSong - the song that is going to be added to the tail of this doubly linked list of 
   * songs
   */
  public void addLast(Song oneSong) {
    LinkedNode<Song> newSong = new LinkedNode<Song>(tail, oneSong, null);
    size += 1;
    tail = newSong;
    if (size == 1) {
      head = newSong;
      return;
    }
    if (oneSong == null) {
      return;
    }
    tail.getPrev().setNext​(newSong);
  }
  
  /**
   * add Song as First Song
   * 
   * @param oneSong - the song that is going to be added to the head of this doubly linked list of 
   * songs
   * @throws NullPointerException with a descriptive error message if the passed oneSong is null
   */
  public void addFirst​(Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException("ERROR: song passed as input is null");
    }
    LinkedNode<Song> newSong = new LinkedNode<Song>(null, oneSong, head);
    size += 1;
    head = newSong;
    if (size == 1) {
      tail = newSong;
      return;
    }
    head.getNext().setPrev​(newSong);
  }
  
  /**
   * adds Song at a given position/order within this collection of songs
   * 
   * @param index - the given index where the new song will be added
   * @param oneSong - the song that is going to be added
   * @throws NullPointerException with a descriptive error message if the passed oneSong is null
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of 
   * the 0 .. size() range
   */
  public void add​(int index, Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException("ERROR: song passed as input is null");
    }
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("ERROR: index is out of bounds");
    }
    if (index == 0) {
      this.addFirst​(oneSong);
      return;
    }
    if (index == size) {
      this.addLast(oneSong);
      return;
    }
    LinkedNode<Song> temp = head.getNext();  
    for (int i = 0; i < index - 1; i++) {
      temp = temp.getNext();
    }
    LinkedNode<Song> newSong = new LinkedNode<Song>(temp.getPrev(), oneSong, temp);
    newSong.getPrev().setNext​(newSong);
    temp.setPrev​(newSong);
    size += 1;
  }
  
  /**
   * Returns the first Song in this list.
   * 
   * @return the Song at the head of this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song getFirst() {
    if (size == 0) {
      throw new NoSuchElementException("ERROR: List is empty");
    }
    return head.getData();
  }
  
  /**
   * Returns the last Song in this list.
   * 
   * @return the Song at the tail of this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song getLast() {
    if (size == 0) {
      throw new NoSuchElementException("ERROR: List is empty");
    }
    return tail.getData();
  }
  
  /**
   * Returns the song at the specified position in this list.
   * 
   * @param index - index of the song to return
   * @return the song at the specified position in this list
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of the 
   * 0 .. size()-1 range
   */
  public Song get​(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("ERROR: index is out of range");
    }
    if (index == 0) {
      return getFirst();
    }
    if (index == size - 1) {
      return getLast();
    }
    LinkedNode<Song> temp = head.getNext();
    for (int i = 0; i < index - 1; i++) {
      temp = temp.getNext();
    }
    return temp.getData();
  }
  
  /**
   * Removes and returns the first song from this list.
   * 
   * @return the first song from this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException("ERROR: List is empty");
    }
    if (size == 1) {
      LinkedNode<Song> temp = head;
      clear();
      return temp.getData();
    }
    LinkedNode<Song> temp = head;
    head = head.getNext();
    head.setPrev​(null);
    size -= 1;
    return temp.getData();
  }
  
  /**
   * Removes and returns the last song from this list.
   * 
   * @return the last song from this list
   * @throws NoSuchElementException with a descriptive error message if this list is empty
   */
  public Song removeLast() {
    if (size == 0) {
      throw new NoSuchElementException("ERROR: List is empty");
    }
    if (size == 1) {
      LinkedNode<Song> temp = tail;
      clear();
      return temp.getData();
    }
    LinkedNode<Song> temp = tail;
    tail = tail.getPrev();
    tail.setNext​(null);
    size -= 1;
    return temp.getData();
  }
  
  /**
   * Removes the song at the specified position in this list and returns the song that was removed 
   * from the list. The order of precedence of the other songs in the list should not be modified.
   * 
   * @param index - the index of the song to be removed
   * @return the song previously at the specified position
   * @throws IndexOutOfBoundsException with a descriptive error message if index is out of 
   * the 0 .. size()-1 range
   */
  public Song remove​(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("ERROR: index is out of range");
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == size - 1) {
      return removeLast();
    }
    LinkedNode<Song> temp = head.getNext();
    for (int i = 0; i < index - 1; i++) {
      temp = temp.getNext();
    }
    temp.getNext().setPrev​(temp.getPrev());
    temp.getPrev().setNext​(temp.getNext());
    size -= 1;
    return temp.getData();
  }
  
  /**
   * Returns true if this list contains a match with the specified song. More formally, returns 
   * true if and only if this list contains at least one song e such that Objects.equals(o, e).
   * 
   * @param o - song whose presence in this list is to be tested
   * @return true if this list contains the specified song
   */
  public boolean contains​(Song o) {
    LinkedNode<Song> temp = head;
    while (temp != null) {
      if (temp.getData().equals(o)) {
        return true;
      }
      temp = temp.getNext();
    }
    return false;
  }
  
  /**
   * Removes all of the songs from this list. The list will be empty after this call returns.
   */
  public void clear() {
    size = 0;
    head = null;
    tail = null;
  }
  
  /**
   * Returns true if this list is empty.
   * 
   * @return true if this list is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }
  
  /**
   * Returns the number of songs in this list.
   * 
   * @return the number of songs in this list
   */
  public int size() {
    return size;
  }
  
  /**
   * Returns an iterator to iterate through the songs in this list with respect to current playing 
   * direction of this song player (either in the forward or in the backward direction)
   * 
   * @return an Iterator to traverse the list of songs in this SongPlayer with respect to the 
   * current playing direction specified by the playingBackward data field.
   */
  public Iterator<Song> iterator() {
    if (playingBackward) {
      return new BackwardSongIterator(tail);
    }
    return new ForwardSongIterator(head);
  }
  
  /**
   * Mutator of the playingDirection of this song player. 
   * It switches the playing direction by setting playingBackward to its opposite value.
   */
  public void switchPlayingDirection() {
    playingBackward = playingBackward == false;
  }
  
  /**
   * Plays the songs in this song player in the current playing direction. 
   * This method MUST be implemented using an enhanced for-each loop.
   * 
   * @return a String representation of the songs in this song player. String representations of 
   * each song are separated by a newline. If this song player is empty, this method returns an 
   * empty string.
   */
  public String play() {
    String str = "";
    for (Iterator<Song> iter = iterator(); iter.hasNext();) {
      str = str.concat(iter.next().toString() + "\n");
    }
    return str.substring(0, str.length()- 1);
  }
  
}
