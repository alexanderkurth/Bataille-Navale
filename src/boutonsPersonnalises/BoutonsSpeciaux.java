package boutonsPersonnalises;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class BoutonsSpeciaux extends JRadioButton{
	
	private int id;

	public BoutonsSpeciaux(int id) { 
		this.id = id;
		
		switch(id) {
		case 1: 
			this.setText("Porte Avion");
			break;
		
		case 2: 
			this.setText("Croiseur");
			break;
			
		case 3: 
			this.setText("Sous Marin");
			break;
		
		case 4: 
			this.setText("Torpilleur");
			break;
			
		case 5: 
			this.setText("Grille à 11 cases");
			break;
			
		case 6: 
			this.setText("Grille à 9 cases");
			break;
		}
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(id>4)
					
				System.out.println(id);				
			}
			
		});
	}	
}
