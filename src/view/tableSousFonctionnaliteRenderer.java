package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class tableSousFonctionnaliteRenderer extends DefaultTableCellRenderer{
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int Column){
		Component cell =super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, Column);
		
	
		
		
		if(table.getValueAt(row,2)== null){
			cell.setForeground(Color.WHITE);
			cell.setFont(new Font("Tahoma",Font.BOLD,13));
		}
		else{
			cell.setForeground(Color.GRAY);
			cell.setFont(new Font("Tahoma",Font.ITALIC,13));
		}
		
		
		return cell;
	}
}
