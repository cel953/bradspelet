public class Board {

// -------- Class variables ----------

    private String name = "Gameboard";
    private boolean isFull = false;
    private char[][] table; 
    private int spacesTaken = 0;
    private int spacesTotal = 9;


//  -------- Public methods ---------

//Skapa bräde
    
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
    
//Kolla om platsen finns med på brädet
    public boolean checkSpaceValid (int row, int column){
        return checkSpaceValid(this.getTable(), row, column);
    }
//Method overloading
    public static boolean checkSpaceValid(char[][] table, int row, int column){
        if(row >= 0 && row < table.length && column >= 0 && column < table[0].length){
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
        if (this.checkSpaceAvailable(row, column)){
            this.table[row][column] = symbol;
            this.spacesTaken++;
            if (this.spacesTaken >= this.spacesTotal){
                this.setIsFull(true);
            }
        }
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

// ---------- Private methods -------


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