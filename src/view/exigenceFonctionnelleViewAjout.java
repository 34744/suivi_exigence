package view;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import controller.ControllerDBConfiguration;
import controller.addDataExigenceFonctionnelle;
import controller.controllerDBExigenceFonctionnelle;
import controller.controllerDBFonctionnalite;
import controller.controllerDBSousFonctionnalite;
import model.direction;
import model.exigenceFonctionnelle;
import model.fonctionnalite;
import model.fonctionnaliteModelTableau;
import model.priorite;

import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JComboBox;

public class exigenceFonctionnelleViewAjout extends JPanel implements ActionListener{
	private JFrame frame; //initialisation
	private JTable table;
	private JTree tree;
	private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
	private Vector<model.sousFonctionnaliteArbre> vectSFonctionnalite = new Vector<model.sousFonctionnaliteArbre>();
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private Vector <model.exigenceFonctionnelleArbre>vectExigenceFonctionnelle = new Vector<model.exigenceFonctionnelleArbre>();
	private Vector<priorite> vectPriorite = new Vector<model.priorite>();
	private fonctionnaliteModelTableau modelFonctionnalite;
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JButton btnAnnuler = new JButton("Annuler");
	private JButton btnValider = new JButton("Valider");
	JComboBox comboBoxPriorite;
	int idSousFonctionnalite, idAppli, idFonctionnalite;
	String nomSousFonctionnalite, nomAppli, nomFonctionnalite;
	private fonctionnalite fonctionnalite = new fonctionnalite();
	private model.sousFonctionnalite sousFonctionnalite = new model.sousFonctionnalite();
	private exigenceFonctionnelle exigenceFonctionnelle = new exigenceFonctionnelle();
	private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JTextField textFieldNumExigence;
	private JTextField textFieldNomExigence;
	private JDateChooser calendrierDebut= new JDateChooser();
	private JDateChooser calendrierFin= new JDateChooser();
	private JTextArea description = new JTextArea();
	private JTextArea raison = new JTextArea();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Create the panel.
	 */
	public exigenceFonctionnelleViewAjout(int idSousFonctionnalite,int idFonctionnalite, int idAppli, String nomSousFonctionnalite, String nomAppli, String nomFonctionnalite) {
		this.idSousFonctionnalite=idSousFonctionnalite;
		this.idAppli=idAppli;
		this.idFonctionnalite=idFonctionnalite;
		this.nomSousFonctionnalite=nomSousFonctionnalite;
		this.nomAppli=nomAppli;
		this.nomFonctionnalite=nomFonctionnalite;
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		buildTree();
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
		panel.setBounds(282, 45, 495, 463);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNomExigenceFonctionnelle = new JLabel("Nom de l'exigence");
		lblNomExigenceFonctionnelle.setBounds(10, 58, 171, 26);
		lblNomExigenceFonctionnelle.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNomExigenceFonctionnelle);
		
