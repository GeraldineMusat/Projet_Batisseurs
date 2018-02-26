import java.util.ArrayList;

public abstract class Jeu {

    static ArrayList<Piece> reserve = new ArrayList<Piece>(); 						// "banque" / taille max = 40

    static ArrayList<Carte> paquetOuvriers = new ArrayList<Carte>(); 					// taille max = 42
    static ArrayList<Carte> listeOuvriersSelectionnables = new ArrayList<Carte>(); 	// pioche du paquet ouvriers / taille max = 5

    static ArrayList<Carte> paquetBatiments = new ArrayList<Carte>(); 				// chantiers batiments + machines / taille max = 42
    static ArrayList<Carte> listeBatimentsSelectionnables = new ArrayList<Carte>(); 	// pioche du paquet batiments / taille max = 5

    static ArrayList<JoueurIA> listeJoueurs = new ArrayList<JoueurIA>(); 					// taille max = 4




    static void genererPieces(){
    	for(int i=0; i<15; i++)
    		reserve.add(new Piece(enumTypePiece.OR));		// créer 15 pièces d'or
    	for(int j=0; j<25; j++)
    		reserve.add(new Piece(enumTypePiece.ARGENT));	// créer 25 pièces d'argent
    }

    static void genererPaquetOuvriers(){

    }

    static void genererPaquetBatiment(){

    }

    static void addJoueur(JoueurIA j){
        listeJoueurs.add(j);

    }

    static void setListCarteOuvrierSelectionnable(){

    }

    static void setListCarteBatimentSelectionnable(){

    }

    static void attribuerPieces(){

    }


    public static void main(String[] args) {
        System.out.println("Les batisseurs");
        Jeu.addJoueur(new JoueurIA("Sebastien"));
        System.out.println(Jeu.listeJoueurs.toString());
        Jeu.genererPieces();
        System.out.println(Jeu.reserve.toString());
    }


}



