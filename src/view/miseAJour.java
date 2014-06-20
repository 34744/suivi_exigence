package view;

import java.awt.Color;
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
import model.applicationArbre;
import model.applicationModelTableau;
import model.fonctionnaliteModelTableau;
import model.miseAJourArbre;
import model.miseAJourModelTableau;

public class miseAJour extends JPanel {

	private JFrame frame;
	private JTable table;

	private Vector<model.miseAJourArbre> vectMiseAJourArbre = new Vector<model.miseAJourArbre>();
	private miseAJourModelTableau modelMiseAJour;
	private miseAJourArbre modelMiseAJourArbre;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private applicationModelTableau modelAppli;
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JTextField textFieldApplication;
	private JTextField erreurSelection;
	private applicationArbre applicationArbre = new applicationArbre();
	private JTable tblMiseAJour;
	private JButton btnModifier = new JButton("Modifier");
	private JButton btnMAJAjout = new JButton("Mise-\u00E0-jour (+)");
	private int idMaj;
	JScrollPane scrollPaneFonctionnalite = new JScrollPane(tblMiseAJour);
	public miseAJour() {
		setBackground(new Color(46, 139, 87));
		vectAppli = controller.ControllerDBConfiguration.getApplicationArbre();
		modelAppli = new applicationModelTableau(vectAppli);
		setLayout(null);
		table = new JTable(modelAppli);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(table.getSelectedRow()!=-1){
					remplirApplication(table.getValueAt(table.getSelectedRow(),0).toString());
					remplirMiseAJour(table.getValueAt(table.getSelectedRow(),0).toString());
					
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setToolTipText("S\u00E9lectionnez une mise-à-jour");
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBackground(new Color(211, 211, 211));
		table.setBounds(10, 56, 153, 476);
		/*frame.getContentPane().*/add(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		toolBar.setBounds(10, 1, 794, 41);
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
		erreurSelection=new JTextField();
		erreurSelection.setText("Veuillez sélectionner une application!");
		erreurSelection.setBackground(Color.RED);
		erreurSelection.setVisible(false);
		textFieldApplication = new JTextField();
		textFieldApplication.setForeground(Color.BLACK);
		textFieldApplication.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textFieldApplication.setBackground(new Color(176,196,222));
		textFieldApplication.setBounds(185, 53, 239, 25);

		add(textFieldApplication);
		textFieldApplication.setColumns(10);

		this.setVisible(true);
		
		
		modelMiseAJour = new miseAJourModelTableau(vectMiseAJourArbre);
		tblMiseAJour = new JTable(modelMiseAJour);
		tblMiseAJour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				int idMAJ;
				if(tblMiseAJour.getSelectedRow()!=-1){
					
					if(arg0.getClickCount()==2){
						System.out.println("recup1 nom MAJ"+tblMiseAJour.getValueAt(tblMiseAJour.getSelectedRow(),0).toString());
						modelMiseAJourArbre=model.getDataMiseAJour.getmiseAJourArbre(tblMiseAJour.getValueAt(tblMiseAJour.getSelectedRow(),0).toString());
						idMAJ=modelMiseAJourArbre.getIdMiseAJour();
						System.out.println("recup id"+idMAJ);
						modifMAJ(idMAJ);
					}
					
				}
			}
		});
		tblMiseAJour.setDefaultRenderer(Object.class, new tableMiseAJourRenderer());
		tblMiseAJour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblMiseAJour.setColumnSelectionAllowed(true);
		tblMiseAJour.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tblMiseAJour.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tblMiseAJour.setForeground(Color.WHITE);
		tblMiseAJour.setFont(new Font("Tahoma", Font.BOLD, 14));
		tblMiseAJour.setBackground(new Color(211, 211, 211));
		tblMiseAJour.setAutoCreateRowSorter(true);
		tblMiseAJour.getRowSorter().toggleSortOrder(0);
		tblMiseAJour.setAutoCreateRowSorter(true);
		tblMiseAJour.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblMiseAJour.getColumnModel().getColumn(1).setPreferredWidth(55);
		tblMiseAJour.getColumnModel().getColumn(2).setPreferredWidth(75);
		tblMiseAJour.getColumnModel().getColumn(3).setPreferredWidth(75);
		tblMiseAJour.getColumnModel().getColumn(4).setPreferredWidth(55);
		tblMiseAJour.getColumnModel().getColumn(4).setPreferredWidth(55);
		
		scrollPaneFonctionnalite.setVisible(true);
		scrollPaneFonctionnalite.setBounds(185, 90, 570, 348);
		this.add(scrollPaneFonctionnalite);
		
