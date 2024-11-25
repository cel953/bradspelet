import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.IOException;

public class Player {

    private String name = "New player";
    private char symbol = ' ';
    private boolean isHuman;
    private int[] stats = { 0, 0, 0, 0 }; // 4 gamemodes, counting wins for each game mode

    public Player createPlayer(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
        return this;
    }

    // -------New players-------

    public static void chooseName(ArrayList<Player> playerList) {

        Player tempPlayer = new Player();

        for (int i = 0; i < playerList.size(); i++) {
            tempPlayer = playerList.get(i);
            int index = i;

            if (tempPlayer.getisHuman()) {

                System.out.println("Vill du välja namn för Spelare " + (i + 1) + "?");
                System.out.println("1. Ja");
                System.out.println("2. Nej");
                int choice = globalTools.intInputFilter(2);
                switch (choice) {
                    case 1:
                        String name = checkName(index, playerList);
                        tempPlayer.setName(name);
                        break;

                    case 2:
                        tempPlayer.setName("Spelare " + (i + 1));
                        break;
                }


                System.out.println("Spelare " + (i + 1) + " har valt namn " + tempPlayer.getName() + "!");
                System.out.println();
            }
        }
    }




    public static String checkName(int index, ArrayList<Player> playerList) {
        boolean validName = false;
        String name = ("Spelare " + (index + 1));

        while (!validName) {
            System.out.println("Vad vill du ha för namn på din spelare " + (index + 1) + "?");
            name = main.gameScanner.nextLine();
            validName = nameFilter(name, playerList);
            System.out.println();

            if (!validName) {
                System.out.println("Vill du fortfarande välja ett eget namn?");
                System.out.println("1. Ja.");
                System.out.println("2. Nej.");
                int choice = globalTools.intInputFilter(2);
                name = ("Spelare " + (index + 1));


                switch (choice) {
                    case 1:
                        continue;

                    case 2:

                        validName = true;
                        break;
                }
            } else {
                break;
            }
        }
        return name;
    }

    public static boolean nameFilter(String name, ArrayList<Player> playerList) {

        try {
            boolean isShort = (name.length() < 2);
            boolean isLong = (name.length() > 12);
            boolean isDuplicate = false;
            boolean isEmpty = false;
            boolean isIllegal = false;
            int spaceCount = 0;

            for (char c : (name.toCharArray())) { //Tar just nu "", och mellanslag före samt efter sista tecknet
                if (c == ' ') {
                    spaceCount = + spaceCount;
                }
            }
            isEmpty = (name.length() > 0) && (spaceCount == name.length());

            for (Player player : playerList) {
                if (name.equalsIgnoreCase(player.getName())) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isEmpty) {
                System.out.println("Ditt namn får inte bestå av endast mellanslag.");
                return false;
            } else if (isShort) {
                System.out.println("Du måste välja ett namn som är mer än 2 tecken långt.");
                return false;
            } else if (isLong) {
                System.out.println("Du måste välja ett namn som är mindre än 12 tecken långt.");
                return false;
            } else if (isDuplicate) {
                System.out.println("Namnet " + name + " är redan taget, välj ett annat namn!");
                return false;
            }

            else {
                return true;
            }

        } catch (NullPointerException e) {
            System.out.println("Du behöver skriva in ett namn.");
            return false;
        }

    }

    public static void chooseSymbol(ArrayList<Player> playerList) {
        Player tempPlayer = new Player();
        tempPlayer = playerList.get(0);
        System.out.println("Välj vilken symbol du vill ha " + tempPlayer.getName() + "!");
        System.out.println("1. X");
        System.out.println("2. O");
        int choice = globalTools.intInputFilter(2);
        System.out.println();

        switch (choice) {
            case 1: // Bryt ut och gör egen metod för detta?
                tempPlayer.setSymbol('X');
                System.out.println(
                        "Spelare " + tempPlayer.getName() + " har valt symbol " + tempPlayer.getSymbol() + ".");
                tempPlayer = playerList.get(1);
                tempPlayer.setSymbol('O');
                System.out.println(
                        "Spelare " + tempPlayer.getName() + " har blivit tilldelad " + tempPlayer.getSymbol() + ".");
                System.out.println();
                break;
            case 2:
                tempPlayer.setSymbol('O');
                System.out.println(
                        "Spelare " + tempPlayer.getName() + " har valt symbol " + tempPlayer.getSymbol() + ".");
                tempPlayer = playerList.get(1);
                tempPlayer.setSymbol('X');
                System.out.println(
                        "Spelare " + tempPlayer.getName() + " har blivit tilldelad " + tempPlayer.getSymbol() + ".");
                System.out.println();
            default:
                break;
        }
    }

    public void increaseStats(int gameID) {
        this.stats[gameID - 1] = +1;
    }

    // -------Name, Symbol and isHuman-------

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

    // -------Stats-------

    public int getWins(int gameMode) {
        return this.stats[gameMode];
    }

    public int getAllWins() {
        int totalWins = 0;
        for (int wins : this.stats) {
            totalWins =+ wins;
        }
        return totalWins;
    }

}
