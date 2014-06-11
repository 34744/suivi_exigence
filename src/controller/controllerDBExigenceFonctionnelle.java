package controller;

import java.util.Vector;

import model.cellule;
import model.compoCelluleArbre;
import model.exigenceFonctionnelle;
import model.exigenceFonctionnelleArbre;
import model.priorite;
import model.prioriteArbre;
import model.sousFonctionnaliteArbre;

public class controllerDBExigenceFonctionnelle {

	public static Vector<priorite> getPriorite(){
		return model.getDataExigenceFonctionnelle.getPriorite();

	}
	
	public static Vector<exigenceFonctionnelleArbre> getExigenceFonctionnelleVecteurArbre(	int idSousFonctionnalite) {
		// TODO Auto-generated method stub
		return model.getDataExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(idSousFonctionnalite);
	}
	
	public static Vector<exigenceFonctionnelle> getExigenceFonctionnelleVecteur(String nomSousFonctionnalite) {
		// TODO Auto-generated method stub
		return model.getDataExigenceFonctionnelle.getExigenceFonctionnelleVecteur(nomSousFonctionnalite);
	}

	public static model.exigenceFonctionnelleArbre getExgienceFonctionnelleArbre(String nomExigenceFonctionnelle) {
		return model.getDataExigenceFonctionnelle.getExigenceFonctionnelleArbre(nomExigenceFonctionnelle);
	}
	
	public static model.exigenceFonctionnelleArbre getExgienceFonctionnelleArbreInt(int codeExigenceFonctionnelle) {
		return model.getDataExigenceFonctionnelle.getExigenceFonctionnelleArbre(codeExigenceFonctionnelle);
	}

	public static model.exigenceFonctionnelleArbre getExgienceFonctionnelleArbrePdf(String nomExigenceFonctionnelle) {
		return model.getDataExigenceFonctionnelle.getExigenceFonctionnelleArbrePdf(nomExigenceFonctionnelle);
	}
	
	public static model.exigenceFonctionnelleArbre getExgienceFonctionnelleArbreVersion(int codeExigence) {
		return model.getDataExigenceFonctionnelle.getExigenceFonctionnelleArbreVersion(codeExigence);
	}
	
	public static model.exigenceFonctionnelleArbre getExgienceFonctionnelleArbre(int idExigence) {
		// TODO Auto-generated method stub
		return model.getDataExigenceFonctionnelle.getExigenceFonctionnelleArbre(idExigence);

	}
}
