package model;

import java.util.Vector;

import controller.addDataExigenceFonctionnelle;
import controller.addDataSousFonctionnalite;
import controller.controllerDBExigenceFonctionnelle;
import controller.controllerDBSousFonctionnalite;

public class recupererIdExigenceFonctionnelle {
private static Vector<model.exigenceFonctionnelleArbre> vectExigenceFonctionnelle = new Vector <model.exigenceFonctionnelleArbre>();
	
	private static String nomExigence;

	private static exigenceFonctionnelle exigenceFonctionnelle2 = new exigenceFonctionnelle();
	
	public static void recupererIdExigenceFonctionnelle(exigenceFonctionnelle exigenceFonctionnelle){
		int idExigenceFonctionnelle;
		String codeExigenceFonctionnelle;
		nomExigence=exigenceFonctionnelle.getNomExigence();

		model.exigenceFonctionnelleArbre exigenceFonctionnelleArbre = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbre(nomExigence);
		idExigenceFonctionnelle = exigenceFonctionnelleArbre.getIdExigence();
		codeExigenceFonctionnelle= String.valueOf(idExigenceFonctionnelle);
		exigenceFonctionnelle2.setIdExigence(idExigenceFonctionnelle);
		exigenceFonctionnelle2.setCodeExigence(codeExigenceFonctionnelle);
		addDataExigenceFonctionnelle.addCodeExigenceFonctionnelle(exigenceFonctionnelle2);
		
	}
}
