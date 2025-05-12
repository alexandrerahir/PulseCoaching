// Package
package com.pulsecoaching.exception.Equipe;

/**
 * Classe EntraineurNonPresentDansEquipeException
 * Exception levée lorsque l'entraîneur essaie de quitter une équipe alors qu'il n'est pas présent dans l'équipe.
 */
public class EntraineurNonPresentDansEquipeException extends RuntimeException {
    
    // Constructeur
    public EntraineurNonPresentDansEquipeException(String nomPrenom) {
        super("L'entraîneur " + nomPrenom + " n'est pas présent dans l'équipe.");
    }
    
}
