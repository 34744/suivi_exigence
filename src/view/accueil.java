package view;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import model.miseAJourArbre;
import model.miseAJourAttenteModelTableau;
import model.miseAJourModelTableau;


public class accueil extends JPanel {
	

	private JFrame frame;
	private JTable table;
	private JButton btnHome = new JButton("");
	private JButton btnRapports = new JButton("");
	private JButton btnSoftware = new JButton("");
	private JButton btnConfig = new JButton("");
	private JButton btnUpdate = new JButton("");
	private Vector<model.miseAJourArbre> vectMiseAJourArbre = new Vector<model.miseAJourArbre>();
	private miseAJourAttenteModelTableau modelMiseAJour;
	private miseAJourArbre miseAJourAttente = new miseAJourArbre();
	private JTable tblMiseAJour;
	
	public accueil() {
		
		setLayout(null);
		
		btnSoftware.setToolTipText("Applications");
		btnSoftware.setBackground(new Color(230, 230, 250));
		btnSoftware.setIcon(new ImageIcon(accueil.class.getResource("/icones/Application109.png")));
		btnSoftware.setBounds(191, 92, 109, 109);
		add(btnSoftware);
		
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setToolTipText("Gestion des mises \u00E0 jour");
		btnUpdate.setSelectedIcon(new ImageIcon(accueil.class.getResource("/icones/update109.png")));		
		btnUpdate.setIcon(new ImageIcon(accueil.class.getResource("/icones/update109.png")));
		btnUpdate.setBounds(343, 92, 109, 109);
		add(btnUpdate);
		
		btnRapports.setSelectedIcon(new ImageIcon(accueil.class.getResource("/icones/rapports109.png")));
		btnRapports.setToolTipText("Rapports");
		btnRapports.setIcon(new ImageIcon(accueil.class.getResource("/icones/rapports109.png")));
		btnRapports.setBounds(491, 92, 109, 109);
		add(btnRapports);
		
		btnConfig.setSelectedIcon(new ImageIcon(accueil.class.getResource("/icones/configuration109.png")));
		btnConfig.setToolTipText("Param\u00E8tres");
		btnConfig.setIcon(new ImageIcon(accueil.class.getResource("/icones/configuration109.png")));
		btnConfig.setBounds(641, 92, 109, 109);
		add(btnConfig);
		
		vectMiseAJourArbre = controller.controllerDBMiseAJour.getMiseAJourAttenteArbre();
		modelMiseAJour = new miseAJourAttenteModelTableau(vectMiseAJourArbre);
		tblMiseAJour = new JTable(modelMiseAJour);
		tblMiseAJour.setDefaultRenderer(Object.class, new tableMiseAJourRenderer());
		tblMiseAJour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblMiseAJour.setColumnSelectionAllowed(true);
		tblMiseAJour.setRowSelectionAllowed(true);
		tblMiseAJour.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tblMiseAJour.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tblMiseAJour.setForeground(Color.WHITE);
		tblMiseAJour.setFont(new Font("Tahoma", Font.BOLD, 14));
		tblMiseAJour.setBackground(new Color(211, 211, 211));
		//tblFonctionnalite.setBounds(10, 40, 130, 200);
		tblMiseAJour.setAutoCreateRowSorter(true);
		tblMiseAJour.getRowSorter().toggleSortOrder(0);
		tblMiseAJour.setAutoCreateRowSorter(true);
		tblMiseAJour.getColumnModel().getColumn(0).setPreferredWidth(55);
		tblMiseAJour.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblMiseAJour.getColumnModel().getColumn(2).setPreferredWidth(55);
		tblMiseAJour.getColumnModel().getColumn(3).setPreferredWidth(65);
		tblMiseAJour.getColumnModel().getColumn(4).setPreferredWidth(85);
		tblMiseAJour.getColumnModel().getColumn(5).setPreferredWidth(55);
		tblMiseAJour.getColumnModel().getColumn(6).setPreferredWidth(55);
		
		tblMiseAJour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tblMiseAJour.getSelectedRow()!=-1){
					//nomFonctionnalite=tblFonctionnalite.getValueAt(tblFonctionnalite.getSelectedRow(), 1).toString();
					if(arg0.getClickCount()==2){
						//modifFonctionnalite();
					}
					
				}
			}
		});
		JScrollPane scrollPaneMAJ = new JScrollPane(tblMiseAJour);
		scrollPaneMAJ.setVisible(true);
		scrollPaneMAJ.setBounds(41, 306, 709, 211);
		add(scrollPaneMAJ);
		
		JLabel lblMiseJour = new JLabel("Mises-\u00E0-jour en attente");
		lblMiseJour.setForeground(Color.WHITE);
		lblMiseJour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMiseJour.setBounds(41, 260, 206, 46);
		add(lblMiseJour);

		btnHome.setSelectedIcon(new ImageIcon(accueil.class.getResource("/icones/home109.png")));
		btnHome.setToolTipText("Accueil");
		btnHome.setIcon(new ImageIcon(accueil.class.getResource("/icones/home109.png")));
		btnHome.setBounds(41, 92, 109, 109);
		add(btnHome);

		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		this.setBackground(new Color(50,200,217));
		this.setVisible(true);
		
	}
	
	private class MyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			
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
		}
		
	}
	
	public void mainFrameHide(){
		frame.hide();
	}
}
