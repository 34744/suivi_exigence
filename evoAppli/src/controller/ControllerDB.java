package controller;

import java.sql.Connection;
import java.util.StringTokenizer;
import java.util.Vector;

import model.getData;
import model.utilisateur;

	public class ControllerDB {
		public static Connection connectionDB() {
			return model.AccesDB.GetInstance();
			}
		
		public static void fermetureDB(){
			model.AccesDB.closeDB();
			}
		
		public static utilisateur getUser(String nom) {
			return getData.getUser(nom);        }
	}
	

