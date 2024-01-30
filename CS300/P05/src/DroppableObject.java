//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Droppable Object
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
 * This class models a droppable object designed for the cs300 spring 2022 p05 Treasure Hunt
 * adventure style game application. It is a draggable object which triggers a next clue to appear
 * when dropped on a specific target.
 * 
 * @author August Bambenek
 */
public class DroppableObject extends DraggableObject {
  private InteractiveObject target; // target of this droppable object

  /**
   * Creates a new Droppable object with specific name, x and y positions, message, target, and sets
   * its next clue.
   * 
   * @param name     - name to be assigned to this droppable object
   * @param x        - x-position of this droppable object
   * @param y        - y-position this droppable object
   * @param message  - message to be assigned to this droppable object
   * @param target   - target where this droppable object should be dropped
   * @param nextClue - reference to an interactive object which will be activated when this
   *                 droppable object is dropped on its target.
   */
  public DroppableObject(java.lang.String name, int x, int y, java.lang.String message,
      InteractiveObject target, InteractiveObject nextClue) {
    super(name, x, y, message);
    this.target = target;
    this.setNextClue​(nextClue);
  }

  /**
   * Stops dragging this droppable object. Also, if this droppable object is over its target and the
   * target is activated, this method (1) deactivates both this object and its target, (2) activates
   * the next clue, and (3) prints the message of this draggable object to the console.
   */
  @Override
  public void mouseReleased() {
    if (super.isMouseOver()) {
      if (!processing.mousePressed) {
        super.stopDragging();
        if (isOver​(target) && target.isActive()) {
          this.deactivate();
          target.deactivate();
          this.activateNextClue();
          System.out.print(this.message());
        }
      }
    }
  }

  /**
   * Checks whether this object is over another interactive object.
   * 
   * @param other - reference to another iteractive object. We assume that other is NOT null.
   * @return - returns true if this droppable object and other overlap and false otherwise.
   */
  public boolean isOver​(InteractiveObject other) {
    if (this.getX() < other.getX() + other.image.width
        && this.getX() + this.image.width > other.getX()) {
      if (this.getY() < other.getY() + other.image.width
          && this.getY() + this.image.width > other.getY()) {
        return true;
      }
    }
    return false;
  }
}
