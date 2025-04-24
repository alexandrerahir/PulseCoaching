// Package
package com.pulsecoaching.model;

/**
 *  Classe Position
 * * Représente une position de joueur dans une équipe de football.
 */
public class Position {
    private String nom;
    private String abreviation;

    // Constructeur
    public Position(String nom, String abreviation) {
        this.nom = nom;
        this.abreviation = abreviation;
    }

    /**
     * toString
     * Représente la position sous forme de chaîne de caractères.
     * 
     * @return La chaîne de caractères représentant la position
     */
    public String toString() {
        return nom + " (" + abreviation + ")";
    }
}
