// Package
package com.pulsecoaching.model;

// Importation
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Classe Joueur
 * Représente un joueur de football.
 */
public class Joueur extends Personne {
    private int taille;
    private int poids;
    private int endurance;
    private int qualite;

    private Set<Position> positions;

    // Constructeur
    private Joueur(JoueurBuilder builder) {
        super(builder.nom, builder.prenom, builder.naissance, builder.nationalite);
        this.taille = builder.taille;
        this.poids = builder.poids;
        this.endurance = builder.endurance;
        this.qualite = builder.qualite;
        this.positions = builder.positions;
    }

    // Constructeur builder
    public static class JoueurBuilder {
        private String nom;
        private String prenom;
        private LocalDate naissance;
        private String nationalite;
        private int taille;
        private int poids;
        private int endurance = 100;
        private int qualite = 0;

        private Set<Position> positions = new LinkedHashSet<>();

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

        // Positions du joueur
        public JoueurBuilder ajouterPosition(Position position) {
            // Vérification du nombre de positions
            if (this.positions.size() >= 3) {
                throw new IllegalArgumentException("Un joueur ne peut avoir que 3 positions maximum.");
            }

            // Rajout de la position
            this.positions.add(position);
            return this;
        }

        // Construction du joueur
        public Joueur build() {
            // Véfication si le joueur a au moins une position
            if (positions.isEmpty()) {
                throw new IllegalStateException("Un joueur doit avoir au moins une position.");
            }

            return new Joueur(this);
        }

    }



    // Méthodes de la classe Joueur

    /**
     * realiserMatch
     * Diminue l'endurance du joueur de 40% et augmente sa qualité de 5%.
     */
    public void realiserMatch() {
        this.endurance = Math.max(this.endurance - 40, 0);
        this.qualite = Math.min(this.qualite + 5, 100);
    }

    /**
     * realiserEntrainement
     * Diminue l'endurance du joueur de 20% et augmente sa qualité de 7%.
     */
    public void realiserEntrainement() {
        this.endurance = Math.max(this.endurance - 20, 0);
        this.qualite = Math.min(this.qualite + 7, 100);
    }

    /**
     * realiserRepos
     * Augmente l'endurance du joueur de 30% et diminue sa qualité de 3%.
     */
    public void realiserRepos() {
        this.endurance = Math.min(this.endurance + 30, 100);
        this.qualite = Math.max(this.qualite - 3, 0);
    }

    /**
     * toString
     * Représente le joueur sous forme de chaîne de caractères.
     * 
     * @return une chaîne de caractères représentant le joueur
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nom).append(" ").append(prenom)
        .append(", né le ").append(naissance)
        .append(", nationalité ").append(nationalite)
        .append(", taille ").append(taille).append("cm")
        .append(", poids ").append(poids).append("kg")
        .append(", endurance ").append(endurance).append("%")
        .append(", qualité ").append(qualite).append("%")
        .append(". Positions : ");
        for (Position position : positions) {
            sb.append(position.toString()).append(", ");
        }

        return sb.toString().substring(0, sb.length() - 2);
    }
    
}
