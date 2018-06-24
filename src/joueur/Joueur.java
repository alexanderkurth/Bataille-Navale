package joueur;

import fenetreGrille.Grille;

public class Joueur {
	
	private String nomJoueur;
	private Grille grilleJoueur;
	private int numeroJoueur;

	public Joueur(String nom, Grille g, int x) {
		this.nomJoueur = nom;
		this.grilleJoueur = g;
		this.numeroJoueur = x;
	}
	
}
