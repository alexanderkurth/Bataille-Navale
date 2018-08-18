package grilleSolo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import bateauxBatailleNavale.Bateau;
import bateauxBatailleNavale.BateauCroiseur1;
import bateauxBatailleNavale.BateauCroiseur2;
import bateauxBatailleNavale.BateauPorteAvion;
import bateauxBatailleNavale.BateauSousMarin;
import bateauxBatailleNavale.Torpilleur;
import boutonsPersonnalises.BoutonsSpeciaux;
import fenetres.FenetreVictoire;

public class GrilleSolo  extends JPanel {

	// ------------------------------------------------------------Utilitaire

	private int obstacle =0;

	private int correcteur = 1;
	private Bateau b;

	private int nombreColonne;
	private int nombreLigne;
	private CaseGrille[][] caseGrilleSolo;
	private JPanel total = new JPanel();

	//-------------------------generation Grille
	private int i =0;
	private int j =0;
	private int numeroX = 0;
	private int numeroY = 0;

	// ------------------------------------------------------------- Grille

	private int tir;
	private boolean estTermine = false;
	private boolean enjeu;

	private int casePorteAvion = 0;
	private int caseCroiseur = 0;
	private int caseSousMarin = 0;
	private int caseTorpilleur = 0;

	private int abcisse;
	private int ordonnee;

	//------------------------------Boutons Bateaux
	private int verif = 0;

	private JPanel colonne = new JPanel();
	private int tailleBateau = 0;
	private BoutonsSpeciaux JRBPorteAvion;
	private BoutonsSpeciaux JRBCroiseur;
	private BoutonsSpeciaux JRBCroiseur2;
	private BoutonsSpeciaux JRBSousMarin;
	private BoutonsSpeciaux JRBTorpilleur;

	private int randomLigne;

	private int randomColonne;

	private int Ligne;

	private int Colonne;







