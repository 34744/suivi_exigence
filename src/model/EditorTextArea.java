package model;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

public class EditorTextArea extends JTextArea implements TableCellEditor {

   transient protected ChangeEvent changeEvent = null;

   public EditorTextArea() {

       this.setLineWrap(true);
       this.setWrapStyleWord(true);
   }

   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

       setText((value == null) ? "" : value.toString());
       setFont(table.getFont());
           setBackground(table.getBackground());
           setForeground(table.getForeground());
       return this;
   }

   public Object getCellEditorValue() {
       return getText();
   }

   public boolean isCellEditable(EventObject anEvent) {
       return true;
   }

   public boolean shouldSelectCell(EventObject anEvent) {
       return true;
   }

   public boolean stopCellEditing() {
       fireEditingStopped();
       return true;
   }

   public void cancelCellEditing() {
       return ;
   }

   public void addCellEditorListener(CellEditorListener l) {
       listenerList.add(CellEditorListener.class, l);

   }

   public void removeCellEditorListener(CellEditorListener l) {
       listenerList.remove(CellEditorListener.class, l);
   }

   // Méthode récupérée et copiée depuis la classe javax.swing.AbstractCellEditor
   protected void fireEditingStopped() {
       Object[] listeners = listenerList.getListenerList();
       for (int i = listeners.length - 2; i >= 0; i -= 2) {
           if (listeners[i] == CellEditorListener.class) {
               if (changeEvent == null) {
                   changeEvent = new ChangeEvent(this);
               }
               ((CellEditorListener) listeners[i + 1]).editingStopped(changeEvent);
           }
       }
   }
}