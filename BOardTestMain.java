import java.util.Scanner;
//Denna är skapad helt för min (Kristin) egen skull för att kolla att board-funktionerna funkar.
public class BOardTestMain {
    public static void main(String[] args) {
        Board myBoard = new Board();
        myBoard.create("Mitt Bräde", 10, 15);
        boolean gameOn = true;


        Scanner scanner = new Scanner(System.in);
        myBoard.print();
        while (gameOn){

            System.out.println("what row?");
            int row = scanner.nextInt()-1;
            System.out.println("what column?");
            int column = scanner.nextInt()-1;
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

            if (myBoard.checkIfWin(row, column, 3)) {
                System.out.println("somwbody's a winner!");
                gameOn = false;
                
            }


            if(myBoard.getIsFull()){
                System.out.println("It's a Draw!");
                gameOn = false;

            }


        }
        System.out.println("Game over!");
        scanner.close();
    }
    

}


