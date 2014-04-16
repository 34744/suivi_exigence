package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class sousFonctionnaliteModelTableau extends AbstractTableModel{
	Vector<String> columnNames = new Vector<String>();
	Vector<model.sousFonctionnaliteArbre> contents = new Vector<model.sousFonctionnaliteArbre>();
	
	public sousFonctionnaliteModelTableau (Vector<model.sousFonctionnaliteArbre> contents){
		setColumnNames();
		setContents(contents);

	}
	
	public void setColumnNames(){
		columnNames.addElement("Numéro");
		columnNames.addElement("Nom");
		columnNames.addElement("Date fin");
		columnNames.addElement("Code");
		//columnNames.addElement("Date fin");
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

		model.sousFonctionnaliteArbre a = contents.elementAt(row);
		switch (col){
		
		case 0: 
			return a.getNumSFonct();
		case 1: 
			return a.getNomSFonct();
		case 2:
			if(a.getDateFinSFonct().compareTo(dateFinale)==0){
				return null;
			}
			else{
				return formater.format(a.getDateFinSFonct());	
			}
		case 3:
			return a.getCodeSFonct();
		/*case 2:
			if(a.getDateDebutSFonct()!=null){
				return formater.format(a.getDateDebutSFonct());
				}
				
				else{
					return a.getDateDebutSFonct();
				}*/
		
		}
		
		return a;
	}
	
	public model.sousFonctionnaliteArbre getArmeeAt (int row){
		model.sousFonctionnaliteArbre a = contents.elementAt(row);
		return a;
	}
	public void setContents(Vector<model.sousFonctionnaliteArbre> contents){
		this.contents=contents;
	}
}
