import java.util.List;

/**
 * This ADT represents an undirected graph data structure with positive edge weights.
 *
 * @param NodeType the data type stored at each graph vertex
 * @param EdgeType the data type stored at each graph edge as a Number whose doubleValue() method returns a value >=0.0
 */
public interface NavigationGraphADT<NodeType,EdgeType extends Number> extends GraphADT<NodeType,EdgeType> {
	
	/**
     * Returns a list of the data within each node for Backend Developer methods
     *
     * @return a list of the data stored in all nodes in the graph
     */
    public List<NodeType> getNodes(); 
}
