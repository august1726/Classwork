// --== CS400 Fall 2022 File Header Information ==--
// Name: August Bambenek
// Email: abambenek@wisc.edu
// Team: AY
// TA: Callie Kim
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

/**
 * A set of JUnit tests for the class SoccerTeamBackend
 * 
 * @author August Bambenek
 */
public class BackendDeveloperTests {
	
	/**
	 * Tests the functionality of reseting a filter after it is set
	 */
	@Test
	public void test1() {
		SoccerTeamBackend backend = new SoccerTeamBackend();
		backend.setMarketValueLowerBoundFilter("100");
		backend.resetLowerBoundMarketValueFilter();
		assertEquals(backend.getMarketValueLowerBoundFilter(), null);
	}
	
	/**
	 * Tests functionality of getNumberofPlayers() after adding 3 players
	 */
	@Test
	public void test2() {
		SoccerTeamBackend backend = new SoccerTeamBackend();
		IPlayer player1 = new Player1BD();
		IPlayer player2 = new Player2BD();
		IPlayer player3 = new Player3BD();
		backend.addPlayer(player1);
		backend.addPlayer(player2);
		backend.addPlayer(player3);
		assertEquals(backend.getNumberOfPlayers(), 3);
	}
	
	/**
	 * Tests functionality of listPlayers when no filters are set
	 */
	@Test
	public void test3() {
		SoccerTeamBackend backend = new SoccerTeamBackend();
		IPlayer player1 = new Player1BD();
		IPlayer player2 = new Player2BD();
		IPlayer player3 = new Player3BD();
		backend.addPlayer(player1);
		backend.addPlayer(player2);
		backend.addPlayer(player3);
		List<IPlayer> list = backend.ListPlayers();
		assertEquals(list.get(0).getName(), "Player1");
	}

	/**
	 * Tests functionality of listPlayers when filters are set to match one player only
	 */
	@Test
	public void test4() {
		SoccerTeamBackend backend = new SoccerTeamBackend();
		IPlayer player1 = new Player1BD();
		IPlayer player2 = new Player2BD();
		IPlayer player3 = new Player3BD();
		backend.addPlayer(player2);
		backend.addPlayer(player1);
		backend.addPlayer(player3);
		backend.setMarketValueLowerBoundFilter("2");
		backend.setMarketValueUpperBoundFilter("2");
		List<IPlayer> list = backend.ListPlayers();
		assertEquals(list.size(), 1);
	}

	/**
	 * Tests functionality of setting and getting rating filter
	 */
	@Test
	public void test5() {
		SoccerTeamBackend backend = new SoccerTeamBackend();
		backend.setRatingFilterUpperBound("88");
		assertEquals(backend.getUpperBoundRatingFilter(), 88);
	}
}
