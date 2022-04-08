import java.util.ArrayList;

public class Game {
   private ArrayList<Player> players;

   public Game() {
      players = new ArrayList<Player>();
      Dealer gameDealer = new Dealer();
      players.add(gameDealer);
   }

   public ArrayList<Player> getPlayers() {
      return this.players;
   }
   public void setPlayers(Player n) {
      this.players.add(n);
   }
}
