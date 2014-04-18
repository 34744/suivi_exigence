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
			
			String requeteSQL = "SELECT * FROM fonctionnalite,sousFonctionnalite, application, exigencefonctionnelle, critereSucces"
					+ " WHERE critereSucces.fkExigence= exigenceFonctionnelle.codeExigence"
					+ " AND exigencefonctionnelle.fkSFonct= sousfonctionnalite.codeSFonct"
					+ " AND critereSucces.dateFinCSRecord = '2099-12-31'"
					+ " AND  exigencefonctionnelle.dateFinEFRecord ='2099-12-31'"
					+ " AND sousFonctionnalite.dateFinSFRecord = '2099-12-31'"
					+ " AND fonctionnalite.fkAppli= application.idApplication "
					+ " AND sousFonctionnalite.fkFonct = fonctionnalite.idFonctionnalite"
					+ " AND exigenceFonctionnelle.codeExigence='"+ codeExigenceFonctionnelle +"'";
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
						donnees.getString("nomExigence"),
						donnees.getString("nomApplication"),
						donnees.getString("nomFonctionnalite"),
						donnees.getString("nomSFonct")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
		
	}

}
