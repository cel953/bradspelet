public class globalTools {


        // -------Convenient choice handler-------

        public static int intInputFilter(int max) {

            int choice = 0;
            boolean invalidChoice = true;
    
            while (invalidChoice) {
    
                    if (main.gameScanner.hasNextInt()) {
                        choice = main.gameScanner.nextInt();
                        invalidChoice = ((choice < 1) || (max < choice));
                        if (invalidChoice) {
                            System.out.println("Du måste välja ett av alternativen från 1 till " + max + ".");
                            main.gameScanner.nextLine();
                            continue;
                        }
                        else {
                            main.gameScanner.nextLine();
                            break;
                        }
                    }
                
                    else {
                        System.out.println("Du måste välja ett av alternativen från 1 till " + max + ".");
                        main.gameScanner.nextLine();
                        continue;
    
                    }
    
            }
            return choice;
        }
    
    }
