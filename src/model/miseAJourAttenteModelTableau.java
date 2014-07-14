package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import controller.controllerDBMiseAJour;

public class miseAJourAttenteModelTableau extends AbstractTableModel {
	Vector<String> columnNames = new Vector<String>();
	Vector<model.miseAJourArbre> contents = new Vector<model.miseAJourArbre>();
	
	public miseAJourAttenteModelTableau (Vector<model.miseAJourArbre> contents){
		setColumnNames();
		setContents(contents);

	}
	
	public void setColumnNames(){
		columnNames.addElement("Application");
		columnNames.addElement("Num");
		columnNames.addElement("Proposition");
		columnNames.addElement("Nbr. points");
		columnNames.addElement("Nbr. points validés");
		columnNames.addElement("Validation");
		columnNames.addElement("Mise en prod.");
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
		int nombrePoint=0;
		int nombrePointValide=0;
		model.miseAJourArbre nombrePointArbre = controllerDBMiseAJour.getMiseAJourPoint(contents.elementAt(row).getIdMiseAJour());
		nombrePoint=nombrePointArbre.getNombrePoint();
		model.miseAJourArbre nombrePointValideArbre = controllerDBMiseAJour.getMiseAJourPointValide(contents.elementAt(row).getIdMiseAJour());
		nombrePointValide=nombrePointValideArbre.getNombrePointValide();
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

		model.miseAJourArbre a = contents.elementAt(row);
		switch (col){
		
		case 0:
			return a.getNomApplication();
		case 1: 
			return a.getNumMAJ();
		case 2: 
			if(a.getDateProposition().compareTo(dateFinale)==0){
				return null;
			}
			else{
				return formater.format(a.getDateProposition());	
			}
		
		case 3: 
			return nombrePoint;
		
		case 4:
			return nombrePointValide;
		
		case 5:
			if(a.getDateValidation().compareTo(dateFinale)==0){
				return null;
			}
			else{
				return formater.format(a.getDateValidation());	
			}
			
		case 6:
			if(a.getDateMiseProd().compareTo(dateFinale)==0){
				return null;
			}
			else{
				return formater.format(a.getDateMiseProd());	
			}
		}
		
		return a;
	}
	
	public model.miseAJourArbre getArmeeAt (int row){
		model.miseAJourArbre a = contents.elementAt(row);
		return a;
	}
	public void setContents(Vector<model.miseAJourArbre> contents){
		this.contents=contents;
	} 

}
