import java.io.FileNotFoundException;
import java.util.List;

/**
 * Instances of this interface can be used to load book data from a DOT file.
 */
public interface IMapLoader {

  /**
   * This method loads locations from a DOT file.
   * 
   * @param filepathToDOT path to the DOT file relative to the executable
   * @return a list of location objects
   * @throws FileNotFoundException
   */
  List<ILocation> loadMap(String filepathToDOT) throws FileNotFoundException;

}
