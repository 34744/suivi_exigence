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
	/**
	 * Create the panel.
	 */
	public configRapportView() {
		
	
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
		
		JPanel panelApplication = new JPanel();
		panelApplication.setBounds(284, 78, 477, 360);
		panelApplication.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panelApplication.setBackground(null);
		panelApplication.setLayout(null);
		
		JPanel panelFonctionnalite = new JPanel();
		panelFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		panelFonctionnalite.setBackground((Color) null);
		panelFonctionnalite.setBounds(10, 102, 457, 72);
		panelFonctionnalite.setLayout(null);
		panelApplication.add(panelFonctionnalite);

		add(panelApplication);
		
				
				
				JPanel panelExigence = new JPanel();
				panelExigence.setBounds(10, 277, 457, 72);
				panelApplication.add(panelExigence);
				panelExigence.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelExigence.setBackground((Color) null);
				panelExigence.setLayout(null);
				
				JPanel panelSFonctionnalite = new JPanel();
				panelSFonctionnalite.setBounds(10, 185, 457, 70);
				panelApplication.add(panelSFonctionnalite);
				panelSFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelSFonctionnalite.setBackground((Color) null);
				panelSFonctionnalite.setLayout(null);
				
				JPanel panelAppli = new JPanel();
				panelAppli.setLayout(null);
				panelAppli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelAppli.setBackground((Color) null);
				panelAppli.setBounds(10, 11, 457, 72);
				panelApplication.add(panelAppli);
				
				JPanel panelBouton = new JPanel();
				panelBouton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
				panelBouton.setBounds(10, 78, 256, 360);
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
				panelBouton.add(btnSFonctionnalite);
				btnSFonctionnalite.setText("Sous-Fonctionnalit\u00E9");
				btnSFonctionnalite.setForeground(Color.BLACK);
				btnSFonctionnalite.setBackground(Color.BLUE);
				
				jbuttonRapport btnExigence = new jbuttonRapport("Application");
				btnExigence.setBounds(10, 277, 235, 72);
				panelBouton.add(btnExigence);
				btnExigence.setText("Exigence fonctionnelle");
				btnExigence.setForeground(Color.BLACK);
				btnExigence.setBackground(Color.BLUE);
				
				jbuttonRapport btnApplication = new jbuttonRapport("Application");
				btnApplication.setBounds(11, 11, 235, 72);
				panelBouton.add(btnApplication);
				btnApplication.setIcon(null);
				btnApplication.setBackground(new Color(0, 0, 255));
				btnApplication.setForeground(SystemColor.windowBorder);
				btnApplication.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
		
		
	}
}
