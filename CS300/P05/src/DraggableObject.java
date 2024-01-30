//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Draggable Object
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
 * This class models a draggable object. A draggable object is a clickable interactive object which
 * can follow the mouse moves when being dragged.
 * 
 * @author August Bambenek
 */
public class DraggableObject extends InteractiveObject {
  private boolean isDragging; // indicates whether this object is being dragged or not
  private int oldMouseX; // old x-position of the mouse
  private int oldMouseY; // old y-position of the mouse

  /**
   * Creates a new Draggable object with a given name, x and y position, and "Drag Me!" as a default
   * message. When created a new draggable object is NOT dragging.
   * 
   * @param name - name to be assigned to this draggable object
   * @param x    - x-position of this draggable object in the display window
   * @param y    - y-position of this draggable object in the display window
   */
  public DraggableObject(java.lang.String name, int x, int y) {
    super(name, x, y, "Drag Me!");
    isDragging = false;
  }

  /**
   * Creates a new Draggable object with a given name, x and y position, and a specific message.
   * When created a new draggable object is NOT dragging.
   * 
   * @param name    - name to be assigned to this draggable object
   * @param x       - x-position of this draggable object in the display window
   * @param y       - y-position of this draggable object in the display window
   * @param message - message to be displayed when this draggable object is clicked. We assume that
   *                message is VALID (meaning it is NOT null and NOT an empty string).
   */
  public DraggableObject(java.lang.String name, int x, int y, java.lang.String message) {
    super(name, x, y, message);
    isDragging = false;
  }

  /**
   * Checks whether this draggable object is being dragged.
   * 
   * @return returns true if this object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging this draggable object and updates the oldMouseX and oldMouseY positions to the
   * current position of the mouse.
   */
  public void startDragging() {
    isDragging = true;
    oldMouseX = processing.mouseX;
    oldMouseY = processing.mouseY;
  }

  /**
   * Stops dragging this draggable object
   */
  public void stopDragging() {
    isDragging = false;
  }

  /**
   * Draws this draggable object to the display window. If this object is dragging, this method sets
   * its position to follow the mouse moves. Then, it draws its image to the its current position.
   */
  @Override
  public void draw() {
    if (isDragging) {
      super.move(-(oldMouseX - processing.mouseX), -(oldMouseY - processing.mouseY));
      oldMouseX = processing.mouseX;
      oldMouseY = processing.mouseY;
    }
    super.draw();
  }

  /**
   * Starts dragging this object when it is clicked (meaning when the mouse is over it).
   */
  @Override
  public void mousePressed() {
    if (super.isMouseOver()) {
      if (processing.mousePressed) {
        startDragging();
      }
    }
  }

  /**
   * Stops dragging this object if the mouse is released
   */
  @Override
  public void mouseReleased() {
    if (super.isMouseOver()) {
      if (!processing.mousePressed) {
        stopDragging();
      }
    }
  }
}
