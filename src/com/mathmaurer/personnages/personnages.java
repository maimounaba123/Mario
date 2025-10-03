package com.mathmaurer.personnages;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import com.mathmaurer.jeu.Main;

public class personnages {
	
	private int largeur, hauteur;
	private int x, y;
	private boolean marche;
	private boolean versDroite;
	public int compteur;
	
	//*******CONSTRUCTEUR*****//
	
	public personnages(int x, int y, int largeur, int hauteur) {
		
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.compteur = 0;
		this.marche = false;
		this.versDroite = true;
	}
	
	//******GETTEUR****//

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isMarche() {
		return marche;
	}

	public boolean isVersDroite() {
		return versDroite;
	}

	public int getCompteur() {
		return compteur;
	}
	
	//*****SETTEUR****//

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setMarche(boolean marche) {
		this.marche = marche;
	}

	public void setVersDroite(boolean versDroite) {
		this.versDroite = versDroite;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	
	
	//*****METHODE****//
	public Image marche(String nom, int frequence) {
		
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.marche == false || Main.scene.getxPos() <= 0 ){
			
			if(this.versDroite == true) {str = "/images/" + "MarioArretDroit.png";}
			else {str = "/images/" + "MarioArretGauche.png";}
			
		}else {
			this.compteur++;
			if(this.compteur / frequence == 0) {
				if(this.versDroite == true) {str = "/images/" +  "MarioArretDroit.png";}
				else {str = "/images/" + "MarioArretGauche.png";}
			}else {
				if(this.versDroite == true) {str = "/images/" +  "MarioDroit.png";}
				else {str = "/images/" +  "MarioMacheGauche.png";}
			}
			if(this.compteur == 2 * frequence) {this.compteur = 0;}
		}
		// affichage limage personage 
		 URL location = getClass().getResource(str);
		    if (location == null) {
		        System.err.println("Image non trouvée : " + str);
		        return null;
		    }

		    ico = new ImageIcon(location);
		    img = ico.getImage();
		    return img;
	}

}
