import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Game {
    private int gameID;
    private boolean gameOn;
    private Queue<Player> playOrder;
    private Player currentPlayer;
    private Board gameBoard;

    public Game(int gameID) {
        this.gameID = gameID;
        this.gameOn = true;
    }


    public void gameFlow(int gameID, ArrayList<Player> players){
        this.gameBoard = new Board(); // Instans av brädet
        switch (gameID) {
            case 1:
                gameBoard.create("Spelbräde", 3, 3);        
                break;
            case 2:
                gameBoard.create("Spelbräde", 3, 3);        
                break;
            case 3:
                gameBoard.create("Spelbräde", 10, 10);        
                break;
            case 4:
                gameBoard.create("Spelbräde", 20, 20);        
                break;            
            default:
                break;
        }
          createRandomOrder(players);
          gameLoop();

    }


    // Metod som skapar brädet och startar spelet
    public void gameSetup(int gameID, ArrayList<Player> players) {

        gameBoard = new Board(); // Instans av brädet
        switch (this.gameID) {
            case 1:
                gameBoard.create("Spelbräde", 3, 3);        
                break;
            case 2:
                gameBoard.create("Spelbräde", 3, 3);        
                break;
            case 3:
                gameBoard.create("Spelbräde", 10, 10);        
                break;
            case 4:
                gameBoard.create("Spelbräde", 20, 20);        
                break;            
            default:
                break;
        }
    
        createRandomOrder(players);
        currentPlayer = playOrder.peek(); // Tar ej bort de i spelkön
        gameLoop();
    }

    // Loop för spelet
    private void gameLoop() {
        
        while (gameOn) {
            currentPlayer = playOrder.peek(); // Tar ej bort de i spelkön
            System.out.println("\n" + currentPlayer.getName() + "s tur. (" + currentPlayer.getSymbol() + ")");
            System.out.println();
            gameBoard.print();
            int row = 0, col = 0;
            boolean validMove = false;

            // För gilitga/tillgänliga spelbricka av spelare
            while (!validMove) {
                try {
                    System.out.println("Rad: ");
                    row = main.gameScanner.nextInt() -1;
                    System.out.println("Kolumn: "); 
                    col = main.gameScanner.nextInt() -1;
                    System.out.println();

                    // Kollar om platsen är tillgänlig
                    if (gameBoard.checkSpaceValid(row, col) && gameBoard.checkSpaceAvailable(row, col)) {
                        gameBoard.placeSymbol(row, col, currentPlayer.getSymbol());
                        validMove = true;

                    } else {
                        System.out.println("Ogiltigt, vänligen försök igen.");
                        System.out.println();
                    }

                } catch (InputMismatchException e) { // För ogitlig inmatning
                    System.out.println("Ogitligt värde, vänligen mata endast in nummer.");
                    System.out.println();
                    main.gameScanner.nextLine(); // Rensar scannern
                }
            }

            //  Kontrollerar vinst
            if (gameBoard.checkIfWin(row, col, calculateWinCondition())) {
                System.out.println("\n" + currentPlayer.getName() + " vann!");
                System.out.println();
                gameBoard.print();
 //               currentPlayer.increaseStats(gameID, 0); // skriv om metodnamn för poängställning
                endGame();

            } else if (gameBoard.getIsFull()) { // Kontrollerar om brädet är fullt,
                System.out.println("\nSpelet är oavgjort!");
                System.out.println();
 //               currentPlayer.increaseStats(gameID, 1); // skriv om metodnamn för poängställning
                endGame();

            } else {
                switchTurn();
            }
        }
    }

     // Metod för slumpmässig turordning
     public void createRandomOrder(ArrayList<Player> players) {
        this.playOrder = new LinkedList<>(); // Skapar spelkön
        List<Player> shuffledPlayers = new ArrayList<>(players); // Kopierar kölistan för slumpmässig turordning
        Collections.shuffle(shuffledPlayers); 
        this.playOrder.addAll(shuffledPlayers);
    }

    // Metod för att byta spelare i turordning
    public void switchTurn() {
        currentPlayer = playOrder.poll();
        playOrder.offer(currentPlayer);
    }
  
    private void endGame() {
        gameOn = false;
        System.out.println("Game over");
        System.out.println();
    }

    private int calculateWinCondition() {
        if (gameID == 1 || gameID == 2) return 3; // 3 i rad
        if (gameID == 3) return 4; // 4 i rad
        if (gameID == 4) return 5; // 5 i rad
        return 3;
    }
}