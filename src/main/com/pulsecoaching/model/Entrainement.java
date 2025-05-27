// Package
package com.pulsecoaching.model;

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
    private Equipe equipe;

    // Constructeur
    private Entrainement(LocalDate date, Set<Joueur> presents, Set<Joueur> absents, Equipe equipe) {
        this.date = date;
        this.presents = presents;
        this.absents = absents;
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
     * 
     * @return une nouvelle instance d'Entrainement
     */
    static Entrainement nouvelleSeance(LocalDate date, Set<Joueur> presents, Set<Joueur> absents, Equipe equipe) {
        return new Entrainement(date, presents, absents, equipe);
    }

    /**
     * toString
     * Représente l'entraînement sous forme de chaîne de caractères.
     * 
     * @return la chaîne de caractères représentant l'entraînement
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Entraînement le ").append(date).append("\n");
        sb.append("Équipe : ").append(equipe.getNom()).append("\n");
        sb.append("Présents : ");
        if (presents.isEmpty()) {
            sb.append("Aucun joueur présent");
        } else {
            for (Joueur joueur : presents) {
                sb.append(joueur.getNomPrenom()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        sb.append("\nAbsents : ");
        if (absents.isEmpty()) {
            sb.append("Aucun joueur absent");
        } else {
            for (Joueur joueur : absents) {
                sb.append(joueur.getNomPrenom()).append(", ");
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

    public Equipe getEquipe() {
        return equipe;
    }
    
}
