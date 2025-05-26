// Package
package com.pulsecoaching.exception.Equipe;

/**
 * Classe EquipeSansJoueurException
 * Exception levée si une équipe n'a pas de joueurs.
 */
public class EquipeSansJoueurException extends RuntimeException {

    // Constructeur
    public EquipeSansJoueurException(String nomEquipe) {
        super("L'équipe " + nomEquipe + " n'a pas de joueurs.");
    }
    
}
