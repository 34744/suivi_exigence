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
import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;



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
	private jbuttonRapport btnApplication = new jbuttonRapport("Application");
	private JPanel panelBouton = new JPanel();
	private JPanel panelApplication = new JPanel();
	private JPanel panelFonctionnalite = new JPanel();
	private JPanel panelExigence = new JPanel();
	private JPanel panelSFonctionnalite = new JPanel();
	private JPanel panelAppli = new JPanel();
	/**
	 * Create the panel.
	 */
	public configRapportView(String mode) {
		
	
		setBackground(new Color(176, 196, 222));
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
		
		if(mode=="choix"){
			
			panelBouton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			panelBouton.setBounds(267, 108, 256, 360);
			add(panelBouton);
			panelBouton.setLayout(null);
			
			jbuttonRapport btnFonctionnalite = new jbuttonRapport("Application");
			btnFonctionnalite.setBounds(10, 102, 235, 72);
			panelBouton.add(btnFonctionnalite);
			btnFonctionnalite.setText("Fonctionnalit\u00E9");
			btnFonctionnalite.setForeground(Color.BLACK);
			btnFonctionnalite.setBackground(Color.BLUE);
			
			jbuttonRapport btnSFonctionnalite = new jbuttonRapport("Application");
			btnSFonctionnalite.setBounds(10, 185, 235, 72);
			btnSFonctionnalite.setText("Sous-Fonctionnalit\u00E9");
			btnSFonctionnalite.setForeground(Color.BLACK);
			btnSFonctionnalite.setBackground(Color.BLUE);
			panelBouton.add(btnSFonctionnalite);
		}
		
		
		panelApplication.setBounds(285, 108, 477, 360);
		panelApplication.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panelApplication.setBackground(null);
		panelApplication.setLayout(null);
		
		
		panelFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		panelFonctionnalite.setBackground((Color) null);
		panelFonctionnalite.setBounds(10, 102, 457, 72);
		panelFonctionnalite.setLayout(null);
		
		
		JComboBox comboBoxFonctionnalite = new JComboBox();
		comboBoxFonctionnalite.setBounds(10, 21, 316, 25);
		
		
		JButton btnFonctionnaliteValider = new JButton("Valider");
		btnFonctionnaliteValider.setBounds(358, 22, 89, 23);
		
											
				panelExigence.setBounds(10, 277, 457, 72);
				
				panelExigence.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelExigence.setBackground((Color) null);
				panelExigence.setLayout(null);
				
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setBounds(10, 24, 316, 25);
				panelExigence.add(comboBox_1);
				
				JButton button_1 = new JButton("Valider");
				button_1.setBounds(358, 25, 89, 23);
				panelExigence.add(button_1);
				
				
				panelSFonctionnalite.setBounds(10, 185, 457, 70);
				
				panelSFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelSFonctionnalite.setBackground((Color) null);
				panelSFonctionnalite.setLayout(null);
				
				JComboBox comboBoxSFonctionnalite = new JComboBox();
				comboBoxSFonctionnalite.setBounds(10, 22, 316, 25);
				panelSFonctionnalite.add(comboBoxSFonctionnalite);
				
				JButton button = new JButton("Valider");
				button.setBounds(358, 23, 89, 23);
				panelSFonctionnalite.add(button);
				
				
				panelAppli.setLayout(null);
				panelAppli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelAppli.setBackground((Color) null);
				panelAppli.setBounds(10, 11, 457, 72);
				
				
				JComboBox comboBoxAppli = new JComboBox();
				comboBoxAppli.setBounds(10, 24, 316, 25);
				panelAppli.add(comboBoxAppli);
				
				JButton btnApplicationValider = new JButton("Valider");
				btnApplicationValider.setBounds(358, 25, 89, 23);
				panelAppli.add(btnApplicationValider);

				
				
				jbuttonRapport btnExigence = new jbuttonRapport("Application");
				btnExigence.setBounds(10, 277, 235, 72);
				panelBouton.add(btnExigence);
				btnExigence.setText("Exigence fonctionnelle");
				btnExigence.setForeground(Color.BLACK);
				btnExigence.setBackground(Color.BLUE);
				
				
				btnApplication.setBounds(11, 11, 235, 72);
				panelBouton.add(btnApplication);
				btnApplication.setIcon(null);
				btnApplication.setBackground(new Color(0, 0, 255));
				btnApplication.setForeground(SystemColor.windowBorder);

			
				if(mode=="application"){
					panelApplication.add(panelAppli);
					panelApplication.setVisible(true);
					panelAppli.setVisible(true);
					this.add(panelApplication);
					this.add(panelBouton);
					
				}	
				MyButtonListener list= new MyButtonListener();
				btnApplication.addActionListener(list);
		
	}
	private class MyButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			if(source==btnApplication){
				controller.gestionFenetreRapport.eraseContainerPaneMainJFrame();
				controller.gestionFenetreRapport.configRapport("application");
					
			}
		}
	}
}
