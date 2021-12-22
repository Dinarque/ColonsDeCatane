import java.util.ArrayList;
import java.util.Random;

public class Joueur {
    private String nom;
    private boolean ia;
    private int ble;
    private int fer;
    private int argile;
    private int bois;
    private int pierre;
    ArrayList<Sommet> colonies;
    ArrayList<Arete> routes;
    ArrayList<Carte> cartes;
    private int pts_victoire = 0;

    Joueur(String nom) {
        super();
        this.nom = nom;

    }

    private void setIA() {
        this.ia = true;
    }

    public int getPts() {
        return this.pts_victoire;
    }

    public void Tour() {
        Random rd = new Random();
        // nextInt(longueur de la suite)+start step
        int de = rd.nextInt(11) + 2;
        System.out.println("Les des ont donne " + de + " ! ");
        if (de == 7) {

        }

    }

    private void placerColonieInit(Sommet s) {
        if (s.colonie) {
            System.out.println("il y a deja une colonie ici ! ");
            return;
        }
        s.colonie = true;
        this.colonies.add(s);
        this.pts_victoire++;
    }

    private void placerVilleInit(Sommet s) {
        if ((this.colonies.contains(s)) && (s.ville = false)) {
            s.ville = true;
        } else {
            System.out.println("Il vous faut deja avoir une colonie a cet endroit pour la faire evoluer en ville");
            this.pts_victoire++;
        }

    }

    private void placerRoute(Sommet s1, Sommet s2) {
        // 1er �t

    }

    public String toString() {
        String st = "JOUEUR : " + this.nom + "\n" + "RESSOURCES : " + "Argile : " + this.argile + " Bl� : " +
                this.ble + " Bois : " + this.bois + " Fer : " + this.fer + " Pierre : " + this.pierre;

        return st;

    }
}