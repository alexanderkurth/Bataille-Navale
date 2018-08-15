/**
 * 
 */
package ia;

import grilleMultiJoueur.Grille;
import grilleSolo.GrilleSolo;

/**
 * @author KURTH Alexander
 *
 */
public class IaData {
	
	private GrilleIa g;
	
	public IaData(GrilleIa g) {
		this.g= new GrilleIa(12,12);
	}

	public GrilleIa getG() {
		return g;
	}
	
	
}
