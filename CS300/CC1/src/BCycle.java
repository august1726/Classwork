///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: August Bambenek
// Campus ID: 9083041492
// WiscEmail: abambenek@wisc.edu
// (TODO: fill this out)
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//
// BE CAREFUL!! This file contains TWO classes. You will need to complete the
// implementation of BOTH classes with respect to the provided requirements
// in the TODO tags for full credit.
//
// When creating new exception objects, including messages within these objects 
// is optional.
////////////////////////////////////////////////////////////////////////////////

/**
 * This class models the BCycle data type representing rental bikes 
 * 
 * NOTES: 
 * You may NOT add any additional data fields to this class NOT specified in the TODO tags. 
 * You may NOT add any additional methods to this class whether private or public 
 * You may NOT need to implement any tester for this class
 *
 */
class BCycle extends Bike/* TODO: 9. set the class BCycle to be a subclass of the super class Bike */ {

  private int id; // identifier of this bike
  private boolean isCheckedOut; // true when this bike is checked out, false otherwise
  

  /**
   * Creates a new BCycle with a given cycling cadence, speed, and id. When created, the BCycle
   * object is NOT checked out. We assume that all the input arguments passed as input are VALID.
   * 
   * @param cyclingCadence the cycling cadence to be assigned to this bCycle
   * @param speed          the speed to be assigned to this bCycle
   * @param id             the identifier to be assigned to this bCycle
   */
  public BCycle(int cyclingCadence, int speed, int id) {
    // TODO:
    // 10. call the constructor of the super class with the passed cyclingCadence and speed as
    // input)
    super(cyclingCadence, speed);
    // 11. Set the id of this bCycle to the id passed as input to this constructor
    this.id = id;
    // 12. Set the isCheckedOut to false (optional since the default value of a boolean is false)
    this.isCheckedOut = false;
  }

  // You are NOT allowed to add any additional methods to this class

  /**
   * Changes the state of this BCycle object to reflect that it has been checked back in by setting 
   * its isCheckedOut data field to false.
   * 
   * @throws IllegalStateException when called on a bike that is NOT checked out.
   */
  public void checkin() throws IllegalStateException {
    // TODO:
    // 13. Complete the implementation of this method
    if (this.isCheckedOut == false) {
      throw new IllegalStateException("ERROR: this bike wasn't checked out");
    }
    this.isCheckedOut = false;
  }

  /**
   * Changes the state of this BCycle to reflect that it has been checked out.
   * 
   * @throws IllegalStateException when called on a bike that is already checked out.
   */
  public void checkout() throws IllegalStateException {
    // TODO:
    // 14. Complete the implementation of this method
    if (this.isCheckedOut == true) {
      throw new IllegalStateException("ERROR: this bike is already checked out");
    }
    this.isCheckedOut = true;
  }

  /**
   * Returns a string representation of this BCycle object. The returned string must have the
   * following format: 
   *   "bike " speed + " @ " + cadence + "rpm, " + id + " (checked out: " + isCheckedOut + ")"
   * 
   * @Return a String representation of this BCycle object
   */
  @Override
  public String toString() {
    // TODO:
    // 15. Complete the implementation of this method. Notice carefully that the cyclingCadence
    // is a private data field with no getter method defined in the super class Bike. 
    // Think of using the toString() method implemented in the super class Bike

    return super.toString() + ", " + this.id + " (checked out: " + this.isCheckedOut + ")"; 
  }

  // MAKE SURE TO SAVE YOUR SOURCE FILE (Ctrl/Cmd + S) before submitting it to Gradescope

}
