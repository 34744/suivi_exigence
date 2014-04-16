package controller;

public class gestionFenetreFonctionnalite {
	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	
	public static void fonctionnalite (){
		view.fonctionnaliteView fonctionnalite = new view.fonctionnaliteView();
		view.mainJFrame.setContainerPanel(fonctionnalite);
		
	}
	
	public static void ajoutFonctionnalite (int idAppli, String nomAppli){
		view.fonctionnaliteViewAjout fonctionnaliteAjout = new view.fonctionnaliteViewAjout(idAppli, nomAppli);
		view.mainJFrame.setContainerPanel(fonctionnaliteAjout);
		
	}
	
	public static void modifFonctionnalite (String nomFonctionnalite, int idAppli, String nomAppli){
		view.fonctionnaliteViewModif fonctionnaliteModif = new view.fonctionnaliteViewModif(nomFonctionnalite, idAppli, nomAppli);
		view.mainJFrame.setContainerPanel(fonctionnaliteModif);
		
	}
	
	public static void modifFonctionnalite (int idFonctionnalite, int idAppli, String nomAppli){
		view.fonctionnaliteViewModif fonctionnaliteModif = new view.fonctionnaliteViewModif(idFonctionnalite, idAppli, nomAppli);
		view.mainJFrame.setContainerPanel(fonctionnaliteModif);
		
	}
}
