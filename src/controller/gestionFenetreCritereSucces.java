package controller;

public class gestionFenetreCritereSucces {

	public static void modifCritereSucces(int idFonctionnalite, int idCSPassee,	int codeCSPasse, String nomCSpassee, boolean b) {
		// TODO Auto-generated method stub
		
			view.critereSuccesView critereSuccesView = new view.critereSuccesView(idFonctionnalite,  nomCSpassee, codeCSPasse);
			view.mainJFrame.setContainerPanel(critereSuccesView);
		
	}

}
