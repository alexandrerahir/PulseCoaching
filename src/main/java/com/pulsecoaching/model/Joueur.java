package main.java.com.pulsecoaching.model;

import java.util.Date;

public class Joueur {
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String nationalite;
    private double taille;
    private double poids;
    private double qualite;
    private double forme;

    public Joueur(String nom, String prenom, Date dateNaissance, String nationalite, double taille, double poids, double qualite, double forme) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
        this.qualite = qualite;
        this.forme = forme;
    }

    public String toString() {
        return "Nom: " + nom + ", Prenom: " + prenom + ", Date de naissance: " + dateNaissance + ", Nationalite: " + nationalite + ", Taille: " + taille + ", Poids: " + poids + ", Qualite: " + qualite + ", Forme: " + forme;
    }
}
