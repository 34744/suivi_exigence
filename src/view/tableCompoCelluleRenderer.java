package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class tableCompoCelluleRenderer extends DefaultTableCellRenderer {
	

	public Component getTableCompoCelluleCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int Column){
		Component cell =super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, Column);
		Vector<model.compoCelluleArbre> vectCellule = new Vector<model.compoCelluleArbre>();
		vectCellule = controller.ControllerDBConfiguration.getCompoCelluleArbre();
		JComboBox comboCellule = new JComboBox();
		
		if(table.getValueAt(row,0).toString().isEmpty()){
			cell.setForeground(Color.GRAY);
			cell.setFont(new Font("Tahoma",Font.ITALIC,13));
		}
		
		if(table.getValueAt(row,0).toString().compareTo("")==0){
			cell.setForeground(Color.GRAY);
			cell.setFont(new Font("Tahoma",Font.ITALIC,13));
		}
		
		if(table.getValueAt(row,0).toString().isEmpty())
		comboCellule.addItem("--Sélectionnez Direction--");
		for(int i=0; i<vectCellule.size();i++){
			comboCellule.addItem(vectCellule.elementAt(i).getNomCellule());
		}
		//table.getColumn("Cellule").setCellEditor(new DefaultCellEditor(comboCellule));
		//tableCompoCelluleRenderer.getColumn("Cellule").setCellEditor(new DefaultCellEditor(comboCellule));
		return cell;
	}
}
