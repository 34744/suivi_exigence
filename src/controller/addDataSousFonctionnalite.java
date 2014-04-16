package controller;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.fonctionnalite;
import model.sousFonctionnalite;

public class addDataSousFonctionnalite {
	
	public static void addNewSousFonctionnalite(sousFonctionnalite sousFonctionnalite) {
		
		try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO sousFonctionnalite (idSousFonct, nomSFonct,  dateDebutSFonct, dateFinSFonct, numSFonct, codeSFonct, dateDebutSFRecord, dateFinSFRecord, fkFonct)"
                                + " VALUES (NULL, '" 
                                + sousFonctionnalite.getNomSFonct() 
                                + "','"
                                + sousFonctionnalite.getDateDebutSFonct()
                                + "','"
                                + sousFonctionnalite.getDateFinSFonct()
                                + "','"
                                + sousFonctionnalite.getNumSFonct()
                                + "','"
                                + sousFonctionnalite.getCodeSFonct()
                                + "','"
                                + sousFonctionnalite.getDateDebutSFRecord()
                                + "','"
                                + sousFonctionnalite.getDateFinSFRecord()
                                + "','"
                                + sousFonctionnalite.getFkFonct()
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

	
	public static void addCodeSousFonctionnalite(
			model.sousFonctionnalite sousFonctionnalite) {
		// TODO Auto-generated method stub
		try {
            Statement stat = controller.ControllerDBConfiguration.connectionDB()
                            .createStatement();
            String instructionSQL="UPDATE sousFonctionnalite SET codeSFonct='"
        			+sousFonctionnalite.getCodeSFonct()
        			+ "' WHERE idSousFonct='" 
        			+ sousFonctionnalite.getIdSousFonct()+"' ";
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
