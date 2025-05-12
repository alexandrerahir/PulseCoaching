// Package
package com.pulsecoaching.exception.Equipe;

/**
 * Classe JoueurNonPresentDansEquipeException
 * Exception levée lorsque le joueur essaie de quitter une équipe alors qu'il n'est pas présent dans l'équipe.
 */
public class JoueurNonPresentDansEquipeException extends RuntimeException {

    // Constructeur
    public JoueurNonPresentDansEquipeException(String nomPrenom) {
        super("Le joueur " + nomPrenom + " n'est pas présent dans l'équipe.");
    }

}
