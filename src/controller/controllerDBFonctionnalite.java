package controller;

import java.util.Vector;

import model.application;
import model.applicationArbre;
import model.compoCelluleArbre;
import model.fonctionnalite;
import model.fonctionnaliteArbre;
import model.sousFonctionnaliteArbre;

public class controllerDBFonctionnalite {
	public static Vector<fonctionnalite> getFonctionnalite(){
		return model.getDataFonctionnalite.getFonctionnalite();
	}
	
	public static Vector<fonctionnaliteArbre> getFonctionnaliteArbre(){
		return model.getDataFonctionnalite.getFonctionnaliteArbre();
	}
	
	public static Vector<fonctionnaliteArbre> getFonctionnaliteVecteurArbre(int idFonctionnalite) {
		return model.getDataFonctionnalite.getFonctionnaliteVecteurArbre(idFonctionnalite);
	}
	
	public static Vector<fonctionnaliteArbre> getNumFonctionnaliteVecteurArbre(int numFonctionnalite) {
		return model.getDataFonctionnalite.getNumFonctionnaliteVecteurArbre(numFonctionnalite);
	}
	
	public static fonctionnaliteArbre getFonctionnaliteArbre(int idFonctionnalite){
		return model.getDataFonctionnalite.getFonctionnaliteArbre(idFonctionnalite);
	}

	public static Vector<fonctionnaliteArbre> getNomFonctionnaliteVecteurArbre(
			String nomFonctionnalite) {
		// TODO Auto-generated method stub
		return model.getDataFonctionnalite.getNomFonctionnaliteVecteurArbre(nomFonctionnalite);
	}

	public static model.fonctionnaliteArbre getFonctionnaliteArbre(
			String nomFonctionnalite) {
		// TODO Auto-generated method stub
		return model.getDataFonctionnalite.getFonctionnaliteArbre(nomFonctionnalite);
	}
	
	public static model.fonctionnaliteArbre getFonctionnaliteArbreAppli(String nomAppli) {
		return model.getDataFonctionnalite.getFonctionnaliteArbreAppli(nomAppli);
	}

}
