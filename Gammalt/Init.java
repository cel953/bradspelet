package Coding_playground.LabBoardGames;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Init {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What game will we play?");
        System.out.println("1. Tic Tac Toe, single player game");
        System.out.println("2. Tic Tac Toe, multiplayer game");
        System.out.println("3. Othello");
        
        int userInput = 0;
        boolean selectGame = true;

        do {
            try {
                userInput = scanner.nextInt();
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                userInput = 0;
            }
            switch (userInput){
                case 1:
                    TicTacToe singleGame = new TicTacToe();
                    TicTacToe.ticTacToeGame();
                    selectGame = false;
                    break;
                case 2: 
                    System.out.println("Sorry, not created yet! Please pick another game.");
                    break;
                case 3: 
                    System.out.println("Sorry, not created yet! Please pick another game.");
                    break;
                default:
                    System.out.println("Please select game 1-3.");
                    break;
            }
        } while (selectGame);
        scanner.close();
    
    }
}
