package catane;

class Arete {
    // paire de paire de coordonnées
    protected Sommet sommetA;
    protected Sommet sommetB;

    // est ce qu'il y a une route construite. false default.
    protected boolean pasDeRoute;

    // joueur null si route libre, MàJ si construction de route
    Joueur joueur = null;

    public void setJoueur(Joueur j) {
        joueur = j;
        pasDeRoute = true;
    }

    Arete(Sommet depart, Sommet arrivee) {
        this.sommetA = depart;
        this.sommetB = arrivee;

    }

}