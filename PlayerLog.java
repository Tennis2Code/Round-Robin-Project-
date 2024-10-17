
package tennisroundrobin;

/**
 * This class displays name, wins and matches played. 
 * Also updates the scores and tracks the wins and losses
 * @author lindytatum
 */
public class PlayerLog {
   //Variables
   private String name;
   private int wins;
   private int matchesPlayed;
   private int points; 
  
   //Constructor
   public PlayerLog (String name){
      this.name = name;
      this.wins = 0;
      this.matchesPlayed = 0;
      this.points = 0;
      
   }
   
   //Getters
   public String getName(){
      return name;
   }
   public int getWins(){
      return wins;
   }
   public int getMatchesPlayed(){
      return matchesPlayed;
   }
   public int getPoint(){
      return points;
   }
   
   //Increments
   public void incrementWins(){
      wins++; // Adds one win
   }
   
   public void incrementMatchesPlayed(){
      matchesPlayed++; // Add one matches played
   }
   
   public void addPoints(int points) {
      this.points += points; // add points
   }
   
   //Displays players stats
   public String displayPlayerStats() {
      return "Player:" + name +
            "\nWins: " + wins +
            "\nMatches Played: " + matchesPlayed + 
            "\nPoints: " + points + "\n";
   }
}
