import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private int gameID;
    private String winner;
    private boolean gameOn;
    private Queue<String> playOrder;

    public Game(int gameID) {this.gameID = gameID;
        this.winner = "";
        this.gameOn = true;
        this.playOrder = new LinkedList<>();
    }

    public void createRandomOrder(ArrayList<String> players){
        Collections.shuffle(players); // Slumpar listan
        this.playOrder.addAll(players); // Lägger till alla spelare i kölistan
    }

    public String switchTurn() {
        String nextPlayer= playOrder.poll(); // Tar bort första spelaren i kön
        playOrder.add(nextPlayer); // Lägger till spelaren på nytt sist i kön
        return nextPlayer;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
        this.gameOn = false; // Spelet avslutas när en vinnare har utvalts
    }

    // Kontrollerar om spelet fortfarande är igång
    public boolean isGameOn() {
        return gameOn;
    }

    public int getGameID() {
        return gameID;
    }
}
