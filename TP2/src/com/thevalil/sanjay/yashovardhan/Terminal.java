package com.thevalil.sanjay.yashovardhan;

public class Terminal implements Symbol{

    private String description;

    public Terminal(String s){
        description = s;
    }

    public String toString() {
        return description;
    }
}
