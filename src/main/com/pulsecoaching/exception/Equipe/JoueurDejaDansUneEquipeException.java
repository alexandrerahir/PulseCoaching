// Package
package com.pulsecoaching.exception.Equipe;

/**
 * Classe JoueurDejaDansUneEquipeException
 * Exception levée lorsque le joueur essaie de rejoindre une équipe alors qu'il est déjà dans une autre équipe.
 */
public class JoueurDejaDansUneEquipeException extends RuntimeException {
    
    // Constructeur
    public JoueurDejaDansUneEquipeException(String nomPrenom) {
        super("Le joueur " + nomPrenom + " appartient déjà à une autre équipe.");
    }
    
}
