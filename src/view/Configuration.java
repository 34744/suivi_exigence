package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import view.Parametres.MyButtonListener;
import view.Parametres.maDirection;
import controller.ControllerDBConfiguration;
import model.application;
import model.applicationArbre;
import model.applicationModelTableau;
import model.compoCelluleModelTableau;
import model.direction;
import model.directionGenerale;
import model.directionGeneraleArbre;
import model.directionGeneraleModelTableau;
import model.directionModelTableau;
import model.utilisateur;
import model.utilisateurArbre;
import model.utilisateurModelTableau;

class ComposantOnglet extends JPanel implements ActionListener {
	  private JTabbedPane pane;
	 
	  public ComposantOnglet(String titre, JTabbedPane pane) {
	    this.pane = pane;
	    setOpaque(false);
	    JLabel label = new JLabel(titre);
	    add(label);
	    JButton button = new JButton("Fermer");
	    button.setPreferredSize(new Dimension(50,30));
	    button.addActionListener(this);
	   // add(button);
	  }
	 
	  public void actionPerformed(ActionEvent e) {
	    int i = pane.indexOfTabComponent(this);
	    if (i != -1)
	      pane.remove(i);
	  }
	}


public class Configuration extends JPanel {
	compoCelluleJFrame fenetreAjout;
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES FENETRE
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	
	
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES NAVIGATION
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES JTTABBEDPANE
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
	private int ongletSelectionne=0;
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES APPLICATION
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	JPanel ongletAppli = new JPanel();
	JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JButton btnNewAppli = new JButton("Ajouter");
	private JButton btnAjouterAppli = new JButton("Valider");
	private JTable tableAppli;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private applicationModelTableau modelAppli;
	public application appli = new application();
	private final JButton btnModifier = new JButton("Valider");
	private JTextField textFieldModifAppli;
	private JTextField textFieldAjoutAppli;
	private JCheckBox chckbxArchiverModif = new JCheckBox("");
	private JCheckBox chckbxArchiverAjt = new JCheckBox("");
	public JPanel panelAjouter = new JPanel();
	private final JButton btnAffModifierAppli = new JButton("Modifier");
	private int idAppliSelec;
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES UTILISATEUR
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	public boolean directionRempli=false;
	JPanel ongletUtilisateur = new JPanel();
	private JTable tableUtilisateur;
	private Vector<model.utilisateurArbre> vectUtilisateur = new Vector<model.utilisateurArbre>();
	private utilisateurArbre utilisateurActif = new utilisateurArbre();
	private utilisateurModelTableau modelUtilisateur;
	public utilisateur user = new utilisateur();
	public String utilisateurSelectionne;
	private final JLabel lblActifModif = new JLabel("Archiv\u00E9e");
	private final JLabel lblActifAjt = new JLabel("Archiv\u00E9e");
	private JTextField textFieldNomUtilisateur;
	private JTextField textFieldPrenomUtilisateur;
	private JTextField textFieldUlisUtilisateur;
	private JTextField textFieldAdresseMail;
	private JComboBox<String> comboBoxDirectionUtilisateur = new JComboBox<String>();
	private JCheckBox chckbxUtilisateurActif = new JCheckBox("Actif uniquement");
	private JCheckBox chckbxActifUtilisateur = new JCheckBox("Actif");
	private JTextField textFieldDgUtilisateur;
	private JTextField textFieldDirectionUtilisateur;
	private JButton btnModifierUtilisateur = new JButton("Valider");
	private String directionUtilisateurSelectionne;
	private String directionSelectionne;
	private model.directionArbre directionArbre= new model.directionArbre();
	private JButton btnAjouterUtilisateur = new JButton("User (+)");
	private JButton btnValiderAjoutUtilisateur = new JButton("Valider");
	tableUtilisateurRenderer rendererTableUtilisateur = new tableUtilisateurRenderer();
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES DIRECTION
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	JPanel ongletDirection = new JPanel();
	private JButton btnNewDirection = new JButton("Ajouter");
	private JButton btnAjouterDirection = new JButton("Valider");
	private JTable tableDirection;
	private Vector<model.directionArbre> vectDirectionArbre = new Vector<model.directionArbre>();
	private Vector<model.directionGeneraleArbre> vectDirectionGeneraleArbre = new Vector<model.directionGeneraleArbre>();
	private directionModelTableau modelDirection;
	public model.direction direction = new model.direction();
	private final JButton btnModifierDirection = new JButton("Valider");
	private JTextField textFieldModifDirection;
	private JTextField textFieldAjoutDirection;
	private JComboBox comboBoxDirectionGeneraleDirectionModif = new JComboBox();
	private JComboBox comboBoxDirectionGeneraleDirectionAjout = new JComboBox();
	private JCheckBox chckbxArchiverModifDirection = new JCheckBox("");
	private JCheckBox chckbxArchiverAjtDirection = new JCheckBox("");
	public JPanel panelAjouterDirection = new JPanel();
	private final JButton btnAffModifierDirection = new JButton("Modifier");
	private int idDirectionSelec;
	private final JLabel lblActifModifDirection = new JLabel("Archiv\u00E9e");
	private final JLabel lblActifAjtDirection = new JLabel("Archiv\u00E9e");
	private boolean ajout;
	private JScrollPane scrollPaneDirection = new JScrollPane();
	private Vector<direction> vectDirection = new Vector<model.direction>();
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES DIRECTION GENERALE
	 * 
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	JPanel ongletDG = new JPanel();
	private JPanel panelModifierDG = new JPanel();
	private JButton btnNewDG = new JButton("Ajouter");
	private JButton btnAjouterDG = new JButton("Valider");
	private JTable tableDG;
	private Vector<model.directionGeneraleArbre> vectDg = new Vector<model.directionGeneraleArbre>();
	private directionGeneraleModelTableau modelDG;
	public directionGenerale directionGenerale = new directionGenerale();
	private final JButton btnModifierDG = new JButton("Valider");
	private JTextField textFieldModifDG;
	private JTextField textFieldAjoutDG;
	private JCheckBox chckbxArchiverModifDG = new JCheckBox("");
	private JCheckBox chckbxArchiverAjtDG = new JCheckBox("");
	public JPanel panelAjouterDG = new JPanel();
	private final JButton btnAffModifierDG = new JButton("Modifier");
	private int idDGSelec;
	private final JLabel lblActifModifDG = new JLabel("Archiv\u00E9e");
	private final JLabel lblActifAjtDG = new JLabel("Archiv\u00E9e");
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES CELLULE
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	public JPanel panelUtilisateurCellule = new JPanel();
	private JTable tableCompoCellule;
	private Vector<model.compoCelluleArbre> vectCompoCellule = new Vector<model.compoCelluleArbre>();
	private compoCelluleModelTableau compoCelluleModelTableau;
	public 	model.compoCellule compoCellule = new model.compoCellule();
	private model.compoCelluleArbre compoCelluleArbre = new model.compoCelluleArbre();
	model.compoCelluleArbre compoCelluleArbreAjout = new model.compoCelluleArbre();
	private JButton btnUtilisateurModifiable = new JButton("Modifier");
	private JButton btnCelluleAjouter = new JButton("");
	private JButton btnCelluleSupprimer = new JButton("-");
	tableCompoCelluleRenderer rendererTableCompoCellule = new tableCompoCelluleRenderer();
	JComboBox comboCellule = new JComboBox();
	private boolean frameAjoutFenetre = false;
	public boolean isFrameAjoutFenetre() {
		return frameAjoutFenetre;
	}
	public void setFrameAjoutFenetre(boolean frameAjoutFenetre) {
		this.frameAjoutFenetre = frameAjoutFenetre;
	}

