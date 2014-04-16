package model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class applicationModelTableau extends AbstractTableModel{
	
	Vector<String> columnNames = new Vector<String>();
	Vector<model.applicationArbre> contents = new Vector<model.applicationArbre>();
	
	public applicationModelTableau (Vector<model.applicationArbre> contents){
		setColumnNames();
		setContents(contents);
	}
	
	public void setColumnNames(){
		columnNames.addElement("Nom");
		columnNames.addElement ("Visibilité");
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return contents.size();
	}
	
	public String getColumnName (int col){
		return columnNames.elementAt(col);
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		model.applicationArbre a = contents.elementAt(row);
		switch (col){
		
		case 0: return a.getNomApplication();
		case 1: return a.getVisibiliteApplication();
		}
		
		return a;
	}
	
	public void setContents(Vector<model.applicationArbre> contents){
		this.contents=contents;
	}
	
}
