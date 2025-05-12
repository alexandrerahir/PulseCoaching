// Package
package com.pulsecoaching.exception.Equipe;

/**
 * Classe EntraineurDejaDansUneEquipeException
 * Exception levée lorsque l'entraîneur essaie de rejoindre une équipe alors qu'il est déjà dans une autre équipe.
 */
public class EntraineurDejaDansUneEquipeException extends RuntimeException {

    // Constructeur
    public EntraineurDejaDansUneEquipeException(String nomPrenom) {
        super("L'entraîneur " + nomPrenom + " appartient déjà à une autre équipe.");
    }
    
}
