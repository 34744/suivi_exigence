package model;

import java.util.Vector;

import controller.addDataSousFonctionnalite;
import controller.controllerDBSousFonctionnalite;


public class recupererIdSousFonctionnalite {
	
	private static Vector<model.sousFonctionnaliteArbre> vectSousFonctionnalite = new Vector <model.sousFonctionnaliteArbre>();
	
	private static String nomSFonct;

	private static sousFonctionnalite sousFonctionnalite2 = new sousFonctionnalite();
	public static void recupererIdSF(sousFonctionnalite sousFonctionnalite){
		int idSousFonctionnalite;
		nomSFonct=sousFonctionnalite.getNomSFonct();

		model.sousFonctionnaliteArbre sousFonctionnaliteArbre = controllerDBSousFonctionnalite.getSousFonctionnaliteArbre(nomSFonct);
		idSousFonctionnalite = sousFonctionnaliteArbre.getIdSousFonct();
		System.out.println("sf"+idSousFonctionnalite);
		sousFonctionnalite2.setIdSousFonct(idSousFonctionnalite);
		sousFonctionnalite2.setCodeSFonct(idSousFonctionnalite);
		addDataSousFonctionnalite.addCodeSousFonctionnalite(sousFonctionnalite2);
		
	}
}
