// Package
package com.pulsecoaching.model;

// Importation
import java.time.LocalDate;
import java.util.Set;

/**
 * Classe Match
 * Représente un match de football.
 */
public class Match {
    private LocalDate date;
    private Set<Joueur> titulaires;
    private Set<Joueur> remplaçants;
    private Set<Joueur> absents;
    private Set<Joueur> blesses;
    private Equipe equipe;


    /**
     * Constructeur
     * Initialise un match avec la date, les joueurs titulaires, les remplaçants, les absents et l'équipe.
     * 
     * @param date la date du match
     * @param titulaires les joueurs titulaires du match
     * @param remplaçants les joueurs remplaçants du match
     * @param absents les joueurs absents du match
     * @param blesses les joueurs blessés du match
     * @param equipe l'équipe associée au match
     */
    private Match(LocalDate date, Set<Joueur> titulaires, Set<Joueur> remplaçants, Set<Joueur> absents, Set<Joueur> blesses,Equipe equipe) {
        this.date = date;
        this.titulaires = titulaires;
        this.remplaçants = remplaçants;
        this.absents = absents;
        this.blesses = blesses;
        this.equipe = equipe;
    }



    // Méthodes de la classe Match

    /**
     * nouveauMatch
     * Crée un nouveau match.
     * 
     * @param date la date du match
     * @param titulaires les joueurs titulaires du match
     * @param remplaçants les joueurs remplaçants du match
     * @param absents les joueurs absents du match
     * @param blesses les joueurs blessés du match
     * @param equipe l'équipe associée au match
     * 
     * @return une nouvelle instance de Match
     */
    public static Match nouveauMatch(LocalDate date, Set<Joueur> titulaires, Set<Joueur> remplaçants, Set<Joueur> absents, Set<Joueur> blesses, Equipe equipe) {
        return new Match(date, titulaires, remplaçants, absents, blesses, equipe);
    }

    /**
     * toString
     * Représente le match sous forme de chaîne de caractères.
     * 
     * @return la chaîne de caractères représentant le match
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Affichage de la date du match
        sb.append("Match le ").append(date).append("\n");

        // Affichage de l'équipe
        sb.append("Équipe : ").append(equipe.getNom()).append("\n");

        // Affichage des titulaires
        sb.append("Titulaires : ");
        for (Joueur joueur : titulaires) {
            sb.append(joueur.getNomPrenom()).append(", ");
        }
        sb.setLength(sb.length() - 2);

        // Affichage des remplaçants
        if (remplaçants.isEmpty()) {
            sb.append("\nRemplaçants : Aucun joueur remplaçant");
        } else {
            sb.append("\nRemplaçants : ");
            for (Joueur joueur : remplaçants) {
                sb.append(joueur.getNomPrenom()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        // Affichage des absents
        if (absents.isEmpty()) {
            sb.append("\nAbsents : Aucun joueur absent");
        } else {
            sb.append("\nAbsents : ");
            for (Joueur joueur : absents) {
                sb.append(joueur.getNomPrenom()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        // Affichage des blessés
        if (blesses.isEmpty()) {
            sb.append("\nBlessés pendant le match : Aucun joueur blessé");
        } else {
            sb.append("\nBlessés pendant le match : ");
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

    public Set<Joueur> getTitulaires() {
        return titulaires;
    }

    public Set<Joueur> getRemplacants() {
        return remplaçants;
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
