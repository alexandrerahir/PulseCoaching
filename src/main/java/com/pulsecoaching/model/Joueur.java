// Import des packages
package main.java.com.pulsecoaching.model;

// Import des classes
import java.util.Date;

// Classe Joueur
public class Joueur {
    // Attributs
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String nationalite;
    private double taille;
    private double poids;
    private double qualite;
    private double forme;
    private Position positionPrincipale;
    private Position[] positionsSecondaires;

    // Constructeur principal
    public Joueur(String nom, String prenom, Date dateNaissance, String nationalite, double taille, double poids, Position positionPrincipale, Position[] positionsSecondaires) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
        this.qualite = 100;
        this.forme = 100;
        this.positionPrincipale = positionPrincipale;
        this.positionsSecondaires = validerPositionsSecondaires(positionsSecondaires);
    }

    // Constructeur secondaire
    public Joueur(String nom, String prenom, Date dateNaissance, String nationalite, double taille, double poids, Position positionPrincipale) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
        this.qualite = 100;
        this.forme = 100;
        this.positionPrincipale = positionPrincipale;
    }

    /*
     * validerPositionsSecondaires
     * 
     * Methode permettant de valider les positions secondaires
     * 
     * @param Position[] positionsSecondaires
     * @return Position[]
     * @throws IllegalArgumentException
     */
    public Position[] validerPositionsSecondaires(Position[] positionsSecondaires) {
        // Verification du nombre de positions secondaires
        if (positionsSecondaires != null && positionsSecondaires.length > 2) {
            throw new IllegalArgumentException("Le nombre de positions secondaires ne peut pas dépasser 2.");
        }

        // Verification de la position principale
        if (this.positionPrincipale.getNom() == "Gardien" ) {
            throw new IllegalArgumentException("Le gardien ne peut pas avoir de positions secondaires.");
        }

        // Verification que la position principale ne correspond pas aux positions secondaires
        for (int i = 0; i < positionsSecondaires.length; i++) {
            if (positionsSecondaires[i] != null && this.positionPrincipale.getNom().equals(positionsSecondaires[i].getNom())) {
                throw new IllegalArgumentException("La position principale ne peut pas être identique à une position secondaire.");
            }
        }

        // Verification des doublons parmi les positions secondaires
        for (int i = 0; i < positionsSecondaires.length; i++) {
            for (int j = i + 1; j < positionsSecondaires.length; j++) {
                if (positionsSecondaires[i] != null && positionsSecondaires[j] != null && positionsSecondaires[i].getNom().equals(positionsSecondaires[j].getNom())) {
                    throw new IllegalArgumentException("Les positions secondaires ne peuvent pas être identiques.");
                }
            }
        }

        return positionsSecondaires;
    }

    /*
     * toString
     * 
     * Methode permettant d'afficher les informations du joueur
     * 
     * @return String
     */
    public String toString() {
        String positionsSecondairesStr = "";
        if (positionsSecondaires != null) {
            for (Position pos : positionsSecondaires) {
                if (pos != null) {
                    positionsSecondairesStr += pos.toString() + " ";
                }
            }
        }
        return "Nom: " + nom + ", Prenom: " + prenom + ", Date de naissance: " + dateNaissance + ", Nationalite: " + nationalite + ", Taille: " + taille + ", Poids: " + poids + ", Qualite: " + qualite + ", Forme: " + forme + ", Position principale: " + positionPrincipale.toString() + ", Positions secondaires: " + positionsSecondairesStr.trim();
    }
}
