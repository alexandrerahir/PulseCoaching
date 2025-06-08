// Package
package com.pulsecoaching.model;

// Importation
import com.pulsecoaching.exception.Joueur.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * Class JoueurTest
 * Représente les tests unitaires de la classe Joueur.
 */
public class JoueurTest {
    private Joueur joueur1;
    private Joueur joueur2;

    /**
     * setUp
     * Initialise les objets nécessaires pour les tests.
     * Cette méthode est exécutée avant chaque test.
     */
    @Before
    public void setUp() {
        // Création d'un joueur
        joueur1 = new Joueur.JoueurBuilder()
                .nom("Mbappé")
                .prenom("Kylian")
                .naissance(LocalDate.of(1998, 12, 20))
                .nationalite("Française")
                .taille(178)
                .poids(73)
                .positions(Position.BU)
                .build();
        
        joueur2 = new Joueur.JoueurBuilder()
                .nom("Lloris")
                .prenom("Hugo")
                .naissance(LocalDate.of(1986, 12, 26))
                .nationalite("Française")
                .taille(188)
                .poids(82)
                .positions(Position.GB)
                .build();
    }



    // Tests pour les méthodes de la classe Joueur

    /**
     * testCreationJoueur
     * Test de la création d'un joueur
     * 
     */
    @Test
    public void testCreationJoueur() {
        // Vérification des attributs du joueur
        assertEquals("Mbappé", joueur1.getNom());
        assertEquals("Kylian", joueur1.getPrenom());
        assertEquals(LocalDate.of(1998, 12, 20), joueur1.getNaissance());
        assertEquals("Française", joueur1.getNationalite());
        assertEquals(178, joueur1.getTaille());
        assertEquals(73, joueur1.getPoids());
        assertTrue(joueur1.getPositions().contains(Position.BU));
    }

    /**
     * testAugmenterEndurance
     * Test de la méthode augmenterEndurance
     */
    @Test
    public void testAugmenterEndurance() {
        // Set l'endurance initiale du joueur
        joueur1.setEndurance(50);

        // Test de l'augmentation de l'endurance
        joueur1.augmenterEndurance(50);
        assertEquals(100, joueur1.getEndurance());

        // Test de l'augmentation de l'endurance au-delà de 100
        joueur1.augmenterEndurance(50);
        assertEquals(100, joueur1.getEndurance());
    }

    /**
     * testDiminuerEndurance
     * Test de la méthode diminuerEndurance
     */
    @Test
    public void testDiminuerEndurance() {
        // Set l'endurance initiale du joueur
        joueur1.setEndurance(50);

        // Test de la diminution de l'endurance
        joueur1.diminuerEndurance(30);
        assertEquals(20, joueur1.getEndurance());

        // Test de la diminution de l'endurance en dessous de 0
        joueur1.diminuerEndurance(30);
        assertEquals(0, joueur1.getEndurance());
    }

    /**
     * testPourcentageInvalideEndurance
     * Test de la méthode diminuerEndurance avec un pourcentage invalide
     */
    @Test
    public void testPourcentageInvalideEndurance() {
        // Set l'endurance initiale du joueur
        joueur1.setEndurance(50);

        // Test de la diminution de l'endurance avec un pourcentage négatif
        assertThrows(PourcentageInvalideException.class, () -> joueur1.diminuerEndurance(-10));
        // Test de l'augmentation de l'endurance avec un pourcentage positif
        assertThrows(PourcentageInvalideException.class, () -> joueur1.augmenterEndurance(-110));
    }

    /**
     * testAugmenterQualite
     * Test de la méthode augmenterQualite
     */
    @Test
    public void testAugmenterQualite() {
        // Set la qualité initiale du joueur
        joueur1.setQualite(50);

        // Test de l'augmentation de la qualité
        joueur1.augmenterQualite(30);
        assertEquals(80, joueur1.getQualite());

        // Test de l'augmentation de la qualité au-delà de 100
        joueur1.augmenterQualite(30);
        assertEquals(100, joueur1.getQualite());
    }

