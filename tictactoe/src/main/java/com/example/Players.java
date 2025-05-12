package tictactoe.src.main.java.com.example;

public class Players {
    private String name;
    private char symbol;
    Players(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
}
