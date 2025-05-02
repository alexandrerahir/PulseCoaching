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

        // Création d'une équipe avec le constructeur builder
        Equipe equipe = new Equipe.EquipeBuilder()
        .nom("Les Bleus")
        .abreviation("FR")
        .build();

        // Création d'un joueur avec le constructeur builder
        Joueur joueur = new Joueur.JoueurBuilder()
                .nom("Dupont")
                .prenom("Jean")
                .naissance(LocalDate.of(1990, 5, 15))
                .nationalite("Française")
                .taille(180)
                .poids(75)
                .ajouterPosition(positionAD)
                .ajouterPosition(positionAD)
                .build();
        
        Joueur joueur2 = new Joueur.JoueurBuilder()
                .nom("Alexandre")
                .prenom("Paul")
                .naissance(LocalDate.of(1990, 5, 15))
                .nationalite("Française")
                .equipe(equipe)
                .taille(180)
                .poids(75)
                .ajouterPosition(positionAD)
                .ajouterPosition(positionAD)
                .build();

        // Creation d'un entraîneur avec le constructeur builder
        Entraineur entraineur = new Entraineur.EntraineurBuilder()
                .nom("Martin")
                .prenom("Pierre")
                .naissance(LocalDate.of(1985, 3, 20))
                .nationalite("Française")
                .fonction("Entraîneur principal")
                .build();
        

        // Affichage des informations de l'équipe
        System.out.println(equipe.toString());

    }
}
