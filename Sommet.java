package catane;

class Sommet {

    // les coordonnées
    int hauteur;
    int largeur;

    // verif si l'intersection est libre ou occupée, avec une ville ou colonie.
    // false par défaut.
    protected boolean colonie;
    protected boolean ville;

    // le joueur potentiel qui a construit au croisement.
    protected Joueur joueur = null;

    public Sommet(int hauteur, int largeur) {
        super();
        this.hauteur = hauteur;
        this.largeur = largeur;

    }

    public String toString() {
        // return String.valueOf(coordonnees[0]) + String.valueOf(coordonnees[1]);
        if (this.colonie == true) {
            return "MMU";
        }
        return " * ";

    }

}