package controller;

public class gestionFenetreRapport {
	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	
	public static void configRapport (){
		view.configRapportView configRapport = new view.configRapportView();
		view.mainJFrame.setContainerPanel(configRapport);
		
	}
}
