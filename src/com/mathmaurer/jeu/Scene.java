package com.mathmaurer.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mathmaurer.personnages.Mario;

  
@SuppressWarnings("serial") // information a ete traiter
public class Scene extends JPanel {
	
	
	private ImageIcon icoFond; 		//image du fond
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	private ImageIcon icoDepart;
	private Image imgDepart;
		
	private int xFond1;	//labsic
	private int xFond2;
	private int dx;
	private int xPos;
	
	public Mario mario;
	
	
	
	
	// constructeur
	
	public Scene() {
		
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 634;
		this.dx = 0;
		this.xPos = -1;
		
		icoFond = new ImageIcon(getClass().getResource("/images/FondJoli.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
		
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau.png"));
		this.imgChateau1 = this.icoChateau1.getImage();
		this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		mario = new Mario(300, 245);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		Thread chronoEcran = new Thread(new Chrono());
		 chronoEcran.start();
		 
		 
	}
	
	private void addKeyListener(int i) {
		// TODO Auto-generated method stub
		
	}

	//****getters***//
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}
	
	//public Image getImgFond2() {return imgFond2;}

	//public Image getImgFond1() {return imgFond1;}

	//****setters***//
	
	
	public void setxPos(int xPos) {this.xPos = xPos;}

	
	public void setDx(int dx) {this.dx = dx;}
	
	
	
	//******METHODES***//
	
	public void setxFond1(int xFond1) {
		this.xFond1 = xFond1;
	}

	public void setxFond2(int xFond2) {
		this.xFond2 = xFond2;
	}

	public void deplacement () {
		if(this.xPos >= 0) {
			this.xPos = this.xPos + this.dx;
		
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}
		if(this.xFond1 == -684) {this.xFond1 = 684;}
		else if (this.xFond2 == -684){this.xFond2 = 684;}
		else if (this.xFond1 == 684){this.xFond2 = -684;}
		else if (this.xFond2 == 684){this.xFond2 = -684;}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		this.deplacement();
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, getWidth(), getHeight(), null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, getWidth(), getHeight(), null);
		
		int marioWidth = 50; 							 // largeur souhaitée pour Mario (en pixels)
		int marioHeight = 75;							 // hauteur souhaitée, adapte selon le ratio de l’image

		g2.drawImage(this.mario.marche("mario", 15) , 300, 160, marioWidth, marioHeight, null);
		
		int ChateauWidth = 150; 							 
		int ChateauHeight = 180;	
		g2.drawImage(this.imgChateau1, 5 - this.xPos, 60, ChateauWidth, ChateauHeight, null);
		int DepartWidth = 70; 							 
		int DepartHeight = 100;
		g2.drawImage(this.imgDepart, 140 - this.xPos, 140, DepartWidth, DepartHeight, null);

	}

	

}
