package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import boutonsPersonnalises.BoutonSpecial;
import fenetreGrille.Grille;
import interfaceUtilisateur.InterfacePrincipale;
import joueur.Joueur;


public class MainJeuBatailleNavale extends JFrame{
	
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
	public MainJeuBatailleNavale(Joueur joueur1, Joueur joueur2){
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
				//System.out.println(joueur1.getGrilleJoueur().getTotalCaseBateau());
				//System.out.println("tour : " +tour);
				
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
						
						remove(joueur1.getGrilleJoueur());
						
						centre.add(joueur2.getGrilleJoueur());
						revalidate();
						repaint();
						
						joueur2.getGrilleJoueur().gestionJeu(e);
						
					}
					
					if(nombreTours%2 != 0){
						
						nomJoueur.setText(joueur2.getNomJoueur() + " Attaque");
						
						remove(joueur2.getGrilleJoueur());
						
						centre.add(joueur1.getGrilleJoueur());
						revalidate();
						repaint();
						
						joueur1.getGrilleJoueur().gestionJeu(e);
						
					}
					

					System.out.println(nombreTours);
				}
				
				nombreTours +=1;
				
				/*
				if(placement) {
					if(estPair) {

						nomJoueur.setText(joueur1.getNomJoueur() +" place ses bateaux");
						repaint();

						remove(joueur1.getGrilleJoueur());
						revalidate();
						repaint();
						
						centre.add(joueur1.getGrilleJoueur());
						revalidate();
						repaint();
						
						joueur1.getGrilleJoueur().gestionJeu(e);

						estPair=false;
					}else {

						nomJoueur.setText(joueur2.getNomJoueur() +" place ses bateaux");
						repaint();

						remove(joueur1.getGrilleJoueur());
						revalidate();
						repaint();
						
						centre.add(joueur2.getGrilleJoueur());
						revalidate();
						repaint();
						
						joueur2.getGrilleJoueur().gestionJeu(e);
						
						estPair = true;

					}

					if(joueur1.getGrilleJoueur().getTotalCaseBateau() == 18 && joueur2.getGrilleJoueur().getTotalCaseBateau() == 18) {
						placement= false;
					}

				}else {
					System.out.println(nombreTours);
					if(estPair) {

						remove(joueur2.getGrilleJoueur());
						revalidate();
						repaint();

						nomJoueur.setText(joueur2.getNomJoueur() +" attaque");
						revalidate();
						repaint();qzdsdz 
						nombreTours++;

						centre.add(joueur1.getGrilleJoueur());
						joueur1.getGrilleJoueur().gestionJeu(e);
						
						estPair=false;

						
					}else {
						

						remove(joueur1.getGrilleJoueur());
						revalidate();
						repaint();

						nomJoueur.setText(joueur1.getNomJoueur() +" attaque");
						revalidate();
						repaint();
						nombreTours++;

						centre.add(joueur2.getGrilleJoueur());
						joueur2.getGrilleJoueur().gestionJeu(e);
						
						estPair=true;
					}
				}*/
			}
		});

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
		return(true);
	}

}
