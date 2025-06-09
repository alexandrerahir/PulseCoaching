// Package
package com.pulsecoaching.model;

// Importation
import com.pulsecoaching.exception.Equipe.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;

/**
 * Classe Equipe
 * Représente une équipe de football.
 */
public class Equipe {
    private static final int STAMINA_MINIMUM_MATCH = 30;
    private static final int STAMINA_MINIMUM_ENTRAINEMENT = 10;

    private String nom;

    private Entraineur entraineur;
    private Set<Joueur> joueurs;
    private List<Entrainement> historiquesEntrainements = new ArrayList<>();
    private List<Match> historiquesMatchs = new ArrayList<>();

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

    /**
     * EquipeBuilder
     * Représente le constructeur de l'équipe.
     * 
     * @throws EntraineurDejaDansUneEquipeException Si l'entraîneur appartient déjà à une autre équipe
     * @throws JoueurDejaDansUneEquipeException Si un joueur appartient déjà à une autre équipe
     *  
     * @return Une instance de Equipe
     */
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
        Set<Joueur> joueursBlesses = new LinkedHashSet<>();
        
        // Parcours des joueurs pour déterminer qui est présent et qui est absent
        for (Joueur joueur : joueurs) {

            if (joueur.getBlessure() != null && joueur.getBlessure().estActive()) { // Vérification si le jouer est blessé
                joueursAbsent.add(joueur);
                joueur.augmenterEndurance(10);
                joueur.diminuerQualite(5);

            } else if (joueur.getEndurance() > STAMINA_MINIMUM_ENTRAINEMENT) { // Vérification de l'endurance du joueur

                if (Math.random() < 0.03) { // Possibilité de blessure
                    joueursBlesses.add(joueur);
                    joueur.subirBlessure();
                    joueur.diminuerEndurance(50);
                    joueur.diminuerQualite(5);
                
                } else { // Si le joueur est présent
                    joueursPresent.add(joueur);
                    joueur.diminuerEndurance(10);
                    joueur.augmenterQualite(20);
                }
            
            } else { // Si le joueur n'a pas assez d'endurance
                joueursAbsent.add(joueur);
                joueur.augmenterEndurance(10);
                joueur.diminuerQualite(5);
            }
        }

        // Création de l'entraînement
        Entrainement entrainement = Entrainement.nouvelleSeance(LocalDate.now(), joueursPresent, joueursAbsent, joueursBlesses, this);

        // Ajouter l'entraînement à l'historique des entraînements de l'équipe
        historiquesEntrainements.add(entrainement);

