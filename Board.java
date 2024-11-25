

public class Board {

// -------- Class variables ----------

    private String name = "Gameboard";
    private boolean isFull = false;
    private char[][] table; 
    private int spacesTaken = 0;
    private int spacesTotal = 9;


//  -------- Public Methods ---------

//Skapa bräde
    
                                            //TODO ----------Felhantering -- kan inte vara 0, hantera här eller där det skickas?
    
    public void create(){                                       //Constructor 1 - default name, default size 3x3
        this.create("Gameboard", 3, 3);
    }

    public void create(String Name){                            //Constructor 2 - custom name, default size 3x3
        this.create(Name, 3, 3);
    }
    
    public void create(String name, int rows, int columns){     //Constructor 3 - custom name, custom size
        this.table = new char[rows][columns];
        this.setName(name);
        this.setSpacesTotal(rows*columns);
 
        for(int i = 0; i < this.table.length; i++){
            for(int j = 0; j < this.table[0].length; j++){
                table[i][j] = ' ';
            }
        }
    }

 
//Skriv ut bräde i terminal
    public void print(){                            
    System.out.println("Här är ditt bräde!");
        
        this.printColumnNumbers();
        this.printLine();
        for(int x = 0; x < this.table.length; x++){
            this.printRow(x);
            this.printLine();
        }
        System.out.println("");
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

//Placera symbol                                    //TODO ----------Felhantering och skicka true eller ha bara void?----
    public void placeSymbol(int row, int column, char symbol){ 
        if (this.checkSpaceAvailable(row, column)){
            this.table[row][column] = symbol;
            this.spacesTaken++;
            if (this.spacesTaken >= this.spacesTotal){
                this.setIsFull(true);
            }
        }
   }
 

//Kolla om vinst
    public boolean checkIfWin(int row, int column, int numbersInRowToWin){
        int horizontal = checkHorizontal(row, column);
        int vertical = checkVertical(row, column);
        int diagonalDown = checkDiagonalDown(row, column);
        int diagonalUp = checkDiagonalUp(row, column);
/*
        System.out.println("Vertikalt : " + vertical);     ///För enkel felsökning         
        System.out.println("Horisontellt : " + horizontal);  
        System.out.println("Diagonalt nedåt: " + diagonalDown);
        System.out.println("Diagonalt uppåt: " + diagonalUp);
*/        
        if( vertical >= numbersInRowToWin || 
            horizontal >= numbersInRowToWin ||
            diagonalDown >= numbersInRowToWin ||
            diagonalUp >= numbersInRowToWin)
        {
            return true;
        }else{
            return false;
        }
    }

// ---------- Private methods -------

    private int checkHorizontal(int row, int column){
        int localNumbersInRow = 1; 
        localNumbersInRow = localNumbersInRow + checkLeft(row, column);
        localNumbersInRow = localNumbersInRow + checkRight(row, column);
        return localNumbersInRow;
    }

    private int checkVertical(int row, int column){
        int localNumbersInRow = 1; 
        localNumbersInRow = localNumbersInRow + checkUp(row, column);
        localNumbersInRow = localNumbersInRow + checkDown(row, column);
        return localNumbersInRow;
    }

    private int checkDiagonalDown(int row, int column){
        int localNumbersInRow = 1; 
        localNumbersInRow = localNumbersInRow + checkUpLeft(row, column);
        localNumbersInRow = localNumbersInRow + checkDownRight(row, column);
        return localNumbersInRow;
    }

    private int checkDiagonalUp(int row, int column){
        int localNumbersInRow = 1; 
        localNumbersInRow = localNumbersInRow + checkUpRight(row, column);
        localNumbersInRow = localNumbersInRow + checkDownLeft(row, column);
        return localNumbersInRow;
    }

    private int checkUp(int row, int column){
        int localNumbersInRow = 0;
        int i = row - 1;
        while(checkSpaceValid(i, column)){
            if(this.table[i][column] == this.table[row][column]){
                localNumbersInRow++;
                i--;
            }else{ 
                break;
            }
        }
        return localNumbersInRow;
    }
    private int checkDown(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        while(checkSpaceValid(i, column)){
            if(this.table[i][column] == this.table[row][column]){
                localNumbersinrow++;
                i++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkLeft(int row, int column){
        int localNumbersinrow = 0;
        int j = column - 1;
        while(checkSpaceValid(row, j)){
            if(this.table[row][j] == this.table[row][column]){
                localNumbersinrow++;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkRight(int row, int column){
        int localNumbersinrow = 0;
        int j = column + 1;
        while(checkSpaceValid(row, j)){
            if(this.table[row][j] == this.table[row][column]){
                localNumbersinrow++;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkUpLeft(int row, int column){
        int localNumbersinrow = 0;
        int i = row - 1;
        int j = column - 1;
        while(checkSpaceValid(i, j)){
            if(this.table[i][j] == this.table[row][column]){
                localNumbersinrow++;
                i--;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkDownRight(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        int j = column + 1;
        while(checkSpaceValid(i, j)){
            if(this.table[i][j] == this.table[row][column]){
                localNumbersinrow++;
                i++;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }


    private int checkUpRight(int row, int column){
        int localNumbersinrow = 0;
        int i = row - 1;
        int j = column + 1;
        while(checkSpaceValid(i, j)){
            if(this.table[i][j] == this.table[row][column]){
                localNumbersinrow++;
                i--;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkDownLeft(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        int j = column - 1;
        while(checkSpaceValid(i, j)){
            if(this.table[i][j] == this.table[row][column]){
                localNumbersinrow++;
                i++;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private void printRow(int x){
        if(x < 9){
            System.out.print(" ");      //Om talet är ensiffrigt, skriv ut extra mellanslag för att jämna till rader och kolumner
        }
        System.out.print((x+1) + " | ");


        for(char a : table[x]){
            System.out.print(a + " | ");
        }
        System.out.println("");
    }

    private void printColumnNumbers(){
        System.out.print("   | ");
        for(int m = 1; m <= this.table[0].length; m++){
            if(m <= 9){
                System.out.print(m + " | ");    //Om talet är ensiffrigt, skriv ut extra mellanslag för att jämna till rader och kolumner
            }else{
                System.out.print(m + "| ");
            }
        } 
        System.out.println("");
    }

    private void printLine(){
        for(int m = 0; m <= this.table[0].length; m++){
            System.out.print("----");
        }
        System.out.println("");
    }

    public boolean checkIfFull() {
        return this.getIsFull();
    }

    public void clear(){
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table[0].length; j++) {
                this.table[i][j] = ' ';
            }
        }
        this.setIsFull(false);
        this.setSpacesTaken(0);
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

    public int getRows() {
        return this.table.length;
    }

    public int getColulmns() {
        return this.table[0].length;
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