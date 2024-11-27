import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    protected static Scanner gameScanner = new Scanner(System.in);
    protected static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
            while (true) {
            System.out.println();
            System.out.println("Hej och välkommen till Swedish Test Mafias brädspelssamling!");
            System.out.println();
            int gameID = Menu.selectGame();
            startGame(gameID);
        }
    }


    public static void startGame(int gameID) {
        Game game = new Game(gameID);
        int chooseGame = 0;
           switch (gameID) {
                case 1:
                    System.out.println("Du valde att spela Tre i rad mot dator!");
                    System.out.println();
                    //Ropa på metod som skapa spelarlista med en spelare + dator
                    if(players.size() == 0){
                        players = createPlayerList(1, 1);
                        Player.chooseName(players);
                        Player.chooseSymbol(players);
                    }
                    game.gameFlow(gameID);
                    break;

                case 2:
                    System.out.println("Du valde att spela Tre i rad mot en motståndare!");
                    System.out.println();
                    //Ropa på metod som skapa spelarlista med en spelare
                    if(players.size() == 0){
                        players = createPlayerList(2, 0);
                        Player.chooseName(players);
                        Player.chooseSymbol(players);
                    }
                    game.gameFlow(gameID);
                    break;

                case 3:
                    System.out.println("Du valde att spela Fyra i rad mot en motståndare!");
                    System.out.println();   
                    //Ropa på metod som skapa spelarlista med en spelare
                    if(players.size() == 0){
                        players = createPlayerList(2, 0);
                        Player.chooseName(players);
                        Player.chooseSymbol(players);
                    }
                    game.gameFlow(gameID);
                    break;

                case 4:
                    System.out.println("Du valde att spela Fem  i rad mot en motståndare!");
                    System.out.println();
                    if(players.size() == 0){
                        players = createPlayerList(2, 0);
                        Player.chooseName(players);
                        Player.chooseSymbol(players);
                    }
                    game.gameFlow(gameID);
                    break;
                default:
                    System.out.println(
                            "Spel med siffan " + chooseGame + " finns tyvärr inte i listan. Välj mellan 1,2 eller 3");
                    break;

    

            }
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
            player.setName("Datorn");
            player.setisHuman(false);
            playerList.add(player);
        }
        return playerList; // ska returnera en lista
    }
    
    

}