package fenetreGrille;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;


public class Case extends JButton{
	
	private int abcisse;
	private int ordone;
	private int type;
	
	public Case(int x, int y, int z) {
		this.abcisse = x;
		this.ordone = y;
		this.type = z;
		
		/*
		 * -1 : eau
		 * 0 : déjà jouée
		 * 5 : porte avion
		 * 4 : croiseur
		 * 3 : sous marin
		 * 2 : torpilleur 
		 */
		
		Dimension d = new Dimension(55,55);
		this.setPreferredSize(d);
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					System.out.println("Type : " + getType());
			}


		});
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAbcisse() {
		return abcisse;
	}

	public int getOrdone() {
		return ordone;
	}

}
