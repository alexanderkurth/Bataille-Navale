/**
 * 
 */
package ia;

import fenetreGrille.Grille;

/**
 * @author KURTH Alexander
 *
 */
public class IaData {

	private Grille grilleIa;
	private int numeroIa;
	
	public IaData(Grille grille, int x) {
		this.grilleIa = grille;
		this.numeroIa = x;
	}

	public Grille getGrilleIa() {
		return grilleIa;
	}

	public void setGrilleIa(Grille grilleIa) {
		this.grilleIa = grilleIa;
	}

	public int getNumeroIa() {
		return numeroIa;
	}

	public void setNumeroIa(int numeroIa) {
		this.numeroIa = numeroIa;
	}
}
