public class Ouvrier extends Carte{
    private boolean estEnTrainDeTravailler = false;

    public Ouvrier(String nom, int rp, int rb, int rs, int rt, int ecu){
        super(nom,rp,rb,rs,rt,ecu);
    }

    public void setEstEnTrainDeTravailler(boolean bool) {
        this.estEnTrainDeTravailler = bool;
    }
    public boolean getEstEnTrainDeTravailler(){
        return this.estEnTrainDeTravailler;
    }
}
