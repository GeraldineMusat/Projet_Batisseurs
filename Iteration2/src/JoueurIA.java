import java.util.ArrayList;

public class JoueurIA {
    private String nom = "";
    private int ptsVictoire = 0;
    private ArrayList<Piece> ecus = new ArrayList<Piece>();
    private ArrayList<Carte> ouvriers = new ArrayList<Carte>();
    private ArrayList<Carte> batiments = new ArrayList<Carte>();
    private ArrayList<Carte> machines = new ArrayList<Carte>();
    private int nbAction = 3;

    public JoueurIA(String s){
        this.nom = s;
    }

    public void tirerOuvrier(Ouvrier o){
        this.ouvriers.add(o);
    }

    public void tirerBatiment(Batiment b){

    }

    public void envoyerTravailler(Ouvrier o, Batiment b){

    }

    public int getNbAction() { return nbAction; }
    public void utiliserAction() { nbAction--; }

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
        return "nom : " + this.nom
               + "\n Actions restantes : " +this.nbAction
                + "\n Ecus : " +this.ecus
                + "\n PtsVictoire : " +this.ptsVictoire
                + "\n ListOuvriers : " +this.ouvriers
                + "\n ListBatiments : " +this.batiments;
    }
}
