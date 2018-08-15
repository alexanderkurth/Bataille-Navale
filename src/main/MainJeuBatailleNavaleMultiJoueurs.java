package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import boutonsPersonnalises.BoutonSpecial;
import grilleMultiJoueur.Grille;
import interfaceUtilisateur.InterfacePrincipale;
import joueur.Joueur;


public class MainJeuBatailleNavaleMultiJoueurs extends JFrame{
	
	private int verif;

	//Jpanel
	private JPanel centre;
	private JPanel droite;
	private JPanel intermediaire;

	//Gestion joueurs
	private BoutonSpecial changementTour;
	private JLabel nomJoueur;
	private boolean tourJoueur1 = true;
	private boolean placement = true;

	private int nombreTours = 2;

	//Grille
	private Grille grilleJoueur1 ;
	private Grille grilleJoueur2 ;


	// --------------------------------------------------Debut Constructeur-
	public MainJeuBatailleNavaleMultiJoueurs(Joueur joueur1, Joueur joueur2){
		this.nomJoueur = new JLabel("");


		this.changementTour = new BoutonSpecial("bouton",1);
		//Taille du bouton changement Tour
		Dimension d = new Dimension(250,100);
		changementTour.setPreferredSize(d);

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

		//centre.add(joueur1.getGrilleJoueur());
		
		centre.add(joueur1.getGrilleJoueur());
		nomJoueur.setText(joueur1.getNomJoueur() + " place ses bateaux");
		

		
		this.changementTour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("pair : " +tourJoueur1);
				
				if(placement) {
					
					if (joueur1.getGrilleJoueur().getTotalCaseBateau() >= 18) {
						tourJoueur1 = false;
						
					}
					
					if( !tourJoueur1) {
					
						
						nomJoueur.setText(joueur2.getNomJoueur() + " place ses bateaux");
						
						centre.remove(joueur1.getGrilleJoueur());
						
						centre.add(joueur2.getGrilleJoueur());
						revalidate();
						repaint();
						
						if (joueur2.getGrilleJoueur().getTotalCaseBateau() >= 18) {
							tourJoueur1 = false;
							placement = false;
						}
						
					}
					
				}else {
					
					changementTour.setText("Fin de Tour");

					if(nombreTours%2 == 0) {
						
						nomJoueur.setText(joueur1.getNomJoueur() + " Attaque");
						
						centre.remove(joueur1.getGrilleJoueur());
						revalidate();
						repaint();
						
						centre.add(joueur2.getGrilleJoueur());
						revalidate();
						repaint();
						
						joueur2.getGrilleJoueur().gestionJeu(e);
						
					}
					
					if(nombreTours%2 != 0){
						
						nomJoueur.setText(joueur2.getNomJoueur() + " Attaque");
						
						centre.remove(joueur2.getGrilleJoueur());
						revalidate();
						repaint();
						
						centre.add(joueur1.getGrilleJoueur());
						revalidate();
						repaint();
						
						joueur1.getGrilleJoueur().gestionJeu(e);
						
					}
					

					System.out.println(nombreTours);
				}
				
				nombreTours +=1;
				
			}
		});

		//Disposition des panels
		this.add(centre, BorderLayout.WEST);
		this.add(droite, BorderLayout.EAST);

		//parametres de la fenetre
		this.setTitle("Bataille Navale 54");
		this.setSize(1200,750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setVisible(true);		
	}

	public boolean estPair(int x) {
		return(true);
	}

}
