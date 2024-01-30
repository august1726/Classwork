public interface ILocation {

  /**
   * Return the name of the current location
   * 
   * @return name of the current location
   */
  public String getName();

  /**
   * Return the distance between the current location and destination
   * 
   * @param destination the place user wants to go from the current location
   * @return the distance between the current location and destination
   */
  public String getDistance(ILocation destination);


}
