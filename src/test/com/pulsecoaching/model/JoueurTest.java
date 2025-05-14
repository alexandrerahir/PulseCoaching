// Package
package com.pulsecoaching.model;

// Importation
import com.pulsecoaching.exception.Joueur.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * Class JoueurTest
 * Représente les tests unitaires de la classe Joueur.
 */
public class JoueurTest {

    // Création d'un joueur
    private Joueur creerJoueur() {
        return new Joueur.JoueurBuilder()
                .nom("Dupont")
                .prenom("Jean")
                .naissance(LocalDate.of(1990, 1, 1))
                .nationalite("Française")
                .taille(180)
                .poids(75)
                .positions(Position.DC, Position.MC)
                .build();
    }

    /**
     * TestAugmenterEndurance
     * Teste la méthode augmenterEndurance de la classe Joueur.
     */
    @Test
    public void testAugmenterEndurance() {
        Joueur joueur = creerJoueur();
        joueur.setEndurance(0);

        joueur.augmenterEndurance(90);
        assertEquals(90, joueur.getEndurance());

        joueur.augmenterEndurance(20);
        assertEquals(100, joueur.getEndurance());
    }

    /**
     * TestDiminuerEndurance
     * Teste la méthode diminuerEndurance de la classe Joueur.
     */
    @Test
    public void testDiminuerEndurance() {
        Joueur joueur = creerJoueur();
        joueur.setEndurance(100);

        joueur.diminuerEndurance(20);
        assertEquals(80, joueur.getEndurance());

        joueur.diminuerEndurance(90);
        assertEquals(0, joueur.getEndurance());
    }

    /**
     * testEndurancePourcentageInvalide
     * Teste la méthode augmenterEndurance et dimunuerEndurance avec un pourcentage invalide.
     */
    @Test
    public void testEndurancePourcentageInvalide() {
        Joueur joueur = creerJoueur();
        joueur.setEndurance(100);

        assertThrows(PourcentageInvalideException.class, () -> joueur.augmenterEndurance(-10));
        assertThrows(PourcentageInvalideException.class, () -> joueur.augmenterEndurance(150));

        assertThrows(PourcentageInvalideException.class, () -> joueur.diminuerEndurance(-10));
        assertThrows(PourcentageInvalideException.class, () -> joueur.diminuerEndurance(150));

    }

    /**
     * testAugmenterQualite
     * Teste la méthode augmenterQualite de la classe Joueur.
     */
    @Test
    public void testAugmenterQualite() {
        Joueur joueur = creerJoueur();
        joueur.setQualite(0);

        joueur.augmenterQualite(90);
        assertEquals(90, joueur.getQualite());

        joueur.augmenterQualite(20);
        assertEquals(100, joueur.getQualite());
    }

    /**
     * testDiminuerQualite
     * Teste la méthode diminuerQualite de la classe Joueur.
     */
    @Test
    public void testDiminuerQualite() {
        Joueur joueur = creerJoueur();
        joueur.setQualite(100);

        joueur.diminuerQualite(20);
        assertEquals(80, joueur.getQualite());

        joueur.diminuerQualite(90);
        assertEquals(0, joueur.getQualite());
    }

    /**
     * testQualitePourcentageInvalide
     * Teste la méthode augmenterQualite et diminuerQualite avec un pourcentage invalide.
     */
    @Test
    public void testQualitePourcentageInvalide() {
        Joueur joueur = creerJoueur();
        joueur.setQualite(100);

        assertThrows(PourcentageInvalideException.class, () -> joueur.augmenterQualite(-10));
        assertThrows(PourcentageInvalideException.class, () -> joueur.augmenterQualite(150));

        assertThrows(PourcentageInvalideException.class, () -> joueur.diminuerQualite(-10));
        assertThrows(PourcentageInvalideException.class, () -> joueur.diminuerQualite(150));

    }

    /**
     * testAjouterPosition
     * Teste la méthode ajouterPosition de la classe Joueur.
     */
    @Test
    public void testAjouterPosition() {
        Joueur joueur = creerJoueur();

        joueur.ajouterPosition(Position.DD);
        assertTrue(joueur.getPositions().contains(Position.DD));

        assertThrows(JoueurTropDePositionsException.class, () -> joueur.ajouterPosition(Position.DG));
    }

    /**
     * testRetirerPosition
     * Teste la méthode retirerPosition de la classe Joueur.
     */
    @Test
    public void testRetirerPosition() {
        Joueur joueur = creerJoueur();

        joueur.retirerPosition(Position.DC);
        assertFalse(joueur.getPositions().contains(Position.DC));

        assertThrows(JoueurSansPositionException.class, () -> joueur.retirerPosition(Position.MC));
    }
    
}
