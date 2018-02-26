import java.util.ArrayList;

public class Batiment extends Carte {

    private int pointsVictoire = 0;
    private ArrayList<Ouvrier> listOuvrierTravaillant = new ArrayList<Ouvrier>();
    private boolean estConstruit = false;

    public Batiment(String nom, int rp, int rb, int rs, int rt, int ecu){
        super(nom,rp,rb,rs,rt,ecu);
    }

    public int getPointsVictoire() {
        return pointsVictoire;
    }

    public boolean isEstConstruit() {
        return estConstruit;
    }

    public void setEstConstruit(boolean estConstruit) {
        this.estConstruit = estConstruit;
    }

    public void ajouterUnOuvrier(Ouvrier o) throws Throwable {
        if(o.getEstEnTrainDeTravailler()){
            this.listOuvrierTravaillant.add(o);
        }else{
            throw new Throwable("Ouvrier travaillant deja sur un autre batiment");
        }

    }
}
