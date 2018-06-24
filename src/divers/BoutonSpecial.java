package divers;

import java.awt.Dimension;

import javax.swing.JButton;

public class BoutonSpecial extends JButton{

	private int id;
	private String nom;
	
	public BoutonSpecial(String nom, int id) {
		this.nom = nom;
		this.id = id;
		
		switch(id) {
			case(1):
				this.setText("Terminer Placement");
			break;
		}
		
		
		Dimension d = new Dimension(150,50);
		this.setPreferredSize(d);
		
		
	}
	
}
