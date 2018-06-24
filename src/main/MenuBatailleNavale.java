package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import divers.BoutonSpecial;
import fenetreGrille.Grille;
import joueur.Joueur;


public class MenuBatailleNavale extends JFrame{
	
	//Jpanel
	private JPanel centre;
	private JPanel droite;
	private JPanel intermediaire;
	
	//Gestion joueurs
	//private BoutonSpecial changementTour;
	private JLabel nomJoueur;
	private int numeroTour;
	
	//Grille
	private Grille grilleJoueur1 ;
	private Grille grilleJoueur2 ;

	//Joueur
	private Joueur joueur1 = new Joueur("Carlos",grilleJoueur1,1);
	private Joueur joueur2 = new Joueur("Kukuss",grilleJoueur2,2);
	
	public MenuBatailleNavale(){
		this.nomJoueur = new JLabel("");
		
		/*
		this.changementTour = new BoutonSpecial("bouton",1);
		//Taille du bouton changement Tour
		Dimension d = new Dimension(250,100);
		changementTour.setPreferredSize(d);
		
		nomJoueur.setText(""+joueur1.getNomJoueur() +"place ses bateaux");
		
		this.changementTour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				 * pair : joueur1 joue
				 * impair : joueur 2 joue
				 
				
				if(estPair(numeroTour)) {
					
					Grille grilleJ1 = joueur1.getGrilleJoueur();
					
					
					if(grilleJ1.getVerif() == 5) {
						grilleJ1.colorierGrille();
						grilleJ1.setEnjeu(true);
						grilleJ1.setVerif(6);					
					}
					if(grilleJ1.isEnjeu()) {
						changementTour.setText("Commencer");
						grilleJ1.setEstTermine(true);
					}
					if(grilleJ1.isEstTermine()) {
						grilleJ1.tousCoules();
						if(grilleJ1.getTir() == 0) {							
							grilleJ1.augmenterTour();
							System.out.println(grilleJ1.getNumeroTour());							
							grilleJ1.setTir(1);	
						}else {
							changementTour.setText("Vous devez tirer");
						}
					}
					numeroTour ++;
				}else {
					Grille grilleJ2 = joueur2.getGrilleJoueur();
					
					
					if(grilleJ2.getVerif() == 5) {
						grilleJ2.colorierGrille();
						grilleJ2.setEnjeu(true);
						grilleJ2.setVerif(6);					
					}
					if(grilleJ2.isEnjeu()) {
						changementTour.setText("Commencer");
						grilleJ2.setEstTermine(true);
					}
					if(grilleJ2.isEstTermine()) {
						grilleJ2.tousCoules();
						if(grilleJ2.getTir() == 0) {							
							grilleJ2.augmenterTour();
							System.out.println(grilleJ2.getNumeroTour());							
							grilleJ2.setTir(1);	
						}else {
							changementTour.setText("Vous devez tirer");
						}
					}
					numeroTour ++;
				}
				
			}
		});
	*/
		//Initialisation grille joueurs
		this.grilleJoueur1 = joueur1.getGrilleJoueur(); 
		this.grilleJoueur2 = joueur2.getGrilleJoueur(); 
		
		//Initialisation des panels
		this.centre = new JPanel();
		this.droite = new JPanel();
		this.intermediaire = new JPanel();
		
		//Declarration du LayoutManager
		this.centre.setLayout(new BorderLayout());
		this.droite.setLayout(new BorderLayout());
		this.intermediaire.setLayout(new BorderLayout());
		
		//Insertion des composants dans les layouts
		this.centre.add(grilleJoueur1);
		//this.intermediaire.add(changementTour,BorderLayout.SOUTH);
		this.intermediaire.add(nomJoueur, BorderLayout.NORTH);
		
		this.droite.add(intermediaire);
		
		//Disposition des panels
		this.add(centre, BorderLayout.WEST);
		this.add(droite, BorderLayout.EAST);
	

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
