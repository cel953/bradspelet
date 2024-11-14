public class Player {
    
    private String name;
    private char symbol;
    private int[] stats; //{Wins, Draws}

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        stats = new int[] {0, 0};
    }

    //-------Name & Symbol-------

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    //-------Stats-------

    public int getWins() {
        return stats[0];
    }
    public int getDraws() {
        return stats[1];
    }

    public void hasWon() {
        this.stats[0] =+ 1;
    }
    public void isDraw() {
        this.stats[1] =+ 1;
    }

}
