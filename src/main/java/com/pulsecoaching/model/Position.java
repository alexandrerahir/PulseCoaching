// Import des packages
package main.java.com.pulsecoaching.model;

// Classe Position
public class Position {
    // Attributs
    private String nom;
    private String abreviation;

    // Constructeur
    public Position(String nom, String abreviation) {
        this.nom = nom;
        this.abreviation = abreviation;
    }

    /*
     * getNom
     * 
     * Methode permettant de recuperer le nom de la position
     * 
     * @return String
     */	
    public String getNom() {
        return nom;
    }

    /*
     * toString
     * 
     * Methode permettant d'afficher les informations de la position
     * 
     * @return String
     */
    public String toString() {
        return "Nom: " + nom + ", Abreviation: " + abreviation;
    }
}
