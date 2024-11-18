import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Game {
    private int gameID;
    private boolean gameOn;
    private Queue<Player> playOrder;
    private Player currentPlayer;
    private Board gameBoard;
    private Scanner scanner;

    public Game(int gameID) {
        this.gameID = gameID;
        this.gameOn = true;
        this.scanner = new Scanner(System.in);        
    }

    // Metod för slumpmässig turordning
    public void createRandomOrder(ArrayList<Player> players) {
        playOrder = new LinkedList<>(); // Skapar spelkön
        List<Player> shuffledPlayers = new ArrayList<>(players); // Kopierar kölistan för slumpmässig turordning
        Collections.shuffle(shuffledPlayers); 
        playOrder.addAll(shuffledPlayers);
    }

    // Metod för att byta spelare i turordning
    public void switchTurn() {
        currentPlayer = playOrder.poll();
        playOrder.offer(currentPlayer);
    }

    // Metod som skapar brädet och startar spelet
    public void startGame(ArrayList<Player> players, int boardHeight, int boardWidth) {
        createRandomOrder(players);
        currentPlayer = playOrder.peek(); // Tar ej bort de i spelkön
        gameBoard = new Board(); // Instans av brädet
        gameBoard.create("Spelbräde", boardHeight, boardWidth);
        gameLoop();
    }

    // Loop för spelet
    private void gameLoop() {
        while (gameOn) {
            System.out.println("\n" + currentPlayer.getName() + " tur (" + currentPlayer.getSymbol() + ")");
            gameBoard.print();

            int row = 0, col = 0;
            boolean validMove = false;

            // För gilitga/tillgänliga spelbricka av spelare
            while (!validMove) {
                try {
                    System.out.println("Rad: ");
                    row = scanner.nextInt();
                    System.out.println("Kolumn: "); 
                    col = scanner.nextInt();

                    // Kollar om platsen är tillgänlig
                    if (gameBoard.checkSpaceValid(row, col) && gameBoard.checkSpaceAvailable(row, col)) {
                        gameBoard.placeSymbol(row, col, currentPlayer.getSymbol());
                        validMove = true;
                    } else {
                        System.out.println("Ogiltigt. Vängeligen försök igen.");
                    }
                } catch (InputMismatchException e) { // För ogitlig inmatning
                    System.out.println("Ogitligt väde. Vänligen ange nummer endast.");
                    scanner.nextLine(); // Rensar scannern
                }
            }

            //  Kontrollerar vinst
            if (gameBoard.checkIfWin(row, col, calculateWinCondition())) {
                System.out.println("\n" + currentPlayer.getName() + " vann!");
                gameBoard.print();
                currentPlayer.increaseStats(gameID, 0);
                endGame();
            } else if (gameBoard.isFull()) { // Kontrollerar om brädet är fullt
                System.out.println("\nSpelet är oavgjort!");
                currentPlayer.increaseStats(gameID, 1);
                endGame();
            } else {
                switchTurn();
            }
        }
    }

    private void endGame() {
        gameOn = false;
        System.out.println("Game over");
        closeScanner();
    }

    private void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    private int calculateWinCondition() {
        if (gameID == 1 || gameID == 2) return 3; // 3 i rad
        if (gameID == 3) return 4; // 4 i rad
        if (gameID == 4) return 5; // 5 i rad
        return 3;
    }
}