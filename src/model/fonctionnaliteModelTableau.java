package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class fonctionnaliteModelTableau extends AbstractTableModel{
	Vector<String> columnNames = new Vector<String>();
	Vector<model.fonctionnaliteArbre> contents = new Vector<model.fonctionnaliteArbre>();
	
	public fonctionnaliteModelTableau (Vector<model.fonctionnaliteArbre> contents){
		setColumnNames();
		setContents(contents);

	}
	
	public void setColumnNames(){
		columnNames.addElement("Numéro");
		columnNames.addElement("Nom");
		//columnNames.addElement("Description");
		columnNames.addElement("Date debut");
		columnNames.addElement("Date fin");
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
		SimpleDateFormat formater99 = null;
		formater99 =new SimpleDateFormat ("yyyy-MM-dd");
		Date dateFinale=null;
		try {
			dateFinale = formater99.parse("2099-12-31");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formater.format(dateFinale);

		model.fonctionnaliteArbre a = contents.elementAt(row);
		switch (col){
		
		case 0: 
			return a.getNumFonct();
		case 1: 
			return a.getNomFonctionnalite();
		case 2:
			if(a.getDateDebutFonct()!=null){
				return formater.format(a.getDateDebutFonct());
				}
				
				else{
					return a.getDateDebutFonct();
				}
		case 3:
			if(a.getDateFinFonct().compareTo(dateFinale)==0){
				return null;
			}
			else{
				return formater.format(a.getDateFinFonct());	
			}
		}
		
		return a;
	}
	
	public model.fonctionnaliteArbre getArmeeAt (int row){
		model.fonctionnaliteArbre a = contents.elementAt(row);
		return a;
	}
	public void setContents(Vector<model.fonctionnaliteArbre> contents){
		this.contents=contents;
	}
}
