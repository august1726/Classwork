// --== CS400 Fall 2022 File Header Information ==--
// Name: August Bambenek
// Email: abambenek@wisc.edu
// Team: AY
// TA: Callie Kim
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Contains the Backend methods for SoccerTeam.java
 * 
 * @author August Bambenek
 */
public class SoccerTeamBackend implements ISoccerTeamBackend {

	private IterableRBTreeADT<IPlayer> tree; //RBT that stores all players
	private int lowerRatingFilter; //minimum 
	private int upperRatingFilter; //maximum rating to filter by
	private int lowerMarketValueFilter; //minimum market value to filter by
	private int upperMarketValueFilter; //maximum market value to filter by
	
	/**
	 * constructor for SoccerTeamBackend(), initializes variables
	 */
	public SoccerTeamBackend() {
		tree = new IterableRBTreeBD();
		lowerRatingFilter = -1;
		upperRatingFilter = -1;
		lowerMarketValueFilter = -1;
		upperMarketValueFilter = -1;
	}
	
	/**
	 * adds a player to the team
	 * 
	 * @param player - player to be added to the RBT of players
	 */
	@Override
	public void addPlayer(IPlayer player) {
		tree.insert(player);
	}

	/**
	 * returns the total number of players on the team
	 * 
	 * @return the total number of players
	 */
	@Override
	public int getNumberOfPlayers() {
		return tree.size();
	}

	/**
	 * Sets the lower rating filter bound to the input string parsed as an integer
	 * 
	 * @param lowerRating - String that must be parsable as an integer that will be 
	 * set to the lower rating filter bound
	 */
	@Override
	public void setRatingFilterLowerBound(String lowerRating) {
		lowerRatingFilter = Integer.parseInt(lowerRating);
		
	}
	
	/**
	 * Sets the upper rating filter bound to the input string parsed as an integer
	 * 
	 * @param upperRating - String that must be parsable as an integer that will be 
	 * set to the upper rating filter bound
	 */
	@Override
	public void setRatingFilterUpperBound(String higherRating) {
		upperRatingFilter = Integer.parseInt(higherRating);
		
	}

	/**
	 * returns the lower rating filter or null if one has not been set
	 * 
	 * @return the lower rating filter or null if one has not been set
	 */
	@Override
	public Integer getLowerBoundRatingFilter() {
		return (lowerRatingFilter < 0) ? null : lowerRatingFilter;
	}

	/**
	 * returns the upper rating filter or null if one has not been set
	 * 
	 * @return the upper rating filter or null if one has not been set
	 */
	@Override
	public Integer getUpperBoundRatingFilter() {
		return (upperRatingFilter < 0) ? null : upperRatingFilter;
	}

	/**
	 * resets the lower rating filter
	 */
	@Override
	public void resetLowerBoundRatingFilter() {
		lowerRatingFilter = -1;
		
	}

	/**
	 * resets the upper rating filter
	 */
	@Override
	public void resetUpperBoundRatingFilter() {
		upperRatingFilter = -1;
		
	}

	/**
	 * Sets the lower market value filter bound to the input string parsed as an integer
	 * 
	 * @param lowerRating - String that must be parsable as an integer that will be 
	 * set to the lower market value filter bound
	 */
	@Override
	public void setMarketValueLowerBoundFilter(String lowerMV) {
		lowerMarketValueFilter = Integer.parseInt(lowerMV);
		
	}

	/**
	 * Sets the upper market value filter bound to the input string parsed as an integer
	 * 
	 * @param lowerRating - String that must be parsable as an integer that will be 
	 * set to the upper market value filter bound
	 */
	@Override
	public void setMarketValueUpperBoundFilter(String upperMV) {
		upperMarketValueFilter = Integer.parseInt(upperMV);
		
	}

	/**
	 * returns the lower market value filter or null if one has not been set
	 * 
	 * @return the lower market value filter or null if one has not been set
	 */
	@Override
	public Integer getMarketValueLowerBoundFilter() {
		return (lowerMarketValueFilter < 0) ? null : lowerMarketValueFilter;
	}

	/**
	 * returns the upper market value filter or null if one has not been set
	 * 
	 * @return the upper market value filter or null if one has not been set
	 */
	@Override
	public Integer getMarketValueUpperBoundFilter() {
		return (upperMarketValueFilter < 0) ? null : upperMarketValueFilter;
	}

	/**
	 * resets the lower market value filter
	 */
	@Override
	public void resetLowerBoundMarketValueFilter() {
		lowerMarketValueFilter = -1;
		
	}

	/**
	 * resets the upper market value filter
	 */
	@Override
	public void resetUpperBoundMarketValueFilter() {
		upperMarketValueFilter = -1;
		
	}

	/**
	 * returns an ArrayList of all players on the team that match the filter conditions
	 * 
	 * @return an ArrayList of all players on the team that match the filter conditions
	 */
	@Override
	public List<IPlayer> ListPlayers() {
		List<IPlayer> filterList = new ArrayList<IPlayer>();
		
		//tree.initIterator();
		while (tree.hasNext()) {
			IPlayer player = tree.next();
			if (Integer.parseInt(player.getValue()) >= lowerMarketValueFilter) {
				if (Integer.parseInt(player.getRating()) >= lowerRatingFilter) {
					if (upperMarketValueFilter < 0 || Integer.parseInt(player.getValue()) <= upperMarketValueFilter) {
						if (upperRatingFilter < 0 || Integer.parseInt(player.getRating()) <= upperRatingFilter) {
							filterList.add(player);
						}
					}
					else {
						return filterList;
					}
				}
			}
		}
		return filterList;
	}

}
