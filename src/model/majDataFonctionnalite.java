package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class majDataFonctionnalite {

	public static void majFonctionnalite(model.fonctionnalite fonctionnalite) {
		// TODO Auto-generated method stub
			try{
				Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
										 
				String instructionSQL="UPDATE fonctionnalite SET nomFonctionnalite='"
						+fonctionnalite.getNomFonctionnalite()+"', descriptionFonctionnalite='"
						+fonctionnalite.getDescriptionFonctionnalite()+"', dateDebutFonct='"
						+fonctionnalite.getDateDebutFonct()+"', dateFinFonct='"
						+fonctionnalite.getDateFinFonct()+"', numFonct='"
						+fonctionnalite.getNumFonct()
						+ "' WHERE idFonctionnalite='" 
						+fonctionnalite.getIdFonctionnalite()+"' ";
				System.out.println("foncttrze"+fonctionnalite.getIdFonctionnalite());
				int nbIns = stat.executeUpdate(instructionSQL);

				
			}catch (SQLException aDO){
				JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
			}
		
	}

}
