package view;

import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import model.fonctionnalite;
import model.fonctionnaliteModelTableau;
import model.ouvrirTree;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ControllerDBConfiguration;
import controller.addDataFonctionnalite;
import controller.addDataSousFonctionnalite;
import controller.controllerDBFonctionnalite;
import controller.controllerDBSousFonctionnalite;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.BevelBorder;

import view.Parametres.MyButtonListener;

import javax.swing.JPanel;
import javax.swing.JComboBox;

public class majAjout extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame frame;
	private JTable table;
	private JTree tree;
	private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
	private Vector<model.sousFonctionnaliteArbre> vectSFonctionnalite = new Vector<model.sousFonctionnaliteArbre>();
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private fonctionnaliteModelTableau modelFonctionnalite;
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JButton btnAnnuler = new JButton("Annuler");
	private JButton btnValider = new JButton("Valider");
	int idAppli;
	String nomAppli;
	private fonctionnalite fonctionnalite = new fonctionnalite();
	private model.sousFonctionnalite sousFonctionnalite = new model.sousFonctionnalite();
	private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JTextField textFieldNumSFonct;
	private JTextField textFieldNomSFonctionnalite;
	private JDateChooser calendrierDebut= new JDateChooser();
	private JDateChooser calendrierFin= new JDateChooser();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public majAjout() {

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(90, 120, 600, 334);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNomApplication = new JLabel("Nom de l'application");
		lblNomApplication.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomApplication.setBounds(49, 58, 233, 26);
		panel.add(lblNomApplication);
		
		JLabel lblNumMAJ = new JLabel("Num\u00E9ro de la mise-\u00E0-jour");
		lblNumMAJ.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumMAJ.setBounds(49, 21, 233, 26);
		panel.add(lblNumMAJ);
		
		JLabel lblDateProposition = new JLabel("Date proposition");
		lblDateProposition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateProposition.setBounds(49, 99, 129, 26);
		panel.add(lblDateProposition);
		
		textFieldNumSFonct = new JTextField();
		textFieldNumSFonct.setBounds(307, 21, 100, 26);
		panel.add(textFieldNumSFonct);
		textFieldNumSFonct.setColumns(10);
		
		textFieldNomSFonctionnalite = new JTextField();
		textFieldNomSFonctionnalite.setColumns(10);
		textFieldNomSFonctionnalite.setBounds(408, 130, 129, 26);
		panel.add(textFieldNomSFonctionnalite);
		

		calendrierDebut.setBounds(273, 93, 110, 26);
		calendrierDebut.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierDebut);

		calendrierFin.setBounds(273, 130, 110, 26);
		calendrierFin.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierFin);
		
		JLabel lblDateFin = new JLabel("Date validation");
		lblDateFin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateFin.setBounds(49, 136, 117, 26);
		panel.add(lblDateFin);		
		lblErreur.setBounds(49, 244, 416, 14);
		panel.add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(307, 56, 230, 28);
		panel.add(comboBox);
		
		JLabel lblDateNotification = new JLabel("Date notification");
		lblDateNotification.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateNotification.setBounds(49, 173, 117, 26);
		panel.add(lblDateNotification);
		
		JLabel lblDateDeMise = new JLabel("Date de mise en production");
		lblDateDeMise.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateDeMise.setBounds(49, 213, 199, 26);
		panel.add(lblDateDeMise);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(273, 167, 110, 26);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(273, 207, 110, 26);
		panel.add(dateChooser_1);
		
		JLabel lblNumCallBmc = new JLabel("Num call BMC");
		lblNumCallBmc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumCallBmc.setBounds(424, 93, 100, 26);
		panel.add(lblNumCallBmc);
		btnValider.setBounds(181, 292, 89, 31);
		panel.add(btnValider);

		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBounds(365, 292, 89, 31);
		panel.add(btnAnnuler);
		

		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		

		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		btnAnnuler.addActionListener(list);
		btnValider.addActionListener(list);

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
			
			if(source== btnAnnuler){
			controller.gestionFenetreMAJ.eraseContainerPaneMainJFrame();
			controller.gestionFenetreConfiguration.accueil();
				
			}
			
			if(source == btnValider){
				if(textFieldNumSFonct.getText()!=null && textFieldNumSFonct.getText().length()>0){
					sousFonctionnalite.setNumSFonct(textFieldNumSFonct.getText());
					
					if(textFieldNomSFonctionnalite.getText()!= null && textFieldNomSFonctionnalite.getText().length()>0 ){
						sousFonctionnalite.setNomSFonct(textFieldNomSFonctionnalite.getText());
							
					
							if(calendrierDebut.getDate()!=null){
								Date debut=calendrierDebut.getDate();
								String dateDebut = dateFormat.format(debut);
								sousFonctionnalite.setDateDebutSFonct(dateDebut);
								sousFonctionnalite.setDateDebutSFRecord(dateDebut);
					
								Date fin=calendrierFin.getDate();
								String dateFin="";
									if(calendrierFin.getDate()!=null){
										dateFin=dateFormat.format(fin);
										sousFonctionnalite.setDateFinSFonct(dateFin);
										sousFonctionnalite.setDateFinSFRecord(dateFin);
									}
									else{
										sousFonctionnalite.setDateFinSFonct("20991231");
										sousFonctionnalite.setDateFinSFRecord("2099-12-31");
									}
									addDataSousFonctionnalite.addNewSousFonctionnalite(sousFonctionnalite);
									model.recupererIdSousFonctionnalite.recupererIdSF(sousFonctionnalite);
									controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
									controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(sousFonctionnalite.getFkFonct(), sousFonctionnalite.getCodeSFonct(), sousFonctionnalite.getNomSFonct());	
							}
							else
							{
								lblErreur.setVisible(true);
								calendrierDebut.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								calendrierDebut.requestFocus();
							}
						}
						
					else
					{
						lblErreur.setVisible(true);
						textFieldNomSFonctionnalite.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textFieldNomSFonctionnalite.requestFocus();
					}
				}
				else
				{
					lblErreur.setVisible(true);
					textFieldNumSFonct.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldNumSFonct.requestFocus();					
				}
			}
		}				
	
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}


