package com.pulsecoaching.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nom;
    private String abreviation; 

    private Entraineur entraineur;
    private List<Joueur> joueurs;

    // Constructeur
    public Equipe(EquipeBuilder builder) {
        this.nom = builder.nom;
        this.abreviation = builder.abreviation;
        this.entraineur = builder.entraineur;
        this.joueurs = builder.joueurs;
    }

    // Constructeur builder
    public static class EquipeBuilder {
        private String nom;
        private String abreviation; 

        private Entraineur entraineur;
        private List<Joueur> joueurs = new ArrayList<>();

        // Nom de l'équipe
        public EquipeBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        // Abreviation de l'équipe
        public EquipeBuilder abreviation(String abreviation) {
            this.abreviation = abreviation;
            return this;
        }

        // Entraineur de l'équipe
        public EquipeBuilder entraineur(Entraineur entraineur) {
            this.entraineur = entraineur;
            return this;
        }

        // Liste des joueurs de l'équipe
        public EquipeBuilder joueurs(List<Joueur> joueurs) {
            this.joueurs = new ArrayList<>(joueurs);
            return this;
        }

        // Méthode pour construire l'objet Equipe
        public Equipe build() {
            return new Equipe(this);
        }
    }



    // Méthodes de la classe Equipe

    /**
     * ajouterJoueur
     * Ajoute un joueur à l'équipe.
     */
    public void ajouterJoueur(Joueur joueur) {
        joueurs.add(joueur);
    }

    /**
     * supprimerJoueur
     * Supprime un joueur de l'équipe.
     */
    public void supprimerJoueur(Joueur joueur) {
        joueurs.remove(joueur);
    }

    /**
     * toString
     * Représente l'équipe sous forme de chaîne de caractères.
     * 
     * @return La chaîne de caractères représentant l'équipe
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Équipe : ").append(nom).append(" (").append(abreviation).append(")\n")
          .append("Entraîneur : \n").append(entraineur.toString()).append("\n")
          .append("Joueurs : \n");
        for (Joueur joueur : joueurs) {
            sb.append(joueur.toString()).append("\n");
        }
        return sb.toString();
    }

}
