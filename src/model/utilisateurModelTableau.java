package model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class utilisateurModelTableau extends AbstractTableModel {

	Vector<String> columnNames = new Vector<String>();
	Vector<model.utilisateurArbre> contents = new Vector<model.utilisateurArbre>();
	
	public utilisateurModelTableau (Vector<model.utilisateurArbre> contents){
		setColumnNames();
		setContents(contents);

	}
	
	public void setColumnNames(){

		columnNames.addElement("Nom");
		columnNames.addElement("Prénom");
		columnNames.addElement("N° Ulis");
		columnNames.addElement("Adresse Mail");
		columnNames.addElement("Actif");
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return contents.size();
	}
	
	public String getColumnName (int col){
		return columnNames.elementAt(col);
	}
	
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub

		model.utilisateurArbre a = contents.elementAt(row);
		switch (col){
		
		case 0: 
			return a.getNomUtilisateur();
		case 1: 
			return a.getPrenomUtilisateur();
		case 2: 
			return a.getNumUlis();
		case 3:
			return a.getMailUtilisateur();
		case 4:
			return a.getUtilisateurActif();
		}
		
		return a;
	}
	
	public model.utilisateurArbre getArmeeAt (int row){
		model.utilisateurArbre a = contents.elementAt(row);
		return a;
	}
	public void setContents(Vector<model.utilisateurArbre> contents){
		this.contents=contents;
	}
}
