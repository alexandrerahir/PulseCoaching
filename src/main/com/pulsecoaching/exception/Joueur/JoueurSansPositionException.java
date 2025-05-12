// Package
package com.pulsecoaching.exception.Joueur;

/**
 * Classe JoueurSansPositionException
 * Représente une exception qui est levée lorsque le joueur n'a pas de position.
 */
public class JoueurSansPositionException extends RuntimeException {

    // Constructeur
    public JoueurSansPositionException(String nomPrenom) {
        super("Le joueur " + nomPrenom + " doit avoir au moins une position.");
    }
    
}
