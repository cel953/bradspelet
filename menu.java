

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
    
    public static int selectGame() {

        System.out.println("Du kan välja på dessa spel");
        System.out.println("1. Tre i rad mot dator");
        System.out.println("2. Tre i rad mot en motståndare");
        System.out.println("3. Fyra i rad mot en motståndare");
        System.out.println("4. Fem i rad mot en motståndare");

        int chooseGame = 0;
        int currentGameId = 0;
        boolean choseGameCorrecly = false;
     //   Scanner menuScanner = new Scanner(System.in);
    

        while (!choseGameCorrecly) {

            System.out.println("Skriv in 1, 2, 3 eller 4 beroende på vilket spel du vill spela");
            try {

                chooseGame = Integer.valueOf(main.ultimateScanner.nextLine());
                

            } catch (InputMismatchException e) {
                System.out.println("Du måste skriva in ett heltal");
                main.ultimateScanner.nextLine(); // Rensar bort ogiltiga symboler i scannern
                continue;

            }

            switch (chooseGame) {
                case 1:
                    choseGameCorrecly = true;
                    currentGameId = 1; 
                    return currentGameId;

                case 2:
                    choseGameCorrecly = true;
                    currentGameId = 2; 
                    return currentGameId;

                case 3:
                    choseGameCorrecly = true;
                    //Ropa på metod som skapa spelarlista med en spelare
                    currentGameId = 3; 
                    return currentGameId;

                case 4:
                    choseGameCorrecly = true;
                    currentGameId = 4; 
                    return currentGameId;

                default:
                    System.out.println(
                            "Spel med siffan " + chooseGame + " finns tyvärr inte i listan. Välj mellan 1,2 eller 3");
                    break;

            }

        }
        
        return 0;
 

    }

}
