package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import controller.controllerDBMiseAJour;

public class pointMajModelTableau extends AbstractTableModel{
	Vector<String> columnNames = new Vector<String>();
	Vector<model.pointMajArbre> contents = new Vector<model.pointMajArbre>();
	
	public pointMajModelTableau (Vector<model.pointMajArbre> contents){
		setColumnNames();
		setContents(contents);

	}
	
	public void setColumnNames(){

		columnNames.addElement("Nom Point");
		columnNames.addElement("Origine");
		columnNames.addElement("Risque");
		columnNames.addElement("Nbr. tests");
		columnNames.addElement("Nbr. tests réalisés");

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
		
		int nombreTests=0;
		int nombreTestsValides=0;
		//model.miseAJourArbre nombrePointArbre = controllerDBMiseAJour.getMiseAJourPoint(contents.elementAt(row).getIdMiseAJour());
		//nombrePoint=nombrePointArbre.getNombrePoint();
		//model.miseAJourArbre nombrePointValideArbre = controllerDBMiseAJour.getMiseAJourPointValide(contents.elementAt(row).getIdMiseAJour());
		//nombrePointValide=nombrePointValideArbre.getNombrePointValide();
		
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

		model.pointMajArbre a = contents.elementAt(row);
		switch (col){
		
		case 0: 
			return a.getNomPoint();
		case 1: 
			return a.getNomOrigine();
		
		case 2: 
			return a.getNomRisque();
		
		case 3:
			return nombreTests;
		
		case 4:
			return nombreTestsValides;
			
		
		}
		
		return a;
	}
	
	public model.pointMajArbre getArmeeAt (int row){
		model.pointMajArbre a = contents.elementAt(row);
		return a;
	}
	public void setContents(Vector<model.pointMajArbre> contents){
		this.contents=contents;
	}
}
