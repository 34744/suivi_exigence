package controller;

import java.util.Vector;

import model.miseAJourArbre;
import model.origineArbre;
import model.pointMajArbre;
import model.sousFonctionnaliteArbre;

public class controllerDBPointMaj {

	public static Vector<pointMajArbre> getPointMajVecteurArbre(int idMAJ) {
		return model.getDataPointMaj.getPointMajArbre(idMAJ);
	}
	
	public static Vector<origineArbre> getOrigineVecteurArbre() {
		return model.getDataPointMaj.getOrigineArbre();
	}

	public static origineArbre getOrigineArbre(String nomOrigine) {
		// TODO Auto-generated method stub
		return model.getDataPointMaj.getOrigineArbre(nomOrigine);
	}
}
