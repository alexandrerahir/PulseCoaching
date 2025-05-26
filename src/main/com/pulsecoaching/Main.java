// Package
package com.pulsecoaching;

// Importation
import java.time.LocalDate;
import com.pulsecoaching.model.*;

public class Main {
    public static void main(String[] args) { 
        // Création des joueurs
        Joueur joueur1 = new Joueur.JoueurBuilder()
            .nom("Martin")
            .prenom("Paul")
            .naissance(LocalDate.of(1995, 3, 20))
            .nationalite("Française")
            .taille(180)
            .poids(75)
            .positions(Position.GB)
            .build();
        
        Joueur joueur2 = new Joueur.JoueurBuilder()
            .nom("Durand")
            .prenom("Luc")
            .naissance(LocalDate.of(1992, 7, 10))
            .nationalite("Française")
            .taille(175)
            .poids(70)
            .positions(Position.DD)
            .build();
        
        // Création de l'entraîneur
        Entraineur entraineur = new Entraineur.EntraineurBuilder()
            .nom("Dupont")
            .prenom("Jean")
            .naissance(LocalDate.of(1980, 5, 15))
            .nationalite("Française")
            .numeroLiscence("123456")
            .niveauCertification("UEFA Pro")
            .build();
        
        // Création de l'équipe
        Equipe equipe = new Equipe.EquipeBuilder()
            .nom("Les Bleus")
            .entraineur(entraineur)
            .joueurs(joueur1, joueur2)
            .build();
        
        // Création d'un entraînement
        Entrainement entrainement1 = equipe.realiserEntrainement();

        System.out.println(entrainement1.toString());


    }
}
