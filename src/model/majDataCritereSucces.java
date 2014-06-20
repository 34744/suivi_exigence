package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class majDataCritereSucces {

	public static void majCritere(model.critereSucces critereSucces) {
		// TODO Auto-generated method stub
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE criteresucces SET dateFinCSRecord= CURDATE() WHERE idCritere ='"
					
					+ critereSucces.getIdCritere()+"' ";
			
			int nbIns = stat.executeUpdate(instructionSQL);

			
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
		}
	}

}
