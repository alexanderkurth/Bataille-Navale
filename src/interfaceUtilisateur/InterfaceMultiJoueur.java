/**
 * 
 */
package interfaceUtilisateur;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import fenetres.FenetreAmelioree;
import grilleMultiJoueur.Grille;
import joueur.Joueur;
import main.MainJeuBatailleNavaleMultiJoueurs;

/**
 * @author KURTH Alexander
 *
 */
public class InterfaceMultiJoueur extends FenetreAmelioree{

	private Grille grilleJoueur1 ;
	private Grille grilleJoueur2 ;

	private Joueur joueur1 = new Joueur("",grilleJoueur1,1);
	private Joueur joueur2 = new Joueur("",grilleJoueur2,2);



	private JTextField JTFJoueur1;
	private JTextField JTFJoueur2;
	private JPanel centre;
	private JPanel intermediaire;
	private JButton valider;
	private JLabel titre;

	/**
	 * @param nom
	 * @param width
	 * @param height
	 */
	public InterfaceMultiJoueur(String nom, int width, int height) {
		super("Multi-joueur", 500, 250);

		this.centre = new JPanel();
		this.intermediaire = new JPanel();
		this.centre.setLayout(new GridLayout(4,0));

		this.valider = new JButton("Valider");
		this.titre = new JLabel("Sasir les noms des joueurs");
		this.JTFJoueur1= new JTextField(18);
		this.JTFJoueur2 = new JTextField(18);

		this.centre.add(titre,BorderLayout.NORTH);
		this.centre.add(JTFJoueur1);
		this.centre.add(JTFJoueur2);
		this.centre.add(valider);

		this.intermediaire.add(centre);
		this.add(intermediaire);

		this.valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				joueur1.setNomJoueur(JTFJoueur1.getText());
				joueur2.setNomJoueur(JTFJoueur2.getText());

				if(JTFJoueur1.getText().length() == 0 || JTFJoueur2.getText().isEmpty()) {
					System.out.println("vide");
				}else {
					System.out.println("1");
					Jouer();
				}
			}	
		});
	}

	public void Jouer() {
		new MainJeuBatailleNavaleMultiJoueurs(joueur1,joueur2);
	}

	public void exit() {
		SwingUtilities.windowForComponent(this).dispose();
	}

}
