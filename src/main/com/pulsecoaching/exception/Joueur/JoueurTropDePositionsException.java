// Package
package com.pulsecoaching.exception.Joueur;

/**
 * Classe JoueurTropDePositionsException
 * Représente une exception qui est levée lorsque le joueur a trop de positions.
 */
public class JoueurTropDePositionsException  extends RuntimeException {

    // Constructeur
    public JoueurTropDePositionsException(String nomPrenom) {
        super("Le joueur " + nomPrenom + " a trop de positions.");
    }

}
