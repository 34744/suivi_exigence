package controller;

public class gestionFenetreSousFonctionnalite {
	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}

	public static void ajoutSousFonctionnalite (int idFonctionnalite, String nomFonctionnalite, int idAppli){
		view.sousFonctionnaliteViewAjout sousFonctionnaliteAjout = new view.sousFonctionnaliteViewAjout(idFonctionnalite, nomFonctionnalite, idAppli);
		view.mainJFrame.setContainerPanel(sousFonctionnaliteAjout);
	}
	
	public static void modifSousFonctionnalite (int idFonctionnalite, int codeSousFonctionnalite, String nomSousFonctionnalite){
		view.sousFonctionnaliteViewModif sousFonctionnaliteModif = new view.sousFonctionnaliteViewModif(idFonctionnalite, codeSousFonctionnalite, nomSousFonctionnalite);
		view.mainJFrame.setContainerPanel(sousFonctionnaliteModif);
	}
}
