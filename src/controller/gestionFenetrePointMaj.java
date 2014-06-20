package controller;

public class gestionFenetrePointMaj {
	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	
	public static void pointMajAjoutView (int idMaj){
		view.pointMajAjoutView pointmaj = new view.pointMajAjoutView(idMaj);
		view.mainJFrame.setContainerPanel(pointmaj);	
	}
}