	private JPanel panelModifierUtilisateur = new JPanel();
	
	/**
	 * Create the panel.
	 */
	public Configuration(boolean ajout, int ongletSelectionne, int idDonneeSelectionnee) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
				/*if(fenetreAjout.isShowing() &&frameAjoutFenetre ==true){
	            	 
	             }
	             else{
	            	 tableCompoCellule.removeAll();
		             tableCompoCellule.repaint(); 
	             }	*/
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent arg0) {
			}
		});
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION FENETRE
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		setBackground(new Color(102,204,255));
		setLayout(null);
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION BARRE NAVIGATION
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		toolBar.setBounds(22, 0, 778, 49);
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

		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION PANEL
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */		

		pane.setBounds(22, 102, 746, 380);
		add(pane);
		//pane.setSelectedIndex(ongletSelectionne);
		
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL APPLICATION
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		

		

		ongletAppli.setLayout(null);
		
		vectAppli = controller.ControllerDBConfiguration.getApplicationArbre();
		modelAppli = new applicationModelTableau(vectAppli);
		tableAppli = new JTable(modelAppli);
		tableAppli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableAppli.getSelectedRow()!=-1){
					remplirApplication(tableAppli.getValueAt(tableAppli.getSelectedRow(),0).toString());
					tableCompoCellule.removeAll();
					tableCompoCellule.repaint();
					
				}
			}
		});
		tableAppli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAppli.setColumnSelectionAllowed(true);
		tableAppli.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tableAppli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableAppli.setForeground(Color.WHITE);
		tableAppli.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableAppli.setBackground(new Color(211, 211, 211));
		tableAppli.setBounds(10, 40, 130, 200);
		tableAppli.setAutoCreateRowSorter(true);
		tableAppli.getRowSorter().toggleSortOrder(0);
		tableAppli.setAutoCreateRowSorter(false);
		
		ongletAppli.setPreferredSize(new Dimension(300, 80));
		JScrollPane scrollPaneAppli = new JScrollPane(tableAppli);
		scrollPaneAppli.setVisible(true);
		scrollPaneAppli.setBounds(10, 40, 156, 219);
		ongletAppli.add(scrollPaneAppli);
		
		pane.addTab("Applications", ongletAppli);
		JPanel panelModifier = new JPanel();
		panelModifier.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifier.setBounds(302, 83, 200, 128);
		ongletAppli.add(panelModifier);
		panelModifier.setLayout(null);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setBounds(72, 11, 55, 17);
		lblModifier.setForeground(SystemColor.inactiveCaption);
		lblModifier.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelModifier.add(lblModifier);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.text);
		separator.setForeground(SystemColor.menu);
		separator.setBounds(40, 25, 118, 8);
		panelModifier.add(separator);
		
		textFieldModifAppli = new JTextField();
		textFieldModifAppli.setBounds(10, 63, 118, 20);
		panelModifier.add(textFieldModifAppli);
		textFieldModifAppli.setColumns(10);
		btnModifier.setBounds(56, 94, 89, 23);
		panelModifier.add(btnModifier);
		
		JLabel lblNomApplicationModif = new JLabel("Nom de l'application");
		lblNomApplicationModif.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationModif.setBounds(10, 44, 118, 14);
		panelModifier.add(lblNomApplicationModif);
		
		chckbxArchiverModif.setBounds(152, 60, 23, 23);
		panelModifier.add(chckbxArchiverModif);
		lblActifModif.setForeground(SystemColor.inactiveCaption);
		lblActifModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifModif.setBounds(137, 44, 53, 14);
		
		panelModifier.add(lblActifModif);
		
		
		panelAjouter.setLayout(null);
		panelAjouter.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAjouter.setBounds(302, 83, 200, 128);
		ongletAppli.add(panelAjouter);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.inactiveCaption);
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouter.setBounds(75, 11, 55, 17);
		panelAjouter.add(lblAjouter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(43, 28, 118, 8);
		panelAjouter.add(separator_1);
		
		textFieldAjoutAppli = new JTextField();
		textFieldAjoutAppli.setBounds(10, 63, 118, 20);
		
		panelAjouter.add(textFieldAjoutAppli);
		textFieldAjoutAppli.setColumns(10);
		
		
		btnAjouterAppli.setBounds(58, 94, 89, 23);
		panelAjouter.add(btnAjouterAppli);
		
		chckbxArchiverAjt.setBounds(156, 63, 23, 23);
		panelAjouter.add(chckbxArchiverAjt);
		
		JLabel lblNomApplicationAjt = new JLabel("Nom de l'application");
		lblNomApplicationAjt.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationAjt.setBounds(10, 47, 118, 14);
		panelAjouter.add(lblNomApplicationAjt);
		lblActifAjt.setForeground(SystemColor.inactiveCaption);
		lblActifAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifAjt.setBounds(138, 47, 53, 14);
		
		panelAjouter.add(lblActifAjt);
		
		
		btnNewAppli.setBounds(31, 274, 89, 23);
		ongletAppli.add(btnNewAppli);
		btnAffModifierAppli.setBounds(31, 274, 89, 23);
		
		ongletAppli.add(btnAffModifierAppli);
		
		if(ajout == false){
			panelAjouter.setVisible(false);
			panelModifier.setVisible(true);
			btnAffModifierAppli.setVisible(false);
			btnNewAppli.setVisible(true);
		}
		else
		{
			panelAjouter.setVisible(true);
			panelModifier.setVisible(false);
			btnAffModifierAppli.setVisible(true);
			btnNewAppli.setVisible(false);
		}
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL UTILISATEUR
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		ongletUtilisateur.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		ongletUtilisateur.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
			
			}
		});
		

		ongletUtilisateur.setLayout(null);

		vectUtilisateur = controller.ControllerDBConfiguration.getUtilisateurArbre();
		modelUtilisateur = new utilisateurModelTableau(vectUtilisateur);
		tableUtilisateur = new JTable(modelUtilisateur);
		tableUtilisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableUtilisateur.getSelectedRow()!=-1){
					utilisateurSelectionne=tableUtilisateur.getValueAt(tableUtilisateur.getSelectedRow(), 2).toString();
					remplirUtilisateur(tableUtilisateur.getValueAt(tableUtilisateur.getSelectedRow(),0).toString());
					remplirCompoCellule(textFieldUlisUtilisateur.getText());
					btnModifierUtilisateur.setVisible(false);
					btnValiderAjoutUtilisateur.setVisible(true);
				}
			}
		});
		tableUtilisateur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableUtilisateur.setColumnSelectionAllowed(true);
		tableUtilisateur.setToolTipText("S\u00E9lectionnez l'utilisateur d\u00E9sir\u00E9");
		tableUtilisateur.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableUtilisateur.setForeground(Color.WHITE);
		tableUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableUtilisateur.setBackground(new Color(211, 211, 211));
		tableUtilisateur.setBounds(7, 40, 95, 128);
		tableUtilisateur.getColumnModel().getColumn(0).setPreferredWidth(75);
		tableUtilisateur.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableUtilisateur.getColumnModel().getColumn(2).setPreferredWidth(25);
		tableUtilisateur.getColumnModel().getColumn(3).setPreferredWidth(190);
		tableUtilisateur.setAutoCreateRowSorter(true);
		tableUtilisateur.getRowSorter().toggleSortOrder(0);
		tableUtilisateur.setAutoCreateRowSorter(false);
		tableUtilisateur.setDefaultRenderer(Object.class, new tableUtilisateurRenderer());
		JScrollPane scrollPaneUtilisateur = new JScrollPane(tableUtilisateur);
		scrollPaneUtilisateur.setVisible(true);
		scrollPaneUtilisateur.setBounds(10, 11, 600, 105);
		
		ongletUtilisateur.setPreferredSize(new Dimension(300, 80));
		ongletUtilisateur.add(scrollPaneUtilisateur);
		pane.addTab("Utilisateurs", ongletUtilisateur);
		
		
		panelModifierUtilisateur.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelModifierUtilisateur.setBounds(10, 139, 600, 182);
		ongletUtilisateur.add(panelModifierUtilisateur);
		panelModifierUtilisateur.setLayout(null);
		
		textFieldPrenomUtilisateur = new JTextField();
		textFieldPrenomUtilisateur.setText("Pr\u00E9nom");
		textFieldPrenomUtilisateur.setBounds(338, 20, 173, 20);
		textFieldPrenomUtilisateur.setColumns(10);
		textFieldPrenomUtilisateur.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent e){
				if(btnValiderAjoutUtilisateur.isVisible()==true && comboBoxDirectionUtilisateur.getSelectedIndex()==0){
					textFieldPrenomUtilisateur.setText("");
				}
			}
		});
		panelModifierUtilisateur.add(textFieldPrenomUtilisateur);
		
		
		textFieldNomUtilisateur = new JTextField();
		textFieldNomUtilisateur.setText("Nom");
		textFieldNomUtilisateur.setBounds(146, 20, 173, 20);
		panelModifierUtilisateur.add(textFieldNomUtilisateur);
		textFieldNomUtilisateur.setColumns(10);
		textFieldNomUtilisateur.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent e){
				if(btnValiderAjoutUtilisateur.isVisible()==true && comboBoxDirectionUtilisateur.getSelectedIndex()==0){
					textFieldNomUtilisateur.setText("");
				}
			}
		});
		textFieldUlisUtilisateur = new JTextField();
		textFieldUlisUtilisateur.setText("n\u00B0Ulis");
		textFieldUlisUtilisateur.setColumns(10);
		textFieldUlisUtilisateur.setBounds(10, 20, 70, 20);
		panelModifierUtilisateur.add(textFieldUlisUtilisateur);
		
		textFieldAdresseMail = new JTextField();
		textFieldAdresseMail.setText("Adresse Mail");
		textFieldAdresseMail.setBounds(338, 51, 254, 20);
		panelModifierUtilisateur.add(textFieldAdresseMail);
		textFieldAdresseMail.setColumns(10);
		textFieldAdresseMail.addFocusListener(new FocusAdapter(){
			public void focusGained(FocusEvent e){
				if(btnValiderAjoutUtilisateur.isVisible()==true){
					textFieldAdresseMail.setText("");
				}
			}
		});

		chckbxActifUtilisateur.setBounds(518, 19, 76, 23);
		panelModifierUtilisateur.add(chckbxActifUtilisateur);
		
		textFieldDgUtilisateur = new JTextField();
		textFieldDgUtilisateur.setText("Direction g\u00E9n\u00E9rale");
		textFieldDgUtilisateur.setBounds(10, 51, 126, 20);
		panelModifierUtilisateur.add(textFieldDgUtilisateur);
		textFieldDgUtilisateur.setColumns(10);
		textFieldDgUtilisateur.setEnabled(false);		
		
		comboBoxDirectionUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBoxDirectionUtilisateur.setBounds(146, 51, 173, 20);
		panelModifierUtilisateur.add(comboBoxDirectionUtilisateur);
		textFieldDirectionUtilisateur=new JTextField();
		textFieldDirectionUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldDirectionUtilisateur.setEnabled(false);
		textFieldDirectionUtilisateur.setColumns(10);
		textFieldDirectionUtilisateur.setBounds(146, 51, 156, 20);
		
		panelModifierUtilisateur.add(textFieldDirectionUtilisateur);
		panelUtilisateurCellule.setBounds(10, 82, 501, 84);
		panelModifierUtilisateur.add(panelUtilisateurCellule);
		
		
		panelUtilisateurCellule.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelUtilisateurCellule.setLayout(null);
		JScrollPane scrollPaneCompoCellule = new JScrollPane(tableCompoCellule);
		scrollPaneCompoCellule.setBounds(0, 0, 501, 84);
		panelUtilisateurCellule.add(scrollPaneCompoCellule);
		
		tableCompoCellule = new JTable(compoCelluleModelTableau);
		tableCompoCellule.setDefaultRenderer(Object.class, new tableCompoCelluleRenderer());
		//scrollPaneCompoCellule.setColumnHeaderView(tableCompoCellule);
		tableCompoCellule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableCompoCellule.getSelectedRow()!=-1){
					
					remplirCompoCellule(tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(),0).toString());
					//System.out.println(tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(), 2).toString());
				}
			}
		});
		tableCompoCellule.setBounds(0, 0, 499, 84);
		tableCompoCellule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCompoCellule.setColumnSelectionAllowed(true);
		tableCompoCellule.setToolTipText("S\u00E9lectionnez la cellule d\u00E9sir\u00E9");
		tableCompoCellule.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableCompoCellule.setForeground(Color.WHITE);
		tableCompoCellule.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableCompoCellule.setBackground(new Color(211, 211, 211));
		tableCompoCellule.setAutoCreateRowSorter(true);
		tableCompoCellule.setAutoCreateRowSorter(false);
		tableCompoCellule.setDefaultRenderer(Object.class, new tableCompoCelluleRenderer());
		scrollPaneCompoCellule.setVisible(true);
		scrollPaneCompoCellule.add(tableCompoCellule);
		btnCelluleAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
		btnCelluleAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCelluleAjouter.setBounds(518, 82, 22, 23);
		panelModifierUtilisateur.add(btnCelluleAjouter);
		btnCelluleSupprimer.setIcon(new ImageIcon(Parametres.class.getResource("/icones/modifiable41.png")));
		
		
		btnCelluleSupprimer.setBounds(518, 111, 22, 23);
		panelModifierUtilisateur.add(btnCelluleSupprimer);
		btnCelluleAjouter.setVisible(true);
		
		maDirection itemListener = new maDirection();
		comboBoxDirectionUtilisateur.addItemListener(itemListener);	
		
		
		btnUtilisateurModifiable.setBounds(303, 332, 89, 23);
		btnUtilisateurModifiable.setVisible(true);
		ongletUtilisateur.add(btnUtilisateurModifiable);
		
		JCheckBox chckbxActiveOnly = new JCheckBox("Cellules Actives Uniquement");
		chckbxActiveOnly.setBounds(573, 328, 89, 23);
		chckbxActiveOnly.setVisible(false);
		ongletUtilisateur.add(chckbxActiveOnly);
		

		btnModifierUtilisateur.setBounds(478, 332, 89, 23);
		btnModifierUtilisateur.setVisible(false);
		ongletUtilisateur.add(btnModifierUtilisateur);
		

		chckbxUtilisateurActif.setBounds(493, 117, 142, 23);
		chckbxUtilisateurActif.setVisible(false);
		ongletUtilisateur.add(chckbxUtilisateurActif);
		
		btnAjouterUtilisateur.setBounds(132, 332, 89, 23);
		ongletUtilisateur.add(btnAjouterUtilisateur);
		btnAjouterUtilisateur.setIcon(null);
		

		btnValiderAjoutUtilisateur.setBounds(478, 332, 89, 23);
		ongletUtilisateur.add(btnValiderAjoutUtilisateur);
		lblErreur.setBounds(123, 496, 416, 14);
		add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);
		
		btnValiderAjoutUtilisateur.setVisible(true);
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL COMPOCELLULE DANS UTILISATEUR
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		vectCompoCellule = controller.ControllerDBConfiguration.getCompoCelluleVecteurArbre(textFieldUlisUtilisateur.getText());
		compoCelluleModelTableau = new compoCelluleModelTableau(vectCompoCellule);
		JComboBox comboCompoCellule = new JComboBox();
		Vector<model.compoCelluleArbre> vectCellule = new Vector<model.compoCelluleArbre>();
		vectCellule = controller.ControllerDBConfiguration.getCompoCelluleArbre();
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL DIRECTION GENERALE
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */

		ongletDG.setLayout(null);
		ongletDG.setVisible(true);
		vectDg = controller.ControllerDBConfiguration.getDirectionGeneraleArbre();
		modelDG = new directionGeneraleModelTableau(vectDg);
		tableDG = new JTable(modelDG);
		tableDG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableDG.getSelectedRow()!=-1){
					remplirDG(tableDG.getValueAt(tableDG.getSelectedRow(),0).toString());
					
				}
			}
		});
		tableDG.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDG.setColumnSelectionAllowed(true);
		tableDG.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tableDG.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableDG.setForeground(Color.WHITE);
		tableDG.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableDG.setBackground(new Color(211, 211, 211));
		tableDG.setBounds(10, 40, 130, 200);
		tableDG.setAutoCreateRowSorter(true);
		tableDG.getRowSorter().toggleSortOrder(0);
		tableDG.setAutoCreateRowSorter(false);
		
		ongletDG.setPreferredSize(new Dimension(599, 400));
		JScrollPane scrollPaneDG = new JScrollPane(tableDG);
		scrollPaneDG.setVisible(true);
		scrollPaneDG.setBounds(10, 40, 185, 219);
		ongletDG.add(scrollPaneDG);
		
		pane.addTab("Directions générales", ongletDG);
		panelModifierDG.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifierDG.setBounds(302, 83, 200, 128);
		ongletDG.add(panelModifierDG);
		panelModifierDG.setLayout(null);
		
		JLabel lblModifierDG = new JLabel("Modifier");
		lblModifierDG.setBounds(72, 11, 55, 17);
		lblModifierDG.setForeground(SystemColor.inactiveCaption);
		lblModifierDG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelModifierDG.add(lblModifierDG);
		
		JSeparator separatorDG = new JSeparator();
		separatorDG.setBackground(SystemColor.text);
		separatorDG.setForeground(SystemColor.menu);
		separatorDG.setBounds(40, 25, 118, 8);
		panelModifierDG.add(separatorDG);
		
		textFieldModifDG = new JTextField();
		textFieldModifDG.setBounds(10, 63, 118, 20);
		panelModifierDG.add(textFieldModifDG);
		textFieldModifDG.setColumns(10);
		btnModifierDG.setBounds(56, 94, 89, 23);
		panelModifierDG.add(btnModifierDG);
		
		JLabel lblNomApplicationModifDG = new JLabel("Nom de la DG");
		lblNomApplicationModifDG.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationModifDG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationModifDG.setBounds(10, 44, 89, 14);
		panelModifierDG.add(lblNomApplicationModifDG);
		
		chckbxArchiverModifDG.setBounds(152, 60, 23, 23);
		panelModifierDG.add(chckbxArchiverModifDG);
		lblActifModifDG.setForeground(SystemColor.inactiveCaption);
		lblActifModifDG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifModifDG.setBounds(137, 44, 53, 14);
		
		panelModifierDG.add(lblActifModifDG);
		
		
		panelAjouterDG.setLayout(null);
		panelAjouterDG.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAjouterDG.setBounds(302, 83, 200, 128);
		ongletDG.add(panelAjouterDG);
		
		JLabel lblAjouterDG = new JLabel("Ajouter");
		lblAjouterDG.setForeground(SystemColor.inactiveCaption);
		lblAjouterDG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouterDG.setBounds(75, 11, 55, 17);
		panelAjouterDG.add(lblAjouterDG);
		
		JSeparator separator1DG = new JSeparator();
		separator1DG.setForeground(Color.WHITE);
		separator1DG.setBackground(Color.WHITE);
		separator1DG.setBounds(43, 28, 118, 8);
		panelAjouterDG.add(separator1DG);
		
		textFieldAjoutDG = new JTextField();
		textFieldAjoutDG.setBounds(10, 63, 118, 20);
		
		panelAjouterDG.add(textFieldAjoutDG);
		textFieldAjoutDG.setColumns(10);
		
		
		btnAjouterDG.setBounds(58, 94, 89, 23);
		panelAjouterDG.add(btnAjouterDG);
		
		chckbxArchiverAjtDG.setBounds(156, 63, 23, 23);
		panelAjouterDG.add(chckbxArchiverAjtDG);
		
		JLabel lblNomApplicationAjtDG = new JLabel("Nom de la DG");
		lblNomApplicationAjtDG.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationAjtDG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationAjtDG.setBounds(10, 47, 118, 14);
		panelAjouterDG.add(lblNomApplicationAjtDG);
		lblActifAjtDG.setForeground(SystemColor.inactiveCaption);
		lblActifAjtDG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifAjtDG.setBounds(138, 47, 53, 14);
		
		panelAjouterDG.add(lblActifAjtDG);
		
		
		btnNewDG.setBounds(31, 274, 89, 23);
		ongletDG.add(btnNewDG);
		btnAffModifierDG.setBounds(31, 274, 89, 23);
		
		ongletDG.add(btnAffModifierDG);
		
		if(ajout == false){
			panelAjouterDG.setVisible(false);
			panelModifierDG.setVisible(true);
			btnAffModifierDG.setVisible(false);
			btnNewDG.setVisible(true);
		}
		else
		{
			panelAjouterDG.setVisible(true);
			panelModifierDG.setVisible(false);
			btnAffModifierDG.setVisible(true);
			btnNewDG.setVisible(false);
		}
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL DIRECTION
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */

		ongletDirection.setLayout(null);
		vectDirectionArbre = controller.ControllerDBConfiguration.getDirectionUtilisateurArbre();
		modelDirection = new directionModelTableau(vectDirectionArbre);
		tableDirection = new JTable(modelDirection);
		tableDirection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableDirection.getSelectedRow()!=-1){
					remplirDirection(tableDirection.getValueAt(tableDirection.getSelectedRow(),0).toString());
				}
			}
		});
		tableDirection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDirection.setColumnSelectionAllowed(true);
		tableDirection.setToolTipText("S\u00E9lectionnez la direction d\u00E9sir\u00E9e");
		tableDirection.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableDirection.setForeground(Color.WHITE);
		tableDirection.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableDirection.setBackground(new Color(211, 211, 211));
		tableDirection.setBounds(10, 40, 130, 200);
		tableDirection.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableDirection.getColumnModel().getColumn(1).setPreferredWidth(75);
		tableDirection.getColumnModel().getColumn(2).setPreferredWidth(20);
		tableDirection.setAutoCreateRowSorter(true);
		tableDirection.getRowSorter().toggleSortOrder(0);
		tableDirection.setAutoCreateRowSorter(false);
		
		ongletDirection.setPreferredSize(new Dimension(599, 400));
		JScrollPane scrollPaneDirection=new JScrollPane(tableDirection);
		scrollPaneDirection.setVisible(true);
		scrollPaneDirection.setBounds(10, 11, 565, 113);
		ongletDirection.add(scrollPaneDirection);
		
		pane.addTab("Directions", ongletDirection);
		JPanel panelModifierDirection = new JPanel();
		panelModifierDirection.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifierDirection.setBounds(224, 172, 242, 176);
		ongletDirection.add(panelModifierDirection);
		panelModifierDirection.setLayout(null);
		
		JLabel lblModifierDirection = new JLabel("Modifier");
		lblModifierDirection.setBounds(72, 11, 55, 17);
		lblModifierDirection.setForeground(SystemColor.inactiveCaption);
		lblModifierDirection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelModifierDirection.add(lblModifierDirection);
		
		JSeparator separatorDirection2 = new JSeparator();
		separatorDirection2.setBackground(SystemColor.text);
		separatorDirection2.setForeground(SystemColor.menu);
		separatorDirection2.setBounds(40, 25, 118, 8);
		panelModifierDirection.add(separatorDirection2);
		
		textFieldModifDirection = new JTextField();
		textFieldModifDirection.setBounds(10, 63, 165, 20);
		panelModifierDirection.add(textFieldModifDirection);
		textFieldModifDirection.setColumns(10);
		btnModifierDirection.setBounds(86, 129, 89, 23);
		panelModifierDirection.add(btnModifierDirection);
		
		JLabel lblNomDirectionModif = new JLabel("Nom de la Direction");
		lblNomDirectionModif.setForeground(SystemColor.inactiveCaption);
		lblNomDirectionModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomDirectionModif.setBounds(10, 44, 117, 14);
		panelModifierDirection.add(lblNomDirectionModif);
		
		chckbxArchiverModifDirection.setBounds(189, 63, 23, 23);
		panelModifierDirection.add(chckbxArchiverModifDirection);
		lblActifModifDirection.setForeground(SystemColor.inactiveCaption);
		lblActifModifDirection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifModifDirection.setBounds(179, 44, 53, 14);
		
		panelModifierDirection.add(lblActifModifDirection);
		

		comboBoxDirectionGeneraleDirectionModif.setBounds(10, 98, 165, 20);
		panelModifierDirection.add(comboBoxDirectionGeneraleDirectionModif);
		chckbxArchiverAjtDirection.setBounds(189, 63, 23, 23);
		panelModifierDirection.add(chckbxArchiverAjtDirection);
		lblActifAjtDirection.setBounds(179, 44, 53, 14);
		panelModifierDirection.add(lblActifAjtDirection);
		lblActifAjtDirection.setForeground(SystemColor.inactiveCaption);
		lblActifAjtDirection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		
		btnNewDirection.setBounds(486, 135, 89, 23);
		ongletDirection.add(btnNewDirection);
		btnAffModifierDirection.setBounds(486, 135, 89, 23);
		
		ongletDirection.add(btnAffModifierDirection);
		panelAjouterDirection.setBounds(224, 172, 242, 176);
		ongletDirection.add(panelAjouterDirection);
		
		
		panelAjouterDirection.setLayout(null);
		panelAjouterDirection.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblAjouterDirection = new JLabel("Ajouter");
		lblAjouterDirection.setForeground(SystemColor.inactiveCaption);
		lblAjouterDirection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouterDirection.setBounds(75, 11, 55, 17);
		panelAjouterDirection.add(lblAjouterDirection);
		
		JSeparator separatorDirection = new JSeparator();
		separatorDirection.setForeground(Color.WHITE);
		separatorDirection.setBackground(Color.WHITE);
		separatorDirection.setBounds(43, 28, 118, 8);
		panelAjouterDirection.add(separatorDirection);
		
		textFieldAjoutDirection = new JTextField();
		textFieldAjoutDirection.setBounds(10, 63, 167, 20);
		
		panelAjouterDirection.add(textFieldAjoutDirection);
		textFieldAjoutDirection.setColumns(10);
		
		
		btnAjouterDirection.setBounds(88, 125, 89, 23);
		panelAjouterDirection.add(btnAjouterDirection);
		
		JLabel lblNomDirectionAjt = new JLabel("Nom de la Direction");
		lblNomDirectionAjt.setForeground(SystemColor.inactiveCaption);
		lblNomDirectionAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomDirectionAjt.setBounds(10, 47, 118, 14);
		panelAjouterDirection.add(lblNomDirectionAjt);
		

		comboBoxDirectionGeneraleDirectionAjout.setBounds(11, 94, 166, 20);
		panelAjouterDirection.add(comboBoxDirectionGeneraleDirectionAjout);

		
		if(ajout == false){
			panelAjouterDirection.setVisible(false);
			panelModifierDirection.setVisible(true);
			btnAffModifierDirection.setVisible(false);
			btnNewDirection.setVisible(true);
		}
		else
		{
			panelAjouterDirection.setVisible(true);
			panelModifierDirection.setVisible(false);
			btnAffModifierDirection.setVisible(true);
			btnNewDirection.setVisible(false);
		}
		

		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT LISTENER BOUTON
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		btnNewAppli.addActionListener(list);
		btnAjouterAppli.addActionListener(list);
		btnAffModifierAppli.addActionListener(list);
		btnModifier.addActionListener(list);
		chckbxUtilisateurActif.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		comboBoxDirectionUtilisateur.addActionListener(list);
		btnModifierUtilisateur.addActionListener(list);
		btnAjouterUtilisateur.addActionListener(list);
		btnValiderAjoutUtilisateur.addActionListener(list);
		btnUtilisateurModifiable.addActionListener(list);
		btnCelluleAjouter.addActionListener(list);
		btnCelluleSupprimer.addActionListener(list);
		btnNewDG.addActionListener(list);
		btnAjouterDG.addActionListener(list);
		btnAffModifierDG.addActionListener(list);
		btnModifierDG.addActionListener(list);
		btnNewDirection.addActionListener(list);
		btnAffModifierDirection.addActionListener(list);
		btnModifierDirection.addActionListener(list);
		btnAjouterDirection.addActionListener(list);
		comboBoxDirectionGeneraleDirectionAjout.addActionListener(list);
		comboBoxDirectionGeneraleDirectionModif.addActionListener(list);
		remplirDirectionGeneraleAjoutDirection();
		remplirDirection();
		
		pane.setSelectedIndex(ongletSelectionne);
		
		if(idDonneeSelectionnee>=0 ){
			tableUtilisateur.changeSelection(idDonneeSelectionnee, 0, false, false);
			String numUtilisateurSelectionne;
			
			utilisateurSelectionne= tableUtilisateur.getValueAt(idDonneeSelectionnee, 2).toString();
			remplirUtilisateur(utilisateurSelectionne);
			remplirCompoCellule(utilisateurSelectionne);

		}
		else
		{
			tableUtilisateur.changeSelection(0, 0, false, false);
			String numUtilisateurSelectionne;
			
			utilisateurSelectionne= tableUtilisateur.getValueAt(idDonneeSelectionnee, 2).toString();
			remplirUtilisateur(utilisateurSelectionne);
			remplirCompoCellule(utilisateurSelectionne);
		}
	}
	private void remplirDirection(){
		comboBoxDirectionUtilisateur.removeAllItems();
		vectDirection = ControllerDBConfiguration.getDirectionUtilisateur();
		comboBoxDirectionUtilisateur.addItem("--Sélectionnez Direction--");
		for(int i=0; i<this.vectDirection.size();i++){
			comboBoxDirectionUtilisateur.addItem(vectDirection.elementAt(i).getNomDirection());
		}
		
	}
	private class maDirection implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			//remplirDirection();
		}

		
	}
	
	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON NAVIGATION
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */
			if(source == btnHome){
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.accueil();
			}
			
			if(source == btnSoftware){
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.fonctionnalite();
			}
			
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON APPLI
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */
			if(source == btnNewAppli){
				
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationAppliAjout(true,tableAppli.getRowCount()+1);
				
			}
			
			if(source == btnAffModifierAppli){
				
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationAppliModif(false,tableAppli.getSelectedRow());
				
			}
			
			if(source == btnModifier){
				
				if(textFieldModifAppli.getText()!= null && textFieldModifAppli.getText().length()>0 ){
					appli.setNomApplication(textFieldModifAppli.getText());
					appli.setIdApplication(idAppliSelec);
					
					if(chckbxArchiverModif.isSelected()){
						appli.setVisibiliteApplication("Archivée");
					}
					else
					{
						appli.setVisibiliteApplication("");
					}					
					controller.ControllerDBConfiguration.ModifApplication(appli);
					controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
					controller.gestionFenetreConfiguration.configurationAppliModif(false, tableAppli.getSelectedRow());	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldModifAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldModifAppli.requestFocus();
				}
			}
			
			if(source == btnAjouterAppli){
				if(textFieldAjoutAppli.getText()!= null && textFieldAjoutAppli.getText().length()>0 ){
					appli.setNomApplication(textFieldAjoutAppli.getText());
					appli.setIdApplication(idAppliSelec);
					
					if(chckbxArchiverAjt.isSelected()){
						appli.setVisibiliteApplication("Archivée");
					}
					else
					{
						appli.setVisibiliteApplication("");
					}					
					controller.addDataConfiguration.addApplication(appli);
					controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
					controller.gestionFenetreConfiguration.configurationAppliModif(true, tableAppli.getRowCount());	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldAjoutAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldAjoutAppli.requestFocus();
			
				}
				
			}
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON UTILISATEUR
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */
			if(source==chckbxUtilisateurActif){
				
				if(chckbxUtilisateurActif.isSelected()){
					vectUtilisateur=controller.ControllerDBConfiguration.getUtilisateurActifArbre();	
					
					}
					else
					{
					vectUtilisateur = controller.ControllerDBConfiguration.getUtilisateurArbre();
					
					}
				

			}
			
			if(source==comboBoxDirectionUtilisateur){
			
				textFieldDirectionUtilisateur.setText(comboBoxDirectionUtilisateur.getSelectedItem().toString());
				textFieldDgUtilisateur.setText("");
			}
			
			if(source==btnModifierUtilisateur){
				if(textFieldDirectionUtilisateur.getText()!=""){
					comboBoxDirectionUtilisateur.setSelectedItem(textFieldDirectionUtilisateur.getText());
				}
				directionUtilisateurSelectionne=comboBoxDirectionUtilisateur.getSelectedItem().toString();
				
				user.setUtilisateurDirection(model.getDataConfiguration.getDirectionArbre(directionUtilisateurSelectionne).getIdDirection());
				user.setMailUtilisateur(textFieldAdresseMail.getText());
				user.setIdUtilisateur(utilisateurActif.getIdUtilisateur());
				if(chckbxActifUtilisateur.isSelected()){
					user.setActifUtilisateur("");
				}
				else
				{
					user.setActifUtilisateur("Inactif");
				}
				
				if(textFieldUlisUtilisateur.getText()!= null && textFieldUlisUtilisateur.getText().length()>0 ){
					user.setNumUlis(textFieldUlisUtilisateur.getText());
					
					if(textFieldNomUtilisateur.getText()!= null && textFieldNomUtilisateur.getText().length()>0 ){
						user.setNomUtilisateur(textFieldNomUtilisateur.getText());
						
						if(textFieldPrenomUtilisateur.getText()!= null && textFieldPrenomUtilisateur.getText().length()>0 ){
							user.setPrenomUtilisateur(textFieldPrenomUtilisateur.getText());
							
							if(textFieldAdresseMail.getText()!= null && textFieldAdresseMail.getText().length()>0 ){
								user.setMailUtilisateur(textFieldAdresseMail.getText());
								model.majDataConfiguration.MajUtilisateur(user);
								controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
								controller.gestionFenetreConfiguration.configurationAppliModif(true, tableUtilisateur.getSelectedRow());	

								
							}
							else{
								lblErreur.setVisible(true);
								textFieldAdresseMail.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
							}
							
						}
						else{
							lblErreur.setVisible(true);
							textFieldPrenomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						}
					}
					else{
						lblErreur.setVisible(true);
						textFieldNomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					}
				}
				else{
					lblErreur.setVisible(true);
					textFieldUlisUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
				}
				
				
				
				
			}
			if(source==btnAjouterUtilisateur){
				textFieldNomUtilisateur.setText("Nom");
				textFieldUlisUtilisateur.requestFocus();
				textFieldPrenomUtilisateur.setText("Prenom");
				textFieldUlisUtilisateur.setText("");
				textFieldAdresseMail.setText("Adresse Mail");
				textFieldDgUtilisateur.setText("Direction générale");
				chckbxActifUtilisateur.setSelected(true);
				btnValiderAjoutUtilisateur.setVisible(true);
				btnModifierUtilisateur.setVisible(false);
				comboBoxDirectionUtilisateur.setEnabled(true);
				textFieldNomUtilisateur.setEditable(true);
				textFieldPrenomUtilisateur.setEditable(true);
				textFieldUlisUtilisateur.setEditable(true);
				textFieldAdresseMail.setEditable(true);
				textFieldDgUtilisateur.setEditable(true);
				textFieldDirectionUtilisateur.setEditable(true);
				chckbxActifUtilisateur.setEnabled(true);
				tableCompoCellule.setVisible(false);
			}
			if(source == btnValiderAjoutUtilisateur){
				if(chckbxActifUtilisateur.isSelected()){
					user.setActifUtilisateur("");
				}
				else
				{
					user.setActifUtilisateur("Inactif");
				}
				if(textFieldUlisUtilisateur.getText()!= null && textFieldUlisUtilisateur.getText().length()>0 && textFieldUlisUtilisateur.getText().length()<=6){
					user.setNumUlis(textFieldUlisUtilisateur.getText());
					textFieldUlisUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
					
					if(textFieldNomUtilisateur.getText()!= null && textFieldNomUtilisateur.getText().length()>0 ){
						user.setNomUtilisateur(textFieldNomUtilisateur.getText());
						textFieldNomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
						
						if(textFieldPrenomUtilisateur.getText()!= null && textFieldPrenomUtilisateur.getText().length()>0 ){
							user.setPrenomUtilisateur(textFieldPrenomUtilisateur.getText());
							textFieldPrenomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
							
							if(comboBoxDirectionUtilisateur.getSelectedItem()!="--Sélectionnez Direction--"){
								comboBoxDirectionUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
								directionUtilisateurSelectionne=comboBoxDirectionUtilisateur.getSelectedItem().toString();
								user.setUtilisateurDirection(model.getDataConfiguration.getDirectionArbre(directionUtilisateurSelectionne).getIdDirection());
								
								if(textFieldAdresseMail.getText()!= null && textFieldAdresseMail.getText().length()>0 ){
								user.setMailUtilisateur(textFieldAdresseMail.getText());
								
								controller.addDataConfiguration.addUtilisateur(user);
								controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
								controller.gestionFenetreConfiguration.configurationUtilisateur(true, tableUtilisateur.getRowCount()+1);	
								
								tableUtilisateur.removeAll();
								tableUtilisateur.repaint();
								}
								else
								{
									lblErreur.setVisible(true);
									comboBoxDirectionUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								}
									
							}
							else{
								lblErreur.setVisible(true);
								textFieldAdresseMail.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
							}
							
						}
						else{
							lblErreur.setVisible(true);
							textFieldPrenomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						}
					}
					else{
						lblErreur.setVisible(true);
						textFieldNomUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					}
				}
				else{
					lblErreur.setVisible(true);
					textFieldUlisUtilisateur.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
				}

				
			}
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON COMPO CELLULE
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */
			
			if(source==btnUtilisateurModifiable){
				btnUtilisateurModifiable.setVisible(false);
				comboBoxDirectionUtilisateur.setVisible(true);
				comboBoxDirectionUtilisateur.setEnabled(true);
				comboBoxDirectionUtilisateur.setSelectedItem(textFieldDirectionUtilisateur.getText());
				textFieldNomUtilisateur.setEditable(true);
				textFieldPrenomUtilisateur.setEditable(true);
				textFieldUlisUtilisateur.setEditable(true);
				textFieldAdresseMail.setEditable(true);
				textFieldDgUtilisateur.setEditable(true);
				
				chckbxActifUtilisateur.setEnabled(true);
				btnModifierUtilisateur.setVisible(true);
				btnValiderAjoutUtilisateur.setVisible(false);
				remplirCompoCellule(textFieldUlisUtilisateur.getText());
				textFieldDirectionUtilisateur.setEditable(true);
				textFieldDirectionUtilisateur.setEnabled(true);
				textFieldDirectionUtilisateur.setVisible(true);
				

				
			}
			
			if(source ==btnCelluleAjouter){ 
	             compoCelluleJFrame fenetreAjout = new compoCelluleJFrame(textFieldUlisUtilisateur.getText(),tableCompoCellule, tableUtilisateur.getSelectedRow());
	             Configuration.this.fenetreAjout=fenetreAjout;
	             fenetreAjout.show();
	             frameAjoutFenetre=true;
	             if(fenetreAjout.isShowing() &&frameAjoutFenetre ==true){
	            	 
	             }
	             else{
	            	 tableCompoCellule.removeAll();
		             tableCompoCellule.repaint(); 
	             }
	             
	             
			}
			
			if(source == btnCelluleSupprimer){
				String nomCellule= tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(), 0).toString();
				String debut= tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(), 1).toString();
				String fin=null;
				String tableauDateFin = null;
				if((tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(), 2))==null){
					fin="31/12/2099";
				}
				else{
				fin= tableCompoCellule.getValueAt(tableCompoCellule.getSelectedRow(), 2).toString();
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dateDebut = null;
				try {
					dateDebut = sdf.parse(debut);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				Date dateFin=null;
				
				try {
					dateFin=sdf.parse(fin);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
				
				
				compoModifJFrame fenetreModif = new compoModifJFrame(textFieldUlisUtilisateur.getText(), nomCellule,dateDebut,dateFin);
				fenetreModif.show();
			}
			/* 
			 * ---------------------------------------------------------------------------------------------------
			 * 									DEBUT BOUTON DIRECTION GENERALE
			 * ---------------------------------------------------------------------------------------------------
			 * 
			 */		
		
		if(source == btnNewDG){
			
			controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
			controller.gestionFenetreConfiguration.configurationDGAjout(true, 0);

			
		}
		
		if(source == btnAffModifierDG){
			
			controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
			controller.gestionFenetreConfiguration.configurationDGModif(false, tableDG.getSelectedRow());
			
		}
		
		if(source == btnModifierDG){
			
			if(textFieldModifDG.getText()!= null && textFieldModifDG.getText().length()>0 ){
				directionGenerale.setNomDirection(textFieldModifDG.getText());
				directionGenerale.setIdDirection(idDGSelec);
				
				if(chckbxArchiverModifDG.isSelected()){
					directionGenerale.setVisibiliteDG("Archivée");
				}
				else
				{
					directionGenerale.setVisibiliteDG("");
				}					
				controller.ControllerDBConfiguration.ModifDg(directionGenerale);
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationDGModif(false, tableDG.getSelectedRow());
				pane.setSelectedIndex(1);
				
			}
			else
			{

				lblErreur.setVisible(true);
				textFieldModifDG.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
				textFieldModifDG.requestFocus();
			}
		}
		
		if(source == btnAjouterDG){
			if(textFieldAjoutDG.getText()!= null && textFieldAjoutDG.getText().length()>0 ){
				directionGenerale.setNomDirectionGenerale(textFieldAjoutDG.getText());
				directionGenerale.setIdDirectionGenerale(idDGSelec);
				
				if(chckbxArchiverAjtDG.isSelected()){
					directionGenerale.setVisibiliteDG("Archivée");
				}
				else
				{
					directionGenerale.setVisibiliteDG("");
				}					
				controller.addDataConfiguration.addDirectionGenerale(directionGenerale);
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationDGModif(true, tableDG.getSelectedRowCount()+1);	
			}
			else
			{

				lblErreur.setVisible(true);
				textFieldAjoutDG.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
				textFieldAjoutDG.requestFocus();
		
			}
			
		}
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT BOUTON DIRECTION 
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */	
		if(source == btnNewDirection){
			
			controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
			controller.gestionFenetreConfiguration.configurationDirectionAjout(true,3);
			
		}
		
		if(source == btnAffModifierDirection){
			
			controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
			controller.gestionFenetreConfiguration.configurationDirectionModif(false,3);
			
		}
		
		if(source == btnModifierDirection){
			
			if(textFieldModifDirection.getText()!= null && textFieldModifDirection.getText().length()>0 ){
				direction.setNomDirection(textFieldModifDirection.getText());
				direction.setIdDirection(idDirectionSelec);
				System.out.println("id"+idDirectionSelec);
				if(chckbxArchiverModifDirection.isSelected()){
					direction.setVisibiliteDirection("Archivée");
				}
				else
				{
					direction.setVisibiliteDirection("");
				}	
				direction.setIdDG(comboBoxDirectionGeneraleDirectionModif.getSelectedIndex()+1);
				direction.setNomDG(comboBoxDirectionGeneraleDirectionModif.getSelectedItem().toString());
				controller.ControllerDBConfiguration.ModifDirection(direction);
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationDirectionModif(false,3);	
			}
			else
			{

				lblErreur.setVisible(true);
				textFieldModifDirection.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
				textFieldModifDirection.requestFocus();
			}
		}
		
		if(source == btnAjouterDirection){
			if(textFieldAjoutDirection.getText()!= null && textFieldAjoutDirection.getText().length()>0 ){
				direction.setNomDirection(textFieldAjoutDirection.getText());
				direction.setIdDirection(idDirectionSelec);
				
				if(chckbxArchiverAjtDirection.isSelected()){
					direction.setVisibiliteDirection("Archivée");
				}
				else
				{
					direction.setVisibiliteDirection("");
				}		
				direction.setIdDG(comboBoxDirectionGeneraleDirectionAjout.getSelectedIndex());
				controller.addDataConfiguration.addDirection(direction);
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationDirectionModif(true,3);	
			}
			else
			{

				lblErreur.setVisible(true);
				textFieldAjoutDirection.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
				textFieldAjoutDirection.requestFocus();
		
			}
			
		}
		
	}
}

