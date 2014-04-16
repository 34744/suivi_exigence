package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;








import controller.ControllerDBConfiguration;
import controller.controllerDBFonctionnalite;
import model.applicationArbre;
import model.applicationModelTableau;
import model.compoCelluleModelTableau;
import model.fonctionnaliteModelTableau;

import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class fonctionnaliteView extends JPanel {
	
	private JFrame frame;
	private JTable table;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private applicationModelTableau modelAppli;
	private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
	private fonctionnaliteModelTableau modelFonctionnalite;
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JTextField textFieldApplication;
	private JButton btnAjoutFonctionnalité = new JButton("Fonctionnalit\u00E9 (+)");
	private JButton btnModifierFonctionnalite = new JButton("Modifier");
	private JPanel panelFonctionnalite = new JPanel();
	private applicationArbre applicationArbre = new applicationArbre();
	private model.fonctionnaliteArbre fonctionnaliteArbre = new model.fonctionnaliteArbre();
	private JTable tblFonctionnalite;
	private int appliSelectionnee= 0;
	private int fonctionnaliteSelectionnee;
	private int idFonctionnalite;
	private String nomAppli;
	String nomFonctionnalite;
	/**
	
	/**
	 * Create the panel.
	 */
	public fonctionnaliteView() {
		setBackground(new Color(102, 204, 255));
		vectAppli = controller.ControllerDBConfiguration.getApplicationArbre();
		modelAppli = new applicationModelTableau(vectAppli);
		table = new JTable(modelAppli);
		table.setBounds(10, 56, 153, 476);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(table.getSelectedRow()!=-1){
					remplirApplication(table.getValueAt(table.getSelectedRow(),0).toString());
					System.out.println(table.getValueAt(table.getSelectedRow(),0).toString());
					remplirFonctionnalite(appliSelectionnee);
				}
			}
		});
		setLayout(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBackground(new Color(211, 211, 211));
		/*frame.getContentPane().*/add(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 1, 794, 41);
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		/*frame.getContentPane().*/add(toolBar);
		

		btnHome.setIcon(new ImageIcon(Application.class.getResource("/icones/home41.png")));
		btnHome.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/home41.png")));
		toolBar.add(btnHome);
		btnSoftware.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/Application41.png")));
		

		btnSoftware.setIcon(new ImageIcon(Application.class.getResource("/icones/Application41.png")));
		toolBar.add(btnSoftware);
		btnUpdate.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/update41.png")));
		

		btnUpdate.setIcon(new ImageIcon(Application.class.getResource("/icones/update41.png")));
		toolBar.add(btnUpdate);
		btnRapports.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/rapports41.png")));
		

		btnRapports.setIcon(new ImageIcon(Application.class.getResource("/icones/rapports41.png")));
		toolBar.add(btnRapports);
		btnConfig.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/configuration41.png")));
		

		btnConfig.setIcon(new ImageIcon(Application.class.getResource("/icones/configuration41.png")));
		toolBar.add(btnConfig);
		
		JToggleButton tglbtnModifier = new JToggleButton("Modifier");
		tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiable41.png")));
		
		tglbtnModifier.setToolTipText("Modifier");
		
		if(tglbtnModifier.isSelected()==false)
		{
		tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiable41.png")));
		System.out.println("test");
		}
		
		else
		{
			tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiableG41.png")));
			
		}
		toolBar.add(tglbtnModifier);
		
		textFieldApplication = new JTextField();
		textFieldApplication.setBounds(186, 56, 146, 25);
		textFieldApplication.setForeground(Color.BLACK);
		textFieldApplication.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textFieldApplication.setBackground(new Color(176,196,222));
		//textFieldApplication.enable(false);
		add(textFieldApplication);
		textFieldApplication.setColumns(10);
		
		vectFonctionnalite = controller.controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(appliSelectionnee);
		modelFonctionnalite = new fonctionnaliteModelTableau(vectFonctionnalite);
		tblFonctionnalite = new JTable(modelFonctionnalite);
		/*tblFonctionnalite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tblFonctionnalite.getSelectedRow()!=-1){
				
					if(arg0.getClickCount()==2){
						System.out.println("double");
					}
					
				}
			}
		});*/
		tblFonctionnalite.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblFonctionnalite.setColumnSelectionAllowed(true);
		tblFonctionnalite.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tblFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tblFonctionnalite.setForeground(Color.WHITE);
		tblFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
		tblFonctionnalite.setBackground(new Color(211, 211, 211));
		//tblFonctionnalite.setBounds(10, 40, 130, 200);
		tblFonctionnalite.setAutoCreateRowSorter(true);
		tblFonctionnalite.getRowSorter().toggleSortOrder(0);
		tblFonctionnalite.setAutoCreateRowSorter(false);
		tblFonctionnalite.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblFonctionnalite.getColumnModel().getColumn(1).setPreferredWidth(255);
		tblFonctionnalite.getColumnModel().getColumn(2).setPreferredWidth(55);
		tblFonctionnalite.getColumnModel().getColumn(3).setPreferredWidth(55);
		JScrollPane scrollPaneFonctionnalite = new JScrollPane(tblFonctionnalite);
		scrollPaneFonctionnalite.setVisible(true);
		scrollPaneFonctionnalite.setBounds(10, 5, 570, 348);
		
		panelFonctionnalite.setBounds(173, 124, 603, 350);
		panelFonctionnalite.setBackground(null);
		panelFonctionnalite.setLayout(null);
		panelFonctionnalite.add(scrollPaneFonctionnalite);
		add(panelFonctionnalite);
		
		JLabel lblListeFonctionnalite = new JLabel("Liste des fonctionnalit\u00E9s");
		lblListeFonctionnalite.setForeground(Color.WHITE);
		lblListeFonctionnalite.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblListeFonctionnalite.setBounds(184, 98, 181, 25);
		add(lblListeFonctionnalite);
		
		
		btnAjoutFonctionnalité.setBounds(295, 509, 140, 23);
		add(btnAjoutFonctionnalité);
		
		btnModifierFonctionnalite.setBounds(521, 509, 140, 23);
		add(btnModifierFonctionnalite);
		
		this.setVisible(true);
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		btnAjoutFonctionnalité.addActionListener(list);
		btnModifierFonctionnalite.addActionListener(list);

	}

	private void remplirApplication(String application){
		
		applicationArbre=ControllerDBConfiguration.getApplicationArbre(application);
		textFieldApplication.setText(applicationArbre.getNomApplication());
		appliSelectionnee=applicationArbre.getIdApplication();
		tblFonctionnalite.removeAll();
		tblFonctionnalite.repaint();
		System.out.println(appliSelectionnee);
	}
	
