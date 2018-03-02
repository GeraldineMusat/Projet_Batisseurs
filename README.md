# Projet_Batisseurs
Projet POO L3 S6

## Résumé 
// TODO

### Itérations
(dans chaque itération le client verra ce qu'il sera capable de faire avec la nouvelle version (user case), il y aura une date de début et fin de l'itération) 

`Itération 1` - *Début :* Lundi 19 Février 2018 | *Fin :* Mardi 20 Février 2018
<p>=> Création du repository avec un readme</p>
<<<<<<< HEAD
<p>=> Prit connaissance des règles du jeu</p> 
<p>=> Versioning</p> 

   
`Itération 2` - *Début :* Mardi 20 Février 2018 | *Fin : Lundi 26 Février 2018* 
<p>=> *Résumé* : Conception et implémentation des classes Jeu, Carte, Ouvrier, Batiment, JoueurIA, Piece</p> 
<p>=> *Classe JoueursIA* : 
Ce ne sont pas encore des IA : leurs actions sont passées en console.</p>
<p>=> *Classes Carte, Ouvrier, Batiment* : 
Ce sont des cartes de test nommées "ouvrierx" ou "batimentx" (avec x={1,2,3,...}) qui ont leurs attributs à 0 (coût en pièces, ressources, points de victoire...). 
Un joueur peut les choisir dans la pioche et attribuer un ouvrier à un batiment. Mais un ouvrier n'est pas encore payé pour travailler et un batiment ne peut pas encore être construit.</p>
<p>=> *Classe Piece* : 
Les pièces sont implémentées, initialisées et distribuées, mais ne sont pas encore utilisées pour payer les ouvriers et comme gain de construction.</p>
<p>=> *Initialisation d'une partie* : 
• création de 2 joueurs 
• création de 2 paquets de Carte (Ouvrier et Batiment) 
• génération des pioches (5 cartes Ouvrier et 5 cartes Batiment) 
• initialisation de la réserve (Piece) 
• attribution des pièces aux joueurs</p>
<p>=> *Déroulement d'un tour pour un joueur* : 
Tant qu'un joueur a assez de points d'action (PA), il peut choisir d'effectuer les actions suivantes : 
- ouvrir un chantier (-1 PA) 
- recruter un ouvrier (-1 PA) 
- envoyer travailler un ouvrier sur un chantier (-1 PA) 
Quand il n'a plus de PA, il peut choisir de : 
- acheter 1 PA 
- finir son tour</p>
>>>>>>> master

      
`Itération 3` - Lundi 26 Février 2018 : Lundi 12 Mars 2018
<p>*Résumé* : Implémentation du serveur-client et ajout d'attributs pour les cartes</p>
<p>=> *Serveur* : 
Mise en place du serveur et de clients avec le code de l'itération précédente.</p>
<p>=> Implémentation de la notion d'argent (coûts/gains), de coûts de ressources pour les batiments, de production de ressources par les ouvrier, de gains de PV (points de victoire).</p> 
<p>=> Possibilité de vendre/acheter des PA (points d'action) contre des pièces.</p> 
<p>=> Les cartes ont maintenant des attributs différents de 0 qui permettent de construire un batiment avec un seul ouvrier en un tour.</p>
<p>=> Affichage des attributs des cartes de la pioche.</p>
<p>=> Construction d'un batiment en fonction des ouvriers qui travaillent dessus (comparaison des attributs ressources du batiment et des ouvriers). Pour l'instant on testera avec un seul ouvrier, mais la fonction parcourera le tableau des ouvriers du chantier comme si il y en avait plusieurs.</p>
<p>=> Tests unitaires.</p> 


`Itération 4` - Lundi 12 Mars 2018 : Lundi 19 Mars 2018
<p>=> Mise en place du serveur et de clients avec le code de l'itération précédente. (si non fait dans l'itération précédente)</p>
<p>=> Implémentation de la fin de la partie. Possibilité de jouer autant de tours qu'il faut jusqu'à finir la partie.</p>
<p>=> Ajouts des vraies cartes du jeu à partir du fichier liste_cartes.xlsx.</p>
<p>=> Tests unitaires.</p>

   
`Itération 5` -  Lundi 19 Mars 2018 : Lundi 26 Mars 2018
<p>=> *IA* : 
Utilisation de l'aléatoire pour déterminer les choix de chantier et d'ouvriers lors de la pioche. Quelques choix logiques. 
Exemple : Si le joueur a déjà un chantier en cours, il n'en repioche pas un nouveau mais pioche plutôt un ouvrier qu'il envoie travailler jusqu'à ce que le batiment soit construit.
Pas d'achat d'action pour le moment.</p>
<p>=> Tests unitaire.</p>


`Itération 6` - Lundi 26 Mars 2018 : Lundi 9 Avril 2018
<p>=> IA (à détailler)</p>
<p>=> Tests unitaire.</p>


`Itération 7` - Lundi 9 Avril 2018 : Lundi 16 Avril 2018
<p>=> IA (à détailler)</p>
<p>=> Tests unitaire.</p>
