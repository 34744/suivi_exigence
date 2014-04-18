package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class addDataCritereSucces {

	public static void addNewCritereSucces(model.critereSucces critereSucces) {
		// TODO Auto-generated method stub
		try {
            Statement stat = controller.ControllerDBConfiguration.connectionDB()
                            .createStatement();
            String instructionSQL = "INSERT INTO critereSucces (idCritere, nomCritere, dateDebutCritere, dateFinCritere, numCritere, codeCritere, dateDebutCSRecord, dateFinCSRecord, fkExigence)"
                            + " VALUES (NULL, '" 
                            + critereSucces.getNomCritere() 
                            + "','"
                            + critereSucces.getDateDebutCritere()
                            + "','"
                            + critereSucces.getDateFinCritere()
                            + "','"
                            + critereSucces.getNumCritere()
                            + "','"
                            + critereSucces.getCodeCritere()
                            + "','"
                            + critereSucces.getDateDebutCSRecord()
                            + "','"
                            + critereSucces.getDateFinCSRecord()
                            + "','"
                            + critereSucces.getFkExigence()
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
