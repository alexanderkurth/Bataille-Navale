/**
 * 
 */
package interfaceUtilisateur;

import fenetres.FenetreAmelioree;
import main.MainJeuBatailleNavale;

/**
 * @author KURTH Alexander
 *
 */
public class InterfaceMultiJoueur extends FenetreAmelioree{

	/**
	 * @param nom
	 * @param width
	 * @param height
	 */
	public InterfaceMultiJoueur(String nom, int width, int height) {
		super("Multi-joueur", 1200, 700);
		
		
	}
	
	public void Jouer() {
		new MainJeuBatailleNavale();
	}

}
