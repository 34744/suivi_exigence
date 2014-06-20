package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class majDataSousFonctionnalite {
	public static void majSousFonctionnalite(model.sousFonctionnalite sousFonctionnalite) {
		// TODO Auto-generated method stub
			try{
				Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
										 
				String instructionSQL="UPDATE sousfonctionnalite SET dateFinSFRecord= CURDATE() WHERE idSousFonct ='"
						
						+ sousFonctionnalite.getIdSousFonct()+"' ";
				
				int nbIns = stat.executeUpdate(instructionSQL);

				
			}catch (SQLException aDO){
				JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
			}
		
	}
}
