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
import grilleSolo.GrilleSolo;
import ia.GrilleIa;
import ia.IaData;
import joueur.JoueurSolo;
import main.MainJeuBatailleNavaleSolo;

/**
 * @author KURTH Alexander
 *
 */
public class InterfaceSolo extends FenetreAmelioree{
	
	private GrilleSolo grilleJoueurSolo;
	private GrilleIa grilleIa;

	private JoueurSolo joueur = new JoueurSolo("", grilleJoueurSolo);
	private IaData ia = new IaData(grilleIa);
	
	private JTextField JTFJoueur1;
	private JLabel JlIa;
	private JPanel centre;
	private JPanel intermediaire;
	private JButton valider;
	private JLabel titre;

	/**
	 * @param nom
	 * @param width
	 * @param height
	 */
	public InterfaceSolo(String nom, int width, int height) {
		super("Solo", 500, 250);
		
		this.centre = new JPanel();
		this.intermediaire = new JPanel();
		this.centre.setLayout(new GridLayout(4,0));
		
		this.valider = new JButton("Valider");
		this.titre = new JLabel("Sasir votre speudo");
		this.JTFJoueur1= new JTextField(18);
		this.JlIa = new JLabel("IA");
		
		this.centre.add(titre,BorderLayout.NORTH);
		this.centre.add(JTFJoueur1);
		this.centre.add(JlIa);
		this.centre.add(valider);
		
		this.intermediaire.add(centre);
		this.add(intermediaire);
		
		this.valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				joueur.setNomJoueur(JTFJoueur1.getText());
				
				if(JTFJoueur1.getText().length() == 0) {
					System.out.println("vide");
				}else {
					System.out.println("1");
					Jouer();
				}
			}	
		});
		
	}
	
	public void Jouer() {
		new MainJeuBatailleNavaleSolo(joueur, ia);
	}
	
	public void exit() {
		SwingUtilities.windowForComponent(this).dispose();
	}

}
