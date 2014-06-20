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
import model.miseAJour;
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
	private model.applicationArbre applicationArbre = new model.applicationArbre();
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
	private miseAJour miseAJour = new miseAJour();
	private model.sousFonctionnalite sousFonctionnalite = new model.sousFonctionnalite();
	private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JTextField textFieldNumMAJ;
	private JTextField textFieldNumCall;
	private JDateChooser calendrierDatePropo= new JDateChooser();
	private JDateChooser calendrierDateValidation= new JDateChooser();
	private JDateChooser calendrierDateProd = new JDateChooser();
	private JDateChooser calendrierDateNotif = new JDateChooser();
	private JComboBox comboBoxAppli = new JComboBox();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public majAjout() {

		setBackground(new Color(46, 139, 87));
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
		
		textFieldNumMAJ = new JTextField();
		textFieldNumMAJ.setBounds(307, 21, 230, 26);
		panel.add(textFieldNumMAJ);
		textFieldNumMAJ.setColumns(10);
		
		textFieldNumCall = new JTextField();
		textFieldNumCall.setColumns(10);
		textFieldNumCall.setBounds(408, 130, 129, 26);
		panel.add(textFieldNumCall);
		

		calendrierDatePropo.setBounds(273, 93, 110, 26);
		calendrierDatePropo.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierDatePropo);

		calendrierDateValidation.setBounds(273, 130, 110, 26);
		calendrierDateValidation.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierDateValidation);
		
		JLabel lblDateFin = new JLabel("Date validation");
		lblDateFin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateFin.setBounds(49, 136, 117, 26);
		panel.add(lblDateFin);		
		lblErreur.setBounds(49, 244, 416, 14);
		panel.add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);
		
		remplirApplication();
		comboBoxAppli.setBounds(307, 56, 230, 28);
		panel.add(comboBoxAppli);
		
		JLabel lblDateNotification = new JLabel("Date notification");
		lblDateNotification.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateNotification.setBounds(49, 173, 117, 26);
		panel.add(lblDateNotification);
		
		JLabel lblDateDeMise = new JLabel("Date de mise en production");
		lblDateDeMise.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateDeMise.setBounds(49, 213, 199, 26);
		panel.add(lblDateDeMise);
		
		calendrierDateNotif.setDateFormatString("dd/MM/yyyy");
		calendrierDateNotif.setBounds(273, 167, 110, 26);
		panel.add(calendrierDateNotif);

		calendrierDateProd.setDateFormatString("dd/MM/yyyy");
		calendrierDateProd.setBounds(273, 207, 110, 26);
		panel.add(calendrierDateProd);
		
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
				if(textFieldNumMAJ.getText()!=null && textFieldNumMAJ.getText().length()>0){
					miseAJour.setNumMAJ(textFieldNumMAJ.getText());
				}
				
					
					if(textFieldNumCall.getText()!= null && textFieldNumCall.getText().length()>0 ){
						miseAJour.setNumCallBmc(textFieldNumCall.getText());
				}	
							if(calendrierDatePropo.getDate()!=null){
								Date propo=calendrierDatePropo.getDate();
								String datePropo = dateFormat.format(propo);
								miseAJour.setDateProposition(datePropo);
							}
							else
							{
								miseAJour.setDateProposition("20991231");
							}
							
							if(calendrierDateValidation.getDate()!=null){
								Date valide=calendrierDateValidation.getDate();
								String dateValid = dateFormat.format(valide);
								miseAJour.setDateValidation(dateValid);
							}
							else
							{
								miseAJour.setDateValidation("20991231");
							}
							
							if(calendrierDateNotif.getDate()!=null){
								Date notif=calendrierDateNotif.getDate();
								String dateNotif = dateFormat.format(notif);
								miseAJour.setDateNotification(dateNotif);
							}
							else
							{
								miseAJour.setDateNotification("20991231");
							}
							if(calendrierDateProd.getDate()!=null){
								Date prod=calendrierDateProd.getDate();
								String dateProd = dateFormat.format(prod);
								miseAJour.setDateMiseProd(dateProd);
							}
							else
							{
								miseAJour.setDateMiseProd("20991231");
							}

							if(comboBoxAppli.getSelectedIndex()>-1){
								applicationArbre=ControllerDBConfiguration.getApplicationArbre2(comboBoxAppli.getSelectedItem().toString());
								miseAJour.setFkApplication(applicationArbre.getIdApplication());
							}	
					
				
			}						if(textFieldNumMAJ.getText()!=null && comboBoxAppli.getSelectedIndex()>-1 && calendrierDatePropo.getDate()!=null){
			
									controller.addDataMAJ.addNewMiseAJour(miseAJour);
									controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
									controller.gestionFenetreMAJ.majAjout();	
									}
							else{
								if(textFieldNumMAJ.getText()!=null){
									textFieldNumMAJ.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
									textFieldNumMAJ.requestFocus();
									lblErreur.setVisible(true);
								}
								else{
									textFieldNumMAJ.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								}
								if(comboBoxAppli.getSelectedIndex()>-1){
									comboBoxAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
									comboBoxAppli.requestFocus();
									lblErreur.setVisible(true);
								}
								else{
									comboBoxAppli.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								}
								
								if(calendrierDatePropo.getDate()!= null){
									calendrierDatePropo.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
									calendrierDatePropo.requestFocus();
									lblErreur.setVisible(true);
								}
								else{
									calendrierDatePropo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								}
							}
								
										
				
				
	
	}
}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void remplirApplication(){
		comboBoxAppli.removeAllItems();
		comboBoxAppli.addItem("--Sélectionnez une application--");
		vectAppli = ControllerDBConfiguration.getApplicationArbre();
		for(int i=0; i<vectAppli.size();i++){
			comboBoxAppli.addItem(vectAppli.elementAt(i).getNomApplication());
		}
	}
	}


