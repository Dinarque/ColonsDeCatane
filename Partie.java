
package catane;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

import java.util.random.RandomGenerator;




public class Partie {
	
int n_joueur ;
LinkedList<Joueur> joueurs = new LinkedList<Joueur> () ;
Plateau plateau ;
	
public Partie() {
Scanner sc = new Scanner(System.in) ;
this.plateau = new Plateau() ;
System.out.println("Bienvenue pour une nouvelle partie des Colons de Catane !") ;

System.out.println("Veuillez indiquer si vous préférez jouer à trois ou quatre joueur") ;
String scan = sc.next() ;

while  (((scan.equals("3")) || (scan.equals("4")) ) == false ) {
	System.out.println("répondez à la question posée. ");
	scan = sc.next() ; }

int n_joueur ;
if (scan.equals("3")) { this.n_joueur = 3 ;  } else { this.n_joueur = 4 ;}

System.out.println("Vous serez donc "+this.n_joueur+ " joueurs à jouer !");

String bienvenue = "Bienvenue dans le jeu, " ;
for (int i = 1;  i< (this.n_joueur + 1); i++) {
	System.out.println("Entrez le nom du joueur "+(i) ) ; 
	scan = sc.next() ;
	Joueur j = new Joueur(scan) ;
	bienvenue += scan +", " ;
	this.joueurs.add(j); }
	
System.out.println(bienvenue+ " !");

this.plateau = new Plateau() ;




	
}







public void Cavalier() {
	System.out.println("voilà le cavalier ! ");
}


			

	

	
public boolean Victoire() {
	for (Joueur j : this.joueurs) {
		if (j.getPts() > 9) {
			return true ;
			
		}
	}
	return false ;
}
	



public void Jouer() {
	int ind_joueur = 0 ;
	
	while (Victoire() == false ) {
		this.joueurs.get(ind_joueur).Tour() ;
		ind_joueur ++ ;
		if (ind_joueur == this.n_joueur) {ind_joueur = 0 ; }
		
	}
			
			
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
