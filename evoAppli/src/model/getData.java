package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class getData {

	public static utilisateur getUser(String nom) {
		utilisateur user = new utilisateur();
		try {
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
			String requeteSQL = "SELECT * FROM Utilisateur WHERE codeUser = '"+ nom + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				user.setCodeUser(donnees.getString("codeUser"));
				user.setNomUser(donnees.getString("nomUser"));
				user.setMdpUser(donnees.getString("mdpUser"));
				user.setFonctionUser(donnees.getString("fonctionUser"));
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e, "ERREUR",JOptionPane.ERROR_MESSAGE);
				}
		return user;
		}
}
