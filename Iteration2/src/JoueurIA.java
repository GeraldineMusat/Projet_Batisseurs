import java.util.ArrayList;

public class JoueurIA {
    private String nom = "";
    private int ptsVictoire = 0;
    private ArrayList ecu = new ArrayList();
    private ArrayList ouvriers = new ArrayList();
    private ArrayList batiments = new ArrayList();
    private ArrayList machines = new ArrayList();
    private int nbsAction = 3;

    public JoueurIA(String s){
        this.nom = s;
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
