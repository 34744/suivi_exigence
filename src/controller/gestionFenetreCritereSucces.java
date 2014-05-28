package controller;

public class gestionFenetreCritereSucces {

	public static void modifCritereSucces(int idFonctionnalite, int idCSPassee,	int codeCSPasse, String nomCSpassee, boolean b) {
		// TODO Auto-generated method stub
		
			view.critereSuccesView critereSuccesView = new view.critereSuccesView(idFonctionnalite,  nomCSpassee, codeCSPasse, nomCSpassee);
			view.mainJFrame.setContainerPanel(critereSuccesView);
		
	}

	public static void modifCritereSucces(int idFonctionnalite,	String nomAppli, int codeExigence, String nomCSPassee) {
		// TODO Auto-generated method stub
		view.critereSuccesView critereSuccesView = new view.critereSuccesView(idFonctionnalite, nomAppli, codeExigence, nomCSPassee);
		view.mainJFrame.setContainerPanel(critereSuccesView);
	}
	
	public static void AjoutCritereSucces(int codeExigence, int codeSousFonctionnalite, boolean ajout) {
		// TODO Auto-generated method stub
		view.critereSuccesView critereSuccesView = new view.critereSuccesView(codeExigence, codeSousFonctionnalite, true);
		view.mainJFrame.setContainerPanel(critereSuccesView);
	}
	
}
