// Package
package com.pulsecoaching.model;

// Importation
import java.time.LocalDate;

/**
 * Classe Joueur
 * Représente un joueur de football.
 */
public class Joueur {
    private String nom;
    private String prenom;
    private LocalDate naissance;
    private String nationalite;
    private int taille;
    private int poids;

    // Constructeur builder
    public static class JoueurBuilder{
        private String nom;
        private String prenom;
        private LocalDate naissance;
        private String nationalite;
        private int taille;
        private int poids;

        // Nom du joueur
        public JoueurBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        // Prénom du joueur
        public JoueurBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        // Date de naissance du joueur
        public JoueurBuilder naissance(LocalDate naissance) {
            this.naissance = naissance;
            return this;
        }

        // Nationalité du joueur
        public JoueurBuilder nationalite(String nationalite) {
            this.nationalite = nationalite;
            return this;
        }

        // Taille du joueur
        public JoueurBuilder taille(int taille) {
            this.taille = taille;
            return this;
        }

        // Poids du joueur
        public JoueurBuilder poids(int poids) {
            this.poids = poids;
            return this;
        }

        // Méthode de construction du joueur
        public Joueur build() {
            Joueur joueur = new Joueur();
            joueur.nom = nom;
            joueur.prenom = prenom;
            joueur.naissance = naissance;
            joueur.nationalite = nationalite;
            joueur.taille = taille;
            joueur.poids = poids;
            return joueur;
        }
    }

    /**
     * toString
     * Représente le joueur sous forme de chaîne de caractères.
     * 
     * @return une chaîne de caractères représentant le joueur
     */
    public String toString() {
        return nom + " " + prenom + ", né le " + naissance + ", nationalité " + nationalite + ", taille " + taille + "cm, poids " + poids + "kg.";
    }

}