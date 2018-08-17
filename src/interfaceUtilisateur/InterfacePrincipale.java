/**
 * 
 */
package interfaceUtilisateur;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import boutonsPersonnalises.BoutonMenu;
import fenetres.FenetreAmelioree;

/**
 * @author KURTH Alexander
 *
 */
public class InterfacePrincipale extends FenetreAmelioree{

	private BoutonMenu solo;
	private BoutonMenu multiJoueur ;
	private BoutonMenu regle ;
	private BoutonMenu parametre ;
	private BoutonMenu quitter ;

	private JPanel centre;
	private JPanel intermediaire;

	/**
	 * @param nom
	 * @param width
	 * @param height
	 */
	public InterfacePrincipale(String nom, int width, int height) {
		super(nom, width, height);
		this.setLayout(new BorderLayout());

		//Instanciation des composants
		this.centre = new JPanel();
		this.centre.setLayout(new GridLayout(5,1));

		this.intermediaire = new JPanel();

		this.solo = new BoutonMenu("Solo",135,50,1);
		this.multiJoueur = new BoutonMenu ("Multi",135,50,2);
		this.regle = new BoutonMenu("regle",135,50,3);
		this.parametre = new BoutonMenu("parametres",135,50,4);
		this.quitter = new BoutonMenu("Quitter",135,50,5);

		//ajout des composants dans le grid Layout
		this.centre.add(solo);
		this.centre.add(multiJoueur);
		this.centre.add(regle);
		this.centre.add(parametre);
		this.centre.add(quitter);

		this.intermediaire.add(centre);

		this.add(intermediaire,BorderLayout.CENTER);
		this.setVisible(true);
	}
}
