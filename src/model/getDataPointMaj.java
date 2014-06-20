package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class getDataPointMaj {

	public static Vector<pointMajArbre> getPointMajArbre(int idMAJ) {
		Vector<model.pointMajArbre> v = new Vector<model.pointMajArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM pointMaj, miseAJour WHERE miseajour.idMiseAjour = pointMaj.fkMiseAJour AND pointMaj.fkMiseAJour='" + idMAJ +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new pointMajArbre(donnees.getInt("idPoint"),
						donnees.getString("nomPoint"),
						donnees.getString("descriptionPoint"),
						donnees.getString("solutionPoint"),
						donnees.getInt("fkMiseAJour"),
						donnees.getInt("fkOrigine"),
						donnees.getString("originePrecision"),
						donnees.getInt("fkRisque"),
						donnees.getBoolean("testFinalise")));
			}

		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	

}
