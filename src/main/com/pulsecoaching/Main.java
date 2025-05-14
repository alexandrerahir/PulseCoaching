// Package
package com.pulsecoaching;

// Importation
import java.time.LocalDate;
import java.util.Arrays;

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
            .positions(Position.DC, Position.GB)
            .build();

        joueur1.ajouterPosition(Position.DD);
        joueur1.retirerPosition(Position.GB);
        System.out.println(joueur1.toString());

    }
}