		btnMAJAjout.setBounds(279, 471, 125, 23);
		add(btnMAJAjout);
		
		btnModifier.setBounds(494, 471, 125, 23);
		add(btnModifier);
		
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		btnModifier.addActionListener(list);
		btnMAJAjout.addActionListener(list);

	}
	
	private void ajoutMAJ(){
		controller.gestionFenetreMAJ.eraseContainerPaneMainJFrame();
		controller.gestionFenetreMAJ.majAjout();
	}
	
	private void modifMAJ(int idMaj){
		int idMAJ=idMaj;
		System.out.println("modifmaj"+idMAJ);
		controller.gestionFenetreMAJ.eraseContainerPaneMainJFrame();
		controller.gestionFenetreMAJ.majModif(idMAJ);
	}

	private void remplirApplication(String application){
		
		applicationArbre=ControllerDBConfiguration.getApplicationArbre(application);
		textFieldApplication.setText(applicationArbre.getNomApplication());
	}

	private void remplirMiseAJour(String nomAppli){
		//numAppli=appliSelectionnee;
		tblMiseAJour.removeAll();
		this.remove(scrollPaneFonctionnalite);
		String nomApplication=nomAppli;
		vectMiseAJourArbre = controller.controllerDBMiseAJour.getMiseAJourVecteurArbre(nomApplication);
		modelMiseAJour = new miseAJourModelTableau(vectMiseAJourArbre);
		tblMiseAJour = new JTable(modelMiseAJour);
		tblMiseAJour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				int idMAJ;
				if(tblMiseAJour.getSelectedRow()!=-1){
					
					if(arg0.getClickCount()==2){
						System.out.println("recup2 nom MAJ"+tblMiseAJour.getValueAt(tblMiseAJour.getSelectedRow(),0).toString());
						modelMiseAJourArbre=model.getDataMiseAJour.getmiseAJourArbre(tblMiseAJour.getValueAt(tblMiseAJour.getSelectedRow(),0).toString());
						idMAJ=modelMiseAJourArbre.getIdMiseAJour();
						System.out.println("recup id"+idMAJ);
						modifMAJ(idMAJ);
					}
					
				}
			}
		});
		tblMiseAJour.setDefaultRenderer(Object.class, new tableMiseAJourRenderer());
		tblMiseAJour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblMiseAJour.setColumnSelectionAllowed(true);
		tblMiseAJour.setRowSelectionAllowed(true);
		tblMiseAJour.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tblMiseAJour.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tblMiseAJour.setForeground(Color.WHITE);
		tblMiseAJour.setFont(new Font("Tahoma", Font.BOLD, 14));
		tblMiseAJour.setBackground(new Color(211, 211, 211));
		tblMiseAJour.setAutoCreateRowSorter(true);
		tblMiseAJour.getRowSorter().toggleSortOrder(0);
		tblMiseAJour.setAutoCreateRowSorter(true);
		tblMiseAJour.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblMiseAJour.getColumnModel().getColumn(1).setPreferredWidth(55);
		tblMiseAJour.getColumnModel().getColumn(2).setPreferredWidth(65);
		tblMiseAJour.getColumnModel().getColumn(3).setPreferredWidth(85);
		tblMiseAJour.getColumnModel().getColumn(4).setPreferredWidth(55);
		tblMiseAJour.getColumnModel().getColumn(4).setPreferredWidth(55);
		
		
		JScrollPane scrollPaneFonctionnalite = new JScrollPane(tblMiseAJour);
		scrollPaneFonctionnalite.setVisible(true);
		scrollPaneFonctionnalite.setBounds(185, 90, 570, 348);
		add(scrollPaneFonctionnalite);
	}
	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			
			if(source == btnHome){
				if(textFieldApplication.getText().equals(null)){
					erreurSelection.setVisible(true);
				}
				else{
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.accueil();
				}
			}
			
			if (source == btnSoftware){
				System.out.println("appli");
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.fonctionnalite();
			}
			
			if (source == btnRapports){
				System.out.println("appli");
				controller.gestionFenetreRapport.eraseContainerPaneMainJFrame();
				controller.gestionFenetreRapport.configRapport("choix");
			}
			
			if(source == btnConfig){
				System.out.println("config test");
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationAppliModif(false, 0);

			}
			if(source==btnUpdate){
				controller.gestionFenetreMAJ.eraseContainerPaneMainJFrame();
				controller.gestionFenetreMAJ.miseAJour();;
			}
			if(source==btnMAJAjout){
				ajoutMAJ();
			}
		}
	}
}


