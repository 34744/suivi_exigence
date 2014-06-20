package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class getDataCritereSucces {

	public static Vector<critereSuccesArbre> getCritereSuccesVecteurArbre(int codeExigenceFonctionnelle) {
		// TODO Auto-generated method stub
		Vector<critereSuccesArbre> v = new Vector<model.critereSuccesArbre>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite,sousfonctionnalite, application, exigencefonctionnelle, criteresucces"
					+ " WHERE criteresucces.fkExigence= exigencefonctionnelle.codeExigence"
					+ " AND exigencefonctionnelle.fkSFonct= sousfonctionnalite.codeSFonct"
					+ " AND criteresucces.dateFinCSRecord = '2099-12-31'"
					+ " AND  exigencefonctionnelle.dateFinEFRecord ='2099-12-31'"
					+ " AND sousfonctionnalite.dateFinSFRecord = '2099-12-31'"
					+ " AND fonctionnalite.fkAppli= application.idApplication "
					+ " AND sousfonctionnalite.fkFonct = fonctionnalite.idFonctionnalite"
					+ " AND exigencefonctionnelle.codeExigence='"+ codeExigenceFonctionnelle 
					+ "' ORDER BY criteresucces.numCritere";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()){

				v.addElement(new critereSuccesArbre(donnees.getInt("idCritere"),
						donnees.getString("nomCritere"),
						donnees.getDate("dateDebutCritere"),
						donnees.getDate("dateFinCritere"),
						donnees.getString("numCritere"),
						donnees.getInt("codeCritere"),
						donnees.getDate("dateDebutCSRecord"),
						donnees.getDate("dateFinCSRecord"),
						donnees.getInt("fkExigence"),
						donnees.getInt("fkAppli"),
						donnees.getInt("fkFonct"),
						donnees.getInt("fkSFonct"),
						donnees.getString("nomApplication"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("nomSFonct"),
						donnees.getString("nomExigence")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
		
	}

	public static Vector<critereSuccesArbre> getCritereSuccesVecteurArbre(String nomCritere) {
		// TODO Auto-generated method stub
Vector<critereSuccesArbre> v = new Vector<model.critereSuccesArbre>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM fonctionnalite,sousfonctionnalite, application, exigencefonctionnelle, criteresucces"
					+ " WHERE criteresucces.fkExigence= exigencefonctionnelle.codeExigence"
					+ " AND exigencefonctionnelle.fkSFonct= sousfonctionnalite.codeSFonct"
					+ " AND criteresucces.dateFinCSRecord = '2099-12-31'"
					+ " AND  exigencefonctionnelle.dateFinEFRecord ='2099-12-31'"
					+ " AND sousfonctionnalite.dateFinSFRecord = '2099-12-31'"
					+ " AND fonctionnalite.fkAppli= application.idApplication "
					+ " AND sousfonctionnalite.fkFonct = fonctionnalite.idFonctionnalite"
					+ " AND criteresucces.nomCritere='"+ nomCritere 
					+ "' ORDER BY criteresucces.numCritere";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()){

				v.addElement(new critereSuccesArbre(donnees.getInt("idCritere"),
						donnees.getString("nomCritere"),
						donnees.getDate("dateDebutCritere"),
						donnees.getDate("dateFinCritere"),
						donnees.getString("numCritere"),
						donnees.getInt("codeCritere"),
						donnees.getDate("dateDebutCSRecord"),
						donnees.getDate("dateFinCSRecord"),
						donnees.getInt("fkExigence"),
						donnees.getInt("fkAppli"),
						donnees.getInt("fkFonct"),
						donnees.getInt("fkSFonct"),
						donnees.getString("nomApplication"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("nomSFonct"),
						donnees.getString("nomExigence")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static critereSuccesArbre getCritereSuccesArbre(String nomCritere) {
				
			model.critereSuccesArbre v = new model.critereSuccesArbre();
			
			try{
				Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
				
				String requeteSQL = "SELECT * FROM fonctionnalite,sousfonctionnalite, application, exigencefonctionnelle, criteresucces"
						+ " WHERE criteresucces.fkExigence= exigencefonctionnelle.codeExigence"
						+ " AND exigencefonctionnelle.fkSFonct= sousfonctionnalite.codeSFonct"
						+ " AND criteresucces.dateFinCSRecord = '2099-12-31'"
						+ " AND  exigencefonctionnelle.dateFinEFRecord ='2099-12-31'"
						+ " AND sousfonctionnalite.dateFinSFRecord = '2099-12-31'"
						+ " AND fonctionnalite.fkAppli= application.idApplication "
						+ " AND sousfonctionnalite.fkFonct = fonctionnalite.idFonctionnalite"
						+ " AND criteresucces.nomCritere='"+ nomCritere +"'";
				ResultSet donnees = stat.executeQuery(requeteSQL);
				ResultSetMetaData metadata = donnees.getMetaData();
				
				while(donnees.next()){
					v.setIdCritere(donnees.getInt("IdCritere"));
					v.setNomCritere(donnees.getString("nomCritere"));
					v.setDateDebutCritere(donnees.getDate("dateDebutCritere"));
					v.setDateFinCritere(donnees.getDate("dateFinCritere"));
					v.setNumCritere(donnees.getString("numCritere"));
					v.setCodeCritere(donnees.getInt("codeCritere"));
					v.setDateDebutCSRecord(donnees.getDate("dateDebutCSRecord"));
					v.setDateFinCSRecord(donnees.getDate("dateFinCSRecord"));
					v.setFkExigence(donnees.getInt("fkExigence"));
					v.setFkAppli(donnees.getInt("fkAppli"));
					v.setFkFonct(donnees.getInt("fkFonct"));
					v.setFkSFonct(donnees.getInt("fkSFonct"));
					v.setNomExigence(donnees.getString("nomExigence"));
					v.setNomAppli(donnees.getString("nomApplication"));
					v.setNomFonct(donnees.getString("nomFonctionnalite"));
					v.setNomSFonct(donnees.getString("nomSFonct"));
				}
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
			}
			return v;
		}
	}


