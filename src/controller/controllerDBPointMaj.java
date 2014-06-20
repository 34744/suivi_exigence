package controller;

import java.util.Vector;

import model.pointMajArbre;
import model.sousFonctionnaliteArbre;

public class controllerDBPointMaj {

	public static Vector<pointMajArbre> getPointMajVecteurArbre(int idMAJ) {
		return model.getDataPointMaj.getPointMajArbre(idMAJ);
	}

}
