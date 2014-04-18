package controller;

import java.util.Vector;

import model.critereSuccesArbre;

public class ControllerDBCritereSucces {

	public static Vector<critereSuccesArbre> getCritereSuccesVecteurArbre(int codeExigenceFonctionnelle) {
		// TODO Auto-generated method stub
		return model.getDataCritereSucces.getCritereSuccesVecteurArbre(codeExigenceFonctionnelle);
	}

}
