package joueur;

import grilleMultiJoueur.Grille;
import grilleSolo.GrilleSolo;

public class JoueurSolo{
	
	private GrilleSolo g;
	private String nomJoueur;

	public JoueurSolo(String nom, GrilleSolo g) {
		this.nomJoueur = nom;
		this.g = new GrilleSolo(12,12);
	}

	public GrilleSolo getGrille() {
		return g;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}
	

}
