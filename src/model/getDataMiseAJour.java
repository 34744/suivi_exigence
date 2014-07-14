package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

public class getDataMiseAJour {

	public static Vector<miseAJourArbre> getMiseAJourVecteurArbre(
			String nomApplication) {
		
			Vector<model.miseAJourArbre> v = new Vector<model.miseAJourArbre>();
			
			try{
				Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
				
				String requeteSQL = "SELECT * FROM miseajour, application WHERE miseajour.fkApplication = application.idApplication AND application.nomApplication = '" + nomApplication +"'";
				ResultSet donnees = stat.executeQuery(requeteSQL);
				ResultSetMetaData metadata = donnees.getMetaData();
				
				while(donnees.next()){
					
					v.addElement(new miseAJourArbre(donnees.getInt("idMiseAJour"),
							donnees.getString("numMAJ"),
							donnees.getDate("dateProposition"),
							donnees.getDate("dateValidation"),
							donnees.getDate("dateNotification"),
							donnees.getString("numCallBmc"),
							donnees.getDate("dateMiseProd"),
							donnees.getInt("fkApplication"),
							donnees.getString("nomApplication")));
				}

			} catch (SQLException e){
				JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			return v;
	}

	public static Vector<miseAJourArbre> getMiseAJourArbre() {
		// TODO Auto-generated method stub
		Vector<model.miseAJourArbre> v = new Vector<model.miseAJourArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM miseajour, application WHERE miseajour.fkApplication = application.idApplication";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new miseAJourArbre(donnees.getInt("idMiseAJour"),
						donnees.getString("numMAJ"),
						donnees.getDate("dateProposition"),
						donnees.getDate("dateValidation"),
						donnees.getDate("dateNotification"),
						donnees.getString("numCallBmc"),
						donnees.getDate("dateMiseProd"),
						donnees.getInt("fkApplication"),
						donnees.getString("nomApplication")));
			}

		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return v;
	}
	
	
	public static Vector<miseAJourArbre> getMiseAJourAttenteArbre() {
		// TODO Auto-generated method stub
		Vector<model.miseAJourArbre> v = new Vector<model.miseAJourArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM miseajour, application WHERE miseajour.fkApplication = application.idApplication AND miseajour.dateMiseProd='2099-12-31'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new miseAJourArbre(donnees.getInt("idMiseAJour"),
						donnees.getString("numMAJ"),
						donnees.getDate("dateProposition"),
						donnees.getDate("dateValidation"),
						donnees.getDate("dateNotification"),
						donnees.getString("numCallBmc"),
						donnees.getDate("dateMiseProd"),
						donnees.getInt("fkApplication"),
						donnees.getString("nomApplication")));
			}

		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return v;
	}
	
public static miseAJourArbre getmiseAJourPointArbre(int idMiseAJour) {
		
		model.miseAJourArbre v = new model.miseAJourArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT COUNT(*) FROM pointmaj WHERE fkMiseAJour ='" + idMiseAJour +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setNombrePoint(donnees.getInt(1));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return v;
	}
public static miseAJourArbre getmiseAJourPointValideArbre(int idMiseAJour) {
	
	model.miseAJourArbre v = new model.miseAJourArbre();
	
	try{
		Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
		
		String requeteSQL = "SELECT COUNT(*) FROM pointmaj,miseajour WHERE testFinalise=1 AND dateMiseProd='2099-12-31' AND fkMiseAJour=idMiseAJour AND fkMiseAJour ='" + idMiseAJour +"'";
		ResultSet donnees = stat.executeQuery(requeteSQL);
		ResultSetMetaData metadata = donnees.getMetaData();
		
		while(donnees.next()){
			v.setNombrePointValide(donnees.getInt(1));
		}
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	return v;
}

public static miseAJourArbre getmiseAJourArbre(String numMAJ) {
model.miseAJourArbre v = new model.miseAJourArbre();
	
	try{
		Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
		
		String requeteSQL = "SELECT * FROM miseajour WHERE numMAJ ='" + numMAJ +"'";
		ResultSet donnees = stat.executeQuery(requeteSQL);
		ResultSetMetaData metadata = donnees.getMetaData();
		
		while(donnees.next()){
			v.setIdMiseAJour(donnees.getInt("idMiseAJour"));
			v.setNumMAJ(donnees.getString("numMAJ"));
			v.setDateProposition(donnees.getDate("dateProposition"));
			v.setDateValidation(donnees.getDate("dateValidation"));
			v.setDateNotification(donnees.getDate("dateNotification"));
			v.setNumCallBmc(donnees.getString("numCallBMC"));
			v.setDateProposition(donnees.getDate("dateMiseProd"));
			v.setFkApplication(donnees.getInt("fkApplication"));
		}
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	return v;
}
public static miseAJourArbre getmiseAJourArbre(int idMAJ) {
model.miseAJourArbre v = new model.miseAJourArbre();
	
	try{
		Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
		
		String requeteSQL = "SELECT * FROM miseajour, application WHERE idApplication = fkApplication AND idMiseAJour ='" + idMAJ +"'";
		ResultSet donnees = stat.executeQuery(requeteSQL);
		ResultSetMetaData metadata = donnees.getMetaData();
		
		while(donnees.next()){
			v.setIdMiseAJour(donnees.getInt("idMiseAJour"));
			v.setNumMAJ(donnees.getString("numMAJ"));
			v.setDateProposition(donnees.getDate("dateProposition"));
			v.setDateValidation(donnees.getDate("dateValidation"));
			v.setDateNotification(donnees.getDate("dateNotification"));
			v.setNumCallBmc(donnees.getString("numCallBMC"));
			v.setDateMiseProd(donnees.getDate("dateMiseProd"));
			v.setFkApplication(donnees.getInt("fkApplication"));
			v.setNomApplication(donnees.getString("nomApplication"));
		}
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
	System.exit(0);
	}
	return v;
	}

public static Vector<miseAJourArbre> getMiseAJourVecteurArbre(int idApplication) {
	Vector<model.miseAJourArbre> v = new Vector<model.miseAJourArbre>();
	
	try{
		Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
		
		String requeteSQL = "SELECT * FROM miseajour, application WHERE miseajour.fkApplication= application.idApplication AND miseajour.fkApplication='" + idApplication +"'";
		ResultSet donnees = stat.executeQuery(requeteSQL);
		ResultSetMetaData metadata = donnees.getMetaData();
		while (donnees.next()){

			v.addElement(new miseAJourArbre(donnees.getInt("idMiseAJour"),
					donnees.getString("numMAJ"),
					donnees.getDate("dateProposition"),
					donnees.getDate("dateValidation"),
					donnees.getDate("dateNotification"),
					donnees.getString("numCallBmc"),
					donnees.getDate("dateMiseProd"),
					donnees.getInt("fkApplication")));
		}
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	return v;
	}
}
