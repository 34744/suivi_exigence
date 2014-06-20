package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
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
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import model.exigenceFonctionnelleArbre;
import model.fonctionnalite;
import model.fonctionnaliteModelTableau;
import model.majDataCritereSucces;
import model.majDataFonctionnalite;
import model.pointMajModelTableau;
import model.sousFonctionnaliteModelTableau;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ControllerDBConfiguration;
import controller.ControllerDBCritereSucces;
import controller.addDataCritereSucces;
import controller.addDataFonctionnalite;
import controller.addDataSousFonctionnalite;
import controller.controllerDBExigenceFonctionnelle;
import controller.controllerDBFonctionnalite;
import controller.controllerDBMiseAJour;
import controller.controllerDBSousFonctionnalite;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import view.Parametres.MyButtonListener;

import javax.swing.JPanel;
import javax.swing.JPanel;


public class majModif extends JPanel {
	private JFrame frame;
	private JTable table;
	private JTree tree;

	private Vector<model.sousFonctionnaliteArbre> vectSousFonctionnalite = new Vector <model.sousFonctionnaliteArbre>();
	private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private Vector<model.pointMajArbre>vectPointMaj = new Vector<model.pointMajArbre>();
	private fonctionnaliteModelTableau modelFonctionnalite;
	private sousFonctionnaliteModelTableau modelSousFonctionnalite;	
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JButton btnAnnuler = new JButton("Retour");
	private JButton btnValider = new JButton("Valider");
	int idAppli, idFonctionnalite, idFonctionnalite2, idFonctionnalitePassee, codeSousFonctionnalitePassee;
	String nomAppli, nomFonctionnalite, nomSousFonctionnalitePassee, codeSousFonctionnaliteString;
	private fonctionnalite fonctionnalite = new fonctionnalite();
	private pointMajModelTableau modelPointMaj;
	private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JTextField textFieldNumMAJ;
	private JTextField textFieldNumCall;
	private JDateChooser dateProposition= new JDateChooser();
	private JDateChooser dateValidation= new JDateChooser();
	private JButton btnPointAjouter = new JButton("");
	private JButton btnSousFonctionnaliteModifier = new JButton("");
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private JTable tblPoint;
	private JPanel panel;
	private JLabel lblBMC = new JLabel("Num\u00E9ro Call BMC");
	private JLabel lblNumMaj = new JLabel("Num\u00E9ro mise-\u00E0-jour");
	private JLabel lblDateValid = new JLabel("Validation");
	private JLabel lblNotification = new JLabel("Notification");
	private JLabel lblPoint = new JLabel("Liste des points");
	private JDateChooser dateNotification = new JDateChooser();
	private JLabel lblProduction = new JLabel("Production");
	private JDateChooser dateProduction = new JDateChooser();
	private Vector<model.miseAJourArbre> vectMAJ = new Vector <model.miseAJourArbre>();
	private int idMAJ;
	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public majModif(int idMaj) {
		
		this.idMAJ=idMaj;
		model.miseAJourArbre miseAJourArbre = controllerDBMiseAJour.getMiseAJourArbre(idMAJ);
		nomAppli=miseAJourArbre.getNomApplication();
		idAppli=miseAJourArbre.getFkApplication();
		setBackground(new Color(46, 139, 87));
		setLayout(null);
	//	buildTree();
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

			}
		
		else
			{
			tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiableG41.png")));
			
			}
		toolBar.add(tglbtnModifier);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(220, 53, 556, 453);
		add(panel);
		panel.setLayout(null);
		

