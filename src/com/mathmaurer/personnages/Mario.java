package com.mathmaurer.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends personnages{
	
	
	//****VARIABLES//
	private Image imgMario;
	private ImageIcon icoMario;
	
	//*****CONSTRUCTEUR******//
	
	public Mario(int x, int y ) {
		
		super(x, y, 28, 50);
		this.icoMario = new ImageIcon("src/images/MarioDroit.png");
		this.imgMario = this.icoMario.getImage();		
	}
	
	
	//******GETTEUR***//
	public Image getImgMario() {
		return imgMario;
	}
	
	

}