private void remplirFonctionnalite(int numAppli){
	numAppli=appliSelectionnee;
	panelFonctionnalite.removeAll();

	vectFonctionnalite = controller.controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(numAppli);
	modelFonctionnalite = new fonctionnaliteModelTableau(vectFonctionnalite);
	tblFonctionnalite = new JTable(modelFonctionnalite);
	tblFonctionnalite.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			Object source = arg0.getSource();
			if(tblFonctionnalite.getSelectedRow()!=-1){
				nomFonctionnalite=tblFonctionnalite.getValueAt(tblFonctionnalite.getSelectedRow(), 1).toString();
				if(arg0.getClickCount()==2){
					modifFonctionnalite();
				}
				
			}
		}
	});
	tblFonctionnalite.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tblFonctionnalite.setColumnSelectionAllowed(true);
	tblFonctionnalite.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
	tblFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
	tblFonctionnalite.setForeground(Color.WHITE);
	tblFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
	tblFonctionnalite.setBackground(new Color(211, 211, 211));
	//tblFonctionnalite.setBounds(10, 40, 130, 200);
	tblFonctionnalite.setAutoCreateRowSorter(true);
	tblFonctionnalite.getRowSorter().toggleSortOrder(0);
	tblFonctionnalite.setAutoCreateRowSorter(false);
	tblFonctionnalite.getColumnModel().getColumn(0).setPreferredWidth(30);
	tblFonctionnalite.getColumnModel().getColumn(1).setPreferredWidth(255);
	tblFonctionnalite.getColumnModel().getColumn(2).setPreferredWidth(55);
	tblFonctionnalite.getColumnModel().getColumn(3).setPreferredWidth(55);
	JScrollPane scrollPaneFonctionnalite = new JScrollPane(tblFonctionnalite);
	scrollPaneFonctionnalite.setVisible(true);
	scrollPaneFonctionnalite.setBounds(10, 5, 580, 350);
	panelFonctionnalite.add(scrollPaneFonctionnalite);
	
	panelFonctionnalite.repaint();
		
	}

	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			
			if(source == btnHome){
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.accueil();
			}
			
			if(source == btnAjoutFonctionnalité){
				nomAppli=table.getValueAt(table.getSelectedRow(),0).toString();
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreFonctionnalite.ajoutFonctionnalite(appliSelectionnee,nomAppli);
			}
			
			if(source==btnModifierFonctionnalite){
				modifFonctionnalite();
			}
		}

	}
	public void modifFonctionnalite(){
		controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
		controller.gestionFenetreFonctionnalite.modifFonctionnalite(nomFonctionnalite, appliSelectionnee, nomAppli);
	}
}


