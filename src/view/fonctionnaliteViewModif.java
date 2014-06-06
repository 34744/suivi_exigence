package view;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
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

import model.fonctionnalite;
import model.fonctionnaliteArbre;
import model.fonctionnaliteModelTableau;
import model.majDataFonctionnalite;
import model.ouvrirTree;
import model.sousFonctionnaliteModelTableau;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ControllerDBConfiguration;
import controller.addDataFonctionnalite;
import controller.controllerDBFonctionnalite;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.xml.datatype.Duration;

import view.Parametres.MyButtonListener;

public class fonctionnaliteViewModif extends JPanel {

	/**
	 * Create the panel.
	 */

		private JFrame frame;
		private JTable table;
		private JTree tree;
		private Vector<model.sousFonctionnaliteArbre> vectSousFonctionnalite = new Vector <model.sousFonctionnaliteArbre>();
		private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
		private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
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
		private model.sousFonctionnalite sousFonctionnalite= new model.sousFonctionnalite();
		private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
		private JTextField textFieldNumFonct;
		private JTextField textFieldNomFonctionnalite;
		private JDateChooser calendrierDebut= new JDateChooser();
		private JDateChooser calendrierFin= new JDateChooser();
		private JTextArea textArea = new JTextArea();
		private JButton btnSousFonctionnaliteAjouter = new JButton("");
		private JButton btnSousFonctionnaliteModifier = new JButton("");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		private JTable tblSousFonctionnalite;
		private JPanel panel;

		
		/**
		 * Create the panel.
		 * @wbp.parser.constructor
		 */
		public fonctionnaliteViewModif(String nomFonctionnalite,int idAppli, String nomAppli) {
			
			vectFonctionnalite = controllerDBFonctionnalite.getNomFonctionnaliteVecteurArbre(nomFonctionnalite);
			this.idAppli=idAppli;
			this.nomAppli=nomAppli;
			this.nomFonctionnalite=nomFonctionnalite;

			model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(nomFonctionnalite);
			idFonctionnalite=fonctionnaliteArbre.getIdFonctionnalite();
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
			
			JLabel lblNomFonctionnalite = new JLabel("Nom de la fonctionnalit\u00E9");
			lblNomFonctionnalite.setBounds(10, 35, 186, 26);
			lblNomFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNomFonctionnalite);
			
