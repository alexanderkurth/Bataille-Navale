package fenetres;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import boutonsPersonnalises.BoutonsSpeciaux;

public class FenetreParametres extends FenetreAmelioree{
	
	private JPanel centre = new JPanel();;
	private JLabel texteHaut = new JLabel("Parametres partie solo",SwingConstants.CENTER);
	
	private BoutonsSpeciaux grille11;
	private BoutonsSpeciaux grille9;
	
	private ButtonGroup group = new ButtonGroup();

	public FenetreParametres(String nom, int width, int height) {
		super(nom, width, height);
		
		this.grille11 = new BoutonsSpeciaux(5);
		this.grille9 = new BoutonsSpeciaux(6);
		
		this.setLayout(new BorderLayout());
		this.add(texteHaut, BorderLayout.NORTH);
		this.add(centre,BorderLayout.CENTER);


		this.group.add(grille11);
		this.group.add(grille9);
		
		this.centre.add(grille11);
		this.centre.add(grille9);

	}

}
