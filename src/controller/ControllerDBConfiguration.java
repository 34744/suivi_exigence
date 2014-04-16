package controller;

import java.sql.Connection;
import java.util.StringTokenizer;
import java.util.Vector;

import view.Application;
import model.application;
import model.applicationArbre;
import model.cellule;
import model.compoCellule;
import model.compoCelluleArbre;
import model.direction;
import model.directionArbre;
import model.directionGenerale;
import model.directionGeneraleArbre;
import model.getDataConfiguration;
import model.majDataConfiguration;
import model.utilisateur;
import model.utilisateurArbre;

	public class ControllerDBConfiguration {
		public static Connection connectionDB() {
			return model.AccesDB.GetInstance();
			}
		
		public static void fermetureDB(){
			model.AccesDB.closeDB();
			}
		
		public static utilisateur getUser(String nom) {
			return getDataConfiguration.getUser(nom);        }
		
		public static Vector<application> getApplication(){
			return model.getDataConfiguration.getApplication();
		}
		
		public static Vector<applicationArbre> getApplicationArbre(){
			return model.getDataConfiguration.getApplicationArbre();
		}
		
		public static applicationArbre getApplicationArbre(String application){
			return model.getDataConfiguration.getApplicationArbre(application);
		}
		
		public static void ModifApplication(application application){
			majDataConfiguration.MajApplication(application);
		}
		
		public static Vector<utilisateur> getUtilisateur(){
			return model.getDataConfiguration.getUtilisateur();
		}
		
		public static Vector<utilisateurArbre> getUtilisateurArbre(){
			return model.getDataConfiguration.getUtilisateurArbre();
		}
		
		public static utilisateurArbre getUtilisateurArbre(String numUlis){
			return model.getDataConfiguration.getUtilisateurArbre(numUlis);
		}
		
		public static Vector<utilisateurArbre> getUtilisateurActifArbre(){
			return model.getDataConfiguration.getUtilisateurActifArbre();
		}
		
		public static Vector<direction> getDirectionUtilisateur(){
			return model.getDataConfiguration.getDirection();

		}
		
		public static Vector<directionArbre> getDirectionUtilisateurArbre(){
			return model.getDataConfiguration.getDirectionArbre();
		}
		
		public static Vector<directionGenerale> getDirectionGenerale(){
			return model.getDataConfiguration.getDirectionGenerale();

		}
		
		public static Vector<directionGeneraleArbre> getDirectionGeneraleArbre(){
			return model.getDataConfiguration.getDirectionGeneraleArbre();
		}
		
		public static void ModifDg(directionGenerale directionGenerale){
			majDataConfiguration.MajDirectionGenerale(directionGenerale);
		}
		
		public static void ModifDirection(direction direction){
			majDataConfiguration.MajDirection(direction);
		}
		
		public static Vector<compoCellule> getCompoCellule(){
			return model.getDataConfiguration.getCompoCellule();

		}
		
		public static Vector<cellule> getCellule(){
			return model.getDataConfiguration.getCellule();

		}
		
		public static Vector<cellule> getCellule(String nomCellule){
			return model.getDataConfiguration.getCellule(nomCellule);

		}
		
		public static cellule getCelluleSele(String nomCellule){
			return model.getDataConfiguration.getCelluleSelect(nomCellule);
		}
		
		public static Vector<cellule> getCelluleNonUtilisee(int idUtilisateur){
			return model.getDataConfiguration.getCelluleNonActive(idUtilisateur);

		}
		
		
		public static compoCelluleArbre getCompoCelluleArbre(String numUlis){
			return model.getDataConfiguration.getCompoCelluleArbre(numUlis);
		}
		
		public static Vector<compoCelluleArbre> getCompoCelluleArbre(){
			return model.getDataConfiguration.getCompoCelluleArbre();

		}

		public static Vector<compoCelluleArbre> getCompoCelluleVecteurArbre(String numUlis) {
			return model.getDataConfiguration.getCompoCelluleVecteurArbre(numUlis);
		}

		public static directionGeneraleArbre getDirectionGeneraleArbre(String directionGenerale) {
			return model.getDataConfiguration.getDirectionGeneraleArbre(directionGenerale);
		}
		
		public static directionArbre getDirectionUtilisateurArbre(String direction) {
			return model.getDataConfiguration.getDirectionArbre(direction);
		}
	}
	

