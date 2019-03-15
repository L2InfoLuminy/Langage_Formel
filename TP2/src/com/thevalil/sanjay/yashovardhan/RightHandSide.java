package com.thevalil.sanjay.yashovardhan;

import java.util.ArrayList;
import java.util.Iterator;

public class RightHandSide {
   private ArrayList<Symbol> rhs;


    /**
     * construit un membre droit vide, donc valant epsilon
     */
   public RightHandSide() {
      rhs = new ArrayList<Symbol>();
   }


    /**
     * ajoute un symbole en dernière position d'un membre droit
     */
   public void addLastSymbol(Symbol s) {
     rhs.add(s);
   }


    /**
     * retourne la liste des symboles constituant le membre droit
     * @return une liste de symboles
     */
    public ArrayList<Symbol> getSymbols() {
        return rhs;
    }

    /**
     * teste si le membre droit est réduit à epsilon
     * @return vrai (true) si le membre droit ne contient aucun Symbol
     */
    public Boolean isEpsilon() {
        return rhs.isEmpty();
    }


    /**
     * teste si le membre droit est réduit à un terminal
     * @return vrai (true) si le membre droit ne contient qu'un élément qui est un terminal
     */
   public Boolean isTerminal() {
       return rhs.size() == 1 && rhs.get(0) instanceof Terminal;
   }


    /**
     * teste si le membre droit est réduit à un seul non-terminal
     * @return vrai (true) si le membre droit ne contient qu'un élément qui est un non-terminal
     */
    public Boolean isSingleNonTerminal() {
        return rhs.size() == 1 && rhs.get(0) instanceof NonTerminal;
    }



    /**
     * retourne une chaine, concatenation des symboles du membre droit
     * @return le membre droit sous la forme d'une chaine
     */

    public String toString() {
        String result = "";
        for (Symbol symbol : rhs) {
            result += symbol.toString();
        }
        return result;
    }
}
