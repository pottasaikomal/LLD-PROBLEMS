import java.util.*;

public class TicTacToe_LLD {
    public static void main(String[] args) {
        Player p1 = new Player("Player 1", 'X');
        Player p2 = new Player("Player 2", 'O');
        Game game = new Game(p1, p2, 3);
        game.start();
    }
}

class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}


class Cell {
    private int row;
    private int col;
    private char value; 

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = ' '; 
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}


class Board {
    private int size;
    private Cell[][] cells;

    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void printBoard() {}

    public boolean placeSymbol(int row, int col, char symbol) {
        if (cells[row][col].getValue() == ' ') {
            cells[row][col].setValue(symbol);
            return true;
        }
        return false;
    }


    public boolean checkWin(char symbol) {
        for (int i = 0; i < size; i++) {
            if (checkRow(i, symbol) || checkColumn(i, symbol)) {
                return true;
            }
        }
        return checkDiagonals(symbol);
    }

    private boolean checkRow(int row, char symbol) {
        for (int j = 0; j < size; j++) {
            if (cells[row][j].getValue() != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, char symbol) {
        for (int i = 0; i < size; i++) {
            if (cells[i][col].getValue() != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(char symbol) {
        boolean diag1 = true;
        boolean diag2 = true;
        for (int i = 0; i < size; i++) {
            diag1 &= (cells[i][i].getValue() == symbol);
            diag2 &= (cells[i][size - i - 1].getValue() == symbol);
        }
        return diag1 || diag2;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getValue() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIdx;

    public Game(Player p1, Player p2, int boardSize) {
        board = new Board(boardSize);
        players = new Player[]{p1, p2};
        currentPlayerIdx = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            board.printBoard();
            Player currentPlayer = players[currentPlayerIdx];
            
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (!board.placeSymbol(row, col, currentPlayer.getSymbol())) {
                System.out.println("Cell already occupied. Try a different move.");
                continue;
            }

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnded = true;
            } else if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayerIdx = (currentPlayerIdx + 1) % 2;
            }
        }
        scanner.close();
    }
}