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
 * This class models the Bike data type.
 * 
 * NOTES: 
 * You may NOT add any additional data fields to this class NOT specified in the TODO tags.
 * You may NOT add any additional methods to this class whether private or public. 
 * You may NOT need to implement any tester for this class.
 * 
 */
public class Bike {
  // TODO
  // 1. Declare a private instance field of type int named cyclingCadence
  private int cyclingCadence;
  // 2. Declare a private instance field of type int named speed
  private int speed;
  // 3. Declare a protected static data field of type int named bikeCount initialized to zero
  protected static int bikeCount = 0;
  // bikeCount represents the total number of Bike objects created by the constructor of this class


  /**
   * Creates a new Bike with a given cyclingCadence and speed. We assume that the provided values of
   * cyclingCadence and speed are VALID.
   * 
   * @param cyclingCadence cadence to be assigned to this bike
   * @param speed          speed to be assigned to this bike
   */
  public Bike(int cyclingCadence, int speed) {
    // TODO
    // 4. Set the instance data fields to the provided input parameters
    this.cyclingCadence = cyclingCadence;
    this.speed = speed;

    // 5. Increments the total number of created Bike objects
    bikeCount += 1;
  }

  // MAKE SURE TO SAVE YOUR SOURCE FILE (Ctrl/Cmd + S) before submitting it to Gradescope

  /**
   * Gets the speed of this bike
   * 
   * @return the speed of this bike
   */
  public int getSpeed() {
    // TODO:
    // 6. Complete the implementation of this accessor

    return this.speed; // default return statement added to avoid compiler errors
  }

  /**
   * Reduces the speed of this bike object by the amount passed as input. We assume that amount is
   * positive (VALID)
   * 
   * @param amount decrement amount by which to reduce the speed of this Bike object
   */
  public void brake(int amount) {
    // TODO
    // 7. Complete the implementation of this mutator
    this.speed -= amount;
  }


  /**
   * Returns a string representation of this bike. The returned string must have the following
   * format: "bike " + speed + " @ " + cadence + "rpm"
   * 
   * @Return a String representation of this bike
   */
  @Override
  public String toString() {
    // TODO
    // 8. Implement this method

    return "bike " + this.speed + " @ " + this.cyclingCadence + "rpm"; 
  }

}

