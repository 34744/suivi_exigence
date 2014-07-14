package model;

import java.sql.SQLException;
import java.sql.Statement;

import controller.ControllerDBConfiguration;

import javax.swing.JOptionPane;

public class majDataConfiguration {
 
	public static void MajApplication (application application){
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE application SET nomApplication='"
			+application.getNomApplication()+"', visibiliteApplication='"
			+application.getVisibiliteApplication()+ "' WHERE idApplication='" 
			+ application.getIdApplication()+"' ";
			int nbIns = stat.executeUpdate(instructionSQL);
			
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			}
	}
	
	public static void MajUtilisateur(utilisateur utilisateur){
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE utilisateur SET nomUtilisateur='"
			+utilisateur.getNomUtilisateur()+"', prenomUtilisateur='"
			+utilisateur.getPrenomUtilisateur()+"', numUlis='"
			+utilisateur.getNumUlis()+"', mailUtilisateur='"
			+utilisateur.getMailUtilisateur()+"', utilisateurActif='"
			+utilisateur.getActifUtilisateur()+"', directionUtilisateur='"
			+utilisateur.getUtilisateurDirection()
			+ "' WHERE numUlis='" 
			+ utilisateur.getNumUlis()+"' ";
			int nbIns = stat.executeUpdate(instructionSQL);
			
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			}
	}
	
	public static void MajCompoCellule(compoCellule cellule) {
        try {
                Statement stat = controller.ControllerDBConfiguration.connectionDB()
                                .createStatement();
                String instructionSQL="UPDATE compocellule SET dateDebutCellule='"
            			+cellule.getDateDebutCellule()+"', dateFinCellule='"
            			+cellule.getDateFinCellule()
            			+ "' WHERE idCellule='" 
            			+ cellule.getFkCellule()+"' AND idUtilisateur='"
            			+cellule.getFkUtilisateur() +"' ";
                
                int nbIns = stat.executeUpdate(instructionSQL);
               

        } catch (SQLException aDO) {
        	JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
    		System.exit(0);
    		}
	}
	
	public static void MajDirectionGenerale (directionGenerale directionGenerale){
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE directiongeneral SET nomDG='"
			+directionGenerale.getNomDirectionGenerale()+"', visibiliteDG='"
			+directionGenerale.getVisibiliteDg()+ "' WHERE idDG='" 
			+ directionGenerale.getIdDirectionGenerale()+"' ";
			int nbIns = stat.executeUpdate(instructionSQL);
			
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			}
	}

	public static void MajDirection(direction direction) {
		// TODO Auto-generated method stub
		try{
		Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
		 
		String instructionSQL="UPDATE direction SET nomDirection='"
		+direction.getNomDirection()+"', idDG='"
		+direction.getIdDG()+"', visibiliteDirection='"
		+direction.getVisibiliteDirection()+ "' WHERE idDirection='" 
		+ direction.getIdDirection()+"' ";
		int nbIns = stat.executeUpdate(instructionSQL);
		System.out.println("test maj direction");
	}catch (SQLException aDO){
		JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
		}
	}
}
