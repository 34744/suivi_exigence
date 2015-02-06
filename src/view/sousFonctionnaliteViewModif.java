package view;
import javax.sound.midi.ControllerEventListener;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import model.MultiLineCellEditor;
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

public class sousFonctionnaliteViewModif extends JPanel {

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
		int idAppli, idFonctionnalite, idFonctionnalite2, codeSousFonctionnalite, idSousFonctionnalite, codeExigence, idSFPassee, codeEFPasse;
		String nomAppli, nomFonctionnalite, nomSousFonctionnalite, nomExigence, nomEFpasse, codeEFString;
		private fonctionnalite fonctionnalite = new fonctionnalite();
		private exigenceFonctionnelle exigenceFonctionnelle = new exigenceFonctionnelle();
		private model.sousFonctionnalite sousFonctionnalite= new model.sousFonctionnalite();
		private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
		private JTextField textFieldNumSousFonct;
		private JTextField textFieldNomSousFonctionnalite;
		private JDateChooser calendrierDebut= new JDateChooser();
		private JDateChooser calendrierFin= new JDateChooser();
		private JButton btnExigenceFonctionnelleAjouter = new JButton("");
		private JButton btnExigenceFonctionnelleModifier = new JButton("");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		private JTable tblExigenceFonctionnelle;
		private Date dateDuJour = new Date();
		private JScrollPane scrollPane;
		private JPanel panel;
		private JPanel panelEF;

		/**
		 * Create the panel.
		 * @wbp.parser.constructor
		 */
		public sousFonctionnaliteViewModif(String nomSousFonctionnalite,int codeSousFonctionnalie, String nomFonctionnalite) {
			System.out.println("SF constructeur1");
			vectFonctionnalite = controllerDBFonctionnalite.getNomFonctionnaliteVecteurArbre(nomFonctionnalite);
			
			this.nomSousFonctionnalite=nomSousFonctionnalite;
			this.codeSousFonctionnalite=codeSousFonctionnalie;
			this.nomFonctionnalite=nomFonctionnalite;

			model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(nomFonctionnalite);
			nomFonctionnalite=fonctionnaliteArbre.getNomFonctionnalite();
			idFonctionnalite=fonctionnaliteArbre.getIdFonctionnalite();
			idAppli=fonctionnaliteArbre.getFkAppli();
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
			
			textFieldNumSousFonct = new JTextField();
			textFieldNumSousFonct.setBounds(265, 8, 38, 26);
			panel.add(textFieldNumSousFonct);
			textFieldNumSousFonct.setColumns(10);

			
			textFieldNomSousFonctionnalite = new JTextField();
			textFieldNomSousFonctionnalite.setBounds(265, 35, 208, 26);
			textFieldNomSousFonctionnalite.setColumns(10);
			panel.add(textFieldNomSousFonctionnalite);
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
			

			vectExigenceFonctionnelle = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeSousFonctionnalite);
			modelExigenceFonctionnelle = new exigenceFonctionnelleModelTableau(vectExigenceFonctionnelle);
			

