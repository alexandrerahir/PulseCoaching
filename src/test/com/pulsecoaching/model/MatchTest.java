//Package
package com.pulsecoaching.model;

// Importation
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.Set;
import org.junit.Before;

/**
 * Classe MatchTest
 * Représente un test pour la classe Match.
 */
public class MatchTest {
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

    /**
     * testNouveauMatch
     * Test de la création d'un nouveau match.
     */
    @Test
    public void testNouveauMatch() {
        // Création d'un match
        Match match = Match.nouveauMatch(
            LocalDate.of(2023, 10, 1),
            Set.of(joueur1),
            Set.of(joueur2),
            Set.of(),
            Set.of(),
            equipe
        );

        // Vérification des attributs du match
        assertEquals(LocalDate.of(2023, 10, 1), match.getDate());
        assertTrue(match.getTitulaires().contains(joueur1));
        assertTrue(match.getRemplacants().contains(joueur2));
        assertTrue(match.getAbsents().isEmpty());
        assertTrue(match.getBlesses().isEmpty());
        assertEquals(equipe, match.getEquipe());
    }
    
}
