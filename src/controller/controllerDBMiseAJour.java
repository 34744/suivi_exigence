package controller;

import java.util.Vector;

import model.fonctionnalite;
import model.fonctionnaliteArbre;
import model.miseAJourArbre;

public class controllerDBMiseAJour {
	/*public static Vector<fonctionnalite> getFonctionnalite(){
		return model.getDataFonctionnalite.getFonctionnalite();
	}
	
	public static Vector<fonctionnaliteArbre> getFonctionnaliteArbre(){
		return model.getDataFonctionnalite.getFonctionnaliteArbre();
	}
	
	public static fonctionnaliteArbre getFonctionnaliteArbre(int idFonctionnalite){
		return model.getDataFonctionnalite.getFonctionnaliteArbre(idFonctionnalite);
	}
	*/
	public static Vector<miseAJourArbre> getMiseAJourVecteurArbre(String nomApplication) {
		return model.getDataMiseAJour.getMiseAJourVecteurArbre(nomApplication);
	}
	
	public static Vector<miseAJourArbre> getMiseAJourVecteurIntArbre(int idAppli) {
		return model.getDataMiseAJour.getMiseAJourVecteurArbre(idAppli);
	}

	public static Vector<miseAJourArbre> getMiseAJourAttenteArbre() {
		// TODO Auto-generated method stub
		return model.getDataMiseAJour.getMiseAJourAttenteArbre();
	}
	
	public static Vector<miseAJourArbre> getMiseAJourArbre() {
		// TODO Auto-generated method stub
		return model.getDataMiseAJour.getMiseAJourArbre();
	}
	
	public static miseAJourArbre getMiseAJourArbre(int idMiseAJour) {
		// TODO Auto-generated method stub
		return model.getDataMiseAJour.getmiseAJourArbre(idMiseAJour);
	}
	public static miseAJourArbre getMiseAJourArbre(String numMiseAJour) {
		// TODO Auto-generated method stub
		return model.getDataMiseAJour.getmiseAJourArbre(numMiseAJour);
	}
	
	public static model.miseAJourArbre getMiseAJourPoint(int idMAJ) {
		return model.getDataMiseAJour.getmiseAJourPointArbre(idMAJ);
	}
	
	public static model.miseAJourArbre getMiseAJourPointValide(int idMAJ) {
		return model.getDataMiseAJour.getmiseAJourPointValideArbre(idMAJ);
	}
}
