package model;

import javax.swing.JTree;

public class ouvrirTree {
	
	public JTree tree;

	public JTree ouvrirTree(JTree tree){
		
		int row = 0; 
	    while (row < tree.getRowCount()) { 
	      tree.expandRow(row); 
	      row++; 
	    } 
	    return tree;
	}
	
	
	
}
