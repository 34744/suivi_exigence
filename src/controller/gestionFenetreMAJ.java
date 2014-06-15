package controller;

public class gestionFenetreMAJ {
	
	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	
	public static void majAjout (){
		view.majAjout majAjout = new view.majAjout();
		view.mainJFrame.setContainerPanel(majAjout);
		
	}
}
