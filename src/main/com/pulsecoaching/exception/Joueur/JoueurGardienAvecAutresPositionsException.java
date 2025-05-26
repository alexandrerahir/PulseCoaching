// Package
package com.pulsecoaching.exception.Joueur;

/**
 * Class JoueurGardienAvecAutresPositionsException
 * Représente une exception qui est levée lorsqu'un joueur est un gardien de but et possède d'autres positions.
 */
public class JoueurGardienAvecAutresPositionsException extends RuntimeException {
    
    // Constructeur
    public JoueurGardienAvecAutresPositionsException(String nomPrenom) {
        super("Le joueur " + nomPrenom + " ne peut pas être un gardien de but et avoir d'autres positions.");
    }

}