			tblExigenceFonctionnelle = new JTable(modelExigenceFonctionnelle);
			tblExigenceFonctionnelle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Object source = arg0.getSource();
					if(tblExigenceFonctionnelle.getSelectedRow()!=-1){
						nomEFpasse=tblExigenceFonctionnelle.getValueAt(tblExigenceFonctionnelle.getSelectedRow(), 1).toString();
						codeEFString=tblExigenceFonctionnelle.getValueAt(tblExigenceFonctionnelle.getSelectedRow(),3).toString();
						codeEFPasse=Integer.parseInt(codeEFString);
						System.out.println("codePasse"+codeEFPasse);
						if(arg0.getClickCount()==2){
							modifExigenceFonctionnelle();
						}
						
					}
				}

				
			});
			tblExigenceFonctionnelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblExigenceFonctionnelle.setColumnSelectionAllowed(true);
			tblExigenceFonctionnelle.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
			tblExigenceFonctionnelle.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			tblExigenceFonctionnelle.setForeground(Color.WHITE);
			tblExigenceFonctionnelle.setFont(new Font("Tahoma", Font.BOLD, 13));
			tblExigenceFonctionnelle.setBackground(new Color(211, 211, 211));
			tblExigenceFonctionnelle.setAutoCreateRowSorter(true);
			tblExigenceFonctionnelle.getRowSorter().toggleSortOrder(0);
			tblExigenceFonctionnelle.setAutoCreateRowSorter(false);
			tblExigenceFonctionnelle.getColumnModel().getColumn(0).setPreferredWidth(60);
			tblExigenceFonctionnelle.getColumnModel().getColumn(1).setPreferredWidth(255);
			tblExigenceFonctionnelle.getColumnModel().getColumn(2).setPreferredWidth(55);
			tblExigenceFonctionnelle.getColumnModel().getColumn(3).setPreferredWidth(30);
			tblExigenceFonctionnelle.setBounds(0, 0, 200, 154);
			
			scrollPane = new JScrollPane(tblExigenceFonctionnelle);
			scrollPane.setBounds(0, 0, 455, 220);
			//scrollPane.setColumnHeaderView(tblSousFonctionnalite);
			panelEF=new JPanel();
			panelEF.setLayout(null);
			panelEF.setBounds(5,167,455,220);
			panelEF.add(scrollPane);
			panel.add(panelEF);
			
			JLabel lblExigencesFonctionnelles = new JLabel("Liste des exigences fonctionnelles");
			lblExigencesFonctionnelles.setBounds(10, 130, 248, 26);
			lblExigencesFonctionnelles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panel.add(lblExigencesFonctionnelles);
			
			btnExigenceFonctionnelleAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
			btnExigenceFonctionnelleAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnExigenceFonctionnelleAjouter.setBounds(463, 242, 22, 23);
			panel.add(btnExigenceFonctionnelleAjouter);
			
			btnExigenceFonctionnelleModifier.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
			btnExigenceFonctionnelleModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnExigenceFonctionnelleModifier.setBounds(463, 276, 22, 23);
			panel.add(btnExigenceFonctionnelleModifier);
			
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
			btnExigenceFonctionnelleAjouter.addActionListener(list);
			btnExigenceFonctionnelleModifier.addActionListener(list);
			
			remplirSousFonctionnalite(nomSousFonctionnalite);

		}
		
		public sousFonctionnaliteViewModif(int idFonctionnalite, int codeFonctionnalite,String nomSousFonctionnalite) {
			// TODO Auto-generated constructor stub
			System.out.println("SF constructeur2");
			System.out.println(nomSousFonctionnalite+"nomSF dans panel SF");
			vectFonctionnalite = controllerDBFonctionnalite.getNumFonctionnaliteVecteurArbre(idFonctionnalite);
			this.idFonctionnalite=idFonctionnalite;
			this.codeSousFonctionnalite=codeFonctionnalite;
			this.nomSousFonctionnalite=nomSousFonctionnalite;
			
			model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(idFonctionnalite);
			idAppli=fonctionnaliteArbre.getFkAppli();
			nomFonctionnalite=fonctionnaliteArbre.getNomFonctionnalite();
			model.sousFonctionnaliteArbre sousFonctionnaliteArbre = controllerDBSousFonctionnalite.getSousFonctionnaliteArbre(nomSousFonctionnalite);
			//codeSousFonctionnalite=Integer.parseInt(sousFonctionnaliteArbre.getCodeSFonct());
			//System.out.println("CODESF"+codeSousFonctionnalite);
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
			
			textFieldNumSousFonct = new JTextField();
			textFieldNumSousFonct.setBounds(265, 8, 38, 26);
			panel.add(textFieldNumSousFonct);
			textFieldNumSousFonct.setColumns(10);

			
			textFieldNomSousFonctionnalite = new JTextField();
			textFieldNomSousFonctionnalite.setBounds(265, 35, 208, 26);
			textFieldNomSousFonctionnalite.setColumns(10);
			panel.add(textFieldNomSousFonctionnalite);
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
			
			vectExigenceFonctionnelle = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeSousFonctionnalite);
			modelExigenceFonctionnelle = new exigenceFonctionnelleModelTableau(vectExigenceFonctionnelle);
			

			tblExigenceFonctionnelle = new JTable(modelExigenceFonctionnelle);
			MultiLineCellEditor editor = new MultiLineCellEditor(tblExigenceFonctionnelle);
			tblExigenceFonctionnelle.setDefaultEditor(String.class,editor);
			tblExigenceFonctionnelle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Object source = arg0.getSource();
					if(tblExigenceFonctionnelle.getSelectedRow()!=-1){
						nomEFpasse=tblExigenceFonctionnelle.getValueAt(tblExigenceFonctionnelle.getSelectedRow(), 1).toString();
						codeEFString=tblExigenceFonctionnelle.getValueAt(tblExigenceFonctionnelle.getSelectedRow(),3).toString();
						codeEFPasse=Integer.parseInt(codeEFString);
						idSFPassee=codeSousFonctionnalite;
						
						if(arg0.getClickCount()==2){
							modifExigenceFonctionnelle();
						}
						
					}
				}

				
			});
			tblExigenceFonctionnelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblExigenceFonctionnelle.setColumnSelectionAllowed(true);
			tblExigenceFonctionnelle.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
			tblExigenceFonctionnelle.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			tblExigenceFonctionnelle.setForeground(Color.WHITE);
			tblExigenceFonctionnelle.setFont(new Font("Tahoma", Font.BOLD, 13));
			tblExigenceFonctionnelle.setBackground(new Color(211, 211, 211));
			tblExigenceFonctionnelle.setAutoCreateRowSorter(true);
			tblExigenceFonctionnelle.getRowSorter().toggleSortOrder(0);
			tblExigenceFonctionnelle.setAutoCreateRowSorter(false);
			tblExigenceFonctionnelle.getColumnModel().getColumn(0).setPreferredWidth(60);
			tblExigenceFonctionnelle.getColumnModel().getColumn(1).setPreferredWidth(255);
			tblExigenceFonctionnelle.getColumnModel().getColumn(2).setPreferredWidth(55);
			tblExigenceFonctionnelle.getColumnModel().getColumn(3).setPreferredWidth(30);
			//tblExigenceFonctionnelle.setBounds(0, 0, 200, 154);
			scrollPane = new JScrollPane(tblExigenceFonctionnelle);
			scrollPane.setBounds(0, 0,455, 220);
			panelEF=new JPanel();
			panelEF.setLayout(null);
			panelEF.setBounds(5,167,455,220);
			panelEF.add(scrollPane);
			panel.add(panelEF);
			
			JLabel lblExigencesFonctionnelles = new JLabel("Liste des exigences fonctionnelles");
			lblExigencesFonctionnelles.setBounds(10, 130, 248, 26);
			lblExigencesFonctionnelles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panel.add(lblExigencesFonctionnelles);
			
			btnExigenceFonctionnelleAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
			btnExigenceFonctionnelleAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnExigenceFonctionnelleAjouter.setBounds(463, 242, 22, 23);
			panel.add(btnExigenceFonctionnelleAjouter);
			
			btnExigenceFonctionnelleModifier.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
			btnExigenceFonctionnelleModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnExigenceFonctionnelleModifier.setBounds(463, 276, 22, 23);
			panel.add(btnExigenceFonctionnelleModifier);
			
			btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnValider.setBounds(593, 518, 89, 31);
			add(btnValider);
			

			btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAnnuler.setBounds(414, 518, 89, 31);
			add(btnAnnuler);
			
			buildTree();
			
			MyButtonListener list= new MyButtonListener();
			btnConfig.addActionListener(list);
			btnSoftware.addActionListener(list);
			btnUpdate.addActionListener(list);
			btnRapports.addActionListener(list);
			btnHome.addActionListener(list);
			tglbtnModifier.addActionListener(list);
			btnValider.addActionListener(list);
			btnAnnuler.addActionListener(list);
			btnExigenceFonctionnelleAjouter.addActionListener(list);
			btnExigenceFonctionnelleModifier.addActionListener(list);
			System.out.println("NOMSFAPPEL"+this.nomSousFonctionnalite);
			remplirSousFonctionnalite(nomSousFonctionnalite);
		}

		private void buildTree(){
			System.out.println("buildtree"+idFonctionnalite);
			vectFonctionnalite = controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(idFonctionnalite);
			vectSousFonctionnalite = controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonctionnalite);
			vectAppli=ControllerDBConfiguration.getApplicationArbre();
			vectExigenceFonctionnelle=controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeSousFonctionnalite);
			String fonctionnalite, sFonctionnalite, exiFonct;
			int i=0;

			DefaultMutableTreeNode racine = new DefaultMutableTreeNode(vectSousFonctionnalite.elementAt(i).getNomAppli()); 
			DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(nomFonctionnalite);
				while (i<vectSousFonctionnalite.size())
				{
						sFonctionnalite=vectSousFonctionnalite.elementAt(i).getNomSFonct();
						DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode(vectSousFonctionnalite.elementAt(i).getNomSFonct());
							
							
					i++;
					rep1.add(rep2);
				}
					i++;
					racine.add(rep1);
				
			
			final JTree tree = new JTree(racine);
			tree.setBounds(21, 53, 250, 495);	
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
				
				if(source == btnAnnuler){
					
				controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
				controller.gestionFenetreFonctionnalite.modifFonctionnalite(idFonctionnalite,idAppli,nomAppli);
				}
				
				if(source == btnExigenceFonctionnelleAjouter){
					
					controller.gestionFenetreSousFonctionnalite.eraseContainerPaneMainJFrame();
					controller.gestionFenetreExigenceFonctionnelle.ajoutExigenceFonctionnnelle(codeSousFonctionnalite, idFonctionnalite, idAppli, nomSousFonctionnalite, nomAppli, nomFonctionnalite);
				}
				
				if(source == btnValider){
					
					if(textFieldNumSousFonct.getText()!=null && textFieldNumSousFonct.getText().length()>0){
						sousFonctionnalite.setNumSFonct(textFieldNumSousFonct.getText());
						
						if(textFieldNomSousFonctionnalite.getText()!= null && textFieldNomSousFonctionnalite.getText().length()>0 ){
							sousFonctionnalite.setNomSFonct(textFieldNomSousFonctionnalite.getText());
							sousFonctionnalite.setCodeSFonct(codeSousFonctionnalite);	
							
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
							textFieldNomSousFonctionnalite.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
							textFieldNomSousFonctionnalite.requestFocus();
						}
					}
					else
					{
						lblErreur.setVisible(true);
						textFieldNumSousFonct.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textFieldNumSousFonct.requestFocus();					
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

			this.nomSousFonctionnalite=nomSousFonctionnalite;
			System.out.println("NOM SF"+nomSousFonctionnalite);
			model.sousFonctionnaliteArbre sousFonctionnaliteArbre = controllerDBSousFonctionnalite.getSousFonctionnaliteArbre(nomSousFonctionnalite);
			idSousFonctionnalite=sousFonctionnaliteArbre.getIdSousFonct();
			textFieldNumSousFonct.setText(sousFonctionnaliteArbre.getNumSFonct());
			textFieldNomSousFonctionnalite.setText(sousFonctionnaliteArbre.getNomSFonct());
			codeSousFonctionnalite=Integer.parseInt(sousFonctionnaliteArbre.getCodeSFonct());
			idSousFonctionnalite=sousFonctionnaliteArbre.getIdSousFonct();
			calendrierDebut.setDate(sousFonctionnaliteArbre.getDateDebutSFonct());
			
			if(sousFonctionnaliteArbre.getDateFinSFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(sousFonctionnaliteArbre.getDateFinSFonct());
			}
		}	
		
		private void remplirFonctionnaliteTree(String nomSousFonctionnalite){
			panelEF.removeAll();
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
			textFieldNumSousFonct.setText(sousFonctionnaliteArbre.getNumSFonct());
			textFieldNomSousFonctionnalite.setText(sousFonctionnaliteArbre.getNomSFonct());
	
			codeSousFonctionnalite=Integer.parseInt(sousFonctionnaliteArbre.getCodeSFonct());
			calendrierDebut.setDate(sousFonctionnaliteArbre.getDateDebutSFonct());
			
			if(sousFonctionnaliteArbre.getDateFinSFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(sousFonctionnaliteArbre.getDateFinSFonct());
			}
			int codeSousFonctionnalitePassee= Integer.parseInt(sousFonctionnaliteArbre.getCodeSFonct());
			idSousFonctionnalite = sousFonctionnaliteArbre.getIdSousFonct();
			
			vectExigenceFonctionnelle = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeSousFonctionnalitePassee);
			modelExigenceFonctionnelle = new exigenceFonctionnelleModelTableau(vectExigenceFonctionnelle);
			

			tblExigenceFonctionnelle = new JTable(modelExigenceFonctionnelle);
			tblExigenceFonctionnelle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Object source = arg0.getSource();
					if(tblExigenceFonctionnelle.getSelectedRow()!=-1){
						nomEFpasse=tblExigenceFonctionnelle.getValueAt(tblExigenceFonctionnelle.getSelectedRow(), 1).toString();
						codeEFString=tblExigenceFonctionnelle.getValueAt(tblExigenceFonctionnelle.getSelectedRow(),3).toString();
						codeEFPasse=Integer.parseInt(codeEFString);
						idSFPassee=codeSousFonctionnalite;
						
						if(arg0.getClickCount()==2){
							modifExigenceFonctionnelle();
						}
						
					}
				}

				
			});
			tblExigenceFonctionnelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblExigenceFonctionnelle.setColumnSelectionAllowed(true);
			tblExigenceFonctionnelle.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
			tblExigenceFonctionnelle.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			tblExigenceFonctionnelle.setForeground(Color.WHITE);
			tblExigenceFonctionnelle.setFont(new Font("Tahoma", Font.BOLD, 13));
			tblExigenceFonctionnelle.setBackground(new Color(211, 211, 211));
			tblExigenceFonctionnelle.setAutoCreateRowSorter(true);
			tblExigenceFonctionnelle.getRowSorter().toggleSortOrder(0);
			tblExigenceFonctionnelle.setAutoCreateRowSorter(false);
			tblExigenceFonctionnelle.getColumnModel().getColumn(0).setPreferredWidth(60);
			tblExigenceFonctionnelle.getColumnModel().getColumn(1).setPreferredWidth(255);
			tblExigenceFonctionnelle.getColumnModel().getColumn(2).setPreferredWidth(55);
			tblExigenceFonctionnelle.getColumnModel().getColumn(3).setPreferredWidth(30);
			tblExigenceFonctionnelle.setBounds(0, 0, 448, 154);
			JScrollPane scrollPane = new JScrollPane(tblExigenceFonctionnelle);
			scrollPane.setBounds(0,0, 448, 217);
			scrollPane.setVisible(true);
			panelEF.add(scrollPane);
			panel.add(panelEF);
			panelEF.repaint();
			
			/*
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(sousFonctionnaliteArbre.getFkFonct(), codeSousFonctionnalitePassee, sousFonctionnaliteArbre.getNomSFonct());	
			*/
		}
		
		private void modifExigenceFonctionnelle() {
			// TODO Auto-generated method stub
			
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			System.out.println("modif"+idFonctionnalite+ idSFPassee +codeEFPasse+ nomEFpasse+ nomSousFonctionnalite );
			controller.gestionFenetreExigenceFonctionnelle.modifExigenceFonctionnelle(idFonctionnalite, idSFPassee, codeEFPasse,  nomSousFonctionnalite, nomEFpasse,true);	
			
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
			textFieldNumSousFonct.setText(fonctionnaliteArbre.getNumFonct());
			textFieldNomSousFonctionnalite.setText(fonctionnaliteArbre.getNomFonctionnalite());
			calendrierDebut.setDate(fonctionnaliteArbre.getDateDebutFonct());
			
			if(fonctionnaliteArbre.getDateFinFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(fonctionnaliteArbre.getDateFinFonct());
			}
		}
}
