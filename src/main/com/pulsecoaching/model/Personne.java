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
    protected Equipe equipe;

    // Constructeur
    public Personne(String nom, String prenom, LocalDate naissance, String nationalite, Equipe equipe) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.nationalite = nationalite;
        this.equipe = equipe;
    }

    // Getters et Setters

    /**
     * setEquipe
     * Permet de définir l'équipe de la personne.
     * 
     * @param equipe
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    /**
     * getEquipe
     * Permet de récupérer l'équipe de la personne.
     * 
     * @return L'équipe de la personne
     */
    public Equipe getEquipe() {
        return equipe;
    }
}
