package BOardTest;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Board {

// -------- Class variables ----------

    private int numberOfRows = 3;
    private int numberOfColumns = 3;
    private String name = "";
    private boolean isFull = false;
    private int numberOfSpaces = 9;
    private Set<Integer> availableSpaces =  new HashSet<>();
    private List<Character> placedSymbols = new ArrayList<>();


//  --------  Methods ---------
//TODO skapa extra konstruktor för default-bräde 3x3
    //Skapa bräde
    public void create(String name, int rows, int columns){
        this.setnumberOfRows(rows);
        this.setnumberOfColumns(columns);
        this.setName(name);
    //----------Felhantering -- kan inte vara 0
        this.numberOfSpaces = rows*columns;
        for(int i = 1; i <= this.numberOfSpaces; i++){
            availableSpaces.add(i);
            placedSymbols.add(' ');
        }

    }

    //Skriv ut bräde i terminal
    public void print(){
    System.out.println("Here is your board!");
//    System.out.println(placedSymbols);
    for(int i = 1; i <= this.numberOfRows; i ++){
        for(int j = 1; j <= this.numberOfColumns; j++){
            int symbolsPlace = convertCoordinateToNumber(i, j);
            System.out.print(this.placedSymbols.get(symbolsPlace-1) + "|");
        }
        System.out.println("");
    }
    
    }

    //Kolla om space is valid - här kontrolleras att platsen finns med på brädet
    public boolean checkSpaceValid (int row, int column){
    // --------Felhantering: Om både rad och kolumn är mellan 1 och max görs nedan
        if(row >= 1 && row <= this.numberOfRows && column >= 1 && column <= this.numberOfColumns){
            return true;
        }else{
            return false;
        }
    }

    //Kolla om plats är ledig
    public boolean checkSpaceAvailable (int row, int column){
        int number = this.convertCoordinateToNumber(row, column);
        if(availableSpaces.contains(number)){
            return true; 
        }else{
            return false;
        }
    }

    //Placera symbol
    public void placeSymbol(int row, int column, char symbol){
    //----------Felhantering och skicka true eller ha bara void?----
            int number = this.convertCoordinateToNumber(row, column);
            placedSymbols.set(number-1, symbol);
            availableSpaces.remove(number);
            if(availableSpaces.isEmpty()){
                this.setIsFull(true);
            }
        }
        
    
//TODO
    //Kolla om vinst
    public boolean checkIfWin(int row, int column, int numberInRowToWin){

        int sentSymbolNumber = this.convertCoordinateToNumber(row, column);
        char sentChar = placedSymbols.get(sentSymbolNumber-1);
        int numbersInRow = 1;
        do{
            for(int i = 1; i < this.numberOfColumns; i++){
                if(this.checkSpaceValid(row, column-i)){
                    int tempspace = this.convertCoordinateToNumber(row, column-i);
                    if (sentChar == placedSymbols.get(tempspace-1)){
                        System.out.println("It is the same");
                        numbersInRow++;
                    }else{
                        System.out.println("Not the same!");    
                        break;
                    }
            }
       }
    }

        






        /*
        Idé: ta emot rad/kolumn. 

            Jämför med set placed symbols. 

            Kolla vilken symbol som finns där. 
            Kolla sedan först horisontellt: 
            
            KOlla om plats finns åt vänster (att inte brädet är slut).
            KOlla vad som finns där. 
            Om samma - gör om gå vidare till bräde tar slut eller annan symbol. 
            Om annat - kolla om plats finns åt höger. 
            Kolla vad om finns där. 
            Om samma - gör om gå vidare till bräde tar slut eller annan symbol. 
            
            Samtidigt: logga hur många i rad. 
            Jämför med antal man ska ha i rad. 
            Om vinst - bryt och skicka true. 
            Om inte - gör inget. 


            Sedan vertikalt. Samma procedur. 
            Sedan diagonalt ena hållet. Samma procedur. 
            Sedan diagonalt andra hållet. Samma procedur. 




        */




        boolean isWin = false;
        return isWin;
    }

    //Konvertera rad + kolumn till nummer
    public int convertCoordinateToNumber(int row, int column){
    // --------Felhantering för avgränsning om rad/kolum när fel? Tex skicka tillbaka 0 eller -1 om rad eller kolumn inte stämmer 
        int number =(row - 1)*this.numberOfColumns + column;
        return number;
    }
  



// ------- Getters and setters --------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public int getnumberOfRows() {
        return this.numberOfRows;
    }

    public void setnumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getnumberOfColumns() {
        return this.numberOfColumns;
    }

    public void setnumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public boolean isIsFull() {
        return this.isFull;
    }

    public boolean getIsFull() {
        return this.isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

}