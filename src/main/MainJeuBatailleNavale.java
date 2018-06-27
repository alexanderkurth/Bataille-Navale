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
import interfaceUtilisateur.InterfacePrincipale;
import joueur.Joueur;


public class MainJeuBatailleNavale extends JFrame{
	
	//Jpanel
	private JPanel centre;
	private JPanel droite;
	private JPanel intermediaire;
	
	//Gestion joueurs
	private BoutonSpecial changementTour;
	private JLabel nomJoueur;
	private int joueur = 1;
	private boolean placement = true;
	
	private int nombreTours;
	
	//Grille
	private Grille grilleJoueur1 ;
	private Grille grilleJoueur2 ;

	//Joueur
	private Joueur joueur1 = new Joueur("Carlos",grilleJoueur1,1);
	private Joueur joueur2 = new Joueur("Kukuss",grilleJoueur2,2);
	
	
	// --------------------------------------------------Debut Constructeur-
	public MainJeuBatailleNavale(){
		this.nomJoueur = new JLabel(joueur2.getNomJoueur() + "place ces bateaux");
		
		
		this.changementTour = new BoutonSpecial("bouton",2);
		//Taille du bouton changement Tour
		Dimension d = new Dimension(250,100);
		changementTour.setPreferredSize(d);
		
		this.changementTour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//tour 1 : j1 place ses bateaux
				//tour 2 : j2 place ses bateaux				
				
				//tour pair : j1 attaque j2
				//tour impair : j2 attaque j1
				
				if(placement) {
					System.out.println(joueur);
				}
						
				
				if(placement) {
					if(joueur == 0) {
						
						if(((BoutonSpecial) e.getSource()).getId() == 2) {
							nomJoueur.setText(joueur1.getNomJoueur() +" places ces bateaux");
						}
						
						
						revalidate();
						repaint();
						centre.add(joueur1.getGrilleJoueur());
						joueur1.getGrilleJoueur().gestionJeu(e);
						
						joueur++;
					}else {
						joueur--;
						
						nomJoueur.setText(joueur2.getNomJoueur() +" places ces bateaux");
						
						remove(joueur1.getGrilleJoueur());
						revalidate();
						repaint();
						centre.add(joueur2.getGrilleJoueur());
						joueur2.getGrilleJoueur().gestionJeu(e);
						
					}
					
					if(joueur1.getGrilleJoueur().getTotalCaseBateau() == joueur2.getGrilleJoueur().getTotalCaseBateau()) {
						placement= false;
						System.out.println(placement);
						
						nomJoueur.setText(joueur2.getNomJoueur() +" attaque");
						
					}
					
				}else {
					System.out.println(nombreTours);
					if(joueur == 0) {
						
						remove(joueur2.getGrilleJoueur());
						revalidate();
						repaint();
						
						nomJoueur.setText(joueur2.getNomJoueur() +" attaque");
						nombreTours++;
						
						centre.add(joueur1.getGrilleJoueur());
						joueur1.getGrilleJoueur().gestionJeu(e);
						
						joueur ++;
					}else {
						joueur --;
						
						remove(joueur1.getGrilleJoueur());
						revalidate();
						repaint();
						
						nomJoueur.setText(joueur1.getNomJoueur() +" attaque");
						nombreTours++;
						
						centre.add(joueur2.getGrilleJoueur());
						joueur2.getGrilleJoueur().gestionJeu(e);
					}
				}
			}
		});

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
		this.intermediaire.add(changementTour,BorderLayout.SOUTH);
		this.intermediaire.add(nomJoueur, BorderLayout.NORTH);	
		this.droite.add(intermediaire);
		
		centre.add(joueur1.getGrilleJoueur());
		
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
		
		public boolean estPair(int x) {
			if(x%2 == 0) {
				return true;
			}else {
				  return false;
		}
	}
		
		public void changerGrilleJoueur1() {
			remove(joueur1.getGrilleJoueur());
			revalidate();
			repaint();
		}

		public void changerGrilleJoueur2() {
			remove(joueur2.getGrilleJoueur());
			revalidate();
			repaint();
		}

}
