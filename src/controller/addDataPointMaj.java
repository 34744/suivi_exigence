package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class addDataPointMaj {
	public static void addNewPoint(model.pointMaj pointMaj) {
		// TODO Auto-generated method stub

		try {
            Statement stat = controller.ControllerDBConfiguration.connectionDB()
                            .createStatement();
            String instructionSQL = "INSERT INTO pointmaj (idPoint, nomPoint, descriptionPoint, solutionPoint,fkMiseAJour, fkOrigine, originePrecision, testFinalise)"
                            + " VALUES (NULL, '" 
                            + pointMaj.getNomPoint()
                            + "','"
                            + pointMaj.getDescriptionPoint()
                            + "','"
                            + pointMaj.getSolutionPoint()
                            + "','"
                            + pointMaj.getFkMiseAJour()
                            + "','"
                            + pointMaj.getFkOrigine()
                            + "','"
                            + pointMaj.getOriginePrecision()
                            + "','"
                            + pointMaj.getTestFinalise()
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
