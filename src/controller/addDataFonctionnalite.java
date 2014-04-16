package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.application;
import model.fonctionnalite;

public class addDataFonctionnalite {
	public static void addFonctionnalite(fonctionnalite fonctionnalite) {
        try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO fonctionnalite (idFonctionnalite, nomFonctionnalite, descriptionFonctionnalite, dateDebutFonct, dateFinFonct, numFonct, fkAppli)"
                                + " VALUES (NULL, '" 
                                + fonctionnalite.getNomFonctionnalite() 
                                + "','"
                                + fonctionnalite.getDescriptionFonctionnalite()
                                + "','"
                                + fonctionnalite.getDateDebutFonct()
                                + "','"
                                + fonctionnalite.getDateFinFonct()
                                + "','"
                                + fonctionnalite.getNumFonct()
                                + "','"
                                + fonctionnalite.getFkAppli()
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