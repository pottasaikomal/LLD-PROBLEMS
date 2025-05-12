package com.example;

public class Main {
    public static void main(String[] args) {
        int size = 4;
        int huddles = 10;
        int playercnt = 2;
        System.out.println("test");
        Game game = new Game(size, huddles, playercnt);
        game.start();
    }
}


/*
  game requires - board, players
  board - will have cells with numbers.
  board - will have snakes and ladders.
  --> before starting of game we need to give input of snake and ladders - or we can statically place few snakes and ladders -> use hashset for this
  -- player will have name and color

 */