

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
    for(int i = 0; i < this.table.length; i ++){
        for(int j = 0; j < this.table[0].length; j++){
            System.out.print(this.table[i][j]);
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
        if (this.table[row][column] == ' '){
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
        
    
    //TODO
//Kolla om vinst
    public boolean checkIfWin(int row, int column, int numberInRowToWin){
        int numbersInRow = 1;
        char checkingSymbol = table[row][column];
        boolean doneChecking = false;
        String checkDirection = "Left";
        while(!doneChecking){
            switch (checkDirection) {
                case "Left":
                    for(int j = column - 1; j >= 0; j--){
                        if(this.checkSpaceValid(row, j) && (this.table[row][j] == checkingSymbol)){
                            System.out.println("It is the same");
                            numbersInRow++;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{ 
                            checkDirection = "Right";
                            break;
                        }
                    }
                    
                case "Right":
                    for(int j = column + 1; j < this.table.length; j++){
                        if(this.checkSpaceValid(row, j) && (this.table[row][j] == checkingSymbol)){
                            System.out.println("It is the same");
                            numbersInRow++;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{ 
                            numbersInRow = 1;
                            checkDirection = "Up";
                            break;
                        }
                    }


                case "Up":
                    numbersInRow = 1;
                    for(int j = row - 1; j >= 0; j--){
                        if(this.checkSpaceValid(j, column) && (this.table[j][column] == checkingSymbol)){
                            System.out.println("It is the same");
                            numbersInRow++;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{ 
                            checkDirection = "Down";
                            break;
                        }
                    }
                    
                case "Down":
                    for(int j = row + 1; j < this.table[0].length; j++){
                        if(this.checkSpaceValid(j, column) && (this.table[j][column] == checkingSymbol)){
                            System.out.println("It is the same");
                            numbersInRow++;
                            if(numbersInRow >= numberInRowToWin){
                                return true;
                            }
                        }else{ 
                            checkDirection = "UpLeft";
                            break;
                        }
                    }


                case "UpLeft": //TODO - denna kollar nu alla kolumner innan den går vidare till nästa rad uppåt. Gäller även nedan
                    numbersInRow = 1;
                    for(int j = row-1; j >= 0; j--){
                        for( int k = column-1; k >= 0; k--){
                            if(this.checkSpaceValid(j, k) && (this.table[j][k] == checkingSymbol)){
                                System.out.println("It is the same");
                                numbersInRow++;
                                if(numbersInRow >= numberInRowToWin){
                                    return true;
                                }
                            }else{ 
                                checkDirection = "DownRight";
                                break;
                            }
                        }
                    }
                
                case "DownRight":  //TODO
                    for(int j = row+1; j < this.table.length; j++){
                        for( int k = column+1; k < this.table[0].length; k++){
                            if(this.checkSpaceValid(j, k) && (this.table[j][k] == checkingSymbol)){
                                System.out.println("It is the same");
                                numbersInRow++;
                                if(numbersInRow >= numberInRowToWin){
                                    return true;
                                }
                            }else{ 
                                checkDirection = "UpRight";
                                break;
                            }
                        }
                    }
                
                case "UpRight": //TODO
                    numbersInRow = 1;
                    for(int j = row - 1; j >= 0; j--){
                        for( int k = column+1; k < this.table[0].length; k++){
                            if(this.checkSpaceValid(j, k) && (this.table[j][k] == checkingSymbol)){
                                System.out.println("It is the same");
                                numbersInRow++;
                                if(numbersInRow >= numberInRowToWin){
                                    return true;
                                }
                            }else{ 
                                checkDirection = "DownLeft";
                                break;
                            }
                        }
                    }
            
                case "DownLeft":  //TODO
                    for(int j = row+1; j < this.table.length; j++){
                        for( int k = column-1; k >= 0; k--){
                            if(this.checkSpaceValid(j, k) && (this.table[j][k] == checkingSymbol)){
                                System.out.println("It is the same");
                                numbersInRow++;
                                if(numbersInRow >= numberInRowToWin){
                                    return true;
                                }
                            }else{ 
                                checkDirection = "Done";
                                break;
                            }
                        }
                    }

                case "Done":
                    doneChecking = true;
                    System.out.println("No winner. Numbers in row: " + numbersInRow);
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }



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