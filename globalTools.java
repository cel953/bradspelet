// Inspirerat av Tan från MT24

public class GlobalTools { 

        // -------Convenient choice handler-------

        public static int intInputFilter(int max) {

            int choice = 0;
            boolean invalidChoice = true;
    
            while (invalidChoice) {
    
                    if (Main.gameScanner.hasNextInt()) {
                        choice = Main.gameScanner.nextInt();
                        invalidChoice = ((choice < 1) || (max < choice));
                        if (invalidChoice) {
                            System.out.println("Du måste välja ett av alternativen från 1 - " + max + ".");
                            Main.gameScanner.nextLine();
                            continue;
                        }
                        else {
                            Main.gameScanner.nextLine();
                            break;
                        }
                    }
                
                    else {
                        System.out.println("Du måste välja ett av alternativen från 1 - " + max + ".");
                        Main.gameScanner.nextLine();
                        continue;
    
                    }
    
            }
            return choice;
        }
    }
