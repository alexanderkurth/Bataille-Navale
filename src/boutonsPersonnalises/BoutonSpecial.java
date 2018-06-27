package boutonsPersonnalises;

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
				this.setText("Commencer");
			break;
			
			case(2):
				this.setText("Terminer Placement ");
			break;
			
			case(3): 
				this.setText("Fin de Tour");
			break;
			}
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	}
