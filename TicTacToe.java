package Coding_playground.LabBoardGames;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/// Saknas: möjlighet att spela igen, samt antal vinster. 
//Kör en egen klass för spelare


public class TicTacToe {
    public static void ticTacToeGame(){
    
        Scanner scanner = new Scanner(System.in);
        char[][] ticTacBoard = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        int line = 0;
        int row = 0;
        boolean gameOn = true;
        boolean player1Turn = false;
        boolean computerTurn = false;
        Random rand = new Random();
        int placed = 0;
        String winner = "";
        String starter = "";


         int drawStarter = rand.nextInt(2);
        if (drawStarter == 0){
            player1Turn = true;
            starter = "Player 1";
        } else {
            computerTurn = true;
            starter = "Computer";
        }
        System.out.println(starter + " starts! ");

        while (gameOn){

            while (player1Turn){
                Methods.printBoard(ticTacBoard);

                boolean lineInput = true;
                boolean rowInput = true;

                System.out.println("Where would you like to place your symbol?");
                do {
                    try{
                        System.out.print("Line: ");
                        line = scanner.nextInt();
                        scanner.nextLine();
                        if ((line >= 1) && (line <= 3)){
                            lineInput = false;
                        }else{
                            System.out.println("Please select number between 1-3");       
                            scanner.nextLine();            
                        }
                    }
                    catch(InputMismatchException ex){
                    System.out.println("Please select number between 1-3");
                    scanner.nextLine();
                    }
                } while (lineInput);
    
    
    
                do{
                    try{
                        System.out.print("Row: ");
                        row = scanner.nextInt();
                        scanner.nextLine();
                        if ((row >= 1) && (row <= 3)){
                            rowInput = false;
                        }else{
                            System.out.println("Please select number between 1-3");       
                            scanner.nextLine();            
                        }                        
                    }catch(InputMismatchException ex){
                        System.out.println("Please select number between 1-3");
                        scanner.nextLine();
                    }
                }while(rowInput);
            

                if (ticTacBoard[line-1][row-1] == ' '){
                    ticTacBoard[line-1][row-1] = 'X';
                    placed = placed + 1;
                    if (Methods.checkThree(ticTacBoard, line-1, row-1)){
                        winner = "Player 1";
                        gameOn = false;
                        break;
                    };                
                    if (placed < 9){
                        player1Turn = false;
                        computerTurn = true;
                    }else {
                        winner = "Nobody";
                        player1Turn = false;
                        gameOn = false;
                        break;
                    }
                }else{
                    System.out.println("");
                    System.out.print("*********   Taken! Please pick another.  ****");
                }
            }


            while (computerTurn){
                rand.nextInt(3);
                    
                line = rand.nextInt(3);   //datorn slumpar fram tal
                row = rand.nextInt(3);
                if (ticTacBoard[line][row] == ' '){     //Om platsen är ledig, placera, annars gör om tills ledig plats hittas
                    ticTacBoard[line][row] = 'O';
                    placed = placed +1;
                    if (Methods.checkThree(ticTacBoard, line, row)){
                        winner = "Computer";
                        gameOn = false;
                        break;
                    };  
                    if (placed < 9){
                        player1Turn = true;
                        computerTurn = false;
                    }else{
                        winner = "Nobody";
                        computerTurn = false; 
                        gameOn = false;
                        break;
                    }
                }
            }
        }
        Methods.printBoard(ticTacBoard);
        System.out.println("Winner is " + winner + " !");
        scanner.close();
    }
    
}
