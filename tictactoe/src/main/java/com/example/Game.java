package tictactoe.src.main.java.com.example;
import java.util.Scanner;

public class Game {
    private Board board;
    private Players[] players;
    private int currentPlayerIdx;
    Game(Players player1, Players player2, int size){
        players = new Players[2];
        this.players[0] = player1;
        this.players[1] = player2; // players = Players[]{player1, player2};
        board = new Board(size);
        currentPlayerIdx = 0;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        while(!gameEnded){
            Players currentPlayer = players[currentPlayerIdx];
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(!board.isValidMove(row, col)){
                System.out.println("Please enter valid row and col: ");
            }
            char symbol = currentPlayer.getSymbol();
            board.placeSymbol(row, col, symbol);
            if(board.isWinner(row, col, symbol)){
                board.printBoard();
                System.out.println("Player "+ currentPlayerIdx + 1 + "has won the match!");
                gameEnded = true;
            }
            if(board.isFull()) gameEnded = true;
            currentPlayerIdx = nextPlayerIdx(currentPlayerIdx);
            scanner.close();
        }
    }
    public int nextPlayerIdx(int currentPlayerIdx){
        return currentPlayerIdx == 1 ? 0 : 1;
    }

}
