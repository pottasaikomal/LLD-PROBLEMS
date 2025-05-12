package tictactoe.src.main.java.com.example;

public class Board {
    private int size;
    private Cell[][] cells;

    Board(int size){
        this.size = size;
        cells = new Cell[size][size];
        initializeCells();
    }
    void initializeCells(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(cells[i][j].getSymbol() + " ");
            }
            System.out.println("______");
        }
    }
    public void placeSymbol(int row, int col, char symbol){
        cells[row][col].setSymbol(symbol);
    }
    public boolean isValidMove(int row, int col){
        if(row<0 || row>=size || col<0 || col>=size) return false;
        return cells[row][col].getSymbol() == ' ';
    }

    public boolean isWinner(int row, int col, char symbol){
        return checkRow(row,symbol) || checkCol(col, symbol) || checkDiagonals(symbol);
    }

    public boolean isFull(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(cells[i][j].getSymbol() == ' ') return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, char symbol){
        for(int i=0;i<size;i++){
            if(cells[row][i].getSymbol() != symbol) return false;
        }
        return true;
    }

    private boolean checkCol(int col, char symbol){
        for(int i=0;i<size;i++){
            if(cells[i][col].getSymbol() != symbol) return false;
        }
        return true;
    }

    private boolean checkDiagonals(char symbol){
        boolean diag1 = true, diag2 = true;
        for(int i=0;i<size;i++){
            if(cells[i][i].getSymbol() != symbol) diag1 = false;
            if(cells[i][size-i-1].getSymbol() != symbol) diag2 = false;
        }
        return diag1 || diag2;
    }
}
