
public class GlobalToolse { 

        // -------Convenient choice handler-------

        public static int intInputFilter(int max) {

            int choice = 0;
            boolean invalidChoice = true;
    
            while (invalidChoice) {
    
                    if (Maine.gameScanner.hasNextInt()) {
                        choice = Maine.gameScanner.nextInt();
                        invalidChoice = ((choice < 1) || (max < choice));
                        if (invalidChoice) {
                            System.out.println("Du måste välja ett av alternativen från 1 - " + max + ".");
                            Maine.gameScanner.nextLine();
                            continue;
                        }
                        else {
                            Maine.gameScanner.nextLine();
                            break;
                        }
                    }
                
                    else {
                        System.out.println("Du måste välja ett av alternativen från 1 - " + max + ".");
                        Maine.gameScanner.nextLine();
                        continue;
    
                    }
    
            }
            return choice;
        }
    }
