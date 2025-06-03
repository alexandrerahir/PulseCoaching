// Package
package com.pulsecoaching.model;

// Importation
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * Class EntraineurTest
 * Représente les tests unitaires de la classe Entraineur.
 */
public class EntraineurTest {
    
    /**
     * testEntraineurCreation
     * Test de la création d'un entraîneur.
     */
    @Test
    public void testEntraineurCreation() {
        // Création d'un entraîneur
        Entraineur entraineur = new Entraineur.EntraineurBuilder()
                .nom("Deschamps")
                .prenom("Didier")
                .naissance(LocalDate.of(1968, 10, 15))
                .nationalite("Française")
                .numeroLiscence("123456")
                .niveauCertification("UEFA Pro")
                .build();
        
        // Vérification des attributs de l'entraîneur
        assertEquals("Deschamps", entraineur.getNom());
        assertEquals("Didier", entraineur.getPrenom());
        assertEquals(LocalDate.of(1968, 10, 15), entraineur.getNaissance());
        assertEquals("Française", entraineur.getNationalite());
        assertEquals("123456", entraineur.getNumeroLiscence());
        assertEquals("UEFA Pro", entraineur.getNiveauCertification());
        assertNull(entraineur.getEquipe());
    }
}
