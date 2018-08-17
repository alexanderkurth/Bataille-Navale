/**
 * 
 */
package interfaceUtilisateur;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fenetres.FenetreAmelioree;

/**
 * @author KURTH Alexander
 *
 */
public class InterfaceRegles extends FenetreAmelioree{

	private JLabel jlTitre;
	private JLabel jlContenu;
	private JButton jbExit;
	private JPanel jpBas;

	/**
	 * @param nom
	 * @param width
	 * @param height
	 */
	public InterfaceRegles(String nom, int width, int height) {
		super(nom, width, height);
		this.setLayout(new BorderLayout());

		//initiation des composants
		this.jlTitre = new JLabel("Règles");
		this.jlContenu = new JLabel("<html>La bataille navale oppose deux joueurs qui s'affrontent.<br /> Chacun a une flotte composée de 5 bateaux, qui sont, en général, les suivants : <br /> <ul><li> 1 porte-avion (5 cases),</li><li> 1 croiseur (4 cases),</li><li> 1 contre-torpilleur (3 cases),</li><li> 1 sous-marin (3 cases),</li><li> 1 torpilleur (2 cases).</li></ul><br />Au début du jeu, chaque joueur place ses bateaux sur sa grille.<br/>Celle-ci est toujours numérotée de A à J verticalement et de 1 à 10 horizontalement.<br />Un à un, les joueurs vont \\\"tirer\\\" sur une case de l'adversaire :<br /> \\t par exemple, B.3 ou encore H.8. <br />Le but est donc de couler les bateaux adverses. Au fur et à mesure, <br />il faut mettre les pions sur sa propre grille afin de se souvenir de ses tirs passés.</html>");
		this.jlContenu.setHorizontalAlignment(SwingConstants.CENTER);

		this.jpBas = new JPanel();

		this.jbExit = new JButton("Quitter");
		this.jbExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				exit();
			}

		});

		//ajout des composants 
		//	this.add(jlTitre,BorderLayout.NORTH);
		this.add(jlContenu,BorderLayout.CENTER);
		this.jpBas.add(jbExit);
		this.add(jpBas,BorderLayout.SOUTH);

	}

	public void exit() {
		dispose();
	}

}
