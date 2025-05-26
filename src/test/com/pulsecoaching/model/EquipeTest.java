// Package
package com.pulsecoaching.model;

// Importation
import com.pulsecoaching.exception.Equipe.*;
import com.pulsecoaching.exception.Joueur.PourcentageInvalideException;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * Class EquipeTest
 * Représente les tests unitaires de la classe Equipe.
 */
public class EquipeTest {
    private Equipe equipe1;
    private Equipe equipe2;
    private Joueur joueur1;
    private Joueur joueur2;
    private Entraineur entraineur1;
    private Entraineur entraineur2;

    /**
     * setUp
     * Initialise les objets nécessaires pour les tests.
     * Cette méthode est exécutée avant chaque test.
     */
    @Before
    public void setUp() {
        // Création des équipes
        equipe1 = new Equipe.EquipeBuilder()
                .nom("Paris Saint-Germain")
                .build();
        
        equipe2 = new Equipe.EquipeBuilder()
                .nom("Olympique de Marseille")
                .build();

        // Création des joueurs
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
                .nom("Payet")
                .prenom("Dimitri")
                .naissance(LocalDate.of(1987, 3, 29))
                .nationalite("Française")
                .taille(175)
                .poids(70)
                .positions(Position.MC)
                .build();
        
        // Création des entraîneurs
        entraineur1 = new Entraineur.EntraineurBuilder()
                .nom("Galtier")
                .prenom("Christophe")
                .naissance(LocalDate.of(1966, 8, 26))
                .nationalite("Française")
                .build();

        entraineur2 = new Entraineur.EntraineurBuilder()
                .nom("Sampaoli")
                .prenom("Jorge")
                .naissance(LocalDate.of(1960, 3, 13))
                .nationalite("Argentine")
                .build();
    }


    /**
     * testAjouterJoueur
     * Teste la méthode ajouterJoueur
     */
    @Test
    public void testAjouterJoueur() { 
        // Ajout d'un joueur à l'équipe 1
        equipe1.ajouterJoueur(joueur1);

        // Vérification que le joueur a été ajouté à l'équipe
        assertTrue(equipe1.getJoueurs().contains(joueur1));
        assertEquals(equipe1, joueur1.getEquipe());
    }

    /**
     * testAjouterJoueurDejaDansUneEquipe
     * Teste la méthode ajouterJoueur avec un joueur déjà dans une équipe
     */
    @Test
    public void testAjouterJoueurDejaDansUneEquipe() {
        // Ajout d'un joueur à l'équipe 1
        equipe1.ajouterJoueur(joueur1);

        // Tentative d'ajout du même joueur à l'équipe 2
        assertThrows(JoueurDejaDansUneEquipeException.class, () -> equipe2.ajouterJoueur(joueur1));
    }

    /**
     * testRetirerJoueur
     * Teste la méthode retirerJoueur
     */
    @Test 
    public void testRetirerJoueur() {
        // Ajout d'un joueur à l'équipe 1
        equipe1.ajouterJoueur(joueur1);

        // Retrait du joueur de l'équipe 1
        equipe1.retirerJoueur(joueur1);

        // Vérification que le joueur a été retiré de l'équipe
        assertFalse(equipe1.getJoueurs().contains(joueur1));
        assertNull(joueur1.getEquipe());
    }

    /**
     * testRetirerJoueurNonPresentDansEquipe
     * Teste la méthode retirerJoueur avec un joueur qui n'est pas dans l'équipe
     */
    @Test
    public void testRetirerJoueurNonPresentDansEquipe() {
        // Ajout du joueur à l'équipe 2
        equipe2.ajouterJoueur(joueur1);

        // Tentative de retrait du joueur qui n'est pas dans l'équipe 1
        assertThrows(JoueurNonPresentDansEquipeException.class, () -> equipe1.retirerJoueur(joueur1));
    }

    /**
     * testAjouterEntraineur
     * Teste la méthode ajouterEntraineur
     */
    @Test
    public void testAjouterEntraineur() {
        // Ajout de l'entraîneur à l'équipe 1
        equipe1.ajouterEntraineur(entraineur1);

        // Vérification que l'entraîneur a été ajouté à l'équipe
        assertEquals(entraineur1, equipe1.getEntraineur());
        assertEquals(equipe1, entraineur1.getEquipe());
    }

    /**
     * testAjouterEntraineurDejaDansUneEquipe
     * Teste la méthode ajouterEntraineur avec un entraîneur déjà dans une équipe
     */
    @Test
    public void testAjouterEntraineurDejaDansUneEquipe() {
        // Ajout de l'entraîneur à l'équipe 1
        equipe1.ajouterEntraineur(entraineur1);

        // Tentative d'ajout du même entraîneur à l'équipe 2
        assertThrows(EntraineurDejaDansUneEquipeException.class, () -> equipe2.ajouterEntraineur(entraineur1));
    }

    /**
     * testAjouterEntraineurEquipeDejaAUnEntraineur
     * Teste la méthode ajouterEntraineur avec une équipe qui a déjà un entraîneur
     */
    @Test
    public void testAjouterEntraineurEquipeDejaAUnEntraineur() {
        // Ajout de l'entraîneur à l'équipe 1
        equipe1.ajouterEntraineur(entraineur1);

        // Tentative d'ajout d'un autre entraîneur à l'équipe 1
        assertThrows(EquipeDejaAUnEntraineurException.class, () -> equipe1.ajouterEntraineur(entraineur2));
    }

    /**
     * testRetirerEntraineur
     * Teste la méthode retirerEntraineur
     */
    @Test
    public void testRetirerEntraineur() {
        // Ajout de l'entraîneur à l'équipe 1
        equipe1.ajouterEntraineur(entraineur1);

        // Retrait de l'entraîneur de l'équipe 1
        equipe1.retirerEntraineur(entraineur1);

        // Vérification que l'entraîneur a été retiré de l'équipe
        assertNull(equipe1.getEntraineur());
        assertNull(entraineur1.getEquipe());
    }

    /**
     * testRetirerEntraineurNonPresentDansEquipe
     * Teste la méthode retirerEntraineur avec un entraîneur qui n'est pas dans l'équipe
     */
    @Test
    public void testRetirerEntraineurNonPresentDansEquipe() {
        // Ajout de l'entraîneur à l'équipe 2
        equipe2.ajouterEntraineur(entraineur1);

        // Tentative de retrait de l'entraîneur qui n'est pas dans l'équipe 1
        assertThrows(EntraineurNonPresentDansEquipeException.class, () -> equipe1.retirerEntraineur(entraineur1));
    }
    
}
