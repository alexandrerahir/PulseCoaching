// Package
package com.pulsecoaching.model;

// Importation
import com.pulsecoaching.exception.Equipe.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;

/**
 * Classe Equipe
 * Représente une équipe de football.
 */
public class Equipe {
    private String nom;

    private Entraineur entraineur;
    private Set<Joueur> joueurs;
    private List<Entrainement> historiquesEntrainements = new ArrayList<>();

    /**
     * Constructeur
     * Initialise une équipe avec son nom, ses joueurs et son entraîneur.
     * 
     * @param builder
     */
    public Equipe(EquipeBuilder builder) {
        this.nom = builder.nom;
        this.joueurs = builder.joueurs;
        this.entraineur = builder.entraineur;
    }

    // Constructeur builder
    public static class EquipeBuilder {
        private String nom;

        private Entraineur entraineur;
        private Set<Joueur> joueurs = new LinkedHashSet<>();

        // Nom de l'équipe
        public EquipeBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        // Entraîneur de l'équipe
        public EquipeBuilder entraineur(Entraineur entraineur) {
            // Vérification si l'entraîneur n'appartient pas déjà à une autre équipe
            if (entraineur.getEquipe() != null) {
                throw new EntraineurDejaDansUneEquipeException(entraineur.getNomPrenom());
            }

            this.entraineur = entraineur;
            return this;
        }

        // Joueurs de l'équipe
        public EquipeBuilder joueurs(Joueur... joueurs) {
            for (Joueur joueur : joueurs) {
                // Vérification si le joueur n'appartient pas déjà à une autre équipe
                if (joueur.getEquipe() != null) {
                    throw new JoueurDejaDansUneEquipeException(joueur.getNomPrenom());
                }

                this.joueurs.add(joueur);
            }

            return this;
        }

        // Méthode de construction de l'équipe
        public Equipe build() {
            Equipe equipe = new Equipe(this);

            // Assigner l'équipe à chaque joueur
            for (Joueur joueur : this.joueurs) {
                joueur.setEquipe(equipe);
            }

            // Assigner l'équipe à l'entraîneur
            if (this.entraineur != null) {
                this.entraineur.setEquipe(equipe);
            }

            return equipe;
        }
    }



    // Méthodes de la classe Equipe

    /**
     * ajouterJoueur
     * Ajoute un joueur à l'équipe.
     * 
     * @param joueur Le joueur à ajouter
     * 
     * @throws JoueurDejaDansUneEquipeException Si le joueur appartient déjà à une autre équipe
     */
    public void ajouterJoueur(Joueur joueur) {
        // Vérification si le joueur n'appartient pas déjà à une autre équipe
        if (joueur.getEquipe() != null) {
            throw new JoueurDejaDansUneEquipeException(joueur.getNomPrenom());
        }

        // Assigner l'équipe au joueur
        joueurs.add(joueur);
        joueur.setEquipe(this);
    }

    /**
     * retirerJoueur
     * Retire un joueur de l'équipe.
     * 
     * @param joueur Le joueur à retirer
     * 
     * @throws JoueurNonPresentDansEquipeException Si le joueur n'est pas dans l'équipe
     */
    public void retirerJoueur(Joueur joueur) {
        // Vérification si le joueur est dans l'équipe
        if (!joueurs.contains(joueur)) {
            throw new JoueurNonPresentDansEquipeException(joueur.getNomPrenom());
        }

        // Désassigner l'équipe du joueur
        joueurs.remove(joueur);
        joueur.setEquipe(null);
    }

