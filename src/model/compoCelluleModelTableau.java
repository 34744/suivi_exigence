package model;

import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableCell;

import view.tableCompoCelluleRenderer;

//import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor.SetterOnlyReflection;


	public class compoCelluleModelTableau extends AbstractTableModel {

		private Object[] data;		
		Vector<String> columnNames = new Vector<String>();
		Vector<model.compoCelluleArbre> contents = new Vector<model.compoCelluleArbre>();
		compoCelluleArbre cellule = new compoCelluleArbre();
		
		
		public compoCelluleModelTableau(Object[]data){
			this.data=data;
		}
		
		public compoCelluleModelTableau () throws Exception{
			super();
			
			for(int i=0; i<contents.size();i++){
				fireTableRowsInserted(contents.size(), contents.size());
			}
		}
		
		
		public compoCelluleModelTableau (Vector<model.compoCelluleArbre>contents){
			setColumnNames();
			setContents(contents);

		}
		
		public void setColumnNames(){

			columnNames.addElement("Cellule");
			columnNames.addElement("Date Début");
			columnNames.addElement("Date Fin");
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
			model.compoCelluleArbre a = contents.elementAt(row);
			Vector<model.compoCelluleArbre> vectCellule = new Vector<model.compoCelluleArbre>();
			vectCellule = controller.ControllerDBConfiguration.getCompoCelluleArbre();
			JComboBox comboCellule = new JComboBox();
			Date dateFinale=null;
			
			try {
				dateFinale = formater99.parse("2099-12-31");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formater.format(dateFinale);
			System.out.println(dateFinale);
			switch (col){
			
			case 0: 
				if(a.getNomCellule()!=null){
				return a.getNomCellule();
				}
				else{
					comboCellule.addItem("--Sélectionnez Direction--");
					for(int i=0; i<vectCellule.size();i++){
						comboCellule.addItem(vectCellule.elementAt(i).getNomCellule());
					}
					return comboCellule;
				}
					
			case 1:
				if(a.getDateDebutCellule()!=null){
				return formater.format(a.getDateDebutCellule());
				}
				
				else{
					return a.getDateDebutCellule();
				}
				
			case 2: 
				if(a.getDateFinCellule().compareTo(dateFinale)==0){
					return null;
				}
				else{
					return formater.format(a.getDateFinCellule());	
				}
			}
			return a;

		}

		public model.compoCelluleArbre getArmeeAt (int row){
			model.compoCelluleArbre a = contents.elementAt(row);
			return a;
		}
		public void setContents(Vector<model.compoCelluleArbre>contents){
			this.contents=contents;
		}
		
		

		
		
		
		
}
