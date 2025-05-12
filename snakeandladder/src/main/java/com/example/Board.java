package com.example;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private Cell[] cells;
    private int size;
    private int huddles;
    private HashMap<Integer,Integer> snakeandladders;
    public Board(int size, int huddles){
        this.size = size;
        this.huddles = huddles;
        cells = new Cell[size+1];
        snakeandladders = new HashMap<>();
        initializeBoard();
    }
    private void initializeBoard(){
        for(int i=0;i<=size;i++){
            cells[i] = new Cell(i);
        }
        while(snakeandladders.size() < huddles){
            int n1 = ThreadLocalRandom.current().nextInt(1,size);
            int n2 = ThreadLocalRandom.current().nextInt(1,size);
            while(n2 == n1){
                n2 = ThreadLocalRandom.current().nextInt(1,size);
            }
            snakeandladders.put(n1, n2);
        }
    }
    public int nextLocation(int curr){
        if(snakeandladders.containsKey(curr)) return snakeandladders.get(curr);
        return curr;
    }
}
