package controller;

import view.Parametres;
import view.accueil;

public class gestionFenetreConfiguration {

	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	
	public static void fonctionnalite (){
		view.fonctionnaliteView fonctionnalite = new view.fonctionnaliteView();
		view.mainJFrame.setContainerPanel(fonctionnalite);
		
	}
	
	public static void configurationAppliModif (boolean modification, int idDonneeSelectionnee){
		view.Configuration config = new view.Configuration(false,0, idDonneeSelectionnee);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	public static void configurationAppliAjout (boolean modification, int idDonneeSelectionnee){
		view.Configuration config = new view.Configuration(true,0, idDonneeSelectionnee);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	public static void configurationUtilisateur (boolean actifUtilisateur, int idDonneSelectionnee){
		view.Configuration config = new view.Configuration(true,1, idDonneSelectionnee);
		view.mainJFrame.setContainerPanel(config);
		
	}
	public static void configurationDGModif (boolean modification, int idDonneeSelectionnee){
		view.Configuration config = new view.Configuration(false,2, idDonneeSelectionnee);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	public static void configurationDGAjout (boolean modification, int idDonneeSelectionnee){
		view.Configuration config = new view.Configuration(true,2, idDonneeSelectionnee);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	public static void configurationDirectionModif (boolean modification, int idDonneeSelectionnee){
		view.Configuration config = new view.Configuration(false,3, idDonneeSelectionnee);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	public static void configurationDirectionAjout (boolean modification, int idDonneeSelectionnee){
		view.Configuration config = new view.Configuration(true,3, idDonneeSelectionnee);
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	
	public static void accueil (){
		view.accueil acc = new view.accueil();
		view.mainJFrame.setContainerPanel(acc);
		
	}
	
	
}
