public abstract class Carte {
    protected int ecu = 0; // a recevoir ou a payer
    protected int ressourcesPierre;
    protected int ressourcesBois;
    protected int ressourcesSavoir;
    protected int ressourcesTuile;
    protected String nom = "";

    public Carte(String nom, int rp, int rb, int rs, int rt, int ecu){
        this.nom = nom;
        this.ressourcesPierre =rp;
        this.ressourcesBois = rb;
        this.ressourcesSavoir = rs;
        this.ressourcesTuile = rt;
        this.ecu = ecu;
    }
}
