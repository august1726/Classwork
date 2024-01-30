//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fountain
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

import java.util.Random;
import java.io.File;
import processing.core.PImage;

/**
 * A program that creates an image of a fountain with animated water droplets coming out of it
 * 
 * @author August Bambenek
 */
public class Fountain {
  
  private static Random randGen;
  private static PImage fountainImage;
  private static int positionX;
  private static int positionY;
  private static Droplet[] droplets;
  private static int startColor; // blue: Utility.color(23,141,235)
  private static int endColor; // lighter blue: Utility.color(23,200,255)
  
  /**
   * The main method
   * 
   * @param args - unused
   */
  public static void main(String[] args) {
    Utility.runApplication(); // starts the application
  }
  
  /**
   * Runs test methods and initializes the static variables
   */
  public static void setup() {
    System.out.println("testUpdateDroplet(): " + testUpdateDroplet());
    System.out.println("testRemoveOldDroplets(): " + testRemoveOldDroplets());
    startColor = Utility.color(23,141,235);
    endColor = Utility.color(23,200,255);
    randGen = new Random();
    positionX = Utility.width()/2;
    positionY = Utility.height()/2;
    // load the image of the fountain
    fountainImage = Utility.loadImage("images" + File.separator + "fountain.png");
    droplets = new Droplet[800];
  }
  
  /**
   * Draws the background, the image of the fountain, and the droplets
   */
  public static void draw() {
    Utility.background(Utility.color(253,245,230));
    // Draw the fountain image to the screen at position (positionX, positionY)
    Utility.image(fountainImage, positionX, positionY);
    createNewDroplets(10);
    for (int i = 0; i < droplets.length; i++) {
      updateDroplet(i);
    }
    removeOldDroplets(80);
  }
  
  /**
   * Updates the position, velocity, and age of the droplet at the specified index in the array as
   * long as the droplet at the index isn't null
   * 
   * @param index - the index of the droplet in the droplets array to update
   */
  public static void updateDroplet(int index) {
    if (droplets[index] != null) {
      Utility.circle(droplets[index].getPositionX(), droplets[index].getPositionY(), 
          droplets[index].getSize());
      droplets[index].setVelocityY(droplets[index].getVelocityY() + 0.3f);
      droplets[index].setPositionX(droplets[index].getPositionX() + droplets[index].getVelocityX());
      droplets[index].setPositionY(droplets[index].getPositionY() + droplets[index].getVelocityY());
      Utility.fill(droplets[index].getColor(), droplets[index].getTransparency());
      droplets[index].setAge(droplets[index].getAge() + 1);
    }
  }
  
  /**
   * Searches the droplets array for null references and creates an input number (numDroplets)
   * of Droplet objects in place of the null references. If numDroplets is greater than the number 
   * of null references in the droplets array, the method quits after creating droplets in all the 
   * spaces left
   * 
   * @param numDroplets - the number of droplets to create
   */
  public static void createNewDroplets(int numDroplets) {
    for (int i = 0; i < droplets.length; i++) {
      if (droplets[i] == null) {
        droplets[i] = new Droplet();
        droplets[i].setPositionX(positionX + randGen.nextFloat() * 6 - 3);
        droplets[i].setPositionY(positionY + randGen.nextFloat() * 6 - 3);
        droplets[i].setColor(Utility.lerpColor(startColor, endColor, randGen.nextFloat()));
        droplets[i].setTransparency(randGen.nextInt(96) + 32);
        droplets[i].setSize(randGen.nextFloat() * 7 + 4);
        droplets[i].setVelocityX(randGen.nextFloat() * 2 - 1);
        droplets[i].setVelocityY(randGen.nextFloat() * 5 - 15);
        droplets[i].setAge(randGen.nextInt(41));
        numDroplets -= 1;
        if (numDroplets <= 0) {
          return;
        }
      }
    }
  }
  
  /**
   * Sets Droplet objects in the droplets array to null if their age surpasses the maxAge input.
   * This removes them from the program and allows new droplets to take their place.
   * 
   * @param maxAge - the maximum age cutoff for droplets
   */
  public static void removeOldDroplets(int maxAge) {
    for(int i = 0; i < droplets.length; i++) {
      if (droplets[i] != null && droplets[i].getAge() > maxAge) {
        droplets[i] = null;
      }
    }
  }
  
  /**
   * moves the position of the fountain to where the mouse is pressed
   */
  public static void mousePressed() {
    positionX = Utility.mouseX();
    positionY = Utility.mouseY();
  }
  
  /**
   * Takes in a character representing a key that was pressed, and if the key pressed was lowercase
   * or uppercase 's', the program saves a screenshot of the fountain
   * 
   * @param keyPressed - the key that has been detected as being pressed
   */
  public static void keyPressed(char keyPressed) {
    if(keyPressed == 's' || keyPressed == 'S') {
      Utility.save("screenshot.png");
    }
  }
  
  /**
   * This tester initializes the droplets array to hold at least three droplets. Creates a single
   * droplet at position (3,3) with velocity (-1,-2). Then checks whether calling updateDroplet() on
   * this droplet’s index correctly results in changing its position to (2.0, 1.3).
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testUpdateDroplet() {
    droplets = new Droplet[3];
    droplets[0] = new Droplet();
    droplets[0].setPositionX(3);
    droplets[0].setPositionY(3);
    droplets[0].setVelocityX(-1);
    droplets[0].setVelocityY(-2);
    droplets[0].setAge(0);
    updateDroplet(0);
    if (droplets[0].getPositionX() - 2.0f > 0.001f || droplets[0].getPositionY() - 1.3f > 0.001f) {
      return false;
    }
    return true;
  }

  /**
   * This tester initializes the droplets array to hold at least three droplets. Calls
   * removeOldDroplets(6) on an array with three droplets (two of which have ages over six and
   * another that does not). Then checks whether the old droplets were removed and the young droplet
   * was left alone.
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testRemoveOldDroplets() {
    droplets = new Droplet[3];
    droplets[0] = new Droplet();
    droplets[1] = new Droplet();
    droplets[2] = new Droplet();
    droplets[0].setAge(1);
    droplets[1].setAge(7);
    droplets[2].setAge(35);
    removeOldDroplets(6);
    if(droplets[0] == null || droplets[1] != null || droplets[2] != null) {
      return false;
    }
    return true;
  }
}
