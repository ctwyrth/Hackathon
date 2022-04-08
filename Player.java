import java.util.ArrayList;

public class Player {
   // member variables
   private String name;
   private int chips;
   private ArrayList<Card> hand;
   private boolean bust = false;

   // constructors
   public Player(String n) {
      this.name = n;
      this.chips = 10;
      hand = new ArrayList<Card>();
   }

   // getters & setters
   public String getPlayerName() {
      return this.name;
   }
   public void setPlayerName(String n) {
      this.name = n;
   }

   public int getPlayerChips() {
      return this.chips;
   }
   public void setPlayerChips(int c) {
      this.chips += c;
   }

   public ArrayList<Card> getPlayerHand() {
      return this.hand;
   }
   public void setPlayerHand(Card newCard) {
      this.hand.add(newCard);
   }

   public boolean getBust() {
      return this.bust;
   }

   public boolean isBlackJack() {
      int total = 0;
      for (int i = 0; i < this.hand.size(); i++) {
         Card temp = this.hand.get(i);
         if (temp.getRank() > 10) {
            total += 10;
         } else if (temp.getRank() == 1) {
            total += 11;
         } else {
            total += temp.getRank();
         }
      }
      if (total == 21) {
         return true;
      }
      return false;
   }

   public boolean isBust() {
      int total = 0;
      for (int i = 0; i < this.hand.size(); i++) {
         Card temp = this.hand.get(i);
         if (temp.getRank() > 10) {
            total += 10;
         } else {
            total += temp.getRank();
         }
      }
      if (total > 21) {
         System.out.println("You DIE!");
         this.bust = true;
         return true;
      }
      return false;
   }

   public int cardTotal() {
      int total = 0;
      for (int i = 0; i < this.hand.size(); i++) {
         Card temp = this.hand.get(i);
         if (temp.getRank() > 10) {
            total += 10;
         } else {
            total += temp.getRank();
         }
      }
      return total;
   }
}