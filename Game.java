import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class Game {
    private int gameID;
    private boolean gameOn;
    private Queue<Integer> playOrder = new LinkedList<>();
    private Player currentPlayer;
    private Board gameBoard;
    private static Random rand = new Random();

    public Game(int gameID) {
        this.gameID = gameID;
        this.gameOn = true;
    }

    public void gameFlow(int gameID){

        this.gameBoard = new Board(); // Instans av brädet
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
          createRandomOrder();
          gameLoop();

    }


    // Loop för spelet
    private void gameLoop() {
        
        printWelcomeMessage();

        while (gameOn) {
            currentPlayer = Main.players.get(playOrder.peek()); // Tar ej bort de i spelkön
            gameBoard.print();
            System.out.println(currentPlayer.getName() + "s tur. (" + currentPlayer.getSymbol() + ")");
            int row = 0, col = 0;
            boolean validMove = false;
            
            // För gilitga/tillgängliga spelbricka av spelare
            while (!validMove) {
                try {
                    if(currentPlayer.getisHuman()){
                        System.out.print("Rad: ");
                        row = Main.gameScanner.nextInt() -1;
                        System.out.print("Kolumn: "); 
                        col = Main.gameScanner.nextInt() -1;
                        System.out.println();
                    }else if(!currentPlayer.getisHuman()){
                        row = computersTurn(gameBoard.getRows());
                        col = computersTurn(gameBoard.getColulmns());
                    }

                    // Kollar om platsen är tillgänlig
                    if (gameBoard.checkSpaceValid(row, col) && gameBoard.checkSpaceAvailable(row, col)) {
                        gameBoard.placeSymbol(row, col, currentPlayer.getSymbol());
                        validMove = true;

                    } else if (currentPlayer.getisHuman() && !gameBoard.checkSpaceValid(row, col)){
                            System.out.println("Spelrutan du valde är utanför spelbrädet, vänligen försök igen.");
                            System.out.println();
                    
                    } else if (currentPlayer.getisHuman() && !gameBoard.checkSpaceAvailable(row, col)){
                        System.out.println("Spelrutan du valde är redan upptagen, vänligen försök igen.");
                        System.out.println();
                    }

                } catch (InputMismatchException e) { // För ogitlig inmatning
                    System.out.println("Ogitligt värde, vänligen mata endast in nummer.");
                    System.out.println();
                    Main.gameScanner.nextLine(); // Rensar scannern
                }
            }

            //  Kontrollerar vinst
            if (gameBoard.checkIfWin(row, col, calculateWinCondition())) {
                gameBoard.print();
                System.out.println(currentPlayer.getName() + " vann!");
                currentPlayer.increaseStats(gameID);
                afterGame();

            } else if (gameBoard.getIsFull()) { // Kontrollerar om brädet är fullt
                gameBoard.print();
                System.out.println("\nSpelet är oavgjort!");
                System.out.println();
                afterGame();

            } else {
                switchTurn();
            }
        }
    }

     // Metod för slumpmässig turordning
     public void createRandomOrder() {
        ArrayList<Integer> shuffledPlayers = new ArrayList<>(); 
        for(int i = 0; i < Main.players.size(); i++){
            shuffledPlayers.add(i);
        }
        Collections.shuffle(shuffledPlayers); 
        this.playOrder.addAll(shuffledPlayers);
    }

    // Metod för att byta spelare i turordning
    public void switchTurn() {
        int playerIndex = this.playOrder.poll();
        currentPlayer = Main.players.get(playerIndex);
        this.playOrder.offer(playerIndex);
    }
  
    private void endGame() {
        printExitMessage();
        Runtime.getRuntime().exit(0);
    }

    private int calculateWinCondition() {
        if (gameID == 1 || gameID == 2) return 3; // 3 i rad
        if (gameID == 3) return 4; // 4 i rad
        if (gameID == 4) return 5; // 5 i rad
        return 3;
    }

    private int computersTurn(int dimension){
        return rand.nextInt(dimension);
    }

    private void afterGame(){
        printGameStats();
        printAllStats();
        System.out.println("\nVad vill du göra nu?");
        System.out.println("1. Spela igen");
        System.out.println("2. Tillbaka till startmeny");
        System.out.println("3. Avsluta spel");
        int playerChoice = GlobalTools.intInputFilter(3);
        switch (playerChoice) {
            case 1:
                gameBoard.clear();
                createRandomOrder();
                break;

            case 2:
                gameOn = false;
                break;

            case 3:
                endGame();
                break;
        
            default:
                break;
        }
    }

    private void printGameStats(){
        System.out.println("\nVinster i detta spel:");
        for (Player player : Main.players) {
                        System.out.println(player.getName() + ": " + player.getWins(this.gameID) + " st");
        }
    }

    private void printAllStats(){
        System.out.println("\nVinster totalt:");
        for (Player player : Main.players) {
            System.out.println(player.getName() + ": " + player.getAllWins() + " st");
        }
    }

    private void printWelcomeMessage(){
        System.out.println("****** Välkommen till spelet " + calculateWinCondition() + " i rad! ******"); 
        System.out.println();
        System.out.println("Spelare turas om att placera sin symbol, X eller O, på någon av de lediga platserna.");
        System.out.println("Välj först vilken rad och sedan vilken kolumn.");
        System.out.println("När du skrivit in siffra, tryck enter för att bekräfta.");
        System.out.println("Den spelare som först når " + calculateWinCondition() + " i rad antingen vertikalt, horisontellt eller diagonalt vinner."); 
        System.out.println();
        System.out.println("*************** Lycka till! ***************");
        System.out.println();
    }

    private void printExitMessage(){
        System.out.println();
        System.out.println("Tack för att du har spelat Swedish Test Mafias brädspelssamling!");
        System.out.println("  _   _   _   _   _   _   _     _   _   _   _     _   _   _   _   _  ");
        System.out.println(" / \\ / \\ / \\ / \\ / \\ / \\ / \\   / \\ / \\ / \\ / \\   / \\ / \\ / \\ / \\ / \\ ");
        System.out.println("( S | W | E | D | I | S | H ) ( T | E | S | T ) ( M | A | F | I | A )");
        System.out.println(" \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ \\_/   ");
        System.out.println();
    }

}

