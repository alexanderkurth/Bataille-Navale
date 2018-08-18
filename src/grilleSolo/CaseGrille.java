package grilleSolo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import ia.IaData;
import joueur.JoueurSolo;


public class CaseGrille extends JButton{
	
	private boolean tir = false;
	
	private JoueurSolo joueur;
	

	private int abcisse;
	private int ordone;
	private int type;
	
	public CaseGrille(int x, int y, int z) {
		this.abcisse = x;
		this.ordone = y;
		this.type = z;
		
		Dimension d = new Dimension(48,48);
		this.setPreferredSize(d);
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
					System.out.println("Type : " + getType());
					System.out.println("Abcisse : " + getAbcisse());
					System.out.println("Ordonne : " + getOrdone());
				*/
			}


		});
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAbcisse() {
		return abcisse;
	}

	public int getOrdone() {
		return ordone;
	}
	
	public boolean isTir() {
		return tir;
	}

	public void setTir(boolean tir) {
		this.tir = tir;
	}


}

