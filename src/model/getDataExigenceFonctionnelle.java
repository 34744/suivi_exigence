package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class getDataExigenceFonctionnelle {

	public static Vector<exigenceFonctionnelleArbre> getExigenceFonctionnelleVecteurArbre(int idSousFonctionnalite) {
Vector<exigenceFonctionnelleArbre> v = new Vector<model.exigenceFonctionnelleArbre>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite,sousfonctionnalite, application, exigencefonctionnelle "
					+ "WHERE exigencefonctionnelle.fkSFonct= sousfonctionnalite.codeSFonct "
					+ "AND exigencefonctionnelle.dateFinEFRecord ='2099-12-31'"
					+ "AND sousfonctionnalite.dateFinSFRecord = '2099-12-31'"
					+ "AND fonctionnalite.fkAppli= application.idApplication "
					+ "AND sousfonctionnalite.fkFonct = fonctionnalite.idFonctionnalite "
					+ "AND sousfonctionnalite.codeSFonct='"+ idSousFonctionnalite 
					+"' ORDER BY exigencefonctionnelle.nomExigence";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()){

				v.addElement(new exigenceFonctionnelleArbre(donnees.getInt("idExigence"),
						donnees.getString("nomExigence"),
						donnees.getString("descriptionExigence"),
						donnees.getString("raisonExigence"),
						donnees.getInt("prioriteExigence"),
						donnees.getDate("dateDebutExi"),
						donnees.getDate("dateFinExi"),
						donnees.getString("numExi"),
						donnees.getString("codeExigence"),
						donnees.getDate("dateDebutEFRecord"),
						donnees.getDate("dateFinEFRecord"),
						donnees.getInt("fkSFonct"),
						donnees.getInt("fkFonct"),
						donnees.getInt("fkAppli"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("nomApplication"),
						donnees.getString("nomSFonct")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
		
	}

	
	
	public static Vector<priorite> getPriorite(){
		Vector<model.priorite> v = new Vector<model.priorite>();
		
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM priorite ORDER BY idPriorite";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new priorite(donnees.getInt("idPriorite"),
												  donnees.getString("nomPriorite")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<prioriteArbre> getPrioriteArbre(){
		Vector<model.prioriteArbre> v = new Vector<model.prioriteArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT  * FROM  priorite ORDER BY idPriorite";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new prioriteArbre(donnees.getInt("idPriorite"),
												  donnees.getString("nomPriorite")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static exigenceFonctionnelleArbre getExigenceFonctionnelleArbre(	String nomExigenceFonctionnelle) {
		
			model.exigenceFonctionnelleArbre v = new model.exigenceFonctionnelleArbre();
			
			try{
				Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
				
				String requeteSQL = "SELECT * FROM exigencefonctionnelle, sousfonctionnalite WHERE  sousfonctionnalite.codeSFonct=exigencefonctionnelle.fkSFonct AND sousfonctionnalite.dateFinSFRecord = '2099-12-31' AND exigencefonctionnelle.dateFinEFRecord='2099-12-31' AND nomExigence='" + nomExigenceFonctionnelle +"'";
				ResultSet donnees = stat.executeQuery(requeteSQL);
				ResultSetMetaData metadata = donnees.getMetaData();
				
				while(donnees.next()){
					v.setIdExigence(donnees.getInt("IdExigence"));
					v.setNomExigence(donnees.getString("nomExigence"));
					v.setDescriptionExigence(donnees.getString("descriptionExigence"));
					v.setRaisonExigence(donnees.getString("raisonExigence"));
					v.setPrioriteExigence(donnees.getInt("prioriteExigence"));
					v.setDateDebutExi(donnees.getDate("dateDebutExi"));
					v.setDateFinExi(donnees.getDate("dateFinExi"));
					v.setNumExi(donnees.getString("numExi"));
					v.setCodeExigence(donnees.getString("codeExigence"));
					v.setDateDebutEFRecord(donnees.getDate("dateDebutEFRecord"));
					v.setDateFinEFRecord(donnees.getDate("dateFinEFRecord"));
					v.setFkSFonct(donnees.getInt("fkSFonct"));
					v.setFkFonct(donnees.getInt("fkFonct"));
					v.setNomSFonct(donnees.getString("nomSFonct"));
				}
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
			}
			return v;
		}
	
	public static exigenceFonctionnelleArbre getExigenceFonctionnelleArbreInt(	int codeExigenceFonctionnelle) {
		
		model.exigenceFonctionnelleArbre v = new model.exigenceFonctionnelleArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM exigencefonctionnelle WHERE  codeExigence='" + codeExigenceFonctionnelle +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdExigence(donnees.getInt("IdExigence"));
				v.setNomExigence(donnees.getString("nomExigence"));
				v.setDescriptionExigence(donnees.getString("descriptionExigence"));
				v.setRaisonExigence(donnees.getString("raisonExigence"));
				v.setPrioriteExigence(donnees.getInt("prioriteExigence"));
				v.setDateDebutExi(donnees.getDate("dateDebutExi"));
				v.setDateFinExi(donnees.getDate("dateFinExi"));
				v.setNumExi(donnees.getString("numExi"));
				v.setCodeExigence(donnees.getString("codeExigence"));
				v.setDateDebutEFRecord(donnees.getDate("dateDebutEFRecord"));
				v.setDateFinEFRecord(donnees.getDate("dateFinEFRecord"));
				v.setFkSFonct(donnees.getInt("fkSFonct"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static exigenceFonctionnelleArbre getExigenceFonctionnelleArbrePdf(	String nomExigenceFonctionnelle) {
		
		model.exigenceFonctionnelleArbre v = new model.exigenceFonctionnelleArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM exigencefonctionnelle,sousfonctionnalite, fonctionnalite, application WHERE application.idApplication= fonctionnalite.fkAppli AND fonctionnalite.idFonctionnalite = sousfonctionnalite.fkFonct AND exigencefonctionnelle.fkSFonct= sousfonctionnalite.codeSFonct AND exigencefonctionnelle.dateFinEFRecord='2099-12-31' AND sousfonctionnalite.dateFinSFRecord='2099-12-31' AND exigencefonctionnelle.nomExigence='" + nomExigenceFonctionnelle +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdExigence(donnees.getInt("IdExigence"));
				v.setNomExigence(donnees.getString("nomExigence"));
				v.setDescriptionExigence(donnees.getString("descriptionExigence"));
				v.setRaisonExigence(donnees.getString("raisonExigence"));
				v.setPrioriteExigence(donnees.getInt("prioriteExigence"));
				v.setDateDebutExi(donnees.getDate("dateDebutExi"));
				v.setDateFinExi(donnees.getDate("dateFinExi"));
				v.setNumExi(donnees.getString("numExi"));
				v.setCodeExigence(donnees.getString("codeExigence"));
				v.setDateDebutEFRecord(donnees.getDate("dateDebutEFRecord"));
				v.setDateFinEFRecord(donnees.getDate("dateFinEFRecord"));
				v.setFkSFonct(donnees.getInt("fkSFonct"));
				v.setFkFonct(donnees.getInt("fkFonct"));
				v.setFkAppli(donnees.getInt("fkAppli"));
				v.setNomFonct(donnees.getString("nomFonctionnalite"));
				v.setNomAppli(donnees.getString("nomApplication"));
				v.setNomSFonct(donnees.getString("nomSFonct"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static exigenceFonctionnelleArbre getExigenceFonctionnelleArbreVersion(int codeExigence) {
		
		model.exigenceFonctionnelleArbre v = new model.exigenceFonctionnelleArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT COUNT(*) FROM exigencefonctionnelle WHERE codeExigence ='" + codeExigence +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setVersionExigence(donnees.getInt(1));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	
	public static exigenceFonctionnelleArbre getExigenceFonctionnelleArbre(int idExigenceFonctionnelle) {
		
		model.exigenceFonctionnelleArbre v = new model.exigenceFonctionnelleArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM exigencefonctionnelle WHERE  idExigence='" + idExigenceFonctionnelle +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdExigence(donnees.getInt("IdExigence"));
				v.setNomExigence(donnees.getString("nomExigence"));
				v.setDescriptionExigence(donnees.getString("descriptionExigence"));
				v.setRaisonExigence(donnees.getString("raisonExigence"));
				v.setPrioriteExigence(donnees.getInt("prioriteExigence"));
				v.setDateDebutExi(donnees.getDate("dateDebutExi"));
				v.setDateFinExi(donnees.getDate("dateFinExi"));
				v.setNumExi(donnees.getString("numExi"));
				v.setCodeExigence(donnees.getString("codeExigence"));
				v.setDateDebutEFRecord(donnees.getDate("dateDebutEFRecord"));
				v.setDateFinEFRecord(donnees.getDate("dateFinEFRecord"));
				v.setFkSFonct(donnees.getInt("fkSFonct"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	
	public static exigenceFonctionnelle getExigenceFonctionnelle(	String nomSFonctionnalite) {
		
		model.exigenceFonctionnelle v = new model.exigenceFonctionnelle();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM exigencefonctionnelle, sousfonctionnalite WHERE exigencefonctionnelle.fkSFonct = sousfonctionnalite.idSousFonct AND exigencefonctionnelle.dateFinEFRecord='2099-12-31' AND sousfonctionnalite.nomSFonct='" + nomSFonctionnalite +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdExigence(donnees.getInt("IdExigence"));
				v.setNomExigence(donnees.getString("nomExigence"));
				v.setDescriptionExigence(donnees.getString("descriptionExigence"));
				v.setRaisonExigence(donnees.getString("raisonExigence"));
				v.setPrioriteExigence(donnees.getInt("prioriteExigence"));
				v.setNumExi(donnees.getString("numExi"));
				v.setFkSFonct(donnees.getInt("fkSFonct"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<exigenceFonctionnelle> getExigenceFonctionnelleVecteur(String nomSousFonctionnalite) {
		Vector<exigenceFonctionnelle> v = new Vector<model.exigenceFonctionnelle>();
				
				try{
					Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
					
					String requeteSQL = "SELECT* FROM exigencefonctionnelle, sousfonctionnalite WHERE exigencefonctionnelle.fkSFonct = sousfonctionnalite.codeSFonct AND exigencefonctionnelle.dateFinEFRecord='2099-12-31'AND sousfonctionnalite.dateFinSFRecord='2099-12-31' AND sousfonctionnalite.nomSFonct= '" + nomSousFonctionnalite +"'";
					ResultSet donnees = stat.executeQuery(requeteSQL);
					ResultSetMetaData metadata = donnees.getMetaData();
					while (donnees.next()){

						v.addElement(new exigenceFonctionnelle(donnees.getInt("idExigence"),
								donnees.getString("nomExigence"),
								donnees.getString("descriptionExigence"),
								donnees.getString("raisonExigence"),
								donnees.getInt("prioriteExigence"),
								donnees.getString("dateDebutExi"),
								donnees.getString("dateFinExi"),
								donnees.getString("numExi"),
								donnees.getInt("codeExigence"),
								donnees.getString("dateDebutEFRecord"),
								donnees.getString("dateFinEFRecord"),
								donnees.getInt("fkSFonct")));
					}
				}catch(SQLException e){
					JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
				}
				return v;
				
			}
}
	

