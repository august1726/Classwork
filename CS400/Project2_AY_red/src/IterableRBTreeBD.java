// --== CS400 Fall 2022 File Header Information ==--
// Name: August Bambenek
// Email: abambenek@wisc.edu
// Team: AY
// TA: Callie Kim
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * Placeholder method for IterableRBTree
 * 
 * @author August Bambenek
 */
public class IterableRBTreeBD implements IterableRBTreeADT<IPlayer>{

	List<IPlayer> players;
	Iterator<IPlayer> iter;
	
	public IterableRBTreeBD() {
		players = new ArrayList<IPlayer>();
		players.add(new Player1BD());
		players.add(new Player2BD());
		players.add(new Player3BD());
		iter = players.iterator();
	}
	
	
	@Override
	public boolean hasNext() {
		return iter.hasNext();
	}

	@Override
	public IPlayer next() {
		return iter.next();
	}

	@Override
	public boolean insert(IPlayer node) {
		return true;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 3;
	}
	

}
