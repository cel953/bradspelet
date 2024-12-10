import java.util.InputMismatchException;

public class Menu {
    
    public static int selectGame() {

        int chooseGame = 0;
        printMenu();
        while (true) {
            
            try {
                chooseGame = GlobalTools.intInputFilter(4);
                System.out.println();

            } catch (InputMismatchException e) {
                System.out.println("Du måste skriva in ett heltal");
                continue;
            }

            if(chooseGame >= 1 && chooseGame <=4){
                return chooseGame;
            }else{
                System.out.println("Spel med siffan " + chooseGame + " finns tyvärr inte i listan. Välj mellan 1,2, 3 eller 4");
            }
        }
    }

    private static void printMenu(){
        System.out.println("Du kan välja på dessa spel:");
        System.out.println("1. Tre i rad mot dator");
        System.out.println("2. Tre i rad mot en motståndare");
        System.out.println("3. Fyra i rad mot en motståndare");
        System.out.println("4. Fem i rad mot en motståndare");
        System.out.println();
        System.out.println("Skriv in 1, 2, 3 eller 4 beroende på vilket spel du vill spela.");
    }
}
