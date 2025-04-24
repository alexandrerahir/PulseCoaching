package com.pulsecoaching;

import java.time.LocalDate;
import com.pulsecoaching.model.*;

public class Main {
    public static void main(String[] args) {
        Joueur joueur = new Joueur.JoueurBuilder()
                .nom("Dupont")
                .prenom("Jean")
                .naissance(LocalDate.of(1990, 1, 1))
                .nationalite("Française")
                .taille(180)
                .poids(70)
                .build();

        System.out.println(joueur.toString());
    }
}
