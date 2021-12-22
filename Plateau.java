import java.util.*;

class Plateau {
    Sommet[][] plateauSommet;
    Case[][] tableauCase;
    Arete[][] lignesVerticales;
    Arete[][] lignesHorizontales;

    Plateau(int hauteur, int largeur) {
        tableauCase = new Case[hauteur - 1][largeur - 1];
        lignesVerticales = new Arete[hauteur - 1][largeur - 1];
        lignesHorizontales = new Arete[hauteur - 1][largeur - 1];

        // TODO methode pour créer les listes de paysages et les listes de numéros de
        // tuile.
        // NOTE les tuiles sont mises au hasard sur le terrain
        // NOTE les numéros sont posés après coup. leur disposition a un ordre
        // ******** tableau de sommets *********
        Sommet[][] sommets = new Sommet[hauteur][largeur];
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                sommets[i][j] = new Sommet(i, j);
            }
        }
        this.plateauSommet = sommets;

        // ******* tableaux d'aretes *******
        Arete[][] aretesVerticales = new Arete[hauteur - 1][largeur - 1];
        Arete[][] aretesHorizontales = new Arete[hauteur - 1][largeur - 1];

        for (int i = 0; i < hauteur - 1; i++) {
            for (int j = 0; j < largeur - 1; j++) {
                aretesVerticales[i][j] = new Arete(this.plateauSommet[i][j], this.plateauSommet[i][j + 1]);
                aretesHorizontales[i][j] = new Arete(this.plateauSommet[i + 1][j], this.plateauSommet[i][j]);
            }
        }
        this.lignesHorizontales = aretesHorizontales;
        this.lignesVerticales = aretesVerticales;

        // ********** plateau de cases **********

        Case[][] cases = new Case[hauteur - 1][largeur - 1];
        for (int i = 0; i < hauteur - 2; i++) {
            for (int j = 0; j < largeur - 2; j++) {
                cases[i][j] = new Case(plateauSommet[i][j], plateauSommet[i][j + 1], plateauSommet[i + 1][j],
                        plateauSommet[i + 1][j + 1]);
                cases[i][j].setRoute(lignesHorizontales[i][j],
                        lignesVerticales[i][j],
                        lignesHorizontales[i + 1][j], lignesVerticales[i][j + 1]);
                // TODO : résoudre les routes exterieures de fin de tableau sud et est.
                // peut-être seulement aretes nord et ouest pour chaque case?

            }
        }
        this.tableauCase = cases;
        System.out.println(this.tableauCase[0][0]);
        // applique le paysage pour chaque case

        this.setCaseType();

    }

    // ********* paysages ***********

    public void setCaseType() {
        Case.Paysage[] tabPaysage = new Case.Paysage[16];

        for (int j = 0; j < 3; j++) {
            tabPaysage[5 * j] = Case.Paysage.FORET;
            tabPaysage[5 * j + 1] = Case.Paysage.MONTAGNE;
            tabPaysage[5 * j + 2] = Case.Paysage.COLLINE;
            tabPaysage[5 * j + 3] = Case.Paysage.PRE;
            tabPaysage[5 * j + 4] = Case.Paysage.CHAMP;

        }
        tabPaysage[15] = Case.Paysage.DESERT;

        List<Case.Paysage> listep = Arrays.asList(tabPaysage);
        Collections.shuffle(listep);
        System.out.println(listep);
        Integer[] tabn = new Integer[] { 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 5, 6, 8, 9, 10 };
        List<Integer> listen = Arrays.asList(tabn);
        Collections.shuffle(listen);

        int k = 0;
        int l = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                this.tableauCase[i][j].setType(listep.get(l));

                if (listep.get(l) != Case.Paysage.DESERT) {
                    this.tableauCase[i][j].setNumber(listen.get(k));
                    k++;
                }
                l++;

            }
        }
    }
}