package ia;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

import bateauxBatailleNavale.Bateau;
import bateauxBatailleNavale.BateauCroiseur1;
import bateauxBatailleNavale.BateauCroiseur2;
import bateauxBatailleNavale.BateauPorteAvion;
import bateauxBatailleNavale.BateauSousMarin;
import bateauxBatailleNavale.Torpilleur;
import grilleSolo.CaseGrille;


public class GrilleIa  extends JPanel {

	private int estVertical;

	private int randomColonne;
	private int randomLigne;

	private int nombreBateauAPlacer = 5;

	private int tailleBateau = 5;
	private int verif = 0;

	// ------------------------------------------------------------Utilitaire

	private int numeroTour = 1;

	private int obstacle =0;

	private int correcteur = 1;
	private Bateau b;

	private int nombreColonne;
	private int nombreLigne;
	private CaseGrille[][] caseGrilleIa;
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

	private int Colonne;
	private int Ligne;	



	//--------------------Constructeur	
	public GrilleIa(int nombreLigne, int nombreColonne) {
		this.nombreColonne = nombreColonne;
		this.nombreLigne = nombreLigne;			

		this.caseGrilleIa = new CaseGrille[nombreLigne][nombreColonne];
		this.total .setLayout(new GridLayout(nombreLigne, nombreColonne));

		generationGrille(nombreLigne, nombreColonne);


		while(nombreBateauAPlacer != 0) {
			placerBateauSimple();
			verif +=1;
		}
		colorierGrille();

	}

	public void generationGrille(int nombreLigne, int nombreColonne) {

		for (i = 0; i < nombreLigne; i++) {
			for (j = 0; j < nombreColonne; j++) {
				caseGrilleIa[i][j] = new CaseGrille(i - 1, j - 1, -1);
				total.add(caseGrilleIa[i][j]);

				if (i > 0 && j > 0) {
					this.caseGrilleIa[i][j].setBackground(Color.white);

					this.caseGrilleIa[i][j].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (estTermine && tir == 1) {
								gestionTirBateau(e);
							}
						}
					});

				}

				if (i == 0 && j == 0) {
					this.caseGrilleIa[i][j].setOpaque(false);
					this.caseGrilleIa[i][j].setContentAreaFilled(false);
					this.caseGrilleIa[i][j].setBorderPainted(false);
				}

				if (i == 0 && j != 0) {
					this.caseGrilleIa[i][j].setText("" + numeroX);
					this.caseGrilleIa[i][j].setOpaque(false);
					this.caseGrilleIa[i][j].setContentAreaFilled(false);
					this.caseGrilleIa[i][j].setBorderPainted(false);
					numeroX++;
				}

				if (i != 0 && j == 0) {
					this.caseGrilleIa[i][j].setText("" + numeroY);
					this.caseGrilleIa[i][j].setOpaque(false);
					this.caseGrilleIa[i][j].setContentAreaFilled(false);
					this.caseGrilleIa[i][j].setBorderPainted(false);
					numeroY++;
				}

