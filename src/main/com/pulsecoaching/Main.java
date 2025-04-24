// Package
package com.pulsecoaching;

// Importation
import java.time.LocalDate;
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

        System.out.println(positionGB.toString());
    }
}
