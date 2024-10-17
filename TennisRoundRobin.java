
package tennisroundrobin;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class makes the makes the Round Robin player output for the user. 
 * This displays the output of the players name, age, rank and who they will play
 * @author  - Selinde Tatum
 * @version TODO - version 1.0 2024-Sept-28 - Initial Version
 */
public class TennisRoundRobin {

   //Defines constants 
   private static final int NUM_OF_PLAYERS = 4;
   private static final int COURTS_AVAILABLE = 6;
   private static final int MAX_ROUNDS = 4; 
   private static final int POINTS_WON = 1;
   private static final int POINTS_LOSS = 0;
   
   /**
    * The driver of the entire program
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // Create players
      List<PlayerLog> players = new ArrayList<>();
      players.add(new PlayerLog ("Serena Williams"));
      players.add(new PlayerLog ("Maria Sharapova"));
      players.add(new PlayerLog ("Iga Swiatek"));
      players.add(new PlayerLog ("Coco Gauff"));
      
      // Scanner for manuel match input
      Scanner scanner = new Scanner(System.in);
      
      //Random pair up players and input match results
      //Nested loops to set up matches
      while ( !allMatchesPlayed(players)) {
         Collections.shuffle(players);
      
      for (int i = 0; i < players.size() - 1; i+= 2){
         
            PlayerLog player1 = players.get(i);
            PlayerLog player2 = players.get(i + 1);
            
            //Display pair for the match and ask for the winner
            System.out.println("MAtch: " + player1.getName() + " vs " + player2.getName());
            System.out.println("Enter 1 if " + player1.getName() + " wins, or 2 if " + player2.getName());
            
            //Gets user input 
            int results = scanner.nextInt();
            
            //Update players stats
            switch (results) {
               case 1 -> {
                  player1.incrementWins();
                  player1.addPoints(POINTS_WON);
                  player2.addPoints(POINTS_LOSS);
                  System.out.println(player1.getName() + " wins!");
               }
               case 2 -> {
                  player2.incrementWins();
                  player2.addPoints(POINTS_WON);
                  player1.addPoints(POINTS_LOSS);
                  System.out.println(player2.getName() + " wins!");
               }
               default -> System.out.println("Invalid input");
            }
            //Increment matches played
            player1.incrementMatchesPlayed();
            player2.incrementMatchesPlayed();
         }
      }
      //Displays final standing
      System.out.println("\nTournament Results");
      for (PlayerLog player : players)
         System.out.println(player.displayPlayerStats());
      }
 
   

//Method checks if all matches have played
public static boolean allMatchesPlayed (List<PlayerLog> players){
   int matchesNeeded = players.size() -1; 
   for (PlayerLog player : players){
      if (player.getMatchesPlayed() < matchesNeeded){
         return false;
         }
      }
   return true;
   }
}