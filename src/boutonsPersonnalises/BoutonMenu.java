/**
 * 
 */
package boutonsPersonnalises;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import interfaceUtilisateur.InterfaceMultiJoueur;
import interfaceUtilisateur.InterfaceRegles;
import interfaceUtilisateur.InterfaceSolo;

/**
 * @author KURTH Alexander
 *
 */
public class BoutonMenu extends JButton{
	
	private int id;
	
	public BoutonMenu(String texte, int longueur, int largeur, int id) {
		this.setText(texte);
		Dimension d = new Dimension (longueur,largeur);
		this.setPreferredSize(d);
		this.id = id;
		
		/*
		 * 1 : solo
		 * 2 : multi
		 * 3 : regle
		 * 4 : parametre
		 */
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch(id) {
				case(1):
					System.out.println("1");
					new InterfaceSolo("un joueur", 1300, 800);
					
				break;
				
				case(2):
					System.out.println("2");
				new InterfaceMultiJoueur("Multi Joueur",1300,800);
				break;
				
				case(3):
					System.out.println("3");
					new InterfaceRegles("Regles", 600, 340);
				break;
				
				case(4):
					System.out.println("4");
				break;
				
				case(5):
					System.out.println("5");
					exit();
				
				break;
				}
			}			
		});
	}
	
	public int getId() {
		return id;
	}
	
	public void exit() {
		SwingUtilities.windowForComponent(this).dispose();
	}

}
