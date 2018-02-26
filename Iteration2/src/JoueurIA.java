import java.util.ArrayList;

public class JoueurIA {
    private String nom = "";
    private int ptsVictoire = 0;
    private ArrayList<Piece> ecu = new ArrayList<Piece>();
    private ArrayList<Carte> ouvriers = new ArrayList<Carte>();
    private ArrayList<Carte> batiments = new ArrayList<Carte>();
    private ArrayList<Carte> machines = new ArrayList<Carte>();
    private int nbsAction = 3;

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

    public void acheterAction(int n){

    }

    public void vendreAction(int n){

    }

    public void setEcu(){

    }

    public void getEcu(){

    }

    public String toString(){
        return "nom : " + this.nom
               + "\n Actions restantes : " +this.nbsAction
                + "\n Ecus : " +this.ecu
                + "\n PtsVictoire : " +this.ptsVictoire
                + "\n ListOuvriers : " +this.ouvriers
                + "\n ListBatiments : " +this.batiments;
    }
}
