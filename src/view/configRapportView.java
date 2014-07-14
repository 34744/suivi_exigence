package view;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import model.fonctionnaliteModelTableau;
import model.jbuttonRapport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;



public class configRapportView extends JPanel {
	private JFrame frame;
	private JTable table;
	private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
	private fonctionnaliteModelTableau modelFonctionnalite;
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JButton btnAutreRapport = new JButton("Autre rapport");
	private JPanel panelBouton = new JPanel();
	private JPanel panelApplication = new JPanel();
	private JPanel panelFonctionnalite = new JPanel();
	private JPanel panelExigence = new JPanel();
	private JPanel panelSFonctionnalite = new JPanel();
	private JPanel panelAppli = new JPanel();
	
	private jbuttonRapport btnApplication = new jbuttonRapport("Application");
	private jbuttonRapport btnSFonctionnalite = new jbuttonRapport("Sous Fonctionnalit�");
	private jbuttonRapport btnFonctionnalite = new jbuttonRapport("Fonctionnalit�");
	private jbuttonRapport btnExigence = new jbuttonRapport("Exigence fonctionnelle");
	
	private JButton btnApplicationValider = new JButton("Valider");
	private JButton btnFonctionnaliteValider = new JButton("Valider");
	private JButton btnSFonctionnaliteValider = new JButton("Valider");
	private JButton btnExigenceValider = new JButton("Valider");
	
	private JComboBox comboBoxSFonctionnalite = new JComboBox();
	private JComboBox comboBoxFonctionnalite = new JComboBox();
	private JComboBox comboBoxExigence = new JComboBox();
	private JComboBox comboBoxAppli = new JComboBox();
	
