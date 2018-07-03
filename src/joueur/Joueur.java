package joueur;

import fenetreGrille.Grille;

/**
 * @author KURTH Alexander
 *
 */
public class Joueur {

	private String nomJoueur;
	private Grille grilleJoueur;
	private int numeroJoueur;

	public Joueur(String nom, Grille g, int x) {
		this.nomJoueur = nom;
		this.grilleJoueur = new Grille(11,11);
		this.numeroJoueur = x;
	}
	
	
	public Grille getGrilleJoueur() {
		return grilleJoueur;
	}

	public void setGrilleJoueur(Grille grilleJoueur) {
		this.grilleJoueur = grilleJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public int getNumeroJoueur() {
		return numeroJoueur;
	}	
}
