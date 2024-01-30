// --== CS400 File Header Information ==--
// Name: August Bambenek
// Email: abambenek@wisc.edu
// Team: AY
// TA: Callie Kim
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;

/**
 * A collection of junit Test methods on the NavigationGraph class
 */
public class AlgorithmEngineerTests {
	
	NavigationGraph<String, Double> graph; //graph used for every test
	
	/**
     * Instantiate graph with an the undirected graph from lecture
     */
    @BeforeEach
    public void createGraph() {
    	graph = new NavigationGraph<String, Double>();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");
		graph.insertVertex("G");
		graph.insertVertex("H");
		graph.insertEdge("A", "H", 1.0);
		graph.insertEdge("A", "C", 6.0);
		graph.insertEdge("A", "F", 7.0);
		graph.insertEdge("B", "C", 3.0);
		graph.insertEdge("B", "D", 2.0);
		graph.insertEdge("C", "G", 5.0);
		graph.insertEdge("D", "E", 2.0);
		graph.insertEdge("D", "F", 3.0);
		graph.insertEdge("E", "F", 1.0);
		graph.insertEdge("E", "G", 4.0);
    }
	
    /**
     * Tests to make sure the shortest path has the proper cost
     */
	@Test
	public void test1() {
		assertEquals(graph.getPathCost("H", "E"), 9.0);
	}
	
	/**
	 * Tests to make sure the shortest path visits the proper vertices
	 */
	@Test
	public void test2() {
		assertEquals(graph.shortestPath("G", "H").toString(), "[G, C, A, H]");
	}
	
	/**
	 * Tests to make sure the graph throws a NoSuchElementException when a vertex is
	 * removed, making another vertex impossible to reach
	 */
	@Test
	public void test3() {
		graph.removeVertex("A");
		assertThrows(NoSuchElementException.class, () -> graph.shortestPath("C", "H"));
	}
	
	/**
	 * Tests to make sure the undirected graph removes nodes in both directions
	 */
	@Test
	public void test4() {
		graph.removeEdge("D", "B");
		assertTrue(!graph.containsEdge("B", "D"));
	}
	
	/**
	 * Tests to make sure the getNodes() method returns the correct list of Vertices
	 */
	@Test
	public void test5() {
		LinkedList<String> vertices = new LinkedList<String>();
		vertices.add("A");
		vertices.add("B");
		vertices.add("C");
		vertices.add("D");
		vertices.add("E");
		vertices.add("F");
		vertices.add("G");
		vertices.add("H");
		for(String s : graph.getNodes()) {
			//remove string from list if it matches one in getNodes()
			if(vertices.contains(s)) {
				vertices.remove(s);
			}
		}
		//assert that the list is empty, meaning that it exactly matched getNodes()
		assertTrue(vertices.isEmpty());
	}
}
