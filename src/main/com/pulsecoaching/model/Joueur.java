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
public class Joueur {
    private String nom;
    private String prenom;
    private LocalDate naissance;
    private String nationalite;
    private int taille;
    private int poids;

    private Set<Position> positions;

    // Constructeur builder
    public static class JoueurBuilder{
        private String nom;
        private String prenom;
        private LocalDate naissance;
        private String nationalite;
        private int taille;
        private int poids;

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
            // Vérification de la position
            if (this.positions.contains(position)) {
                return this; // ignoré silencieusement si déjà présent
            }

            // Vérification du nombre de positions
            if (this.positions.size() >= 3) {
                throw new IllegalArgumentException("Un joueur ne peut avoir que 3 positions maximum.");
            }

            // Rajout de la position
            this.positions.add(position);
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

            // Vérification si le joueur a au moins une position
            if (positions.isEmpty()) {
                throw new IllegalStateException("Un joueur doit avoir au moins une position.");
            }
            joueur.positions = this.positions;

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
        StringBuilder sb = new StringBuilder();
        sb.append(nom).append(" ").append(prenom)
        .append(", né le ").append(naissance)
        .append(", nationalité ").append(nationalite)
        .append(", taille ").append(taille).append("cm")
        .append(", poids ").append(poids).append("kg")
        .append(". Positions : ");
        for (Position position : positions) {
            sb.append(position.toString()).append(", ");
        }

        return sb.toString().substring(0, sb.length() - 2);
    }

}