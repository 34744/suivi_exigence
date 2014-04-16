package controller;

public class gestionFenetreExigenceFonctionnelle {
	public static void ajoutExigenceFonctionnnelle (int idSousFonctionnalite, int idFonctionnalite, int idAppli,String nomSousFonctionnalite, String nomAppli, String nomFonctionnalite){
		view.exigenceFonctionnelleViewAjout exigenceFonctionnelleAjout = new view.exigenceFonctionnelleViewAjout(idSousFonctionnalite, idFonctionnalite, idAppli,nomSousFonctionnalite, nomAppli,  nomFonctionnalite);
		view.mainJFrame.setContainerPanel(exigenceFonctionnelleAjout);
	}
	
	public static void modifExigenceFonctionnelle (int idSousFonctionnalite, int codeExigenceFonctionnelle, String nomExigenceFonctionnelle){
		view.exigenceFonctionnelleViewModif exigenceFonctionnelleModif = new view.exigenceFonctionnelleViewModif(idSousFonctionnalite, codeExigenceFonctionnelle, nomExigenceFonctionnelle);
		view.mainJFrame.setContainerPanel(exigenceFonctionnelleModif);
	}
}
