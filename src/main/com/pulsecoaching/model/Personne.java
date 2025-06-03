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

    /**
     * Constructeur
     * Initialise une personne avec son nom, prénom, date de naissance, nationalité et équipe.
     * 
     * @param nom
     * @param prenom
     * @param naissance
     * @param nationalite
     * @param equipe
     */
    public Personne(String nom, String prenom, LocalDate naissance, String nationalite, Equipe equipe) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.nationalite = nationalite;
        this.equipe = equipe;
    }



    // Getters et Setters

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomPrenom() {
        return nom + " " + prenom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

}
