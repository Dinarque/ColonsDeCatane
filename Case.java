import java.util.LinkedList;

class Case {
    Sommet NO;
    Sommet NE;
    Sommet SO;
    Sommet SE;
    Arete nord;
    Arete ouest;
    Arete sud;
    Arete est;
    protected int numero;
    protected Paysage type;

    public enum Paysage {
        DESERT, FORET, MONTAGNE, COLLINE, PRE, CHAMP
    }

    public void setNumber(int i) {
        this.numero = i;
    }

    public void setType(Paysage paysage) {
        this.type = paysage;
    }

    public void setRoute(Arete n, Arete o, Arete s, Arete e) {
        this.nord = n;
        this.ouest = o;
        this.sud = s;
        this.est = e;
    }

    Case(Sommet no, Sommet ne, Sommet so, Sommet se) {
        this.NO = no;
        this.NE = ne;
        this.SO = so;
        this.SE = se;
    }

    public String toString() {
        // return this.type.toString() + " " + this.numero;
        return this.NO.toString();
    }

}