	//--------------------Constructeur	
	public GrilleSolo(int nombreLigne, int nombreColonne) {
		this.nombreColonne = nombreColonne;
		this.nombreLigne = nombreLigne;

		//-----------------------Boutons Bateaux
		this.colonne.setLayout(new GridLayout(5,0));

		// -------------------------------------------------------------Action Listener
		this.JRBPorteAvion = new BoutonsSpeciaux(1);
		JRBPorteAvion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new BateauPorteAvion();
				tailleBateau = b.getLongueurBateau();
				JRBPorteAvion.setEnabled(false);
				verif += 1;
			}
		});

		this.JRBCroiseur = new BoutonsSpeciaux(2);
		JRBCroiseur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new BateauCroiseur1();
				tailleBateau = b.getLongueurBateau();
				JRBCroiseur.setEnabled(false);
				verif += 1;
			}
		});

		this.JRBCroiseur2 = new BoutonsSpeciaux(2);
		JRBCroiseur2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new BateauCroiseur2();
				tailleBateau = b.getLongueurBateau();
				JRBCroiseur2.setEnabled(false);
				verif += 1;
			}
		});

		this.JRBSousMarin = new BoutonsSpeciaux(3);
		JRBSousMarin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new BateauSousMarin();
				tailleBateau = b.getLongueurBateau();
				JRBSousMarin.setEnabled(false);
				verif += 1;
			}
		});

		this.JRBTorpilleur = new BoutonsSpeciaux(4);
		JRBTorpilleur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new Torpilleur();
				tailleBateau = b.getLongueurBateau();
				JRBTorpilleur.setEnabled(false);
				verif += 1;
			}
		});

		this.colonne.add(JRBPorteAvion);
		this.colonne.add(JRBCroiseur);
		this.colonne.add(JRBCroiseur2);
		this.colonne.add(JRBSousMarin);
		this.colonne.add(JRBTorpilleur);
		this.add(colonne);


		this.caseGrilleSolo = new CaseGrille[nombreLigne][nombreColonne];
		this.total .setLayout(new GridLayout(nombreLigne, nombreColonne));

		generationGrille(nombreLigne, nombreColonne);
	}

	public void generationGrille(int nombreLigne, int nombreColonne) {

		for (i = 0; i < nombreLigne; i++) {
			for (j = 0; j < nombreColonne; j++) {
				caseGrilleSolo[i][j] = new CaseGrille(i - 1, j - 1, -1);
				total.add(caseGrilleSolo[i][j]);

				if (i > 0 && j > 0) {
					this.caseGrilleSolo[i][j].setBackground(Color.white);					
				}

				if (i == 0 && j == 0) {
					this.caseGrilleSolo[i][j].setOpaque(false);
					this.caseGrilleSolo[i][j].setContentAreaFilled(false);
					this.caseGrilleSolo[i][j].setBorderPainted(false);
				}

				if (i == 0 && j != 0) {
					this.caseGrilleSolo[i][j].setText("" + numeroX);
					this.caseGrilleSolo[i][j].setOpaque(false);
					this.caseGrilleSolo[i][j].setContentAreaFilled(false);
					this.caseGrilleSolo[i][j].setBorderPainted(false);
					numeroX++;
				}

				if (i != 0 && j == 0) {
					this.caseGrilleSolo[i][j].setText("" + numeroY);
					this.caseGrilleSolo[i][j].setOpaque(false);
					this.caseGrilleSolo[i][j].setContentAreaFilled(false);
					this.caseGrilleSolo[i][j].setBorderPainted(false);
					numeroY++;
				}

				placerBateau();
				this.add(total);
			}
		}
		
		System.out.println(nombreColonne);
		System.out.println(nombreLigne);

	}

	// ------------------------------------Placement Bateaux
	public void placerBateau() {
		if (i > 0 && j > 0) {
			this.caseGrilleSolo[i][j].addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {

					Object o = event.getSource();
					abcisse = ((CaseGrille) o).getAbcisse();
					ordonnee = ((CaseGrille) o).getOrdone();

					if (event.isPopupTrigger()) {
						if (abcisse >= 0 && abcisse < tailleBateau) {
							bateauVerticalBas();
						} else {
							bateauVerticalHaut();
						}

					} else {
						if (ordonnee >= 0 && ordonnee < tailleBateau) {
							bateauHorizontalDroite();
						} else {
							bateauHorizontalGauche();
						}
					}
				}
			});
		}
	}


	// -------------------------------------------------GestionPlacementBateau
	public void bateauHorizontalDroite() {
		if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur ].getType() == -1) {
			for (int y = 0; y < tailleBateau; y++) {

				if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur + y].getType() == -1) {
					caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur + y].setBackground(Color.PINK);
					caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur + y].setType(b.getTypeBateau());
					nombreCaseBateau();
				}else {

					if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur + y].getType() != -1) {
						obstacle += 1;
						System.out.println("Taille obstacle : " + obstacle);		
					}
				}	
			}
			tailleBateau = 0;
		}

		if(obstacle != 0 ) {
			System.out.println("sbeul");
			tailleBateau = b.getLongueurBateau();
			caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur ].setBackground(Color.RED);
			for (int w = 0; w < tailleBateau; w++) {
				if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur + w].getType() == b.getTypeBateau()) {
					caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur + w].setBackground(Color.RED);
					caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur + w].setType(-1);
				}
			}	
		}
		obstacle =0;
	}

	public void bateauHorizontalGauche() {
		if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur ].getType() == -1) {
			for (int y = 0; y < tailleBateau; y++) {
				if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur - y].getType() == -1) {
					caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur - y].setBackground(Color.PINK);
					caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur - y].setType(b.getTypeBateau());
					nombreCaseBateau();
				}else {

					if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur - y].getType() != -1) {
						obstacle += 1;
						System.out.println("Taille obstacle : " + obstacle);		
					}
				}	
			}
			tailleBateau = 0;
		}				

		if(obstacle != 0 ) {
			System.out.println("sbeul");
			tailleBateau = b.getLongueurBateau();
			caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur ].setBackground(Color.RED);
			for (int w = 0; w < tailleBateau; w++) {
				if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur - w].getType() == b.getTypeBateau()) {
					caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur - w].setBackground(Color.RED);
					caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur - w].setType(-1);
				}
			}	
		}
		obstacle =0;
	}

	public void bateauVerticalBas() {
		if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur ].getType() == -1) {
			for (int y = 0; y < tailleBateau; y++) {
				if(caseGrilleSolo[abcisse + correcteur + y][ordonnee + correcteur ].getType() == -1) {
					caseGrilleSolo[abcisse + correcteur + y][ordonnee + correcteur ].setBackground(Color.PINK);
					caseGrilleSolo[abcisse + correcteur + y][ordonnee + correcteur ].setType(b.getTypeBateau());
					nombreCaseBateau();
				}else {

					if(caseGrilleSolo[abcisse + correcteur +y][ordonnee + correcteur].getType() != -1) {
						obstacle += 1;
						System.out.println("Taille obstacle : " + obstacle);		
					}
				}	
			}
			tailleBateau = 0;
		}				

		if(obstacle != 0 ) {
			System.out.println("sbeul");
			tailleBateau = b.getLongueurBateau();
			caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur ].setBackground(Color.RED);
			for (int w = 0; w < tailleBateau; w++) {
				if(caseGrilleSolo[abcisse + correcteur +w][ordonnee + correcteur ].getType() == b.getTypeBateau()) {
					caseGrilleSolo[abcisse + correcteur+w][ordonnee + correcteur ].setBackground(Color.RED);
					caseGrilleSolo[abcisse + correcteur +w][ordonnee + correcteur ].setType(-1);
				}
			}	
		}
		obstacle =0;
	}
	public void bateauVerticalHaut() {
		if(caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur ].getType() == -1) {
			for (int y = 0; y < tailleBateau; y++) {
				if(caseGrilleSolo[abcisse + correcteur - y][ordonnee + correcteur].getType() == -1) {
					caseGrilleSolo[abcisse + correcteur - y][ordonnee + correcteur].setBackground(Color.PINK);
					caseGrilleSolo[abcisse + correcteur - y][ordonnee + correcteur].setType(b.getTypeBateau());
					nombreCaseBateau();
				}else {

					if(caseGrilleSolo[abcisse + correcteur -y][ordonnee + correcteur ].getType() != -1) {
						obstacle += 1;
						System.out.println("Taille obstacle : " + obstacle);		
					}
				}	
			}
			tailleBateau = 0;
		}				

		if(obstacle != 0 ) {
			System.out.println("sbeul");
			tailleBateau = b.getLongueurBateau();
			caseGrilleSolo[abcisse + correcteur][ordonnee + correcteur ].setBackground(Color.RED);
			for (int w = 0; w < tailleBateau; w++) {
				if(caseGrilleSolo[abcisse + correcteur -w][ordonnee + correcteur ].getType() == b.getTypeBateau()) {
					caseGrilleSolo[abcisse + correcteur -w][ordonnee + correcteur].setBackground(Color.RED);
					caseGrilleSolo[abcisse + correcteur -w][ordonnee + correcteur].setType(-1);
				}
			}	
		}
		obstacle =0;
	}

	public void nombreCaseBateau() {
		switch (b.getTypeBateau()) {
		case (-5):
			casePorteAvion += 1;
		break;

		case (-41):
			caseCroiseur += 1;
		break;

		case (-42):
			caseCroiseur += 1;
		break;

		case (-3):
			caseSousMarin += 1;
		break;

		case (-2):
			caseTorpilleur += 1;
		break;
		}
	}

	// -----------------------------------------Gestion Jeu
	public void gestionJeu(ActionEvent e) {
		if (verif == 5) {
			//colorierGrille();
			enjeu = true;
			verif = 6;
		}
		if (enjeu) {
			estTermine = true;
		}

		if (estTermine) {
			tousCoules();
			if(tir == 1) {
				gestionTirBateau();
			}

		}
	}

	public int getTir() {
		return tir;
	}

	public void setTir(int tir) {
		this.tir = tir;
	}

	//--------------------------------------Random
	public int randomLigne(int Min,int Max) {
		randomLigne = Min + (int)(Math.random() * ((Max - Min) + 1))	;	
		System.out.println("random ligne : " + randomLigne);
		return randomLigne;
	}

	public int randomColonne(int Min,int Max) {
		randomColonne = Min + (int)(Math.random() * ((Max - Min) + 1))	;	
		System.out.println("random Colonne : " + randomColonne);
		return randomColonne;
	}	

	// ------------------------------------------Gestion Tir
	public void gestionTirBateau() {

		Ligne = randomLigne(0,nombreLigne-2);
		Colonne = randomColonne(0,nombreColonne-2);
		
		
		if(caseGrilleSolo[Ligne][Colonne].getType() == 0 ) {
			System.out.println("erreur");
			
			for(int i=0;i<nombreLigne;i++) {
				for (int j=0;j<nombreColonne;j++) {					
					
					if(caseGrilleSolo[i][j].getType() ==-1) {
						Colonne = i;
						Ligne = j;
					}
					
				}
			}
			
			if(caseGrilleSolo[Colonne][Ligne].getType() == -1) {
				caseGrilleSolo[Colonne][Ligne].setType(0);
				caseGrilleSolo[Colonne][Ligne].setBackground(Color.orange);
			}else {
				System.out.println("plus d'eau");
			}
		}

		if(caseGrilleSolo[Ligne][Colonne].getType() == -5 ) {
			caseGrilleSolo[Ligne][Colonne].setType(0);
			caseGrilleSolo[Ligne][Colonne].setBackground(Color.CYAN);
		}

		if(caseGrilleSolo[Ligne][Colonne].getType() == -41 ) {
			caseGrilleSolo[Ligne][Colonne].setType(0);
			caseGrilleSolo[Ligne][Colonne].setBackground(Color.CYAN);
		}

		if(caseGrilleSolo[Ligne][Colonne].getType() == -42 ) {
			caseGrilleSolo[Ligne][Colonne].setType(0);
			caseGrilleSolo[Ligne][Colonne].setBackground(Color.CYAN);
		}

		if(caseGrilleSolo[Ligne][Colonne].getType() == -3 ) {
			caseGrilleSolo[Ligne][Colonne].setType(0);
			caseGrilleSolo[Ligne][Colonne].setBackground(Color.CYAN);
		}

		if(caseGrilleSolo[Ligne][Colonne].getType() == -2 ) {
			caseGrilleSolo[Ligne][Colonne].setType(0);
			caseGrilleSolo[Ligne][Colonne].setBackground(Color.CYAN);
		}

		if(caseGrilleSolo[Ligne][Colonne].getType() == -1 ) {
			caseGrilleSolo[Ligne][Colonne].setType(0);
			caseGrilleSolo[Ligne][Colonne].setBackground(Color.GREEN);
		}

		tousCoules();

	}


	public void tousCoules() {
		if (casePorteAvion == 0 && caseCroiseur == 0 && caseSousMarin == 0 && caseTorpilleur == 0) {
			System.out.println("Victoire");
			new FenetreVictoire("Victoire", 650, 350);
		}
	}

	// --------------------------------Colorier Grille
	public void colorierGrille() {
		for (int i = 0; i < nombreLigne; i++) {
			for (int j = 0; j < nombreColonne; j++) {
				caseGrilleSolo[i][j].setBackground(Color.BLUE);
			}
		}
	}

	public int getTotalCaseBateau() {
		int x= this.caseCroiseur+this.casePorteAvion+this.caseSousMarin+this.caseTorpilleur;	
		return x;
	}

}
