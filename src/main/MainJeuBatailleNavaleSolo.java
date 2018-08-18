package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import boutonsPersonnalises.BoutonSpecial;
import ia.IaData;
import joueur.JoueurSolo;

public class MainJeuBatailleNavaleSolo extends JFrame{
	//Gestion joueurs
	private BoutonSpecial changementTour;
	private boolean placement = true;

	//Jpanel
	private JPanel gauche;
	private JPanel droite;
	private JPanel intermediaire;
	private JPanel bouton;

	public MainJeuBatailleNavaleSolo(JoueurSolo joueur, IaData ia) {


		this.changementTour = new BoutonSpecial(1);
		//Taille du bouton changement Tour
		Dimension d = new Dimension(250,100);
		changementTour.setPreferredSize(d);



		//Initialisation des panels
		this.gauche = new JPanel();
		this.droite = new JPanel();
		this.intermediaire = new JPanel();
		this.bouton = new JPanel();

		//Declarration du LayoutManager
		this.gauche.setLayout(new BorderLayout());
		this.droite.setLayout(new BorderLayout());
		this.intermediaire.setLayout(new BorderLayout());

		//Insertion des composants dans les layouts
		gauche.add(joueur.getGrille());
		droite.add(ia.getGrilleIa());

		intermediaire.add(changementTour);
		bouton.add(intermediaire);

		//Disposition des panels
		this.add(gauche,BorderLayout.WEST);
		this.add(droite, BorderLayout.EAST);

		this.add(bouton,BorderLayout.SOUTH);

		this.changementTour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(placement) {
					if(joueur.getGrille().getTotalCaseBateau() >= 18) {
						placement = false;
					}
				}else {
					changementTour.setText("Fin de Tour");

					joueur.getGrille().gestionJeu();
					ia.getGrilleIa().gestionJeu();
					joueur.getGrille().setTir(1);

				}
			}
		});

		//parametres de la fenetre
		this.setTitle("Bataille Navale Solo");
		this.setSize(1300,850);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setVisible(true);	
	}

}