    /**
     * ajouterEntraineur
     * Ajoute un entraîneur à l'équipe.
     * 
     * @param entraineur L'entraîneur à ajouter
     * 
     * @throws EquipeDejaAUnEntraineurException Si l'équipe a déjà un entraîneur
     * @throws EntraineurDejaDansUneEquipeException Si l'entraîneur appartient déjà à une autre équipe
     */
    public void ajouterEntraineur(Entraineur entraineur) {
        // Vérification si l'équipe a déjà un entraîneur
        if (this.entraineur != null) {
            throw new EquipeDejaAUnEntraineurException(this.nom);
        }

        // Vérification si l'entraîneur n'appartient pas déjà à une autre équipe
        if (entraineur.getEquipe() != null) {
            throw new EntraineurDejaDansUneEquipeException(entraineur.getNomPrenom());
        }

        // Assigner l'entraîneur à l'équipe
        this.entraineur = entraineur;
        entraineur.setEquipe(this);
    }

    /**
     * retirerEntraineur
     * Retire l'entraîneur de l'équipe.
     * 
     * @param entraineur L'entraîneur à retirer
     * 
     * @throws EntraineurNonPresentDansEquipeException Si l'entraîneur n'est pas dans l'équipe
     */
    public void retirerEntraineur(Entraineur entraineur) {
        // Vérification si l'entraîneur est dans l'équipe
        if (this.entraineur != entraineur) {
            throw new EntraineurNonPresentDansEquipeException(entraineur.getNomPrenom());
        }

        // Désassigner l'entraîneur de l'équipe
        this.entraineur = null;
        entraineur.setEquipe(null);
    }

    /**
     * realiserEntrainement
     * Réalise un entraînement pour l'équipe.
     * 
     * @throws EquipeSansEntraineurException Si l'équipe n'a pas d'entraîneur
     * @throws EquipeSansJoueurException Si l'équipe n'a pas de joueurs
     * 
     * @return Un objet Entrainement représentant l'entraînement réalisé
     */
    public Entrainement realiserEntrainement() {
        // Vérification si l'équipe a un entraîneur
        if (this.entraineur == null) {
            throw new EquipeSansEntraineurException(nom);
        }

        // Vérification si l'équipe a des joueurs
        if (this.joueurs.isEmpty()) {
            throw new EquipeSansJoueurException(nom);
        }

        // Initialisation des ensembles de joueurs présents et absents
        Set<Joueur> joueursPresent = new LinkedHashSet<>();
        Set<Joueur> joueursAbsent = new LinkedHashSet<>();

        // Parcours des joueurs pour déterminer qui est présent et qui est absent
        for (Joueur joueur : joueurs) {
            if(joueur.getEndurance() > 30) {
                joueursPresent.add(joueur);
                joueur.diminuerEndurance(10);
                joueur.augmenterQualite(20);
            } else {
                joueursAbsent.add(joueur);
                joueur.augmenterEndurance(10);
                joueur.diminuerQualite(5);
            }
        }

        // Création de l'entraînement
        Entrainement entrainement = Entrainement.nouvelleSeance(LocalDate.now(), joueursPresent, joueursAbsent, this);

        // Ajouter l'entraînement à l'historique des entraînements de l'équipe
        historiquesEntrainements.add(entrainement);

        return entrainement;
    }

    /**
     * toString
     * Représente l'équipe sous forme de chaîne de caractères.
     * 
     * @return La chaîne de caractères représentant l'équipe
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Affichage du nom de l'équipe
        sb.append("Équipe : \n").append(nom).append("\n");

        // Affichage de l'entraîneur
        if (entraineur != null) {
            sb.append("Entraîneur : ").append(entraineur.toString()).append("\n");
        } else {
            sb.append("Pas d'entraîneur assigné.\n");
        }

        // Affichage des joueurs
        sb.append("Joueurs :\n");
        for (Joueur joueur : joueurs) {
            sb.append(joueur.toString()).append("\n");
        }

        return sb.toString();
    }



    // Getters et Setters

    public String getNom() {
        return nom;
    }

    public Set<Joueur> getJoueurs() {
        return joueurs;
    }

    public Entraineur getEntraineur() {
        return entraineur;
    } 

    public List<Entrainement> getHistoriquesEntrainements() {
        return historiquesEntrainements;
    }

}
