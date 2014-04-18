package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class majDataExigence {

	public static void majExigence(model.exigenceFonctionnelle exigenceFonctionnelle) {
		// TODO Auto-generated method stub
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE exigenceFonctionnelle SET dateFinEFRecord= CURDATE() WHERE idExigence ='"
					
					+ exigenceFonctionnelle.getIdExigence()+"' ";
			
			int nbIns = stat.executeUpdate(instructionSQL);

			
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
		}
	
	}

}