		JLabel lblNumExigenceFonctionnelle = new JLabel("Num\u00E9ro de l'exigence");
		lblNumExigenceFonctionnelle.setBounds(10, 21, 171, 26);
		lblNumExigenceFonctionnelle.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNumExigenceFonctionnelle);
		
		JLabel lblDateDebut = new JLabel("Date Debut");
		lblDateDebut.setBounds(10, 99, 85, 26);
		lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblDateDebut);
		
		textFieldNumExigence = new JTextField();
		textFieldNumExigence.setBounds(191, 23, 100, 26);
		panel.add(textFieldNumExigence);
		textFieldNumExigence.setColumns(10);
		
		textFieldNomExigence = new JTextField();
		textFieldNomExigence.setBounds(191, 60, 276, 26);
		textFieldNomExigence.setColumns(10);
		panel.add(textFieldNomExigence);
		calendrierDebut.setBounds(108, 99, 110, 26);
		calendrierDebut.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierDebut);
		calendrierFin.setBounds(316, 99, 110, 26);
		calendrierFin.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierFin);
		
		JLabel lblDateFin = new JLabel("Date Fin");
		lblDateFin.setBounds(241, 99, 65, 26);
		lblDateFin.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblDateFin);
		lblErreur.setBounds(10, 442, 416, 14);
		panel.add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);
		
		description = new JTextArea();
		description.setLineWrap(true);
		JScrollPane scrollPaneDesc = new JScrollPane(description);
		scrollPaneDesc.setBounds(10, 198, 442, 105);
		panel.add(scrollPaneDesc);
		
		JLabel labelPriorite = new JLabel("Priorite");
		labelPriorite.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPriorite.setBounds(10, 139, 65, 26);
		panel.add(labelPriorite);
		
		comboBoxPriorite = new JComboBox();
		comboBoxPriorite.setBounds(108, 141, 110, 26);
		remplirPriorite();
		panel.add(comboBoxPriorite);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 176, 100, 20);
		panel.add(lblDescription);
		
		JLabel lblRaison = new JLabel("Raison");
		lblRaison.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRaison.setBounds(10, 314, 100, 20);
		panel.add(lblRaison);
		
		raison = new JTextArea();
		raison.setLineWrap(true);
		
		JScrollPane scrollPaneRaison = new JScrollPane(raison);
		scrollPaneRaison.setBounds(10, 335, 442, 105);
		panel.add(scrollPaneRaison);

		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnValider.setBounds(573, 516, 89, 31);
		add(btnValider);
		

		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBounds(399, 516, 89, 31);
		add(btnAnnuler);
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		btnValider.addActionListener(list);
		btnAnnuler.addActionListener(list);


	}
	
	private void buildTree(){
		
		vectFonctionnalite = controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(idFonctionnalite);
	//	vectSousFonctionnalite = controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonctionnalite);
		vectAppli=ControllerDBConfiguration.getApplicationArbre();
		vectExigenceFonctionnelle=controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(idSousFonctionnalite);
		String fonctionnalite, sFonctionnalite, exiFonct;
		int i=0;

		if(vectExigenceFonctionnelle.size()>0){
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(vectExigenceFonctionnelle.elementAt(i).getNomAppli()); 
		
			while (i<vectExigenceFonctionnelle.size())
			{
				fonctionnalite=vectExigenceFonctionnelle.elementAt(i).getNomFonct();
				DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(vectExigenceFonctionnelle.elementAt(i).getNomFonct());
				
				while(i<vectExigenceFonctionnelle.size()&&fonctionnalite.equals(vectExigenceFonctionnelle.elementAt(i).getNomFonct()))
				{
					sFonctionnalite=vectExigenceFonctionnelle.elementAt(i).getNomSFonct();
					DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode(vectExigenceFonctionnelle.elementAt(i).getNomSFonct());
						System.out.println(sFonctionnalite);
						while(i<vectExigenceFonctionnelle.size()&& sFonctionnalite.equals(vectExigenceFonctionnelle.elementAt(i).getNomSFonct())
																&& fonctionnalite.equals(vectExigenceFonctionnelle.elementAt(i).getNomFonct()))
						{
							exiFonct=vectExigenceFonctionnelle.elementAt(i).getNomExigence();
							DefaultMutableTreeNode rep3 = new DefaultMutableTreeNode(vectExigenceFonctionnelle.elementAt(i).getNomExigence());
							  
							
							i++;
							rep2.add(rep3);
						}
				i++;
				rep1.add(rep2);
				}
				i++;
				racine.add(rep1);
			}
		
		tree = new JTree(racine);
		tree.setBounds(21, 53, 250, 495);	
		int row = 0; 
		  while (row < tree.getRowCount()) { 
		      tree.expandRow(row); 
		      row++; 
		    } 
		

		tree.setBounds(21, 45, 250, 495);	
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(21, 45, 250, 495);
		this.add(JSP);
	
		}
		else{
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode(nomAppli); 
			
		
		JTree tree = new JTree(racine);
		tree.setBounds(21, 45, 250, 495);	
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(21, 45, 250, 495);
		this.add(JSP);
	
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
			
			if(source== btnAnnuler){
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			controller.gestionFenetreFonctionnalite.fonctionnalite();
				
			}
			
			if(source == btnValider){
				if(textFieldNumExigence.getText()!=null && textFieldNumExigence.getText().length()>0){
					exigenceFonctionnelle.setNumExi(textFieldNumExigence.getText());
					
					if(textFieldNomExigence.getText()!= null && textFieldNomExigence.getText().length()>0 ){
						exigenceFonctionnelle.setNomExigence(textFieldNomExigence.getText());
						exigenceFonctionnelle.setFkSFonct(idSousFonctionnalite);	
					
							if(calendrierDebut.getDate()!=null){
								Date debut=calendrierDebut.getDate();
								String dateDebut = dateFormat.format(debut);
								exigenceFonctionnelle.setDateDebutExi(dateDebut);
								exigenceFonctionnelle.setDateDebutEFRecord(dateDebut);
					
								Date fin=calendrierFin.getDate();
								String dateFin="";
									if(calendrierFin.getDate()!=null){
										dateFin=dateFormat.format(fin);
										exigenceFonctionnelle.setDateFinExi(dateFin);
										exigenceFonctionnelle.setDateFinEFRecord(dateFin);
									}
									else{
										exigenceFonctionnelle.setDateFinExi("20991231");
										exigenceFonctionnelle.setDateFinEFRecord("2099-12-31");
									}
									
									if(comboBoxPriorite.getSelectedIndex()!=0){
										exigenceFonctionnelle.setPrioriteExigence(comboBoxPriorite.getSelectedIndex());
																		
									if(raison.getText()!=null && raison.getText().length()>0){
										exigenceFonctionnelle.setRaisonExigence(raison.getText());
										
										if(description.getText()!=null && description.getText().length()>0){
											exigenceFonctionnelle.setDescriptionExigence(description.getText());
										
											addDataExigenceFonctionnelle.addNewExigenceFonctionnelle(exigenceFonctionnelle);
											model.recupererIdExigenceFonctionnelle.recupererIdExigenceFonctionnelle(exigenceFonctionnelle);
											controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
											int codeSFPasse;
											codeSFPasse=exigenceFonctionnelle.getCodeExigence();
											controller.gestionFenetreExigenceFonctionnelle.modifExigenceFonctionnelle(idFonctionnalite, exigenceFonctionnelle.getFkSFonct(),codeSFPasse, exigenceFonctionnelle.getNomExigence(),true);	
								
										}
										else
										{
											lblErreur.setVisible(true);
											raison.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
											raison.requestFocus();
										}
									}
									else
									{
										lblErreur.setVisible(true);
										description.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
										description.requestFocus();
									}								
									}
							else
							{
								lblErreur.setVisible(true);
								comboBoxPriorite.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								comboBoxPriorite.requestFocus();
							}								
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
						textFieldNomExigence.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textFieldNomExigence.requestFocus();
					}
				}
				else
				{
					lblErreur.setVisible(true);
					textFieldNumExigence.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldNumExigence.requestFocus();					
				}
			}
		}				
	
	}

	private void remplirPriorite(){
		comboBoxPriorite.removeAllItems();
		vectPriorite = controllerDBExigenceFonctionnelle.getPriorite();
		comboBoxPriorite.addItem("--Sélectionnez Direction--");
		for(int i=0; i<this.vectPriorite.size();i++){
			comboBoxPriorite.addItem(vectPriorite.elementAt(i).getNomPriorite());
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
