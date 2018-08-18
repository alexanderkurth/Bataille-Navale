package fenetres;

import javax.swing.JFrame;

/**
 * @author KURTH Alexander
 *
 */
public class FenetreAmelioree extends JFrame{
	
	public FenetreAmelioree(String nom, int width, int height) {
		this.setTitle(nom);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
