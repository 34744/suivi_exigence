package controller;

import java.util.Vector;

import model.fonctionnalite;
import model.fonctionnaliteArbre;
import model.sousFonctionnalite;
import model.sousFonctionnaliteArbre;

public class controllerDBSousFonctionnalite {
	public static Vector<sousFonctionnalite> getSousFonctionnalite(){
		return model.getDataSousFonctionnalite.getSousFonctionnalite();
	}
	
	public static Vector<sousFonctionnalite> getSousFonctionnalite(String nomFonctionnalite){
		return model.getDataSousFonctionnalite.getSousFonctionnalite(nomFonctionnalite);
	}
	
	public static Vector<sousFonctionnaliteArbre> getSousFonctionnaliteArbre(){
		return model.getDataSousFonctionnalite.getSousFonctionnaliteArbre();
	}
	
	public static Vector<sousFonctionnaliteArbre> getSousFonctionnaliteVecteurArbre(int idFonct) {
		return model.getDataSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonct);
	}
	public static Vector<sousFonctionnaliteArbre> getSousFonctionnaliteVecteurArbre(String nomSFonct) {
		return model.getDataSousFonctionnalite.getSousFonctionnaliteVecteurArbre(nomSFonct);
	}
	
	public static sousFonctionnaliteArbre getSousFonctionnaliteArbre(int idSousFonctionnalite){
		return model.getDataSousFonctionnalite.getSousFonctionnaliteArbre(idSousFonctionnalite);
	}
	
	public static model.sousFonctionnaliteArbre getSousFonctionnaliteArbre(
			String nomSousFonctionnalite) {
		return model.getDataSousFonctionnalite.getSousFonctionnaliteArbre(nomSousFonctionnalite);
	}

	public static Vector<sousFonctionnaliteArbre> getSousFonctionnalitVecteurArbre(
			String nomSFonct) {
		// TODO Auto-generated method stub
		return model.getDataSousFonctionnalite.getSousFonctionnaliteVecteurArbre(nomSFonct);
	}

	public static model.sousFonctionnaliteArbre getSousFonctionnaliteArbreVersion(
			int codeSFonctionnalite) {
		return model.getDataSousFonctionnalite.getSousFonctionnaliteArbreVersion(codeSFonctionnalite);
	}
}
