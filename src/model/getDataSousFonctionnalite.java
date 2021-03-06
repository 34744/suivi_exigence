package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.sousFonctionnaliteArbre;

public class getDataSousFonctionnalite {

	public static Vector<sousFonctionnalite> getSousFonctionnalite() {
		Vector<model.sousFonctionnalite> v = new Vector<model.sousFonctionnalite>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM sousfonctionnalite";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()){

				v.addElement(new sousFonctionnalite(donnees.getInt("idSousFonct"),
						donnees.getString("nomSFonct"),
						donnees.getString("dateDebutSFonct"),
						donnees.getString("dateFinSFonct"),
						donnees.getString("numSFonct"),
						donnees.getInt("fkFonct")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			}
		return v;
	}

	public static Vector<sousFonctionnaliteArbre> getSousFonctionnaliteVecteurArbre(int idFonct) {
		Vector<model.sousFonctionnaliteArbre> v = new Vector<model.sousFonctionnaliteArbre>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite,sousfonctionnalite, application WHERE sousfonctionnalite.dateFinSFRecord ='2099-12-31' AND fonctionnalite.fkAppli= application.idApplication AND sousfonctionnalite.fkFonct = fonctionnalite.idFonctionnalite AND sousfonctionnalite.fkFonct='" + idFonct +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()){

				v.addElement(new sousFonctionnaliteArbre(donnees.getInt("idSousFonct"),
						donnees.getString("nomSFonct"),
						donnees.getDate("dateDebutSFonct"),
						donnees.getDate("dateFinSFonct"),
						donnees.getString("numSFonct"),
						donnees.getString("codeSFonct"),
						donnees.getDate("dateDebutSFRecord"),
						donnees.getDate("dateFinSFRecord"),
						donnees.getInt("fkFonct"),
						donnees.getInt("fkAppli"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("nomApplication")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			}
		return v;
		}

	public static Vector<sousFonctionnaliteArbre> getSousFonctionnaliteVecteurArbre(String nomSFonct) {
		Vector<model.sousFonctionnaliteArbre> v = new Vector<model.sousFonctionnaliteArbre>();
				
				try{
					Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
					
					String requeteSQL = "SELECT * FROM fonctionnalite,sousfonctionnalite, application WHERE fonctionnalite.fkAppli= application.idApplication AND sousfonctionnalite.fkFonct = fonctionnalite.idFonctionnalite AND sousfonctionnalite.nomSFonct='" + nomSFonct +"'";
					ResultSet donnees = stat.executeQuery(requeteSQL);
					ResultSetMetaData metadata = donnees.getMetaData();
					while (donnees.next()){

						v.addElement(new sousFonctionnaliteArbre(donnees.getInt("idSousFonct"),
								donnees.getString("nomSFonct"),
								donnees.getDate("dateDebutSFonct"),
								donnees.getDate("dateFinSFonct"),
								donnees.getString("numSFonct"),
								donnees.getString("codeSFonct"),
								donnees.getDate("dateDebutSFRecord"),
								donnees.getDate("dateFinSFRecord"),
								donnees.getInt("fkFonct"),
								donnees.getInt("fkAppli"),
								donnees.getString("nomFonctionnalite"),
								donnees.getString("nomApplication")));
					}
				}catch(SQLException e){
					JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
					}
				return v;
				}

	
	public static model.sousFonctionnaliteArbre getSousFonctionnaliteArbre(	int idSousFonctionnalite) {
model.sousFonctionnaliteArbre v = new model.sousFonctionnaliteArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite,sousfonctionnalite, application WHERE fonctionnalite.fkAppli= application.idApplication AND sousfonctionnalite.fkFonct = fonctionnalite.idFonctionnalite AND sousfonctionnalite.idSousFonct='" + idSousFonctionnalite +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdSousFonct(donnees.getInt("IdSousFonct"));
				v.setNomSFonct(donnees.getString("nomSFonct"));
				v.setDateDebutSFonct(donnees.getDate("dateDebutSFonct"));
				v.setDateFinSFonct(donnees.getDate("dateFinSFonct"));
				v.setNumSFonct(donnees.getString("numSFonct"));
				v.setCodeSFonct(donnees.getString("codeSFonct"));
				v.setDateDebutSFRecord(donnees.getDate("dateDebutSFonct"));
				v.setDateFinSFRecord(donnees.getDate("dateFinSFonct"));
				v.setFkFonct(donnees.getInt("fkFonct"));
				v.setFkAppli(donnees.getInt("fkAppli"));
				v.setNomFonct(donnees.getString("nomFonctionnalite"));
				v.setNomAppli(donnees.getString("nomApplication"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			}
		return v;
	}

	public static sousFonctionnaliteArbre getSousFonctionnaliteArbre(String nomSousFonctionnalite) {
		model.sousFonctionnaliteArbre v = new model.sousFonctionnaliteArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite,sousfonctionnalite, application WHERE fonctionnalite.fkAppli= application.idApplication AND sousfonctionnalite.fkFonct = fonctionnalite.idFonctionnalite AND sousfonctionnalite.nomSFonct='" + nomSousFonctionnalite +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdSousFonct(donnees.getInt("IdSousFonct"));
				v.setNomSFonct(donnees.getString("nomSFonct"));
				v.setDateDebutSFonct(donnees.getDate("dateDebutSFonct"));
				v.setDateFinSFonct(donnees.getDate("dateFinSFonct"));
				v.setNumSFonct(donnees.getString("numSFonct"));
				v.setCodeSFonct(donnees.getString("codeSFonct"));
				v.setDateDebutSFRecord(donnees.getDate("dateDebutSFonct"));
				v.setDateFinSFRecord(donnees.getDate("dateFinSFonct"));
				v.setFkFonct(donnees.getInt("fkFonct"));
				v.setFkAppli(donnees.getInt("fkAppli"));
				v.setNomFonct(donnees.getString("nomFonctionnalite"));
				v.setNomAppli(donnees.getString("nomApplication"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			}
		return v;
	}

	public static Vector<sousFonctionnaliteArbre> getSousFonctionnaliteArbre() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Vector<sousFonctionnalite> getSousFonctionnalite(
			String nomFonctionnalite) {
		
			Vector<model.sousFonctionnalite> v = new Vector<model.sousFonctionnalite>();
			
			try{
				Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
				
				String requeteSQL = "SELECT * FROM sousfonctionnalite, fonctionnalite WHERE sousfonctionnalite.fkFonct=idFonctionnalite AND sousfonctionnalite.dateFinSFRecord='2099-12-31'AND fonctionnalite.nomFonctionnalite ='" + nomFonctionnalite +"'";
				ResultSet donnees = stat.executeQuery(requeteSQL);
				ResultSetMetaData metadata = donnees.getMetaData();
				while (donnees.next()){

					v.addElement(new sousFonctionnalite(donnees.getInt("idSousFonct"),
							donnees.getString("nomSFonct"),
							donnees.getString("dateDebutSFonct"),
							donnees.getString("dateFinSFonct"),
							donnees.getString("numSFonct"),
							donnees.getInt("fkFonct")));
				}
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
				}
			return v;
		}

	public static sousFonctionnaliteArbre getSousFonctionnaliteArbreVersion(
			int codeSFonctionnalite) {
		model.sousFonctionnaliteArbre v = new model.sousFonctionnaliteArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT COUNT(*) FROM sousfonctionnalite WHERE codeSFonct ='" + codeSFonctionnalite +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setVersionSFonct(donnees.getInt(1));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Impossibilité de se connecter à la base de données","Erreur", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			}
		return v;
	}

	}


