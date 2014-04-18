package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.exigenceFonctionnelle;
import model.sousFonctionnalite;

public class addDataExigenceFonctionnelle {
public static void addNewExigenceFonctionnelle(exigenceFonctionnelle exigenceFonctionnelle) {
		
		try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO exigenceFonctionnelle (idExigence, nomExigence, descriptionExigence, raisonExigence, prioriteExigence,  dateDebutExi, dateFinExi, numExi, codeExigence, dateDebutEFRecord, dateFinEFRecord, fkSFonct)"
                                + " VALUES (NULL, '" 
                                + exigenceFonctionnelle.getNomExigence() 
                                + "','"
                                + exigenceFonctionnelle.getDescriptionExigence()
                                + "','"
                                + exigenceFonctionnelle.getRaisonExigence()
                                + "','"
                                + exigenceFonctionnelle.getPrioriteExigence() 
                                + "','"
                                + exigenceFonctionnelle.getDateDebutExi()
                                + "','"
                                + exigenceFonctionnelle.getDateFinExi()
                                + "','"
                                + exigenceFonctionnelle.getNumExi()
                                + "','"
                                + exigenceFonctionnelle.getCodeExigence()
                                + "','"
                                + exigenceFonctionnelle.getDateDebutEFRecord()
                                + "','"
                                + exigenceFonctionnelle.getDateFinEFRecord()
                                + "','"
                                + exigenceFonctionnelle.getFkSFonct()
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
	public static void addCodeExigenceFonctionnelle(exigenceFonctionnelle exigenceFonctionnelle) {
	// TODO Auto-generated method stub
	try {
        Statement stat = controller.ControllerDBConfiguration.connectionDB()
                        .createStatement();
        String instructionSQL="UPDATE exigenceFonctionnelle SET codeExigence='"
    			+exigenceFonctionnelle.getCodeExigence()
    			+ "' WHERE idExigence='" 
    			+ exigenceFonctionnelle.getIdExigence()+"' ";
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
