import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;


public class main {

    public static void main(String[] args) {
        System.out.println("Hej och välkommen till brädspelssamlingen TicTacToe!");
        System.out.println();
       

        // TODO hämta metod om att fråga om namn - addPlayer
        // TODO returnera en arraylist Players

        ArrayList<Player> players = askForPlayers();  
        selectAndStartGame();
        

        // Kalla på tre i rad
        // kalla på fyra i rad
        // Kalla på fem i rad

        // avsluta spelet

        // avslutsvillkor
        // val om de vill fortsätta, gå tillbaka till menyn eller avsluta spelet.

        // fortsätta - starta ny runda
        // tillbaka till menyn
        // Avsluta spelet

    }

    // Metod för att fråga om antal spelare
    public static ArrayList<Player> askForPlayers() {

        System.out.println("Hur många spelare ska spela? 1 eller 2?");
        // Ta in hur många spelare

        Scanner askHowManyPlayers = new Scanner(System.in);
        askHowManyPlayers.nextInt();

        // Antlet valda spelare ska skapas
        Player player1 = new Player("Player 1", true);
        Player player2 = new Player("Player 2", false); // denna måste justeras om man spelar multispelare

        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(player1);
        playerList.add(player2);

     //TODO fixa felhantering
     
        return playerList; // ska returnera en lista

      
      
    }

    public static void askForPlayerName(){
    // fråga spelaren om namn

    }

    public static void selectAndStartGame() {

        System.out.println("Du kan välja på dessa spel");
        System.out.println("1. Tre i rad mot dator");
        System.out.println("2. Tre i rad mot en motståndare");
        System.out.println("3. Fyra i rad mot en motståndare");
        System.out.println("4. Fem i rad mot en motståndare");

        int chooseGame = 0;
        boolean choseGameCorrecly = false;
        Scanner playerPickGame = new Scanner(System.in);

        while (!choseGameCorrecly) {

            System.out.println("Skriv in 1, 2, 3 eller 4 beroende på vilket spel du vill spela");
            try {

                chooseGame = playerPickGame.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Du måste skriva in ett heltal");
                playerPickGame.nextLine(); // Rensar bort ogiltiga symboler i scannern
                continue;

            }

            switch (chooseGame) {
                case 1:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Tre i rad!");// denna ska bort
                    
                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;

                case 2:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Fyra i rad!");// denna ska bort
                    // sedan ska den kalla på metoden för att komma till 4 i rad
                    break;

                case 3:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Fem  i rad!");// denna ska bort
                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;

                case 4:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Fem  i rad mot en motståndare!"); //denna ska bort
                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;
                default:
                    System.out.println(
                            "Spel med siffan " + chooseGame + " finns tyvärr inte i listan. Välj mellan 1,2 eller 3");
                    break;

            }

        }
        playerPickGame.close();

    }
}