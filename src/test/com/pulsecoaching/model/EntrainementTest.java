// Package
package com.pulsecoaching.model;

// Importation
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.Set;
import org.junit.Before;

/**
 * Class EntrainementTest
 * Représente les tests unitaires de la classe Entrainement.
 */
public class EntrainementTest {
    private Joueur joueur1;
    private Joueur joueur2;
    private Equipe equipe;

    /**
     * setUp
     * Initialise les objets nécessaires pour les tests.
     * Cette méthode est exécutée avant chaque test.
     */
    @Before
    public void setUp() {
        // Création des joueurs
        joueur1 = new Joueur.JoueurBuilder()
                .nom("Dembele")
                .prenom("Ousmane")
                .naissance(LocalDate.of(1997, 5, 15))
                .nationalite("Française")
                .taille(178)
                .poids(73)
                .positions(Position.BU)
                .build();

        joueur2 = new Joueur.JoueurBuilder()
                .nom("Donnarumma")
                .prenom("Gianluigi")
                .naissance(LocalDate.of(1999, 2, 25))
                .nationalite("Italienne")
                .taille(196)
                .poids(90)
                .positions(Position.GB)
                .build();

        // Création de l'équipe
        equipe = new Equipe.EquipeBuilder()
                .nom("Paris Saint-Germain")
                .joueurs(joueur1, joueur2)
                .build();
    }

    

    // Tests pour les méthodes de la classe Equipe

    /**
     * testNouvelleSeance
     * Test de la création d'une nouvelle séance d'entraînement.
     */
    @Test
    public void testNouvelleSeance() {
        // Création d'une séance d'entraînement
        Entrainement entrainement = Entrainement.nouvelleSeance(
                LocalDate.of(2023, 10, 1),
                Set.of(joueur1),
                Set.of(joueur2),
                Set.of(),
                equipe
        );

        // Vérification des attributs de l'entraînement
        assertEquals(LocalDate.of(2023, 10, 1), entrainement.getDate());
        assertTrue(entrainement.getPresents().contains(joueur1));
        assertTrue(entrainement.getAbsents().contains(joueur2));
        assertTrue(entrainement.getBlesses().isEmpty());
        assertEquals(equipe, entrainement.getEquipe());
    }


    
}
