package view;
import javax.sound.midi.ControllerEventListener;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
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

import model.exigenceFonctionnelle;
import model.exigenceFonctionnelleModelTableau;
import model.fonctionnalite;
import model.fonctionnaliteArbre;
import model.fonctionnaliteModelTableau;
import model.majDataFonctionnalite;
import model.majDataSousFonctionnalite;
import model.sousFonctionnaliteModelTableau;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ControllerDBConfiguration;
import controller.addDataFonctionnalite;
import controller.controllerDBExigenceFonctionnelle;
import controller.controllerDBFonctionnalite;
import controller.controllerDBSousFonctionnalite;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.xml.datatype.Duration;

import view.Parametres.MyButtonListener;

public class exigenceFonctionnelleViewModif extends JPanel {

	/**
	 * Create the panel.
	 */

		private JFrame frame;
		private JTable table;
		private JTree tree;
		private Vector<model.exigenceFonctionnelleArbre> vectExigenceFonctionnelle = new Vector<model.exigenceFonctionnelleArbre>();
		private Vector<model.sousFonctionnaliteArbre> vectSousFonctionnalite = new Vector <model.sousFonctionnaliteArbre>();
		private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
		private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
		private fonctionnaliteModelTableau modelFonctionnalite;
		private sousFonctionnaliteModelTableau modelSousFonctionnalite;	
		private exigenceFonctionnelleModelTableau modelExigenceFonctionnelle;
		private JButton btnHome = new JButton("Accueil");
		private JButton btnRapports = new JButton("Rapports");
		private JButton btnSoftware = new JButton("Application");
		private JButton btnConfig = new JButton("Configuration");
		private JButton btnUpdate = new JButton("Mise \u00E0 jour");
		private JButton btnAnnuler = new JButton("Retour");
		private JButton btnValider = new JButton("Valider");
		int idAppli, idFonctionnalite, idFonctionnalite2, codeExigenceFonctionnelle, idSousFonctionnalite, codeExigence;
		String nomAppli, nomSousFonctionnalite, nomExigenceFonctionnelle, nomExigence;
		private fonctionnalite fonctionnalite = new fonctionnalite();
		private exigenceFonctionnelle exigenceFonctionnelle = new exigenceFonctionnelle();
		private model.sousFonctionnalite sousFonctionnalite= new model.sousFonctionnalite();
		private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
		private JTextField textFieldNumExigenceFonctionnelle;
		private JTextField textFieldNomExigenceFonctionnelle;
		private JDateChooser calendrierDebut= new JDateChooser();
		private JDateChooser calendrierFin= new JDateChooser();
		private JButton btnCritereSuccesAjouter = new JButton("");
		private JButton btnCritereSuccesModifier = new JButton("");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		private JTable tblCritereSucces;
		private Date dateDuJour = new Date();
		private JScrollPane scrollPane;
		private JPanel panel;
		private JPanel panelCS;

		/**
		 * Create the panel.
		 * @wbp.parser.constructor
		 */
		public exigenceFonctionnelleViewModif(String nomExigenceFonctionnelle,int codeExigenceFonctionnelle, String nomSousFonctionnalite) {
			
			vectFonctionnalite = controllerDBFonctionnalite.getNomFonctionnaliteVecteurArbre(nomSousFonctionnalite);
			
			this.nomExigenceFonctionnelle=nomExigenceFonctionnelle;
			this.codeExigenceFonctionnelle=codeExigenceFonctionnelle;
			this.nomSousFonctionnalite=nomSousFonctionnalite;

			//model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(nomFonctionnalite);
			//idFonctionnalite=fonctionnaliteArbre.getIdFonctionnalite();
			setBackground(new Color(176, 196, 222));
			setLayout(null);
			buildTree();
			JToolBar toolBar = new JToolBar();
			toolBar.setBounds(10, 1, 794, 41);
			toolBar.setFloatable(false);
			toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
			toolBar.setForeground(Color.WHITE);
			toolBar.setBackground(new Color(211, 211, 211));
			add(toolBar);
			

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
			panel.setBounds(283, 49, 495, 453);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblNomSousFonctionnalite = new JLabel("Nom de la sous fonctionnalit\u00E9");
			lblNomSousFonctionnalite.setBounds(10, 35, 232, 26);
			lblNomSousFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNomSousFonctionnalite);
			
