public class Piece {

    private enumTypePiece  type; //soit OR soit ARGENT
    private int valeur; //soit OR = 5 soit ARGENT = 2

    public Piece(enumTypePiece etp){
        if(etp.equals(enumTypePiece.OR)){
            type = enumTypePiece.OR;
            valeur = 5;
        }else if(etp.equals(enumTypePiece.ARGENT)){
            type = enumTypePiece.ARGENT;
            valeur = 1;
        }
    }

    public String toString(){
        return "Type : " + this.type + " Valeur : "  + this.valeur + "\n";
    }
}
