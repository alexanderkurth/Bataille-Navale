package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import divers.BoutonSpecial;
import fenetreGrille.Grille;
import joueur.Joueur;


public class MenuBatailleNavale extends JFrame{
	
	private BoutonSpecial changementTour;
	
	private JLabel nomJoueur;
	
	private Grille grilleJoueur1 ;
	private Grille grilleJoueur2 ;

	
	private Joueur joueur1 = new Joueur("Carlos",grilleJoueur1,1);
	private Joueur joueur2 = new Joueur("Kukuss",grilleJoueur2,2);
	
	public MenuBatailleNavale(){
		
		this.changementTour = new BoutonSpecial("Bouton Special",0);
		
		
		this.grilleJoueur1 = joueur1.getGrilleJoueur(); 
		this.nomJoueur = new JLabel("");
		this.add(grilleJoueur1,BorderLayout.WEST);
		this.add(nomJoueur, BorderLayout.NORTH);
	
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
		
		public boolean estPair(int x) {
			if(x%2 == 0) {
				return true;
			}else {
				  return false;
			}
		}

}
