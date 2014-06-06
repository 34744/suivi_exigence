package controller;

public class gestionFenetreRapport {
	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	
	public static void configRapport (String mode){
		view.configRapportView configRapport = new view.configRapportView(mode);
		view.mainJFrame.setContainerPanel(configRapport);
		
	}
}
