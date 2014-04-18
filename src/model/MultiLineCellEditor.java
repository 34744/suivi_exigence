package model;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
 
 
public class MultiLineCellEditor extends AbstractCellEditor implements TableCellEditor {
 
  MyTextArea textArea;
	JTable table;
 
	public MultiLineCellEditor(JTable ta) {
		super();
		table = ta;
		// this component relies on having this renderer for the String class
		MultiLineCellRenderer renderer = new MultiLineCellRenderer();
		table.setDefaultRenderer(String.class,renderer);
//                JOptionPane.showMessageDialog(null,"jui ds l'editor","h",JOptionPane.INFORMATION_MESSAGE);
		textArea = new MyTextArea();
		textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
		for(int i=0;i<table.getRowCount();i++) updateRow(i);
	}
 
	/** This method determines the height in pixel of a cell given the text it contains */
	private int cellHeight(int row,int col) {
		if (row == table.getEditingRow() && col == table.getEditingColumn())
		  return textArea.getPreferredSize().height;
	  else
		  return table.getDefaultRenderer(String.class).getTableCellRendererComponent(table,
			  table.getModel().getValueAt(row,col),false,false,row,col).getPreferredSize().height;
	}
 
	void cellGrewEvent(int row,int column) {
		updateRow(row);
	}
 
	void cellShrankEvent(int row,int column) {
		updateRow(row);
	}
 
	void updateRow(int row) {
		int maxHeight = 0;
		for(int j=0;j<table.getColumnCount();j++) {
			int ch;
			if ((ch = cellHeight(row,j)) > maxHeight) {
			  maxHeight = ch;
			}
		}
		table.setRowHeight(row,maxHeight);
	}
 
	public Object getCellEditorValue() {
		return textArea.getText();
  }
 
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
						int row, int column) {
		textArea.setText(table.getValueAt(row,column).toString());
		textArea.rowEditing = row;
		textArea.columnEditing = column;
		textArea.lastPreferredHeight = textArea.getPreferredSize().height;
		return textArea;
	}
 
	class MyTextArea extends JTextArea implements KeyListener {
		int lastPreferredHeight = 0;
		int rowEditing;
		int columnEditing;
 
		MyTextArea() {
			addKeyListener(this);
			// This is a fix to Bug Id 4256006
			addAncestorListener( new AncestorListener(){
				public void ancestorAdded(AncestorEvent e){
				  requestFocus();
			  }
			  public void ancestorMoved(AncestorEvent e){}
			  public void ancestorRemoved(AncestorEvent e){}
			});
		}
 
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {
			if (getPreferredSize().getHeight() > lastPreferredHeight) {
				lastPreferredHeight = getPreferredSize().height;
				cellGrewEvent(rowEditing,columnEditing);
				// this will trigger the addition of extra lines upon the cell growing and
				// prevent all the text being lost when the cell grows to the point of requiring
				// scrollbars
				table.setValueAt(getText(),rowEditing,columnEditing);
			}
			else if (getPreferredSize().getHeight() < lastPreferredHeight) {
				lastPreferredHeight = getPreferredSize().height;
				cellShrankEvent(rowEditing,columnEditing);
			}
			else if (table.getValueAt(rowEditing,columnEditing).equals(""))
				table.setValueAt(getText(),rowEditing,columnEditing);
 
	  }
	}
}