private void remplirApplication(String application){
		
		applicationArbre applicationArbre = ControllerDBConfiguration.getApplicationArbre(application);
		textFieldModifAppli.setText(applicationArbre.getNomApplication());
		
		if(applicationArbre.getVisibiliteApplication().equals("Archivée")){
			chckbxArchiverModif.setSelected(true);
			
		}
		else
		{

			chckbxArchiverModif.setSelected(false);
			
		}
		
		idAppliSelec=applicationArbre.getIdApplication();
		
	}

private void remplirUtilisateur(String numUtilisateur){
	numUtilisateur=utilisateurSelectionne;
	utilisateurArbre utilisateurArbre = ControllerDBConfiguration.getUtilisateurArbre(numUtilisateur);
	textFieldNomUtilisateur.setText(utilisateurArbre.getNomUtilisateur());
	textFieldPrenomUtilisateur.setText(utilisateurArbre.getPrenomUtilisateur());
	textFieldUlisUtilisateur.setText(utilisateurArbre.getNumUlis());
	textFieldAdresseMail.setText(utilisateurArbre.getMailUtilisateur());
	textFieldDgUtilisateur.setText(utilisateurArbre.getUtilisateurDG());
	if(utilisateurArbre.getUtilisateurActif().equals("Inactif")){
		chckbxActifUtilisateur.setSelected(false);
	}
	else{
		chckbxActifUtilisateur.setSelected(true);
	}

	textFieldDirectionUtilisateur.setText(utilisateurArbre.getUtilisateurDirection());
	
	textFieldNomUtilisateur.setEditable(false);
	textFieldPrenomUtilisateur.setEditable(false);
	textFieldUlisUtilisateur.setEditable(false);
	textFieldAdresseMail.setEditable(false);
	textFieldDgUtilisateur.setEditable(false);
	textFieldDirectionUtilisateur.setEditable(false);
	chckbxActifUtilisateur.setEnabled(false);
	comboBoxDirectionUtilisateur.setEnabled(false);
 }
