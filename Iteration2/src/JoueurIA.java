import java.util.ArrayList;

public class JoueurIA {
    private String nom = "";
    private int pointsVictoire = 0;
    private ArrayList<Piece> ecus = new ArrayList<Piece>();
    private ArrayList<Carte> ouvriers = new ArrayList<Carte>();
    private ArrayList<Carte> chantiers = new ArrayList<Carte>();
    private ArrayList<Carte> batiments = new ArrayList<Carte>();
    private ArrayList<Carte> machines = new ArrayList<Carte>();
    private int nbAction = 3;

    public JoueurIA(String s){
        this.nom = s;
    }

    public String getNom() { return nom; }

    public void choisirOuvrier(Ouvrier o){ this.ouvriers.add(o); }
    public void choisirChantier(Batiment b){
        chantiers.add(b);
    }

    public void envoyerTravailler(Ouvrier o, Batiment b){

    }

    public int getNbAction() { return nbAction; }
    public void utiliserAction() { nbAction--; }

    public int getPointsVictoire() { return pointsVictoire; }

    public void acheterAction(int n){
        this.nbAction = n;
    }

    public void vendreAction(int n){

    }

    public void addEcu(Piece piece){
        ecus.add(piece);
    }

    public int getEcu(){
        int sommePiece = 0;

        for(int i = 0; i < this.ecus.size();i++){
            sommePiece+= this.ecus.get(i).getValeur();
        }
        return sommePiece;

    }

    public boolean passerTour() {
        return true;
    }

    public String toString(){
        return this.nom+" : PA=" +this.nbAction
                +", ecus="+this.ecus
                +", PV="+this.pointsVictoire
                +", ouvriers="+this.ouvriers
                +", chantiers="+this.chantiers
                +", batiments="+this.batiments;
    }
}
