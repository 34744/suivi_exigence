package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class addDataMAJ {

	public static void addNewMiseAJour(model.miseAJour miseAJour) {
		// TODO Auto-generated method stub

		try {
            Statement stat = controller.ControllerDBConfiguration.connectionDB()
                            .createStatement();
            String instructionSQL = "INSERT INTO miseajour (idMiseAJour, numMAJ, dateProposition, dateValidation, dateNotification, numCallBmc, dateMiseProd, fkApplication)"
                            + " VALUES (NULL, '" 
                            + miseAJour.getNumMAJ()
                            + "','"
                            + miseAJour.getDateProposition()
                            + "','"
                            + miseAJour.getDateValidation()
                            + "','"
                            + miseAJour.getDateNotification()
                            + "','"
                            + miseAJour.getNumCallBmc()
                            + "','"
                            + miseAJour.getDateMiseProd()
                            + "','"
                            + miseAJour.getFkApplication()
                            + "')";
            int nbIns = stat.executeUpdate(instructionSQL);
           /* JOptionPane.showMessageDialog(null,
                            "L'enregistrement a bien été effectué", "Enregistrement",
                            JOptionPane.INFORMATION_MESSAGE);*/

		} catch (SQLException aDO) {
            JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                            JOptionPane.ERROR_MESSAGE);
		}
	}
}
