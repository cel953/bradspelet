import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {

    public int currentGameID;

    public static void main(String[] args) {

        


        // TODO skapa en spelarlista
        //TODO hämta metod om att fråga om namn - addPlayer
        // TODO returnera en arraylist Players

        // Menyval för spelaren
        System.out.println("Hej och välkommen till brädspelssamlingen TicTacToe!");
        System.out.println();

        System.out.println("Du kan välja på dessa spel");
        System.out.println("1. Tre i rad mot dator");
        System.out.println("2. Tre i rad mot en motståndare");
        System.out.println("3. Fyra i rad mot en motståndare");
        System.out.println("4. Fem i rad mot en motståndare");

        int chooseGame = 0;
        boolean choseGameCorrecly = false;
        Scanner scanner = new Scanner(System.in);

        while (!choseGameCorrecly) {

            System.out.println("Skriv in 1, 2, 3 eller 4 beroende på vilket spel du vill spela");
            try {

                chooseGame = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Du måste skriva in ett heltal");
                scanner.nextLine(); // Rensar bort ogiltiga symboler i scannern
                continue;

            }

            switch (chooseGame) {
                case 1:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Tre i rad!");
                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;

                case 2:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Fyra i rad!");
                    // sedan ska den kalla på metoden för att komma till 4 i rad
                    break;

                case 3:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Fem  i rad!");
                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;

                case 4:
                    choseGameCorrecly = true;
                    System.out.println("Du valde att spela Fem  i rad mot en motståndare!");
                    // sedan ska den kalla på metoden för att komma till 3 i rad
                    break;
                default:
                    System.out.println(
                            "Spel med siffan " + chooseGame + " finns tyvärr inte i listan. Välj mellan 1,2 eller 3");
                    break;

            }

        }
        scanner.close();
    }
}
