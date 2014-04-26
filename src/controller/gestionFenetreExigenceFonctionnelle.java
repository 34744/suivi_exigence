package controller;

public class gestionFenetreExigenceFonctionnelle {
	public static void ajoutExigenceFonctionnnelle (int idSousFonctionnalite, int idFonctionnalite, int idAppli,String nomSousFonctionnalite, String nomAppli, String nomFonctionnalite){
		view.exigenceFonctionnelleViewAjout exigenceFonctionnelleAjout = new view.exigenceFonctionnelleViewAjout(idSousFonctionnalite, idFonctionnalite, idAppli,nomSousFonctionnalite, nomAppli,  nomFonctionnalite);
		view.mainJFrame.setContainerPanel(exigenceFonctionnelleAjout);
	}
	
	public static void modifExigenceFonctionnelle (int idFonctionnalite, int idSousFonctionnalite, int codeExigenceFonctionnelle, String nomExigenceFonctionnelle, String nomSousFonctionnalite, Boolean liste){
		view.exigenceFonctionnelleViewModif exigenceFonctionnelleModif = new view.exigenceFonctionnelleViewModif(idFonctionnalite, idSousFonctionnalite, codeExigenceFonctionnelle, nomExigenceFonctionnelle, nomSousFonctionnalite, liste);
		view.mainJFrame.setContainerPanel(exigenceFonctionnelleModif);
	}
}