	private JRadioButton rdbtnTypecourt = new JRadioButton("Succinct");
	private JRadioButton rdbtnTypeLong = new JRadioButton("D�taill�");
	/**
	 * Create the panel.
	 */
	public configRapportView(String mode) {
		
	
		setBackground(new Color(187,210,255));
		setLayout(null);
		
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
		
			
			panelBouton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			panelBouton.setBounds(267, 108, 256, 360);
			add(panelBouton);
			panelBouton.setLayout(null);
			
			
			btnAutreRapport.setBounds(633, 513, 128, 23);
			add(btnAutreRapport);
			
			rdbtnTypecourt.setBackground(null);
			rdbtnTypeLong.setBackground(null);
			
			
			
			btnFonctionnalite.setBounds(10, 102, 235, 72);

			
			btnFonctionnalite.setForeground(Color.BLACK);
			btnFonctionnalite.setBackground(Color.BLUE);
			
			
			btnSFonctionnalite.setBounds(10, 185, 235, 72);
			
			btnSFonctionnalite.setForeground(Color.BLACK);
			btnSFonctionnalite.setBackground(Color.BLUE);

		
		
		panelApplication.setBounds(285, 108, 477, 360);
		panelApplication.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panelApplication.setBackground(null);
		panelApplication.setLayout(null);
		
		
		panelFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		panelFonctionnalite.setBackground((Color) null);
		panelFonctionnalite.setBounds(10, 102, 457, 72);
		panelFonctionnalite.setLayout(null);
		comboBoxFonctionnalite.setBounds(10, 21, 316, 25);
		panelFonctionnalite.add(comboBoxFonctionnalite);
		

		btnSFonctionnaliteValider.setEnabled(false);
		btnSFonctionnaliteValider.setBounds(358, 22, 89, 23);
											
				panelExigence.setBounds(10, 277, 457, 72);
				
				panelExigence.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelExigence.setBackground((Color) null);
				panelExigence.setLayout(null);
				
				
				comboBoxExigence.setBounds(10, 24, 316, 25);
				panelExigence.add(comboBoxExigence);
				
				btnExigenceValider.setEnabled(false);
				btnExigenceValider.setBounds(358, 25, 89, 23);
				
				
				panelSFonctionnalite.setBounds(10, 185, 457, 70);
				
				panelSFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelSFonctionnalite.setBackground((Color) null);
				panelSFonctionnalite.setLayout(null);
				
				
				comboBoxSFonctionnalite.setBounds(10, 22, 316, 25);
				panelSFonctionnalite.add(comboBoxSFonctionnalite);
				
				btnFonctionnaliteValider.setEnabled(false);
				btnFonctionnaliteValider.setBounds(358, 23, 89, 23);	
				
				panelAppli.setLayout(null);
				panelAppli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelAppli.setBackground((Color) null);
				panelAppli.setBounds(10, 11, 457, 72);
				
				
				comboBoxAppli.setBounds(10, 24, 316, 25);
				panelAppli.add(comboBoxAppli);
				
				btnApplicationValider.setEnabled(false);
				btnApplicationValider.setBounds(358, 25, 89, 23);

				btnExigence.setBounds(10, 277, 235, 72);
				btnExigence.setForeground(Color.BLACK);
				btnExigence.setBackground(Color.BLUE);
				
				
				btnApplication.setBounds(11, 11, 235, 72);
				btnApplication.setIcon(null);
				btnApplication.setBackground(new Color(0, 0, 255));
				btnApplication.setForeground(SystemColor.windowBorder);

				if(mode=="choix"){
					panelBouton.add(btnApplication);
					panelBouton.add(btnFonctionnalite);
					panelBouton.add(btnSFonctionnalite);
					panelBouton.add(btnExigence);
					btnAutreRapport.setVisible(false);
				}
			
				if(mode=="application"){
					comboBoxAppli.setBounds(10, 10, 316, 25);
					panelApplication.add(panelAppli);
					panelApplication.setVisible(true);
					rdbtnTypecourt.setBounds(50, 40, 75, 23);
					rdbtnTypecourt.setSelected(true);
					panelAppli.add(rdbtnTypecourt);
					rdbtnTypeLong.setBounds(150, 40, 75, 23);
					panelAppli.add(rdbtnTypeLong);
					panelAppli.add(btnApplicationValider);
					panelAppli.setVisible(true);
					panelBouton.setBounds(25, 108, 256, 360);
					panelBouton.add(btnApplication);
					remplirApplication();
					this.add(panelApplication);
					this.add(panelBouton);
					
				}	
				
				if(mode=="fonctionnalite"){
					comboBoxFonctionnalite.setBounds(10, 10, 316, 25);
					rdbtnTypecourt.setBounds(50, 40, 75, 23);
					rdbtnTypecourt.setSelected(true);
					panelFonctionnalite.add(rdbtnTypecourt);
					rdbtnTypeLong.setBounds(150, 40, 75, 23);
					panelFonctionnalite.add(rdbtnTypeLong);
					panelApplication.add(panelAppli);
					panelApplication.add(panelFonctionnalite);
					panelApplication.setVisible(true);
					panelFonctionnalite.add(btnFonctionnaliteValider);
					panelAppli.setVisible(true);
					panelBouton.setBounds(25, 108, 256, 360);
					panelBouton.add(btnFonctionnalite);
					remplirApplication();
					
					this.add(panelApplication);
					this.add(panelBouton);
					
				}	
				
				if(mode=="sousFonctionnalite"){
					comboBoxSFonctionnalite.setBounds(10, 10, 316, 25);
					rdbtnTypecourt.setBounds(50, 40, 75, 23);
					rdbtnTypecourt.setSelected(true);
					panelSFonctionnalite.add(rdbtnTypecourt);
					rdbtnTypeLong.setBounds(150, 40, 75, 23);
					panelSFonctionnalite.add(rdbtnTypeLong);
					panelApplication.add(panelSFonctionnalite);
					panelApplication.add(panelAppli);
					panelApplication.add(panelFonctionnalite);
					panelSFonctionnalite.add(btnSFonctionnaliteValider);
					panelApplication.setVisible(true);
					panelAppli.setVisible(true);
					panelBouton.setBounds(25, 108, 256, 360);
					panelBouton.add(btnSFonctionnalite);
					
					remplirApplication();
					this.add(panelApplication);
					this.add(panelBouton);
					
				}	
				
				if(mode=="exigence"){
					comboBoxExigence.setBounds(10, 10, 316, 25);
					rdbtnTypecourt.setBounds(50, 40, 75, 23);
					rdbtnTypecourt.setSelected(true);
					panelExigence.add(rdbtnTypecourt);
					rdbtnTypeLong.setBounds(150, 40, 75, 23);
					panelExigence.add(rdbtnTypeLong);
					panelApplication.add(panelExigence);
					panelApplication.add(panelSFonctionnalite);
					panelApplication.add(panelAppli);
					panelApplication.add(panelFonctionnalite);
					panelExigence.add(btnExigenceValider);
					panelApplication.setVisible(true);
					panelAppli.setVisible(true);
					panelBouton.setBounds(25, 108, 256, 360);
					panelBouton.add(btnExigence);
					remplirApplication();
					this.add(panelApplication);
					this.add(panelBouton);
					
				}	
				
				MyButtonListener list= new MyButtonListener();
				btnConfig.addActionListener(list);
				btnSoftware.addActionListener(list);
				btnUpdate.addActionListener(list);
				btnRapports.addActionListener(list);
				btnHome.addActionListener(list);
				btnApplication.addActionListener(list);
				btnFonctionnalite.addActionListener(list);
				btnSFonctionnalite.addActionListener(list);
				btnExigence.addActionListener(list);
				btnExigenceValider.addActionListener(list);
				btnSFonctionnaliteValider.addActionListener(list);
				btnFonctionnaliteValider.addActionListener(list);
				btnAutreRapport.addActionListener(list);
				MonApplication itemListener = new MonApplication();
				comboBoxAppli.addItemListener(itemListener);
				comboBoxFonctionnalite.addItemListener(itemListener);
				comboBoxSFonctionnalite.addItemListener(itemListener);
				comboBoxExigence.addItemListener(itemListener);
				
				MonRadio itemListenerRadio = new MonRadio();
				rdbtnTypecourt.addItemListener(itemListenerRadio);
				rdbtnTypeLong.addItemListener(itemListenerRadio);
	}
	private class MonRadio implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==rdbtnTypecourt){
				if(rdbtnTypecourt.isSelected()==true){
					rdbtnTypeLong.setSelected(false);
				}
			}
			if(e.getSource()==rdbtnTypeLong){
				if(rdbtnTypeLong.isSelected()==true){
					rdbtnTypecourt.setSelected(false);
				}
			}
		}
		
	}
	private class MonApplication implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==comboBoxAppli){
				remplirFonctionnalite(comboBoxAppli.getSelectedItem().toString());
				btnApplicationValider.setEnabled(true);
			}
			if(e.getSource()==comboBoxFonctionnalite){
				if(e.getStateChange()==ItemEvent.SELECTED && comboBoxFonctionnalite.getSelectedIndex()>0)
				remplirSFonctionnalite(comboBoxFonctionnalite.getSelectedItem().toString());
			}
			if(e.getSource()==comboBoxSFonctionnalite){
				if(e.getStateChange()==ItemEvent.SELECTED&& comboBoxSFonctionnalite.getSelectedIndex()>0)
				remplirExigence(comboBoxSFonctionnalite.getSelectedItem().toString());
				
			}
			if(e.getSource()==comboBoxSFonctionnalite&&comboBoxSFonctionnalite.getSelectedIndex()>0){
				btnSFonctionnaliteValider.setEnabled(true);
			}
			
			if(e.getSource()==comboBoxExigence && comboBoxExigence.getSelectedIndex()>0){
				btnExigenceValider.setEnabled(true);
			}
			
			if(e.getSource()==comboBoxFonctionnalite && comboBoxFonctionnalite.getSelectedIndex()>0){
				btnFonctionnaliteValider.setEnabled(true);
			}
			
		}
		
	}
	
	private class MyButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			if(source == btnHome){
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.accueil();
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
			if(source==btnApplication){
				controller.gestionFenetreRapport.eraseContainerPaneMainJFrame();
				controller.gestionFenetreRapport.configRapport("application");
					
			}
			if(source==btnFonctionnalite){
				controller.gestionFenetreRapport.eraseContainerPaneMainJFrame();
				controller.gestionFenetreRapport.configRapport("fonctionnalite");
					
			}
			if(source==btnSFonctionnalite){
				controller.gestionFenetreRapport.eraseContainerPaneMainJFrame();
				controller.gestionFenetreRapport.configRapport("sousFonctionnalite");
					
			}
			if(source==btnExigence){
				controller.gestionFenetreRapport.eraseContainerPaneMainJFrame();
				controller.gestionFenetreRapport.configRapport("exigence");
					
			}
			
			if(source==btnExigenceValider&&rdbtnTypecourt.isSelected()==true){
				controller.controllerDocumentExigence.docExigence(comboBoxExigence.getSelectedItem().toString());
			}
			
			if(source==btnSFonctionnaliteValider&&rdbtnTypecourt.isSelected()==true){
				controller.controllerDocumentSousFonctionnalite.docSousFonctionnalite(comboBoxSFonctionnalite.getSelectedItem().toString());
			}
			
			if(source==btnFonctionnaliteValider&&rdbtnTypecourt.isSelected()==true){
				controller.controllerDocumentFonctionnalite.docFonctionnalite(comboBoxFonctionnalite.getSelectedItem().toString());
			}
			
			if(source==btnAutreRapport){
				controller.gestionFenetreRapport.eraseContainerPaneMainJFrame();
				controller.gestionFenetreRapport.configRapport("choix");
			}
		}
	}
	
	public void remplirApplication(){
		
	Vector<model.application> vectApplication = new Vector<model.application>();
	vectApplication = controller.ControllerDBConfiguration.getApplication();
	//vectCellule = controller.ControllerDB.getCellule();
	comboBoxAppli.addItem("--S�lectionnez une application--");
	for(int i=0; i<vectApplication.size();i++){
		comboBoxAppli.addItem(vectApplication.elementAt(i).getNomApplication());
		
		}
	}
	
	public void remplirFonctionnalite(String nomAppli){
		comboBoxFonctionnalite.removeAllItems();
		Vector<model.fonctionnalite> vectFonctionnalites = new Vector<model.fonctionnalite>();
		vectFonctionnalites = controller.controllerDBFonctionnalite.getFonctionnaliteVecteurAppli(nomAppli);
		//vectCellule = controller.ControllerDB.getCellule();
		comboBoxFonctionnalite.addItem("--S�lectionnez une fonctionnalite--");
		for(int i=0; i<vectFonctionnalites.size();i++){
			comboBoxFonctionnalite.addItem(vectFonctionnalites.elementAt(i).getNomFonctionnalite());
			
			}
		}
	
	public void remplirSFonctionnalite(String nomFonctionnalite){
		comboBoxSFonctionnalite.removeAllItems();
		Vector<model.sousFonctionnalite> vectSFonctionnalites = new Vector<model.sousFonctionnalite>();
		vectSFonctionnalites = controller.controllerDBSousFonctionnalite.getSousFonctionnalite(nomFonctionnalite);
		//vectCellule = controller.ControllerDB.getCellule();
		comboBoxSFonctionnalite.addItem("--S�lectionnez une sous-fonctionnalite--");
		for(int i=0; i<vectSFonctionnalites.size();i++){
			comboBoxSFonctionnalite.addItem(vectSFonctionnalites.elementAt(i).getNomSFonct());
			
			}
		}
	
	public void remplirExigence(String nomSFonctionnalite){
		comboBoxExigence.removeAllItems();
		Vector<model.exigenceFonctionnelle> vectExigence = new Vector<model.exigenceFonctionnelle>();
		vectExigence = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteur(nomSFonctionnalite);
		//vectCellule = controller.ControllerDB.getCellule();
		comboBoxExigence.addItem("--S�lectionnez une exigence fonctionnelle--");
		for(int i=0; i<vectExigence.size();i++){
			comboBoxExigence.addItem(vectExigence.elementAt(i).getNomExigence());
			
			}
		}
}