private void remplirCompoCellule(String numUtilisateur){
	numUtilisateur=textFieldUlisUtilisateur.getText();
	model.compoCelluleArbre compoCelluleArbre = ControllerDBConfiguration.getCompoCelluleArbre(numUtilisateur);
	vectCompoCellule = controller.ControllerDBConfiguration.getCompoCelluleVecteurArbre(numUtilisateur);
	panelUtilisateurCellule.removeAll();

	compoCelluleModelTableau = new compoCelluleModelTableau(vectCompoCellule);
	tableCompoCellule = new JTable(compoCelluleModelTableau);
	tableCompoCellule.setDefaultRenderer(Object.class, new tableCompoCelluleRenderer());
	tableCompoCellule.setBounds(0, 0, 499, 82);
	tableCompoCellule.getColumnModel().getColumn(0).setPreferredWidth(55);
	tableCompoCellule.getColumnModel().getColumn(1).setPreferredWidth(55);
	tableCompoCellule.getColumnModel().getColumn(2).setPreferredWidth(55);
	tableCompoCellule.setAutoCreateRowSorter(true);
	tableCompoCellule.getRowSorter().toggleSortOrder(0);
	
	JScrollPane scrollPaneCompoCellule = new JScrollPane(tableCompoCellule);
	scrollPaneCompoCellule.setBounds(0, 0, 501, 84);
	scrollPaneCompoCellule.setVisible(true);
	
	panelUtilisateurCellule.setLayout(null);
	panelUtilisateurCellule.add(scrollPaneCompoCellule);
	panelUtilisateurCellule.repaint();

}

