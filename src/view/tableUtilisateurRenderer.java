package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

public class tableUtilisateurRenderer extends DefaultTableCellRenderer {
	
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int Column){
		Component cell =super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, Column);
		
	
		
		
		if(table.getValueAt(row,4).toString().compareTo("Inactif")==0){
			cell.setForeground(Color.GRAY);
			cell.setFont(new Font("Tahoma",Font.ITALIC,13));
		}
		
		if(table.getValueAt(row, 4).toString().compareTo("Inactif")!=0){
			cell.setForeground(Color.WHITE);
			cell.setFont(new Font("Tahoma",Font.PLAIN,13));
			
	}	
		return cell;
	}
	
	
}
