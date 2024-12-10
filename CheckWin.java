public class CheckWin {

    private static char[][] tableCopy;

    //Kontrollera vinst
    public static boolean winCheck(char[][] table, int row, int column, int winCondition){
        
        tableCopy = table;
        int horizontal = checkHorizontal(row, column);
        int vertical = checkVertical(row, column);
        int diagonalDown = checkDiagonalDown(row, column);
        int diagonalUp = checkDiagonalUp(row, column);
    
        if( vertical >= winCondition || 
            horizontal >= winCondition ||
            diagonalDown >= winCondition ||
            diagonalUp >= winCondition)
        {
            return true;
        }else{
            return false;
        }
    }


    private static int checkHorizontal(int row, int column){
        int localNumbersInRow = 1; 
        localNumbersInRow = localNumbersInRow + checkLeft(row, column);
        localNumbersInRow = localNumbersInRow + checkRight(row, column);
        return localNumbersInRow;
    }

    private static int checkVertical(int row, int column){
        int localNumbersInRow = 1; 
        localNumbersInRow = localNumbersInRow + checkUp(row, column);
        localNumbersInRow = localNumbersInRow + checkDown(row, column);
        return localNumbersInRow;
    }

    private static int checkDiagonalDown(int row, int column){
        int localNumbersInRow = 1; 
        localNumbersInRow = localNumbersInRow + checkUpLeft(row, column);
        localNumbersInRow = localNumbersInRow + checkDownRight(row, column);
        return localNumbersInRow;
    }

    private static int checkDiagonalUp(int row, int column){
        int localNumbersInRow = 1; 
        localNumbersInRow = localNumbersInRow + checkUpRight(row, column);
        localNumbersInRow = localNumbersInRow + checkDownLeft(row, column);
        return localNumbersInRow;
    }

    private static int checkUp(int row, int column){
        int localNumbersInRow = 0;
        int i = row - 1;
        while(Board.checkSpaceValid(tableCopy, i, column)){
                        
            if(tableCopy[i][column] == tableCopy[row][column]){
                localNumbersInRow++;
                i--;
            }else{ 
                break;
            }
        }
        return localNumbersInRow;
    }
    private static int checkDown(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        while(Board.checkSpaceValid(tableCopy, i, column)){
            if(tableCopy[i][column] == tableCopy[row][column]){
                localNumbersinrow++;
                i++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private static int checkLeft(int row, int column){
        int localNumbersinrow = 0;
        int j = column - 1;
        while(Board.checkSpaceValid(tableCopy, row, j)){
            if(tableCopy[row][j] == tableCopy[row][column]){
                localNumbersinrow++;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private static int checkRight(int row, int column){
        int localNumbersinrow = 0;
        int j = column + 1;
        while(Board.checkSpaceValid(tableCopy, row, j)){
            if(tableCopy[row][j] == tableCopy[row][column]){
                localNumbersinrow++;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private static int checkUpLeft(int row, int column){
        int localNumbersinrow = 0;
        int i = row - 1;
        int j = column - 1;
        while(Board.checkSpaceValid(tableCopy, i, j)){
            if(tableCopy[i][j] == tableCopy[row][column]){
                localNumbersinrow++;
                i--;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private static int checkDownRight(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        int j = column + 1;
        while(Board.checkSpaceValid(tableCopy, i, j)){
            if(tableCopy[i][j] == tableCopy[row][column]){
                localNumbersinrow++;
                i++;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }


    private static int checkUpRight(int row, int column){
        int localNumbersinrow = 0;
        int i = row - 1;
        int j = column + 1;
        while(Board.checkSpaceValid(tableCopy, i, j)){
            if(tableCopy[i][j] == tableCopy[row][column]){
                localNumbersinrow++;
                i--;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private static int checkDownLeft(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        int j = column - 1;
        while(Board.checkSpaceValid(tableCopy, i, j)){
            if(tableCopy[i][j] == tableCopy[row][column]){
                localNumbersinrow++;
                i++;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

}
