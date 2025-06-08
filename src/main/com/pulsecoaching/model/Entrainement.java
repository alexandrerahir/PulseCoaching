// Package
package com.pulsecoaching.model;

// Importation
import java.time.LocalDate;
import java.util.Set;

/**
 * Classe Entrainement
 * Représente un entraînement de football.
 */
public class Entrainement {
    private LocalDate date;
    private Set<Joueur> presents;
    private Set<Joueur> absents;
    private Set<Joueur> blesses;
    private Equipe equipe;

    /**
     * Constructeur
     * Initialise un entraînement avec sa date, les joueurs présents, absents et l'équipe associée.
     * 
     * @param date la date de l'entraînement
     * @param presents les joueurs présents à l'entraînement
     * @param absents les joueurs absents à l'entraînement
     * @param blesses les joueurs blessés
     * @param equipe l'équipe associée à l'entraînement
     */
    public Entrainement(LocalDate date, Set<Joueur> presents, Set<Joueur> absents, Set<Joueur> blesses ,Equipe equipe) {
        this.date = date;
        this.presents = presents;
        this.absents = absents;
        this.blesses = blesses;
        this.equipe = equipe;
    }



    // Méthodes de la classe Entrainement

    /**
     * nouvelleSeance
     * Crée une nouvelle séance d'entraînement.
     * 
     * @param date la date de l'entraînement
     * @param presents les joueurs présents à l'entraînement
     * @param absents les joueurs absents à l'entraînement
     * @param blesses les joueurs blessés (optionnel, par défaut vide)
     * @param equipe l'équipe associée à l'entraînement
     * 
     * @return une nouvelle instance d'Entrainement
     */
    public static Entrainement nouvelleSeance(LocalDate date, Set<Joueur> presents, Set<Joueur> absents, Set<Joueur> blesses, Equipe equipe) {
        return new Entrainement(date, presents, absents, blesses, equipe);
    }

    /**
     * toString
     * Représente l'entraînement sous forme de chaîne de caractères.
     * 
     * @return la chaîne de caractères représentant l'entraînement
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Affichage date de l'entraînement et de l'équipe
        sb.append("Entraînement le ").append(date).append("\n");
        sb.append("Équipe : ").append(equipe.getNom()).append("\n");

        // Affichage des joueurs présents
        sb.append("Présents : ");
        if (presents.isEmpty()) {
            sb.append("Aucun joueur présent");
        } else {
            for (Joueur joueur : presents) {
                sb.append(joueur.getNomPrenom()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        // Affichage des joueurs absents
        sb.append("\nAbsents : ");
        if (absents.isEmpty()) {
            sb.append("Aucun joueur absent");
        } else {
            for (Joueur joueur : absents) {
                sb.append(joueur.getNomPrenom()).append(", ");
            }
            sb.setLength(sb.length() - 2); 
        }

        // Affichage des joueurs blessés    
        sb.append("\nBlessés pendant l'entraînement : ");
        if (blesses.isEmpty()) {
            sb.append("Aucun joueur blessé");
        } else {
            for (Joueur joueur : blesses) {
                sb.append(joueur.getNomPrenom()).append(" [").append(joueur.getBlessure().toString()).append("], ");
            }
            sb.setLength(sb.length() - 2); 
        }

        return sb.toString();
    }



    // Getters et Setters

    public LocalDate getDate() {
        return date;
    }

    public Set<Joueur> getPresents() {
        return presents;
    }

    public Set<Joueur> getAbsents() {
        return absents;
    }

    public Set<Joueur> getBlesses() {
        return blesses;
    }

    public Equipe getEquipe() {
        return equipe;
    }
    
}
