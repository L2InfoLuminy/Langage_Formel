package com.thevalil.sanjay.yashovardhan;

public class NonTerminal implements Symbol{

    private String description;

    public NonTerminal(String s){
        description = s;
    }

    public String toString() {
        return description;
    }
}