    /**
     * testDiminuerQualite
     * Test de la méthode diminuerQualite
     */
    @Test
    public void testDiminuerQualite() {
        // Set la qualité initiale du joueur
        joueur1.setQualite(50);

        // Test de la diminution de la qualité
        joueur1.diminuerQualite(30);
        assertEquals(20, joueur1.getQualite());

        // Test de la diminution de la qualité en dessous de 0
        joueur1.diminuerQualite(30);
        assertEquals(0, joueur1.getQualite());
    }

    /**
     * testPourcentageInvalideQualite
     * Test de la méthode diminuerQualite avec un pourcentage invalide
     */
    @Test
    public void testPourcentageInvalideQualite() {
        // Set la qualité initiale du joueur
        joueur1.setQualite(50);

        // Test de la diminution de la qualité avec un pourcentage négatif
        assertThrows(PourcentageInvalideException.class, () -> joueur1.diminuerQualite(-10));
        // Test de l'augmentation de la qualité avec un pourcentage positif
        assertThrows(PourcentageInvalideException.class, () -> joueur1.augmenterQualite(-110));
    }

    /**
     * testAjouterPosition
     * Test de la méthode ajouterPosition
     */
    @Test
    public void testAjouterPosition() {
        // Ajout d'une position au joueur
        joueur1.ajouterPosition(Position.AD);
        
        // Vérification que la position a été ajoutée
        assertTrue(joueur1.getPositions().contains(Position.AD));
    }

    /**
     * testAjouterPositionLimite
     * Test de la méthode ajouterPosition avec un joueur ayant déjà 3 positions
     */
    @Test
    public void testAjouterPositionLimite() {
        // Ajout de 3 positions au joueur
        joueur1.ajouterPosition(Position.MC);
        joueur1.ajouterPosition(Position.AD);

        // Tentative d'ajout d'une quatrième position
        assertThrows(JoueurTropDePositionsException.class, () -> joueur1.ajouterPosition(Position.AG));
    }

    /**
     * testAjouterPositionGardien
     * Test de la méthode ajouterPosition avec la position de gardien de but
     */
    @Test
    public void testAjouterPositionGardien() {
        // Tentative d'ajout de la position de gardien de but au joueur 1 qui est déjà un attaquant
        assertThrows(JoueurGardienAvecAutresPositionsException.class, () -> joueur1.ajouterPosition(Position.GB));
        
        // Tentative d'ajout de la position d'attaquant au joueur 2 qui est déjà un gardien
        assertThrows(JoueurGardienAvecAutresPositionsException.class, () -> joueur2.ajouterPosition(Position.BU));
    }

    /**
     * testRetirerPosition
     * Test de la méthode retirerPosition
     */
    @Test
    public void testRetirerPosition() {
        // Ajout de 3 positions au joueur
        joueur1.ajouterPosition(Position.MC);
        joueur1.ajouterPosition(Position.AD);
        
        // Retrait d'une position
        joueur1.retirerPosition(Position.AD);
        
        // Vérification que la position a été retirée
        assertFalse(joueur1.getPositions().contains(Position.AD));
    }

    /**
     * testRetirerPositionLimite
     * Test de la méthode retirerPosition avec un joueur n'ayant qu'une seule position restante
     */
    @Test
    public void testRetirerPositionLimite() {
        // Tentative de retrait de la seule position restante du joueur
        assertThrows(JoueurSansPositionException.class, () -> joueur1.retirerPosition(Position.BU));
    }

    /**
     * testSubirBlessure
     * Test de la méthode subirBlessure
     */
    @Test
    public void testSubirBlessure() {
        joueur1.subirBlessure();

        // Vérification que le joueur est blessé
        assertNotNull(joueur1.getBlessure());
    }
}