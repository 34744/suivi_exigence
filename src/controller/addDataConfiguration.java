package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.application;
import model.compoCellule;
import model.utilisateur;

public class addDataConfiguration {
	public static void addApplication(application application) {
        try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO application (idApplication, nomApplication, visibiliteApplication)"
                                + " VALUES (NULL, '" 
                                + application.getNomApplication() 
                                + "','"
                                + application.getVisibiliteApplication()
                                + "')";
                int nbIns = stat.executeUpdate(instructionSQL);
               /* JOptionPane.showMessageDialog(null,
                                "L'enregistrement a bien �t� effectu�", "Enregistrement",
                                JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                                JOptionPane.ERROR_MESSAGE);
        }
        
}
	public static void addDirectionGenerale(model.directionGenerale directionGenerale) {
        try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO directiongeneral (idDG, nomDG, visibiliteDG)"
                                + " VALUES (NULL, '" 
                                + directionGenerale.getNomDirectionGenerale() 
                                + "','"
                                + directionGenerale.getVisibiliteDg()
                                + "')";
                int nbIns = stat.executeUpdate(instructionSQL);
               /* JOptionPane.showMessageDialog(null,
                                "L'enregistrement a bien �t� effectu�", "Enregistrement",
                                JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                                JOptionPane.ERROR_MESSAGE);
        }
        
}
	
	public static void addDirection(model.direction direction) {
        try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO direction (idDirection, nomDirection,idDG, visibiliteDirection)"
                                + " VALUES (NULL, '" 
                                + direction.getNomDirection() 
                                + "','"
                                + direction.getIdDG() 
                                + "','"
                                + direction.getVisibiliteDirection()
                                + "')";
                int nbIns = stat.executeUpdate(instructionSQL);
               /* JOptionPane.showMessageDialog(null,
                                "L'enregistrement a bien �t� effectu�", "Enregistrement",
                                JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                                JOptionPane.ERROR_MESSAGE);
        }
        
}
	public static void addUtilisateur(utilisateur utilisateur) {
        try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO utilisateur (idUtilisateur, nomUtilisateur, prenomUtilisateur, numUlis, mailUtilisateur, utilisateurActif, directionUtilisateur)"
                                + " VALUES (NULL, '" 
                                + utilisateur.getNomUtilisateur()
                                + "','"
                                + utilisateur.getPrenomUtilisateur() 
                                + "','"
                                + utilisateur.getNumUlis()
                                + "','"
                                + utilisateur.getMailUtilisateur() 
                                + "','"
                                + utilisateur.getActifUtilisateur()
                                + "','"
                                + utilisateur.getUtilisateurDirection()
                                + "')";
                int nbIns = stat.executeUpdate(instructionSQL);
               /* JOptionPane.showMessageDialog(null,
                                "L'enregistrement a bien �t� effectu�", "Enregistrement",
                                JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null,"L'utilisateur que vous d�sirez ajouter est d�j� repris dans la base de donn�es","L'utilisateur existe d�j�", JOptionPane.ERROR_MESSAGE);
        }
        
}
	public static void addCompoCellule(compoCellule cellule) {
        try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO compocellule (idCellule,idUtilisateur, dateDebutCellule, dateFinCellule)"
                                + " VALUES ('" 
                                + cellule.getFkCellule()
                                + "','"
                                + cellule.getFkUtilisateur() 
                                + "','"
                                + cellule.getDateDebutCellule()
                                + "','"
                                + cellule.getDateFinCellule()
                                + "')";
                int nbIns = stat.executeUpdate(instructionSQL);
               /* JOptionPane.showMessageDialog(null,
                                "L'enregistrement a bien �t� effectu�", "Enregistrement",
                                JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                                JOptionPane.ERROR_MESSAGE);
        }
	}
}
