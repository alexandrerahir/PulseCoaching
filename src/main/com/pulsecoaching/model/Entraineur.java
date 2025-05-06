// Package
package com.pulsecoaching.model;

// Importation
import java.time.LocalDate;

/**
 * Classe Entraineur
 * Représente un entraîneur de football.
 */
public class Entraineur extends Personne {
    private String fonction;
    
    // Constructeur
    public Entraineur(EntraineurBuilder builder) {
        super(builder.nom, builder.prenom, builder.naissance, builder.nationalite);
        this.fonction = builder.fonction;
    }

    // Constructeur builder
    public static class EntraineurBuilder {
        private String nom;
        private String prenom;
        private LocalDate naissance;
        private String nationalite;
        private String fonction;

        // Nom de l'entraîneur
        public EntraineurBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        // Prénom de l'entraîneur
        public EntraineurBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        // Date de naissance de l'entraîneur
        public EntraineurBuilder naissance(LocalDate naissance) {
            this.naissance = naissance;
            return this;
        }

        // Nationalité de l'entraîneur
        public EntraineurBuilder nationalite(String nationalite) {
            this.nationalite = nationalite;
            return this;
        }

        // Spécialité de l'entraîneur
        public EntraineurBuilder fonction(String fonction) {
            this.fonction = fonction;
            return this;
        }

        // Méthode pour construire l'objet Entraineur
        public Entraineur build() {
            Entraineur entraineur = new Entraineur(this);
            return entraineur;
        }

    }


    // Methodes de la classe Entraineur

    /**
     * toString
     * Représente l'entraîneur sous forme de chaîne de caractères.
     * 
     * @return La chaîne de caractères représentant l'entraîneur
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nom).append(" ").append(prenom)
        .append(", né le ").append(naissance)
        .append(", nationalité ").append(nationalite)
        .append(", fonction ").append(fonction);

        return sb.toString();
    }
}
