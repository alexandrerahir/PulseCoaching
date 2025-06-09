// Package
package com.pulsecoaching;

// Importation
import java.time.LocalDate;

import com.pulsecoaching.model.*;

public class Main {
    public static void main(String[] args) { 

        // Création de l'équipe
        Equipe psg = new Equipe.EquipeBuilder()
                .nom("Paris Saint-Germain")
                .build();

        // Création entraineur
        Entraineur t1 = new Entraineur.EntraineurBuilder()
                .nom("Luis")
                .prenom("Enrique")
                .naissance(LocalDate.of(1970, 1, 1))
                .nationalite("Espagnol")
                .niveauCertification("UEFA Pro")
                .numeroLiscence("UEFA123456")
                .equipe(psg)
                .build();

        // Création de joueurs

        // Gardiens de but
        Joueur gb1 = new Joueur.JoueurBuilder()
                .nom("Donnarumma")
                .prenom("Gianluigi")
                .naissance(LocalDate.of(1999,2,25))
                .nationalite("Italienne")
                .taille(196)
                .poids(90)
                .equipe(psg)
                .positions(Position.GB)
                .build();
        
        Joueur gb2 = new Joueur.JoueurBuilder()
                .nom("Safonov")
                .prenom("Matvey")
                .naissance(LocalDate.of(1999, 2, 25))
                .nationalite("Russe")
                .taille(191)
                .poids(80)
                .equipe(psg)
                .positions(Position.GB)
                .build();
        
        Joueur gb3 = new Joueur.JoueurBuilder()
            .nom("Tenas")
            .prenom("Arnau")
            .naissance(LocalDate.of(2001,5,30))
            .nationalite("Espagnole")
            .taille(185)
            .poids(78)
            .equipe(psg)
            .positions(Position.GB)
            .build();

        // Défenseurs

        Joueur df1 = new Joueur.JoueurBuilder()
                .nom("Marquinhos")
                .prenom("Marcos")
                .naissance(LocalDate.of(1994, 5, 14))
                .nationalite("Brésilienne")
                .taille(183)
                .poids(75)
                .equipe(psg)
                .positions(Position.DC, Position.DD, Position.MC)
                .build();
        
        Joueur df2 = new Joueur.JoueurBuilder()
                .nom("Hakimi")
                .prenom("Achraf")
                .naissance(LocalDate.of(1998, 11, 4))
                .nationalite("Marocaine")
                .taille(181)
                .poids(73)
                .equipe(psg)
                .positions(Position.DD, Position.AD)
                .build();

        Joueur df3 = new Joueur.JoueurBuilder()
                .nom("Lucas")
                .prenom("Hernandez")
                .naissance(LocalDate.of(1996, 2, 14))
                .nationalite("Française")
                .taille(182)
                .poids(76)
                .equipe(psg)
                .positions(Position.DG, Position.DC)
                .build();
        
        Joueur df4 = new Joueur.JoueurBuilder()
                .nom("Kimpembe")
                .prenom("Presnel")
                .naissance(LocalDate.of(1995, 8, 13))
                .nationalite("Française")
                .taille(189)
                .poids(87)
                .equipe(psg)
                .positions(Position.DC)
                .build();
        
        Joueur df5 = new Joueur.JoueurBuilder()
                .nom("Beraldo")
                .prenom("Lucas")
                .naissance(LocalDate.of(2003, 11, 24))
                .nationalite("Brésilienne")
                .taille(185)
                .poids(80)
                .equipe(psg)
                .positions(Position.DC)
                .build();
        
        Joueur df6 = new Joueur.JoueurBuilder()
                .nom("Mendes")
                .prenom("Nuno")
                .naissance(LocalDate.of(2002, 6, 19))
                .nationalite("Portugaise")
                .taille(180)
                .poids(70)
                .equipe(psg)
                .positions(Position.DG, Position.MC)
                .build();

        Joueur df7 = new Joueur.JoueurBuilder()
                .nom("Pacho")
                .prenom("Willian")
                .naissance(LocalDate.of(2001, 10, 16))
                .nationalite("Equatorienne")
                .taille(188)
                .poids(82)
                .equipe(psg)
                .positions(Position.DC)
                .build();

        // Milieux de terrain

        Joueur mc1 = new Joueur.JoueurBuilder()
                .nom("Ruiz")
                .prenom("Fabian")
                .naissance(LocalDate.of(1996, 4, 3))
                .nationalite("Espagnole")
                .taille(185)
                .poids(78)
                .equipe(psg)
                .positions(Position.MC, Position.DC)
                .build();
        
        Joueur mc2 = new Joueur.JoueurBuilder()
                .nom("Vitinha")
                .prenom("Vitor")
                .naissance(LocalDate.of(2000, 2, 10))
                .nationalite("Portugaise")
                .taille(175)
                .poids(70)
                .equipe(psg)
                .positions(Position.MC)
                .build();
        
        Joueur mc3 = new Joueur.JoueurBuilder()
                .nom("Zaire-Emery")
                .prenom("Warren")
                .naissance(LocalDate.of(2006, 3, 8))
                .nationalite("Française")
                .taille(180)
                .poids(72)
                .equipe(psg)
                .positions(Position.MC, Position.DD)
                .build();
        
        Joueur mc4 = new Joueur.JoueurBuilder()
                .nom("Kang-In")
                .prenom("Lee")
                .naissance(LocalDate.of(2001, 2, 19))
                .nationalite("Sud-Coréenne")
                .taille(175)
                .poids(68)
                .equipe(psg)
                .positions(Position.MC, Position.AD, Position.AG)
                .build();
        
        Joueur mc5 = new Joueur.JoueurBuilder()
                .nom("Mayulu")
                .prenom("Senny")
                .naissance(LocalDate.of(2003, 6, 15))
                .nationalite("Française")
                .taille(182)
                .poids(75)
                .equipe(psg)
                .positions(Position.MC)
                .build();
        
        Joueur mc6 = new Joueur.JoueurBuilder()
                .nom("Neves")
                .prenom("Joao")
                .naissance(LocalDate.of(2001, 3, 5))
                .nationalite("Portugaise")
                .taille(178)
                .poids(74)
                .equipe(psg)
                .positions(Position.MC, Position.DC)
                .build();
        
        // Attaquants

        Joueur at1 = new Joueur.JoueurBuilder()
                .nom("Kvaratskhelia")
                .prenom("Khvicha")
                .naissance(LocalDate.of(2001, 2, 12))
                .nationalite("Géorgienne")
                .taille(185)
                .poids(80)
                .equipe(psg)
                .positions(Position.AD, Position.AG, Position.BU)
                .build();
        
        Joueur at2 = new Joueur.JoueurBuilder()
                .nom("Ramos")
                .prenom("Gonçalo")
                .naissance(LocalDate.of(2001, 6, 20))
                .nationalite("Portugaise")
                .taille(185)
                .poids(78)
                .equipe(psg)
                .positions(Position.BU)
                .build();
            
        Joueur at3 = new Joueur.JoueurBuilder()
                .nom("Dembele")
                .prenom("Ousmane")
                .naissance(LocalDate.of(1997, 5, 15))
                .nationalite("Française")
                .taille(178)
                .poids(73)
                .equipe(psg)
                .positions(Position.AD, Position.AG, Position.BU)
                .build();
        
        Joueur at4 = new Joueur.JoueurBuilder()
                .nom("Doue")
                .prenom("Désiré")
                .naissance(LocalDate.of(2003, 8, 10))
                .nationalite("Française")
                .taille(180)
                .poids(75)
                .equipe(psg)
                .positions(Position.BU, Position.AD)
                .build();

        Joueur at5 = new Joueur.JoueurBuilder()
                .nom("Barcola")
                .prenom("Bradley")
                .naissance(LocalDate.of(2003, 9, 28))
                .nationalite("Française")
                .taille(180)
                .poids(72)
                .equipe(psg)
                .positions(Position.AG, Position.AD)
                .build();

        Joueur at6 = new Joueur.JoueurBuilder()
                .nom("Mbaye")
                .prenom("Ibrahim")
                .naissance(LocalDate.of(2004, 1, 15))
                .nationalite("Française")
                .taille(185)
                .poids(80)
                .equipe(psg)
                .positions(Position.BU, Position.AG)
                .build();
        
        
        // Réaliser un entraînement
        Entrainement entrainement1 = psg.realiserEntrainement();
        System.out.println(entrainement1.toString() + "\n");

        // Réaliser un match
        Match match1 = psg.realiserMatch();
        System.out.println(match1.toString() + "\n");

        // Afficher les joueurs de l'équipe
        System.out.println(psg.toString() + "\n");

        // Realiser un deuxième entrainement
        Entrainement entrainement2 = psg.realiserEntrainement();
        System.out.println(entrainement2.toString() + "\n");

        // Réaliser un transfert
        Joueur df8 = new Joueur.JoueurBuilder()
                .nom("Zabarnyi")
                .prenom("Illya")
                .naissance(LocalDate.of(2002, 9, 1))
                .nationalite("Ukrainienne")
                .taille(190)
                .poids(85)
                .positions(Position.DC)
                .build();

        psg.ajouterJoueur(df8);
        System.out.println("Transfert de : " + df8.toString() + "\n");

        // Afficher les joueurs de l'équipe après le transfert
        System.out.println(psg.toString() + "\n");

        // Realiser un repos
        psg.realiserRepos();

        // Afficher les joueurs de l'équipe après le repos
        System.out.println(psg.toString() + "\n");

        // Réaliser un deuxième match
        Match match2 = psg.realiserMatch();
        System.out.println(match2.toString() + "\n");

        // Afficher les joueurs de l'équipe après le match
        System.out.println(psg.toString() );

        // Ajouter un position à un joueur (Senny Mayulu)
        mc5.ajouterPosition(Position.AG);
        System.out.println("Ajout de la position AG à " + mc5.getNomPrenom() + "\n");

        // Retirer un joueur de l'équipe (Mbaye Ibrahim)
        psg.retirerJoueur(at6);
        System.out.println("Retrait du joueur : " + at6.getNomPrenom() + "\n");

        // Afficher les joueurs de l'équipe après le retrait et l'ajout de position
        System.out.println(psg.toString() + "\n");

    }
}
