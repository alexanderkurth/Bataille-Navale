package fenetreGrille;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

import bateauxBatailleNavale.Bateau;
import bateauxBatailleNavale.BateauCroiseur;
import bateauxBatailleNavale.BateauPorteAvion;
import bateauxBatailleNavale.BateauSousMarin;
import bateauxBatailleNavale.Torpilleur;
import divers.BoutonSpecial;
import divers.BoutonsSpeciaux;
import joueur.Joueur;

public class Grille extends JPanel {

	// -----------------------------------------------------------Joueur
	private Joueur joueur;

	// ------------------------------------------------------------Utilitaire
	private int correcteur = 1;

	private Bateau b;

	// ------------------------------------------------------------Gestion Jeu
	private int numeroTour = 1;

	// ------------------------------------------------------------- Boutons
	private int verif = 0;

	private JPanel colonne = new JPanel();
	private int tailleBateau = 0;
	private BoutonsSpeciaux JRBPorteAvion;
	private BoutonsSpeciaux JRBCroiseur;
	private BoutonsSpeciaux JRBCroiseur2;
	private BoutonsSpeciaux JRBSousMarin;
	private BoutonsSpeciaux JRBTorpilleur;

	private BoutonSpecial JBTerminer;

	// ------------------------------------------------------------- Grille

	private int tir;
	private boolean estTermine = false;
	private boolean enjeu;

	private int nombreLigne;
	private int nombreColonne;

	private int casePorteAvion = 0;
	private int caseCroiseur = 0;
	private int caseSousMarin = 0;
	private int caseTorpilleur = 0;

	private int abcisse;
	private int ordonnee;

	private Case[][] caseGrille;
	private JPanel total = new JPanel();
	private int i;
	private int j;

	private int numeroX = 0;
	private int numeroY = 0;

	public Grille(int nombreLigne, int nombreColonne) {
		this.nombreColonne = nombreColonne;
		this.nombreLigne = nombreLigne;

		// ------------------------------------------------------------- Boutons
		this.colonne.setLayout(new GridLayout(6, 0));

		// -------------------------------------------------------------Action Listener
		this.JRBPorteAvion = new BoutonsSpeciaux("Porte Avion", 1);
		JRBPorteAvion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new BateauPorteAvion();
				tailleBateau = b.getLongueurBateau();
				JRBPorteAvion.setEnabled(false);
				verif += 1;
			}
		});

		this.JRBCroiseur = new BoutonsSpeciaux("Croiseur", 2);
		JRBCroiseur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new BateauCroiseur();
				tailleBateau = b.getLongueurBateau();
				JRBCroiseur.setEnabled(false);
				verif += 1;
			}
		});

		this.JRBCroiseur2 = new BoutonsSpeciaux("Croiseur", 2);
		JRBCroiseur2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new BateauCroiseur();
				tailleBateau = b.getLongueurBateau();
				JRBCroiseur2.setEnabled(false);
				verif += 1;
			}
		});

		this.JRBSousMarin = new BoutonsSpeciaux("Sous Marin", 3);
		JRBSousMarin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new BateauSousMarin();
				tailleBateau = b.getLongueurBateau();
				JRBSousMarin.setEnabled(false);
				verif += 1;
			}
		});

		this.JRBTorpilleur = new BoutonsSpeciaux("Torpilleur", 4);
		JRBTorpilleur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b = new Torpilleur();
				tailleBateau = b.getLongueurBateau();
				JRBTorpilleur.setEnabled(false);
				verif += 1;
			}
		});
