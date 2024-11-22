import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;


public class main {

    public static void main(String[] args) {
        
        
        System.out.println("Hej och välkommen till Swedish Test Mafias brädspelssamling!");
        System.out.println();
        int gameID = menu.selectGame();
        startGame(gameID);

        
        // TODO hämta metod om att fråga om namn - addPlayer
        // TODO returnera en arraylist Players


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


    public static void startGame(int gameID) {

        int chooseGame = 0;
        boolean choseGameCorrecly = false;
        ArrayList<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
    



            switch (gameID) {
                case 1:
                    System.out.println("Du valde att spela Tre i rad mot dator!");
                    //Ropa på metod som skapa spelarlista med en spelare + dator
                    players = createPlayerList(1, 1);
                    Player.choose("name", players);
                    Player.choose("symbol", players);

                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;

                case 2:
                    System.out.println("Du valde att spela Tre i rad mot en motståndare!");
                    
                    //Ropa på metod som skapa spelarlista med en spelare
                    // sedan ska den kalla på metoden för att komma till 4 i rad
                    players = createPlayerList(2, 0);
                    Player.choose("name", players);
                    Player.choose("symbol", players);
                    break;

                case 3:
                    System.out.println("Du valde att spela Fyra i rad mot en motståndare!");    
                    //Ropa på metod som skapa spelarlista med en spelare
                    players = createPlayerList(2, 0);
                    Player.choose("name", players);
                    Player.choose("symbol", players);
                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;

                case 4:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Fem  i rad mot en motståndare!"); //denna ska bort
                    players = createPlayerList(2, 0);
                    Player.choose("name", players);
                    Player.choose("symbol", players);
                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;
                default:
                    System.out.println(
                            "Spel med siffan " + chooseGame + " finns tyvärr inte i listan. Välj mellan 1,2 eller 3");
                    break;

    

            }
        scanner.close();

 

    }

    private static ArrayList<Player> createPlayerList(int human, int computer){

        ArrayList<Player> playerList = new ArrayList<>();

        for (int i = 1; i <= human; i++){
            Player player = new Player();
            player.setisHuman(true);
            playerList.add(player);
        }

        for (int i = 1; i <= computer; i++){
            Player player = new Player();
            player.setName("Computer");
            player.setisHuman(false);
            playerList.add(player);
        }

        return playerList; // ska returnera en lista
    }

}