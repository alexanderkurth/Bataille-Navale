package fenetreGrille;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class BoutonBateaux extends JPanel{

	private JRadioButton JRBPorteAvion;
	private JRadioButton JRBCroiseur;
	private JRadioButton JRBCroiseur2;
	private JRadioButton JRBSousMarin;
	private JButton JBFin;
	
	public BoutonBateaux() {
		
		this.setLayout(new GridLayout(5,0));
		
		this.JRBPorteAvion = new JRadioButton("Porte Avion");		
		this.JRBCroiseur = new JRadioButton("Croiseur");
		this.JRBCroiseur2 = new JRadioButton("Croiseur"); 
		this.JRBSousMarin = new JRadioButton("Sous Marin");
		
		this.JBFin = new JButton("Terminer le placement");
		
		this.add(JRBPorteAvion);
		this.add(JRBCroiseur);
		this.add(JRBCroiseur2);
		this.add(JRBSousMarin);
		this.add(JBFin);
	}

}
