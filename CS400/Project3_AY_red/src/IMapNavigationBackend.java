import java.util.ArrayList;
import java.util.List;

/**
 * This interface displays the methods needed to be implemented
 * by MapNavigationBackend in order for the user to filter
 * their search of nearby locations or check for the shortest
 * path to a defined location
 *
 * @author Tanay Nagar
 *
 */
public interface IMapNavigationBackend {
  public void setDistanceFilter(String dist);	//sets the distance from the building to display locations

  public void resetDistanceFilter();	//resets the distance from the building to display locations

  public double getDistanceFilter(); //gets the distance from the building to display locations

  public void setCurrLocation(String location);	//sets the current location

  public void resetCurrLocation();	//resets the current location

  public String getCurrLocation(); 	//gets the distance from the building to display locations

  public List<ILocation> displayNearbyBuildings();	//returns a list of locations that
  //can be reached from the current location

  public double shortestPath(ILocation building);		//returns the shortest distance to get from current location
  //to the building paased in

}
