package boutonsPersonnalises;

import javax.swing.JButton;

public class BoutonSpecial extends JButton{

	private int id;

	public BoutonSpecial( int id) {
		this.id = id;

		switch(id) {
		case(1):
			this.setText("Placer les bateaux");
			break;

		case(2):
			this.setText("Terminer Placement ");
		break;

		case(3): 
			this.setText("Fin de Tour");
		break;
		}
	}
}
