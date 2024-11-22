import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Player {
    
    private String name = "New player";
    private char symbol;
    private boolean isHuman;
    private int[][] stats; 
    

//Används ej
    public Player createPlayer(String name, boolean isHuman) {
        this.name = name;
        this.symbol = ' ';
        this.isHuman = isHuman;
        this.stats = new int[3][3]; // 3 gamemodes, 3 stats = {wins, draws, losses}
        return this;
    }

    //-------New players-------

 
    public static void chooseName(ArrayList<Player> playerList) {

        // Error handling needed, min and max length etc
        Player tempPlayer = new Player();
        for (int i = 0; i < playerList.size(); i++){
            tempPlayer = playerList.get(i);
            if(tempPlayer.getisHuman()){
                System.out.println("Vad vill du ha för namn på din spelare " + (i+1) + "?");
                tempPlayer.setName(main.gameScanner.nextLine()); //Felhantering för längd etc  
                System.out.println("Spelare " + (i+1) + " har valt namn " + tempPlayer.getName());
            }    
        }         
    }

    public static void chooseSymbol(ArrayList<Player> playerList) {
        Player tempPlayer = new Player();
        tempPlayer = playerList.get(0);
        System.out.println("Välj vilken symbol du vill ha " + tempPlayer.getName() + "!");
        System.out.println("1. X");
        System.out.println("2. O");

        int choice = main.gameScanner.nextInt();
        main.gameScanner.nextLine();
        
        //intInputHandler(2);

        switch (choice) {
            case 1:  //Bryt ut och gör egen metod för detta
                tempPlayer.setSymbol('X');
                System.out.println("Spelare " + tempPlayer.getName() + " har valt symbol " + tempPlayer.getSymbol() + ".");
                tempPlayer = playerList.get(1);
                tempPlayer.setSymbol('O');
                System.out.println("Spelare " + tempPlayer.getName() + " har blivit tilldelad " + tempPlayer.getSymbol() + ".");
                break;
            case 2:
                tempPlayer.setSymbol('O');
                System.out.println("Spelare " + tempPlayer.getName() + " har valt symbol " + tempPlayer.getSymbol() + ".");
                tempPlayer = playerList.get(1);
                tempPlayer.setSymbol('X');
                System.out.println("Spelare " + tempPlayer.getName() + " har blivit tilldelad " + tempPlayer.getSymbol() + ".");
            default:
                break;
        }
    }
    

    //-------Name, Symbol and isHuman-------

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getSymbol() {
        return this.symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public boolean getisHuman() {
        return this.isHuman;
    }

    public void setisHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }




        // Filter so that if playing vs the computer, the player always chooses symbol
        
    


    //-------Stats-------


    public int getWins(int gameMode) {
        return stats[gameMode][0];
    }
    public int getDraws(int gameMode) {
        return stats[gameMode][1];
    }
    public int getLosses(int gameMode) {
        return stats [gameMode][2];
    }
    public int getTotalStat(int stat) {
        int total = 0;
        for (int gameMode = 0; gameMode < this.stats.length; gameMode++) 
            total =+ this.stats[gameMode][stat];
        return total;
    }

    public void hasWon(int gameMode) {
        this.stats[gameMode][0] =+ 1;
    }
    public void isDraw(int gameMode) {
        this.stats[gameMode][1] =+ 1;
    }
    public void hasLost(int gameMode) {
        this.stats[gameMode][2] =+ 1;
    }

    //-------Convenient choice handler-------
/*
    public static int intInputHandler(int max) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while ((choice < 1) || (max < choice)) {
            try {
                choice = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Du måste välja ett av alternativen från 1 till" + max + ".");
                continue;
            }
        }
        input.close();
        return choice;
    }
*/
}
