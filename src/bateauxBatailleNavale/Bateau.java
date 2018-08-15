package bateauxBatailleNavale;

public class Bateau {

	private int longueurBateau;
	public int typeBateau;
	public String nomBateau;
	
	
	public Bateau(String nomBateau, int typeBateau,int longueurBateau) {
		this.nomBateau = nomBateau;
		this.typeBateau = typeBateau;
		this.longueurBateau = longueurBateau;
	}
	
	public void setTypeBateau(int typeBateau) {
		this.typeBateau = typeBateau;
	}

	public int getLongueurBateau() {
		return longueurBateau;
	}


	public int getTypeBateau() {
		return typeBateau;
	}	
	
	public void resetTaille() {
		this.longueurBateau = 0;
	}
}
