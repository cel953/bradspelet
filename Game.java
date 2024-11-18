import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private int gameID;
    private boolean gameOn;
    private Queue<Player> playOrder;
    private Player currentPlayer;

    public Game(int gameID, ArrayList<Player> players) {
        this.gameID = gameID;
        this.gameOn = true;
        this.playOrder = createRandomOrder(players);
        this.currentPlayer = playOrder.peek();
    }

    private Queue<Player> createRandomOrder(ArrayList<Player> players){
        Collections.shuffle(players);
        return new LinkedList<>(players);
    }

    public String switchTurn() {
        Player previousPlayer = playOrder.poll();
        playOrder.add(previousPlayer);
        currentPlayer = playOrder.peek();
        return currentPlayer.getName();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void play() {
        System.out.println("Första ronden: " + currentPlayer.getName());
        while (gameOn) {
            System.out.println("Nuvarande tur: " + currentPlayer.getName());
            switchTurn();
        }

        System.out.println("Avslutat spelomgång!");
    }

    public void endGame() {
        gameOn = false;
    }

    public int getGameID() {
        return gameID;
    }

    public boolean isGameOn() {
        return gameOn;
    }

    public Queue<Player> getPlayOrder() {
        return playOrder;
    }
}