// Package
package com.pulsecoaching;

// Importation
import java.time.LocalDate;
import java.util.Arrays;

import com.pulsecoaching.model.*;

public class Main {
    public static void main(String[] args) {
        // Déclaration des positions 
        Position positionGB = new Position("Gardien de but", "GB");

        Position positionDC = new Position("Défenseur central", "DC");
        Position positionDD = new Position("Défenseur droit", "DD");
        Position positionDG = new Position("Défenseur gauche", "DG");
    
        Position positionMDC = new Position("Milieu défensif central", "MDC");
        Position positionMC = new Position("Milieu central", "MC");
        Position positionMD = new Position("Milieu droit", "MD");
        Position positionMG = new Position("Milieu gauche", "MG");
    
        Position positionBU = new Position("Buteur", "BU");
        Position positionAD = new Position("Ailier droit", "AD");
        Position positionAG = new Position("Ailier gauche", "AG");

        // Création de l'entraîneur
        Entraineur entraineur = new Entraineur.EntraineurBuilder()
            .nom("Dupont")
            .prenom("Jean")
            .naissance(LocalDate.of(1980, 5, 15))
            .nationalite("Française")
            .numeroLiscence("123456")
            .niveauCertification("UEFA Pro")
            .build();

        Entraineur entraineur2 = new Entraineur.EntraineurBuilder()
            .nom("Leroy")
            .prenom("Marc")
            .naissance(LocalDate.of(1985, 8, 25))
            .nationalite("Française")
            .numeroLiscence("654321")
            .niveauCertification("UEFA A")
            .build();
            
        // Création des joueurs
        Joueur joueur1 = new Joueur.JoueurBuilder()
            .nom("Martin")
            .prenom("Paul")
            .naissance(LocalDate.of(1995, 3, 20))
            .nationalite("Française")
            .taille(180)
            .poids(75)
            .positions(positionGB)
            .build();

        Joueur joueur2 = new Joueur.JoueurBuilder()
            .nom("Durand")
            .prenom("Lucas")
            .naissance(LocalDate.of(1998, 7, 10))
            .nationalite("Française")
            .taille(185)
            .poids(80)
            .positions(positionDC, positionDD)
            .build();

        
        // Création d'une autre équipe
        Equipe fcmotro = new Equipe.EquipeBuilder()
            .nom("FC Motro")
            .build();

        Equipe fcpoli = new Equipe.EquipeBuilder()
            .nom("FC Poli")
            .joueurs(joueur2)
            .build();

        fcpoli.ajouterEntraineur(entraineur);

        fcpoli.retirerEntraineur(entraineur);

        System.out.println(entraineur.getEquipe().getNom());
    }
}
