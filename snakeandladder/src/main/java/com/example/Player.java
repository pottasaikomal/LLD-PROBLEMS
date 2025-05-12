package com.example;

public class Player {
    private String name;
    private int num, currpos;
    public Player(String name, int num, int currpos){
        this.name = name;
        this.num = num;
        this.currpos = currpos;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getCurrpos() {
        return currpos;
    }
    public void setCurrpos(int currpos) {
        this.currpos = currpos;
    }
    
}
