package com.thevalil.sanjay.yashovardhan;

public class Main {
    public static void main(String args[]) {
        String output;

        Terminal ta = new Terminal("a");
        Terminal tb = new Terminal("b");
        NonTerminal s = new NonTerminal("S");
        NonTerminal a = new NonTerminal("A");

        RightHandSide r = new RightHandSide();
        r.addLastSymbol(ta);
        r.addLastSymbol(s);
        r.addLastSymbol(tb);

        RightHandSide rb = new RightHandSide();

        RightHandSide rc = new RightHandSide();
        rc.addLastSymbol(a);
        rc.addLastSymbol(tb);

        RightHandSide rd = new RightHandSide();
        rd.addLastSymbol(ta);

        RightHandSide rss = new RightHandSide();
        rss.addLastSymbol(s);
        rss.addLastSymbol(s);

        RightHandSide ras = new RightHandSide();
        ras.addLastSymbol(a);
        ras.addLastSymbol(s);

        NonTerminal t = new NonTerminal("T");

        Grammar g = new Grammar(s);
        g.addRule(s,r);
        g.addRule(s,rb);
        g.addRule(s,rc);

        g.addRule(a,rd);

        g.addRule(t, rss);
        g.addRule(t, ras);


        output = g.toString();

        System.out.println(output);

        System.out.println(g.ErasableNonTerminal(a) + "== false");
        System.out.println(g.ErasableNonTerminal(s) + "== true");
        System.out.println(g.ErasableNonTerminal(a));
        System.out.println(g.ErasableNonTerminal(t));
        System.out.println(g.ErasableNonTerminal(s));
    }
}
