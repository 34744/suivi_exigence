package model;

import java.util.Vector;

import controller.ControllerDBCritereSucces;
import controller.addDataCritereSucces;
import controller.addDataExigenceFonctionnelle;
import controller.controllerDBExigenceFonctionnelle;

public class recupererIdCritereSucces {
private static Vector<model.critereSuccesArbre> vectCritereSucces = new Vector <model.critereSuccesArbre>();
	
	private static String nomCritere;

	private static critereSucces critereSucces2 = new critereSucces();
	
	public static void recupererIdCritereSucces(critereSucces critereSucces){
		int idCritere;
		String codeCritere;
		nomCritere=critereSucces.getNomCritere();

		model.critereSuccesArbre critereSuccesArbre = ControllerDBCritereSucces.getCritereSuccesArbre(nomCritere);
		idCritere = critereSuccesArbre.getIdCritere();
		//codeExigenceFonctionnelle= idExigenceFonctionnelle;
		critereSucces2.setIdCritere(idCritere);
		critereSucces2.setCodeCritere(idCritere);
		addDataCritereSucces.addCodeCritereSucces(critereSucces2);
		
	}
}
