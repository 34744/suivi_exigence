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
			
			String requeteSQL = "SELECT * FROM pointmaj, miseajour,origine WHERE origine.idOrigine=pointmaj.fkOrigine AND miseajour.idMiseAjour = pointmaj.fkMiseAJour AND pointmaj.fkMiseAJour='" + idMAJ +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new pointMajArbre(donnees.getInt("idPoint"),
						donnees.getString("nomPoint"),
						donnees.getString("descriptionPoint"),
						donnees.getString("solutionPoint"),
						donnees.getInt("fkMiseAJour"),
						donnees.getInt("fkOrigine"),
						donnees.getString("nomOrigine"),
						donnees.getString("originePrecision"),
						donnees.getInt("testFinalise")));
			}

		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<origineArbre> getOrigineArbre() {
		// TODO Auto-generated method stub
		Vector<model.origineArbre> v = new Vector<model.origineArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM origine ORDER BY nomOrigine";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new origineArbre(donnees.getInt("idOrigine"),
						donnees.getString("nomOrigine")));
			}

		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	public static origineArbre getOrigineArbre(String nomOrigine) {
		model.origineArbre v = new model.origineArbre();
			
			try{
				Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
				
				String requeteSQL = "SELECT * FROM origine WHERE nomOrigine ='" + nomOrigine +"'";
				ResultSet donnees = stat.executeQuery(requeteSQL);
				ResultSetMetaData metadata = donnees.getMetaData();
				
				while(donnees.next()){
					v.setIdOrigine(donnees.getInt("idOrigine"));
					v.setNomOrigine(donnees.getString("nomOrigine"));
					
				}
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
			}
			return v;
		}

}
