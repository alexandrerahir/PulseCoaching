// Package
package com.pulsecoaching.model;

/**
 * Enumération Position
 * Représente les différentes positions d'un joueur de football.
 */
public enum Position {
    GB("Gardien de but", "GB"),
    DC("Défenseur central", "DC"),
    DD("Défenseur droit", "DD"),
    DG("Défenseur gauche", "DG"),
    MC("Milieu central", "MC"),
    BU("Buteur", "BU"),
    AD("Ailier droit", "AD"),
    AG("Ailier gauche", "AG");

    // Attributs
    private String nom;
    private String abreviation;

    // Constructeur
    Position(String nom, String abreviation) {
        this.nom = nom;
        this.abreviation = abreviation;
    }

    // Methodes de l'énumération

    /**
     * toString
     * Représente la position sous forme de chaîne de caractères.
     * 
     * @return la chaîne de caractères représentant la position
     */
    public String toString() {
        return nom + " (" + abreviation + ")";
    }



    // Getters et Setters

    public String getNom() {
        return nom;
    }

    public String getAbreviation() {
        return abreviation;
    }
    
}
