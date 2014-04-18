package model;

 
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
 
public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
 
  public MultiLineCellRenderer() {
    setEditable(false);
    setLineWrap(true);
    setWrapStyleWord(true);
  }
 
  public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected, boolean hasFocus, int row, int column) {
 
    if (value instanceof String) {
      setText((String)value);
      // set the table's row height, if necessary
			//updateRowHeight(row,getPreferredSize().height);
    }
    else
      setText("");
    return this;
  }
}