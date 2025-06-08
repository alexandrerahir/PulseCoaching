// Package
package com.pulsecoaching.model;

// Importation
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class BlessureTest
 * Représente les tests unitaires de la classe Blessure.
 */
public class BlessureTest {

    /**
     * testBlessureCreation
     * Test de la création d'une blessure.
     */
    @Test
    public void testBlessureCreation() {
        // Création d'une blessure
        Blessure blessure = Blessure.nouvelleBlessure();

        // Vérification des attributs de la blessure
        assertNotNull(blessure);
        assertNotNull(blessure.getType());
        assertTrue(blessure.getMatchsIndisponible() > 0);
    }
    
    /**
     * testDecrementerMatchsIndisponible
     * Test de la méthode decrementerMatchsIndisponible de la classe Blessure.
     */
    @Test
    public void testDecrementerMatchsIndisponible() {
        // Création d'une blessure
        Blessure blessure = Blessure.nouvelleBlessure();
        
        // Vérification de la valeur initiale
        int matchsIndisponibleInitial = blessure.getMatchsIndisponible();
        
        // Décrémentation des matchs indisponibles
        blessure.decrementerMatchsIndisponible();
        
        // Vérification que le nombre de matchs indisponibles a diminué
        assertEquals(matchsIndisponibleInitial - 1, blessure.getMatchsIndisponible());
    }

    @Test
    public void testEstActive() {
        // Création d'une blessure
        Blessure blessure = Blessure.nouvelleBlessure();
        
        // Vérification que la blessure est active
        assertTrue(blessure.estActive());
        
        // Décrémentation des matchs indisponibles jusqu'à ce qu'ils soient à 0
        while (blessure.getMatchsIndisponible() > 0) {
            blessure.decrementerMatchsIndisponible();
        }
        
        // Vérification que la blessure n'est plus active
        assertFalse(blessure.estActive());
    }
}
