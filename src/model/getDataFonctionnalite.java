package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class getDataFonctionnalite {
	public static Vector<fonctionnalite> getFonctionnalite(){
		Vector<model.fonctionnalite> v = new Vector<model.fonctionnalite>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite ORDER BY nomFonctionnalite";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){

				v.addElement(new fonctionnalite(donnees.getInt("idFonctionnalite"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("descriptionFonctionnalite"),
						donnees.getString("dateDebutFonct"),
						donnees.getString("dateFinFonct"),
						donnees.getString("numFonct"),
						donnees.getInt("fkAppli")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<fonctionnalite> getFonctionnaliteAppli(String nomAppli){
		Vector<model.fonctionnalite> v = new Vector<model.fonctionnalite>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite, application WHERE fonctionnalite.fkAppli = application.idApplication "
							+ "AND nomApplication = '" + nomAppli +"'" ;
							
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){

				v.addElement(new fonctionnalite(donnees.getInt("idFonctionnalite"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("descriptionFonctionnalite"),
						donnees.getString("dateDebutFonct"),
						donnees.getString("dateFinFonct"),
						donnees.getString("numFonct"),
						donnees.getInt("fkAppli")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<fonctionnaliteArbre> getFonctionnaliteArbre(){
		Vector<model.fonctionnaliteArbre> v = new Vector<model.fonctionnaliteArbre>();

		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite ORDER BY nomFonctionnalite";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){

				v.addElement(new fonctionnaliteArbre(donnees.getInt("idFonctionnalite"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("descriptionFonctionnalite"),
						donnees.getDate("dateDebutFonct"),
						donnees.getDate("dateFinFonct"),
						donnees.getString("numFonct"),
						donnees.getInt("fkAppli"),
						donnees.getString("nomAppli")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static fonctionnaliteArbre getFonctionnaliteArbre(int idFonctionnalite){
		model.fonctionnaliteArbre v = new model.fonctionnaliteArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite WHERE idFonctionnalite = '" + idFonctionnalite +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdFonctionnalite(donnees.getInt("IdFonctionnalite"));
				v.setNomFonctionnalite(donnees.getString("nomFonctionnalite"));
				v.setDescriptionFonctionnalite(donnees.getString("descriptionFonctionnalite"));
				v.setDateDebutFonct(donnees.getDate("dateDebutFonct"));
				v.setDateFinFonct(donnees.getDate("dateFinFonct"));
				v.setNumFonct(donnees.getString("numFonct"));
				v.setFkAppli(donnees.getInt("fkAppli"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	public static fonctionnaliteArbre getFonctionnaliteArbre(String nomFonctionnalite){
		model.fonctionnaliteArbre v = new model.fonctionnaliteArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite WHERE nomFonctionnalite = '" + nomFonctionnalite +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdFonctionnalite(donnees.getInt("IdFonctionnalite"));
				v.setNomFonctionnalite(donnees.getString("nomFonctionnalite"));
				v.setDescriptionFonctionnalite(donnees.getString("descriptionFonctionnalite"));
				v.setDateDebutFonct(donnees.getDate("dateDebutFonct"));
				v.setDateFinFonct(donnees.getDate("dateFinFonct"));
				v.setNumFonct(donnees.getString("numFonct"));
				v.setFkAppli(donnees.getInt("fkAppli"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	public static Vector<fonctionnaliteArbre> getFonctionnaliteVecteurArbre(int idAppli){
		Vector<model.fonctionnaliteArbre> v = new Vector<model.fonctionnaliteArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite, application WHERE fonctionnalite.fkAppli = application.idApplication AND fkAppli = '" + idAppli +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new fonctionnaliteArbre(donnees.getInt("idFonctionnalite"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("descriptionFonctionnalite"),
						donnees.getDate("dateDebutFonct"),
						donnees.getDate("dateFinFonct"),
						donnees.getString("numFonct"),
						donnees.getInt("fkAppli"),
						donnees.getString("nomApplication")));
			}
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<fonctionnaliteArbre> getFonctionnaliteVecteurArbre(String nomAppli){
		Vector<model.fonctionnaliteArbre> v = new Vector<model.fonctionnaliteArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite, application WHERE fonctionnalite.fkAppli = application.idApplication AND nomApplication = '" + nomAppli +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new fonctionnaliteArbre(donnees.getInt("idFonctionnalite"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("descriptionFonctionnalite"),
						donnees.getDate("dateDebutFonct"),
						donnees.getDate("dateFinFonct"),
						donnees.getString("numFonct"),
						donnees.getInt("fkAppli"),
						donnees.getString("nomApplication")));
			}
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	public static Vector<fonctionnaliteArbre> getNumFonctionnaliteVecteurArbre(int numFonctionnalite){
		Vector<model.fonctionnaliteArbre> v = new Vector<model.fonctionnaliteArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite, application WHERE fonctionnalite.fkAppli = application.idApplication AND numFonct = '" + numFonctionnalite +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new fonctionnaliteArbre(donnees.getInt("idFonctionnalite"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("descriptionFonctionnalite"),
						donnees.getDate("dateDebutFonct"),
						donnees.getDate("dateFinFonct"),
						donnees.getString("numFonct"),
						donnees.getInt("fkAppli"),
						donnees.getString("nomApplication")));
			}
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	public static Vector<fonctionnaliteArbre> getNomFonctionnaliteVecteurArbre(String nomFonctionnalite){
		Vector<model.fonctionnaliteArbre> v = new Vector<model.fonctionnaliteArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite, application WHERE fonctionnalite.fkAppli = application.idApplication AND nomFonctionnalite = '" + nomFonctionnalite +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new fonctionnaliteArbre(donnees.getInt("idFonctionnalite"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("descriptionFonctionnalite"),
						donnees.getDate("dateDebutFonct"),
						donnees.getDate("dateFinFonct"),
						donnees.getString("numFonct"),
						donnees.getInt("fkAppli"),
						donnees.getString("nomApplication")));
			}
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static fonctionnaliteArbre getFonctionnaliteArbreAppli(
			String nomAppli) {
		// TODO Auto-generated method stub
model.fonctionnaliteArbre v = new model.fonctionnaliteArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite, application WHERE fonctionnalite.fkAppli=application idApplication AND application.nomApplication = '" + nomAppli +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdFonctionnalite(donnees.getInt("IdFonctionnalite"));
				v.setNomFonctionnalite(donnees.getString("nomFonctionnalite"));
				v.setDescriptionFonctionnalite(donnees.getString("descriptionFonctionnalite"));
				v.setDateDebutFonct(donnees.getDate("dateDebutFonct"));
				v.setDateFinFonct(donnees.getDate("dateFinFonct"));
				v.setNumFonct(donnees.getString("numFonct"));
				v.setFkAppli(donnees.getInt("fkAppli"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

}
