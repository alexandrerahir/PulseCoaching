// Package
package com.pulsecoaching.model;

/**
 * Enum TypeBlessure
 * Représente les différents types de blessures possibles pour un joueur.
 */
public enum TypeBlessure {
    ENTORSE("Entorse", 2),
    CLAQUAGE("Claquage", 3),
    FRACTURE("Fracture", 6),
    TENDINITE("Tendinite", 4);

    private String nom;
    private int matchsIndisponible;

    /**
     * Constructeur
     * Initialise un type de blessure avec son nom et la durée d'indisponibilité en matchs.
     * 
     * @param nom
     * @param dureeMatchs
     */
    TypeBlessure(String nom, int matchsIndisponible) {
        this.nom = nom;
        this.matchsIndisponible = matchsIndisponible;
    }


    // Getters et Setters

    public String getNom() {
        return nom;
    }

    public int getMatchIndisponible() {
        return matchsIndisponible;
    }

    public static TypeBlessure getAleatoire() {
        TypeBlessure[] valeurs = values();
        return valeurs[(int) (Math.random() * valeurs.length)];
    }

}