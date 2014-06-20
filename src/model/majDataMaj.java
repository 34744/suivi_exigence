package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class majDataMaj {
	public static void updateMaj(model.miseAJour miseajour) {
		// TODO Auto-generated method stub
			try{
				Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
										 
				String instructionSQL="UPDATE miseajour SET numMAJ='"
						+miseajour.getNumMAJ()+"', dateProposition='"
						+miseajour.getDateProposition()+"', dateValidation='"
						+miseajour.getDateValidation()+"', dateNotification='"
						+miseajour.getDateNotification()+"', numCallBmc='"
						+miseajour.getNumCallBmc()+"',dateMiseProd='"
						+miseajour.getDateMiseProd()
						+ "' WHERE idMiseAJour='" 
						+miseajour.getIdMiseAJour()+"' ";
		
				int nbIns = stat.executeUpdate(instructionSQL);

				
			}catch (SQLException aDO){
				JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
			}
		
	}

}
