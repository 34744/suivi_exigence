package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class getDataConfiguration {

	public static utilisateur getUser(String nom) {
		utilisateur user = new utilisateur();
		try {
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			String requeteSQL = "SELECT * FROM Utilisateur WHERE codeUser = '"+ nom + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				user.setNumUlis(donnees.getString("numUlis"));
				user.setNomUtilisateur(donnees.getString("nomUser"));
				user.setPrenomUtilisateur(donnees.getString("prenomUser"));
				user.setIdUtilisateur(donnees.getInt("idUser"));
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e, "ERREUR",JOptionPane.ERROR_MESSAGE);
				}
		return user;
		}
	
	public static Vector<marche> getMarche(){
		Vector<model.marche> v = new Vector<model.marche>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM marche ORDER BY nomMarche";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){
				System.out.print(donnees.getString("nomMarche"));
				v.addElement(new marche(donnees.getInt("idMarche"),
						donnees.getString("nomMarche")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<application> getApplication(){
		Vector<model.application> v = new Vector<model.application>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM application ORDER BY visibiliteApplication, nomApplication";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){
				System.out.print(donnees.getString("nomApplication"));
				v.addElement(new application(donnees.getInt("idApplication"),
						donnees.getString("nomApplication"),
						donnees.getString("visibiliteApplication")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<applicationArbre> getApplicationArbre(){
		Vector<model.applicationArbre> v = new Vector<model.applicationArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM application ORDER BY visibiliteApplication, nomApplication";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new applicationArbre(donnees.getInt("IdApplication"),
												  donnees.getString("nomApplication"),
												  donnees.getString("visibiliteApplication")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static applicationArbre getApplicationArbre(String application){
		model.applicationArbre v = new model.applicationArbre();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM application WHERE nomApplication = '" + application +"' ORDER BY visibiliteApplication, nomApplication";//pt enlever ORDER BY
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdApplication(donnees.getInt("IdApplication"));
				v.setNomApplication(donnees.getString("nomApplication"));
				v.setVisibiliteApplication(donnees.getString("visibiliteApplication"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<utilisateur> getUtilisateur(){
		Vector<model.utilisateur> v = new Vector<model.utilisateur>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT DISTINCT * FROM utilisateur, direction, directiongeneral WHERE utilisateur.directionUtilisateur=direction.idDirection AND direction.idDG = directiongeneral.idDG ORDER BY nomUtilisateur";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new utilisateur(donnees.getInt("IdUtilisateur"),
												  donnees.getString("nomUtilisateur"),
												  donnees.getString("prenomUtilisateur"),
												  donnees.getString("numUlis"),
												  donnees.getString("mailUtilisateur"),
												  donnees.getString ("utilisateurActif"),
												  donnees.getInt("nomDirection"),
												  donnees.getString("nomDG")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<utilisateurArbre> getUtilisateurArbre(){
		Vector<model.utilisateurArbre> v = new Vector<model.utilisateurArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT DISTINCT * FROM utilisateur, direction, directiongeneral WHERE utilisateur.directionUtilisateur=direction.idDirection AND direction.idDG = directiongeneral.idDG ORDER BY nomUtilisateur";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new utilisateurArbre(donnees.getInt("idUtilisateur"),
												  donnees.getString("nomUtilisateur"),
												  donnees.getString("prenomUtilisateur"),
												  donnees.getString("numUlis"),
												  donnees.getString("mailUtilisateur"),
												  donnees.getString("utilisateurActif"),
												  donnees.getString("nomDirection"),
												  donnees.getString("nomDG")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static utilisateurArbre getUtilisateurArbre(String numUlis){
		model.utilisateurArbre v = new model.utilisateurArbre();

		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();

			String requeteSQL = "SELECT * FROM utilisateur,direction,directiongeneral WHERE utilisateur.directionUtilisateur=direction.idDirection AND direction.idDG = directiongeneral.idDG and numUlis = '" + numUlis +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdUtilisateur(donnees.getInt("idUtilisateur"));
				v.setNomUtilisateur(donnees.getString("nomUtilisateur"));
				v.setPrenomUtilisateur(donnees.getString("prenomUtilisateur"));
				v.setNumUlis(donnees.getString("numUlis"));
				v.setMailUtilisateur(donnees.getString("mailUtilisateur"));
				v.setUtilisateurActif(donnees.getString("utilisateurActif"));
				v.setUtilisateurDirection(donnees.getString("nomDirection"));
				v.setUtilisateurDG(donnees.getString("nomDG"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<utilisateurArbre> getUtilisateurActifArbre(){
		Vector<model.utilisateurArbre> v = new Vector<model.utilisateurArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM utilisateur,direction, directiongeneral WHERE utilisateur.directionUtilisateur=direction.idDirection AND direction.idDG = directiongeneral.idDG AND utilisateurActif !='Inactif' ORDER BY nomUtilisateur";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new utilisateurArbre(donnees.getInt("idUtilisateur"),
												  donnees.getString("nomUtilisateur"),
												  donnees.getString("prenomUtilisateur"),
												  donnees.getString("numUlis"),
												  donnees.getString("mailUtilisateur"),
												  donnees.getString("utilisateurActif"),
												  donnees.getString("nomDirection"),
												  donnees.getString("nomDG")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<direction> getDirection(){
		Vector<model.direction> v = new Vector<model.direction>();
		System.out.println("direction");
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM direction, directiongeneral WHERE direction.idDG = directiongeneral.idDG ORDER BY directiongeneral.nomDG";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new direction(donnees.getInt("idDirection"),
												  donnees.getString("nomDirection"),
												  donnees.getString("nomDG"),
												  donnees.getInt("idDG"),
												  donnees.getString("visibiliteDirection")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<directionArbre> getDirectionArbre(){
		Vector<model.directionArbre> v = new Vector<model.directionArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT  * FROM  direction, directiongeneral WHERE direction.idDG = directiongeneral.idDG ORDER BY directiongeneral.nomDG";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new directionArbre(donnees.getInt("idDirection"),
												  donnees.getString("nomDirection"),
												  donnees.getString("nomDG"),
												  donnees.getInt("idDG"),
												  donnees.getString("visibiliteDirection")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static directionArbre getDirectionArbre(String nomDirection){
		model.directionArbre v = new model.directionArbre();

		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();

			String requeteSQL = "SELECT * FROM direction WHERE nomDirection = '" + nomDirection +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdDirection(donnees.getInt("idDirection"));
				v.setNomDirection(donnees.getString("nomDirection"));
				v.setIdDG(donnees.getInt("idDG"));
				v.setVisibiliteDirection(donnees.getString("visibiliteDirection"));
				
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<directionGenerale> getDirectionGenerale(){
		Vector<model.directionGenerale> v = new Vector<model.directionGenerale>();

		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM directiongeneral ORDER BY idDG";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new directionGenerale(donnees.getInt("idDG"),
												  donnees.getString("nomDG"),
												  donnees.getString("visibiliteDG")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<directionGeneraleArbre> getDirectionGeneraleArbre(){
		Vector<model.directionGeneraleArbre> v = new Vector<model.directionGeneraleArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT  * FROM  directionGeneral ORDER BY idDG";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new directionGeneraleArbre(donnees.getInt("idDG"),
												  donnees.getString("nomDG"),
												  donnees.getString("visibiliteDG")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static directionGeneraleArbre getDirectionGeneraleArbre(String nomDG){
		model.directionGeneraleArbre v = new model.directionGeneraleArbre();

		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();

			String requeteSQL = "SELECT * FROM directiongeneral WHERE nomDG = '" + nomDG +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdDirectionGenerale(donnees.getInt("idDG"));
				v.setNomDirectionGenerale(donnees.getString("nomDG"));
				v.setVisibiliteDg(donnees.getString("visibiliteDG"));
				
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<cellule> getCellule(){
		Vector<model.cellule> v = new Vector<model.cellule>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM cellule ORDER BY nomCellule";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){
				System.out.print(donnees.getString("nomCellule"));
				v.addElement(new cellule(donnees.getInt("idCellule"),
						donnees.getString("nomCellule")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<cellule> getCelluleNonActive(int idUtilisateur){
		Vector<model.cellule> v = new Vector<model.cellule>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM cellule WHERE idCellule NOT IN (SELECT idCellule FROM compoCellule WHERE idUtilisateur ='" + idUtilisateur + "')";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){
				System.out.print(donnees.getString("nomCellule"));
				v.addElement(new cellule(donnees.getInt("idCellule"),
						donnees.getString("nomCellule")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<cellule> getCellule(String nomCellule){
		Vector<model.cellule> v = new Vector<model.cellule>();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM cellule WHERE nomCellule = '" + nomCellule +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){
				//System.out.print(donnees.getString("nomCellule"));
				v.addElement(new cellule(donnees.getInt("idCellule"),
						donnees.getString("nomCellule")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static cellule getCelluleSelect(String nomCellule){
		model.cellule v = new model.cellule();
		
		try{
			Statement stat=controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM cellule WHERE nomCellule = '" + nomCellule +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.setIdCellule(donnees.getInt("idCellule"));
				v.setNomCellule(donnees.getString("nomCellule"));
				
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<compoCellule> getCompoCellule(){
		Vector<model.compoCellule> v = new Vector<model.compoCellule>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM `compocellule`, cellule, utilisateur where compocellule.idUtilisateur = utilisateur.idUtilisateur and compocellule.idCellule = cellule.idCellule";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new compoCellule(donnees.getInt("idCellule"),
						donnees.getInt("idUtilisateur"),
						donnees.getString("dateDebutCellule"),
						donnees.getString("dateFinCellule")));
			}
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static compoCelluleArbre getCompoCelluleArbre(int idUtilisateur){
		model.compoCelluleArbre v = new model.compoCelluleArbre();

		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();

			String requeteSQL = "SELECT * FROM `compocellule`, cellule, utilisateur where compocellule.idUtilisateur = '" + idUtilisateur +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.setFkCellule(donnees.getInt("idCellule"));
				v.setFkUtilisateur(donnees.getInt("idUtilisateur"));
				v.setDateDebutCellule(donnees.getDate("DateDebutCellule"));
				v.setDateFinCellule(donnees.getDate("DateFinCellule"));
			}
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static compoCelluleArbre getCompoCelluleArbre(String numUlis){
		model.compoCelluleArbre v = new model.compoCelluleArbre();

		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();

			String requeteSQL = "SELECT * FROM compocellule, cellule, utilisateur where utilisateur.numUlis ='" + numUlis +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.setFkCellule(donnees.getInt("idCellule"));
				v.setFkUtilisateur(donnees.getInt("idUtilisateur"));
				v.setDateDebutCellule(donnees.getDate("DateDebutCellule"));
				v.setDateFinCellule(donnees.getDate("DateFinCellule"));
			}
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<compoCelluleArbre> getCompoCelluleArbre(){
		Vector<model.compoCelluleArbre> v = new Vector<model.compoCelluleArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM compocellule ORDER BY idCellule";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new compoCelluleArbre(donnees.getInt("idCellule"),
						donnees.getInt("idUtilisateur"),
						donnees.getDate("dateDebutCellule"),
						donnees.getDate("dateFinCellule")));
			}
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<compoCelluleArbre> getCompoCelluleVecteurArbre(String numUlis){
		Vector<model.compoCelluleArbre> v = new Vector<model.compoCelluleArbre>();
		
		try{
			Statement stat = controller.ControllerDBConfiguration.connectionDB().createStatement();
			System.out.println("Vecteur arbre");
			String requeteSQL = "SELECT * FROM compocellule, cellule, utilisateur where compocellule.idCellule = cellule.idCellule and compocellule.idUtilisateur=utilisateur.idUtilisateur and utilisateur.numUlis ='" + numUlis +"'ORDER BY nomCellule";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new compoCelluleArbre(donnees.getString("cellule.nomCellule"),
						donnees.getInt("compocellule.idUtilisateur"),
						donnees.getDate("compocellule.dateDebutCellule"),
						donnees.getDate("compocellule.dateFinCellule")));
			}
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
}
