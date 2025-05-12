// Package
package com.pulsecoaching.exception.Joueur;

/**
 * Classe PourcentageInvalideException
 * Représente une exception qui est levée lorsque le pourcentage est invalide.
 */
public class PourcentageInvalideException extends RuntimeException {

    // Constructeur
    public PourcentageInvalideException(int pourcentage) {
        super("Le pourcentage doit être compris entre 0 et 100. Valeur fournie : " + pourcentage);
    }
    
}