				//placerBateau();
				this.add(total);
			}
		}

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

	public int Position(int Min,int Max) {
		estVertical = Min + (int)(Math.random() * ((Max - Min) + 1))	;	
		System.out.println("random Position : " + estVertical);
		return estVertical;
	}

	//******************************TEST
	public void placerBateauSimple() {

		Ligne = randomLigne(0,nombreLigne-2);
		Colonne = randomColonne(0,nombreColonne-2);

		switch (nombreBateauAPlacer) {
		case 5:
			b = new BateauPorteAvion();
			tailleBateau = b.getLongueurBateau();
			nombreBateauAPlacer--;
			System.out.println(nombreBateauAPlacer);
			break;

		case 4:
			b = new BateauCroiseur1();
			tailleBateau = b.getLongueurBateau();
			nombreBateauAPlacer--;
			System.out.println(nombreBateauAPlacer);
			break;

		case 3:
			b = new BateauCroiseur2();
			tailleBateau = b.getLongueurBateau();
			nombreBateauAPlacer--;
			System.out.println(nombreBateauAPlacer);
			break;

		case 2:
			b = new BateauSousMarin();
			tailleBateau = b.getLongueurBateau();
			nombreBateauAPlacer--;
			System.out.println(nombreBateauAPlacer);
			break;

		case 1:
			b = new Torpilleur();
			tailleBateau = b.getLongueurBateau();
			nombreBateauAPlacer--;
			System.out.println(nombreBateauAPlacer);
			break;

		default : System.out.println("fini");
		}

		//horizontal
		if(randomColonne +tailleBateau  >= nombreColonne) {
			if(caseGrilleIa[Ligne+ correcteur][Colonne+ correcteur].getType() == -1) {

				for (int y = 0; y < tailleBateau; y++) {

					if(caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].getType() == -1) {
						caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].setBackground(Color.MAGENTA);
						caseGrilleIa[Ligne + correcteur][Colonne - y + correcteur].setType(b.getTypeBateau());
						nombreCaseBateau();
					}else {
						if(caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].getType() != -1) {
							obstacle += 1;
							System.out.println("Taille obstacle : " + obstacle);	
						}
					}	
				}
				tailleBateau = 0;
			}else {
				Ligne = randomLigne(0,nombreLigne-2);
				Colonne = randomColonne(0,nombreColonne-2);

				for (int y = 0; y < tailleBateau; y++) {

					if(caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].getType() == -1) {
						caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].setBackground(Color.BLACK);
						caseGrilleIa[Ligne + correcteur][Colonne - y + correcteur].setType(b.getTypeBateau());
						nombreCaseBateau();
					}else {
						if(caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].getType() != -1) {
							obstacle += 1;
							System.out.println("Taille obstacle : " + obstacle);	
						}
					}
				}
			}

			if(obstacle != 0) {
				System.out.println("sbeul");
				tailleBateau = b.getLongueurBateau();

				Ligne = randomLigne(0,nombreLigne-2);
				Colonne = randomColonne(0,nombreColonne-2);

				if(caseGrilleIa[Ligne+ correcteur][Colonne+ correcteur].getType() == -1) {
					for (int w = 0; w < tailleBateau; w++) {
						if(caseGrilleIa[Ligne+ correcteur][Colonne-w+ correcteur].getType() == -1) {
							caseGrilleIa[Ligne+ correcteur][Colonne-w+ correcteur].setBackground(Color.GRAY);
							caseGrilleIa[Ligne + correcteur][Colonne - w + correcteur].setType(b.getTypeBateau());
							nombreCaseBateau();
						}
					}

				}else {
					Ligne = randomLigne(0,nombreLigne-2);
					Colonne = randomColonne(0,nombreColonne-2);

					for (int y = 0; y < tailleBateau; y++) {

						if(caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].getType() == -1) {
							caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].setBackground(Color.BLACK);
							caseGrilleIa[Ligne + correcteur][Colonne - y + correcteur].setType(b.getTypeBateau());
							nombreCaseBateau();
						}else {
							if(caseGrilleIa[Ligne+ correcteur][Colonne-y+ correcteur].getType() != -1) {
								obstacle += 1;
								System.out.println("Taille obstacle : " + obstacle);	
							}
						}
					}
				}
			}
		}else {

			if(caseGrilleIa[Ligne+ correcteur][Colonne+ correcteur].getType() == -1) {

				for (int y = 0; y < tailleBateau; y++) {

					if(caseGrilleIa[Ligne+ correcteur][Colonne+y+ correcteur].getType() == -1) {
						caseGrilleIa[Ligne+ correcteur][Colonne+y+ correcteur].setBackground(Color.YELLOW);
						caseGrilleIa[Ligne + correcteur][Colonne + y + correcteur].setType(b.getTypeBateau());
						nombreCaseBateau();
					}							
				}
			}else {
				Ligne = randomLigne(0,nombreLigne-2);
				Colonne = randomColonne(0,nombreColonne-2);

				for (int y = 0; y < tailleBateau; y++) {

					if(caseGrilleIa[Ligne+ correcteur][Colonne+y+ correcteur].getType() == -1) {
						caseGrilleIa[Ligne+ correcteur][Colonne+y+ correcteur].setBackground(Color.BLACK);
						caseGrilleIa[Ligne + correcteur][Colonne + y + correcteur].setType(b.getTypeBateau());
						nombreCaseBateau();
					}else {
						if(caseGrilleIa[Ligne+ correcteur][Colonne+y+ correcteur].getType() != -1) {
							obstacle += 1;
							System.out.println("Taille obstacle : " + obstacle);	
						}
					}
				}
			}	
		}				

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
			enjeu = true;
			verif = 6;
		}
		if (enjeu) {
			estTermine = true;
		}

		if (estTermine) {
			tousCoules();
			if (tir == 0) {
				numeroTour += 1;
				tir = 1;
			}else {
				((AbstractButton) e.getSource()).setText("Vous devez tirer");
			}
		}
	}

	// ------------------------------------------Gestion Tir
	public void gestionTirBateau(ActionEvent e) {
		switch (((CaseGrille) e.getSource()).getType()) {

		case (0):
			tir = 1;
		System.out.println("Case Deja Jouée");
		break;

		case (-1):
			((CaseGrille) e.getSource()).setBackground(Color.BLACK);
		((CaseGrille) e.getSource()).setType(0);
		tir = 0;
		break;

		case (-2):
			((CaseGrille) e.getSource()).setBackground(Color.RED);
		((CaseGrille) e.getSource()).setType(0);
		caseTorpilleur -= 1;
		tir = 0;
		break;

		case (-3):
			((CaseGrille) e.getSource()).setBackground(Color.RED);
		((CaseGrille) e.getSource()).setType(0);
		caseSousMarin -= 1;
		tir = 0;

		break;

		case (-41):
			((CaseGrille) e.getSource()).setBackground(Color.RED);
		((CaseGrille) e.getSource()).setType(0);
		caseCroiseur -= 1;
		tir = 0;
		break;

		case (-42):
			((CaseGrille) e.getSource()).setBackground(Color.RED);
		((CaseGrille) e.getSource()).setType(0);
		caseCroiseur -= 1;
		tir = 0;
		break;

		case (-5):
			((CaseGrille) e.getSource()).setBackground(Color.RED);
		((CaseGrille) e.getSource()).setType(0);
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
				caseGrilleIa[i][j].setBackground(Color.BLUE);
			}
		}
	}

	public int getTotalCaseBateau() {
		int x= this.caseCroiseur+this.casePorteAvion+this.caseSousMarin+this.caseTorpilleur;	
		return x;
	}
}

