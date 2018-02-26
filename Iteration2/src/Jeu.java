import java.util.ArrayList;
import java.util.Scanner;

public abstract class Jeu {

    static ArrayList<Piece> reserve = new ArrayList<Piece>(); 						// "banque" / taille max = 40

    static ArrayList<Carte> paquetOuvriers = new ArrayList<Carte>(); 				// taille max = 42
    static ArrayList<Carte> listeOuvriersSelectionnables = new ArrayList<Carte>(); 	// pioche du paquet ouvriers / taille max = 5

    static ArrayList<Carte> paquetChantiers = new ArrayList<Carte>(); 				// chantiers batiments + machines / taille max = 42
    static ArrayList<Carte> listeChantiersSelectionnables = new ArrayList<Carte>(); // pioche du paquet batiments / taille max = 5

    static ArrayList<JoueurIA> listeJoueurs = new ArrayList<JoueurIA>(); 			// taille max = 4

    static boolean dernierTour = true;


    static void genererReserve(){
    	for(int i=0; i<15; i++)
    		reserve.add(new Piece(enumTypePiece.OR));		// créer 15 pièces d'or
    	for(int j=0; j<25; j++)
    		reserve.add(new Piece(enumTypePiece.ARGENT));	// créer 25 pièces d'argent
    }

    static void genererPaquetOuvriers(){
        for(int i=0; i<10; i++) {
            paquetOuvriers.add(new Ouvrier("ouvrier"+(i+1),0,0,0,0,0));
        }
    }

    static void genererPaquetChantiers(){
        for(int i=0; i<10; i++) {
            paquetChantiers.add(new Batiment("batiment"+(i+1),0,0,0,0,0));
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
        genererPaquetChantiers();
        setListeChantiersSelectionnables();
        genererPaquetOuvriers();
        // distribuer des Ouvriers Apprentis
        setListeOuvriersSelectionnables();
        genererReserve();
        for(int i=0; i<listeJoueurs.size(); i++) {
            try {
                attribuerPieces(listeJoueurs.get(i));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        dernierTour = false;
    }

    static void jouer(JoueurIA joueur){
        boolean tourPasse = false;
        while(!tourPasse){
            Scanner choix = new Scanner(System.in);
            if(joueur.getNbAction() > 0) {
                System.out.println("Il vous reste "+joueur.getNbAction()+" actions.");
                System.out.println("1 : Ouvrir un chantier");
                System.out.println("2 : Recruter un ouvrier");
                System.out.println("3 : Envoyer travailler un ouvrier");
                System.out.println("4 : Prendre un ou plusieurs écus");
                switch (choix.nextLine()) {
                    case "1":
                        System.out.println("Choisir le chantier a ouvrir :");
                        if(piocherChantier(joueur)) {
                            joueur.utiliserAction();
                            System.out.println(joueur);
                        }
                        break;
                    case "2":
                        System.out.println("Choisir l'ouvrier a recruter :");
                        if(piocherOuvrier(joueur)){
                            joueur.utiliserAction();
                            System.out.println(joueur);
                        }
                        break;
                    case "3":
                        System.out.println("Choisir l'ouvrier a envoyer travailler :");
                        joueur.envoyerTravailler();
                        joueur.utiliserAction();
                        System.out.println(joueur);
                        break;
                    case "4":
                        //System.out.println("Choisir le nombre d'ecus a prendre :");
                        System.out.println("Indisponible dans cette iteration car l'argent n'est pas encore pris en compte");
                        break;
                    default:
                        System.out.println("Choix non valide");
                }
            }
            else{
                System.out.println("Vous n'avez plus de point d'action. Que voulez-vous faire ?");
                System.out.println("1 : Acheter une action");
                System.out.println("2 : Finir le tour");
                String monChoix = choix.nextLine();
                if(monChoix.equals("1")){
                    joueur.acheterAction(1);
                    System.out.println("Vous avez achete une action.");
                }
                else if(monChoix.equals("2")){
                    System.out.println("Vous avez fini votre tour.");
                    tourPasse = joueur.passerTour();
                }
                else
                    System.out.println("Choix non valide");
            }
        }
    }

    private static boolean piocherChantier(JoueurIA joueur) {
        for(int i=0; i<listeChantiersSelectionnables.size(); i++)
            System.out.println((i+1)+" : "+listeChantiersSelectionnables.get(i).toString());
        Scanner choix = new Scanner(System.in);
        switch(choix.nextLine()) {
            case "1":
                joueur.choisirChantier((Batiment)listeChantiersSelectionnables.get(0));
                listeChantiersSelectionnables.remove(0);
                break;
            case "2":
                joueur.choisirChantier((Batiment)listeChantiersSelectionnables.get(1));
                listeChantiersSelectionnables.remove(1);
                break;
            case "3":
                joueur.choisirChantier((Batiment)listeChantiersSelectionnables.get(2));
                listeChantiersSelectionnables.remove(2);
                break;
            case "4":
                joueur.choisirChantier((Batiment)listeChantiersSelectionnables.get(3));
                listeChantiersSelectionnables.remove(3);
                break;
            case "5":
                joueur.choisirChantier((Batiment)listeChantiersSelectionnables.get(4));
                listeChantiersSelectionnables.remove(4);
                break;
            default:
                System.out.println("Choix non valide");
                return false;
        }
        setListeChantiersSelectionnables();
        return true;
    }

    private static boolean piocherOuvrier(JoueurIA joueur) {
        for(int i=0; i<listeOuvriersSelectionnables.size(); i++)
            System.out.println((i+1)+" : "+listeOuvriersSelectionnables.get(i).toString());
        Scanner choix = new Scanner(System.in);
        switch(choix.nextLine()) {
            case "1":
                joueur.choisirOuvrier((Ouvrier)listeOuvriersSelectionnables.get(0));
                listeOuvriersSelectionnables.remove(0);
                break;
            case "2":
                joueur.choisirOuvrier((Ouvrier)listeOuvriersSelectionnables.get(1));
                listeOuvriersSelectionnables.remove(1);
                break;
            case "3":
                joueur.choisirOuvrier((Ouvrier)listeOuvriersSelectionnables.get(2));
                listeOuvriersSelectionnables.remove(2);
                break;
            case "4":
                joueur.choisirOuvrier((Ouvrier)listeOuvriersSelectionnables.get(3));
                listeOuvriersSelectionnables.remove(3);
                break;
            case "5":
                joueur.choisirOuvrier((Ouvrier)listeOuvriersSelectionnables.get(4));
                listeOuvriersSelectionnables.remove(4);
                break;
            default:
                System.out.println("Choix non valide");
                return false;
        }
        setListeOuvriersSelectionnables();
        return true;
    }

    public static void main(String[] args) {
        Jeu.initPartie();
        //System.out.println(Jeu.listeJoueurs.toString());

        JoueurIA joueurActuel;
        while(!dernierTour) {
            for(int i=0; i<Jeu.listeJoueurs.size(); i++){
                joueurActuel = Jeu.listeJoueurs.get(i);
                System.out.println("C'est au tour de "+joueurActuel.getNom()+" de jouer.");
                System.out.println(joueurActuel);
                Jeu.jouer(joueurActuel);
            }
        }
        System.out.println("Fin de la partie.");
    }


}



