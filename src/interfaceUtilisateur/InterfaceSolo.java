/**
 * 
 */
package interfaceUtilisateur;

import javax.swing.JLabel;

import fenetres.FenetreAmelioree;

/**
 * @author KURTH Alexander
 *
 */
public class InterfaceSolo extends FenetreAmelioree{
	
	private JLabel jlJoueur1;
	private JLabel jlJoueur2;

	/**
	 * @param nom
	 * @param width
	 * @param height
	 */
	public InterfaceSolo(String nom, int width, int height) {
		super("Solo", 1350, 850);
	}

}