			JLabel lblNumSousFonctionnalite = new JLabel("Num\u00E9ro de la sous fonctionnalit\u00E9");
			lblNumSousFonctionnalite.setBounds(10, 8, 232, 26);
			lblNumSousFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNumSousFonctionnalite);
			
			JLabel lblDateDebut = new JLabel("Date Debut");
			lblDateDebut.setBounds(10, 62, 85, 26);
			lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblDateDebut);
			
			textFieldNumExigenceFonctionnelle = new JTextField();
			textFieldNumExigenceFonctionnelle.setBounds(265, 8, 38, 26);
			panel.add(textFieldNumExigenceFonctionnelle);
			textFieldNumExigenceFonctionnelle.setColumns(10);

			
			textFieldNomExigenceFonctionnelle = new JTextField();
			textFieldNomExigenceFonctionnelle.setBounds(265, 35, 208, 26);
			textFieldNomExigenceFonctionnelle.setColumns(10);
			panel.add(textFieldNomExigenceFonctionnelle);
			calendrierDebut.setBounds(108, 62, 110, 26);
			calendrierDebut.setDateFormatString("dd/MM/yyyy");
			panel.add(calendrierDebut);
			calendrierFin.setBounds(316, 62, 110, 26);
			calendrierFin.setDateFormatString("dd/MM/yyyy");
			panel.add(calendrierFin);
			
			JLabel lblDateFin = new JLabel("Date Fin");
			lblDateFin.setBounds(238, 62, 65, 26);
			lblDateFin.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblDateFin);
			lblErreur.setBounds(10, 435, 416, 14);
			panel.add(lblErreur);
			lblErreur.setVisible(false);
			

			lblErreur.setForeground(Color.RED);
			

			vectExigenceFonctionnelle = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeExigenceFonctionnelle);
			modelExigenceFonctionnelle = new exigenceFonctionnelleModelTableau(vectExigenceFonctionnelle);
			

			tblCritereSucces = new JTable(modelExigenceFonctionnelle);
			
			tblCritereSucces.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblCritereSucces.setColumnSelectionAllowed(true);
			tblCritereSucces.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
			tblCritereSucces.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			tblCritereSucces.setForeground(Color.WHITE);
			tblCritereSucces.setFont(new Font("Tahoma", Font.BOLD, 13));
			tblCritereSucces.setBackground(new Color(211, 211, 211));
			tblCritereSucces.setAutoCreateRowSorter(true);
			tblCritereSucces.getRowSorter().toggleSortOrder(0);
			tblCritereSucces.setAutoCreateRowSorter(false);
			tblCritereSucces.getColumnModel().getColumn(0).setPreferredWidth(60);
			tblCritereSucces.getColumnModel().getColumn(1).setPreferredWidth(255);
			tblCritereSucces.getColumnModel().getColumn(2).setPreferredWidth(55);
			tblCritereSucces.getColumnModel().getColumn(3).setPreferredWidth(30);
			tblCritereSucces.setBounds(0, 0, 200, 154);
			
			scrollPane = new JScrollPane(tblCritereSucces);
			scrollPane.setBounds(0, 0, 455, 220);
			//scrollPane.setColumnHeaderView(tblSousFonctionnalite);
			panelCS=new JPanel();
			panelCS.setLayout(null);
			panelCS.setBounds(5,167,455,220);
			panelCS.add(scrollPane);
			panel.add(panelCS);
			
			JLabel lblExigencesFonctionnelles = new JLabel("Liste des exigences fonctionnelles");
			lblExigencesFonctionnelles.setBounds(10, 130, 248, 26);
			lblExigencesFonctionnelles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panel.add(lblExigencesFonctionnelles);
			
			btnCritereSuccesAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
			btnCritereSuccesAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnCritereSuccesAjouter.setBounds(463, 242, 22, 23);
			panel.add(btnCritereSuccesAjouter);
			
			btnCritereSuccesModifier.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
			btnCritereSuccesModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnCritereSuccesModifier.setBounds(463, 276, 22, 23);
			panel.add(btnCritereSuccesModifier);
			
			btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnValider.setBounds(594, 513, 89, 31);
			add(btnValider);
			

			btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAnnuler.setBounds(417, 513, 89, 31);
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
			btnCritereSuccesAjouter.addActionListener(list);
			btnCritereSuccesModifier.addActionListener(list);
			
			remplirSousFonctionnalite(nomExigenceFonctionnelle);

		}
		
		public exigenceFonctionnelleViewModif(int idFonctionnalite, int codeFonctionnalite,String nomSousFonctionnalite) {
			// TODO Auto-generated constructor stub
			
			vectFonctionnalite = controllerDBFonctionnalite.getNumFonctionnaliteVecteurArbre(idFonctionnalite);
			this.idFonctionnalite=idFonctionnalite;
			this.codeExigenceFonctionnelle=codeFonctionnalite;
			this.nomSousFonctionnalite=nomSousFonctionnalite;
			System.out.println("idFonct"+idFonctionnalite);
			setBackground(new Color(176, 196, 222));
			setLayout(null);
			buildTree();
			JToolBar toolBar = new JToolBar();
			toolBar.setBounds(10, 1, 794, 41);
			toolBar.setFloatable(false);
			toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
			toolBar.setForeground(Color.WHITE);
			toolBar.setBackground(new Color(211, 211, 211));
			add(toolBar);
			

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
			panel.setBounds(283, 53, 495, 453);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblNomSousFonctionnalite = new JLabel("Nom de la sous fonctionnalit\u00E9");
			lblNomSousFonctionnalite.setBounds(10, 35, 232, 26);
			lblNomSousFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNomSousFonctionnalite);
			
			JLabel lblNumSousFonctionnalite = new JLabel("Num\u00E9ro de la sous fonctionnalit\u00E9");
			lblNumSousFonctionnalite.setBounds(10, 8, 232, 26);
			lblNumSousFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNumSousFonctionnalite);
			
			JLabel lblDateDebut = new JLabel("Date Debut");
			lblDateDebut.setBounds(10, 62, 85, 26);
			lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblDateDebut);
			
			textFieldNumExigenceFonctionnelle = new JTextField();
			textFieldNumExigenceFonctionnelle.setBounds(265, 8, 38, 26);
			panel.add(textFieldNumExigenceFonctionnelle);
			textFieldNumExigenceFonctionnelle.setColumns(10);

			
			textFieldNomExigenceFonctionnelle = new JTextField();
			textFieldNomExigenceFonctionnelle.setBounds(265, 35, 208, 26);
			textFieldNomExigenceFonctionnelle.setColumns(10);
			panel.add(textFieldNomExigenceFonctionnelle);
			calendrierDebut.setBounds(108, 62, 110, 26);
			calendrierDebut.setDateFormatString("dd/MM/yyyy");
			panel.add(calendrierDebut);
			calendrierFin.setBounds(316, 62, 110, 26);
			calendrierFin.setDateFormatString("dd/MM/yyyy");
			panel.add(calendrierFin);
			
			JLabel lblDateFin = new JLabel("Date Fin");
			lblDateFin.setBounds(238, 62, 65, 26);
			lblDateFin.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblDateFin);
			lblErreur.setBounds(10, 435, 416, 14);
			panel.add(lblErreur);
			lblErreur.setVisible(false);
			

			lblErreur.setForeground(Color.RED);
			
			vectExigenceFonctionnelle = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeExigenceFonctionnelle);
			modelExigenceFonctionnelle = new exigenceFonctionnelleModelTableau(vectExigenceFonctionnelle);
			

			tblCritereSucces = new JTable(modelExigenceFonctionnelle);
			
			tblCritereSucces.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblCritereSucces.setColumnSelectionAllowed(true);
			tblCritereSucces.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
			tblCritereSucces.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			tblCritereSucces.setForeground(Color.WHITE);
			tblCritereSucces.setFont(new Font("Tahoma", Font.BOLD, 13));
			tblCritereSucces.setBackground(new Color(211, 211, 211));
			tblCritereSucces.setAutoCreateRowSorter(true);
			tblCritereSucces.getRowSorter().toggleSortOrder(0);
			tblCritereSucces.setAutoCreateRowSorter(false);
			tblCritereSucces.getColumnModel().getColumn(0).setPreferredWidth(60);
			tblCritereSucces.getColumnModel().getColumn(1).setPreferredWidth(255);
			tblCritereSucces.getColumnModel().getColumn(2).setPreferredWidth(55);
			tblCritereSucces.getColumnModel().getColumn(3).setPreferredWidth(30);
			//tblExigenceFonctionnelle.setBounds(0, 0, 200, 154);
			scrollPane = new JScrollPane(tblCritereSucces);
			scrollPane.setBounds(0, 0,455, 220);
			panelCS=new JPanel();
			panelCS.setLayout(null);
			panelCS.setBounds(5,167,455,220);
			panelCS.add(scrollPane);
			panel.add(panelCS);
			
			JLabel lblExigencesFonctionnelles = new JLabel("Liste des exigences fonctionnelles");
			lblExigencesFonctionnelles.setBounds(10, 130, 248, 26);
			lblExigencesFonctionnelles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panel.add(lblExigencesFonctionnelles);
			
			btnCritereSuccesAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
			btnCritereSuccesAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnCritereSuccesAjouter.setBounds(463, 242, 22, 23);
			panel.add(btnCritereSuccesAjouter);
			
			btnCritereSuccesModifier.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
			btnCritereSuccesModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnCritereSuccesModifier.setBounds(463, 276, 22, 23);
			panel.add(btnCritereSuccesModifier);
			
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
			btnCritereSuccesAjouter.addActionListener(list);
			btnCritereSuccesModifier.addActionListener(list);
			
			remplirSousFonctionnalite(nomSousFonctionnalite);
		}

		private void buildTree(){
			vectFonctionnalite = controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(idFonctionnalite);
			vectSousFonctionnalite = controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonctionnalite);
			vectAppli=ControllerDBConfiguration.getApplicationArbre();
			vectExigenceFonctionnelle=controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeExigenceFonctionnelle);
			String fonctionnalite, sFonctionnalite, exiFonct;
			int i=0;
			if(vectExigenceFonctionnelle.size()>0){
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode(vectExigenceFonctionnelle.elementAt(i).getNomAppli()); 
			
				while (i<vectFonctionnalite.size())
				{
					fonctionnalite=vectFonctionnalite.elementAt(i).getNomFonctionnalite();
					DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(vectFonctionnalite.elementAt(i).getNomFonctionnalite());
					
					while(i<vectSousFonctionnalite.size()&& fonctionnalite.equals(vectSousFonctionnalite.elementAt(i).getNomFonct()))
					{
						sFonctionnalite=vectSousFonctionnalite.elementAt(i).getNomSFonct();
						DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode(vectSousFonctionnalite.elementAt(i).getNomSFonct());
							
							while(i<vectExigenceFonctionnelle.size()&& sFonctionnalite.equals(vectExigenceFonctionnelle.elementAt(i).getNomSFonct()))
							{
								sFonctionnalite=vectExigenceFonctionnelle.elementAt(i).getNomSFonct();
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
			JScrollPane JSP = new JScrollPane(tree);
			JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JSP.setBounds(21, 53, 250, 495);
			this.add(JSP);
		
			}/*
			else{
				DefaultMutableTreeNode racine = new DefaultMutableTreeNode(nomAppli); 
				
			
			JTree tree = new JTree(racine);
			tree.setBounds(21, 53, 250, 495);	
			JScrollPane JSP = new JScrollPane(tree);
			JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JSP.setBounds(21, 53, 250, 495);
			this.add(JSP);
		
			}*/
			
			tree.addTreeSelectionListener(new TreeSelectionListener() {
				
				@Override
				public void valueChanged(TreeSelectionEvent event) {
					// TODO Auto-generated method stub
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					if(node.isLeaf()){
					remplirFonctionnaliteTree(tree.getLastSelectedPathComponent().toString());
					}
				}
			});
}
		

		private class MyButtonListener implements ActionListener{
			
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
				
				if(source == btnCritereSuccesAjouter){
					
					controller.gestionFenetreSousFonctionnalite.eraseContainerPaneMainJFrame();
					controller.gestionFenetreExigenceFonctionnelle.ajoutExigenceFonctionnnelle(codeExigenceFonctionnelle, idFonctionnalite, idAppli, nomExigenceFonctionnelle, nomAppli, nomSousFonctionnalite);
				}
				
				if(source == btnValider){
					
					if(textFieldNumExigenceFonctionnelle.getText()!=null && textFieldNumExigenceFonctionnelle.getText().length()>0){
						sousFonctionnalite.setNumSFonct(textFieldNumExigenceFonctionnelle.getText());
						
						if(textFieldNomExigenceFonctionnelle.getText()!= null && textFieldNomExigenceFonctionnelle.getText().length()>0 ){
							sousFonctionnalite.setNomSFonct(textFieldNomExigenceFonctionnelle.getText());
							sousFonctionnalite.setCodeSFonct(codeExigenceFonctionnelle);	
							
								//if(calendrierFin.getDate()!=null){
									//if(calendrierDebut.getDate().before(calendrierFin.getDate())){
										
										if(calendrierDebut.getDate()!=null){
										
										Date debut=calendrierDebut.getDate();
										String dateDebut = dateFormat.format(debut);
										String dateJour = dateFormat.format(dateDuJour);
										sousFonctionnalite.setDateDebutSFonct(dateDebut);
										sousFonctionnalite.setDateDebutSFRecord(dateJour);
										sousFonctionnalite.setDateFinSFRecord("2099-12-31");
										Date fin=calendrierFin.getDate();
										String dateFin="";
											if(calendrierFin.getDate()!=null){
												dateFin=dateFormat.format(fin);
												sousFonctionnalite.setDateFinSFonct(dateFin);
											}
											else{
												sousFonctionnalite.setDateFinSFonct("2099-12-31");
											}
										
											sousFonctionnalite.setFkFonct(idFonctionnalite);
											sousFonctionnalite.setIdSousFonct(idSousFonctionnalite);
											majDataSousFonctionnalite.majSousFonctionnalite(sousFonctionnalite);
											controller.addDataSousFonctionnalite.addNewSousFonctionnalite(sousFonctionnalite);
											controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
											controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(idFonctionnalite, sousFonctionnalite.getCodeSFonct(), sousFonctionnalite.getNomSFonct());	
											remplirSousFonctionnalite(sousFonctionnalite.getNomSFonct());
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
							textFieldNomExigenceFonctionnelle.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
							textFieldNomExigenceFonctionnelle.requestFocus();
						}
					}
					else
					{
						lblErreur.setVisible(true);
						textFieldNumExigenceFonctionnelle.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textFieldNumExigenceFonctionnelle.requestFocus();					
					}
				}
			}				
			


			
	
		
		private void remplirSousFonctionnalite(String nomSousFonctionnalite){
			SimpleDateFormat formater99 = null;
			formater99 =new SimpleDateFormat ("yyyy-MM-dd");
			Date dateFinale=null;
			try {
				dateFinale = formater99.parse("2099-12-31");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.nomExigenceFonctionnelle=nomSousFonctionnalite;
			model.sousFonctionnaliteArbre sousFonctionnaliteArbre = controllerDBSousFonctionnalite.getSousFonctionnaliteArbre(nomSousFonctionnalite);
			idSousFonctionnalite=sousFonctionnaliteArbre.getIdSousFonct();
			textFieldNumExigenceFonctionnelle.setText(sousFonctionnaliteArbre.getNumSFonct());
			textFieldNomExigenceFonctionnelle.setText(sousFonctionnaliteArbre.getNomSFonct());
			//codeSousFonctionnalite=sousFonctionnaliteArbre.getCodeSFonct();
			calendrierDebut.setDate(sousFonctionnaliteArbre.getDateDebutSFonct());
			
			if(sousFonctionnaliteArbre.getDateFinSFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(sousFonctionnaliteArbre.getDateFinSFonct());
			}
		}	
		
		private void remplirFonctionnaliteTree(String nomSousFonctionnalite){
			panelCS.removeAll();
			String nomSousFonctionnaliteTree;
			SimpleDateFormat formater99 = null;
			formater99 =new SimpleDateFormat ("yyyy-MM-dd");
			Date dateFinale=null;
			try {
				dateFinale = formater99.parse("2099-12-31");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			nomSousFonctionnaliteTree=nomSousFonctionnalite;
			System.out.println("nom SF"+ nomSousFonctionnaliteTree);
			model.sousFonctionnaliteArbre sousFonctionnaliteArbre = controllerDBSousFonctionnalite.getSousFonctionnaliteArbre(nomSousFonctionnaliteTree);
			textFieldNumExigenceFonctionnelle.setText(sousFonctionnaliteArbre.getCodeSFonct());
			textFieldNomExigenceFonctionnelle.setText(sousFonctionnaliteArbre.getNomSFonct());
	
			//codeSousFonctionnalite=sousFonctionnaliteArbre.getCodeSFonct()
			calendrierDebut.setDate(sousFonctionnaliteArbre.getDateDebutSFonct());
			
			if(sousFonctionnaliteArbre.getDateFinSFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(sousFonctionnaliteArbre.getDateFinSFonct());
			}
			int codeSousFonctionnalitePassee= Integer.parseInt(sousFonctionnaliteArbre.getCodeSFonct());
			
			
			vectExigenceFonctionnelle = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeSousFonctionnalitePassee);
			modelExigenceFonctionnelle = new exigenceFonctionnelleModelTableau(vectExigenceFonctionnelle);
			

			tblCritereSucces = new JTable(modelExigenceFonctionnelle);
			
			tblCritereSucces.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblCritereSucces.setColumnSelectionAllowed(true);
			tblCritereSucces.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
			tblCritereSucces.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			tblCritereSucces.setForeground(Color.WHITE);
			tblCritereSucces.setFont(new Font("Tahoma", Font.BOLD, 13));
			tblCritereSucces.setBackground(new Color(211, 211, 211));
			tblCritereSucces.setAutoCreateRowSorter(true);
			tblCritereSucces.getRowSorter().toggleSortOrder(0);
			tblCritereSucces.setAutoCreateRowSorter(false);
			tblCritereSucces.getColumnModel().getColumn(0).setPreferredWidth(60);
			tblCritereSucces.getColumnModel().getColumn(1).setPreferredWidth(255);
			tblCritereSucces.getColumnModel().getColumn(2).setPreferredWidth(55);
			tblCritereSucces.getColumnModel().getColumn(3).setPreferredWidth(30);
			tblCritereSucces.setBounds(0, 0, 448, 154);
			JScrollPane scrollPane = new JScrollPane(tblCritereSucces);
			scrollPane.setBounds(0,0, 448, 217);
			scrollPane.setVisible(true);
			panelCS.add(scrollPane);
			panel.add(panelCS);
			panelCS.repaint();
			
			/*
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(sousFonctionnaliteArbre.getFkFonct(), codeSousFonctionnalitePassee, sousFonctionnaliteArbre.getNomSFonct());	
			*/
		}
		
		private void remplirFonctionnaliteId(int idFonctionnalite2){
			SimpleDateFormat formater99 = null;
			formater99 =new SimpleDateFormat ("yyyy-MM-dd");
			Date dateFinale=null;
			try {
				dateFinale = formater99.parse("2099-12-31");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.idFonctionnalite2=idFonctionnalite2;
			this.idFonctionnalite=idFonctionnalite2;
			model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(idFonctionnalite2);
			textFieldNumExigenceFonctionnelle.setText(fonctionnaliteArbre.getNumFonct());
			textFieldNomExigenceFonctionnelle.setText(fonctionnaliteArbre.getNomFonctionnalite());
			calendrierDebut.setDate(fonctionnaliteArbre.getDateDebutFonct());
			
			if(fonctionnaliteArbre.getDateFinFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(fonctionnaliteArbre.getDateFinFonct());
			}
		}
}
