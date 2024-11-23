
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Player {
    
    private String name = "New player";
    private char symbol = ' ';
    private boolean isHuman;
    private int[] stats = {0, 0, 0, 0}; // 4 gamemodes, counting wins for each game mode



    public Player createPlayer(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
        return this;
    }

    //-------New players-------

 
    public static void chooseName(ArrayList<Player> playerList) {

        // Error handling needed, min and max length etc
        Player tempPlayer = new Player();

        for (int i = 0; i < playerList.size(); i++){
            tempPlayer = playerList.get(i);
            int index = i;


            if(tempPlayer.getisHuman()){
                System.out.println("Vad vill du ha för namn på din spelare " + (i+1) + "?");
                String name = goodName(index, playerList);
                tempPlayer.setName(name); //Felhantering för längd etc  
                System.out.println("Spelare " + (i+1) + " har valt namn " + tempPlayer.getName());
            }    
        }         
    }


    public static String goodName(int index, ArrayList<Player> playerList) {
        boolean validName = false;
        String name = ("Spelare " + (index + 1));


        while (!validName) {
            name = main.gameScanner.nextLine();
            validName = nameFilter(name, playerList);

            if (!validName) {
                System.out.println("Vill du fortfarande välja ett eget namn?");
                System.out.println("1. Ja.");
                System.out.println("2. Nej.");
                int choice = intInputFilter(2);

                switch (choice) {
                    case 1:
                        continue;

                    case 2:
                        name = ("Spelare " + (index + 1));
                        break;
                }
            }
            else {
                break;
            }
        }
        return name;
    }

    public static boolean nameFilter(String name, ArrayList<Player> playerList) {
        boolean isShort = (name.length() < 2);
        boolean isLong  = (name.length() > 12);
        boolean isDupe = true;
        //boolean isEmpty;

        //for (char c : name) // sätt isEmpty för att kolla om första eller sista tecknet i namnet inte är == " "

        for (Player player : playerList) {
            if (name == player.getName()) {
                isDupe = true;
                break;
            }
        }

        if (isDupe) {
            System.out.println("Namnet " + name + " är redan taget, välj ett annat namn!");
            return false;
        }
        else if (isShort) {
            System.out.println("Du måste välja ett namn som är mer än 2 tecken långt.");
            return false;
        }
        else if (isLong) {
            System.out.println("Du måste välja ett namn som är mindre än 12 tecken långt.");
            return false;
        }

        else {
            return true;
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
            case 1:  //Bryt ut och gör egen metod för detta?
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
    
    public void increaseStats(int gameID){
        this.stats[gameID-1] =+ 1;
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
        return this.stats[gameMode];
    }
/*
    public int getTotalStat(int stat) {
        int total = 0;
        for (int gameMode = 0; gameMode < this.stats.length; gameMode++) 
            total =+ this.stats[gameMode][stat];
        return total;
    }
*/

    //-------Convenient choice handler-------

    public static int intInputFilter(int max) {

        int choice = 0;

        while ((choice < 1) || (max < choice)) {
            try {
                choice = main.gameScanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Du måste välja ett av alternativen från 1 till" + max + ".");
                continue;
            }
        }
        return choice;
    }

}
