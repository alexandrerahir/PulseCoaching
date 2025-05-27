// Package
package com.pulsecoaching.model;

// Importation
import com.pulsecoaching.exception.Joueur.*;
import java.time.LocalDate;
import java.util.Arrays;
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
        super(builder.nom, builder.prenom, builder.naissance, builder.nationalite, builder.equipe);
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

        private Equipe equipe;
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

        // Equipe du joueur
        public JoueurBuilder equipe(Equipe equipe) {
            this.equipe = equipe;
            return this;
        }

        // Positions du joueur
        public JoueurBuilder positions(Position... position) {
            // Vérification si le joueur dépasse 3 positions
            if (position.length > 3) {
                throw new JoueurTropDePositionsException(nom + " " + prenom);
            }

            // Vérification si le joueur a déjà la position de gardien de but
            if (Arrays.asList(position).contains(Position.GB) && position.length > 1) {
                throw new JoueurGardienAvecAutresPositionsException(nom + " " + prenom);
            }

            this.positions = new LinkedHashSet<>(Set.of(position));
            return this;
        }

        // Construction du joueur
        public Joueur build() {
            Joueur joueur = new Joueur(this);

            // Véfication si le joueur a au moins une position
            if (positions.isEmpty()) {
                throw new JoueurSansPositionException(nom + " " + prenom);
            }

            return joueur;
        }

    }



    // Méthodes de la classe Joueur

    /**
     * augmenterEndurance
     * Augmente l'endurance du joueur d'un pourcentage donné.
     * 
     * @param pourcentage 
     * 
     * @throws IllegalArgumentException si le pourcentage est inférieur à 0 ou supérieur à 100
     */
    public void augmenterEndurance(int pourcentage) {
        // Verification si le pourcentage est compris entre 0 et 100
        if (pourcentage < 0 || pourcentage > 100) {
            throw new PourcentageInvalideException(pourcentage);
        }

        this.endurance += pourcentage;

        // Vérification si l'endurance dépasse 100%
        if (this.endurance > 100) {
            this.endurance = 100;
        }
    }

    /**
     * diminuerEndurance
     * Diminue l'endurance du joueur d'un pourcentage donné.
     * 
     * @param pourcentage 
     * 
     * @throws IllegalArgumentException si le pourcentage est inférieur à 0 ou supérieur à 100
     */
    public void diminuerEndurance(int pourcentage) {
        // Verification si le pourcentage est compris entre 0 et 100
        if (pourcentage < 0 || pourcentage > 100) {
            throw new PourcentageInvalideException(pourcentage);
        }

        this.endurance -= pourcentage;

        // Vérification si l'endurance est inférieure à 0%
        if (this.endurance < 0) {
            this.endurance = 0;
        }
    }

    /**
     * augmenterQualite
     * Augmente la qualité du joueur d'un pourcentage donné.
     * 
     * @param pourcentage 
     * 
     * @throws IllegalArgumentException si le pourcentage est inférieur à 0 ou supérieur à 100
     */
    public void augmenterQualite(int pourcentage) {
        // Verification si le pourcentage est compris entre 0 et 100
        if (pourcentage < 0 || pourcentage > 100) {
            throw new PourcentageInvalideException(pourcentage);
        }

        this.qualite += pourcentage;

        // Vérification si la qualité dépasse 100%
        if (this.qualite > 100) {
            this.qualite = 100;
        }
    }

    /**
     * diminuerQualite
     * Diminue la qualité du joueur d'un pourcentage donné.
     * 
     * @param pourcentage 
     * 
     * @throws IllegalArgumentException si le pourcentage est inférieur à 0 ou supérieur à 100
     */
    public void diminuerQualite(int pourcentage) {
        // Verification si le pourcentage est compris entre 0 et 100
        if (pourcentage < 0 || pourcentage > 100) {
            throw new PourcentageInvalideException(pourcentage);
        }

        this.qualite -= pourcentage;

        // Vérification si la qualité est inférieure à 0%
        if (this.qualite < 0) {
            this.qualite = 0;
        }
    }

    /**
     * ajouterPosition
     * Ajoute une position au joueur.
     * 
     * @param position
     * 
     * @throws IllegalStateException si le joueur a déjà 3 positions
     * @throws IllegalStateException si le joueur a déjà la position de gardien de but
     */
    public void ajouterPosition(Position position) {
        // Vérification si le joueur a déjà 3 positions
        if (positions.size() >= 3) {
            throw new JoueurTropDePositionsException(nom + " " + prenom);
        }

        // Vérification si le joueur a déjà la position de gardien de but
        if(positions.contains(Position.GB) || position == Position.GB) {
            throw new JoueurGardienAvecAutresPositionsException(nom + " " + prenom);
        }

        positions.add(position);
    }

    /**
     * retirerPosition
     * Retire une position du joueur.
     * 
     * @param position
     * 
     * @throws IllegalStateException si le joueur n'a pas au moins une position restante
     */    
    public void retirerPosition(Position position) {
        // Vérification si le joueur a au moins une position restante
        if (positions.size() <= 1) {
            throw new JoueurSansPositionException(nom + " " + prenom);
        }

        positions.remove(position);
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



    // Getters et Setters

    public int getTaille() {
        return taille;
    }

    public int getPoids() {
        return poids;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getQualite() {
        return qualite;
    }

    public void setQualite(int qualite) {
        this.qualite = qualite;
    }

    public Set<Position> getPositions() {
        return positions;
    }

}
