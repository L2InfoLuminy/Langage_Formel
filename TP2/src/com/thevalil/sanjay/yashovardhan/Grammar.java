package com.thevalil.sanjay.yashovardhan;

import java.util.*;

public class Grammar {
    private NonTerminal axiom;
    private HashMap<NonTerminal, ArrayList<RightHandSide>> Rules;


    /**
    * construit une grammaire d'axiome ax et sans règle de production
    */
    public Grammar(NonTerminal ax) {
        this.axiom = ax;
        this.Rules = new HashMap<NonTerminal, ArrayList<RightHandSide>>();
    }

    /**
     * ajoute une nouvelle règle de production à la grammaire avec n pour membre gauche et r pout membre droit
     */
    public void addRule(NonTerminal n, RightHandSide r) {
        ArrayList<RightHandSide> RhsList;
        if (Rules.containsKey(n)) {
            RhsList = Rules.get(n);
            Rules.remove(n);
        } else {
            RhsList = new ArrayList<RightHandSide>();
        }
        RhsList.add(r);
        Rules.put(n, RhsList);
     }



    /**
     * retourne l'axiome de la grammaire
     * @return le NonTerminal axiome de la grammaire
     */
    public NonTerminal getAxiom() {
        return axiom;
    }



    /**
     * modifie l'axiome de la grammaire
     */
    public void setAxiom(NonTerminal n) {
        axiom = n;
    }

    /**
    * teste si un non-terminal peut s'effacer, c'est-à-dire se dériver en epsilon
    * @return vrai (true) si le non-terminal peut se dériver en epsilon
    */
    public Boolean ErasableNonTerminal(NonTerminal N) {
        ArrayList<RightHandSide> rightHandSides = Rules.get(N);
        for (RightHandSide rightHandSide : rightHandSides) {
            if (ErasableRhs(rightHandSide)) return true;

            if (testNotTerminal(rightHandSide)) return true;
        }
        return false;
    }

    private Boolean testNotTerminal(RightHandSide r) {
        for (Symbol symbol : r.getSymbols()) {
            if (symbol instanceof Terminal) return false;
            if (ErasableNonTerminal((NonTerminal) symbol)) return true;
        }
        return false;
    }



    /**
     * teste si une suite de Symbol formant un membre droit peut s'effacer, c'est-à-dire se dériver en epsilon
     * @return vrai (true) si un membre droit peut se dériver en epsilon
     */
    public Boolean ErasableRhs(RightHandSide r) {
        return r.isEpsilon();
    }


    public String toString() {
        String result = "";
        for (Map.Entry<NonTerminal, ArrayList<RightHandSide>> key: Rules.entrySet()) {
            NonTerminal nonTerminal = key.getKey();
            ArrayList<RightHandSide> rightHandSides = key.getValue();
            String rules = nonTerminal.toString() + " -> ";
            for (RightHandSide rightHandSide : rightHandSides) {
                rules += rightHandSide.toString() + " | ";
            }
            result += rules.substring(0, rules.length() - 3) + "\n";
        }
        return result;
    }
}