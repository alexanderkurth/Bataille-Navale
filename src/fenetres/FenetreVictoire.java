package fenetres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreVictoire extends FenetreAmelioree{

	private JPanel centre;
	private JLabel JlCentre;

	public FenetreVictoire(String nom, int width, int height) {
		super(nom, width, height);	

		this.centre = new JPanel();
		this.JlCentre = new JLabel("Victoire");

		this.centre.add(JlCentre);
		this.add(centre);
	}



}
