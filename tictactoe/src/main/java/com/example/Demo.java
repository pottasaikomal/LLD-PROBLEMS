package tictactoe.src.main.java.com.example;

public class Demo {
    public static void main(String[] args) {
        Players p1 = new Players("Player 1", 'X');
        Players p2 = new Players("Player 2", 'O');
        Game game = new Game(p1, p2, 3);
        game.start();
    }
}