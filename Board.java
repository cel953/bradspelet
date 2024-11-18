

public class Board {

// -------- Class variables ----------

    private String name = "Gameboard";
    private boolean isFull = false;
    private char[][] table; 
    private int spacesTaken = 0;
    private int spacesTotal = 9;



    //Tillagt 2024-11-18
    //Ändrat brådet till en 2d-array
    //Spapat default-konstruktor för bräde



//  --------  Methods ---------

//Skapa bräde
    public void create(){
        this.create("Gameboard", 3, 3);
    }

    public void create(String Name){
        this.create(Name, 3, 3);
    }
    
    public void create(String name, int rows, int columns){
        this.table = new char[rows][columns];
        this.setName(name);
        this.setSpacesTotal(rows*columns);
        
    //TODO ----------Felhantering -- kan inte vara 0
 
        for(int i = 0; i < this.table.length; i++){
            for(int j = 0; j < this.table[0].length; j++){
                table[i][j] = ' ';
            }
        }
    }

    //TODO snygga till utskrift

//Skriv ut bräde i terminal
    public void print(){
    System.out.println("Here is your board!");

        for (int i = 0; i < this.table.length; i++){
            System.out.print((i) + " | ");

            for(char a : table[i]){
                System.out.print(a + " | ");
            }
            System.out.println("");
        }

    }
    
//Kolla om space is valid - här kontrolleras att platsen finns med på brädet
    public boolean checkSpaceValid (int row, int column){
        if(row >= 0 && row < this.table.length && column >= 0 && column < this.table[0].length){
            return true;
        }else{
            return false;
        }
    }

//Kolla om plats är ledig
    public boolean checkSpaceAvailable (int row, int column){
        if (checkSpaceValid(row, column) && this.table[row][column] == ' '){
            return true; 
        }else{
            return false;
        }
    }

//Placera symbol
    public void placeSymbol(int row, int column, char symbol){
    //TODO ----------Felhantering och skicka true eller ha bara void?----
        if (this.checkSpaceAvailable(row, column)){
            this.table[row][column] = symbol;
            this.spacesTaken++;
            if (this.spacesTaken >= this.spacesTotal){
                this.setIsFull(isFull);
            }
        }
   }
        
    

//Kolla om vinst
    public boolean checkIfWin(int row, int column, int numberInRowToWin){
        int numbersInRow = 1;
        char checkingSymbol = table[row][column];
        boolean doneChecking = false;
        String checkDirection = "Up";
        int i = 0;
        int j = 0;

        while(!doneChecking){  //TODO kolla om går att bryta ut "gemensam" funktion, sätta checkDirection i en lista/kö? TYp nextDirection(); eller alla Up/down/ etc till egna metoder?
        switch (checkDirection) {
                case "Up":
                    numbersInRow = 1;
                    i = row - 1;
                    while(checkSpaceValid(i, column))
                        if(this.table[i][column] == checkingSymbol){
                            numbersInRow++;
                            i--;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{ 
                            checkDirection = "Down";
                            break;
                        }

                case "Down":
                    i = row + 1;
                        while(this.checkSpaceValid(i, column)){
                            if (this.table[i][column] == checkingSymbol){
                                numbersInRow++;
                                i++;
                                if(numbersInRow >= numberInRowToWin){
                                    return true;
                                }
                            }else{ 
                                checkDirection = "Left";
                                break;
                            }
                        }
                    

                case "Left":
                    numbersInRow = 1;    
                    j = column - 1; 
                    while(this.checkSpaceValid(row, j)){
                        if (this.table[row][j] == checkingSymbol){
                            numbersInRow++;
                            j--;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{ 
                            checkDirection = "Left";
                            break;
                        }
                    }

                    
                case "Right":
                j = column + 1; 
                while(this.checkSpaceValid(row, j)){
                    if (this.table[row][j] == checkingSymbol){
                        numbersInRow++;
                        j++;
                        if(numbersInRow >= numberInRowToWin){
                            return true;
                        }
                    }else{ 
                        checkDirection = "Left";
                        break;
                    }
                }

                case "UpLeft":
                    i = row - 1;
                    j = column - 1;
                    while(this.checkSpaceValid(i, j)){
                        if (table[i][j] == checkingSymbol){
                            numbersInRow++;
                            i--;
                            j--;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{
                            checkDirection = "DownRight";
                            break;
                        }
                    }

                case "DownRight":
                    numbersInRow = 1;
                    i = row - 1;
                    j = column + 1;
                    while(this.checkSpaceValid(i, j)){
                        if (table[i][j] == checkingSymbol){
                            numbersInRow++;
                            i--;
                            j++;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{
                            numbersInRow = 1;
                            checkDirection = "UpRight";
                            break;
                        }
                    }

                case "UpRight":
                    numbersInRow = 1;
                    i = row - 1;
                    j = column + 1;
                    while(this.checkSpaceValid(i, j)){
                        if (table[i][j] == checkingSymbol){
                            numbersInRow++;
                            i--;
                            j++;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{
                            checkDirection = "DownLeft";
                            break;
                        }
                    }
    
                case "DownLeft":
                    numbersInRow = 1;
                    i = row + 1;
                    j = column - 1;
                    while(this.checkSpaceValid(i, j)){
                        if (table[i][j] == checkingSymbol){
                            numbersInRow++;
                            i++;
                            j--;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{
                            numbersInRow = 1;
                            checkDirection = "Done";
                            break;
                        }
                    }

                case "Done":
                    doneChecking = true;
                    System.out.println("No winner yet!");
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

/*
 * checkUp()
 * checkDown()
 * checkLeft()
 * checkRight()
 * checkUpLeft()
 * checkDownRight()
 * checkUpRight()
 * checkDownLeft()
 * 
 * 
 * 
 * 
 */





// ------- Getters and setters --------


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public char[][] getTable() {
        return this.table;
    }
    
    public void setTable(char[][] table) {
        this.table = table;
    }
    
    public int getSpacesTaken() {
        return this.spacesTaken;
    }
    
    public void setSpacesTaken(int spacesTaken) {
        this.spacesTaken = spacesTaken;
    }
    
    public int getSpacesTotal() {
        return this.spacesTotal;
    }
    
    public void setSpacesTotal(int spacesTotal) {
        this.spacesTotal = spacesTotal;
    }
    


    public boolean getIsFull() {
        return this.isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

}