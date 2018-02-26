import java.util.ArrayList;

public abstract class Jeu {

    static ArrayList<Piece> reserve = new ArrayList<Piece>(); 						// "banque" / taille max = 40

    static ArrayList<Carte> paquetOuvriers = new ArrayList<Carte>(); 				// taille max = 42
    static ArrayList<Carte> listeOuvriersSelectionnables = new ArrayList<Carte>(); 	// pioche du paquet ouvriers / taille max = 5

    static ArrayList<Carte> paquetChantiers = new ArrayList<Carte>(); 				// chantiers batiments + machines / taille max = 42
    static ArrayList<Carte> listeChantiersSelectionnables = new ArrayList<Carte>(); // pioche du paquet batiments / taille max = 5

    static ArrayList<JoueurIA> listeJoueurs = new ArrayList<JoueurIA>(); 			// taille max = 4

    static boolean dernierTour;


    static void genererReserve(){
    	for(int i=0; i<15; i++)
    		reserve.add(new Piece(enumTypePiece.OR));		// créer 15 pièces d'or
    	for(int j=0; j<25; j++)
    		reserve.add(new Piece(enumTypePiece.ARGENT));	// créer 25 pièces d'argent
    }

    static void genererPaquetOuvriers(){
        for(int i=0; i<10; i++) {
            paquetOuvriers.add(new Ouvrier("ouvrier",0,0,0,0,0));
        }
    }

    static void genererPaquetChantiers(){
        for(int i=0; i<10; i++) {
            paquetChantiers.add(new Batiment("batiment",0,0,0,0,0));
        }
    }

    static void addJoueur(JoueurIA j){
        listeJoueurs.add(j);
    }

    static void setListeOuvriersSelectionnables(){
        while(listeOuvriersSelectionnables.size() < 5){
            Carte ouvrier = paquetOuvriers.remove(0);
            listeOuvriersSelectionnables.add(ouvrier);
        }
    }

    static void setListeChantiersSelectionnables(){
        while(listeChantiersSelectionnables.size() < 5){
            Carte chantier = paquetChantiers.remove(0);
            listeChantiersSelectionnables.add(chantier);
        }
    }

    static void attribuerPieces(JoueurIA joueur) throws Throwable {
        // attribuer une pièce d'or :
        Piece piece = selectionnerPiece(enumTypePiece.OR);
        joueur.addEcu(piece);
        // attribuer 5 pièces d'argent :
        for(int i=0; i<5; i++){
            piece = selectionnerPiece(enumTypePiece.ARGENT);
            joueur.addEcu(piece);
        }
    }

    static Piece selectionnerPiece(enumTypePiece type) throws Throwable {
        Piece piece;
        for(int i=0; i<reserve.size(); i++) {
            if (reserve.get(i).getType().equals(type))
                return reserve.remove(i);
        }
        throw new Throwable("Pas de piece de ce type");
    }

    static void initPartie(){
        System.out.println("Les batisseurs");
        Jeu.addJoueur(new JoueurIA("Sebastien"));
        Jeu.addJoueur(new JoueurIA("Alexandra"));
        // 1
        genererPaquetChantiers();
        setListeChantiersSelectionnables();
        // 2
        genererPaquetOuvriers();
        // distribuer des Ouvriers Apprentis
        // 3
        setListeOuvriersSelectionnables();
        // 4
        genererReserve();
        // 5
        for(int i=0; i<listeJoueurs.size(); i++) {
            try {
                attribuerPieces(listeJoueurs.get(i));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        dernierTour = false;
    }

    public static void main(String[] args) {
        Jeu.initPartie();
        System.out.println(Jeu.listeJoueurs.toString());
    }


}



