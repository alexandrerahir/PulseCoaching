// Package
package com.pulsecoaching.exception.Equipe;

/**
 * Classe EquipeDejaAUnEntraineurException
 * Exception levée lorsque l'équipe essaie d'ajouter un entraîneur alors qu'elle en a déjà un.
 */
public class EquipeDejaAUnEntraineurException extends RuntimeException {

    // Constructeur
    public EquipeDejaAUnEntraineurException(String nomEquipe) {
        super("L'équipe " + nomEquipe + " a déjà un entraîneur.");
    }
    
}
