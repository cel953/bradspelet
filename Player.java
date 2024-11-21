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
/*
    public Player addPlayer(boolean isHuman) {

        String name = ("Player " + (1 + Game.length(Game.playOrder)));  // Missing player collection and/or access

        if (isHuman == true) {
            System.out.println("Vill du välja ett namn för " + name + "?");
            System.out.println("1: Ja.");
            System.out.println("2: Nej.");
            int choice = intInputHandler(2);

            if (choice == 1) {
                name = chooseName();
            }
            else {
                continue;
            }
        }
        else {
            name = "CPU";
        }
        return new Player(name, isHuman);
        }
*/

    public static void choose(String option, ArrayList<Player> playerList){
            
//        Scanner scanner = new Scanner(System.in);
        Player tempPlayer = new Player();
        switch (option) {
            
                case "symbol":
                    
                    tempPlayer = playerList.get(0);
                    System.out.println("Välj vilken symbol du vill ha " + tempPlayer.getName() + "!");
                    System.out.println("1. X");
                    System.out.println("2. O");

                    
                    int choice = main.ultimateScanner.nextInt();
                    main.ultimateScanner.nextLine();
                    
            
            //intInputHandler(2);
    
                switch (choice) {
                    case 1:
                        tempPlayer.setSymbol('X');
                        System.out.println("Spelare " + tempPlayer + " har valt symbol " + tempPlayer.getSymbol() + ".");
                        tempPlayer = playerList.get(1);
                        tempPlayer.setSymbol('O');
                        System.out.println("Spelare " + tempPlayer + " har blivit tilldelad " + tempPlayer.getSymbol() + ".");
                    case 2:
                        tempPlayer.setSymbol('O');
                        System.out.println("Spelare " + tempPlayer + " har valt symbol " + tempPlayer.getSymbol() + ".");
                        tempPlayer = playerList.get(1);
                        tempPlayer.setSymbol('X');
                        System.out.println("Spelare " + tempPlayer + " har blivit tilldelad " + tempPlayer.getSymbol() + ".");
                    default:
                        break;
                    }
                
                break;

                case "name":
                
                for (int i = 0; i < playerList.size(); i++){

                    tempPlayer = playerList.get(i);
                    if(tempPlayer.getisHuman()){
                        System.out.println("Vad vill du ha för namn på din spelare?");
                        
                                tempPlayer.setName(main.ultimateScanner.nextLine()); //Felhantering för längd etc  
                                
                        System.out.println("Spelare " + (i+1) + " har valt namn " + tempPlayer.getName());
                    }
                }
                
                break;

            default:
                break;

            } 
        
    }
/* 
    public String chooseName() {

        // Error handling needed, min and max length etc
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Vad vill du ha för namn på din spelare?");
        String name = scanner.nextLine();
        scanner.close();
        return name;                
    }

    public static void chooseSymbol(ArrayList<Player> playerList) {




    }

*/




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
