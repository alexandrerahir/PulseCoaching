package main.java.com.pulsecoaching;

import java.util.Date;
import main.java.com.pulsecoaching.model.Joueur;
import main.java.com.pulsecoaching.model.Position;

public class Main {
    public static void main(String[] args) {
        Position positionAttaquant = new Position("Attaquant", "ATT");
        Position positionMilieu = new Position("Milieu", "MIL");
        Position PositionDefenseur = new Position("Defenseur", "DEF");
        Position positionGardien = new Position("Gardien", "GAR");

        Joueur joueur = new Joueur("Messi", "Lionel", new Date(), "Argentine", 1.70, 72, positionAttaquant, new Position[]{positionAttaquant, PositionDefenseur});
        System.out.println(joueur.toString());

    }
}
