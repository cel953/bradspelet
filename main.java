import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;


public class main {
    
    protected static Scanner gameScanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        
        System.out.println("Hej och välkommen till Swedish Test Mafias brädspelssamling!");
        System.out.println();
        
        int gameID = menu.selectGame();
        startGame(gameID);
        
    gameScanner.close();
    }


    public static void startGame(int gameID) {
        Game game = new Game(gameID);
        int chooseGame = 0;
        ArrayList<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

            switch (gameID) {
                case 1:
                    System.out.println("Du valde att spela Tre i rad mot dator!");
                    //Ropa på metod som skapa spelarlista med en spelare + dator
                    players = createPlayerList(1, 1);
                    Player.chooseName(players);
                    Player.chooseSymbol(players);
                    game.gameFlow(gameID, players);
                    break;

                case 2:
                    System.out.println("Du valde att spela Tre i rad mot en motståndare!");
                    //Ropa på metod som skapa spelarlista med en spelare
                    players = createPlayerList(2, 0);
                    Player.chooseName(players);
                    Player.chooseSymbol(players);
                    game.gameFlow(gameID, players);
                    break;

                case 3:
                    System.out.println("Du valde att spela Fyra i rad mot en motståndare!");    
                    //Ropa på metod som skapa spelarlista med en spelare
                    players = createPlayerList(2, 0);
                    Player.chooseName(players);
                    Player.chooseSymbol(players);
                    game.gameFlow(gameID, players);
                    break;

                case 4:
                    System.out.println("Du valde att spela Fem  i rad mot en motståndare!"); //denna ska bort
                    players = createPlayerList(2, 0);
                    Player.chooseName(players);
                    Player.chooseSymbol(players);
                    game.gameFlow(gameID, players);
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