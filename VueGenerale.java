public class VueGenerale {
    Modele modele;
    Modele memoire;

    Controleur controleur;

    VueGenerale() {
        this.modele = new Modele();
        this.memoire = new Modele();
        this.controleur = new Controleur(this, this.modele);

    }

    // MiseAJour
    // public void miseAJour(Modele newModele){}
}