// Package
package com.pulsecoaching.exception.Equipe;

/**
 * Classe EquipeSansJoueurException
 * Exception levée si une équipe n'a pas de joueurs.
 */
public class EquipeSansEntraineurException extends RuntimeException {

    // Constructeur
    public EquipeSansEntraineurException(String nomEquipe) {
        super("L'équipe " + nomEquipe + " n'a pas d'entraîneur.");
    }
    
}
