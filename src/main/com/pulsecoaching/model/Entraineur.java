// Package
package com.pulsecoaching.model;

// Importation
import java.time.LocalDate;

/**
 * Classe Entraineur
 * Représente un entraîneur de football.
 */
public class Entraineur extends Personne {
    private String numeroLiscence;
    private String niveauCertification;
    
    /**
     * Constructeur
     * Initialise un entraîneur avec son nom, prénom, date de naissance, nationalité, numéro de licence et niveau de certification.
     * 
     * @param builder
     */
    public Entraineur(EntraineurBuilder builder) {
        super(builder.nom, builder.prenom, builder.naissance, builder.nationalite, builder.equipe);
        this.numeroLiscence = builder.numeroLiscence;
        this.niveauCertification = builder.niveauCertification;
    }

    /**
     * Classe EntraineurBuilder
     * Représente le constructeur de l'entraîneur.
     *
     * @return Une instance d'entraîneur
     */
    public static class EntraineurBuilder {
        private String nom;
        private String prenom;
        private LocalDate naissance;
        private String nationalite;
        private String numeroLiscence;
        private String niveauCertification;

        private Equipe equipe;

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

        // Numéro de licence de l'entraîneur
        public EntraineurBuilder numeroLiscence(String numeroLiscence) {
            this.numeroLiscence = numeroLiscence;
            return this;
        }

        // Niveau de certification de l'entraîneur
        public EntraineurBuilder niveauCertification(String niveauCertification) {
            this.niveauCertification = niveauCertification;
            return this;
        }

        // Équipe de l'entraîneur
        public EntraineurBuilder equipe(Equipe equipe) {
            this.equipe = equipe;
            return this;
        }

        // Méthode pour construire l'objet Entraineur
        public Entraineur build() {
            Entraineur entraineur = new Entraineur(this);

            if (equipe != null) {
                entraineur.setEquipe(null);
                equipe.ajouterEntraineur(entraineur);
            }

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
        .append(", numéro de licence : ").append(numeroLiscence)
        .append(", niveau de certification : ").append(niveauCertification);

        return sb.toString();
    }



    // Getters et Setters

    public String getNumeroLiscence() {
        return numeroLiscence;
    }

    public String getNiveauCertification() {
        return niveauCertification;
    }

}
