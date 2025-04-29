// Package
package com.pulsecoaching.model;

// Importation
import java.time.LocalDate;

/**
 * Classe Personne
 * Représente une personne.
 */
public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected LocalDate naissance;
    protected String nationalite;

    // Constructeur
    public Personne(String nom, String prenom, LocalDate naissance, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.nationalite = nationalite;
    }
}
