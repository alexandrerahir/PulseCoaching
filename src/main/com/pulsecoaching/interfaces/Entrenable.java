// Package
package com.pulsecoaching.interfaces;

/**
 * Interface Entrenable
 * Représente une entité qui peut être entraînée, augmentant ou diminuant son endurance et sa qualité.
 */
public interface Entrenable {

    /**
     * augmenterEndurance
     * Augmente l'endurance de l'entité en pourcentage.
     * 
     * @param pourcentage
     */
    void augmenterEndurance(int pourcentage);

    /**
     * diminuerEndurance
     * Diminue l'endurance de l'entité en pourcentage.
     * 
     * @param pourcentage
     */
    void diminuerEndurance(int pourcentage);

    /**
     * augmenterQualite
     * Augmente la qualité de l'entité en pourcentage.
     * 
     * @param pourcentage
     */
    void augmenterQualite(int pourcentage);

    /**
     * diminuerQualite
     * Diminue la qualité de l'entité en pourcentage.
     * 
     * @param pourcentage
     */
    void diminuerQualite(int pourcentage);
}