		lblBMC.setBounds(228, 82, 127, 26);
		lblBMC.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblBMC);
		

		lblNumMaj.setBounds(10, 8, 208, 26);
		lblNumMaj.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNumMaj);
		
		JLabel lblDatePropo = new JLabel("Proposition");
		lblDatePropo.setBounds(10, 45, 85, 26);
		lblDatePropo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblDatePropo);
		
		textFieldNumMAJ = new JTextField();
		textFieldNumMAJ.setBounds(169, 8, 240, 26);
		panel.add(textFieldNumMAJ);
		textFieldNumMAJ.setColumns(10);

		
		textFieldNumCall = new JTextField();
		textFieldNumCall.setBounds(365, 84, 119, 26);
		textFieldNumCall.setColumns(10);
		panel.add(textFieldNumCall);
		dateProposition.setBounds(108, 45, 110, 26);
		dateProposition.setDateFormatString("dd/MM/yyyy");
		panel.add(dateProposition);
		dateValidation.setBounds(108, 82, 110, 26);
		dateValidation.setDateFormatString("dd/MM/yyyy");
		panel.add(dateValidation);
		
		
		lblDateValid.setBounds(10, 82, 85, 26);
		lblDateValid.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblDateValid);
		lblErreur.setBounds(10, 435, 416, 14);
		panel.add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);
		
		idFonctionnalitePassee=idFonctionnalite;
		vectPointMaj = controller.controllerDBPointMaj.getPointMajVecteurArbre(idMAJ);
		modelPointMaj = new pointMajModelTableau(vectPointMaj);
		tblPoint = new JTable(modelPointMaj);
		tblPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tblPoint.getSelectedRow()!=-1){
					nomSousFonctionnalitePassee=tblPoint.getValueAt(tblPoint.getSelectedRow(), 1).toString();
					codeSousFonctionnaliteString=tblPoint.getValueAt(tblPoint.getSelectedRow(),3).toString();
					codeSousFonctionnalitePassee=Integer.parseInt(codeSousFonctionnaliteString);
					if(arg0.getClickCount()==2){
					//	modifSousFonctionnalite();
					}
					
				}
			}

			
		});
	
		tblPoint.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPoint.setColumnSelectionAllowed(true);
		tblPoint.setToolTipText("S\u00E9lectionnez le point de mise à jour");
		tblPoint.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tblPoint.setForeground(Color.WHITE);
		tblPoint.setFont(new Font("Tahoma", Font.BOLD, 13));
		tblPoint.setBackground(new Color(211, 211, 211));
		tblPoint.setAutoCreateRowSorter(true);
		tblPoint.getRowSorter().toggleSortOrder(0);
		tblPoint.setAutoCreateRowSorter(false);
		tblPoint.getColumnModel().getColumn(0).setPreferredWidth(240);
		tblPoint.getColumnModel().getColumn(1).setPreferredWidth(60);
		tblPoint.getColumnModel().getColumn(2).setPreferredWidth(60);
		tblPoint.getColumnModel().getColumn(3).setPreferredWidth(75);
		tblPoint.getColumnModel().getColumn(3).setPreferredWidth(75);
		tblPoint.setBounds(0, 0, 448, 154);
		//tblPoint.setDefaultRenderer(Object.class, new tableSousFonctionnaliteRenderer());
		JScrollPane scrollPane = new JScrollPane(tblPoint);
		scrollPane.setBounds(10, 244, 504, 154);
		//scrollPane.setColumnHeaderView(tblSousFonctionnalite);

		panel.add(scrollPane);
		

		lblPoint.setBounds(10, 207, 248, 26);
		lblPoint.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(lblPoint);
		
		btnPointAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
		btnPointAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPointAjouter.setBounds(524, 298, 22, 23);
		panel.add(btnPointAjouter);
		
		btnSousFonctionnaliteModifier.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
		btnSousFonctionnaliteModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSousFonctionnaliteModifier.setBounds(524, 336, 22, 23);
		panel.add(btnSousFonctionnaliteModifier);
		

		lblNotification.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNotification.setBounds(10, 119, 85, 26);
		panel.add(lblNotification);
		
	
		dateNotification.setDateFormatString("dd/MM/yyyy");
		dateNotification.setBounds(108, 119, 110, 26);
		panel.add(dateNotification);
		
		
		lblProduction.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduction.setBounds(10, 156, 85, 26);
		panel.add(lblProduction);
		
		dateProduction.setDateFormatString("dd/MM/yyyy");
		dateProduction.setBounds(108, 156, 110, 26);
		panel.add(dateProduction);
		
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnValider.setBounds(593, 518, 89, 31);
		add(btnValider);
		

		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBounds(414, 518, 89, 31);
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
		btnPointAjouter.addActionListener(list);
		btnSousFonctionnaliteModifier.addActionListener(list);
		
		remplirMiseAJour(idMAJ);
		buildTree();
	}

	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
			
			if(source == btnAnnuler){
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			controller.gestionFenetreFonctionnalite.fonctionnalite();
			}
			
			if(source == btnPointAjouter){
				nomFonctionnalite=textFieldNumCall.getText();
				controller.gestionFenetreSousFonctionnalite.eraseContainerPaneMainJFrame();
				controller.gestionFenetreSousFonctionnalite.ajoutSousFonctionnalite(idFonctionnalite, nomAppli, idAppli,nomFonctionnalite);
			}
			
		/*	if(source == btnValider){
				if(textFieldNumFonct.getText()!=null && textFieldNumFonct.getText().length()>0){
					fonctionnalite.setNumFonct(textFieldNumFonct.getText());
					
					if(textFieldNomFonctionnalite.getText()!= null && textFieldNomFonctionnalite.getText().length()>0 ){
						fonctionnalite.setNomFonctionnalite(textFieldNomFonctionnalite.getText());
						fonctionnalite.setFkAppli(idAppli);	
					
						if(textArea.getText()!=null && textArea.getText().length()>0){
							fonctionnalite.setDescriptionFonctionnalite(textArea.getText());
							fonctionnalite.setDescriptionFonctionnalite(fonctionnalite.getDescriptionFonctionnalite().replaceAll("'", "''"));
					
								if(calendrierDebut.getDate()!=null){
									Date debut=calendrierDebut.getDate();
									String dateDebut = dateFormat.format(debut);
									fonctionnalite.setDateDebutFonct(dateDebut);
					
									Date fin=calendrierFin.getDate();
									String dateFin="";
										if(calendrierFin.getDate()!=null){
											dateFin=dateFormat.format(fin);
											fonctionnalite.setDateFinFonct(dateFin);
										}
										else{
											fonctionnalite.setDateFinFonct("20991231");
										}
									
									
										fonctionnalite.setIdFonctionnalite(idFonctionnalite);
										majDataFonctionnalite.majFonctionnalite(fonctionnalite);
										controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
										controller.gestionFenetreFonctionnalite.modifFonctionnalite(idFonctionnalite, fonctionnalite.getFkAppli(), nomAppli);	
								}
							else {
								lblErreur.setVisible(true);
								calendrierDebut.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								calendrierDebut.requestFocus();
								}
						}
							else
							{
								lblErreur.setVisible(true);
								calendrierFin.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								calendrierDebut.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								calendrierFin.requestFocus();
							}
						}
						
						else
						{
							lblErreur.setVisible(true);
							textArea.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
							textArea.requestFocus();
						}
					}
					else
					{
						lblErreur.setVisible(true);
						textFieldNomFonctionnalite.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textFieldNomFonctionnalite.requestFocus();
					}
				}
				else
				{
					lblErreur.setVisible(true);
					textFieldNumFonct.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldNumFonct.requestFocus();					
				}
			}
		*/}
	}
	private void buildTree(){
	
	vectMAJ = controllerDBMiseAJour.getMiseAJourVecteurIntArbre(idAppli);
	System.out.println("taille vect"+vectMAJ.size());
	vectAppli=ControllerDBConfiguration.getApplicationArbre();

	int i=0;
	
	DefaultMutableTreeNode racine = new DefaultMutableTreeNode(nomAppli); 
	if(vectMAJ.size()>0){
	
		while (i<vectMAJ.size())
		{
			
			DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(vectMAJ.elementAt(i).getNumMAJ());
			i++;
			racine.add(rep1);
		}
	
	final JTree tree = new JTree(racine);
	tree.setBounds(5, 53, 200, 453);	
	JScrollPane JSP = new JScrollPane(tree);
	JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	JSP.setBounds(5, 53, 200, 453);
	this.add(JSP);

	
	/*else{
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(nomAppli); 
		
	
	JTree tree = new JTree(racine);
	tree.setBounds(21, 53, 250, 453);	
	JScrollPane JSP = new JScrollPane(tree);
	JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	JSP.setBounds(21, 53, 250, 453);
	this.add(JSP);

	}*/
	int row = 0; 
    while (row < tree.getRowCount()) { 
      tree.expandRow(row); 
      row++; 
    } 
	tree.addTreeSelectionListener(new TreeSelectionListener() {
		
		@Override
		public void valueChanged(TreeSelectionEvent event) {
			// TODO Auto-generated method stub
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			if(node.isLeaf()){
				model.miseAJourArbre miseAJourArbre = controllerDBMiseAJour.getMiseAJourArbre(tree.getLastSelectedPathComponent().toString());
				int idMajours=miseAJourArbre.getIdMiseAJour();
				remplirMiseAJour(idMajours);
			}
		}
	});
	}
}
	private void remplirFonctionnalite(String nomFonctionnalite){
		SimpleDateFormat formater99 = null;
		formater99 =new SimpleDateFormat ("yyyy-MM-dd");
		Date dateFinale=null;
		try {
			dateFinale = formater99.parse("2099-12-31");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(nomFonctionnalite);
		textFieldNumMAJ.setText(fonctionnaliteArbre.getNumFonct());
		textFieldNumCall.setText(fonctionnaliteArbre.getNomFonctionnalite());
		idFonctionnalite=fonctionnaliteArbre.getIdFonctionnalite();
		dateProposition.setDate(fonctionnaliteArbre.getDateDebutFonct());
		idFonctionnalitePassee=idFonctionnalite;
		if(fonctionnaliteArbre.getDateFinFonct().compareTo(dateFinale)==0){
			dateValidation.setDate(null);
		}
		else{
			dateValidation.setDate(fonctionnaliteArbre.getDateFinFonct());
		}
		//buildTree();
	}	
	private void remplirFonctionnaliteTree(String nomFonctionnalite){

		String nomFonctionnaliteTree;
		SimpleDateFormat formater99 = null;
		formater99 =new SimpleDateFormat ("yyyy-MM-dd");
		Date dateFinale=null;
		try {
			dateFinale = formater99.parse("2099-12-31");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		nomFonctionnaliteTree=nomFonctionnalite;
		model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(nomFonctionnaliteTree);
		textFieldNumMAJ.setText(fonctionnaliteArbre.getNumFonct());
		textFieldNumCall.setText(fonctionnaliteArbre.getNomFonctionnalite());
		
		idFonctionnalite=fonctionnaliteArbre.getIdFonctionnalite();
		dateProposition.setDate(fonctionnaliteArbre.getDateDebutFonct());
		idFonctionnalitePassee=idFonctionnalite;
		if(fonctionnaliteArbre.getDateFinFonct().compareTo(dateFinale)==0){
			dateValidation.setDate(null);
		}
		else{
			dateValidation.setDate(fonctionnaliteArbre.getDateFinFonct());
		}
		controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
		controller.gestionFenetreFonctionnalite.modifFonctionnalite(idFonctionnalite, fonctionnaliteArbre.getFkAppli(), nomAppli);	
	}
	
	private void remplirMiseAJour(int idMAJ){
		int idMaj=idMAJ;

		SimpleDateFormat formater99 = null;
		formater99 =new SimpleDateFormat ("yyyy-MM-dd");
		Date dateFinale=null;
		
		try {
			dateFinale = formater99.parse("2099-12-31");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.miseAJourArbre miseAJourArbre = controllerDBMiseAJour.getMiseAJourArbre(idMaj);
		textFieldNumMAJ.setText(miseAJourArbre.getNumMAJ());
		String call = miseAJourArbre.getNumCallBmc();
		if(call.length()==4 && call.equals("null")){
			textFieldNumCall.setText(" ");
		}
		else{
		textFieldNumCall.setText(miseAJourArbre.getNumCallBmc());
		}
		
		if(miseAJourArbre.getDateProposition().compareTo(dateFinale)==0){
			dateProposition.setDate(null);
		}
		else{
			dateProposition.setDate(miseAJourArbre.getDateProposition());
		}
		
		if(miseAJourArbre.getDateValidation().compareTo(dateFinale)==0){
			dateValidation.setDate(null);
		}
		else{
			dateValidation.setDate(miseAJourArbre.getDateValidation());
		}
		
		if(miseAJourArbre.getDateNotification().compareTo(dateFinale)==0){
			dateNotification.setDate(null);
		}
		else{
			dateNotification.setDate(miseAJourArbre.getDateNotification());
		}
		
		if(miseAJourArbre.getDateMiseProd().compareTo(dateFinale)==0){
			dateProduction.setDate(null);
		}
		else{
			dateProduction.setDate(miseAJourArbre.getDateMiseProd());
		}
		System.out.println("remplir maj");
	}	
	private void modifSousFonctionnalite() {
		// TODO Auto-generated method stub
		System.out.println(nomSousFonctionnalitePassee+ idFonctionnalite + "code"+codeSousFonctionnalitePassee+"nonSF"+nomSousFonctionnalitePassee);
		controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
		controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(idFonctionnalite, codeSousFonctionnalitePassee, nomSousFonctionnalitePassee);	
	
	}
}

