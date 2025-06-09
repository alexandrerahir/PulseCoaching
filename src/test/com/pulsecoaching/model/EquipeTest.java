// Package
package com.pulsecoaching.model;

// Importation
import com.pulsecoaching.exception.Equipe.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.HashSet;

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
                .nom("Neymar")
                .prenom("Neymar Jr")
                .naissance(LocalDate.of(1992, 2, 5))
                .nationalite("Brésilienne")
                .taille(175)
                .poids(68)
                .positions(Position.BU)
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



    // Tests pour les méthodes de la classe Equipe

    /**
     * testCreationEquipe
     * Teste la création d'une équipe
     */
    @Test
    public void testCreationEquipe() {
        // Vérification des attributs de l'équipe
        assertEquals("Paris Saint-Germain", equipe1.getNom());
        assertTrue(equipe1.getJoueurs().isEmpty());
        assertNull(equipe1.getEntraineur());
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
    
    /**
     * testRealiserEntrainementSansEntraineur
     * Teste la méthode realiserEntrainement sans entraîneur
     */
    @Test
    public void testRealiserEntrainementSansEntraineur() {
        // Tentative de réalisation d'un entraînement sans entraîneur
        assertThrows(EquipeSansEntraineurException.class, () -> equipe1.realiserEntrainement());
    }

    /**
     * testRealiserEntrainementSansJoueurs
     * Teste la méthode realiserEntrainement sans joueurs
     */
    @Test
    public void testRealiserEntrainementSansJoueurs() {
        // Ajout de l'entraîneur à l'équipe 1
        equipe1.ajouterEntraineur(entraineur1);

        // Tentative de réalisation d'un entraînement sans joueurs
        assertThrows(EquipeSansJoueurException.class, () -> equipe1.realiserEntrainement());
    }

    /**
     * testRealiserEntrainementAvecEntraineur
     * Teste la méthode realiserEntrainement avec un entraîneur
     */
    @Test
    public void testRealiserEntrainementAvecEntraineurJoueurs() {
        // Ajout de l'entraîneur à l'équipe 1
        equipe1.ajouterEntraineur(entraineur1);

        // Ajout d'un joueur à l'équipe 1
        equipe1.ajouterJoueur(joueur1);

        // Réalisation de l'entraînement
        Entrainement entrainement = equipe1.realiserEntrainement();

        // Vérification que l'entrainement a été réalisé
        assertTrue(equipe1.getHistoriquesEntrainements().contains(entrainement));  
    }

    /**
     * testTrouverJoueurPosition
     * Teste la méthode trouverJoueurPosition
     */
    @Test
    public void testTrouverJoueurPosition() {
        // Ajout de joueurs à l'équipe 1
        equipe1.ajouterJoueur(joueur1);
        equipe1.ajouterJoueur(joueur2);

        // Augmenter la qualité au joueur 1 pour qu'il soit le meilleur BU
        joueur1.augmenterQualite(30);;

        // Recherche d'un joueur avec la position BU
        Joueur joueurTrouve = equipe1.trouverJoueurPosition(Position.BU, new HashSet<>());

        // Vérification que le joueur trouvé est bien le joueur 1
        assertEquals(joueur1, joueurTrouve);
    }

    /**
     * testTrouverJoueurPositionAucunJoueur
     * Teste la méthode trouverJoueurPosition sans joueur pour la position donnée
     */
    @Test
    public void testTrouverJoueurPositionAucunJoueur() {
        // Ajout de joueurs à l'équipe 1
        equipe1.ajouterJoueur(joueur1);
        equipe1.ajouterJoueur(joueur2);

        // Recherche d'un joueur avec la position AD alors qu'aucun joueur n'a cette position
        Joueur joueurTrouve = equipe1.trouverJoueurPosition(Position.AD, new HashSet<>());

        // Vérification que le joueur trouvé est null
        assertNull(joueurTrouve);
    }

    /**
     * testTrouverTitulaireSansJoueurs
     * Teste la méthode trouverTitulaire sans joueurs
     */
    @Test
    public void testTrouverTitulaireSansJoueurs() {
        // Vérifier que la méthode retourne une exception si l'équipe n'a pas assez de joueurs
        assertThrows(EquipeSansJoueurException.class, () -> equipe1.trouverTitulaires());
    }

    @Test
    public void testRealiserRepos() {
        // Ajout de joueurs à l'équipe 1
        equipe1.ajouterJoueur(joueur1);
        equipe1.ajouterJoueur(joueur2);
    
        // Modification de la qualité et de l'endurance des joueurs pour simuler un repos
        joueur1.augmenterQualite(10);
        joueur1.diminuerEndurance(50);
        joueur2.augmenterQualite(10);
        joueur2.diminuerEndurance(50);

        // Réalisation du repos
        equipe1.realiserRepos();

        // Vérification que les joueurs ont récupéré de l'endurance
        assertTrue(joueur1.getEndurance() == 70);
        assertTrue(joueur2.getEndurance() == 70);

        // Vérification que les joueurs ont perdu de la qualité
        assertTrue(joueur1.getQualite() == 5);
        assertTrue(joueur2.getQualite() == 5);

    }


}