private void remplirDirection(String direction){
	remplirDirectionGeneraleModifDirection();
	model.directionArbre directionsArbre = ControllerDBConfiguration.getDirectionUtilisateurArbre(direction);
	textFieldModifDirection.setText(directionsArbre.getNomDirection());
	System.out.println(directionsArbre.getIdDG());
	comboBoxDirectionGeneraleDirectionModif.setSelectedIndex(directionsArbre.getIdDG()-1);
	if(directionsArbre.getVisibiliteDirection().equals("Archivée")){
		chckbxArchiverModifDirection.setSelected(true);
		
	}
	else
	{

		chckbxArchiverModifDirection.setSelected(false);
		
	}
	
	idDirectionSelec=directionsArbre.getIdDirection();
	
}

private void remplirDirectionGeneraleAjoutDirection(){
comboBoxDirectionGeneraleDirectionAjout.removeAllItems();
vectDirectionGeneraleArbre = ControllerDBConfiguration.getDirectionGeneraleArbre();
comboBoxDirectionGeneraleDirectionAjout.addItem("--Sélectionnez Direction--");
for(int i=0; i<this.vectDirectionGeneraleArbre.size();i++){
	comboBoxDirectionGeneraleDirectionAjout.addItem(vectDirectionGeneraleArbre.elementAt(i).getNomDirectionGenerale());
}
}	