/*
		this.JBTerminer = new BoutonSpecial("Terminer", 1);
		JBTerminer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestionJeu(e);
			}
		});
*/
		this.colonne.add(JRBPorteAvion);
		this.colonne.add(JRBCroiseur);
		this.colonne.add(JRBCroiseur2);
		this.colonne.add(JRBSousMarin);
		this.colonne.add(JRBTorpilleur);
		//this.colonne.add(JBTerminer);
		this.add(colonne);

		// ------------------------------------------------------------- Grille

		this.caseGrille = new Case[nombreLigne][nombreColonne];
		this.total.setLayout(new GridLayout(nombreLigne, nombreColonne));

		generationGrille(nombreLigne, nombreColonne);

	}
	// Fin constructeur

	// ---------------------------------------------------Generation de la grille
	public void generationGrille(int nombreLigne, int nombreColonne) {
		for (i = 0; i < nombreLigne; i++) {
			for (j = 0; j < nombreColonne; j++) {
				caseGrille[i][j] = new Case(i - 1, j - 1, -1);
				total.add(caseGrille[i][j]);

				if (i > 0 && j > 0) {
					this.caseGrille[i][j].setBackground(Color.white);
					this.caseGrille[i][j].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (estTermine && tir == 1) {
								gestionTirBateau(e);
							}
						}
					});
				}

				if (i == 0 && j == 0) {
					this.caseGrille[i][j].setOpaque(false);
					this.caseGrille[i][j].setContentAreaFilled(false);
					this.caseGrille[i][j].setBorderPainted(false);
				}

				if (i == 0 && j != 0) {
					this.caseGrille[i][j].setText("" + numeroX);
					this.caseGrille[i][j].setOpaque(false);
					this.caseGrille[i][j].setContentAreaFilled(false);
					this.caseGrille[i][j].setBorderPainted(false);
					numeroX++;
				}

				if (i != 0 && j == 0) {
					this.caseGrille[i][j].setText("" + numeroY);
					this.caseGrille[i][j].setOpaque(false);
					this.caseGrille[i][j].setContentAreaFilled(false);
					this.caseGrille[i][j].setBorderPainted(false);
					numeroY++;
				}

				placerBateau();
				this.add(total);
			}
		}
	}

	// ------------------------------------Placement Bateaux
	public void placerBateau() {
		if (i > 0 && j > 0) {
			this.caseGrille[i][j].addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {

					Object o = event.getSource();
					abcisse = ((Case) o).getAbcisse();
					ordonnee = ((Case) o).getOrdone();

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
		for (int y = 0; y < tailleBateau; y++) {
			caseGrille[abcisse + correcteur][ordonnee + correcteur + y].setBackground(Color.PINK);
			caseGrille[abcisse + correcteur][ordonnee + correcteur + y].setType(b.getTypeBateau());

			nombreCaseBateau();

		}
		tailleBateau = 0;
	}

	public void bateauHorizontalGauche() {
		for (int y = 0; y < tailleBateau; y++) {
			caseGrille[abcisse + correcteur][ordonnee + correcteur - y].setBackground(Color.GRAY);
			caseGrille[abcisse + correcteur][ordonnee + correcteur - y].setType(b.getTypeBateau());

			nombreCaseBateau();

		}
		tailleBateau = 0;
	}

	public void bateauVerticalBas() {
		for (int y = 0; y < tailleBateau; y++) {
			caseGrille[abcisse + correcteur + y][ordonnee + correcteur].setBackground(Color.ORANGE);
			caseGrille[abcisse + correcteur + y][ordonnee + correcteur].setType(b.getTypeBateau());

			nombreCaseBateau();

		}
		tailleBateau = 0;
	}

	public void bateauVerticalHaut() {
		for (int y = 0; y < tailleBateau; y++) {
			caseGrille[abcisse + correcteur - y][ordonnee + correcteur].setBackground(Color.YELLOW);
			caseGrille[abcisse + correcteur - y][ordonnee + correcteur].setType(b.getTypeBateau());

			nombreCaseBateau();

		}
		tailleBateau = 0;
	}

	public void nombreCaseBateau() {
		switch (b.getTypeBateau()) {
		case (-5):
			casePorteAvion += 1;
		break;

		case (-4):
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
			colorierGrille();
			enjeu = true;
			verif = 6;
		}
		if (enjeu) {
			((AbstractButton) e.getSource()).setText("Commencer");
			estTermine = true;
		}

		if (estTermine) {
			tousCoules();
			if (tir == 0) {
				((AbstractButton) e.getSource()).setText("" + numeroTour);
				numeroTour += 1;
				tir = 1;
			} else {
				((AbstractButton) e.getSource()).setText("Vous devez tirer");
			}
		}
	}

	// ------------------------------------------Gestion Tir
	public void gestionTirBateau(ActionEvent e) {
		switch (((Case) e.getSource()).getType()) {

		case (0):
			tir = 1;
		System.out.println("Case Deja Jouée");
		break;

		case (-1):
			((Case) e.getSource()).setBackground(Color.BLACK);
		((Case) e.getSource()).setType(0);
		tir = 0;
		break;

		case (-2):
			((Case) e.getSource()).setBackground(Color.RED);
		((Case) e.getSource()).setType(0);
		caseTorpilleur -= 1;
		tir = 0;
		break;

		case (-3):
			((Case) e.getSource()).setBackground(Color.RED);
		((Case) e.getSource()).setType(0);
		caseSousMarin -= 1;
		tir = 0;

		break;

		case (-4):
			((Case) e.getSource()).setBackground(Color.RED);
		((Case) e.getSource()).setType(0);
		caseCroiseur -= 1;
		tir = 0;
		break;

		case (-5):
			((Case) e.getSource()).setBackground(Color.RED);
		((Case) e.getSource()).setType(0);
		casePorteAvion -= 1;
		tir = 0;
		break;

		}
	}

	public void tousCoules() {
		if (casePorteAvion == 0 && caseCroiseur == 0 && caseSousMarin == 0 && caseTorpilleur == 0) {
			System.out.println("Victoire");
		}
	}

	// --------------------------------Colorier Grille
	public void colorierGrille() {
		for (int i = 0; i < nombreLigne; i++) {
			for (int j = 0; j < nombreColonne; j++) {
				caseGrille[i][j].setBackground(Color.BLUE);
			}
		}
	}

	public int getNumeroTour() {
		return numeroTour;
	}

	public void setNumeroTour(int numeroTour) {
		this.numeroTour = numeroTour;
	}

	public int getVerif() {
		return verif;
	}

	public boolean isEstTermine() {
		return estTermine;
	}

	public void setEstTermine(boolean estTermine) {
		this.estTermine = estTermine;
	}

	public boolean isEnjeu() {
		return enjeu;
	}

	public void setEnjeu(boolean enjeu) {
		this.enjeu = enjeu;
	}

	public int getTir() {
		return tir;
	}

	public void setTir(int tir) {
		this.tir = tir;
	}

	public int getCasePorteAvion() {
		return casePorteAvion;
	}
	
	public int getTotalCaseBateau() {
		int x= this.caseCroiseur+this.casePorteAvion+this.caseSousMarin+this.caseTorpilleur;	
		return x;
	}
}