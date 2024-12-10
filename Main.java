import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    protected static Scanner gameScanner = new Scanner(System.in);
    protected static ArrayList<Player> players = new ArrayList<>();
    protected static ArrayList<Player> restingPlayers = new ArrayList<>();
    protected static int activeGameID = 0;
    protected static boolean nameForPlayer2IsSet = false;
    
    public static void main(String[] args) {
            while (true) {
            System.out.println();
            System.out.println("Hej och välkommen till Swedish Test Mafias brädspelssamling!");
            System.out.println();
            int gameID = Menu.selectGame();
            playerListAdjustment(gameID);
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
                    if(players.size() == 0){
                        createPlayerList(1, 1);
                        Player.chooseName(players);
                        Player.chooseSymbol(players);
                    }
                    break;

                case 2:
                    System.out.println("Du valde att spela Tre i rad mot en motståndare!\n");
                    if(players.size() == 0){
                        createPlayerList(2, 0);
                        Player.chooseName(players);
                        Player.chooseSymbol(players);
                        nameForPlayer2IsSet = true;
                    }

                    break;

                case 3:
                    System.out.println("Du valde att spela Fyra i rad mot en motståndare!\n");
                    if(players.size() == 0){
                        createPlayerList(2, 0);
                        Player.chooseName(players);
                        Player.chooseSymbol(players);
                    }
                    nameForPlayer2IsSet = true;
                    break;

                case 4:
                    System.out.println("Du valde att spela Fem  i rad mot en motståndare!\n");
                    if(players.size() == 0){
                        createPlayerList(2, 0);
                        Player.chooseName(players);
                        Player.chooseSymbol(players);
                    }
                    nameForPlayer2IsSet = true;
                    break;
                default:
                    System.out.println(
                            "Spel med siffan " + chooseGame + " finns tyvärr inte i listan. Välj mellan 1,2 eller 3");
                    break;
            }

        game.gameFlow(gameID);
    }

    private static void createPlayerList(int human, int computer){

        for (int i = 1; i <= human; i++){
            Player player = new Player();
            player.setisHuman(true);
            players.add(player);
        }

        for (int i = 1; i <= computer; i++){
            Player player = new Player();
            player.setName("Datorn");
            player.setisHuman(false);
            players.add(player);
        }
    }

    public static void createRestingPlayer(){
        Player playerToAdd = new Player();
        Player player = players.get(1); //Hämta spelare 2
        if(player.getisHuman()) {            
            playerToAdd = playerToAdd.createPlayer("Datorn", false);
            playerToAdd.setSymbol(player.getSymbol());
            restingPlayers.add(playerToAdd);
        }else if(!player.getisHuman()){
            playerToAdd = playerToAdd.createPlayer("Spelare 2", true);
            playerToAdd.setSymbol(player.getSymbol());
            restingPlayers.add(playerToAdd);
        }
    }

    public static void playerListAdjustment(int gameID){
        if (activeGameID != gameID){
            switch (activeGameID) {
                case 0:
                    activeGameID = gameID;    
                    break;
                case 1:
                    //byt från dator till spelare 2
                    if(restingPlayers.size() == 0){
                        createRestingPlayer();
                    }
                    restPlayer(1);
                    fetchRestingPlayer(0);
                    if (!nameForPlayer2IsSet) {
                        Player.chooseNameForPlayer(players.get(1));
                        nameForPlayer2IsSet = true;
                    }
                    activeGameID = gameID;
                    break;
                case 2, 3, 4:
                    if(gameID == 1){
                        //byt från spelare 2 till dator
                        if(restingPlayers.size() == 0){
                            createRestingPlayer();
                        }
                        restPlayer(1);                                
                        fetchRestingPlayer(0);
                    }
                    activeGameID = gameID;
                    break;
                default:
                    break;
            }
        }
    }
    
    public static void restPlayer(int index){
        restingPlayers.add(players.get(index));
        players.remove(index);
    }
    
    public static void fetchRestingPlayer(int index){
        players.add(restingPlayers.get(index));
        restingPlayers.remove(index);
    }

}