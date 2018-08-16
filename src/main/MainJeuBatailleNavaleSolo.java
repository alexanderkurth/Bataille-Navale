package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import grilleSolo.GrilleSolo;
import ia.GrilleIa;
import ia.IaData;
import joueur.JoueurSolo;

public class MainJeuBatailleNavaleSolo extends JFrame{
	
	private GrilleSolo grilleJoueur;
	private GrilleIa grilleIa;
	
	//Gestion joueurs
	private boolean tourJoueur1 = true;
	private boolean placement = true;
	
	//Jpanel
	private JPanel gauche;
	private JPanel droite;
	private JPanel intermediaire;
	
	public MainJeuBatailleNavaleSolo(JoueurSolo joueur, IaData ia) {


		//Taille du bouton changement Tour
		Dimension d = new Dimension(250,100);

		
		
		//Initialisation des panels
		this.gauche = new JPanel();
		this.droite = new JPanel();
		this.intermediaire = new JPanel();

		//Declarration du LayoutManager
		this.gauche.setLayout(new BorderLayout());
		this.droite.setLayout(new BorderLayout());
		this.intermediaire.setLayout(new BorderLayout());
		
		
		
		
		
		
		
		
		
		
		
		
		//Insertion des composants dans les layouts
		gauche.add(joueur.getGrille());
		droite.add(ia.getG());
		
		//Disposition des panels
		this.add(gauche,BorderLayout.WEST);
		this.add(droite, BorderLayout.EAST);
		
		//parametres de la fenetre
		this.setTitle("Bataille Navale Solo");
		this.setSize(1300,850);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setVisible(true);	
	}

}
