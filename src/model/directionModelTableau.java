package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class directionModelTableau extends AbstractTableModel {
	Vector<String> columnNames = new Vector<String>();
	Vector<model.directionArbre> contents = new Vector<model.directionArbre>();
	directionArbre direction = new directionArbre();
	DateFormat formatter;
	
	
	public directionModelTableau (Vector<model.directionArbre>contents){
		setColumnNames();
		setContents(contents);

	}
	
	public void setColumnNames(){

		columnNames.addElement("Nom Direction");
		columnNames.addElement("DG");
		columnNames.addElement("Visibilité");

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
		SimpleDateFormat formater = null;
		formater =new SimpleDateFormat ("dd/MM/yyyy");
		model.directionArbre a = contents.elementAt(row);
		Vector<model.directionArbre> vectDirection = new Vector<model.directionArbre>();
		vectDirection = controller.ControllerDBConfiguration.getDirectionUtilisateurArbre();


			switch (col){
			
			case 0: return a.getNomDirection();
			case 1: return a.getNomDG();
			case 2: return a.getVisibiliteDirection();
			
			}
			
			return a;
		
	}
	
	public model.directionArbre getArmeeAt (int row){
		model.directionArbre a = contents.elementAt(row);
		return a;
	}
	public void setContents(Vector<model.directionArbre>contents){
		this.contents=contents;
	}
	


}
