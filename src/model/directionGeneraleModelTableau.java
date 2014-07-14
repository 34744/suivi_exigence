package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class directionGeneraleModelTableau extends AbstractTableModel{
	Vector<String> columnNames = new Vector<String>();
	Vector<model.directionGeneraleArbre> contents = new Vector<model.directionGeneraleArbre>();
	directionGeneraleArbre directionGenerale = new directionGeneraleArbre();
	DateFormat formatter;
	
	
	public directionGeneraleModelTableau (Vector<model.directionGeneraleArbre>contents){
		setColumnNames();
		setContents(contents);

	}
	
	public void setColumnNames(){

		columnNames.addElement("Nom DG");
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
		model.directionGeneraleArbre a = contents.elementAt(row);
		Vector<model.directionGeneraleArbre> vectDirectionGenerale = new Vector<model.directionGeneraleArbre>();
		vectDirectionGenerale = controller.ControllerDBConfiguration.getDirectionGeneraleArbre();


			switch (col){
			
			case 0: return a.getNomDirectionGenerale();
			case 1: return a.getVisibiliteDg();
			}
			
			return a;
		
	}
	
	public model.directionGeneraleArbre getArmeeAt (int row){
		model.directionGeneraleArbre a = contents.elementAt(row);
		return a;
	}
	public void setContents(Vector<model.directionGeneraleArbre>contents){
		this.contents=contents;
	}
	
}
