package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import fenetreGrille.BoutonBateaux;
import fenetreGrille.Grille;


public class MenuBatailleNavale extends JFrame{
	
	private Grille grille ;
	private BoutonBateaux boutons;
	
	public MenuBatailleNavale(){		
		this.grille = new Grille(11,11); 
		this.add(grille,BorderLayout.CENTER);
		/*
		this.boutons = new BoutonBateaux();
		this.add(boutons,BorderLayout.WEST);
		*/
		
	
	//parametres de la fenetre
		this.setTitle("Bataille Navale 54");
		this.setSize(1200,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setVisible(true);		
		}

		//Main
		public static void main(String[] args) {
			new MenuBatailleNavale();
		}

}
