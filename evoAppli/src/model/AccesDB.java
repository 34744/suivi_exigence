package model;
import java.sql.*;

import javax.swing.JOptionPane;

public class AccesDB {
	
	private static Connection connexion;
	
	public static Connection GetInstance(){
		//Si la connection n'est pas faite, affiche fenêtre de connection
		
		if(connexion==null){
			accessDB();
		}
		return connexion;
	}

	public static Connection getConnection(){
		return connexion;
	}

	public static void closeDB(){
		try{
			GetInstance().close();
		}catch (SQLException sqlE){
			JOptionPane.showMessageDialog(null, sqlE, "Erreur de fermeture de la base de données", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void accessDB(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException classNotFound) {
			JOptionPane.showMessageDialog(null, classNotFound, "Erreur de driver", JOptionPane.ERROR_MESSAGE);
		}
		
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/evoappli", "root","");
		} catch(SQLException sqlE){
			JOptionPane.showMessageDialog(null,sqlE,"Erreur de connexion à la DB", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