private void remplirDirectionGeneraleModifDirection(){
comboBoxDirectionGeneraleDirectionModif.removeAllItems();
vectDirectionGeneraleArbre = ControllerDBConfiguration.getDirectionGeneraleArbre();
for(int i=0; i<this.vectDirectionGeneraleArbre.size();i++){
	comboBoxDirectionGeneraleDirectionModif.addItem(vectDirectionGeneraleArbre.elementAt(i).getNomDirectionGenerale());
}
}	

private void addLigneCompoCellule(String numUtilisateur){
	numUtilisateur=textFieldUlisUtilisateur.getText();
	model.compoCelluleArbre compoCelluleArbre = ControllerDBConfiguration.getCompoCelluleArbre(numUtilisateur);
	Vector<model.compoCelluleArbre> vectCellule = new Vector<model.compoCelluleArbre>();
	vectCellule = controller.ControllerDBConfiguration.getCompoCelluleArbre();
	vectCompoCellule = controller.ControllerDBConfiguration.getCompoCelluleVecteurArbre(numUtilisateur);
	vectCompoCellule.add(compoCelluleArbre);
	panelUtilisateurCellule.removeAll();
	panelUtilisateurCellule.repaint();
	compoCelluleModelTableau = new compoCelluleModelTableau(vectCompoCellule);
	tableCompoCellule = new JTable(compoCelluleModelTableau);
	tableCompoCellule.setDefaultRenderer(Object.class, new tableCompoCelluleRenderer());
	tableCompoCellule.setBounds(0, 0, 499, 82);
	tableCompoCellule.getColumnModel().getColumn(0).setPreferredWidth(55);
	tableCompoCellule.getColumnModel().getColumn(1).setPreferredWidth(55);
	tableCompoCellule.getColumnModel().getColumn(2).setPreferredWidth(55);
	tableCompoCellule.setAutoCreateRowSorter(true);
	tableCompoCellule.getRowSorter().toggleSortOrder(0);
	comboCellule.addItem("--Sélectionnez Direction--");
	for(int i=0; i<vectCellule.size();i++){
		comboCellule.addItem(vectCellule.elementAt(i).getNomCellule());
	}
	tableCompoCellule.getColumn("Cellule").setCellEditor(new DefaultCellEditor(comboCellule));
	DefaultTableCellRenderer dcr = new DefaultTableCellRenderer();
	tableCompoCellule.getColumn("Cellule").setCellRenderer(dcr);
	JScrollPane scrollPaneCompoCellule = new JScrollPane(tableCompoCellule);
	scrollPaneCompoCellule.setBounds(0, 0, 501, 84);
	scrollPaneCompoCellule.setVisible(true);
	
	panelUtilisateurCellule.setLayout(null);
	panelUtilisateurCellule.add(scrollPaneCompoCellule);

	

}

public void getVectDirection(){
	comboBoxDirectionUtilisateur.removeAllItems();
	vectDirection=controller.ControllerDBConfiguration.getDirectionUtilisateur();
	for (int i=0; i<this.vectDirection.size();i++){
		comboBoxDirectionUtilisateur.addItem(vectDirection.elementAt(i).getNomDirection());
		}

	}

public void refreshCompoCelluleTable() {

	panelUtilisateurCellule.removeAll();
	panelUtilisateurCellule.repaint();
	}

private void remplirDG(String directionGenerale	){
	
	directionGeneraleArbre directionGeneraleArbre = ControllerDBConfiguration.getDirectionGeneraleArbre(directionGenerale);
	textFieldModifDG.setText(directionGeneraleArbre.getNomDirectionGenerale());
	
	if(directionGeneraleArbre.getVisibiliteDg().equals("Archivée")){
		chckbxArchiverModifDG.setSelected(true);
		
	}
	else
	{

		chckbxArchiverModifDG.setSelected(false);
		
	}
	
	idDGSelec=directionGeneraleArbre.getIdDirectionGenerale();
	

}

	}


