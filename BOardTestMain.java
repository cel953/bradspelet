package BOardTest;
import java.util.Scanner;

public class BOardTestMain {
    public static void main(String[] args) {
        Board myBoard = new Board();
        myBoard.create("Bräde 3x3", 3, 3);
        boolean gameOn = true;


        Scanner scanner = new Scanner(System.in);
        myBoard.print();
        while (gameOn){

            System.out.println("what row?");
            int row = scanner.nextInt();
            System.out.println("what column?");
            int column = scanner.nextInt();
            scanner.nextLine();
            System.out.println("what symbol?");
            
            String symbolInput = scanner.nextLine();
            char symbol = symbolInput.charAt(0);
    

            if (myBoard.checkSpaceAvailable(row, column)){
                System.out.println("Is available!");
            }else{
                System.out.println("Not available, pick another!");
            }


            myBoard.placeSymbol(row, column, symbol);
            myBoard.print();

   /*         if (myBoard.checkIfWin(row, column, 3)) {
                System.out.println("somwbody's a winner!");
                gameOn = false;
                
            }
*/

            if(myBoard.isIsFull()){
                System.out.println("It's a Draw!");
                gameOn = false;

            }


        }
        System.out.println("Game over!");
        scanner.close();
    }
    

}


