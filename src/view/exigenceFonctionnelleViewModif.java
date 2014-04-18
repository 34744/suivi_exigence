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
import javax.swing.JComboBox;
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
import model.majDataExigence;
import model.majDataFonctionnalite;
import model.majDataSousFonctionnalite;
import model.priorite;
import model.recupererIdExigenceFonctionnelle;
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

import javax.swing.Box;

import java.awt.SystemColor;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

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
		private Vector<priorite> vectPriorite = new Vector<model.priorite>();
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
		private JButton btnModifier = new JButton("Modifier");
		private JButton btnDetail;
		int idAppli, idFonctionnalite, idFonctionnalite2, idExigence, codeExigenceFonctionnelle, idSousFonctionnalite, codeExigence, codeSousFonctionnalite;
		String nomAppli, nomSousFonctionnalite, nomExigenceFonctionnelle, nomExigence;
		private fonctionnalite fonctionnalite = new fonctionnalite();
		private exigenceFonctionnelle exigenceFonctionnelle = new exigenceFonctionnelle();
		private model.sousFonctionnalite sousFonctionnalite= new model.sousFonctionnalite();
		private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
		private JTextField textFieldNumExigence;
		private JTextField textFieldNomExigence;
		public JTextField textFieldPriorite;
		private JLabel lblExigencesFonctionnelles; 
		private JDateChooser calendrierDebut= new JDateChooser();
		private JDateChooser calendrierFin= new JDateChooser();
		private JButton btnCritereSuccesAjouter = new JButton("");
		private JButton btnCritereSuccesModifier = new JButton("");
		private JTextArea description = new JTextArea();
		private JTextArea raison = new JTextArea();
		private JPanel panelDetail = new JPanel();
		private JComboBox<String> comboBoxPriorite = new JComboBox<String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		private JTable tblCritereSucces;
		private Date dateDuJour = new Date();
		private JScrollPane scrollPane;
		private JPanel panel;
		private JPanel panelCS;
		private Boolean liste;

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
			panel.setBounds(283, 53, 495, 453);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblNomExigence = new JLabel("Nom de l'exigence");
			lblNomExigence.setBounds(10, 35, 159, 26);
			lblNomExigence.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNomExigence);
			
			JLabel lblNumExigence = new JLabel("Num\u00E9ro de l'exigence ");
			lblNumExigence.setBounds(10, 8, 171, 26);
			lblNumExigence.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNumExigence);
			
			JLabel lblDateDebut = new JLabel("Date Debut");
			lblDateDebut.setBounds(10, 62, 85, 26);
			lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblDateDebut);
			
			textFieldNumExigence = new JTextField();
			textFieldNumExigence.setBounds(194, 8, 38, 26);
			panel.add(textFieldNumExigence);
			textFieldNumExigence.setColumns(10);

			
			textFieldNomExigence = new JTextField();
			textFieldNomExigence.setBounds(194, 35, 266, 26);
			textFieldNomExigence.setColumns(10);
			panel.add(textFieldNomExigence);
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
			
			lblExigencesFonctionnelles = new JLabel("Liste des crit\u00E8res de succ\u00E8s");
			lblExigencesFonctionnelles.setBounds(10, 99, 248, 26);
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
			
			btnDetail = new JButton("Détails>>");
			btnDetail.setHorizontalAlignment(SwingConstants.RIGHT);
			btnDetail.setForeground(SystemColor.activeCaption);
			btnDetail.setFocusPainted(false);
			btnDetail.setBorderPainted(false);
			btnDetail.setContentAreaFilled(false);
			btnDetail.setBounds(226, 99, 234, 23);
			panel.add(btnDetail);
			
			description = new JTextArea();
			
			JScrollPane scrollPaneDesc = new JScrollPane(description);
			scrollPaneDesc.setBounds(10, 198, 442, 105);
			panelDetail.add(scrollPaneDesc);
			
			JLabel labelPriorite = new JLabel("Priorite");
			labelPriorite.setFont(new Font("Tahoma", Font.BOLD, 14));
			labelPriorite.setBounds(10, 139, 65, 26);
			panelDetail.add(labelPriorite);
			
			comboBoxPriorite = new JComboBox();
			comboBoxPriorite.setBounds(108, 141, 110, 26);
			remplirPriorite(nomExigenceFonctionnelle);
			panelDetail.add(comboBoxPriorite);
			
			textFieldPriorite= new JTextField();
			textFieldPriorite.setBounds(75, 5, 110, 26);
			textFieldPriorite.setColumns(10);
			panelDetail.add(textFieldPriorite);
			
			JLabel lblDescription = new JLabel("Description");
			lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDescription.setBounds(10, 176, 100, 20);
			panelDetail.add(lblDescription);
			
			JLabel lblRaison = new JLabel("Raison");
			lblRaison.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRaison.setBounds(10, 314, 100, 20);
			panelDetail.add(lblRaison);
			
			raison = new JTextArea();
			
			JScrollPane scrollPaneRaison = new JScrollPane(raison);
			scrollPaneRaison.setBounds(10, 335, 442, 105);
			panelDetail.add(scrollPaneRaison);
	
			panelDetail = new JPanel();
			panelDetail.setBounds(5, 167, 455, 220);
			panelDetail.setLayout(null);
			panel.add(panelDetail);


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
			scrollPane.setBounds(0, 0, 455, 299);
			//scrollPane.setColumnHeaderView(tblSousFonctionnalite);
			panelCS=new JPanel();
			panelCS.setBounds(5,125,455,299);
			panelCS.setLayout(null);
			panelCS.add(scrollPane);
			panel.add(panelCS);
			
			btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnValider.setBounds(594, 513, 89, 31);
			btnValider.setVisible(false);
			add(btnValider);
			

			btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAnnuler.setBounds(417, 513, 89, 31);
			add(btnAnnuler);
			
			btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnModifier.setBounds(594, 513, 89, 31);
			add(btnModifier);
			
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
			btnDetail.addActionListener(list);
			btnModifier.addActionListener(list);
			remplirExigenceFonctionnelle(nomExigenceFonctionnelle);

		}
		
		public exigenceFonctionnelleViewModif(int idFocntionnalite, int idSousFonctionnalite, int codeSousFonctionnalite,String nomExigenceFonctionnelle, Boolean liste) {
			// TODO Auto-generated constructor stub
			
			vectFonctionnalite = controllerDBFonctionnalite.getNumFonctionnaliteVecteurArbre(idFonctionnalite);
			this.idFonctionnalite=idFocntionnalite;
			this.idSousFonctionnalite=idSousFonctionnalite;
			this.codeSousFonctionnalite=codeSousFonctionnalite;
			this.nomExigence=nomExigenceFonctionnelle;
			this.liste=liste;
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
			
			JLabel lblNomExigence = new JLabel("Nom de l'exigence");
			lblNomExigence.setBounds(10, 35, 159, 26);
			lblNomExigence.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNomExigence);
			
			JLabel lblNumExigence = new JLabel("Num\u00E9ro de l'exigence ");
			lblNumExigence.setBounds(10, 8, 171, 26);
			lblNumExigence.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNumExigence);
			
			JLabel lblDateDebut = new JLabel("Date Debut");
			lblDateDebut.setBounds(10, 62, 85, 26);
			lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblDateDebut);
			
			textFieldNumExigence = new JTextField();
			textFieldNumExigence.setBounds(194, 8, 38, 26);
			panel.add(textFieldNumExigence);
			textFieldNumExigence.setColumns(10);

			
			textFieldNomExigence = new JTextField();
			textFieldNomExigence.setBounds(194, 35, 266, 26);
			textFieldNomExigence.setColumns(10);
			panel.add(textFieldNomExigence);
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
			
			if(liste==true){

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
			scrollPane.setBounds(0, 0, 455, 299);
			//scrollPane.setColumnHeaderView(tblSousFonctionnalite);
			panelCS=new JPanel();
			panelCS.setBounds(5,125,455,299);
			panelCS.setLayout(null);
			panelCS.add(scrollPane);
			panel.add(panelCS);
			
			JLabel lblExigencesFonctionnelles = new JLabel("Liste des crit\u00E8res de succ\u00E8s");
			lblExigencesFonctionnelles.setBounds(10, 99, 248, 26);
			lblExigencesFonctionnelles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panel.add(lblExigencesFonctionnelles);
			
			btnDetail = new JButton("Détails>>");
			btnDetail.setHorizontalAlignment(SwingConstants.RIGHT);
			btnDetail.setForeground(SystemColor.activeCaption);
			btnDetail.setFocusPainted(false);
			btnDetail.setBorderPainted(false);
			btnDetail.setContentAreaFilled(false);
			btnDetail.setBounds(226, 99, 234, 23);
			panel.add(btnDetail);
			}
			
			else{
				panelCS=new JPanel();
				panelCS.setBounds(5,125,455,299);
				panelCS.setLayout(null);
				panelCS.setBorder(new LineBorder(new Color(0, 0, 0)));
				
				JLabel labelPriorite = new JLabel("Priorite");
				labelPriorite.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelPriorite.setBounds(5, 5, 65, 26);
				panelCS.add(labelPriorite);
				
				comboBoxPriorite = new JComboBox();
				comboBoxPriorite.setBounds(75, 5, 110, 26);
				remplirPriorite(nomExigenceFonctionnelle);
				panelCS.add(comboBoxPriorite);


				
				JLabel lblDescription = new JLabel("Description");
				lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDescription.setBounds(5, 35, 100, 20);
				panelCS.add(lblDescription);
				
				description = new JTextArea();
				description.setLineWrap(true);
				JScrollPane scrollPaneDesc = new JScrollPane(description);
				scrollPaneDesc.setBounds(5, 60, 442, 105);
				panelCS.add(scrollPaneDesc);				
				
				
				JLabel lblRaison = new JLabel("Raison");
				lblRaison.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblRaison.setBounds(5, 165, 100, 20);
				panelCS.add(lblRaison);
				
				raison = new JTextArea();
				raison.setLineWrap(true);
				
				JScrollPane scrollPaneRaison = new JScrollPane(raison);
				scrollPaneRaison.setBounds(5, 190, 442, 105);
				panelCS.add(scrollPaneRaison);
		
				panelDetail = new JPanel();
				panelDetail.setLayout(null);
				panelDetail.setBounds(5, 167, 455, 220);
				
				panel.add(panelCS);
				
				btnDetail = new JButton("<<Liste des critères de succès");
				btnDetail.setHorizontalAlignment(SwingConstants.RIGHT);
				btnDetail.setForeground(SystemColor.activeCaption);
				btnDetail.setFocusPainted(false);
				btnDetail.setBorderPainted(false);
				btnDetail.setContentAreaFilled(false);
				btnDetail.setBounds(226, 99, 234, 23);
				panel.add(btnDetail);
				
			}

			
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
			if(liste==false){
				btnValider.setVisible(true);
			}
			else{
				btnValider.setVisible(false);
				}

			btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAnnuler.setBounds(417, 513, 89, 31);
			add(btnAnnuler);
			
			
			btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnModifier.setBounds(594, 513, 89, 31);
			add(btnModifier);
			
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
			btnDetail.addActionListener(list);
			btnModifier.addActionListener(list);
			remplirExigenceFonctionnelle(nomExigenceFonctionnelle);
		}


		private void buildTree(){
			vectFonctionnalite = controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(idFonctionnalite);
			vectSousFonctionnalite = controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonctionnalite);
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
			JScrollPane JSP = new JScrollPane(tree);
			JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JSP.setBounds(21, 53, 250, 495);
			this.add(JSP);
		
			/*
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
					remplirFonctionnaliteTree(tree.getLastSelectedPathComponent().toString(),liste);
					}
				}
			});
			}
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
				
				if(source==btnModifier){
					model.exigenceFonctionnelleArbre exigenceFonctionnelleArbre = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbre(textFieldNomExigence.getText());
					codeExigenceFonctionnelle=Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence());
					nomExigenceFonctionnelle = exigenceFonctionnelleArbre.getNomExigence();
					controller.gestionFenetreSousFonctionnalite.eraseContainerPaneMainJFrame();
					controller.gestionFenetreExigenceFonctionnelle.modifExigenceFonctionnelle(idFonctionnalite, idSousFonctionnalite, codeExigenceFonctionnelle, nomExigenceFonctionnelle, false);

				}
				
				if(source==btnDetail){
					if(btnDetail.getText()=="<<Liste des critères de succès"){
						liste=true;
					}
					else{
						liste=false;	
					}
					
					model.exigenceFonctionnelleArbre exigenceFonctionnelleArbre = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbre(textFieldNomExigence.getText());
					codeExigenceFonctionnelle=Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence());
					nomExigenceFonctionnelle = exigenceFonctionnelleArbre.getNomExigence();
					controller.gestionFenetreSousFonctionnalite.eraseContainerPaneMainJFrame();
					controller.gestionFenetreExigenceFonctionnelle.modifExigenceFonctionnelle(idFonctionnalite, idSousFonctionnalite, codeExigenceFonctionnelle, nomExigenceFonctionnelle, liste);
				}
				
				if(source == btnCritereSuccesAjouter){
					
					controller.gestionFenetreSousFonctionnalite.eraseContainerPaneMainJFrame();
					controller.gestionFenetreExigenceFonctionnelle.ajoutExigenceFonctionnnelle(codeExigenceFonctionnelle, idFonctionnalite, idAppli, nomExigenceFonctionnelle, nomAppli, nomSousFonctionnalite);
				}
				
				if(source == btnValider){
					model.exigenceFonctionnelleArbre exigenceFonctionnelleArbre = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbre(idExigence);
					exigenceFonctionnelle.setPrioriteExigence(exigenceFonctionnelleArbre.getPrioriteExigence());
					if(textFieldNumExigence.getText()!=null && textFieldNumExigence.getText().length()>0){
						exigenceFonctionnelle.setNumExi(textFieldNumExigence.getText());
						
						if(textFieldNomExigence.getText()!= null && textFieldNomExigence.getText().length()>0 ){
							exigenceFonctionnelle.setNomExigence(textFieldNomExigence.getText());
							exigenceFonctionnelle.setCodeExigence(Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence()));	
							

							if(comboBoxPriorite.getSelectedIndex()>0){
								exigenceFonctionnelle.setPrioriteExigence(comboBoxPriorite.getSelectedIndex());
								
								if(description.getText()!=null && description.getText().length()>0){
									exigenceFonctionnelle.setDescriptionExigence(description.getText());
									
									if(raison.getText()!=null && raison.getText().length()>0){
										exigenceFonctionnelle.setRaisonExigence(raison.getText());
								
								
								//if(calendrierFin.getDate()!=null){
									//if(calendrierDebut.getDate().before(calendrierFin.getDate())){
										
										if(calendrierDebut.getDate()!=null){
										
										Date debut=calendrierDebut.getDate();
										String dateDebut = dateFormat.format(debut);
										String dateJour = dateFormat.format(dateDuJour);
										exigenceFonctionnelle.setDateDebutExi(dateDebut);
										exigenceFonctionnelle.setDateDebutEFRecord(dateJour);
										exigenceFonctionnelle.setDateFinEFRecord("2099-12-31");
										
										Date fin=calendrierFin.getDate();
										String dateFin="";
											if(calendrierFin.getDate()!=null){
												dateFin=dateFormat.format(fin);
												exigenceFonctionnelle.setDateFinExi(dateFin);
											}
											else{
												exigenceFonctionnelle.setDateFinExi("2099-12-31");
											}
											idExigence=exigenceFonctionnelleArbre.getIdExigence();
											System.out.println("idExigence"+idExigence);
											exigenceFonctionnelle.setFkSFonct(idSousFonctionnalite);
											exigenceFonctionnelle.setIdExigence(idExigence);
											majDataExigence.majExigence(exigenceFonctionnelle);
											controller.addDataExigenceFonctionnelle.addNewExigenceFonctionnelle(exigenceFonctionnelle);
											controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
											controller.gestionFenetreExigenceFonctionnelle.modifExigenceFonctionnelle(idFonctionnalite, idSousFonctionnalite, Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence()), exigenceFonctionnelle.getNomExigence(), liste);
											System.out.println("idFonc"+idFonctionnalite+"idSous"+ idSousFonctionnalite +"code"+Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence())+ exigenceFonctionnelle.getNomExigence()+" "+ liste);
											
											//remplirSousFonctionnalite(sousFonctionnalite.getNomSFonct());
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
		


			
	
		
		private void remplirExigenceFonctionnelle(String nomExigenceFonctionnelle){
			SimpleDateFormat formater99 = null;
			formater99 =new SimpleDateFormat ("yyyy-MM-dd");
			Date dateFinale=null;
			try {
				dateFinale = formater99.parse("2099-12-31");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.nomExigenceFonctionnelle=nomExigenceFonctionnelle;
			model.exigenceFonctionnelleArbre exigenceFonctionnelleArbre = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbre(nomExigenceFonctionnelle);
			idExigence=exigenceFonctionnelleArbre.getIdExigence();
			textFieldNumExigence.setText(exigenceFonctionnelleArbre.getNumExi());
			textFieldNomExigence.setText(exigenceFonctionnelleArbre.getNomExigence());
			//codeSousFonctionnalite=sousFonctionnaliteArbre.getCodeSFonct();
			calendrierDebut.setDate(exigenceFonctionnelleArbre.getDateDebutExi());
			
			if(exigenceFonctionnelleArbre.getDateFinExi().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(exigenceFonctionnelleArbre.getDateFinExi());
			}
			description.setText(exigenceFonctionnelleArbre.getDescriptionExigence());
			raison.setText(exigenceFonctionnelleArbre.getRaisonExigence());
			
			vectPriorite = controllerDBExigenceFonctionnelle.getPriorite();
			
			
		}	
		
		private void remplirFonctionnaliteTree(String nomExigenceFonctionnelle, Boolean liste){
			Boolean listeTree=liste;
			panelCS.removeAll();
			
			String nomExigenceTree;
			SimpleDateFormat formater99 = null;
			formater99 =new SimpleDateFormat ("yyyy-MM-dd");
			Date dateFinale=null;
			try {
				dateFinale = formater99.parse("2099-12-31");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			nomExigenceTree=nomExigenceFonctionnelle;
			model.exigenceFonctionnelleArbre exigenceFonctionnelleArbre = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbre(nomExigenceTree);
			textFieldNumExigence.setText(exigenceFonctionnelleArbre.getNumExi());
			textFieldNomExigence.setText(exigenceFonctionnelleArbre.getNomExigence());

			codeExigenceFonctionnelle=Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence());
			//codeSousFonctionnalite=sousFonctionnaliteArbre.getCodeSFonct()
			calendrierDebut.setDate(exigenceFonctionnelleArbre.getDateDebutExi());
			
			if(exigenceFonctionnelleArbre.getDateFinExi().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(exigenceFonctionnelleArbre.getDateFinExi());
			}
			int codeExigencePassee= Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence());
			
			if(btnDetail.getText()=="Détails>>"){
			vectExigenceFonctionnelle = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeExigencePassee);
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
			}
			else{

				JLabel labelPriorite = new JLabel("Priorite");
				labelPriorite.setFont(new Font("Tahoma", Font.BOLD, 14));
				labelPriorite.setBounds(5, 5, 65, 26);
				panelCS.add(labelPriorite);
				
				comboBoxPriorite = new JComboBox();
				comboBoxPriorite.setBounds(75, 5, 110, 26);
				remplirPriorite(nomExigenceFonctionnelle);
				panelCS.add(comboBoxPriorite);


				
				JLabel lblDescription = new JLabel("Description");
				lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDescription.setBounds(5, 35, 100, 20);
				panelCS.add(lblDescription);
				
				description = new JTextArea();
				description.setLineWrap(true);
				JScrollPane scrollPaneDesc = new JScrollPane(description);
				scrollPaneDesc.setBounds(5, 60, 442, 105);
				panelCS.add(scrollPaneDesc);				
				
				
				JLabel lblRaison = new JLabel("Raison");
				lblRaison.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblRaison.setBounds(5, 165, 100, 20);
				panelCS.add(lblRaison);
				
				raison = new JTextArea();
				raison.setLineWrap(true);
				
				JScrollPane scrollPaneRaison = new JScrollPane(raison);
				scrollPaneRaison.setBounds(5, 190, 442, 105);
				panelCS.add(scrollPaneRaison);
		
				panelDetail = new JPanel();
				panelDetail.setLayout(null);
				panelDetail.setBounds(5, 167, 455, 220);
								
				raison.setText(exigenceFonctionnelleArbre.getRaisonExigence());
				description.setText(exigenceFonctionnelleArbre.getDescriptionExigence());
				remplirPriorite(exigenceFonctionnelleArbre.getNomExigence());
				panelCS.repaint();
			}
			
		}
		
		private void remplirPriorite(String nomExigenceFonctionnelle){

			this.nomExigenceFonctionnelle=nomExigenceFonctionnelle;
			model.exigenceFonctionnelleArbre exigenceFonctionnelleArbre = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbre(nomExigenceFonctionnelle);
			comboBoxPriorite.removeAllItems();
			vectPriorite = controllerDBExigenceFonctionnelle.getPriorite();
			comboBoxPriorite.addItem("--Sélectionnez importance--");
			for(int i=0; i<this.vectPriorite.size();i++){
				comboBoxPriorite.addItem(vectPriorite.elementAt(i).getNomPriorite());
			}
			comboBoxPriorite.setSelectedIndex(exigenceFonctionnelleArbre.getPrioriteExigence());
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
			textFieldNumExigence.setText(fonctionnaliteArbre.getNumFonct());
			textFieldNomExigence.setText(fonctionnaliteArbre.getNomFonctionnalite());
			calendrierDebut.setDate(fonctionnaliteArbre.getDateDebutFonct());
			
			if(fonctionnaliteArbre.getDateFinFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(fonctionnaliteArbre.getDateFinFonct());
			}
		}
}
