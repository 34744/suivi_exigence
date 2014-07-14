package model;
import java.sql.*;

import javax.swing.JOptionPane;

public class AccesDB {
	
	private static Connection connexion;
	
	public static Connection GetInstance(){
		//Si la connection n'est pas faite, affiche fen�tre de connection
		
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
			JOptionPane.showMessageDialog(null, sqlE, "Erreur de fermeture de la base de donnees", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public static void accessDB(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException classNotFound) {
			JOptionPane.showMessageDialog(null, classNotFound, "Erreur de driver", JOptionPane.ERROR_MESSAGE);
		}
		
		try{
			//connexion = DriverManager.getConnection("jdbc:mysql://localhost/evolappli", "root","");
			connexion = DriverManager.getConnection("jdbc:mysql://srvmysql.intra.spw.test.wallonie.be/evoappli", "evoappli","Mu6fExU48e4UA7Gr");
			GestionLog.connexionDB();
		} catch(SQLException sqlE){
			GestionLog.connexionDBImpossible();
		}
		
	}
}