			JLabel lblNumFonctionnalite = new JLabel("Num\u00E9ro de la fonctionnalit\u00E9");
			lblNumFonctionnalite.setBounds(10, 8, 208, 26);
			lblNumFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblNumFonctionnalite);
			
			JLabel lblDateDebut = new JLabel("Date Debut");
			lblDateDebut.setBounds(10, 62, 85, 26);
			lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel.add(lblDateDebut);
			
			JLabel lblDescription = new JLabel("Description de la fonctionnalit\u00E9");
			lblDescription.setBounds(10, 90, 248, 26);
			lblDescription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panel.add(lblDescription);
			
			textFieldNumFonct = new JTextField();
			textFieldNumFonct.setBounds(228, 8, 100, 26);
			panel.add(textFieldNumFonct);
			textFieldNumFonct.setColumns(10);

			
			textFieldNomFonctionnalite = new JTextField();
			textFieldNomFonctionnalite.setBounds(228, 35, 230, 26);
			textFieldNomFonctionnalite.setColumns(10);
			panel.add(textFieldNomFonctionnalite);
			
			textArea.setBounds(10, 187, 448, 149);
			textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textArea.setLineWrap(true);
			JScrollPane JSPtextArea = new JScrollPane(textArea);
			JSPtextArea.setBounds(10, 122, 448, 120);
			JSPtextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			JSPtextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			
			panel.add(JSPtextArea);
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
			
			idFonctionnalitePassee=idFonctionnalite;
			vectSousFonctionnalite = controller.controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonctionnalite);
			modelSousFonctionnalite = new sousFonctionnaliteModelTableau(vectSousFonctionnalite);
			tblSousFonctionnalite = new JTable(modelSousFonctionnalite);
			tblSousFonctionnalite.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Object source = arg0.getSource();
					if(tblSousFonctionnalite.getSelectedRow()!=-1){
						nomSousFonctionnalitePassee=tblSousFonctionnalite.getValueAt(tblSousFonctionnalite.getSelectedRow(), 1).toString();
						codeSousFonctionnaliteString=tblSousFonctionnalite.getValueAt(tblSousFonctionnalite.getSelectedRow(),3).toString();
						codeSousFonctionnalitePassee=Integer.parseInt(codeSousFonctionnaliteString);
						if(arg0.getClickCount()==2){
							modifSousFonctionnalite();
						}
						
					}
				}

				
			});
			tblSousFonctionnalite.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblSousFonctionnalite.setColumnSelectionAllowed(true);
			tblSousFonctionnalite.setToolTipText("S\u00E9lectionnez la sous-fonctionnalit\u00E9 d\u00E9sir\u00E9e");
			tblSousFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			tblSousFonctionnalite.setForeground(Color.WHITE);
			tblSousFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 13));
			tblSousFonctionnalite.setBackground(new Color(211, 211, 211));
			tblSousFonctionnalite.setAutoCreateRowSorter(true);
			tblSousFonctionnalite.getRowSorter().toggleSortOrder(0);
			tblSousFonctionnalite.setAutoCreateRowSorter(false);
			tblSousFonctionnalite.getColumnModel().getColumn(0).setPreferredWidth(45);
			tblSousFonctionnalite.getColumnModel().getColumn(1).setPreferredWidth(240);
			tblSousFonctionnalite.getColumnModel().getColumn(2).setPreferredWidth(75);
			tblSousFonctionnalite.getColumnModel().getColumn(3).setPreferredWidth(0);
			tblSousFonctionnalite.setBounds(0, 0, 448, 154);
			tblSousFonctionnalite.setDefaultRenderer(Object.class, new tableSousFonctionnaliteRenderer());
			JScrollPane scrollPane = new JScrollPane(tblSousFonctionnalite);
			scrollPane.setBounds(10, 270, 448, 154);
			//scrollPane.setColumnHeaderView(tblSousFonctionnalite);

			panel.add(scrollPane);
			
			JLabel lblSousFonctionnalite = new JLabel("Liste des sous fonctionnalit\u00E9s");
			lblSousFonctionnalite.setBounds(10, 246, 248, 26);
			lblSousFonctionnalite.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panel.add(lblSousFonctionnalite);
			
			btnSousFonctionnaliteAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
			btnSousFonctionnaliteAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnSousFonctionnaliteAjouter.setBounds(463, 297, 22, 23);
			panel.add(btnSousFonctionnaliteAjouter);
			
			btnSousFonctionnaliteModifier.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
			btnSousFonctionnaliteModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnSousFonctionnaliteModifier.setBounds(463, 335, 22, 23);
			panel.add(btnSousFonctionnaliteModifier);
			
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
			btnSousFonctionnaliteAjouter.addActionListener(list);
			btnSousFonctionnaliteModifier.addActionListener(list);
			
			remplirFonctionnalite(nomFonctionnalite);
		}
		
		public fonctionnaliteViewModif(int idFonctionnalite2, int idAppli2,	String nomAppli2) {
			// TODO Auto-generated constructor stub
			vectFonctionnalite = controllerDBFonctionnalite.getNumFonctionnaliteVecteurArbre(idFonctionnalite);
			this.idAppli=idAppli2;
			this.nomAppli=nomAppli2;
			this.idFonctionnalite2=idFonctionnalite2;
			this.idFonctionnalite=idFonctionnalite2;
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
			
			JLabel lblNomFonctionnalite = new JLabel("Nom de la fonctionnalit\u00E9");
			lblNomFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNomFonctionnalite.setBounds(10, 35, 186, 26);
			panel.add(lblNomFonctionnalite);
			
			JLabel lblNumFonctionnalite = new JLabel("Num\u00E9ro de la fonctionnalit\u00E9");
			lblNumFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNumFonctionnalite.setBounds(10, 8, 208, 26);
			panel.add(lblNumFonctionnalite);
			
			JLabel lblDateDebut = new JLabel("Date Debut");
			lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDateDebut.setBounds(10, 62, 85, 26);
			panel.add(lblDateDebut);
			
			JLabel lblDescription = new JLabel("Description de la fonctionnalit\u00E9");
			lblDescription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblDescription.setBounds(10, 90, 248, 26);
			panel.add(lblDescription);
			
			textFieldNumFonct = new JTextField();
			textFieldNumFonct.setBounds(228, 8, 100, 26);
			panel.add(textFieldNumFonct);
			textFieldNumFonct.setColumns(10);

			
			textFieldNomFonctionnalite = new JTextField();
			textFieldNomFonctionnalite.setColumns(10);
			textFieldNomFonctionnalite.setBounds(228, 35, 230, 26);
			panel.add(textFieldNomFonctionnalite);
			
			textArea.setBounds(10, 187, 448, 149);
			textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textArea.setLineWrap(true);
			JScrollPane JSPtextArea = new JScrollPane(textArea);
			JSPtextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			JSPtextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JSPtextArea.setBounds(10, 122, 448, 120);
			
			panel.add(JSPtextArea);
			

			calendrierDebut.setBounds(108, 62, 110, 26);
			calendrierDebut.setDateFormatString("dd/MM/yyyy");
			panel.add(calendrierDebut);

			calendrierFin.setBounds(316, 62, 110, 26);
			calendrierFin.setDateFormatString("dd/MM/yyyy");
			panel.add(calendrierFin);
			
			JLabel lblDateFin = new JLabel("Date Fin");
			lblDateFin.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDateFin.setBounds(238, 62, 65, 26);
			panel.add(lblDateFin);		
			lblErreur.setBounds(10, 435, 416, 14);
			panel.add(lblErreur);
			lblErreur.setVisible(false);
			

			lblErreur.setForeground(Color.RED);
			
			idFonctionnalitePassee=idFonctionnalite2;
			vectSousFonctionnalite = controller.controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonctionnalite2);
			modelSousFonctionnalite = new sousFonctionnaliteModelTableau(vectSousFonctionnalite);

			tblSousFonctionnalite = new JTable(modelSousFonctionnalite);
			
			tblSousFonctionnalite.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Object source = arg0.getSource();
					if(tblSousFonctionnalite.getSelectedRow()!=-1){
						nomSousFonctionnalitePassee=tblSousFonctionnalite.getValueAt(tblSousFonctionnalite.getSelectedRow(), 1).toString();
						codeSousFonctionnaliteString=tblSousFonctionnalite.getValueAt(tblSousFonctionnalite.getSelectedRow(),3).toString();
						codeSousFonctionnalitePassee=Integer.parseInt(codeSousFonctionnaliteString);
						if(arg0.getClickCount()==2){
							modifSousFonctionnalite();
						}
						
					}
				}

				
			});
			
			tblSousFonctionnalite.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblSousFonctionnalite.setColumnSelectionAllowed(true);
			
			tblSousFonctionnalite.setToolTipText("S\u00E9lectionnez la sous-fonctionnalit\u00E9 d\u00E9sir\u00E9e");
			tblSousFonctionnalite.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			tblSousFonctionnalite.setForeground(Color.WHITE);
			tblSousFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 13));
			tblSousFonctionnalite.setBackground(new Color(211, 211, 211));
			tblSousFonctionnalite.setAutoCreateRowSorter(true);
			tblSousFonctionnalite.getRowSorter().toggleSortOrder(0);
			tblSousFonctionnalite.setAutoCreateRowSorter(false);
			tblSousFonctionnalite.getColumnModel().getColumn(0).setPreferredWidth(45);
			tblSousFonctionnalite.getColumnModel().getColumn(1).setPreferredWidth(240);
			tblSousFonctionnalite.getColumnModel().getColumn(2).setPreferredWidth(75);
			tblSousFonctionnalite.getColumnModel().getColumn(3).setPreferredWidth(0);
			
			tblSousFonctionnalite.setBounds(0, 0, 448, 154);
			JScrollPane scrollPane = new JScrollPane(tblSousFonctionnalite);
			scrollPane.setBounds(10, 270, 448, 154);
			//scrollPane.setColumnHeaderView(tblSousFonctionnalite);

			panel.add(scrollPane);
			
			JLabel lblSousFonctionnalite = new JLabel("Liste des sous fonctionnalit\u00E9s");
			lblSousFonctionnalite.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblSousFonctionnalite.setBounds(10, 246, 248, 26);
			panel.add(lblSousFonctionnalite);
			
			btnSousFonctionnaliteAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
			btnSousFonctionnaliteAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnSousFonctionnaliteAjouter.setBounds(463, 297, 22, 23);
			panel.add(btnSousFonctionnaliteAjouter);
			
			btnSousFonctionnaliteModifier.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
			btnSousFonctionnaliteModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnSousFonctionnaliteModifier.setBounds(463, 335, 22, 23);
			panel.add(btnSousFonctionnaliteModifier);
			
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
			btnSousFonctionnaliteAjouter.addActionListener(list);
			btnSousFonctionnaliteModifier.addActionListener(list);
			remplirFonctionnaliteId(idFonctionnalite2);
		}

		private void buildTree(){
			System.out.println("idAppli"+idAppli);
			vectFonctionnalite = controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(idAppli);
			vectAppli=ControllerDBConfiguration.getApplicationArbre();
			String fonctionnalite, sFonctionnalite, exiFonct;
			int i=0;
			if(vectFonctionnalite.size()>0){
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode(vectFonctionnalite.elementAt(i).getNomApplication()); 
			nomAppli=vectFonctionnalite.elementAt(i).getNomApplication();
			nomFonctionnalite=vectFonctionnalite.elementAt(i).getNomFonctionnalite();
			idFonctionnalitePassee=vectFonctionnalite.elementAt(i).getIdFonctionnalite();
				while (i<vectFonctionnalite.size())
				{
					fonctionnalite=vectFonctionnalite.elementAt(i).getNomFonctionnalite();
					DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(vectFonctionnalite.elementAt(i).getNomFonctionnalite());
					i++;
					racine.add(rep1);
				}
			
			final JTree tree = new JTree(racine);
			tree.setBounds(21, 53, 250, 453);	
			JScrollPane JSP = new JScrollPane(tree);
			JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JSP.setBounds(21, 53, 250, 453);
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
						remplirFonctionnaliteTree(tree.getLastSelectedPathComponent().toString());
					}
				}
			});
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
				
				if(source == btnAnnuler){
				controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
				controller.gestionFenetreFonctionnalite.fonctionnalite();
				}
				
				if(source == btnSousFonctionnaliteAjouter){
					nomFonctionnalite=textFieldNomFonctionnalite.getText();
					controller.gestionFenetreSousFonctionnalite.eraseContainerPaneMainJFrame();
					controller.gestionFenetreSousFonctionnalite.ajoutSousFonctionnalite(idFonctionnalite, nomAppli, idAppli,nomFonctionnalite);
				}
				
				if(source == btnValider){
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
			}				
			
		

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
		private void creerPanel(){
			
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

			this.nomFonctionnalite=nomFonctionnalite;
			model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(nomFonctionnalite);
			textFieldNumFonct.setText(fonctionnaliteArbre.getNumFonct());
			textFieldNomFonctionnalite.setText(fonctionnaliteArbre.getNomFonctionnalite());
			textArea.setText(fonctionnaliteArbre.getDescriptionFonctionnalite());
			idFonctionnalite=fonctionnaliteArbre.getIdFonctionnalite();
			calendrierDebut.setDate(fonctionnaliteArbre.getDateDebutFonct());
			idFonctionnalitePassee=idFonctionnalite;
			if(fonctionnaliteArbre.getDateFinFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(fonctionnaliteArbre.getDateFinFonct());
			}
			buildTree();
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
			textFieldNumFonct.setText(fonctionnaliteArbre.getNumFonct());
			textFieldNomFonctionnalite.setText(fonctionnaliteArbre.getNomFonctionnalite());
			textArea.setText(fonctionnaliteArbre.getDescriptionFonctionnalite());
			idFonctionnalite=fonctionnaliteArbre.getIdFonctionnalite();
			calendrierDebut.setDate(fonctionnaliteArbre.getDateDebutFonct());
			idFonctionnalitePassee=idFonctionnalite;
			if(fonctionnaliteArbre.getDateFinFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(fonctionnaliteArbre.getDateFinFonct());
			}
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			controller.gestionFenetreFonctionnalite.modifFonctionnalite(idFonctionnalite, fonctionnaliteArbre.getFkAppli(), nomAppli);	
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
			textFieldNumFonct.setText(fonctionnaliteArbre.getNumFonct());
			textFieldNomFonctionnalite.setText(fonctionnaliteArbre.getNomFonctionnalite());
			textArea.setText(fonctionnaliteArbre.getDescriptionFonctionnalite());
			calendrierDebut.setDate(fonctionnaliteArbre.getDateDebutFonct());
			idFonctionnalitePassee=idFonctionnalite;
			if(fonctionnaliteArbre.getDateFinFonct().compareTo(dateFinale)==0){
				calendrierFin.setDate(null);
			}
			else{
				calendrierFin.setDate(fonctionnaliteArbre.getDateFinFonct());
			}
			
		}	
		private void modifSousFonctionnalite() {
			// TODO Auto-generated method stub
			System.out.println(nomSousFonctionnalitePassee+ idFonctionnalite + "code"+codeSousFonctionnalitePassee+"nonSF"+nomSousFonctionnalitePassee);
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(idFonctionnalite, codeSousFonctionnalitePassee, nomSousFonctionnalitePassee);	
		
		}
}
