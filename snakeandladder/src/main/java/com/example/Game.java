package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Board board;
    private Player[] players; // List
    private int playercnt;
    private int currentPlayerIdx;
    private List<Integer> leaderBoard;
    private int size;
    private Scanner scanner;

    public Game(int size, int huddles, int playercnt) {
        scanner = new Scanner(System.in);
        board = new Board(size, huddles);
        players = new Player[playercnt]; // create in main
        this.playercnt = playercnt;
        leaderBoard = new ArrayList<>();
        currentPlayerIdx = 0;
        this.size = size;
        intializePlayers();
    }

    private void intializePlayers() {
        for (int i = 0; i < playercnt; i++) {
            String name = "ABC";
            players[i] = new Player(name, i, 0);
        }
    }

    public void start() {
        while (leaderBoard.size() != playercnt - 1) {
            Player currentPlayer = players[currentPlayerIdx];
            System.out.println("Player " + currentPlayerIdx + " please roll your dice.");
            System.out.println("Press any number to roll the dice: ");
            int str = scanner.nextInt();
            int nextmv = ThreadLocalRandom.current().nextInt(1, 7);
            System.out.println("dice no: " + nextmv);
            int currpos = currentPlayer.getCurrpos();
            currpos += nextmv;
            if (currpos >= size)
                leaderBoard.add(currentPlayerIdx);
            else
                currpos = board.nextLocation(currpos);
            currentPlayerIdx = (currentPlayerIdx + 1) % playercnt;
            while (players[currentPlayerIdx].getCurrpos() >= size) {
                currentPlayerIdx = (currentPlayerIdx + 1) % playercnt;
            }
        }
        System.out.println("LEADER BOARD:");
        for (int i = 1; i <= playercnt; i++) {
            System.out.println(i + ": " + players[leaderBoard.get(i - 1)].getName());
        }
    }
}
