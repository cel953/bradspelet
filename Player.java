import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Player {
    
    private String name;
    private char symbol;
    private boolean isHuman;
    private int[][] stats; 


    public Player(String name, boolean isHuman) {
        this.name = name;
        symbol = 'n';
        this.isHuman = isHuman;
        stats = new int[3][2]; // 3 gamemodes, 2 stats = {wins, draws}

    }

    //-------New players-------

    public Player addPlayer(boolean isHuman) {

        String name = ("Player " + (1 + main.players.size()));  // Missing player collection and/or access
        
        
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

    public String chooseName() {

        // Error handling needed, min and max length etc (atleast 2 non-space to avoid confusion with symbol and name)
        // Avoid duplicate names, use HashSet?

        System.out.println("Vad vill du ha för namn på din spelare?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        return name;
    }

    //public String goodName() {      //name length, name taken?

    }

    //-------Name, Symbol and isHuman-------

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public boolean isHuman() {
        return this.isHuman;
    }




    //-------Stats-------


    public int getWins(int gameMode) {
        return stats[gameMode][0];
    }
    public int getDraws(int gameMode) {
        return stats[gameMode][1];
    }

    public int getTotalStat(int stat) {
        int total = 0;
        for (int gameMode = 0; gameMode < this.stats[0].length; gameMode++) 
            total =+ this.stats[gameMode][stat];
        return total;
    }

    public void hasWon(int gameMode) {
        this.stats[gameMode][0] =+ 1;
    }
    public void isDraw(int gameMode) {
        this.stats[gameMode][1] =+ 1;
    }


    //-------Convenient choice handler-------

    public int intInputHandler(int max) {
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

}



/*-------Archive-------

    public void chooseSymbol(Player[] players) {
        // missing playerqueue atm
        System.out.println("Välj vilken symbol du vill ha " + players[0] + "!");
        System.out.println("1. X");
        System.out.println("2. O");
        int choice = intInputHandler(2);

        switch (choice) {
            case 1:
                playerList[0].setSymbol('X');
                playerList[1].setSymbol('O');

            case 2:
                playerList[0].setSymbol('O');
                playerList[1].setSymbol('X');
        }

        System.out.println("Spelare " + playerList[0] + " har valt symbol " + playerList[0].getSymbol() + ".");
        System.out.println("Spelare " + playerList[1] + " har blivit tilldelad " + playerList[1].getSymbol() + ".");
    }


        // Filter so that if playing vs the computer, the player always chooses symbol
        
    