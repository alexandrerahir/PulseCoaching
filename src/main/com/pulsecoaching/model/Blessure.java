// Package
package com.pulsecoaching.model;

// Importation


/**
 * Classe Blessure
 * Représente une blessure d'un joueur de football.
 */
public class Blessure {
    private TypeBlessure type;
    private int matchsIndisponible;

    /**
     * Constructeur
     * Initialise une blessure avec son type et la durée d'indisponibilité en matchs.
     *
     * @param type le type de la blessure
     * @param matchsIndisponible le nombre de matchs d'indisponibilité
     */
    private Blessure(TypeBlessure type, int matchsIndisponible) {
        this.type = type;
        this.matchsIndisponible = matchsIndisponible;
    }



    // Methodes de la classe Blessure

    /**
     * nouvelleBlessure
     * Crée une nouvelle blessure avec un type aléatoire et la durée d'indisponibilité associée.
     *
     * @return une nouvelle instance de Blessure
     */
    public static Blessure nouvelleBlessure() {
        TypeBlessure type = TypeBlessure.getAleatoire();
        return new Blessure(type, type.getMatchIndisponible());
    }

    /**
     * decrementerMatchsIndisponible
     * Décrémente le nombre de matchs d'indisponibilité de la blessure.
     */
    public void decrementerMatchsIndisponible() {
        if (matchsIndisponible > 0) {
            matchsIndisponible--;
        }
    }

    /**
     * estActive
     * Vérifie si la blessure est encore active, c'est-à-dire si le joueur est toujours indisponible pour jouer.
     * 
     * @return true si le joueur est encore indisponible, false sinon
     */
    public boolean estActive() {
        return matchsIndisponible > 0;
    }

    /**
     * toString
     * Représente la blessure sous forme de chaîne de caractères.
     * 
     * @return la chaîne de caractères représentant la blessure
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type.getNom()).append(" (").append(matchsIndisponible).append(" matchs indisponible)");
        return sb.toString();
    }



    // Getters et Setters

    public TypeBlessure getType() {
        return type;
    }

    public int getMatchsIndisponible() {
        return matchsIndisponible;
    }

}
