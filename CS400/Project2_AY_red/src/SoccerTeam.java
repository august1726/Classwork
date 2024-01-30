// --== CS400 Fall 2022 File Header Information ==--
// Name: August Bambenek
// Email: abambenek@wisc.edu
// Team: AY
// TA: Callie Kim
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Class with main method to run the soccer team app
 * 
 * @author August Bambenek
 */
public class SoccerTeam {
    public static void main(String[] args) throws FileNotFoundException {
        IPlayerLoader playerLoader = new PlayerLoader();
        // load players from data file
        List<IPlayer> playerList = playerLoader.loadPlayers("players.xml"); 
        // instantiate the backend
        ISoccerTeamBackend backend = new SoccerTeamBackend(); 
        // add all the players to the backend
        for(IPlayer player: playerList) backend.addPlayer(player);
        // instantiate scanner for user input
        Scanner userInputScanner = new Scanner(System.in);
        // instantiate the frontend and pass the scanner and backend into it
        ISoccerTeamFrontend frontend = new SoccerTeamFrontend(userInputScanner, backend);
        // run the input loop from the front end
        frontend.runCommandLoop();
    }
}
        

