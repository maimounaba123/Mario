package com.mathmaurer.jeu;

import javax.swing.JFrame;

public class Main {
	
	public static Scene scene; // acceder partout dans notre programme

	public static void main(String[] args) {
		
		
		
		//creation de la fenetre de l'application
		JFrame fenetre = new JFrame("jeu style mario"); 				// creation de la fenetre on apel fenetre  type JFrame avec un tritre 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			 // quand on va cliquer sur l croit rouge sa va fermer le pprogramme 
		fenetre.setSize(700, 360);										// taille 
		fenetre.setLocationRelativeTo(null);							// on centre a l'ecrant
		fenetre.setResizable(false);									// interdiction de redimentionner
		fenetre.setAlwaysOnTop(true);									 //toujour au dessus des autre fenetre 
		
		// instanciation de l'objet scene
		
		scene = new Scene();
		
		fenetre.setContentPane(scene);									// on associe la scene a la fenetre de l'application
		fenetre.setVisible(true);										//rendre la fenetre visible 

	}

}