        // Retourne une instance d'Entrainement
        return entrainement;
    }

    /**
     * trouverJoueurrPosition
     * Trouve le joueur le mieux adapté pour une position donnée.
     * 
     * @param position La position pour laquelle trouver le meilleur joueur
     * @param joueursExclus Un ensemble de joueurs à exclure de la recherche
     * 
     * @return Le joueur le mieux adapté pour la position, ou null si aucun joueur n'est trouvé
     */
    public Joueur trouverJoueurPosition(Position position, Set<Joueur> joueursExclus) {
        Joueur meilleurJoueur = null;

        // Parcours des joueurs de l'équipe
        for (Joueur joueur : joueurs) {
            // Création des conditions pour vérifier si le joueur est adapté à la position, est exclu, a une endurance suffisante et n'est pas blessé
            boolean estExclu = joueursExclus.contains(joueur);
            boolean bonnePosition = joueur.getPositions().contains(position);
            boolean enduranceSuffisante = joueur.getEndurance() >= STAMINA_MINIMUM_MATCH;
            boolean estBlessé = joueur.getBlessure() != null && joueur.getBlessure().estActive();

            // Vérification des conditions
            if (!estExclu && bonnePosition && enduranceSuffisante && !estBlessé) {
                // Si le joueur est le meilleur trouvé jusqu'à présent on le mets à jour
                if (meilleurJoueur == null || (joueur.getQualite() + joueur.getEndurance()) > (meilleurJoueur.getQualite() + meilleurJoueur.getEndurance())) {
                    meilleurJoueur = joueur;
                }
            }
        }

        // Retourne le meilleur joueur trouvé ou null si aucun joueur n'est adapté
        return meilleurJoueur;
    }

    /**
     * trouverTitulaires
     * Trouve les joueurs titulaires de l'équipe en fonction de leur endurance + qualité.
     * 
     * @throws EquipeSansJoueurException Si l'équipe n'a pas assez de joueurs pour former une équipe titulaire
     * 
     * @return Un ensemble de joueurs titulaires
     */
    public Set<Joueur> trouverTitulaires() {
        Set<Joueur> titulaires = new LinkedHashSet<>();
        Set<Joueur> joueurExclus = new HashSet<>();

        // 1 Gardien
        Joueur gardien = trouverJoueurPosition(Position.GB, joueurExclus);
        if (gardien != null) {
            titulaires.add(gardien);
            joueurExclus.add(gardien);
        }

        // 1 Défenseur droit
        Joueur defenseurDroit = trouverJoueurPosition(Position.DD, joueurExclus);
        if (defenseurDroit != null) {
            titulaires.add(defenseurDroit);
            joueurExclus.add(defenseurDroit);
        }

        // 1 Défenseur gauche
        Joueur defenseurGauche = trouverJoueurPosition(Position.DG, joueurExclus);
        if (defenseurGauche != null) {
            titulaires.add(defenseurGauche);
            joueurExclus.add(defenseurGauche);
        }

        // 2 Défenseurs centraux
        for (int i = 0; i < 2; i++) {
            Joueur defenseurCentral = trouverJoueurPosition(Position.DC, joueurExclus);
            if (defenseurCentral != null) {
                titulaires.add(defenseurCentral);
                joueurExclus.add(defenseurCentral);
            }
        }

        // 3 Milieux de terrain
        for (int i = 0; i < 3; i++) {
            Joueur milieu = trouverJoueurPosition(Position.MC, joueurExclus);
            if (milieu != null) {
                titulaires.add(milieu);
                joueurExclus.add(milieu);
            }
        }

        // 1 Ailier droit
        Joueur ailierDroit = trouverJoueurPosition(Position.AD, joueurExclus);
        if (ailierDroit != null) {
            titulaires.add(ailierDroit);
            joueurExclus.add(ailierDroit);
        }

        // 1 Ailier gauche
        Joueur ailierGauche = trouverJoueurPosition(Position.AG, joueurExclus);
        if (ailierGauche != null) {
            titulaires.add(ailierGauche);
            joueurExclus.add(ailierGauche);
        }

        // 1 Buteur
        Joueur buteur = trouverJoueurPosition(Position.BU, joueurExclus);
        if (buteur != null) {
            titulaires.add(buteur);
            joueurExclus.add(buteur);
        }

        // Vérification si l'équipe a au moins 11 titulaires
        if (titulaires.size() < 11) {
            throw new EquipeSansJoueurException(nom);
        }

        // Retourne l'ensemble des joueurs titulaires
        return titulaires;
    }

    /**
     * trouverRemplacants
     * Trouve les joueurs remplaçants de l'équipe.
     * 
     * @return Un ensemble de joueurs remplaçants
     */
    public Set<Joueur> trouverRemplacants(Set<Joueur> joueursTitulaires) {
        Set<Joueur> remplacants = new LinkedHashSet<>();
        Set<Joueur> joueursExclus = new HashSet<>(joueursTitulaires);

        // Créer une liste de tous les joueurs non titulaires
        List<Joueur> joueursNonTitulaires = new ArrayList<>();
        for (Joueur joueur : joueurs) {
            if (!joueursExclus.contains(joueur)) {
                joueursNonTitulaires.add(joueur);
            }
        }

        // Trier les joueurs non titulaires par qualité + endurance
        joueursNonTitulaires.sort((j1, j2) -> {
            int scoreJ1 = j1.getQualite() + j1.getEndurance();
            int scoreJ2 = j2.getQualite() + j2.getEndurance();
            return Integer.compare(scoreJ2, scoreJ1);
        });

        // Sélectionner jusqu'à 12 meilleurs remplaçants
        int count = 0;
        for (Joueur joueur : joueursNonTitulaires) {
            if (count >= 12) {
                break;
            }
            boolean enduranceSuffisante = joueur.getEndurance() >= STAMINA_MINIMUM_MATCH;
            boolean estBlessé = joueur.getBlessure() != null && joueur.getBlessure().estActive();

            if (enduranceSuffisante && !estBlessé) {
                remplacants.add(joueur);
                count++;
            }
        }

        // Retourne l'ensemble des remplaçants
        return remplacants;
    }

    /**
     * realiserMatch
     * Réalise un match pour l'équipe.
     * 
     * @throws EquipeSansEntraineurException Si l'équipe n'a pas d'entraîneur
     * 
     * @return Un objet Match représentant le match réalisé
     */
    public Match realiserMatch() {
        // Vérification si l'équipe a un entraîneur
        if (this.entraineur == null) {
            throw new EquipeSansEntraineurException(nom);
        }

        // Trouver les titulaires et les remplaçants
        Set<Joueur> titulaires = trouverTitulaires();
        Set<Joueur> remplacants = trouverRemplacants(titulaires);

        // Création d'un ensemble de tous les joueurs séléctionnés
        Set<Joueur> joueursSelectionnes = new LinkedHashSet<>(titulaires);
        joueursSelectionnes.addAll(remplacants);

        // Trouver les absents (joueurs non sélectionnés)
        Set<Joueur> absents = new LinkedHashSet<>(joueurs);
        absents.removeAll(joueursSelectionnes);

        // Liste pour les joueurs blessés
        Set<Joueur> blesses = new LinkedHashSet<>();

        // Diminier l'endurance et augmenté la qualité des joueurs titulaires
        for (Joueur joueur : titulaires) {
            if (Math.random() < 0.03) {
                blesses.add(joueur);
                joueur.subirBlessure();
                joueur.diminuerEndurance(50);
                joueur.diminuerQualite(10);
            } else {
                joueur.diminuerEndurance(30);
                joueur.augmenterQualite(10);
            }
        }

        // Diminier l'endurance et augmenté la qualité des joueurs remplaçants
        for (Joueur joueur : remplacants) {
            if (Math.random() < 0.01) { 
                blesses.add(joueur);
                joueur.subirBlessure();
                joueur.diminuerEndurance(50);
                joueur.diminuerQualite(10);
            } else {
                joueur.diminuerEndurance(30);
                joueur.augmenterQualite(10);
            }
        }

        // Augmenter l'endurance et diminuer la qualité des joueurs absents
        for (Joueur joueur : absents) {
            // Verification si le joueur est blessé
            if (joueur.getBlessure() != null && joueur.getBlessure().estActive()) {
                joueur.getBlessure().decrementerMatchsIndisponible();
            }

            joueur.augmenterEndurance(20);
            joueur.diminuerQualite(5);
        }

        // Créer le match
        Match match = Match.nouveauMatch(LocalDate.now(), titulaires, remplacants, absents, blesses, this);

        // Ajouter le match à l'historique des matchs de l'équipe
        historiquesMatchs.add(match);

        // Retourne une instance de Match
        return match;
    }

    /**
     * realiserRepos
     * Permet aux joueurs de l'équipe de récupérer de l'endurance.
     * 
     * @throws EquipeSansJoueurException Si l'équipe n'a pas de joueurs
     */
    public void realiserRepos() {
        // Vérification si l'équipe a des joueurs
        if (this.joueurs.isEmpty()) {
            throw new EquipeSansJoueurException(nom);
        }

        // Parcours des joueurs pour leur faire récupérer de l'endurance
        for (Joueur joueur : joueurs) {
            // Vérification si le joueur n'est pas blessé
            if (joueur.getBlessure() == null || !joueur.getBlessure().estActive()) {
                joueur.augmenterEndurance(20);
                joueur.diminuerQualite(5);
            }
        }
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
        sb.append("Équipe : " + nom + "\n");

        // Affichage de l'entraîneur
        if (entraineur != null) {
            sb.append("Entraîneur : " + entraineur.getNomPrenom() + "\n");
        } else {
            sb.append("Pas d'entraîneur assigné.\n");
        }

        // Affichage des joueurs
        if (joueurs.isEmpty()) {
            sb.append("Pas de joueurs dans l'équipe.\n");
        } else {
            sb.append("Joueurs : \n");
            for (Joueur joueur : joueurs) {
                sb.append(joueur.getNomPrenom() + " " + joueur.getPositions())
                .append(" [" + "Qualité: " + joueur.getQualite() + ", Endurance: " + joueur.getEndurance() + "]");

                // Affichage de la blessure du joueur s'il en a une
                if (joueur.getBlessure() != null) {
                    sb.append(" [" + joueur.getBlessure().toString() + "]\n");
                } else {
                    sb.append("\n");
                }

            }
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

    public List<Match> getHistoriquesMatchs() {
        return historiquesMatchs;
    }
}
