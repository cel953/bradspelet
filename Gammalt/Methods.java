package Coding_playground.LabBoardGames;

public class Methods {
    public static void printBoard(char[][] board){
        System.out.println("");
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("----------");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("----------");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println("");
    }

    

    public static boolean checkThree(char[][] board, int line, int row){
        for(int i = 0; i < 3; i++){
            if(((board[line][0] == board[line][1]) && (board[line][1] == board[line][2]) && (board[line][0] != ' ')) 
            || ((board[0][row] == board[1][row]) && (board[1][row] == board[2][row]) && (board[0][row] != ' '))
            || ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[0][0] != ' '))
            || ((board[2][0] == board[1][1]) && (board[1][1] == board[0][2]) && (board[2][0] != ' ')))
            {
                return true;
            }
        }
        return false;
    }


        
}

